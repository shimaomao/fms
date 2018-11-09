app.controller('deposit_contract_create_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {
    //附件对象
    $scope.formValidate = false;

    $scope.submit = false;

    $scope.submitUrl = null;

    $scope.depositTaskNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];

    $scope.depositApproveVo = {depositTaskNo: $scope.depositTaskNo,actType:'1',
        taskId:$location.search()['taskId'],taskDefinitionKey:$location.search()['taskDefinitionKey']};

    $scope.sendToApply = function(){

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.post('deposit_change_task/sendToApply',$scope.depositApproveVo).success(function(data){
                if (data.code == Response.successCode){
                    $location.path("/app/home").search({type:'homeToastInfo', msg:'退回成功'});
                } else {
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

    $scope.submitInfo = function(){

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.post('deposit_change_task/contractCreate',$scope.depositApproveVo).success(function(data){
                if (data.code == Response.successCode){
                    $location.path("/app/home").search({type:'homeToastInfo', msg:'合同生成成功'});
                } else {
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


    // 返回
    $scope.goBack = function () {
        $location.path('/app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.depositChange;
    $scope.wfLogNo = $scope.depositTaskNo;
}]);