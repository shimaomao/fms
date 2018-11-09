/**
 * Created by qiaomengnan on 2018-03-26.
 */
app.controller('financial_voucher_assis_detail_controller', ['$scope', '$http', '$modal','$modalInstance', 'toaster','$compile','$location','voucherDataId', function ($scope, $http, $modal,$modalInstance, toaster,$compile,$location,voucherDataId) {

    $scope.finVouAssisList = [];

    $http.get('financial_voucher_data/findFinVouAssisVosByVouDataId?voucherDataId=' + voucherDataId).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.finVouAssisList = data.data;
        } else
            modalAlert($modal,data.message);
    }).error(function(data){
        modalAlert($modal,data);
    })

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close(null);
    };

}])
;