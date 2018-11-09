/**
 * Created by qiaohao on 2018/1/19.
 */
app.controller('sys_user_modify_pwd_controller', ['$scope', '$http','$modal', '$modalInstance','toaster' ,'sysUserId', function ($scope, $http,$modal, $modalInstance,toaster,sysUserId) {

    $scope.sysUser={id:sysUserId};

    $scope.formValidate = false;

    /**
     * 保存用户信息
     */
    $scope.modify = function () {
        if(!$scope.form.$invalid) {
            $http.put('sys_user/modifySysUserPwd', $scope.sysUser).success(function (data) {
                if (data.code == Response.successCode)
                    $scope.close(Response.successMark);
                else
                    modalAlert($modal,data.message);
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



