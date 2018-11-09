/**
 * Created by lijunjun on 2018-05-23.
 */
app.controller('quotation_device_detail_controller', ['$scope', '$http','$modal', '$modalInstance','quotationDevice', function ($scope, $http,$modal, $modalInstance,quotationDevice) {

    $scope.quotationDevice=quotationDevice;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


