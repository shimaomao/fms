/**
 * Created by yanfengbo on 2018-04-10.
 */
app.controller('sys_log_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {

    $scope.sysLog={};
    $scope.frameTitle = $location.search()['frameTitle'];
    $scope.showCheck = $location.search()['operate']=='check'||false;

    if ($scope.showCheck) {
        $http.get('sys_log/findSysLogByLogId?logId='+$location.search()['logId']).success(function (data) {
            $scope.sysLog = data.data;

        })
    }


    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/system_sys_log_list");
    };

}]);


