/**
 * Created by lijunjun on 2018-08-28.
 */
app.controller('invoice_change_save_controller', ['$scope', '$http','$modal','toaster', '$location','$timeout', function ($scope, $http,$modal,toaster,$location,$timeout) {

    $scope.invoiceChange={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.InvoiceChangePostVo = {};
    $scope.cstmCompany = {};
    $scope.oldCstmCompany = {};
    $scope.fileType = CommonCodeUtils.basFileTypes.invoiceChangeFile;
    $scope.treeFileId = "invoice_change_file_tree";
    $scope.notUpload = false;
    $scope.invoiceTaskNo = '';
    $scope.taskId = '';
    $scope.socialCertifNo = '';
    if ($location.search()['serviceParameter']){
        if ($location.search()['serviceParameter'].paramVariables.socialCertifNo){
            $scope.socialCertifNo = $location.search()['serviceParameter'].paramVariables.socialCertifNo;
        }
        console.log($scope.socialCertifNo);
    } else {
        $scope.socialCertifNo = $location.search()['socialCertifNo'];
    }
    if ($location.search()['serviceId']){
        $scope.invoiceTaskNo = $location.search()['serviceId'];
    }
    if ($location.search()['taskId']){
        $scope.taskId = $location.search()['taskId'];
    }

    $http.get('invoice_change/findApplyInvoiceVosBySocialCertifNo?socialCertifNo='+ $scope.socialCertifNo+'&invoiceTaskNo='+$scope.invoiceTaskNo).success(function(data){
        $scope.cstmCompany = $.extend(true,{},data.data.newInvoiceChangeVo);
        $scope.oldCstmCompany = $.extend(true,{},data.data.oldInvoiceChangeVo);
        $scope.oldCstmCompany.invoiceTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceType,$scope.oldCstmCompany.invoiceType);
        if (data.data.bizFilesList){
            $scope.bizFilesList = data.data.bizFilesList;
        }
    });

    /**
     * 开票信息变更申请提交
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            // 判断附件是否上传
            if($scope.notUpload){
                modalAlert($modal,$scope.notUploadInfo);
                $scope.submit = false;
                return false;
            }
            var modifyFlag = modifyCheck();
            if (modifyFlag){
                $scope.submit = true;
                $scope.InvoiceChangePostVo.oldInvoiceChangeVo = $scope.oldCstmCompany;//变更前
                $scope.InvoiceChangePostVo.newInvoiceChangeVo = $scope.cstmCompany;//变更后
                $scope.InvoiceChangePostVo.taskId = $scope.taskId;//taskId
                $scope.InvoiceChangePostVo.invoiceTaskNo = $scope.invoiceTaskNo;//任务号
                $scope.InvoiceChangePostVo.bizFilesList = $scope.bizFilesList;//附件List
                $scope.InvoiceChangePostVo.remark = $scope.InvoiceChangePostVo.newInvoiceChangeVo.remark;//备注
                $http.post('invoice_change/saveInvoiceChange', $scope.InvoiceChangePostVo).success(function (data) {
                    if (data.code == Response.successCode){
                        if ($location.search()['type'] == 'list'){
                            $location.path('app/postbiz_invoice_company_list').search({type:'submit', msg:'申请提交成功'});
                        } else {
                            $location.path('app/home');
                        }
                    } else{
                        modalAlert($modal,data.message);
                    }
                    $scope.submit = false;
                 }).error(function(data){
                    modalAlert($modal,data);
                    $scope.submit = false;
                 })
            } else {
                modalAlert($modal,"没有信息改变，请变更开票信息后保存");
            }

        }else{
            $scope.formValidate = true;
            remindMsg($timeout,toaster);
        }
    }

    function modifyCheck () {
        if ($scope.cstmCompany.invoiceType == $scope.oldCstmCompany.invoiceType
            && $scope.cstmCompany.ticketOpening == $scope.oldCstmCompany.ticketOpening
            && $scope.cstmCompany.dutyParagraph == $scope.oldCstmCompany.dutyParagraph
            && $scope.cstmCompany.invoiceAddr == $scope.oldCstmCompany.invoiceAddr
            && $scope.cstmCompany.accountNumber == $scope.oldCstmCompany.accountNumber
            && $scope.cstmCompany.bankName == $scope.oldCstmCompany.bankName){
            return false;
        } else {
            return true;
        }
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        var type = $location.search()['type'];
        if (type == 'list'){
            $location.path('app/postbiz_invoice_company_list');
        } else {
            $location.path('app/home');
        }
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.invoiceChange;
    $scope.wfLogNo = $scope.invoiceTaskNo;

}]);


