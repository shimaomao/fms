/**
 * Created by ningyangyang on 2018-09-01.
 * 展期申请审批
 */
app.controller('defer_task_approve_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http,$modal,toaster,$location) {

    //$scope.deferTask={taskId:$location.search()['taskId'],deferTaskNo:$location.search()['serviceId']};

    // $scope.formValidate = false;
    //
    // $scope.submit = false;

    //从一览页面获取合同编号
    //$scope.contNo = $location.search()['contNo'];
    //$scope.deferTask.contNo = $scope.contNo;
    //taskId
    // $scope.taskId = $location.search()['taskId'];
    // //taskNo
    // $scope.deferTaskNo = $location.search()['serviceId'];
    // //获取展期合同信息
    // $http.post('defer_task/findDeferTaskVoByContNo',$scope.deferTask).success(function(data){
    //     $scope.deferTask = data.data;
    // });
    //接受值
    $scope.$on('deferTaskToSon',function (e,data) {
        $scope.deferTask = data;
        $scope.deferTaskNo = $scope.deferTask.deferTaskNo;
    });

    //合同详情
    $scope.contractDetails = function () {
        var id = $scope.deferTask.contNo;
        var url = 'app.prebiz_apply_input_detail?applyNo=' + $scope.deferTask.applyNo
            + '&contNo=' +$scope.deferTask.contNo
            + '&applyType=' +$scope.deferTask.applyType
            + '&type=contract'
            + '&contractDate=' +$scope.contractDate
            + '&bizStatus=' +$scope.bizStatus
            + '&isTab=true';
        var title = '合同详情';
        var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
        if(window.parent.addTab){
            window.parent.addTab(html);
        }
    }

    //查看还款计划表
    $scope.overdueSales = function () {
        var contNo = $scope.deferTask.contNo;
        if(contNo){
            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/postbiz/overdue_cstm/overdue_sales.html'+getCacheTime(),
                controller: 'overdue_sales_controller',
                resolve:{
                    paramsData: function () {
                        return {
                            "contNo": contNo
                        }
                    }
                }
            });
            rtn.result.then(function (data) {

            },function(){

            });
        } else{
            modalAlert($modal,'合同号不存在！');
        }
    };

}]);


