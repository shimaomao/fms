

app.controller('sys_param_modify_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    $scope.sysParam={};
    $scope.formValidate = false;
    $scope.submit = false;

    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    $scope.showCheck=$location.search()['operate']=='check'||false;

    if ($scope.showUpdate||$scope.showCheck) {
        $http.get('sys_param/findSysParamByParamKeyId?paramKeyId='+ $location.search()['paramKeyId']).success(function(data){
            $scope.sysParam = data.data;
        });
    }


    $scope.modify = function () {

        //从页面获取时间插件生成的日期
       /* $scope.sysParam.validStartDate = $("#validStartDate").val();

        $scope.sysParam.validEndDate = $("#validEndDate").val();*/

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.put('sys_param/modifySysParam', $scope.sysParam).success(function (data) {
                if (data.code == Response.successCode){
                    CommonCodeUtils.setCommonParamValues(data.data);
                    $location.path("app/system_sys_param_list").search({messageType:'modifySysParam'});
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
