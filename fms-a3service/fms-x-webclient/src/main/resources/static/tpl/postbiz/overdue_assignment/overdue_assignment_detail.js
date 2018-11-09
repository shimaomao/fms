/**
 * Created by lijunjun on 2018-05-16.
 */
app.controller('overdue_assignment_detail_controller', ['$scope', '$http','$modal', '$modalInstance','overdueAssignment', function ($scope, $http,$modal, $modalInstance,overdueAssignment) {

    $scope.overdueAssignment=overdueAssignment;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


