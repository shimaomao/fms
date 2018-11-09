/**
 * Created by ningyangyang on 2018/9/27.
 *  收车任务详情
 */
app.controller('retrieve_cars_task_detail_controller',['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout',function($scope, $http, $modal, toaster,$compile,$location,$timeout){

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.retrieveCarTaskNo = $location.search()['retrieveCarTaskNo'];
    //$scope.taskId = $location.search()['taskId'];
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

    //返回
    $scope.goBack = function () {
        $location.path('/app/postbiz_retrieve_cars_task_list')
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