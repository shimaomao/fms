/**
 * Created by lijunjun on 2018-09-12.
 */
app.controller('lawsuit_register_detail_controller', ['$scope', '$http','$modal', '$modalInstance','lawsuitRegister', function ($scope, $http,$modal, $modalInstance,lawsuitRegister) {

    $scope.lawsuitRegister=lawsuitRegister;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


