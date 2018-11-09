/**
 * Created by qiaomengnan on 2018-03-14.
 */
app.controller('act_user_leave_detail_controller', ['$scope', '$http','$modal', '$modalInstance','actUserLeave', function ($scope, $http,$modal, $modalInstance,actUserLeave) {

    $scope.actUserLeave=actUserLeave;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


