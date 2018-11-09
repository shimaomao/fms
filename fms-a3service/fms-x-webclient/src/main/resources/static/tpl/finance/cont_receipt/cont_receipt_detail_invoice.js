/**
 * Created by yanfengbo
 */
app.controller('cont_receipt_detail_invoice_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal, toaster,$location) {
    $scope.contRepaySkedVo={};
    $scope.formValidate = false;
    $scope.submit = false;

    $scope.frameTitle=$location.search()['frameTitle'];


    $http.get('cont_repay_sked/findContReceiptDetailByContReceiptExamId?contReceiptExamId='+ $location.search()['contReceiptExamId']).success(function(data){
        $scope.contRepaySkedVo = data.data;
        console.log(data.data)
    });


    /**
     * 开具发票
     */
    $scope.update = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.put('cont_repay_sked/contReceiptDetailInvoice', $scope.contRepaySkedVo).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("app/finance_cont_receipt_detail_list").search({messageType:'InvoiceSuccess'});
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
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/finance_cont_receipt_detail_list");
    };
}]);


