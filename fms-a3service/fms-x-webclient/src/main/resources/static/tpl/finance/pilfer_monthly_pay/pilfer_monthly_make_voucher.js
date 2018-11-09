/**
 * Created by yangyiquan on 2018-06-04.
 */
app.controller('pilfer_monthly_make_voucher_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.valid = false;
    $scope.formValidate = false;
    $scope.httpData = true;
    //附件对象
    $scope.bizFilesList= [];
    //审批操作
    $scope.contRequestPayActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contRequestPayActType);

    //审批数据
    $scope.pilferInsuranceApproveVo = {monthlyPilferInsuranceNo:$location.search()['serviceId'], taskId:$location.search()['taskId'],
        approvalFlag:'1'};

    //退回时不用强求选择付款银行
    $scope.$watch('pilferInsuranceApproveVo.approvalFlag', function(newVal, oldVal){
        if(newVal != "1")
            $scope.valid = false;
    });

    $scope.monthlyPilferInsuranceNo = $location.search()['serviceId'];
    console.log($scope.monthlyPilferInsuranceNo)
    $scope.taskId = $location.search()['taskId'];
    $scope.submit = false;

    //获取月结数据
    $http.get('monthly_pilfer_insurance/findMonthlyPilferInsuranceVoByPilferInsuranceNo?monthlyPilferInsuranceNo='+ $scope.monthlyPilferInsuranceNo).success(function(data){
        $scope.monthlyPilferInsuranceVo = data.data;
        //附件赋值
        $scope.bizFilesList = $scope.monthlyPilferInsuranceVo.bizFilesList;
    });
    //获取财务付款数据
    $http.get('contpay/findContPayByBizCodeAndPaymentType?paymentType='+CommonCodeUtils.bizTypes.pilfer+'&bizCode='+ $scope.monthlyPilferInsuranceNo).success(function(data){
        $scope.contPay = data.data;
        $scope.pilferInsuranceApproveVo.contPayId = $scope.contPay.contPayId;
        $scope.pilferInsuranceApproveVo.payAccBank = $scope.contPay.payAccBank;
        $scope.pilferInsuranceApproveVo.payAccountName = $scope.contPay.payAccountName;
        $scope.pilferInsuranceApproveVo.payAccountNo = $scope.contPay.payAccountNo;
    });

    //获取月结明细数据
    $http.post(
        'pilfer_insurance/findPilferInsuranceMonthlysVos',
        {monthlyPilferInsuranceNo: $scope.monthlyPilferInsuranceNo}
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
                selectBank:function () {
                    return {organizationType: CommonCodeUtils.organizationType.userGroup}
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.pilferInsuranceApproveVo.payAccBank = data.accBankName;
                $scope.pilferInsuranceApproveVo.payAccountName = data.accountName;
                $scope.pilferInsuranceApproveVo.payAccountNo = data.accountNo;
                $scope.pilferInsuranceApproveVo.payAccBranch = data.accBranchBank;
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
        if($scope.pilferInsuranceApproveVo.approvalFlag == "1"){//提交
            if(isNullEmpty($scope.pilferInsuranceApproveVo.payAccBank)){
                $scope.valid = true;
            }
        }else{
            $scope.valid = false;
        }
        if(!$scope.form.$invalid  && !$scope.valid) {
            $scope.submit = true;
            $scope.url="pilfer_monthly_pay/makeVoucher";//提交

            $http.post($scope.url, $scope.pilferInsuranceApproveVo).success(function (data) {
                if (data.code == Response.successCode){

                    if($scope.pilferInsuranceApproveVo.approvalFlag=="1"){
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
     * 盗抢险月结付款单打印
     */
    $scope.printPilferMonthly = function () {
        $scope.pilferInsuranceApproveVo.contPay = $scope.contPay;
        $scope.pilferInsuranceApproveVo.pilferInsuranceVoList = $scope.tableData;
        CommonFileUtils.downloadFilePost('pilfer_monthly_pay/printPilferMonthly',$scope.pilferInsuranceApproveVo
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


