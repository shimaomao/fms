/**
 * Created by qiaohao on 2018/3/20.
 */
app.controller('act_user_leave_save_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.task = {taskId : $location.search()['taskId'],serviceId:$location.search()['serviceId'],taskDefinitionKey:$location.search()['taskDefinitionKey']};

    $http.get('act_user_leave/findActUserLeaveByLeaveId?leaveId=' + $scope.task.serviceId).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.actUserLeave = data.data;
        }
        else
            modalAlert($modal,data.message);
    }).error(function(data){
        modalAlert($modal,data);
    })

    $scope.save = function(){
        $http.post('act_user_leave/adopt?taskId='+$scope.task.taskId).success(function(data){
            if (data.code == Response.successCode) {
                $location.path("/app/home").search({type:'homeToastInfo', msg:'审批成功'});
            }
            else
                modalAlert($modal,data.message);
        }).error(function(data){
            modalAlert($modal,data);
        })
    }

    $scope.goBack = function(){
        $location.path("/app/home");
    }

}]);