/**
 *
 */

app.controller('sys_menu_handler_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {


    $scope.sysMenu ={};
    $scope.sysMenu.enableFlag = 0;
    $scope.formValidate = false;
    $scope.submit = false;

    $scope.frmWidgetId = $location.search()['frmWidgetId'];


    $scope.showSaveButton = $scope.frmWidgetId == common_frame_widget_id.F000601;
    $scope.showModifySaveButton = $scope.frmWidgetId == common_frame_widget_id.F000602;
    $scope.frameTitle = consNameById($scope.frmWidgetId);

    if ($scope.frmWidgetId == common_frame_widget_id.F000602) {
        // 编辑和详情
        $http.get('sys_menu/findSysMenuByMenuId?menuId='+ $location.search()['menuId']).success(function(data){
            $scope.sysMenu=data.data;
            if($scope.sysMenu.menuLevel!=1) {
                var level = $scope.sysMenu.menuLevel - 1;
                $http.get('sys_menu/findSysResourceIsParent?menuLevel=' + level).success(function (data) {
                    $scope.sysResParents = data.data;
                });
            }
            $scope.sysMenu.parMenuId = 0;

            //$scope.sysMenu.enableFlag = consValue(common_constant_code.common_status,$scope.sysMenu.enableFlag);
        });
    }else if($scope.frmWidgetId == common_frame_widget_id.F000603){
        $scope.sysMenu=$location.search()['SysMenu'];
        //$scope.sysMenu.enableFlag = consValue(common_constant_code.common_status,$scope.sysMenu.enableFlag);

    }else if($scope.frmWidgetId == common_frame_widget_id.F000601){

        $scope.sysMenu.menuLevel = 1;
        $scope.sysMenu.enableFlag = 0;
        $scope.sysMenu.parMenuId = 0;
    }

    // 取得画面项目权限
    $scope.itemWidgetMap = consItemWidgetMap($scope.frmWidgetId);
    // 启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.common_status)
        //consValueArr(common_constant_code.common_status);

    $scope.menuLevels = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.sys_resource_level);
        //consValueArr(common_constant_code.sys_resource_level);

    //$scope.menuLevels = resLevelDataTmp;

    $scope.sysResParents = [];



    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('sys_menu/saveSysMenu', $scope.sysMenu).success(function (data) {
                if (data.code == Response.successCode){

                    toaster_success('添加菜单成功',toaster);
                    $location.path("app/system_sys_menu_list");
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

            //alert(sysMenu.resLevel)
            if( $scope.sysMenu.menuLevel != 1 && $scope.sysMenu.parMenuId == 0){
                modalAlert($modal,"非一级菜单需要选择父级菜单");
            }else  if($scope.sysMenu.menuId == $scope.sysMenu.parMenuId){

                modalAlert($modal,"不能选择自己当做上级菜单");
            }
            else {
                $scope.submit = true;

                $http.put('sys_menu/modifySysMenu', $scope.sysMenu).success(function (data) {
                    if (data.code == Response.successCode){

                        toaster_success('编辑菜单成功',toaster);
                        $location.path("app/system_sys_menu_list");
                    }

                    else
                        modalAlert($modal, data.message);
                    $scope.submit = false;
                }).error(function (data) {
                    modalAlert($modal, data);
                    $scope.submit = false;
                })
            }
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }


    };

    //获取父类菜单
    $scope.resLevelChange = function(){

        var menuLv = parseInt($scope.sysMenu.menuLevel);
        if( menuLv != 0){
            var menuLevel = menuLv - 1;
            $http.get('sys_menu/findSysResourceIsParent?menuLevel='+menuLevel).success(function(data){
                $scope.sysResParents = data.data;
            });
        }else{
            $scope.sysResParents = [];
        }
    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/system_sys_menu_list");
    };

}]);