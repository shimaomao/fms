'use strict';

/* Controllers */
  // signin controller
app.controller('UpdatePSWController', ['$scope', '$http', '$state','$localStorage','$modal', function($scope, $http, $state,$localStorage,$modal) {
    $scope.sysUser = {userId:$localStorage.user.userId};
    $scope.authError = null;

    $scope.close = function(){
        $scope.authError = null;
    };
    // 获取验证码
    $scope.updatePsw = function(){
        if(!$scope.form.$invalid) {
            if($scope.sysUser.userPassword!=$scope.sysUser.userPasswordConfirm){
                modalAlert($modal,'两次密码输入不一致！');
                return;
            }
            $http.get('sys_user/getPasswordEncoder?password='+$scope.sysUser.userPasswordOld+'&passwordold='+$localStorage.user.userPassword).success(function (data) {
                if(!data.data){
                    modalAlert($modal,'原密码错误！');
                    return;
                }else{
                        $http.put('sys_user/modifySysUserPwd', $scope.sysUser).success(function (data) {
                        if (data.code == Response.successCode){
                            modalAlert($modal,'密码修改成功,请重新登录！');
                            parent.window.location.href="/#/access/signin";
                        }else{
                            modalAlert($modal,data.message);
                        }
                        $scope.submit = false;
                    }).error(function(data){
                        modalAlert($modal,data);
                        $scope.submit = false;
                    })
                }
            });
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }

    };

  }]);