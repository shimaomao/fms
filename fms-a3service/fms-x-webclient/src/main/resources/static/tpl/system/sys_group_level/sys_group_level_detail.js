/**
 * Created by wangxue on 2018/4/2.
 */

app.controller('sys_group_level_detail_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster, $location) {

    $scope.sysGroupLevel={};

    // 取得详情
    $http.get('sys_group_level/findSysGroupLevelById?groupLevId='+ $location.search()['groupLevId']).success(function(data){
        $scope.sysGroupLevel = data.data;
        $scope.sysGroupLevel.enableFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,$scope.sysGroupLevel.enableFlag);
    });

    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/system_sys_group_level_list");
    };
}]);