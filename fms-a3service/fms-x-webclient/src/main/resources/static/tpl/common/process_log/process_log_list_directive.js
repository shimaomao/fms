app.directive('processLogListDirective',function(){

    return {
        restrict: 'E',
        templateUrl: 'tpl/common/process_log/process_log_list_directive.html',
        replace : true,
        transclude : true,
        scope:{
            wfLogType : '=wfLogType',
            wfLogNo : '=wfLogNo',
            wfLogSubNo: '=wfLogSubNo'
        },
        controller: function($scope, $http, $modal, toaster,$compile,$location,$timeout){
            if(CommonObjectUtils.isNotExist($scope.wfLogType)){
                $scope.wfLogType = null;
            }
            if(CommonObjectUtils.isNotExist($scope.wfLogNo)){
                $scope.wfLogNo = null;
            }
            if(CommonObjectUtils.isNotExist($scope.wfLogSubNo)){
                $scope.wfLogSubNo = null;
            }
            //$scope.dataTableId = 'process_log_table_' + $scope.$id;

            $scope.initData = function(){
                $http.get("workflow_log/findWorkflowLogs?wfLogType=" + $scope.wfLogType + "&applyNo=" + $scope.wfLogNo + "&contNo=" + $scope.wfLogSubNo ).success(function(data){

                    /*//参数配置
                    $scope.dataTableProperties= {
                        //table的html id
                        dataTableId: $scope.dataTableId,
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
                    }

                    CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);*/
                    $scope.logData = data.data;

                })
            };

            $scope.initData();

            $scope.$watch("wfLogType + wfLogNo + wfLogSubNo",function () {
                $scope.initData();
            })

        }
    }


});