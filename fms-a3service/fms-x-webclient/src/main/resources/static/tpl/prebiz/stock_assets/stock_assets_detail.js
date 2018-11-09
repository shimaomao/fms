/**
 * Created by ningyangyang on 2018-05-28.
 */
app.controller('stock_assets_detail_controller', ['$scope', '$http','$modal', '$modalInstance','stockAssets', function ($scope, $http,$modal, $modalInstance,stockAssets) {

    $scope.stockAssets=stockAssets;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


