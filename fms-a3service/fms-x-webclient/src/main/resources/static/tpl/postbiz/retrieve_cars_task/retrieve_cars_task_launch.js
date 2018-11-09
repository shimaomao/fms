/**
 * Created by qiaohao on 2018/9/14 0014.
 */
app.controller('retrieve_cars_task_launch_controller',['$scope', '$http', '$modal', 'toaster','$location','$timeout',function($scope, $http, $modal, toaster,$location,$timeout){

    $scope.formValidate = false;
    //$scope.retrieveCarTaskNo = '';
    $scope.submit = false;

    $scope.contNo = $location.search()['contNo'];
    $scope.retrieveCarTaskNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.retrieveCarsTask = {};
    //逾期客户一览参数
    $scope.flag = $location.search()['flag'];
    $scope.overdueCstmId = $location.search()['overdueCstmId'];
    $scope.overdueContId = $location.search()['overdueContId'];
    $scope.certifNo = $location.search()['certifNo'];

    if(CommonStringUtils.isNotTrimBlank($scope.taskId)){
        $http.get('retrieve_cars_task/findRetrieveCarsTaskVoByTaskNo?retrieveCarTaskNo=' + $scope.retrieveCarTaskNo).success(function (data) {
            if (data.code == Response.successCode){
                $scope.retrieveCarsTask = data.data;
                if($scope.retrieveCarsTask.dispachType == null)
                    $scope.retrieveCarsTask.dispachType = "";
            } else
                modalAlert($modal,data.message);
        }).error(function(data){
            modalAlert($modal,data);
        })
    }else{
        if(CommonStringUtils.isNotTrimBlank($scope.overdueContId)){
            $http.get('overdue_cont/findOverdueContVoByContNo?contNo='+$scope.overdueContId).success(function (data) {
                if (data.code == Response.successCode) {
                    var overdueCont = data.data;
                    //赋值
                    $scope.retrieveCarsTask.contNo = overdueCont.contNo;
                    $scope.retrieveCarsTask.cstmName = overdueCont.cstmName;
                    $scope.retrieveCarsTask.overdueContVinNo = overdueCont.vinNo;
                    $scope.retrieveCarsTask.vehicleLicenseNo = overdueCont.vehicleLicenseNo;
                    $scope.retrieveCarsTask.engineNo = overdueCont.engineNo;
                    $scope.retrieveCarsTask.lessor = overdueCont.lessor;
                    $scope.retrieveCarsTask.applyNo = overdueCont.applyNo;
                    $scope.retrieveCarsTask.applyType = overdueCont.applyType;
                    $scope.retrieveCarsTask.overdueContId = overdueCont.overdueContId;
                    $scope.retrieveCarsTask.trialAmount = overdueCont.trialAmount;
                    $scope.retrieveCarsTask.salvageValue = 0;
                    $scope.retrieveCarsTask.costDifference = ($scope.retrieveCarsTask.trialAmount * 1 - $scope.retrieveCarsTask.salvageValue * 1).toFixed(2);
                } else
                    modalAlert($modal,data.message);
            }).error(function(data){
                modalAlert($modal,data);
            })
        }else{
            $scope.retrieveCarsTask = {};
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
                $http.post('retrieve_cars_task/checkRetrieveCarsTask',data).success(function (data1) {
                    $scope.retrieveCarsTask1 = data1.data;
                    if(isNotUndefinedNull($scope.retrieveCarsTask1))
                        modalAlert($modal,"该合同有正在进行收车任务，不能再次发起");
                    else{
                        var overdueCont = data;
                        //赋值
                        $scope.retrieveCarsTask.contNo = overdueCont.contNo;
                        $scope.contNo = overdueCont.contNo;
                        $scope.retrieveCarsTask.cstmName = overdueCont.cstmName;
                        $scope.retrieveCarsTask.overdueContVinNo = overdueCont.vinNo;
                        $scope.retrieveCarsTask.vehicleLicenseNo = overdueCont.vehicleLicenseNo;
                        $scope.retrieveCarsTask.engineNo = overdueCont.engineNo;
                        $scope.retrieveCarsTask.lessor = overdueCont.lessor;
                        $scope.retrieveCarsTask.overdueContId = overdueCont.overdueContId;
                        $scope.retrieveCarsTask.applyNo = overdueCont.applyNo;
                        $scope.retrieveCarsTask.applyType = overdueCont.applyType;
                        $scope.retrieveCarsTask.overdueContId = overdueCont.overdueContId;
                        $scope.retrieveCarsTask.salvageValue = 0
                        //$scope.retrieveCarsTask.trialAmount = overdueCont.trialAmount;
                        $http.get('cont_prepayment/findContPrepaymentWithDetailByContNo?contNo='+data.contNo).success(function (result) {
                            $scope.retrieveCarsTask.trialAmount  = result.data.prepayTrialAmount;
                            $scope.retrieveCarsTask.costDifference = ($scope.retrieveCarsTask.trialAmount * 1 - $scope.retrieveCarsTask.salvageValue * 1).toFixed(2);
                        })
                    }
                })
            }
        },function(){

        });
    };
    //提交申请
    $scope.save = function(){
        if(!$scope.form.$invalid) {
            $scope.retrieveCarsTask.contNo = $scope.retrieveCarsTask.contNo;
            $scope.retrieveCarsTask.taskId = $scope.taskId;
            $scope.retrieveCarsTask.retrieveCarTaskNo = $scope.retrieveCarTaskNo;
            $scope.submit = true;
            $http.post('retrieve_cars_task/retrieveCarsTaskLaunch', $scope.retrieveCarsTask).success(function (data) {
                if (data.code == Response.successCode){
                    if(CommonCodeUtils.yesNoFlag.yes == $scope.flag){
                        $location.path('app/postbiz_overdue_cstm_modify').search({contNo:$scope.retrieveCarsTask.contNo,overdueCstmId:$scope.overdueCstmId,overdueContId:$scope.overdueContId,certifNo:$scope.certifNo,"msg":"收车任务发起成功"})
                    }else{
                        if($scope.taskId){
                            $location.path('/app/home').search({"type": 'homeToastInfo',"msg":'收车任务发起成功'})
                        }else{
                            $location.path('app/postbiz_retrieve_cars_task_list').search({"msg":"收车任务发起成功"})
                        }
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
            remindMsg($timeout,toaster);
        }
    }
    //返回
    $scope.goBack = function () {
        if(CommonCodeUtils.yesNoFlag.yes == $scope.flag){
            $location.path('app/postbiz_overdue_cstm_modify').search({contNo:$scope.retrieveCarsTask.contNo,overdueCstmId:$scope.overdueCstmId,overdueContId:$scope.overdueContId,certifNo:$scope.certifNo})
        }else{
            if($scope.taskId){
                $location.path('/app/home')
            }else{
                $location.path('app/postbiz_retrieve_cars_task_list')
            }
        }

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
        if(!$scope.contNo){
            $scope.retrieveCarsTask.costDifference = 0
        }
        // if($scope.retrieveCarsTask.costDifference<0){
        //     modalAlert($modal,'差额不能小于零');
        //     $scope.retrieveCarsTask.salvageValue = 0;
        // }
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
            if(!$scope.contNo){
                modalAlert($modal,'请选择一条合同后查看');
                $scope.submit = false;
                return false;
            }
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