/**
 * Created by ningyangyang on 2018-03-30.
 */
app.controller('guarantee_comp_detail_controller', ['$scope', '$http','$modal', '$modalInstance','guaranteeComp', function ($scope, $http,$modal, $modalInstance,guaranteeComp) {

    $scope.guaranteeComp=guaranteeComp;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


