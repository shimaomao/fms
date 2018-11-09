app.controller('sys_role_modify_controller', ['$scope', '$http','$modal','toaster','$location' ,function ($scope, $http, $modal, toaster,$location) {


    $scope.sysRole ={};

    $scope.formValidate = false;

    $scope.submit = false;

    // 启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag)
    //consValueArr(common_constant_code.common_status);


    $http.get('sys_role/findSysRoleById?roleId='+$location.search()['roleId']).success(function(data) {
        $scope.sysRole = data.data;
    })
    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('sys_role/modifySysRole', $scope.sysRole).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path("app/system_sys_role_list").search({type:'modify'});
                }
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


    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(status){
        $location.path('app/system_sys_role_list');
    };

}]);