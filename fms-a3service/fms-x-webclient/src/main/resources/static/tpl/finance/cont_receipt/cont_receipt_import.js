/**
 * Created by ningyangyang on 2018/5/10.
 */
app.controller('cont_receipt_import_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cont_receipt/findContReceiptsImport',
            type:"GET",
        },
        //table的html id
        dataTableId:'cont_receipt_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contReceiptId'),
            // defaultDetail('receiptDate','detailContReceipt','到账日期','20%',$compile,$scope),
            {title:'到账日期',data:'receiptDate',width:'20%'},
            {title:'到账时刻',data:'receiptTime',width:'20%'},
            {title:'付款银行',data:'payAccBank',width:'20%'},
            {title:'付款账号',data:'payAccountNo',width:'20%'},
            {title:'付款户名',data:'payAccountName',width:'20%'},
            {title:'到账金额',data:'receiptAmount',width:'20%'},
            {title:'付款备注',data:'memo',width:'20%'},
            // {title:'剩余金额',data:'restAmount',width:'20%'},
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
        params.memo = $scope.memo;
        params.recAccountName = $scope.recAccountName;
        params.payAccountName = $scope.payAccountName;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchContReceipt = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetContReceipt = function(){
        $scope.recAccountNo = "";
        $scope.receiptDateSearch = "";
        $scope.memo = "";
        $scope.recAccountName = "";
        $scope.payAccountName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    //参数配置
    $scope.dataTablePropertiesRepaySked= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cont_repay_sked/findContRepaySkedsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'cont_repay_sked_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('repaySkedId'),
            // defaultDetail('contNo','detailContRepaySked','合同编号','20%',$compile,$scope),
            {title:'合同编号',data:'contNo',width:'20%'},
            {title:'期数',data:'period',width:'20%'},
            {title:'收款日期',data:'receiptDate',width:'20%'},
            {title:'每期客户实际租金',data:'rent',width:'20%'},
            {title:'逾期罚息额',data:'overdueAmount',width:'20%'},
            {title:'已认领金额',data:'claimedAmount',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParamsRepaySked($scope){
        params = {};
        params.contNo = $scope.contNo;
        params.repayDateSearch = $scope.repayDateSearch;
        return params;
    }

    //创建dataTable
    $scope.dataTableRepaySked = createTable($scope.dataTablePropertiesRepaySked,dataTableParamsRepaySked,$scope);


    $scope.searchContRepaySked = function(){
        $scope.dataTableRepaySked.fnDraw(true);
    }

    $scope.resetContRepaySked = function(){
        $scope.contNo = "";
        $scope.repayDateSearch = "";
        $scope.dataTableRepaySked.fnDraw(true);//刷新
    }
    //收款明细导出
    $scope.exportContReceiptExcel = function () {
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.finance,CommonServiceType.excelTypes.one,
            'cont_receipt/findContReceiptsImport',dataTableParams($scope));
    }

    // //待勾稽租金导出
    // $scope.exportContRepaySkedExcel = function () {
    //     CommonServiceType.exportExcel(CommonServiceType.serviceTypes.finance,CommonServiceType.excelTypes.one,
    //         'cont_repay_sked/findContRepaySkedsByPage',dataTableParamsRepaySked($scope));
    // }
    //收款明细导入
    $scope.importContReceiptExcel = function () {
                var rtn = $modal.open({
                    backdrop : 'static',
                    size:'lg',
                    templateUrl: 'tpl/common/file/file_upload.html'+getCacheTime(),
                    controller: 'file_upload_controller',
                    resolve:{
                        fileTypePath:function () {
                            return CommonCodeUtils.fileTypePaths.upLoad;
                        },
                        secondPath:function () {
                            return CommonCodeUtils.secondPath.contReceiptFiles;
                        }
                    }
                });
                rtn.result.then(function (data) {
                    if(CommonObjectUtils.isExist(data) && data.length > 0 && CommonStringUtils.isNotTrimBlank(data[0].fileCompletePath)){
                        $scope.importContReceipts(data[0].fileCompletePath);
                    }
                },function(){

                });
    }


    $scope.importContReceipts = function(filePath){
        $http.post('cont_receipt/importContReceipts?filePath='+filePath).success(function (data) {
            if (data.code == Response.successCode) {
                toaster_success('收入明细导入成功', toaster);
                $scope.dataTable.fnDraw(true);
            } else {
                modalAlert($modal,data.message);
            }
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    }
    $scope.exportContReceiptModalExcel = function(){
        window.parent.open('cont_receipt/exportContReceiptModalExcel');
    }

}])
;