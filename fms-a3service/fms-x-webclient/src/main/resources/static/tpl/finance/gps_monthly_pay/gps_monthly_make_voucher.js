/**
 * Created by yangyiquan on 2018-6-01.
 */
app.controller('gps_monthly_make_voucher_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.valid = false;
    $scope.formValidate = false;
    $scope.httpData = true;
    //附件对象
    $scope.bizFilesList= [];
    //审批操作
    $scope.contRequestPayActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contRequestPayActType);

    $scope.monthlySettlementApproveVo = {monthlySettlementNo:$location.search()['serviceId'], taskId:$location.search()['taskId'],
        approvalFlag:'1'};

    //退回时不用强求选择付款银行
    $scope.$watch('monthlySettlementApproveVo.approvalFlag', function(newVal, oldVal){
        if(newVal != "1")
            $scope.valid = false;
    });

    $scope.monthlySettlementNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.submit = false;

    //获取月结数据
    $http.get('monthly_settlement/findMonthlySettlementVoBySettlementNo?monthlySettlementNo='+ $scope.monthlySettlementNo).success(function(data){
        $scope.monthlySettlementVo = data.data;
        //附件赋值
        $scope.bizFilesList = $scope.monthlySettlementVo.bizFilesList;
        $scope.monthlySettlementApproveVo.updateTime = data.data.updateTime;
    });
    //获取财务付款数据
    $http.get('contpay/findContPayByBizCodeAndPaymentType?paymentType='+CommonCodeUtils.bizTypes.gps+'&bizCode='+ $scope.monthlySettlementNo).success(function(data){
        $scope.contPay = data.data;
        $scope.monthlySettlementApproveVo.contPayId = $scope.contPay.contPayId;
        $scope.monthlySettlementApproveVo.payAccBank = $scope.contPay.payAccBank;
        $scope.monthlySettlementApproveVo.payAccountName = $scope.contPay.payAccountName;
        $scope.monthlySettlementApproveVo.payAccountNo = $scope.contPay.payAccountNo;
    });

    //获取月结明细数据
    $http.post(
        'gps_dispatch/findGpsDispatchMonthlysVos',
        {monthlySettlementNo: $scope.monthlySettlementNo}
    ).success(function (data) {
        if (data.code == Response.successCode){
            $scope.tableData = data.data.data;
        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
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
                $scope.monthlySettlementApproveVo.payAccBank = data.accBankName;
                $scope.monthlySettlementApproveVo.payAccountName = data.accountName;
                $scope.monthlySettlementApproveVo.payAccountNo = data.accountNo;
                $scope.monthlySettlementApproveVo.payEleBankNo = data.eleAccountNo;
                $scope.monthlySettlementApproveVo.payAccBranch = data.accBranchBank;
                $scope.valid = false;
            }
        },function(){

        });
    }

    /**
     * 提交月结申请
     */
    $scope.url="";
    $scope.submitInfo = function () {
        if($scope.monthlySettlementApproveVo.approvalFlag == "1"){//提交
            if(isNullEmpty($scope.monthlySettlementApproveVo.payAccBank)){
                $scope.valid = true;
            }
        }else{
            $scope.valid = false;
        }
        if(!$scope.form.$invalid && !$scope.valid) {
            $scope.submit = true;
            $scope.url="gps_monthly_pay/makeVoucher";//提交
            $http.post($scope.url, $scope.monthlySettlementApproveVo).success(function (data) {
                if (data.code == Response.successCode){

                    if($scope.monthlySettlementApproveVo.approvalFlag=="1"){
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
     * gps月结付款单打印
     */
    $scope.printGpsMonthly = function () {
        $scope.monthlySettlementApproveVo.contPay = $scope.contPay;
        $scope.monthlySettlementApproveVo.gpsDispatchMonthlyVo = $scope.tableData;
        CommonFileUtils.downloadFilePost('gps_monthly_pay/printGpsMonthly',$scope.monthlySettlementApproveVo
            ,$http,$modal,$scope);
    }
    /**
     * 返回
     * @param status
     */
    $scope.goback = function(){
        $location.path("/app/home").search({
            operate: null,
            contNo: null
        });
    };
}]);


