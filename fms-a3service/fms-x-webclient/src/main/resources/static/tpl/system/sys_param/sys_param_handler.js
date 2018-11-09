

app.controller('sys_param_handler_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    $scope.sysParam={};

    $scope.formValidate = false;

    $scope.submit = false;

    /*$scope.frmWidgetId = $location.search()['frmWidgetId'];
    console.log($scope.frmWidgetId);
    $scope.showSaveButton = $scope.frmWidgetId == common_frame_widget_id.F000801;
    $scope.showModifySaveButton = $scope.frmWidgetId == common_frame_widget_id.F000802;
    // 画面名称
    $scope.frameTitle = consNameById($scope.frmWidgetId);*/

    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    $scope.showCheck=$location.search()['operate']=='check'||false;


   /* if ($scope.frmWidgetId == common_frame_widget_id.F000802 || $scope.frmWidgetId == common_frame_widget_id.F000803) {
        // 编辑和详情
        $http.get('sys_param/findSysParamByParamKeyId?paramKeyId='+ $location.search()['paramKeyId']).success(function(data){
            $scope.sysParam = data.data;
        });
    }*/


    if ($scope.showUpdate||$scope.showCheck) {
        $http.get('sys_param/findSysParamByParamKeyId?paramKeyId='+ $location.search()['paramKeyId']).success(function(data){
            $scope.sysParam = data.data;
        });
    }

    /*// 取得画面项目权限
    $scope.itemWidgetMap = consItemWidgetMap($scope.frmWidgetId);*/

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        //从页面获取时间插件生成的日期
        $scope.sysParam.validStartDate = $("#validStartDate").val();

        $scope.sysParam.validEndDate = $("#validEndDate").val();

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('sys_param/saveSysParam', $scope.sysParam).success(function (data) {
                if (data.code == Response.successCode){
                    toaster_success('添加用户组层级成功',toaster);
                    $location.path("app/system_sys_param_list");
                }

                else{
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
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        //从页面获取时间插件生成的日期
        $scope.sysParam.validStartDate = $("#validStartDate").val();

        $scope.sysParam.validEndDate = $("#validEndDate").val();

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('sys_param/modifySysParam', $scope.sysParam).success(function (data) {
                if (data.code == Response.successCode){
                    toaster_success('编辑用户组层级成功',toaster);
                    $location.path("app/system_sys_param_list");
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
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/system_sys_param_list");
    };
}]);
