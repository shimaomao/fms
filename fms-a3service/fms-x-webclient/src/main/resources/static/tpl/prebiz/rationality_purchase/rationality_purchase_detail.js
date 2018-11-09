/**
 * Created by ningyangyang on 2018-05-29.
 */
app.controller('rationality_purchase_detail_controller', ['$scope', '$http','$modal', '$modalInstance','rationalityPurchase', function ($scope, $http,$modal, $modalInstance,rationalityPurchase) {

    $scope.rationalityPurchase=rationalityPurchase;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


