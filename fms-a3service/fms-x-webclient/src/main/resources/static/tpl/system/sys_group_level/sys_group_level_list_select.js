/**
 * Created by wangxue on 2018/3/12.
 */

app.controller('sys_group_level_list_select_controller', ['$scope', '$http', '$modal','$compile','$modalInstance', function ($scope, $http, $modal,$compile,$modalInstance) {


    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_group_level/findSysGroupLevelsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_group_level_select_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('groupLevId'),
            defaultDetail('groupLev','getRowData','层级代码','20%',$compile,$scope,'groupLevId'),
            {title:'层级名称',data:'groupLevName',width:'20%'},
            {title: '启用标识', data: 'enableFlag', width: '20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,data);
                }
            }
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    };

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.groupLev = $scope.groupLev;
        params.groupLevName = $scope.groupLevName;
        return params;
    }
    // 初始化
    $scope.init = function(){
        //创建dataTable 封装了datatable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };

    // 查询
    $scope.searchSysGroupLevel = function(){
        $scope.dataTable.fnDraw(true);
    };

    // 重置
    $scope.resetSysGroupLevel = function(){
        $scope.groupLev = "";
        $scope.groupLevName = "";
        $scope.dataTable.fnDraw(true);//刷新
    };

    //点击一条开户行直接获取
    $scope.getRowData = function (groupLevId) {
        var data = $scope.dataTable.getRow(groupLevId,'groupLevId');
        $modalInstance.close(data);
    }

    // 确认
    $scope.confirm = function(status){
        if (status != 'none') {
            var rowsIds =  $scope.dataTable.getRowsIds('groupLevId');//主键
            if(rowsIds.length < 1)
                modalAlert($modal,'请您选择用户组信息！');
            else if(rowsIds.length > 1)
                modalAlert($modal,'只能同时选中一条数据！');
            else{
                var data = $scope.dataTable.getRow(rowsIds[0],'groupLevId');
                if(data == null) {
                    modalAlert($modal,'请选择用户组层级');
                } else {
                    $modalInstance.close(data);
                }
            }
        } else {
            var data = {groupLev:'',groupLevName:'无用户组层级'};
            $modalInstance.close(data);
        }
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close(null);
    };
    // 导出excel
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.system,CommonServiceType.excelTypes.two,
            'sys_group_level/findSysGroupLevelsByPage',dataTableParams($scope));
    };

}]);