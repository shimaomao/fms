app.controller('sys_role_handler_controller', ['$scope', '$http','$modal','toaster','$location' ,function ($scope, $http, $modal, toaster,$location) {


    $scope.sysRole ={};

    $scope.formValidate = false;

    $scope.submit = false;

        // 编辑用户组层级
        $http.get('sys_role/findSysRoleById?roleId='+$location.search()['roleId']).success(function(data){
            $scope.sysRole = data.data;
            $scope.sysRole.enableFlagVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.common_status,$scope.sysRole.enableFlag)

        });

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(status){
        $location.path('app/system_sys_role_list');
    };

}]);