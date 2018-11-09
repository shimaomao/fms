/**
 * Created by ningyangyang on 2018-09-01.
 * 展期申请提交
 */
app.controller('defer_task_apply_page_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http,$modal,toaster,$location) {

    //接受子页面的值
    $scope.$on('deferTaskToFather',function (e,data) {
        $scope.deferTask = data;
        if(!$scope.deferTask.deferMaturity){
            $scope.deferTask.deferMaturity = '';
        }
    });
    $scope.$broadcast('deferTaskToSon', $scope.deferTask);

    //taskId
    $scope.taskId = $location.search()['taskId'];
    //taskNo
    $scope.deferTaskNo = $location.search()['serviceId'];

    if(!$scope.taskId){
        $scope.deferTask={contNo:$location.search()['contNo'],taskId:$location.search()['taskId'],deferTaskNo:$location.search()['serviceId']};
    }else{
        $scope.deferTask={taskId:$location.search()['taskId'],deferTaskNo:$location.search()['serviceId']};
    }

    $scope.formValidate = false;

    $scope.submit = false;
    //contNo:$location.search()['contNo'],taskId:$location.search()['contNo'],deferTaskNo:$location.search()['serviceId']
    //从一览页面获取合同编号
    // $scope.contNo = $location.search()['contNo'];
    // $scope.deferTask.contNo = $scope.contNo;


    //获取展期合同信息
        $http.post('defer_task/findDeferTaskVoByContNo',$scope.deferTask).success(function(data){
            console.log(data.data)
            $scope.deferTask = data.data;
            if(!$scope.taskId){//taskId存在
                $scope.deferTask.deferDeposit = 0;
            }
            $scope.deferTask.backDeposit = $scope.deferTask.deposit*1 - $scope.deferTask.deferDeposit*1;
        });
    /**
     * 提交展期合同信息
     */
    $scope.submitDeferTaskApply = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;
            if($scope.deferTask.notUpload){
                modalAlert($modal,$scope.deferTask.notUploadInfo);
                $scope.submit = false;
                return false;
            }
            //合同号
            //$scope.deferTask.contNo = $scope.contNo;
            //taskId
            $scope.deferTask.taskId = $scope.taskId;
            //taskNo
            $scope.deferTask.deferTaskNo = $scope.deferTaskNo;
            $http.put('defer_task/submitDeferTaskApply', $scope.deferTask).success(function (data) {
                if (data.code == Response.successCode){
                    if(!$scope.deferTask.taskId){
                        $location.path('app/postbiz_basic_change_list').search({"type": 'submit',"msg":'合同展期申请提交成功'}); //共通页面
                    }else{
                        $location.path('/app/home').search({"type": 'homeToastInfo',"msg":'合同展期申请提交成功'});//我的任务页面
                    }
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
    //报价单计算
    $scope.quotationCalculate = function () {

    }
    //合同详情
    $scope.quotationCalculate = function () {

    }

    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(){
        if($scope.taskId){
            $location.path('/app/home');
        }else{
            $location.path('app/postbiz_basic_change_list');
        }
    };

}]);


