/**
 * Created by ningyangyang on 2018-06-20.
 */
app.controller('financial_voucher_detail_controller', ['$scope', '$http','$modal', '$modalInstance','financialVoucher', function ($scope, $http,$modal, $modalInstance,financialVoucher) {

    $scope.financialVoucher=financialVoucher;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


