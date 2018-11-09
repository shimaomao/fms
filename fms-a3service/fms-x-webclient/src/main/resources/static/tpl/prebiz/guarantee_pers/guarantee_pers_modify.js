/**
 * Created by ningyangyang on 2018-03-30.
 */
app.controller('guarantee_pers_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','guarPersId', function ($scope, $http,$modal, $modalInstance,toaster,guarPersId) {

    $scope.guaranteePers={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('guarantee_pers/findGuaranteePersByGuarPersId?guarPersId='+ guarPersId).success(function(data){
        $scope.guaranteePers = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('guarantee_pers/modifyGuaranteePers', $scope.guaranteePers).success(function (data) {
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


