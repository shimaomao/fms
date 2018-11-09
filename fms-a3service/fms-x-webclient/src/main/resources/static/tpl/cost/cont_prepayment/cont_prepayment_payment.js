/**
 * Created by ningyangyang on 2018/8/22.
 */
app.controller('cont_prepayment_payment_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {


    $scope.$on('contPrepaymentToFather',function (e,data) {

        //$scope.bankInfo = data;
        //$scope.contPrepaymentApproveVo = $.extend(true,$scope.contPrepaymentApproveVo,data);
        $scope.contPrepaymentApproveVo.payAccountName = data.payAccountName;
        $scope.contPrepaymentApproveVo.payAccountNo = data.payAccountNo;
        $scope.contPrepaymentApproveVo.payAccBranch = data.payAccBranch;
        $scope.contPrepaymentApproveVo.recAccBranch = data.recAccBranch;
        $scope.contPrepaymentApproveVo.recAccountName = data.recAccountName;
        $scope.contPrepaymentApproveVo.recAccountNo = data.recAccountNo;
        $scope.contPrepaymentApproveVo.prepayActualAmount = data.prepayActualAmount; //实际金额
        $scope.contPrepaymentApproveVo.payActualAmount = data.payMentAmount; // 应付金额
        $scope.contPrepaymentApproveVo.transferTotalCost = data.transferTotalCost; // 过户费用
        $scope.contPrepaymentApproveVo.vinNo = data.vinNo; //车架号
        $scope.contPrepaymentApproveVo.rentPerson = data.rentPerson; //出租人
        $scope.contPrepaymentApproveVo.name = data.name; //承租人
    });
    $scope.formValidate = false;
    //审批操作
    $scope.contRequestPayActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contRequestPayActType);

    $scope.contPrepaymentApproveVo = {contPrepaymentNo:$location.search()['serviceId'], taskId:$location.search()['taskId'],
        contPrepaymentStatus:'1',taskDefinitionKey:$location.search()['taskDefinitionKey']};

    $scope.contPrepaymentNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];
    $scope.submit = false;
    $scope.bankInfo = {};
    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.contPrepayment;
    $scope.wfLogNo = $scope.contPrepaymentNo;

    /**
     * 提交提前还款信息
     */
    $scope.url="";
    $scope.submitInfo = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            if($scope.contPrepaymentApproveVo.contPrepaymentStatus=="1"){
                $scope.url="cont_prepayment_approve/approval";//提交
            }else{
                $scope.url="cont_prepayment_approve/sendBack";//退回
            }
            // if($scope.contPrepaymentApproveVo.contPrepaymentStatus=="1"){
            //     if(isUndefinedNull($scope.bankInfo)){
            //         modalAlert($modal,'请选择银行信息')
            //         $scope.submit = false;
            //         return false;
            //     }
            // }
            $http.post($scope.url, $scope.contPrepaymentApproveVo).success(function (data) {
                if (data.code == Response.successCode){
                    if($scope.contPrepaymentApproveVo.contPrepaymentStatus=="1"){
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

    //选择银行信息
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
                $scope.contPrepaymentApproveVo.payAccBank = data.accBankName;
                $scope.contPrepaymentApproveVo.payAccountName = data.accountName;
                $scope.contPrepaymentApproveVo.payAccountNo = data.accountNo;
                //$scope.contPrepaymentApproveVo.recEleBankNo = data.eleAccountNo;
                $scope.contPrepaymentApproveVo.payAccBranch = data.accBranchBank;
                //$scope.bankInfo = data;
            }
        },function(){
        });
    }


    /**
     * 打印付款单
     */
    $scope.printPaymentOrder = function () {
        if(isUndefinedNull($scope.contPrepaymentApproveVo.payAccBranch)){
            modalAlert($modal,'请选择付款信息');
            $scope.submit = false;
            return false;
        }
        console.log($scope.contPrepaymentApproveVo)
        CommonFileUtils.downloadFilePost('cont_prepayment/printPaymentOrder',$scope.contPrepaymentApproveVo
            ,$http,$modal,$scope);

    }

    /**
     * 返回
     * @param status
     */
    $scope.goback = function(){
        $location.path("/app/home");
    };
}]);



