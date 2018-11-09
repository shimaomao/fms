/**
 * Created by yangyiquan on 2018-05-31.
 */
app.controller('pilfer_insurance_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','pilferInsuranceId', function ($scope, $http,$modal, $modalInstance,toaster,pilferInsuranceId) {

    $scope.pilferInsurance={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('pilfer_insurance/findPilferInsuranceByPilferInsuranceId?pilferInsuranceId='+ pilferInsuranceId).success(function(data){
        $scope.pilferInsurance = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('pilfer_insurance/modifyPilferInsurance', $scope.pilferInsurance).success(function (data) {
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


