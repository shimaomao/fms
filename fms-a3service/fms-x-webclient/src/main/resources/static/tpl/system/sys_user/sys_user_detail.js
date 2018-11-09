/**
 * Created by ningyangyang on 2018/3/20.
 */


app.controller('sys_user_detail_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http, $modal, toaster,$location) {

    $scope.sysUser ={
    };

    $scope.formValidate = false;
    $scope.submit = false;
    var str ='';
        // 详情
        $http.get('sys_user/findSysUserVoById?userId='+ $location.search()['userId']).success(function(data){
            //console.log(data.data)
            $scope.sysUser = data.data
            $scope.rolenames = $scope.sysUser.roles;
            for( var i in  $scope.sysUser.roles ){
                if(i ==  $scope.sysUser.roles.length-1){
                    str = str+ $scope.sysUser.roles[i].roleName
                }else{
                    str = str+ $scope.sysUser.roles[i].roleName+','
                }
            }
            $scope.sysUser.roles  = str;
            $scope.sysUser.userRoles = str;
            $scope.sysUser.enableFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.common_status,$scope.sysUser.enableFlag)
            $scope.sysUser.userGender = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gender,$scope.sysUser.sex)
            $scope.sysUser.userValidMenuType = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.sys_validMenuType,$scope.sysUser.validMenuType);
           $scope.sysUser.certifType = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType,$scope.sysUser.certifType);
            $scope.sysUser.userDeptLevelName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.userDeptLevel,$scope.sysUser.userDeptLevel)
        });




    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("app/system_sys_user_list");
    };

}]);