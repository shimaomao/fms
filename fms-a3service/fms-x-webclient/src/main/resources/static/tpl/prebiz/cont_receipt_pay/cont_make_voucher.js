/**
 * Created by huchenghao on 2018-03-26.
 */
app.controller('prebiz_cont_make_voucher_controller', ['$scope', '$http','$modal','toaster','$location','$compile', function ($scope, $http,$modal,toaster,$location,$compile) {

    $scope.contRequestPay={};

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

    //银行选择
    $scope.selectBasBankInfo = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_bank_info_select_controller',
            resolve:{
                selectBank: function () {
                    return {organizationType: CommonCodeUtils.organizationType.userGroup}
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.showError = false;
                $scope.contRequestPay.contPay.payAccBank = data.accBankName;
                $scope.contRequestPay.contPay.payAccountName = data.accountName;
                $scope.contRequestPay.contPay.payAccountNo = data.accountNo;
                $scope.contRequestPay.contPay.payEleBankNo = data.eleAccountNo;
                $scope.contRequestPay.contPay.payAccBranch = data.accBranchBank;
            }
        },function(){

        });
    }

    /**
     * 提交
     */
    $scope.url="";
    $scope.submitContRequestPay = function () {
        if(!$scope.form.$invalid) {
            if(isNullEmpty($scope.contRequestPay.contPay.payAccBranch)){//单独验证付款银行
                toaster_info(promptInfo.submitWarn,toaster);
                $scope.showError = true;
                return;
            }
            if ($scope.contRequestPay.contFinPayVoList.length > 0){
                for (var index in $scope.contRequestPay.contFinPayVoList){
                    if ($scope.contRequestPay.contFinPayVoList[index].finItem == 'carprice'
                        && $scope.contRequestPay.contFinPayVoList[index].contPay.payAmount <= 0){
                        $scope.submit = false;
                        modalAlert($modal,"车款付款金额必须大于0");
                        return ;
                    }
                }
            }
            $scope.submit = true;
            $scope.url="cont_receipt_pay/submitContMakeVoucher";//提交

            $http.post($scope.url, $scope.contRequestPay).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
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

    /**
     * 打印
     */
    $scope.print = function(){
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.url="cont_receipt_pay/saveContMakeVoucher";//暂存

            $http.post($scope.url, $scope.contRequestPay).success(function (data) {
                if (data.code == Response.successCode){
                    CommonFileUtils.downloadFileGet('cont_receipt_pay/printContMakeVoucher',{contNo:$scope.contNo}
                        ,$http,$modal,$scope);
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



        // if(CommonObjectUtils.isExist($scope.contNo)){
        //     CommonFileUtils.downloadFileGet('cont_receipt_pay/printContMakeVoucher',{contNo:$scope.contNo}
        //         ,$http,$modal,$scope);
        // }else{
        //     modalAlert($modal,"合同号不存在")
        // }
    }

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.apply;
    $scope.wfLogNo = $scope.applyNo;
    $scope.wfLogSubNo = $scope.contNo;
}]);


