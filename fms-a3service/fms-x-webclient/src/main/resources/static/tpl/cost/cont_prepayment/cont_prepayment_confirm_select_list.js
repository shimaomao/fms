/**
 * Created by lijunjun on 2018-05-07.
 */
app.controller('cont_prepayment_confirm_select_list_controller', ['$scope', '$http', 'toaster','$compile', '$location', '$modalInstance', '$modal',function ($scope, $http, toaster,$compile, $location, $modalInstance, $modal) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cont_receipt/findContReceiptsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'cont_receipt_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contReceiptId'),
            defaultDetail('receiptDate','detailContReceipt','到账日期','20%',$compile,$scope, 'contReceiptId'),
            // {title:'到账日期',data:'receiptDate',width:'20%'},
            {title:'到账时刻',data:'receiptTime',width:'20%'},
            {title:'付款银行',data:'payAccBank',width:'20%'},
            {title:'付款账号',data:'payAccountNo',width:'20%'},
            {title:'付款户名',data:'payAccountName',width:'20%'},
            {title:'到账金额',data:'receiptAmount',width:'20%'},
            {title:'付款备注',data:'memo',width:'20%'},
            {title:'剩余金额',data:'restAmount',width:'20%'},
            {title:'收款银行',data:'recAccBank',width:'20%'},
            {title:'收款账号',data:'recAccountNo',width:'20%'},
            {title:'收款户名',data:'recAccountName',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.recAccountNo = $scope.recAccountNo;
        params.receiptDateSearch = $scope.receiptDateSearch;
        return params;
    }

    //创建dataTable
    // 初始化
    $scope.init = function() {
        $scope.dataTable = createTable($scope.dataTableProperties, dataTableParams, $scope);
    };



    $scope.searchContReceipt = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetContReceipt = function(){
        $scope.recAccountNo = "";
        $scope.receiptDateSearch = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    //收款明细导出
    $scope.exportExcel = function () {
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.finance,CommonServiceType.excelTypes.one,
            'cont_receipt/findContReceiptsByPage',dataTableParams($scope));
    }

    // 确认
    $scope.confirm = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('contReceiptId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择收款明细信息！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时选中一条数据！');
        else{
            var data = $scope.dataTable.getRow(rowsIds[0],'contReceiptId');
            if(data == null) {
                modalAlert($modal,'请您选择收款明细信息！');
            } else {
                $modalInstance.close(data);
            }
        }
    };
    
    $scope.detailContReceipt = function (contReceiptId) {
        var data = $scope.dataTable.getRow(contReceiptId, 'contReceiptId');
        $modalInstance.close(data);
    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close(null);
    };



}])
;