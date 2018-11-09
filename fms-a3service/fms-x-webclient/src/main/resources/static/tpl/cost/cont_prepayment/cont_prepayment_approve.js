/**
 * Created by yangyiquan on 2018-03-26.
 */
app.controller('cont_prepayment_approve_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {


    $scope.formValidate = false;
    //审批操作
    $scope.contRequestPayActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.generalApproval);

    $scope.contPrepaymentApproveVo = {contPrepaymentNo:$location.search()['serviceId'], taskId:$location.search()['taskId'],
        contPrepaymentStatus:'1',taskDefinitionKey:$location.search()['taskDefinitionKey']};

    $scope.contPrepaymentNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];
    $scope.submit = false;

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

    /**
     * 返回
     * @param status
     */
    $scope.goback = function(){
        $location.path("/app/home");
    };
}]);


