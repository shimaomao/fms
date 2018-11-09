/**
 * Created by ningyangyang on 2018-09-01.
 * 展期申请合同审核
 */
app.controller('defer_task_contract_approve_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http,$modal,toaster,$location) {

    //传值父页面
    $scope.$watch("deferTask",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal !==oldVal)
            $scope.$emit("deferTaskToFather",$scope.deferTask);
    },true);

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


