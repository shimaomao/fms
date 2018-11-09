/**
 * Created by qiaomengnan on 2018-03-05.
 */
app.controller('sys_file_detail_controller', ['$scope', '$http','$modal', '$modalInstance','sysFile', function ($scope, $http,$modal, $modalInstance,sysFile) {

    $scope.sysFile=sysFile;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


