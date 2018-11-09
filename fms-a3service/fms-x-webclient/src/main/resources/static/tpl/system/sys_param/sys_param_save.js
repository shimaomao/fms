

app.controller('sys_param_save_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http, $modal, toaster,$location) {

    $scope.sysParam={};
    $scope.formValidate = false;
    $scope.submit = false;

    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    $scope.showCheck=$location.search()['operate']=='check'||false;

    $scope.save = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.post('sys_param/saveSysParam', $scope.sysParam).success(function (data) {
                if (data.code == Response.successCode){
                    CommonCodeUtils.setCommonParamValues(data.data);
                    $location.path("app/system_sys_param_list").search({messageType:'saveSysParam'});
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
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/system_sys_param_list");
    };
}]);
