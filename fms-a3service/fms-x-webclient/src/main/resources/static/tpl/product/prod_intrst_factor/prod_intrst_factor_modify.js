/**
 * Created by niehaibing on 2018-03-27.
 */
app.controller('prod_intrst_factor_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','prodIntrstFactorId', function ($scope, $http,$modal, $modalInstance,toaster,prodIntrstFactorId) {

    $scope.prodIntrstFactor={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('prod_intrst_factor/findProdIntrstFactorByProdIntrstFactorId?prodIntrstFactorId='+ prodIntrstFactorId).success(function(data){
        $scope.prodIntrstFactor = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('prod_intrst_factor/modifyProdIntrstFactor', $scope.prodIntrstFactor).success(function (data) {
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


