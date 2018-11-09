/**
 * Created by qiaohao on 2018/7/11.
 */
app.controller('financial_voucher_data_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'financial_voucher_data/findFinVouDataVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'financial_voucher_data_table',
        //table的列
        dataTableColumn: [
            defaultDetail('voucherNo','detailFinancialVoucherData','凭证号','8%',$compile,$scope,'voucherNo'),
            {title:'业务号',data:'voucherBizCode',width:'8%'},
            {title:'业务日期',data:'voucherBizDate',width:'8%'},
            {title:'凭证类型',data:'voucherTypeName',width:'8%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.voucherNo = $scope.voucherNo;
        params.voucherBizCode = $scope.voucherBizCode;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchFinancialVoucherData = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetFinancialVoucherData = function(){
        $scope.voucherNo = "";
        $scope.voucherBizCode = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.finance,CommonServiceType.excelTypes.one,
            'financial_voucher_data/findFinVouDataVosByPage',dataTableParams($scope));
    }

    $scope.detailFinancialVoucherData = function(voucherNo){
        var row = $scope.dataTable.getRow(voucherNo,"voucherNo");
        if(CommonObjectUtils.isExist(row))
            $location.path('/app/financial_voucher_data_detail').search({finVouData:row});
        else
            modalAlert($modal,"请选择需要查看明细的数据");
    }

}])
;