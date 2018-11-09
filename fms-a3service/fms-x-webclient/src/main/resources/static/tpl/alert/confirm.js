/**
 * Created by qiaohao on 2018/1/19.
 */
app.controller('modal_confirm_controller', ['$scope', '$http','$modal', '$modalInstance','header','info', function ($scope, $http,$modal, $modalInstance,header,info) {

    $scope.header = header;
    $scope.info = info;
    $scope.infoList = [];
    if($scope.info && $scope.info.indexOf("<br>")>0) {
        $scope.infoList = $scope.info.split("<br>");
    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

    $scope.cancel = function(status){
        $modalInstance.dismiss(status);
    };

}]);
