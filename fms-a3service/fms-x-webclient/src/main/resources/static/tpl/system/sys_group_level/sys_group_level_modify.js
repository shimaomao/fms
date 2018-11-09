/**
 * Created by wangxue on 2018/4/2.
 */

app.controller('sys_group_level_modify_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster, $location) {

    $scope.sysGroupLevel={};

    $scope.formValidate = false;

    $scope.submit = false;

    // 编辑和详情
    $http.get('sys_group_level/findSysGroupLevelById?groupLevId='+ $location.search()['groupLevId']).success(function(data){
        $scope.sysGroupLevel = data.data;
        $scope.sysGroupLevel.enableFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,$scope.sysGroupLevel.enableFlag);
    });

    // 启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);

    /**
     * 修改用户组层级信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('sys_group_level/modifySysGroupLevel', $scope.sysGroupLevel).success(function (data) {
                if (data.code == Response.successCode) {
                    // toaster_success('编辑用户组层级成功',toaster);
                    $location.path("app/system_sys_group_level_list").search({type: 'modify'});
                } else {
                    modalAlert($modal,data.message);
                }
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
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/system_sys_group_level_list");
    };
}]);