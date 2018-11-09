/**
 * Created by ningyangyang on 2018-03-30.
 */
app.controller('guarantee_comp_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','guarCompId', function ($scope, $http,$modal, $modalInstance,toaster,guarCompId) {

    $scope.guaranteeComp={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('guarantee_comp/findGuaranteeCompByGuarCompId?guarCompId='+ guarCompId).success(function(data){
        $scope.guaranteeComp = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('guarantee_comp/modifyGuaranteeComp', $scope.guaranteeComp).success(function (data) {
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


