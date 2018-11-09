/**
 * Created by lijunjun on 2018-05-16.
 */
app.controller('overdue_sum_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','paramsData', function ($scope, $http,$modal, $modalInstance,toaster,paramsData) {
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : "overdue_cstm/findContRepaySkedAndOverduByoverdueCstmId",
            type:"GET"
        },
        //table的html id
        dataTableId:'overdue_sum',
        //table的列
        dataTableColumn: [
            {title:'合同编号',data:'contNo',width:'20%'},
            {title:'每期序号',data:'period',width:'20%'},
            {title:'收款日期',data:'repayDate',width:'20%'},
            {title:'实际还款日',data:'receiptDate',width:'20%'},
            {title:'租金扣款状态',data:'rentRepayStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.repayStatus,data);
                }
            },
            {title:'客户租金',data:'rent',width:'20%'},
            {title:'是否逾期',data:'overdueStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.overdueCondCd,data);
                }
            },
            {title:'逾期天数',data:'overdueDays',width:'20%'},
            {title:'当期本金',data:'principal',width:'20%'},
            {title:'当期利息',data:'interest',width:'20%'},
            //{title:'手续费用',data:'charge',width:'20%'},
            {title:'当期剩余本金',data:'restPrincipal',width:'20%'},
            //{title:'保证金',data:'deposit',width:'20%'},
            //{title:'每期客户实际租金',data:'rent',width:'20%'},
            {title:'罚息金额',data:'overdueAmount',width:'20%'},
            {title:'罚息扣款状态',data:'overdueRepayStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.repayStatus,data);
                }
            },
            {title:'罚息已收金额',data:'receiptAmount',width:'20%'},
            {title:'罚息免除金额',data:'exemptAmount',width:'20%'},
            {title:'剩余罚息金额',data:'restOverdueAmount',width:'20%'}
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        //dataTableSelectType: CheckBox

    };
    //请求的参数
    function dataTableParams(){
        params = {};
        if(paramsData.overdueCstmId){
            params.overdueCstmId = paramsData.overdueCstmId;
        }else{
            params.contNo = paramsData.contNo;
        }
        return params;
    }
    $scope.loadReady = function () {
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close();
    };

}]);


