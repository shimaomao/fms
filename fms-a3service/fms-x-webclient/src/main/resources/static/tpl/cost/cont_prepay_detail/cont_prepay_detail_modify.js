/**
 * Created by yangyiquan on 2018-05-11.
 */
app.controller('cont_prepay_detail_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','contPrepayDetailId', function ($scope, $http,$modal, $modalInstance,toaster,contPrepayDetailId) {

    $scope.contPrepayDetail={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('cont_prepay_detail/findContPrepayDetailByContPrepayDetailId?contPrepayDetailId='+ contPrepayDetailId).success(function(data){
        $scope.contPrepayDetail = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('cont_prepay_detail/modifyContPrepayDetail', $scope.contPrepayDetail).success(function (data) {
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


