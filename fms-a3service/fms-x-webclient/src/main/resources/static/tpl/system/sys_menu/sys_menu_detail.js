/**
 * Created by ningyangyang on 2018-03-07.
 */
app.controller('sys_menu_detail_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {


    $scope.sysMenu ={};
    $scope.formValidate = false;
    $scope.submit = false;
        // 编辑和详情

    $scope.sysMenu=$location.search()['SysMenu'];
    $scope.sysMenu.menuLevel = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.menuLevel,$scope.sysMenu.menuLevel);
    $scope.sysMenu.enableFlag = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,$scope.sysMenu.enableFlag);
    /**
     * 关闭窗口
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/system_sys_menu_list");
    };

}]);


