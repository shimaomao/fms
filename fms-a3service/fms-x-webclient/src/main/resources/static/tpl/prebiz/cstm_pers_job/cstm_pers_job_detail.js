/**
 * Created by ningyangyang on 2018-03-26.
 */
app.controller('cstm_pers_job_detail_controller', ['$scope', '$http','$modal', '$modalInstance','cstmPersJob', function ($scope, $http,$modal, $modalInstance,cstmPersJob) {

    $scope.cstmPersJob=cstmPersJob;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


