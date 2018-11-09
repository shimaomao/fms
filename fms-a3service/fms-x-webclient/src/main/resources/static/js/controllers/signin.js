'use strict';

/* Controllers */
  // signin controller
app.controller('SigninFormController', ['$scope', '$http', '$state','$cookies', function($scope, $http, $state,$cookies) {
    $scope.user = {};
    $scope.authError = null;
    $scope.login = function() {
      $scope.authError = null;
      // Try to login
      $http.post('oauth2/get_token', $scope.user)
      .then(function(response) {
          var code = response.data.code;
          var access_token = response.data.data.access_token;
          if(code == Response.successCode && isNotUndefined(access_token) && isNotNull(access_token)){
              $cookies.put('access-user',access_token);
              $state.go('app.dashboard-v1');
          }else{
              $scope.authError = '用户名或密码错误';
          }
      }, function(x) {
        $scope.authError = '用户名或密码错误';
      });
    };
  }])
;