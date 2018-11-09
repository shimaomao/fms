/**
 * Created by qiaohao on 2018-09-14.
 */
app.controller('invoice_printinv_confirm_controller', ['$scope', '$http', '$modal','$modalInstance','invoiceResult', function ($scope, $http, $modal,$modalInstance,invoiceResult) {

    $scope.invoiceResult = invoiceResult;

    $scope.confirm = function(){
        $modalInstance.close();
    }

}])
;