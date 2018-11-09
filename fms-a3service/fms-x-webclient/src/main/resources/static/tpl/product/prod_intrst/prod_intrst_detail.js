/**
 * Created by niehaibing on 2018-03-27.
 */
app.controller('prod_intrst_detail_controller', ['$scope', '$http','$modal', '$modalInstance','prodIntrst', function ($scope, $http,$modal, $modalInstance,prodIntrst) {

    $scope.prodIntrst=prodIntrst;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


