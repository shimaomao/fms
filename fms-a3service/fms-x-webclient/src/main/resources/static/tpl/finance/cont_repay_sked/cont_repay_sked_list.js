/**
 * Created by lijunjun on 2018-05-08.
 */
app.controller('cont_repay_sked_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location', function ($scope, $http, $modal, toaster,$compile, $location) {

    $scope.receiptBizType = $location.search()['receiptBizType']
    $scope.repaySkedId = $location.search()['repaySkedId'];

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cont_repay_sked/findContRepaySkedClaimeByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'cont_repay_sked_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contReceiptExamId'),
            // defaultDetail('contNo','detailContRepaySked','合同编号','20%',$compile,$scope),
            {title:'合同编号',data:'contNo',width:'20%'},
            {title:'期数',data:'period',width:'20%'},
            {title:'收款日期',data:'receiptDate',width:'20%'},
            {title:'每期客户实际租金',data:'rentActual',width:'20%'},
            {title:'逾期罚息额',data:'overdueAmount',width:'20%'},
            {title:'认领金额',data:'claimedAmount',width:'20%'},
            {title:'付款银行',data:'payAccBank',width:'20%'},
            {title:'付款账号',data:'payAccountNo',width:'20%'},
            {title:'付款户名',data:'payAccountName',width:'20%'},
            {title:'付款金额',data:'receiptAmount',width:'20%'},
            {title:'付款备注',data:'memo',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.receiptBizType = $scope.receiptBizType ;
        params.repaySkedId = $scope.repaySkedId;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchContRepaySked = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetContRepaySked = function(){
        $scope.contNo = "";
        $scope.period = "";
        $scope.dataTable.fnDraw(true);//刷新
    }
    
    $scope.cancelClaime = function () {
        var rows =  $scope.dataTable.getRows();//主键
        if(rows.length < 1)
            modalAlert($modal,'请您选择需要取消认领的数据！');
        else {
            $http.post('cont_repay_sked/cancelClaime', {'contRepaySkedVoList':rows}).success(function (result) {
                if (result.code == Response.successCode) {
                    toaster_success('取消认领成功', toaster);
                    $scope.dataTable.fnDraw(true);
                } else {
                    modalAlert($modal,result.message);
                }
                $scope.submit = false;
            });
        }
    }

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.finance,CommonServiceType.excelTypes.two,
            'cont_repay_sked/findContRepaySkedClaimeByPage?receiptBizType=' + $scope.receiptBizType + '&repaySkedId=' + $scope.repaySkedId,dataTableParams($scope));
    }

    $scope.goBack = function () {
        $location.path("app/finance_cont_receipt_list");
    }

}])
;