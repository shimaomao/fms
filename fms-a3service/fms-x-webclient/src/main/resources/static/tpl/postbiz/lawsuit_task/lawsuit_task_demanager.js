/**
 * Created by lijunjun on 2018-09-12.
 */
app.controller('lawsuit_task_demanager_controller', ['$scope', '$http','$modal', 'toaster', '$location',function ($scope, $http,$modal,toaster,$location) {

    $scope.lawsuitTaskVo={};
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.lawsuitTaskNo = "";
    if ($location.search()['serviceId']){
        $scope.lawsuitTaskNo = $location.search()['serviceId'];
    }

    if ($scope.lawsuitTaskNo){
        $http.get('lawsuit_task/findLawsuitTasksByTaskNo?lawsuitTaskNo='+ $scope.lawsuitTaskNo).success(function (data) {
            if (data.code == Response.successCode){
                $scope.lawsuitTaskVo = data.data;
                $scope.lawsuitTaskVo.remark = "";
            }else{
                modalAlert($modal,data.message);
            }
        });
    }

    /**
     * 风控经理审核通过
     */
    $scope.lawsuitApproval = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            if ($location.search()['taskId']){
                $scope.lawsuitTaskVo.taskId = $location.search()['taskId'];
            }
            $http.post('lawsuit_task/lawsuitApproval', $scope.lawsuitTaskVo).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path('app/home');
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
     * 风控经理审核退回
     */
    $scope.lawsuitBack = function () {
        $scope.submit = true;
        if ($location.search()['taskId']){
            $scope.lawsuitTaskVo.taskId = $location.search()['taskId'];
        }
        $http.post('lawsuit_task/lawsuitBack', $scope.lawsuitTaskVo).success(function (data) {
            if (data.code == Response.successCode)
                $location.path('app/home');
            else
                modalAlert($modal,data.message);
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    }

    /**
     * 风控经理审核拒绝
     */
    $scope.lawsuitRefuse = function () {
        $scope.submit = true;
        if ($location.search()['taskId']){
            $scope.lawsuitTaskVo.taskId = $location.search()['taskId'];
        }
        $http.post('lawsuit_task/lawsuitRefuse', $scope.lawsuitTaskVo).success(function (data) {
            if (data.code == Response.successCode)
                $location.path('app/home');
            else
                modalAlert($modal,data.message);
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    }

    //合同详情
    $scope.contractDetails = function () {
        var id = $scope.lawsuitTaskVo.contNo;
        var url = 'app.prebiz_apply_input_detail?applyNo=' + $scope.lawsuitTaskVo.applyNo
            + '&contNo=' +$scope.lawsuitTaskVo.contNo
            + '&applyType=' +$scope.lawsuitTaskVo.applyType
            + '&type=lawsuit'
            + '&contractDate=' +$scope.contractDate
            + '&bizStatus=' +$scope.bizStatus
            + '&isTab=true';
        var title = '合同详情';
        var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
        if(window.parent.addTab){
            window.parent.addTab(html);
        }
    }

    //查看逾期详情
    $scope.overdueDetail = function () {
        //取得逾期客户id
        $http.get('lawsuit_task/findOverdueCstmIdByOverdueContId?overdueContId='+$scope.lawsuitTaskVo.overdueContId).success(function (data) {
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


    /**
     * 返回
     * @param status
     */
    $scope.close = function(){
        $location.path('app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.lawsuit;
    if ($location.search()['serviceId']){
        $scope.wfLogNo = $location.search()['serviceId'];
    }

}]);


