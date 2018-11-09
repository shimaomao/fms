/**
 * Created by ningyangyang on 2018-09-17.
 * 展期申请审批
 */
app.controller('defer_task_detail_page_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http,$modal,toaster,$location) {

    //传递给子页面
    //$scope.$broadcast('deferTaskToSon', $scope.deferTask);

    $scope.deferTask={deferTaskNo:$location.search()['deferTaskNo'],contNo:$location.search()['contNo']};

    $scope.formValidate = false;

    $scope.submit = false;

    //从一览页面获取合同编号
    //$scope.contNo = $location.search()['contNo'];
    //$scope.deferTask.contNo = $scope.contNo;
    //taskId
    //$scope.taskId = $location.search()['taskId'];
    //taskNo
    //$scope.deferTaskNo = $location.search()['serviceId'];
    //任务主键
    //获取展期后合同信息
    $scope.getData = function () {
        $http.post('defer_task/findDeferTaskVoByContNo',$scope.deferTask).success(function(data){
            $scope.deferTaskVo = data.data;
            $scope.$broadcast('deferTaskToSon', $scope.deferTaskVo);
        });
        //获取展期前合同信息
        $http.post('defer_task/findOldDeferTaskVoByContNo',$scope.deferTask).success(function(data){
            $scope.defer = data.data;
            $scope.$broadcast('deferTaskToSonSecond', $scope.defer);
        });
    }

    $scope.getData();
    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(){

        $location.path('app/postbiz_basic_change_task_list');

    };

}]);


