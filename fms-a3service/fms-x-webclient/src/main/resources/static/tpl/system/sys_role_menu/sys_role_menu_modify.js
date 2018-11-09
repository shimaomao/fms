/**
 * Created by ningyangyang on 2018-03-15.
 */
app.controller('sys_role_menu_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','roleMenuId', function ($scope, $http,$modal, $modalInstance,toaster,roleMenuId) {

    $scope.sysRoleMenu={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('sys_role_menu/findSysRoleMenuByRoleMenuId?roleMenuId='+ roleMenuId).success(function(data){
        $scope.sysRoleMenu = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('sys_role_menu/modifySysRoleMenu', $scope.sysRoleMenu).success(function (data) {
                if (data.code == Response.successCode)
                    $scope.close(Response.successMark);
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }


    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


