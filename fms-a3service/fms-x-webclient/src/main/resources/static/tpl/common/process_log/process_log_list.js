app.controller('process_log_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {
    function getData() {
        $http.get("workflow_log/findWorkflowLogs?wfLogType=" + $scope.$parent.wfLogType + "&applyNo=" + $scope.$parent.wfLogNo + "&contNo=" + $scope.$parent.wfLogSubNo ).success(function(data){

            /*//参数配置
            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'process_log_table',
                //table的列
                dataTableColumn: [
                    {title:'提交人',data:'user',width:'15%'},
                    {title:'当前流程状态',data:'status',width:'15%', render: function (data, type, row, meta) {  return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data);}},
                    {title:'备注内容',data:'remark1',width:'15%'},
                    // {title:'操作',data:'actWidgetId',width:'15%'},
                    {title:'操作分类',data:'actType',width:'15%' ,render: function (data, type, row, meta) {  return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.actType,data);}},
                    {title:'操作日期',data:'createTime',width:'15%'},
                ],
                dataTableData: data.data
            };

            CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);*/
            $scope.logData = data.data;
        })
    }

    getData();

    $scope.$on('logJobToSon',function (e,data) {
        getData();
    });


}]);