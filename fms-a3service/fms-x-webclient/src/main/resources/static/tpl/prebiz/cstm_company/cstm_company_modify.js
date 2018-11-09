/**
 * Created by ningyangyang on 2018-03-27.
 */
app.controller('cstm_company_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','cstmCompanyId', function ($scope, $http,$modal, $modalInstance,toaster,cstmCompanyId) {

    $scope.cstmCompany={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('cstm_company/findCstmCompanyByCstmCompanyId?cstmCompanyId='+ cstmCompanyId).success(function(data){
        $scope.cstmCompany = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('cstm_company/modifyCstmCompany', $scope.cstmCompany).success(function (data) {
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


