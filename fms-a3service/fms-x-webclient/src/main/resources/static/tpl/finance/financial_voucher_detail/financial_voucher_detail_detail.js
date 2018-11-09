/**
 * Created by ningyangyang on 2018-06-20.
 */
app.controller('financial_voucher_detail_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {


    $scope.financialVoucherDetail={};

    $scope.voucherDetailId = $location.search()['voucherDetailId'];
    $http.get('financial_voucher_detail/findFinancialVoucherDetailByVoucherDetailId?voucherDetailId='+ $scope.voucherDetailId).success(function(data){
        $scope.financialVoucherDetail = data.data;
        $scope.financialVoucherDetail.crdrFlagName =   CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.crdrFlag,$scope.financialVoucherDetail.crdrFlag)
        $scope.financialVoucherDetail.cycleFlagName =   CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.cycleFlag,$scope.financialVoucherDetail.cycleFlag)
    });

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(){
        $location.path('app/financial_voucher_detail_list');
    };
}]);


