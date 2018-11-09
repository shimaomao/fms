/**
 * Created by niehaibing on 2018-03-23.
 */
app.controller('product_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','productId', function ($scope, $http,$modal, $modalInstance,toaster,productId) {

    $scope.product={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('product/findProductByProductId?productId='+ productId).success(function(data){
        $scope.product = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('product/modifyProduct', $scope.product).success(function (data) {
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


