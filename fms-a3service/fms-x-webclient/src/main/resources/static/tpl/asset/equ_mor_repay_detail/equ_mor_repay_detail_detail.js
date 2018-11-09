/**
 * Created by qinmuqiao on 2018-10-26.
 */
app.controller('equ_mor_repay_detail_detail_controller', ['$scope', '$http','$modal', '$modalInstance','equMorRepayDetail', function ($scope, $http,$modal, $modalInstance,equMorRepayDetail) {

    $scope.equMorRepayDetail=equMorRepayDetail;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


