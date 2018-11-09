/**
 * Created by wangxue on 2018-03-08.
 */
app.controller('sys_group_level_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {

    // 启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);

    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加用户组层级成功',toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑用户组层级成功',toaster);
        }
    }, 100);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_group_level/findSysGroupLevelsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_group_level_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('groupLevId'),
            defaultDetail('groupLev','detailSysGroupLevel','层级代码','20%',$compile,$scope,'groupLevId'),
            {title:'层级名称',data:'groupLevName',width:'20%'},
            {title: '启用标识', data: 'enableFlag', width: '20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,data);
                }
            },
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.groupLev = $scope.groupLev;
        params.groupLevName = $scope.groupLevName;
        params.enableFlag = $scope.enableFlag;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchSysGroupLevel = function(){
        $scope.dataTable.fnDraw(true);
    };

    $scope.resetSysGroupLevel = function(){
        $scope.groupLev = "";
        $scope.groupLevName = "";
        $scope.enableFlag = "";
        $scope.dataTable.fnDraw(true);//刷新
    };

    // 添加
    $scope.saveSysGroupLevel = function(){
        $location.path('/app/system_sys_group_level_save');
    };

    // 修改
    $scope.modifySysGroupLevel = function(sysGroupLevelId){
        var rowsIds =  $scope.dataTable.getRowsIds('groupLevId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/system_sys_group_level_modify').search({'groupLevId': rowsIds[0]});
        }

    };

    // 详情
    $scope.detailSysGroupLevel = function(sysGroupLevelId){
        $location.path('/app/system_sys_group_level_detail').search({'groupLevId': sysGroupLevelId});
    };

    // 删除
    $scope.deleteSysGroupLevel = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('groupLevId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('sys_group_level/deleteSysGroupLevelsByIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除用户组层级成功', toaster);
                        $scope.dataTable.fnDraw(true);
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
            'sys_group_level/findSysGroupLevelsByPage',dataTableParams($scope));
    };

}])
;