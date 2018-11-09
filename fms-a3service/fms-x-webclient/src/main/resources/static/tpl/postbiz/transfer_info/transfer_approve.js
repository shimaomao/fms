/**
 * Created by wangxue on 2018/9/5.
 */

app.controller('transfer_approve_controller', ['$scope', '$http','$modal', 'toaster','$location', function ($scope, $http, $modal, toaster, $location) {

    $scope.formValidate = false;

    $scope.submit = false;

    //审批操作
    $scope.contRequestPayActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.generalApproval);

    $scope.transferInfoVo = {transferNo:$location.search()['serviceId'], taskId:$location.search()['taskId'],
        examineSts:'1',taskDefinitionKey:$location.search()['taskDefinitionKey']};
    // 详情页面
    $scope.transferNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];

    // 提交
    $scope.submitInfo = function () {
        if (!$scope.form.$invalid) {
            $scope.submit = true;
            if($scope.transferInfoVo.examineSts=="1"){
                $scope.url="transfer_info/transferApproval";//提交
            }else{
                $scope.url="transfer_info/transferSendBack";//退回
            }

            $http.post($scope.url, $scope.transferInfoVo).success(function (result) {
                if (result.code == Response.successCode){
                    if($scope.transferInfoVo.examineSts=="1"){
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                    }else{
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'退回成功'});
                    }
                }else{
                    modalAlert($modal, result.message);
                }

                $scope.submit = false;
            }).error(function(result){
                modalAlert($modal, result);
                $scope.submit = false;
            })
        } else {
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    /**
     * 返回
     * @param status
     */
    $scope.goback = function(){
        $location.path("/app/home");
    };
}]);