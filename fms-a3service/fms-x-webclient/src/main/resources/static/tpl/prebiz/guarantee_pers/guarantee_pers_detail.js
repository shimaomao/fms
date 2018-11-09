/**
 * Created by ningyangyang on 2018-03-30.
 */
app.controller('guarantee_pers_detail_controller', ['$scope', '$http','$modal', '$modalInstance','guaranteePers', function ($scope, $http,$modal, $modalInstance,guaranteePers) {

    $scope.guaranteePers=guaranteePers;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


