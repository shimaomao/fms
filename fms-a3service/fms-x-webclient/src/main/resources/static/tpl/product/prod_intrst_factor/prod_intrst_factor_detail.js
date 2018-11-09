/**
 * Created by niehaibing on 2018-03-27.
 */
app.controller('prod_intrst_factor_detail_controller', ['$scope', '$http','$modal', '$modalInstance','prodIntrstFactor', function ($scope, $http,$modal, $modalInstance,prodIntrstFactor) {

    $scope.prodIntrstFactor=prodIntrstFactor;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


