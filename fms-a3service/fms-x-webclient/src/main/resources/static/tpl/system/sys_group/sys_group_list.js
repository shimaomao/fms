/**
 * Created by wangxue on 2018-03-10.
 */
app.controller('sys_group_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {

    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加用户组信息成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑用户组信息成功',toaster);
        }
    }, 100);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_group/findSysGroupVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_group_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('groupId'),
            defaultDetail('groupCode','detailSysGroup','用户组代码','20%',$compile,$scope, 'groupId'),
            {title:'用户组全称',data:'groupName',width:'20%'},
            {title:'用户组简称',data:'groupNameShort',width:'20%'},
            {title:'用户组英文简称',data:'groupNameEng',width:'20%'},
            {title:'层级代码',data:'groupLev',width:'20%'},
            {title:'层级名称',data:'groupLevName',width:'20%'},
            {title:'统一社会信用代码',data:'socialCertifNo',width:'20%'},
            {title:'负责人',data:'head',width:'20%'},
            {title:'区域',data:'groupDistrict',width:'20%'},
            {title:'注册地址',data:'registeredAddr',width:'20%'},
            {title:'财务辅助核算代码',data:'finassGroupCode',width:'20%'},
            {title:'启用标志',data:'enableFlag',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,data);
                }
            },
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    };

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.parentGroup = $scope.parentGroup;
        params.groupCode = $scope.groupCode;
        params.groupName = $scope.groupName;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    $scope.orgParent = {};
    // 创建用户组树
    function initSysGroupTree() {
        $http.get('sys_group/findSysGroupByTree?parentType=1').success(function(data){
            var tree = data.data;
            $('#sys_group_tree').treeview({
                data: tree,
                icon:"glyphicon glyphicon-stop",
                emptyIcon: 'glyphicon glyphicon-minus',
                onNodeSelected: function (event, data) {
                    $scope.parentGroup = data.id;
                    $scope.orgParent.id = data.id;
                    $scope.orgParent.text = data.text;
                    $scope.dataTable.fnDraw(true);
                }
            });
        });
    }

    // 用户组树信息初始化
    initSysGroupTree();

    // 查询
    $scope.searchSysGroup = function(){
        $scope.parentGroup = '';
        $scope.dataTable.fnDraw(true);
    };
    // 重置
    $scope.resetSysGroup = function(){
        $scope.parentGroup = '';
        $scope.groupCode = "";
        $scope.groupName = "";
        $scope.dataTable.fnDraw(true);//刷新
    };

    // 添加
    $scope.saveSysGroup = function(){
        $location.path('/app/system_sys_group_save').search({'parentGroup': $scope.orgParent.id, 'parentGroupName': $scope.orgParent.text});
    };

    // 修改
    $scope.modifySysGroup = function(groupId){
        var rowsIds =  $scope.dataTable.getRowsIds('groupId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            $location.path('/app/system_sys_group_modify').search({'groupId': rowsIds[0]});
        }
    };

    // 查看详情
    $scope.detailSysGroup = function(groupId){
        $location.path('/app/system_sys_group_detail').search({'groupId': groupId});
    };

    // 删除
    $scope.deleteSysGroup = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('groupId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{
            modalConfirm($modal,function(){
                $http.delete('sys_group/deleteSysGroupsByGroupIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除用户组信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                        // 刷新树
                        initSysGroupTree();
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')
        }
    }

    // 导出excel
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.system,CommonServiceType.excelTypes.one,
            'sys_group/findSysGroupVosByPage',dataTableParams($scope));
    };

}])
;