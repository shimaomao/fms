/**
 * Created by lijunjun on 2018-05-16.
 */
app.controller('overdue_state_controller', ['$scope', '$http','$modal', '$modalInstance','toaster', function ($scope, $http,$modal, $modalInstance,toaster) {
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : "overdue_condition/findOverdueConditionsByPage",
            type:"GET"
        },
        //table的html id
        dataTableId:'overdue_state',
        //table的列
        dataTableColumn: [
            defaultCheckBox('overdueCondCd'),
            {title:'逾期状态代码',data:'overdueCondCd',width:'20%'},
            {title:'逾期状态名称',data:'overdueCondName',width:'20%'},
            {title:'逾期风险等级',data:'overdueRisk',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.overdueRisk,data);
                }
            },
            {title:'逾期状态备注',data:'overdueMeno',width:'20%'}
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio,

    };
    //请求的参数
    function dataTableParams($scope){
        params = {};
        return params;
    }
    $scope.loadReady = function () {
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };

    $scope.save = function () {
        var row = $scope.dataTable.getRow();
        if(row){
            $modalInstance.close(row);
        }else{
            modalAlert($modal,"请选择一条数据！");
        }
    };
    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close();
    };
}]);


