app.controller('basic_change_cancel_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    $scope.basicChangeVo={};
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.basicTaskNo=$location.search()['basicTaskNo'];
    $scope.changeType=$location.search()['changeType'];

    $http.get('basic_change_task/findBasicChangeCancelVo?basicTaskNo='+ $scope.basicTaskNo).success(function(data){
        if (data.code == Response.successCode){
            $scope.basicChangeVo = data.data;
        } else{
            modalAlert($modal,data.message);
        }
    });

    /**
     * 基本信息变更取消提交
     */
    $scope.modify = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            // 变更类型
            $scope.basicChangeVo.changeType = $scope.changeType;
            $http.post('basic_change_task/basicChangeTaskCancel', $scope.basicChangeVo).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path("app/postbiz_basic_change_task_list").search({type:'cancel', msg:'流程取消成功'});
                } else
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
    };


    /**
     * 返回
     * @param status
     */
    $scope.goback = function(){
        $location.path("app/postbiz_basic_change_task_list");
    };
}]);

