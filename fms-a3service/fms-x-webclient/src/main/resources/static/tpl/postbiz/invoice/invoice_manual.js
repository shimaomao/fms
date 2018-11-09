/**
 * Created by qiaohao on 2018-09-10.
 */
app.controller('invoice_manual_controller', ['$scope', '$http','$modal', '$location','toaster', function ($scope, $http,$modal, $location,toaster) {

    $scope.invoice={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.invoices = $location.search()['invoices'];

    //计算合计金额
    var receiveActualAccountSum=0,invoiceAmountSum=0;
    for(var i in $scope.invoices){
        receiveActualAccountSum=$scope.invoices[i].receiveActualAccount * 1 + receiveActualAccountSum;//收款金额
        invoiceAmountSum=$scope.invoices[i].invoiceAmount * 1 + invoiceAmountSum;//开票金额
    }
    $scope.invoice.invoiceDataType='合计';
    $scope.invoice.receiveActualAccount=receiveActualAccountSum.toFixed(2);//收款金额
    $scope.invoice.invoiceAmount=invoiceAmountSum.toFixed(2);//开票金额

    $scope.sumAmount = function (){
        var receiveActualAccountSum=0,invoiceAmountSum=0;
        for(var i in $scope.invoices){
            receiveActualAccountSum=$scope.invoices[i].receiveActualAccount * 1 + receiveActualAccountSum;//收款金额
            invoiceAmountSum=$scope.invoices[i].invoiceAmount * 1 + invoiceAmountSum;//开票金额
        }
        $scope.invoice.invoiceDataType='合计';
        $scope.invoice.receiveActualAccount=receiveActualAccountSum.toFixed(2);//收款金额
        $scope.invoice.invoiceAmount=invoiceAmountSum.toFixed(2);//开票金额
    }


    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {
        for(var i in $scope.invoices){
            var val = $scope.invoices[i];

            if((Number(val.invoiceAmount)>0 && CommonStringUtils.isTrimBlank(val.invoiceDate))
                || (Number(val.invoiceAmount)<=0 && CommonStringUtils.isNotTrimBlank(val.invoiceDate))) {
                modalAlert($modal,"第"+(i*1+1)+"行开票金额和日期必须同时存在");
                return ;
            }

            if(CommonStringUtils.isNotTrimBlank(val.invoiceStatus) && val.invoiceStatus != CommonCodeUtils.invoiceStatus.noInvoice){
                modalAlert($modal,'合同号: ' + val.contNo + ',已经开票,不能重复开票');
                return;
            }
        }
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.put('invoice/invoiceManual', $scope.invoices).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("app/postbiz_invoice_list");
                else
                    modalAlert($modal,data.message);
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

    //监听批量录入的日期
    $scope.init = false;
    $scope.$watch("allInvoiceDate",function(newVal,oldVal){
        if($scope.init){
            angular.forEach($scope.invoices,function (val) {
                val.invoiceDate = newVal;
            })
        }else{
            $scope.init = true;
        }
    })

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("app/postbiz_invoice_list");
    };

}]);


