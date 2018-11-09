/**
 * Created by ningyangyang on 2018-06-20.
 */
app.controller('financial_voucher_modify_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.financialVoucher={};

    $scope.formValidate = false;
    $scope.voucherType = $location.search()['voucherType'];
    $scope.submit = false;
    $http.get('financial_voucher/findFinancialVoucherByVoucherId?voucherType='+ $scope.voucherType).success(function(data){
        $scope.financialVoucher = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('financial_voucher/modifyFinancialVoucher', $scope.financialVoucher).success(function (data) {
                if (data.code == Response.successCode){
                    modalAlert($modal,Response.successMessage);
                    $location.path('app/financial_voucher_detail_list');
                }
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }


    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(){
        $location.path('app/financial_voucher_detail_list');
    };

}]);


