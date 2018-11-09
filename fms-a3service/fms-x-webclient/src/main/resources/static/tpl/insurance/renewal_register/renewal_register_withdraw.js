/**
 * Created by ningyangyang on 2018-06-10.
 * 续保财务确认收款
 */
app.controller('renewal_register_withdraw_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.renewalRegister={};


    $scope.renewalTaskNo = $location.search()['serviceId']
    $scope.taskId = $location.search()['taskId']
    $scope.formValidate = false;
    $scope.submit = false;


    $http.get('renewal_register/findRenewalRegistersByTaskNo?renewalTaskNo='+$scope.renewalTaskNo).success(function(data){
        console.log(data.data)
        $scope.renewalRegister = data.data;
        $scope.renewalRegister.insCompName = null;
        $scope.renewalRegister.requesAmount = null
        // if($scope.renewalRegister.finFlag == 0){
        //     $scope.renewalRegister.requesAmount = $scope.renewalRegister.finAmount;
        // }else if($scope.renewalRegister.finFlag == 1){
        //     $scope.renewalRegister.requesAmount = $scope.renewalRegister.customPaymentAmount;
        // }
        if($scope.renewalRegister.customPaymentAmount == null){
            $scope.renewalRegister.customPaymentAmount = 0;
        }
    })

    /**
     * 续保上传
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            // $scope.renewalRegister.renewalContVehinsId = $scope.renewalContVehinsId
            // $scope.renewalRegister.renewalRegisterId = $scope.renewalRegisterId
            // $scope.renewalRegister.contNo = $scope.contNo
            // $scope.renewalRegister.bizfilesVo = $scope.bizFilesList;
            $scope.renewalRegister.renewalTaskNo = $scope.renewalTaskNo;
            $scope.renewalRegister.taskId  = $scope.taskId
            $http.post('renewal_register/renewalRegisterWithdraw',$scope.renewalRegister).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path('/app/home').search({"type": 'homeToastInfo', "msg":'资管请款成功'})
                }
                else
                    modalAlert($modal,data.message);
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
     * 退回上一级
     */
    $scope.sendBack = function(){
        $scope.submit = true;
        if(isUndefinedNull($scope.renewalRegister.remark1)){
            modalAlert($modal,'请输入备注');
            $scope.submit = false;
            return false;
        }
        $scope.renewalRegister.renewalTaskNo = $scope.renewalTaskNo;
        $scope.renewalRegister.taskId  = $scope.taskId
        $http.post('renewal_register/renewalRegisterSendBack', $scope.renewalRegister).success(function (data) {
            if (data.code == Response.successCode){
                $location.path('/app/home').search({"type": 'homeToastInfo', "msg":'退回成功'})
            }
            else
                modalAlert($modal,data.message);
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    }

    //选择银行信息
    $scope.selectBasBankInfo = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_bank_info_select_controller',
            resolve:{
                selectBank: function () {
                    return {organizationType: CommonCodeUtils.organizationType.insuranceCompany}
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.renewalRegister.recAccBank = data.accBankName;
                $scope.renewalRegister.recAccountName = data.accountName;
                $scope.renewalRegister.recAccountNo = data.accountNo;
                $scope.renewalRegister.recEleBankNo = data.eleAccountNo;
                $scope.renewalRegister.recAccBranch = data.accBranchBank;
            }
        },function(){
        });
    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goback = function(){
        $location.path('/app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.renewal;
    $scope.wfLogNo = $scope.renewalTaskNo;

}]);



