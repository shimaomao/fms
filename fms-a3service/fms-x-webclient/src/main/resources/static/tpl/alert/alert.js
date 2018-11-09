/**
 * Created by qiaohao on 2018/1/19.
 */
app.controller('modal_alert_controller', ['$scope', '$http','$modal', '$modalInstance','header','info', function ($scope, $http,$modal, $modalInstance,header,info) {

    $scope.header = header;
    $scope.info = info;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);
