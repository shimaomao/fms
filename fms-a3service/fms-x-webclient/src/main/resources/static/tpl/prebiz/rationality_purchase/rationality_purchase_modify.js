/**
 * Created by ningyangyang on 2018-05-29.
 */
app.controller('rationality_purchase_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','buyCarId', function ($scope, $http,$modal, $modalInstance,toaster,buyCarId) {

    $scope.rationalityPurchase={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('rationality_purchase/findRationalityPurchaseByBuyCarId?buyCarId='+ buyCarId).success(function(data){
        $scope.rationalityPurchase = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('rationality_purchase/modifyRationalityPurchase', $scope.rationalityPurchase).success(function (data) {
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


