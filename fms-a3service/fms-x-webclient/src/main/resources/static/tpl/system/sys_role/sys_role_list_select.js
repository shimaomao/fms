/**
 * Created by ningyangyang on 2018/3/21.
 */

app.controller('sys_role_list_select_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$modalInstance' ,function ($scope, $http, $modal, toaster,$compile,$modalInstance) {

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
            defaultDetail('role','selectSysRole','角色代码','20%',$compile,$scope,'roleId'),
            {title:'角色名称',data:'roleName',width:'20%'},
            {title:'启用标识',data:'enableFlag',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,data);
                }
            },
            {title:'排序',data:'orderNo',width:'20%'},
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

    // //创建dataTable
    // $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);

    $scope.init = function(){
        //创建dataTable 封装了datatable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    }

    $scope.searchSysRole = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetSysRole = function(){
        $scope.roleName="";
        $scope.dataTable.fnDraw(true);//框架内部方法
    }

    //确认角色
    $scope.confirm = function(status){
        if(status != 'none') {
            var data = $scope.dataTable.getRows('roleId');
            if(data == null)
                modalAlert($modal,'请选择角色');
            else
                $modalInstance.close(data);
        }
    }
    //确认一条角色
    $scope.selectSysRole = function (roleId) {
        var data = $scope.dataTable.getRow(roleId,'roleId');
        var datas = [];
        datas.push(data)
        $modalInstance.close(datas);
    }
//导出角色表
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.system,CommonServiceType.excelTypes.two,
            'sys_role/findSysRolesByPage',dataTableParams($scope));
    }
    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close(null);
    };


}])
;