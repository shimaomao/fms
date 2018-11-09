/**
 * Created by ningyangyang on 2018-09-10.
 */
app.controller('change_lessee_task_detail_controller', ['$scope', '$http','$modal', '$modalInstance','changeLesseeTask', function ($scope, $http,$modal, $modalInstance,changeLesseeTask) {

    $scope.changeLesseeTask=changeLesseeTask;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


