/**
 * Created by lijunjun on 2018-08-28.
 */
app.controller('invoice_change_detail_controller', ['$scope', '$http','$modal','toaster', '$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.invoiceChange={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.cstmCompany = {};
    $scope.oldCstmCompany = {};
    $scope.fileType = CommonCodeUtils.basFileTypes.invoiceChangeFile;
    $scope.treeFileId = "invoice_change_detail_file_tree";
    $scope.notUpload = false;
    $scope.invoiceTaskNo = '';
    if ($location.search()['invoiceTaskNo']){
        $scope.invoiceTaskNo = $location.search()['invoiceTaskNo'];
    }

    $http.get('invoice_change/findInvoiceChangeVosByInvoiceTaskNo?invoiceTaskNo='+ $scope.invoiceTaskNo).success(function(data){
        $scope.cstmCompany = $.extend(true,{},data.data.newInvoiceChangeVo);
        $scope.oldCstmCompany = $.extend(true,{},data.data.oldInvoiceChangeVo);
        // 判断每个项目是否变更过
        isChangedSolve($scope.oldCstmCompany, $scope.cstmCompany);
        $scope.oldCstmCompany.invoiceTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceType,$scope.oldCstmCompany.invoiceType);
        $scope.cstmCompany.invoiceTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceType,$scope.cstmCompany.invoiceType);
        if (data.data.bizFilesList){
            $scope.bizFilesList = data.data.bizFilesList;
        }
    });

    /**
     * 判断变更前后各项目是否变化，并给Flag赋值
     * @param oldEntity
     * @param newEntity
     */
    function isChangedSolve(oldEntity, newEntity) {
        $scope.invoiceTypeFlag = getChangedFlag(oldEntity.invoiceType, newEntity.invoiceType);
        $scope.ticketOpeningFlag = getChangedFlag(oldEntity.ticketOpening, newEntity.ticketOpening);
        $scope.dutyParagraphFlag = getChangedFlag(oldEntity.dutyParagraph, newEntity.dutyParagraph);
        $scope.invoiceAddrFlag = getChangedFlag(oldEntity.invoiceAddr, newEntity.invoiceAddr);
        $scope.accountNumberFlag = getChangedFlag(oldEntity.accountNumber, newEntity.accountNumber);
        $scope.bankNameFlag = getChangedFlag(oldEntity.bankName, newEntity.bankName);
    };

    /**
     * 判断两个值是否不同，如果不同返回1
     * @param value1
     * @param value2
     * @returns {string}
     */
    function getChangedFlag (value1, value2) {
        if (value1 != value2){
            return '1';
        }
    };

    /**
     * 返回
     * @param status
     */
    $scope.close = function(){
        $location.path('app/postbiz_invoice_change_list');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.invoiceChange;
    $scope.wfLogNo = $scope.invoiceTaskNo;

}]);


