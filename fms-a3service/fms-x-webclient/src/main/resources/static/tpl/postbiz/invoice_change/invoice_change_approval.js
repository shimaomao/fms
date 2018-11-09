/**
 * Created by lijunjun on 2018-08-28.
 */
app.controller('invoice_change_approval_controller', ['$scope', '$http','$modal','toaster', '$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.invoiceChange={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.InvoiceChangePostVo = {};
    $scope.cstmCompany = {};
    $scope.oldCstmCompany = {};
    $scope.fileType = CommonCodeUtils.basFileTypes.invoiceChangeFile;
    $scope.treeFileId = "invoice_change_approval_file_tree";
    $scope.notUpload = false;
    if ($location.search()['serviceParameter']){
        if ($location.search()['serviceParameter'].paramVariables.socialCertifNo){
            $scope.socialCertifNo = $location.search()['serviceParameter'].paramVariables.socialCertifNo;
        }
        if ($location.search()['serviceParameter'].paramVariables.invoiceTaskNo){
            $scope.invoiceTaskNo = $location.search()['serviceParameter'].paramVariables.invoiceTaskNo;
        }
    }

    $http.get('invoice_change/findInvoiceChangeVosByInvoiceTaskNo?invoiceTaskNo='+ $scope.invoiceTaskNo).success(function(data){
        $scope.cstmCompany = $.extend(true,{},data.data.newInvoiceChangeVo);
        $scope.oldCstmCompany = $.extend(true,{},data.data.oldInvoiceChangeVo);
        // 判断每个项目是否变更过
        isChangedSolve($scope.oldCstmCompany, $scope.cstmCompany);
        $scope.oldCstmCompany.invoiceTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceType,$scope.oldCstmCompany.invoiceType);
        $scope.cstmCompany.invoiceTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceType,$scope.cstmCompany.invoiceType);
        $scope.bizFilesList = data.data.bizFilesList;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.InvoiceChangePostVo.oldInvoiceChangeVo = $scope.oldCstmCompany;//变更前
            $scope.InvoiceChangePostVo.newInvoiceChangeVo = $scope.cstmCompany;//变更后
            $scope.InvoiceChangePostVo.taskId = $location.search()['taskId'];
            $scope.InvoiceChangePostVo.invoiceTaskNo = $scope.invoiceTaskNo;
            $http.post('invoice_change/invoiceChangeApproval', $scope.InvoiceChangePostVo).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path('app/home');
                } else{
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
             }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
             })
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    }

    /**
     * 退回到申请
     */
    $scope.backUp = function () {

        $scope.submit = true;
        $scope.InvoiceChangePostVo.oldInvoiceChangeVo = $scope.oldCstmCompany;//变更前
        $scope.InvoiceChangePostVo.newInvoiceChangeVo = $scope.cstmCompany;//变更后
        $scope.InvoiceChangePostVo.taskId = $location.search()['taskId'];
        $scope.InvoiceChangePostVo.invoiceTaskNo = $scope.invoiceTaskNo;
        $http.post('invoice_change/invoiceChangeBackApply', $scope.InvoiceChangePostVo).success(function (data) {
            if (data.code == Response.successCode){
                $location.path('app/home');
            } else{
                modalAlert($modal,data.message);
            }
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    }

    /**
     * 拒绝
     */
    $scope.refuse = function () {

        $scope.submit = true;
        $scope.InvoiceChangePostVo.oldInvoiceChangeVo = $scope.oldCstmCompany;//变更前
        $scope.InvoiceChangePostVo.newInvoiceChangeVo = $scope.cstmCompany;//变更后
        $scope.InvoiceChangePostVo.taskId = $location.search()['taskId'];
        $scope.InvoiceChangePostVo.invoiceTaskNo = $scope.invoiceTaskNo;
        $http.post('invoice_change/invoiceChangeRefuse', $scope.InvoiceChangePostVo).success(function (data) {
            if (data.code == Response.successCode){
                $location.path('app/home');
            } else{
                modalAlert($modal,data.message);
            }
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    }

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
     * 返回主页
     * @param status
     */
    $scope.backHome = function(){
        $location.path('app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.invoiceChange;
    $scope.wfLogNo = $scope.invoiceTaskNo;

}]);


