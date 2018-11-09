app.controller('capital_assets_manager_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    $scope.submit = false;

    $scope.capitalTaskNo = $location.search()['serviceId'];
    $scope.disposalTaskNo = $scope.capitalTaskNo;
    $scope.taskId = $location.search()['taskId'];
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];
    $scope.msgInfo = null;
    $scope.notUploadInfo = "";

    $scope.approveVo = {capitalTaskNo: $scope.capitalTaskNo,taskId:$location.search()['taskId']};

    $scope.submitInfo = function(){

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.post('capital_assets/approve',$scope.approveVo).success(function(data){
                if (data.code == Response.successCode){
                    $location.path("/app/home").search({type:'homeToastInfo', msg:'审批成功'});
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
    $scope.wfLogType = CommonCodeUtils.bizTypes.capitalAssets;
    $scope.wfLogNo = $scope.capitalTaskNo;

}]);