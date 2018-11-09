 /**
 * Created by lijunjun on 2018-04-28.
 */
app.controller('postbiz_invoice_hi_change_controller', ['$scope', '$http', '$modal', 'toaster', '$compile', '$location', '$localStorage', 'socialCertifNo', '$modalInstance', function ($scope, $http, $modal, toaster, $compile, $location, $localStorage, socialCertifNo, $modalInstance) {

    $scope.socialCertifNo = socialCertifNo;
    //参数配置
    $scope.dataTableProperties = {
        //ajax url 和类型
        dataTableAjax: {
            url: 'invoice_change_task/findInvoiceChangeHistory',
            type: "GET",
        },
        //table的html id
        dataTableId: 'invoice_change_table',
        //table的列
        dataTableColumn: [
            {title: '任务号', data: 'invoiceTaskNo', width: '10%'},
            {title: '任务状态', data: 'invoiceTaskStatus', width: '10%',
                render:function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus, data);
                }},
            {title: '变更发起人', data: 'submitUser', width: '10%'},
            {title: '变更发起时间', data: 'submitDate', width: '10%'},
            {title: '备注', data: 'remark', width: '10%'},
            {
                title: '变更后开票类型', data: 'invoiceType', width: '10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceType, data);
                }
            },
            {title: '变更后开票名称', data: 'ticketOpening', width: '10%'},
            {title: '变更后开票地址电话', data: 'invoiceAddr', width: '10%'},
            {title: '变更后税号', data: 'dutyParagraph', width: '10%'},
            {title: '变更后账号', data: 'accountNumber', width: '10%'},
            {title: '变更后开户行', data: 'bankName', width: '10%'},
            {
                title: '变更前开票类型', data: 'invoiceTypeOld', width: '10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceType, data);
                }
            },
            {title: '变更前开票名称', data: 'ticketOpeningOld', width: '10%'},
            {title: '变更前开票地址电话', data: 'invoiceAddrOld', width: '10%'},
            {title: '变更前税号', data: 'dutyParagraphOld', width: '10%'},
            {title: '变更前账号', data: 'accountNumberOld', width: '10%'},
            {title: '变更前开户行', data: 'bankNameOld', width: '10%'},
        ]
    }


    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.socialCertifNo = $scope.socialCertifNo;
        return params;
    }

    $scope.init = function () {
        //创建dataTable
        $scope.dataTable = createTable($scope.dataTableProperties, dataTableParams, $scope);
    }

    $scope.close = function(){
        $modalInstance.close();
    };

}])
;