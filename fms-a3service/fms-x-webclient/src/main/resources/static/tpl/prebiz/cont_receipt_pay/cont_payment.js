/**
 * Created by huchenghao on 2018-03-26.
 */
app.controller('prebiz_cont_payment_controller', ['$scope', '$http','$modal','toaster','$location','$compile', function ($scope, $http,$modal,toaster,$location,$compile) {

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
     * 提交
     */
    $scope.url="";
    $scope.submitContRequestPay = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            if($scope.contRequestPay.approvalFlag=="1"){
                $scope.url="cont_receipt_pay/submitContPayment";//提交
            }else{
                $scope.url="cont_receipt_pay/backContPayment";//退回
            }

            $http.post($scope.url, $scope.contRequestPay).success(function (data) {
                if (data.code == Response.successCode){
                    if($scope.contRequestPay.approvalFlag=="1"){
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                    }else{
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'退回成功'});
                    }
                }else{
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    }

    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("/app/home");
    };

    $scope.getPayDate = function(a){
        if(a.confirmPayStatus == 1)
            a.contPay.payDate = new Date();
        else
            a.contPay.payDate = "";
    }

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.apply;
    $scope.wfLogNo = $scope.applyNo;
    $scope.wfLogSubNo = $scope.contNo;
}]);


