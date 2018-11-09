/**
 * Created by wangxue on 2018/3/10.
 */

app.controller('sys_widget_list_select_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$modalInstance', function ($scope, $http, $modal, toaster,$compile,$modalInstance) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_widget/findSysWidgetsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_widget_select_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('widgetUuid'),
            {title:'项目ID',data:'widgetId',width:'20%'},
            {title:'项目名称',data:'widgetName',width:'20%'},
            {title:'提示信息',data:'memo',width:'20%'}
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    };

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.widgetTypw = '1';
        params.widgetId = $scope.widgetId;
        params.widgetName = $scope.widgetName;
        return params;
    }

    $scope.init = function(){
        //创建dataTable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };

    $scope.searchSysWidgetSelect = function(){
        $scope.dataTable.fnDraw(true);
    };

    $scope.resetSysWidgetSelect = function(){
        $scope.widgetId = "";
        $scope.widgetName = "";
        $scope.dataTable.fnDraw(true);//刷新
    };
    
    // 确认
    $scope.confirm = function () {
        var rowsIds =  $scope.dataTable.getRowsIds('widgetUuid');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要添加的项目');
        } else if (rowsIds.length > 1) {
            modalAlert($modal,'只能选择一条数据');
        } else {
            var data =  $scope.dataTable.getRow(rowsIds[0],'widgetUuid');
            $modalInstance.close(data);
        }
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);