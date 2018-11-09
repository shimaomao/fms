/**
 * Created by ningyangyang on 2018-03-07.
 */
app.controller('sys_menu_modify_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.sysMenu={
    };

    $scope.formValidate = false;

    $scope.submit = false;

    //启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);
    //菜单等级
    $scope.menuLevels = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.menuLevel);

    $scope.sysResParents = [];




    $http.get('sys_menu/findSysMenuByMenuId?menuId='+ $location.search()['menuId']).success(function(data){
        $scope.sysMenu = data.data;
        if($scope.sysMenu.menuLevel!=1) {
            var level = $scope.sysMenu.menuLevel - 1;
            $http.get('sys_menu/findSysResourceIsParent?menuLevel=' + level).success(function (data) {
                $scope.sysResParents = data.data;
            });
        }
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

          console.log($scope.sysMenu)
            if( ($scope.sysMenu.menuLevel != 1 && $scope.sysMenu.parMenuId == "")){
                modalAlert($modal,"请填写正确信息");
            }else  if($scope.sysMenu.menuId == $scope.sysMenu.parMenuId){
                modalAlert($modal,"不能选择自己当做上级菜单");
            }
            else {
                $scope.submit = true;

                $http.put('sys_menu/modifySysMenu', $scope.sysMenu).success(function (data) {
                    if (data.code == Response.successCode){
                        $location.path("app/system_sys_menu_list").search({type:'modify'});
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

    var parMenuInfo = "---请选择父级菜单---";
    $scope.parMenuInfoTmp = parMenuInfo;

    $scope.$watch('sysMenu.menuLevel',function(){
        if($scope.sysMenu.menuLevel != 1){
            $scope.parMenuInfoTmp = parMenuInfo;
        }else{
            $scope.parentIdInfo = "";
        }
    });

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/system_sys_menu_list");
    };
}]);


