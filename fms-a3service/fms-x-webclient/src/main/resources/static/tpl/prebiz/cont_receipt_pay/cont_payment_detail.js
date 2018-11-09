/**
 * Created by huchenghao on 2018-03-26.
 */
app.controller('prebiz_cont_payment_detail_controller', ['$scope', '$http','$modal','toaster','$location','$compile',function ($scope, $http,$modal,toaster,$location,$compile) {

    $scope.contRequestPay={};
    //审批操作
    $scope.paymentActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.paymentActType);
    //是否确认付款
    $scope.confirmPayStatusList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.confirmPayStatus);

    $scope.formValidate = false;


    $scope.applyNo = $location.search()['applyNo'];
    $scope.contNo = $location.search()['contNo'];
    $scope.applyType = $location.search()['applyType'];
    $scope.taskId = $location.search()['taskId'];
    $scope.submit = false;

    $http.get('cont_receipt_pay/findContRequestPayWithContPayByContNo?contNo='+$scope.contNo).success(function (data) {
        if(data.code == Response.successCode){
            $scope.contRequestPay=data.data;
            console.log($scope.contRequestPay)
            $scope.contRequestPay.approvalFlag='1';

            $scope.contRequestPay.contNo=$location.search()["contNo"];
            $scope.contRequestPay.applyNo=$location.search()["applyNo"];
            $scope.contRequestPay.applyType=$location.search()["applyType"];
            $scope.contRequestPay.taskId=$location.search()["taskId"];

            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'cont_receipt_table',
                //table的列
                dataTableColumn: [
                    {title:'收款类型',data:'chargeFund',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.payFundName,data);
                        }
                    },
                    {title:'应收金额',data:'chargeAmount',width:'20%'},
                    {title:'抵扣金额',data:'chargeDeductionAmount',width:'20%'},
                    {title:'实收金额',data:'receiptAmount',width:'20%'},
                    {title:'到账日期',data:'receiptDate',width:'20%'},
                    {title:'备注',data:'memoReceipt',width:'20%'},
                    {title:'收款银行分行',data:'recAccBranch',width:'20%'},
                    {title:'收款户名',data:'recAccountName',width:'20%'},
                    {title:'收款账号',data:'recAccountNo',width:'20%'}
                ],
                dataTableData: $scope.contRequestPay.contChargeReceiptVoList
            };
            $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
            $compile($("#cont_receipt_table"))($scope);
        }
    });

    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("/app/home");
    };

}]);


