/**
 * Created by lijunjun on 2018-09-12.
 */
app.controller('lawsuit_register_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','lawsuitRegisterId', function ($scope, $http,$modal, $modalInstance,toaster,lawsuitRegisterId) {

    $scope.lawsuitRegister={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('lawsuit_register/findLawsuitRegisterByLawsuitRegisterId?lawsuitRegisterId='+ lawsuitRegisterId).success(function(data){
        $scope.lawsuitRegister = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('lawsuit_register/modifyLawsuitRegister', $scope.lawsuitRegister).success(function (data) {
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


