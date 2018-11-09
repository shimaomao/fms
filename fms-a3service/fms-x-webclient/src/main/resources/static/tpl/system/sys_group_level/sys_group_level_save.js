/**
 * Created by wangxue on 2018/4/2.
 */

app.controller('sys_group_level_save_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster, $location) {

    $scope.sysGroupLevel={};
    $scope.sysGroupLevel.enableFlag = '0';

    $scope.formValidate = false;

    $scope.submit = false;

    // 启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('sys_group_level/saveSysGroupLevel', $scope.sysGroupLevel).success(function (data) {
                if (data.code == Response.successCode){
                    // toaster_success('添加用户组层级成功',toaster);
                    $location.path("app/system_sys_group_level_list").search({type: 'save'});
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