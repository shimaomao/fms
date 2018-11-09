/**
 * Created by yanfengbo on 2018-03-09.
 */
app.controller('sys_param_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {

    $scope.sysParam={};


    $scope.frameTitle=$location.search()['frameTitle'];

    $scope.showCheck=$location.search()['operate']=='check'||false;

    if ($scope.showCheck) {

        $http.get('sys_param/findSysParamByParamKeyId?paramKeyId='+ $location.search()['paramKeyId']).success(function(data){
            $scope.sysParam = data.data;
        });
    }



    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/system_sys_param_list");
    };

}]);


