/**
 * Created by yangyiquan on 2018-09-10.
 */
app.controller('invoice_auto_detail_controller', ['$scope', '$http','$modal', '$modalInstance','invoiceAuto', function ($scope, $http,$modal, $modalInstance,invoiceAuto) {

    $scope.invoiceAuto=invoiceAuto;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


