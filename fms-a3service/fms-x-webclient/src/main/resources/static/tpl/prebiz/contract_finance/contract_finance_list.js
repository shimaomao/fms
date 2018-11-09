/**
 * Created by huchenghao on 2018-04-11.
 */
app.controller('contract_finance_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'contract_finance/findContractFinancesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'contract_finance_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contFinId'),
            {title:'合同号',data:'contNo',width:'20%'},
            {title:'订单号',data:'applyNo',width:'20%'},
            {title:'vehicleNo',data:'vehicleNo',width:'20%'},
            {title:'productCatg',data:'productCatg',width:'20%'},
            {title:'product',data:'product',width:'20%'},
            {title:'vehicleForm',data:'vehicleForm',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.contNo = $scope.contNo;
        params.applyNo = $scope.applyNo;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchContractFinance = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetContractFinance = function(){
        $scope.contNo = "";
        $scope.applyNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }
   //生成合同
    $scope.contCreate = function () {
        var rowsIds =  $scope.dataTable.getRowsIds('contFinId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时选中一条数据！');
        else {
            var data = $scope.dataTable.getRow(rowsIds[0], 'contFinId');
            $location.path("app/prebiz_cont_create").search({contNo:data.contNo,applyNo:data.applyNo,applyType:1 ,taskId: 0});
        }
        }
   //请款
    $scope.contRequestPay = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('contFinId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时选中一条数据！');
        else {
            var data = $scope.dataTable.getRow(rowsIds[0], 'contFinId');
            $location.path("app/prebiz_cont_request_pay").search({contNo:data.contNo,applyNo:data.applyNo,applyType:1 ,taskId: 0});
        }
    }

    // 收款
    $scope.contRequestReceipt = function (applyNo) {
        var apply =  $scope.dataTable.getRow(applyNo,'applyNo')
        $location.path("app/prebiz_cont_charge").search({'applyNo':apply.applyNo, 'taskId':apply.taskId, "applyType":'1', 'contNo': apply.contNo});
        // $location.path("app/prebiz_cont_print").search({'applyNo':apply.applyNo, 'taskId':apply.taskId, "applyType":apply.applyType, 'contNo': apply.contNo});
    }

    // 制单
    $scope.contRequestMake = function (applyNo) {
        var apply =  $scope.dataTable.getRow(applyNo,'applyNo')
        $location.path("app/prebiz_cont_make_voucher").search({'applyNo':apply.applyNo, 'taskId':apply.taskId, "applyType":'1', 'contNo': apply.contNo});
        // $location.path("app/prebiz_cont_print").search({'applyNo':apply.applyNo, 'taskId':apply.taskId, "applyType":apply.applyType, 'contNo': apply.contNo});
    }

    //财务付款
    $scope.contPayment = function (applyNo,contNo) {
        var contractFinance =  $scope.dataTable.getRow(applyNo,'applyNo')
        contractFinance.applyType = '1';
        contractFinance.taskId = '0';
        $location.path("app/prebiz_receipt_cont_payment").search({'applyNo':contractFinance.applyNo,'contNo':contractFinance.contNo,'taskId':contractFinance.taskId,"applyType":contractFinance.applyType});
        //原来的付款路径
        // $location.path("app/prebiz_cont_payment").search({'applyNo':contractFinance.applyNo,'contNo':contractFinance.contNo,'taskId':contractFinance.taskId,"applyType":contractFinance.applyType});
    }

    // 合同打印
    $scope.contPrint = function (applyNo) {
        var apply =  $scope.dataTable.getRow(applyNo,'applyNo')
        $location.path("app/prebiz_cont_print").search({'applyNo':apply.applyNo, 'taskId':apply.taskId, "applyType":'1', 'contNo': apply.contNo});
        // $location.path("app/prebiz_cont_print").search({'applyNo':apply.applyNo, 'taskId':apply.taskId, "applyType":apply.applyType, 'contNo': apply.contNo});
    }

    // 合同资管
    $scope.contQualification = function (applyNo) {
        var apply =  $scope.dataTable.getRow(applyNo,'applyNo')
        $location.path("app/prebiz_cont_qualification").search({'applyNo':apply.applyNo, 'taskId':apply.taskId, "applyType":'1', 'contNo': apply.contNo});
        // $location.path("app/prebiz_cont_print").search({'applyNo':apply.applyNo, 'taskId':apply.taskId, "applyType":apply.applyType, 'contNo': apply.contNo});
    }

    //合同文件核查
    $scope.contInspect = function (applyNo) {
        var contractFinance =  $scope.dataTable.getRow(applyNo,'applyNo')
        contractFinance.applyType = '1';
        contractFinance.taskId = '0';
        $location.path("app/prebiz_cont_inspect").search({'applyNo':contractFinance.applyNo,'contNo':contractFinance.contNo,'taskId':contractFinance.taskId,"applyType":contractFinance.applyType});
    }

    //有模板excel导出测试
    $scope.testExport = function () {
        var hrefUrl = 'contract_finance/testExport';
        window.parent.open(hrefUrl);
    }

}])
;