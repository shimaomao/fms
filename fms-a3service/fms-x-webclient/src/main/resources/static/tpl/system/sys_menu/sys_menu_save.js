/**
 * Created by ningyangyang on 2018-03-07.
 */
app.controller('sys_menu_save_controller', ['$scope', '$http','$modal','toaster', '$location',function ($scope, $http,$modal,toaster,$location) {

    $scope.sysMenu={
    };


    $scope.formValidate = false;

    $scope.submit = false;
    //启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);
    //菜单等级
    $scope.menuLevels = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.menuLevel);
    $scope.sysResParents = [];

    var parMenuInfo = "---请选择父级菜单---";
    $scope.parMenuInfoTmp = parMenuInfo;


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
     * 保存组织机构属性信息
     */
    $scope.save = function () {
        if(!$scope.form.$invalid) {
            if ($scope.sysMenu.menuLevel != 1 && $scope.sysMenu.parMenuId == null) {
                modalAlert($modal, "请填写正确信息");
            }
            // else if ($scope.sysMenu.menuLevel != 1 && $scope.sysMenu.menuLink ==null) {
            //     modalAlert($modal, '请填写正确信息');
            // }
            else{
                $scope.submit = true;
            $http.post('sys_menu/saveSysMenu', $scope.sysMenu).success(function (data) {
                if (data.code == Response.successCode) {
                    $location.path("app/system_sys_menu_list").search({type:'save'});
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


    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/system_sys_menu_list");
    };

}]);


