/**
 * Created by qiaohao on 2018/1/10.
 */
app.controller('sys_role_save_controller', ['$scope', '$http','$modal','toaster','$location' ,function ($scope, $http, $modal, toaster,$location) {


    $scope.sysRole ={};

    $scope.formValidate = false;

    $scope.submit = false;

    // 启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag)



    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('sys_role/saveSysRole', $scope.sysRole).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path("app/system_sys_role_list").search({type:'save'});
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


