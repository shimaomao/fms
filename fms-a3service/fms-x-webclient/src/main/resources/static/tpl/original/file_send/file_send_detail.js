/**
 * Created by ningyangyang on 2018-05-04.
 */
app.controller('file_send_detail_controller', ['$scope', '$http','$modal', '$modalInstance','fileSend', function ($scope, $http,$modal, $modalInstance,fileSend) {

    $scope.fileSend=fileSend;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


