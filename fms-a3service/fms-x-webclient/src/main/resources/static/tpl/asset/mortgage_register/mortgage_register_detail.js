/**
 * Created by yangyiquan on 2018-05-18.
 */
app.controller('mortgage_register_detail_controller', ['$scope', '$http','$modal', '$modalInstance','mortgageRegister', function ($scope, $http,$modal, $modalInstance,mortgageRegister) {

    $scope.mortgageRegister=mortgageRegister;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


