/**
 * Created by ningyangyang on 2018-03-26.
 */
app.controller('cstm_pers_addr_detail_controller', ['$scope', '$http','$modal', '$modalInstance','cstmPersAddr', function ($scope, $http,$modal, $modalInstance,cstmPersAddr) {

    $scope.cstmPersAddr=cstmPersAddr;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


