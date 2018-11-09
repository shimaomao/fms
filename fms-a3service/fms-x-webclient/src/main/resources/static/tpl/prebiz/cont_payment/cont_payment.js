

app.controller('cont_payment_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {
   /* $scope.$watch('contPayment.contPaymentActType',function () {
        if($scope.contPayment.contPaymentActType == '1'){
            $scope.isOk = true;
        }else{
            $scope.isOk = false;
        }
    })
    $scope.isOk = false;*/
    //财务付款审批意见
    $scope.contPaymentActTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contPaymentActType);

    //财务付款退回原因
    $scope.contPaymentReasonList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contPaymentReason);

    $scope.contPayment={};

    $scope.formValidate = false;

    //从主页面获取合同编号和订单编号
    $scope.contNo = $location.search()['contNo'];
    $scope.applyNo = $location.search()['applyNo'];
    $scope.applyType = $location.search()['applyType'];
    $scope.taskId = $location.search()['taskId'];

    $scope.contPayment = {applyNo: $location.search()['applyNo'],contNo:$location.search()['contNo'],
        applyType:$location.search()['applyType'],taskId:$location.search()['taskId']};

    $scope.submit = false;

    $http.get('cont_payment/findContPaymentVo?applyNo='+$scope.applyNo+'&contNo='+$scope.contNo).success(function (data) {

        data.data.contNo = $scope.contNo;
        data.data.applyNo = $scope.applyNo;
        $scope.contPayment = data.data;
        $scope.contPayment.contPaymentActType = '1';
        $scope.contPayment.taskId = $location.search()['taskId'];

    })


    //选择付款银行
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
                $scope.contPayment.accBank = data.accBankName;
                $scope.contPayment.accountNo = data.accountNo;
            }
        },function(){

        });


    }


    //提交

    $scope.url="";

    $scope.$watch('contPayment.contPaymentActType', function(){
        if($scope.contPayment.contPaymentActType == '0'){
            $scope.contPayment.contPaymentReason = '';
        }
    })

    $scope.save = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            if($scope.contPayment.contPaymentActType=="1"){
                $scope.url="cont_payment/submit";//付款完成
            }else{
                $scope.url="cont_payment/sendBack";//退回
                $scope.contPayment.contPaymentReasonKey = 'contPaymentReasonKey'//退回原因key
            }

            $http.post($scope.url, $scope.contPayment).success(function (data) {
                if (data.code == Response.successCode){

                    if($scope.contPayment.contPaymentActType=="1"){
                        //modalAlert($modal,"提交成功")
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                    }else{
                        //modalAlert($modal,"退回成功")
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

}]);
