/**
 * Created by ningyangyang on 2018-03-26.
 */
app.controller('cstm_pers_mate_detail_controller', ['$scope', '$http','$modal', '$modalInstance','cstmPersMate', function ($scope, $http,$modal, $modalInstance,cstmPersMate) {

    $scope.cstmPersMate=cstmPersMate;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


