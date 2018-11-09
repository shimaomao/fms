/**
 * Created by ningyangyang on 2018-05-25.
 */
app.controller('common_borrower_save_controller', ['$scope', '$http','$modal', '$modalInstance','toaster', function ($scope, $http,$modal, $modalInstance,toaster) {

    $scope.commonBorrower={};

    $scope.formValidate = false;

    $scope.submit = false;


    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('common_borrower/saveCommonBorrower', $scope.commonBorrower).success(function (data) {
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


