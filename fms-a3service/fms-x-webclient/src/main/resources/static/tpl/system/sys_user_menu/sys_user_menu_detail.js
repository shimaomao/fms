/**
 * Created by ningyangyang on 2018-03-17.
 */
app.controller('sys_user_menu_detail_controller', ['$scope', '$http','$modal', '$modalInstance','sysUserMenu', function ($scope, $http,$modal, $modalInstance,sysUserMenu) {

    $scope.sysUserMenu=sysUserMenu;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


