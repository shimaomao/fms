/**
 * Created by yangyiquan on 2018-09-10.
 */
app.controller('invoice_auto_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','invoiceAutoId', function ($scope, $http,$modal, $modalInstance,toaster,invoiceAutoId) {

    $scope.invoiceAuto={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('invoice_auto/findInvoiceAutoByInvoiceAutoId?invoiceAutoId='+ invoiceAutoId).success(function(data){
        $scope.invoiceAuto = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('invoice_auto/modifyInvoiceAuto', $scope.invoiceAuto).success(function (data) {
                if (data.code == Response.successCode)
                    $scope.close(Response.successMark);
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
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


