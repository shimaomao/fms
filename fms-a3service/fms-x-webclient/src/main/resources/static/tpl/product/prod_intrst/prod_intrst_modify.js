/**
 * Created by niehaibing on 2018-03-27.
 */
app.controller('prod_intrst_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','prodIntrstId', function ($scope, $http,$modal, $modalInstance,toaster,prodIntrstId) {

    $scope.prodIntrst={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('prod_intrst/findProdIntrstByProdIntrstId?prodIntrstId='+ prodIntrstId).success(function(data){
        $scope.prodIntrst = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('prod_intrst/modifyProdIntrst', $scope.prodIntrst).success(function (data) {
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


