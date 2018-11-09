/**
 * Created by lijunjun on 2018-05-16.
 */
app.controller('overdue_cstm_detail_controller', ['$scope', '$http','$modal', '$modalInstance','overdueCstm', function ($scope, $http,$modal, $modalInstance,overdueCstm) {

    $scope.overdueCstm=overdueCstm;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


