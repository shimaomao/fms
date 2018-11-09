/**
 * Created by ningyangyang on 2018/3/20.
 */


app.controller('sys_user_handler_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http, $modal, toaster,$location) {

    $scope.sysUser ={
        certifType:0,
        validMenuType:0,

    };
    $scope.sysUser.enableFlag = 0;
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.frmWidgetId = $location.search()['frmWidgetId'];
    $scope.showSaveButton = $scope.frmWidgetId == common_frame_widget_id.F000641;
    $scope.showModifySaveButton = $scope.frmWidgetId == common_frame_widget_id.F000642;
    $scope.frameTitle = consNameById($scope.frmWidgetId);
    $scope.itemWidgetMap = consItemWidgetMap($scope.frmWidgetId);
    // 启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);
    //consValueArr(common_constant_code.common_status);
    //性别
    $scope.genderList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gender)
    //consValueArr(common_constant_code.gender);
    //菜单权限类型
    $scope.validMenuTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.sys_validMenuType)
    //consValueArr(common_constant_code.sys_validMenuType)
    var str ='';
    if ($scope.frmWidgetId == common_frame_widget_id.F000642 || $scope.frmWidgetId == common_frame_widget_id.F000643) {
        // 编辑和详情
        $http.get('sys_user/findSysUserVoById?userId='+ $location.search()['userId']).success(function(data){
           //console.log(data.data)
            $scope.sysUser = data.data
            $scope.rolenames = $scope.sysUser.roles;
            var str ='';
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
                //consValue(common_constant_code.common_status,$scope.sysUser.enableFlag);
            $scope.sysUser.userGender = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gender,$scope.sysUser.sex)
                //consValue(common_constant_code.gender,$scope.sysUser.sex);
            $scope.sysUser.userValidMenuType = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.sys_validMenuType,$scope.sysUser.validMenuType)
                //consValue(common_constant_code.sys_validMenuType,$scope.sysUser.validMenuType);
        });
    }

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;
                   $scope.sysUser.roles =  $scope.rolenames
                   console.log($scope.sysUser)
            $http.post('sys_user/saveSysUser', $scope.sysUser).success(function (data) {
                if (data.code == Response.successCode){

                    toaster_success('添加菜单成功',toaster);
                    $location.path("app/system_sys_user_list");
                }

                else{
                    modalAlert($modal,data.message);
                    $scope.sysUser.roles = str;
                    $scope.submit = false;
                }
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
     * 修改信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

                $scope.submit = true;
                $scope.sysUser.roles =  $scope.rolenames
                $http.put('sys_user/modifySysUser', $scope.sysUser).success(function (data) {
                    if (data.code == Response.successCode){

                        toaster_success('编辑菜单成功',toaster);
                        $location.path("app/system_sys_user_list");
                    }

                    else
                        modalAlert($modal, data.message);
                    $scope.submit = false;
                }).error(function (data) {
                    modalAlert($modal, data);
                    $scope.submit = false;
                })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }


    };
     //选择用户组
    $scope.selectSysUserGroup = function (index) {
        var parentType = index;
        var rtn = $modal.open({

            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_group/sys_group_list_select.html?datetime='+getTimestamp(),
            controller: 'sys_group_list_select_controller',
            resolve:{
                parentType:function () {
                    return index;
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.sysUser.groupCode = data.groupName;
            }
        },function(){

        });

    }
    //选择角色
    $scope.selectSysUserRoles = function () {
        var rtn = $modal.open({

            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_role/sys_role_list_select.html?datetime='+getTimestamp(),
            controller: 'sys_role_list_select_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {

            if(data != null) {
                $scope.rolenames = data;
                for( var i in data ){
                    if(i == data.length-1){
                        str = str+data[i].roleName
                    }else{
                        str = str+data[i].roleName+','
                    }
                }
              $('#userRoles').val(str)
                $scope.sysUser.roles = str;
            }
        },function(){

        });


    }
    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("app/system_sys_user_list");
    };

}]);