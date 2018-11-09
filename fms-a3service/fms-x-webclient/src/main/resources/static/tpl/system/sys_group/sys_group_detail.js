/**
 * Created by wangxue on 2018/4/2.
 */

app.controller('sys_group_detail_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster, $location) {

    $scope.sysGroup={};

    // 取得用户组信息
    $http.get('sys_group/findSysGroupVoByGroupId?groupId='+ $location.search()['groupId']).success(function(data){
        $scope.sysGroup = data.data;
        $scope.sysGroup.enableFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,$scope.sysGroup.enableFlag);
    });

    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/system_sys_group_list");
    };

}]);