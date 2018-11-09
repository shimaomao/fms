/**
 * Created by qiaohao on 2018/1/10.
 */
app.controller('sys_data_dictionary_detail_controller', ['$scope', '$http','$modal', '$modalInstance','sysDataDic', function ($scope, $http,$modal, $modalInstance,sysDataDic) {

    $scope.sysDataDic=sysDataDic;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


