/**
 * Created by ningyangyang on 2018-03-15.
 */
app.controller('sys_role_menu_detail_controller', ['$scope', '$http','$modal', '$modalInstance','sysRoleMenu', function ($scope, $http,$modal, $modalInstance,sysRoleMenu) {

    $scope.sysRoleMenu=sysRoleMenu;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


