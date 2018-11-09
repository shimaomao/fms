'use strict';

// signup controller
app.controller('SignupFormController', ['$scope', '$http', '$state', function($scope, $http, $state) {
    $scope.user = {};
    $scope.authError = null;
    $scope.signup = function() {

      $scope.authError = null;
      // Try to create
      $http.post('/sys_user/register', $scope.user)
      .then(function(response) {
          if(response.data.code = "00000000"){
              $state.go('access.signin');
          }else{
              $scope.authError = response;
          }
      }, function(x) {
        $scope.authError = 'Server Error';
      });
    };
  }])
 ;