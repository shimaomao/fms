/**
 * Created by lijunjun on 2018-09-12.
 */
app.controller('lawsuit_task_save_controller', ['$scope', '$http','$modal', 'toaster', '$location','$timeout',function ($scope, $http,$modal,toaster,$location,$timeout) {

    $scope.lawsuitTaskVo={};
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.lawsuitTaskNo = "";
    $scope.overdueContId = "";
    $scope.overdueCstmId = $location.search()['overdueCstmId'];
    if ($location.search()['overdueContId']){
        $scope.overdueContId = $location.search()['overdueContId'];
    }
    if ($location.search()['serviceId']){
        $scope.lawsuitTaskNo = $location.search()['serviceId'];
    }
    if ($scope.lawsuitTaskNo){
        $http.get('lawsuit_task/findLawsuitTasksByTaskNo?lawsuitTaskNo='+ $scope.lawsuitTaskNo).success(function (data) {
            if (data.code == Response.successCode){
                $scope.lawsuitTaskVo = data.data;
                $scope.lawsuitTaskVo.remark = '';
            }else{
                modalAlert($modal,data.message);
            }
        });
    }
    if ($scope.overdueContId){
        // 根据逾期合同Id获取诉讼任务基本信息
        $http.get('lawsuit_task/findLawsuitTasksByOverdueContId?overdueContId='+ $scope.overdueContId).success(function (data) {
            if (data.code == Response.successCode){
                $scope.lawsuitTaskVo = data.data;
            }else{
                modalAlert($modal,data.message);
            }
        });
    }

    /**
     * 诉讼任务申请发起
     */
    $scope.save = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            if ($location.search()['taskId']){
                $scope.lawsuitTaskVo.taskId = $location.search()['taskId'];
            }
            $http.post('lawsuit_task/saveLawsuitTask', $scope.lawsuitTaskVo).success(function (data) {
                if (data.code == Response.successCode)
                    if ($location.search()['type'] == 'list'){
                        $location.path('app/postbiz_lawsuit_task_list').search({type:'submit', msg:'诉讼任务申请成功'});
                    } else if ($location.search()['type'] == 'overdueCstm'){
                        $location.path('app/postbiz_overdue_cstm_modify').search({overdueCstmId:$scope.overdueCstmId,type:'submit', msg:'诉讼任务申请成功'});
                    } else {
                        $location.path('app/home');
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
            remindMsg($timeout,toaster);
        }
    }

    $scope.selectOverdueCont = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/cost/overdue_cont/overdue_cont_list_select.html'+getCacheTime(),
            controller: 'overdue_cont_list_select_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {
            if(data){
                console.log(data);
                $scope.lawsuitTaskVo = data;
                $scope.lawsuitTaskVo.belongGroupName = data.lessor;
            }
        },function(){

        });
    };

    // 获取派单人员弹出框
    $scope.getUserName = function (type) {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_user/sys_user_list_select.html'+getCacheTime(),
            controller: 'sys_user_list_select_controller',
            resolve:{
                sysUserRoleCode: function(){return CommonCodeUtils.roles.dispatchRole}
            }
        });
        rtn.result.then(function (data) {
            if(data){
                if (type == '1'){
                    // 设定派单人
                    $scope.lawsuitTaskVo.dispatchUserName = data.userName;
                    $scope.lawsuitTaskVo.dispatchUser = data.user;
                } else {
                    // 设定登记人
                    $scope.lawsuitTaskVo.registerUserName = data.userName;
                    $scope.lawsuitTaskVo.registerUser = data.user;
                }
            }
        },function(){
        });
    };

    //派单类型change事件
    $scope.changeDispatch = function () {
        // 如果是公司内部
        if ($scope.lawsuitTaskVo.dispatchType == CommonCodeUtils.dispatchType.company){
            $scope.lawsuitTaskVo.registerUserName = "";
            $scope.lawsuitTaskVo.registerUser = "";
            $scope.lawsuitTaskVo.tollyName = "";
            $scope.lawsuitTaskVo.tollyContactName = "";
            $scope.lawsuitTaskVo.tollyMobileNo = "";
        } else {
            $scope.lawsuitTaskVo.dispatchUserName = "";
            $scope.lawsuitTaskVo.dispatchUser = "";
        }
    };

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
        var type = $location.search()['type'];
        if (type == 'list'){
            $location.path('app/postbiz_lawsuit_task_list');
        } else if (type == 'overdueCstm'){
            $location.path('app/postbiz_overdue_cstm_modify').search({overdueCstmId:$scope.overdueCstmId});
        } else {
            $location.path('app/home');
        }
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.lawsuit;
    if ($location.search()['serviceId']){
        $scope.wfLogNo = $location.search()['serviceId'];
    }

}]);


