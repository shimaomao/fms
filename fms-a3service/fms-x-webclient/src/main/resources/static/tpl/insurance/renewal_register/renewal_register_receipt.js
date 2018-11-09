/**
 * Created by ningyangyang on 2018/6/8.
 */
/**
 * Created by ningyangyang on 2018-05-14.
 * 续保财务确认收款
 */
app.controller('renewal_register_receipt_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.renewalRegister={};

    $scope.renewalRegisterVoList = [];

    $scope.renewalTaskNo = $location.search()['serviceId']
    $scope.taskId = $location.search()['taskId']
    $scope.formValidate = false;
    $scope.submit = false;


        $http.get('renewal_register/findRenewalRegistersByTaskNo?renewalTaskNo='+$scope.renewalTaskNo).success(function(data){
            // alert($scope.wfLogType);
            $scope.renewalRegister = data.data;
        })

    //是否融保险
    $scope.finFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.finFlag);
    $scope.insurPurTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.insurPurType);
    /**
     * 续保上传
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.renewalRegister.renewalRegisterVoList = $scope.renewalRegisterVoList;
            $scope.renewalRegister.renewalTaskNo = $scope.renewalTaskNo;
            $scope.renewalRegister.taskId  = $scope.taskId
            $http.post('renewal_register/renewalRegisterReceipt', $scope.renewalRegister).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path('/app/home').search({"type": 'homeToastInfo', "msg":'财务确认收款成功'})
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

    $scope.add = function () {
        var obj = {
            recAccBank:'',
            recAccountName:'',
            recAccountNo:'',
            recEleBankNo:'',
            receiptAmount:0,
            memo:'',
            receiptDate: getToday()
        };
        $scope.renewalRegisterVoList.push(obj);
    };
    //删除银行信息
    $scope.del = function (index) {
        $scope.renewalRegisterVoList.splice(index,1);
    };
    //选择银行信息
    $scope.selectBasBankInfo = function(index){
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
                $scope.renewalRegisterVoList[index].recAccBank = data.accBankName;
                $scope.renewalRegisterVoList[index].recAccountName = data.accountName;
                $scope.renewalRegisterVoList[index].recAccountNo = data.accountNo;
                $scope.renewalRegisterVoList[index].recEleBankNo = data.eleAccountNo;
                $scope.renewalRegisterVoList[index].recAccBranch = data.accBranchBank;
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



