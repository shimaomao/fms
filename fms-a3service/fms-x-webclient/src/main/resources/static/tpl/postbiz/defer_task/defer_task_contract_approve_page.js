/**
 * Created by ningyangyang on 2018-09-01.
 * 展期申请合同审核
 */
app.controller('defer_task_contract_approve_page_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http,$modal,toaster,$location) {

    //接受子页面的值
    $scope.$on('deferTaskToFather',function (e,data) {
        $scope.deferTask = data;

    });
    $scope.$broadcast('deferTaskToSon', $scope.deferTask);

    $scope.deferTask={taskId:$location.search()['taskId'],deferTaskNo:$location.search()['serviceId'],taskDefinitionKey:$location.search()['taskDefinitionKey']};

    $scope.formValidate = false;

    $scope.submit = false;

    //从一览页面获取合同编号
    //$scope.contNo = $location.search()['contNo'];
    //$scope.deferTask.contNo = $scope.contNo;
    //taskId
    $scope.taskId = $location.search()['taskId'];
    //taskNo
    $scope.deferTaskNo = $location.search()['serviceId'];
    //任务主键
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];
    //获取展期合同信息
    $http.post('defer_task/findDeferTaskVoByContNo',$scope.deferTask).success(function(data){
        $scope.deferTask = data.data;
    });

    /**
     * 提交展期合同信息
     */
    $scope.approveDeferContract = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;
            // if($scope.deferTask.notUpload){
            //     modalAlert($modal,$scope.deferTask.notUploadInfo);
            //     $scope.submit = false;
            //     return false;
            // }
            //taskId
            $scope.deferTask.taskId = $scope.taskId;
            //taskNo
            $scope.deferTask.deferTaskNo = $scope.deferTaskNo;
            $http.put('defer_task/approveDeferContract', $scope.deferTask).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path('/app/home').search({"type": 'homeToastInfo',"msg":'展期合同审核成功'});//我的任务页面

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
    }
    /**
     * 退回操作
     */
    $scope.sendBack = function(){
        $scope.submit = true;
        if(isUndefinedNull($scope.deferTask.memo)){
            toaster_info('请输入备注',toaster);
            $scope.submit = false;
            return false;
        }
        //taskId
        $scope.deferTask.taskId = $scope.taskId;
        //taskNo
        $scope.deferTask.deferTaskNo = $scope.deferTaskNo;
        //退回操作
        $http.put('defer_task/sendBack', $scope.deferTask).success(function (data) {
            if (data.code == Response.successCode){
                $location.path('/app/home').search({"type": 'homeToastInfo',"msg":'退回成功'});//我的任务页面
            }
            else
                modalAlert($modal,data.message);
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    }
    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(){
        if($scope.taskId){
            $location.path('/app/home');
        }else{

        }
    };
}]);


