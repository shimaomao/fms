/**
 * Created by ningyangyang on 2018-06-10.
 * 资管复核
 */
app.controller('renewal_register_review_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.renewalRegister={};


    $scope.renewalTaskNo = $location.search()['serviceId']
    $scope.taskId = $location.search()['taskId']
    $scope.formValidate = false;
    $scope.submit = false;


    $http.get('renewal_register/findRenewalRegistersByTaskNo?renewalTaskNo='+$scope.renewalTaskNo).success(function(data){
        console.log(data.data)
        $scope.renewalRegister = data.data;
        // if($scope.renewalRegister.finFlag == 0){
        //     $scope.renewalRegister.requesAmount = $scope.renewalRegister.finAmount;
        // }else if($scope.renewalRegister.finFlag == 1){
        //     $scope.renewalRegister.requesAmount = $scope.renewalRegister.customPaymentAmount;
        // }
    })

    /**
     * 资管复核
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
            $http.put('renewal_register/renewalRegisterReview', $scope.renewalRegister).success(function (data) {
                if (data.code == Response.successCode){
                    //modalAlert($modal,'资管复核成功');
                    $location.path('/app/home').search({"type": 'homeToastInfo', "msg":'资管复核成功'})
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
            $scope.submit = false;
            return false;
        }
        $scope.renewalRegister.renewalTaskNo = $scope.renewalTaskNo;
        $scope.renewalRegister.taskId  = $scope.taskId
        $http.put('renewal_register/renewalRegisterSendBack', $scope.renewalRegister).success(function (data) {
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
    // $scope.selectBasBankInfo = function(){
    //     var rtn = $modal.open({
    //         backdrop : 'static',
    //         size:'lg',
    //         templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
    //         controller: 'bas_bank_info_select_controller',
    //         resolve:{
    //              selectBank: null
    //         }
    //     });
    //     rtn.result.then(function (data) {
    //         if(data != null) {
    //             $scope.renewalRegister.payAccBank = data.accBankName;
    //             $scope.renewalRegister.payAccountName = data.accountName;
    //             $scope.renewalRegister.recAccountNo = data.accountNo;
    //             $scope.renewalRegister.payEleBankNo = data.eleAccountNo;
    //         }
    //     },function(){
    //     });
    // }

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



