angular.module('app')
  .directive('setNgAnimate', ['$animate', function ($animate) {
    return {
        link: function ($scope, $element, $attrs) {
            $scope.$watch( function() {
                return $scope.$eval($attrs.setNgAnimate, $scope);
            }, function(valnew, valold){
                $animate.enabled(!!valnew, $element);
            });
        }
    };
  }])
  .directive('repeatFinish', function ($timeout) {
      return {
          restrict: 'A',
          link: function(scope, element, attr) {
              if (scope.$last) {
                  $timeout(function() {
                      scope.$emit('ngRepeatFinished',element);
                  });
              }
          }
      }
  });