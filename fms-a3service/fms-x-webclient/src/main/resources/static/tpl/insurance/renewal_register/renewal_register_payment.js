/**
 * Created by ningyangyang on 2018-05-14.
 * 财务付款
 */
app.controller('renewal_register_payment_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.renewalRegister={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.renewalTaskNo = $location.search()['serviceId']
    $scope.taskId = $location.search()['taskId']

    $http.get('renewal_register/findRenewalRegistersByTaskNo?renewalTaskNo='+$scope.renewalTaskNo).success(function(data){
        console.log(data.data)
        $scope.renewalRegister = data.data;
    })

    //是否融保险
    $scope.finFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.finFlag);
    //保险购买方式
    $scope.insurPurTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.insurPurType);
    /**
     * 续保上传
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.renewalRegister.renewalTaskNo = $scope.renewalTaskNo;
            $scope.renewalRegister.taskId = $scope.taskId;
            $http.put('renewal_register/renewalRegisterPayment', $scope.renewalRegister).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path('/app/home').search({"type": 'homeToastInfo', "msg":'财务付款成功'})
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

    //选择付款银行信息
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
    //             $scope.renewalRegister.payAccountNo = data.accountNo;
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












/*
 /!**
 * Created by yanfengbo on 2018-05-17.
 *!/
 app.controller('renewal_register_save_controller', ['$scope', '$http','$modal', '$modalInstance','toaster', function ($scope, $http,$modal, $modalInstance,toaster) {

 $scope.renewalRegister={};

 $scope.formValidate = false;

 $scope.submit = false;


 /!**
 * 保存组织机构属性信息
 *!/
 $scope.save = function () {

 if(!$scope.form.$invalid) {

 $scope.submit = true;

 $http.post('renewal_register/saveRenewalRegister', $scope.renewalRegister).success(function (data) {
 if (data.code == Response.successCode)
 $scope.close(Response.successMark);
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

 /!**
 * 关闭窗口
 * @param status
 *!/
 $scope.close = function(status){
 $modalInstance.close(status);
 };

 }]);*/



