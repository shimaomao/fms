/**
 * Created by ningyangyang on 2018/3/12.
 */

app.controller('sys_role_handler_controller', ['$scope', '$http','$modal','toaster','$location' ,function ($scope, $http, $modal, toaster,$location) {


    $scope.sysRole ={};

    $scope.formValidate = false;

     $scope.submit = false;

    $scope.frmWidgetId = $location.search()['frmWidgetId'];
    console.log($scope.frmWidgetId);




    $scope.showSaveButton = $scope.frmWidgetId == common_frame_widget_id.F000620;
    $scope.showModifySaveButton = $scope.frmWidgetId == common_frame_widget_id.F000621;
     // 取得画面项目权限
    $scope.itemWidgetMap = consItemWidgetMap($scope.frmWidgetId);
    // 画面名称
    $scope.frameTitle = consNameById($scope.frmWidgetId);
    if ($scope.frmWidgetId == common_frame_widget_id.F000621||$scope.frmWidgetId == common_frame_widget_id.F000622) {
        // 编辑用户组层级
        $http.get('sys_role/findSysRoleById?roleId='+$location.search()['roleId']).success(function(data){
            $scope.sysRole = data.data;
            $scope.sysRole.enableFlagVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.common_status,$scope.sysRole.enableFlag)
                //consValue(common_constant_code.common_status,$scope.sysRole.enableFlag);

        });
    }
    // 启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.common_status)
        //consValueArr(common_constant_code.common_status);



    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('sys_role/saveSysRole', $scope.sysRole).success(function (data) {
                if (data.code == Response.successCode){

                    toaster_success('添加角色成功',toaster);
                    $location.path("app/system_sys_role_list");
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
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('sys_role/modifySysRole', $scope.sysRole).success(function (data) {
                if (data.code == Response.successCode){
                    toaster_success('添加角色成功',toaster);
                    $location.path("app/system_sys_role_list");
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