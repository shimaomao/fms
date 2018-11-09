/**
 * Created by qiaohao on 2018/2/1.
 */
app.controller('act_ru_task_complete_test_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$modalInstance','taskId', function ($scope, $http, $modal, toaster,$compile,$location,$modalInstance,taskId) {

    //操作分类列表
    $scope.actTypes = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.applyApproveActType);

    $scope.actObj = {actType:0};

    $scope.submit = function(){
        $http.post('act_ru_task/approvalTest?taskId=' + taskId + '&status=' +  $scope.actObj.actType).success(function (data) {
            if (data.code == Response.successCode)
                $scope.close(Response.successMark);
            else
                modalAlert($modal,data.message);
        }).error(function(data){
            modalAlert($modal,data);
        })
    }


    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}])
;