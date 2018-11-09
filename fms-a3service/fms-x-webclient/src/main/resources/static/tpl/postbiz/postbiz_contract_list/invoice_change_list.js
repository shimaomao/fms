 /**
 * Created by lijunjun on 2018-04-28.
 */
app.controller('postbiz_invoice_change_list_controller', ['$scope', '$http', '$modal', 'toaster', '$compile', '$location', '$localStorage','setData', function ($scope, $http, $modal, toaster, $compile, $location, $localStorage,setData) {

    $scope.submitMaxDate = {maxDate:'#F{$dp.$D(\'submitDateEndSearch\')}'};
    $scope.submitMinDate = {minDate:'#F{$dp.$D(\'submitDateStartSearch\')}'};
    //订单状态
    $scope.bizStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.bizStatus);
    //查询参数
    $scope.params = setData.getter();
    //参数配置
    $scope.dataTableProperties = {
        //ajax url 和类型
        dataTableAjax: {
            url: 'invoice_change_task/findInvoiceChangeVosByPage',
            type: "GET",
        },
        //table的html id
        dataTableId: 'contract_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('companyId'),
            defaultDetail('invoiceTaskNo','detailInvoiceTaskNo','任务号','10%',$compile,$scope, 'invoiceTaskNo'),
            // {title: '任务号', data: 'invoiceTaskNo', width: '10%'},
            {title: '任务状态', data: 'invoiceTaskStatus', width: '10%',
            render:function (data, type, row, meta) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus, data);
            }},
            {title: '当前节点用户', data: 'presentUser', width: '10%'},
            {title: '任务发起人', data: 'submitUser', width: '10%'},
            {title: '任务发起时间', data: 'submitDate', width: '10%'},
            {title: '承租人', data: 'name', width: '10%'},
            {title: '统一社会信用代码', data: 'socialCertifNo', width: '10%'},
            {
                title: '开票类型', data: 'invoiceType', width: '10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceType, data);
                }
            },
            {title: '开票名称', data: 'ticketOpening', width: '10%'},
            {title: '开票地址电话', data: 'invoiceAddr', width: '10%'},
            {title: '税号', data: 'dutyParagraph', width: '10%'},
            {title: '账号', data: 'accountNumber', width: '10%'},
            {title: '开户行', data: 'bankName', width: '10%'},
            {title: '地区', data: 'groupDistrict', width: '10%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope) {
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties, dataTableParams, $scope);


    $scope.searchContractList = function () {
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetContractList = function () {
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

    //导出数据表
    $scope.exportExcel = function () {
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.postbiz, CommonServiceType.excelTypes.two,
            'invoice_change_task/findInvoiceChangeVosByPage', dataTableParams($scope));
    }

    $scope.detailInvoiceTaskNo = function (invoiceTaskNo) {
        $location.path("/app/postbiz_invoice_change_detail").search({'invoiceTaskNo': invoiceTaskNo});
    };

}])
;