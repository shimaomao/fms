/**
 * Created by qiaohao on 2018/9/14 0014.
 */
app.controller('retrieve_cars_task_risk_controller',['$scope', '$http', '$modal', 'toaster','$location','$timeout',function($scope, $http, $modal, toaster,$location,$timeout){

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.retrieveCarTaskNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.retrieveCarsTask = {};
    $scope.dispatchTypes = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.dispatchType);

    $http.get('retrieve_cars_task/findRetrieveCarsTaskVoByTaskNo?retrieveCarTaskNo='+ $scope.retrieveCarTaskNo).success(function (data) {
        if (data.code == Response.successCode){
            $scope.retrieveCarsTask = data.data;
            if($scope.retrieveCarsTask.dispachType == null)
                $scope.retrieveCarsTask.dispachType = "";
        } else
            modalAlert($modal,data.message);
    }).error(function(data){
        modalAlert($modal,data);
    })


    // 获取登记人员弹出框
    $scope.selectUser = function () {
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
                if($scope.retrieveCarsTask.dispachType == 1){
                    $scope.retrieveCarsTask.dispachPeople = data.user;
                    $scope.retrieveCarsTask.dispachPeopleName = data.userName;
                } else if($scope.retrieveCarsTask.dispachType == 2){
                    $scope.retrieveCarsTask.registerPeople = data.user;
                    $scope.retrieveCarsTask.registerPeopleName = data.userName;
                }
            }
        },function(){
        });
    };

   //提交
    $scope.save = function () {
        if(!$scope.form.$invalid) {

            if($scope.retrieveCarsTask.dispachType == CommonCodeUtils.dispatchType.company){
                $scope.retrieveCarsTask.registerPeople = "";
                $scope.retrieveCarsTask.registerPeopleName = "";
                $scope.retrieveCarsTask.thirdDispachOrg = "";
                $scope.retrieveCarsTask.thirdDispachContact = "";
                $scope.retrieveCarsTask.thirdDispachMobile = "";
            } else if($scope.retrieveCarsTask.dispachType == CommonCodeUtils.dispatchType.other){
                $scope.retrieveCarsTask.dispachPeople = "";
                $scope.retrieveCarsTask.dispachPeopleName = "";
            }

            $scope.submit = true;
            $scope.retrieveCarsTask.taskId = $scope.taskId;
            $scope.retrieveCarsTask.retrieveCarTaskNo = $scope.retrieveCarTaskNo;
            $http.post('retrieve_cars_task/retrieveCarsTaskRisk', $scope.retrieveCarsTask).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("/app/home").search({"type":"homeToastInfo",'msg':'派单成功'});
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
     //拒绝
    $scope.goRefuse = function () {
        if(!$scope.retrieveCarsTask.memo){
            toaster_info('请输入备注',toaster);
            $scope.submit = false;
            return false;
        }
        $scope.retrieveCarsTask.taskId = $scope.taskId;
        $scope.retrieveCarsTask.retrieveCarTaskNo = $scope.retrieveCarTaskNo;
        $http.post('retrieve_cars_task/retrieveCarsTaskRefuse',$scope.retrieveCarsTask).success(function (data) {
            if (data.code == Response.successCode)
                $location.path("/app/home").search({'msg':'申请已拒绝'});
            else
                modalAlert($modal,data.message);
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
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
                $location.path("/app/home").search({'msg':'退回成功'});
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

    /**
     * 计算试算金额差额
     */
    $scope.calculateTrial = function () {
        $scope.retrieveCarsTask.costDifference = ($scope.retrieveCarsTask.trialAmount * 1 - $scope.retrieveCarsTask.salvageValue * 1).toFixed(2);
        if(isUndefinedNull($scope.retrieveCarsTask.salvageValue)){
            $scope.retrieveCarsTask.costDifference = 0
        }
    }

    //试算详情
    $scope.preCount = function(){
        // if(rows && rows.length == 1) {
        //var contract =  rows[0];
        // if(contract.bizStatus != CommonCodeUtils.codeValues.contractValid) {
        //     modalAlert($modal,'只能试算已生效的合同！');
        //     return;
        // }
        // if(contract.paymentSts != CommonCodeUtils.codeValues.uncleared) {
        //     modalAlert($modal,'已结清合同无法试算！');
        //     return;
        // }
        // var repayDay = contract.repayDay*1;
        // var nowDay = new Date().getDate();
        // if(nowDay && nowDay*1 == repayDay){
        //     modalAlert($modal,'还款日当天不能试算提前还款！');
        //     return;
        // }

        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/cost/cont_prepayment/cont_prepayment_try_count.html?datetime='+getTimestamp(),
            controller: 'cont_prepayment_try_count_controller',
            resolve:{
                contData: function () {
                    return $scope.retrieveCarsTask.contNo;
                }
            }
        });
        rtn.result.then(function (data) {

        },function(){
        });

        // }else{
        //     modalAlert($modal,'请您选择一条需要试算的数据！');
        // }
    };

}])