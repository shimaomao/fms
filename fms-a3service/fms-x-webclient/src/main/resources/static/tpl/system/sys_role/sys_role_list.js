/**
 * Created by qiaohao on 2018/1/9.
 */
app.controller('sys_role_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location','$timeout',function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {
// 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加角色信息成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑角色信息成功',toaster);
        }
    }, 100);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_role/findSysRolesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_role_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('roleId'),

            defaultDetail('role','detailSysRole','角色代码','20%',$compile,$scope,'roleId'),
            {title:'角色名称',data:'roleName',width:'20%'},
            {title:'启用标识',data:'enableFlag',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.common_status,data);
                }
            },
            {title:'排序',data:'orderNo',width:'20%'},
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
     function dataTableParams($scope){
        params = {};
        params.roleName = $scope.roleName;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchSysRole = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetSysRole = function(){
        $scope.roleName="";
        $scope.dataTable.fnDraw(true);//框架内部方法
    }


    $scope.saveSysRole = function(){

        $location.path('/app/system_sys_role_save');

    }



    $scope.deleteSysRole = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('roleId');//主键
        if(rowsIds.length < 1){
            modalAlert($modal,'请您选择需要删除的数据！');
        }else{

            modalConfirm($modal,function(){
                $http.delete('sys_role/deleteSysRolesByIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除角色信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？');

        }
    }


    $scope.modifySysRole = function(){

        var rowsIds =  $scope.dataTable.getRowsIds('roleId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            $location.path('/app/system_sys_role_modify').search({'roleId':rowsIds[0]});

        }

    }


    $scope.detailSysRole = function(sysRoleId){
        $location.path('/app/system_sys_role_detail').search({'roleId':sysRoleId});

    }
   //导出角色表
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.system,CommonServiceType.excelTypes.one,
            'sys_role/findSysRolesByPage',dataTableParams($scope));
    }


}])
;