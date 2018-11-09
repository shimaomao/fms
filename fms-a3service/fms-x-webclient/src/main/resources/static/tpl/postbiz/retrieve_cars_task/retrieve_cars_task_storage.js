/**
 * Created by ningyangyang on 2018/9/18.
 *  车辆入库
 */
app.controller('retrieve_cars_task_storage_controller',['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout',function($scope, $http, $modal, toaster,$compile,$location,$timeout){

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.retrieveCarTaskNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.retrieveCarsTask = {};
    //获取收车任务详情
    $http.get('retrieve_cars_task/findRetrieveCarsTaskVoByTaskNo?retrieveCarTaskNo='+$scope.retrieveCarTaskNo).success(function (data) {
        if (data.code == Response.successCode){
            $scope.retrieveCarsTask = data.data;
        } else
            modalAlert($modal,data.message);
    }).error(function(data){
        modalAlert($modal,data);
    })


    //提交入库信息
    $scope.save = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            if($scope.retrieveCarsTask.notUpload){
                modalAlert($modal,$scope.retrieveCarsTask.notUploadInfo);
                $scope.submit = false;
                return false;
            }
            $scope.retrieveCarsTask.taskId = $scope.taskId;
            $scope.retrieveCarsTask.retrieveCarTaskNo = $scope.retrieveCarTaskNo;
            $http.post('retrieve_cars_task/retrieveCarsTaskStorage', $scope.retrieveCarsTask).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("/app/home").search({"type":"homeToastInfo",'msg':'车辆入库成功'});
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
        }else{
            $scope.formValidate = true;
            remindMsg($timeout,toaster);
        }
    }
    //退回
    $scope.sendBack = function () {
        if(!$scope.retrieveCarsTask.memo){
            toaster_info('请输入备注',toaster);
            $scope.submit = false;
            return false;
        }
        $scope.retrieveCarsTask.taskId = $scope.taskId;
        $scope.retrieveCarsTask.retrieveCarTaskNo = $scope.retrieveCarTaskNo;
        $http.post('retrieve_cars_task/retrieveCarsTaskSendBack',$scope.retrieveCarsTask).success(function (data) {
            if (data.code == Response.successCode)
                $location.path("/app/home").search({"type":"homeToastInfo",'msg':'退回成功'});
            else
                modalAlert($modal,data.message);
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    }

    //返回
    $scope.goBack = function () {
        $location.path('/app/home')
    }

    //合同详情
    $scope.contractDetails = function () {
        var id = $scope.retrieveCarsTask.contNo;
        var url = 'app.prebiz_apply_input_detail?applyNo=' + $scope.retrieveCarsTask.applyNo
            + '&contNo=' +$scope.retrieveCarsTask.contNo
            + '&applyType=' +$scope.retrieveCarsTask.applyType
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

    //归还车钥匙
    $scope.backCarKey = function () {
        if($scope.retrieveCarsTask.carKeyStatus == '6'){
            var id = $scope.retrieveCarsTask.retrieveCarId;
            var url = 'app.original_file_borrow_back_send_detail?borrowTaskNo='+$scope.retrieveCarsTask.borrowTaskNo
                + '&skipType=' + "true";
                // +'&taskId='+$scope.retrieveCarsTask.borrowBackTaskNo
            var title = '借阅归还申请';
            var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
            if(window.parent.addTab){
                window.parent.addTab(html);
            }
        }else{
            modalAlert($modal,'车钥匙不是借出状态');
        }
    }

    //查看逾期详情
    $scope.overdueDetail = function () {
        //取得逾期客户id
        $http.get('lawsuit_task/findOverdueCstmIdByOverdueContId?overdueContId='+$scope.retrieveCarsTask.overdueContId).success(function (data) {
            if(data.code == Response.successCode){
                var overdueCstmId = data.data;
                if(CommonStringUtils.isTrimBlank(overdueCstmId)){
                    modalAlert($modal,'该客户未发生过逾期');
                } else {
                    var id = overdueCstmId;
                    var url = 'app.postbiz_overdue_cstm_modify?overdueCstmId=' + overdueCstmId
                        + '&detail=true&isTab=true';
                    var title = '逾期详情';
                    var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
                    if(window.parent.addTab){
                        window.parent.addTab(html);
                    }
                }
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };

}])
