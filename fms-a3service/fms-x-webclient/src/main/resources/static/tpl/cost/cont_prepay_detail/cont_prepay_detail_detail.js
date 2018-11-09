/**
 * Created by yangyiquan on 2018-05-11.
 */
app.controller('cont_prepay_detail_detail_controller', ['$scope', '$http','$modal', '$modalInstance','contPrepayDetail', function ($scope, $http,$modal, $modalInstance,contPrepayDetail) {

    $scope.contPrepayDetail=contPrepayDetail;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


