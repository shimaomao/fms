'use strict';

/* Controllers */
  // signin controller
app.controller('SigninFormController', ['$scope', '$http', '$state','$localStorage','$rootScope','$interval', function($scope, $http, $state,$localStorage,$rootScope,$interval) {
    $scope.user = {};
    $scope.authError = null;

    $scope.close = function(){
        $scope.authError = null;
    };

    // 获取验证码
    $scope.getVerifyCode = function(){
        $scope.timeStamp = new Date().getTime();
        $http.get('oauth2/findCodeByTimeStamp?timeStamp='+$scope.timeStamp).success(function(data){
            $scope.randomNum = data.data.data;
        })
    };
    $scope.getVerifyCode();

    $scope.login = function () {
        $scope.authError = null;
        // 页面输入验证
        if ('' == $scope.user.user||undefined == $scope.user.user) {
            $scope.authError = "请填写账号";
            return;
        }
        if ('' == $scope.user.userPassword||undefined == $scope.user.userPassword) {
            $scope.authError = "请填写密码";
            return;
        }
        if ('' == $scope.user.code||undefined == $scope.user.code) {
            $scope.authError = "请填写验证码";
            return;
        }
        $scope.user.timeStamp = $scope.timeStamp;
        // 用户登录
        doLogin();
    };

    function doLogin() {
      // Try to login
      $http.post('oauth2/get_token', $scope.user)
      .then(function(response) {
          var code = response.data.code;
          var access_token = response.data.data.access_token;
          if(code == Response.successCode && isNotUndefined(access_token) && isNotNull(access_token)){
              document.cookie="access-user="+access_token;

              $http.get('sys_user/findSysUserDetail')
                  .then(function(response) {
                      var user = response.data.data;
                      var menus = null;
                      if(user != null) {
                          $localStorage.user = user;
                          menus = user.sysMenus;
                      }
                      if(menus == null || menus.length <=0 ) {
                          $scope.authError = '没有权限访问该系统,请联系管理员';
                      }
                      else{
                          //initialCommonConstantValue();
                          CommonCodeUtils.initCommonCodeValues();
                          CommonCodeUtils.initCommonParamValues();
                          //initialCommonWidgetValue();
                          // $state.go('app.dashboard-v1');
                          //if($localStorage.user){
                              $rootScope.sysUserName = $localStorage.user.userName;
                          //}
                          $state.go('app_tpl.dashboard-v1');
                          // $rootScope.pageName = secondMenu.description;
                          // $state.go(secondMenu.res);
                      }
                  }, function(x) {
               });
          }else{
              $scope.authError = response.data.message;
          }

      }, function(x) {
        $scope.authError = '用户名或密码错误';
      });
    };


    //清空定时器
    $interval.cancel($rootScope.userInfoRequestTimer);

  }]);