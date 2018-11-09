/**
 * Created by ningyangyang on 2018/8/21.
 */
app.controller('fin_repay_sked_invoice_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {

    //扣款状态
    //$scope.repayStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.repayStatus);
    //业务类型
    //$scope.licenseAttrList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr);
    $scope.finRepaySked = {};
    $scope.finRepaySkeds = JSON.parse($location.search()['finRepaySkeds']);
    //如果开票金额不存在，使用收款金额
    for(var i in $scope.finRepaySkeds){
        if(!$scope.finRepaySkeds[i].invoiceAmount) {
            $scope.finRepaySkeds[i].invoiceAmount = $scope.finRepaySkeds[i].receiptAmount;
        }
    }

    //计算合计行
    var rentActualSum=0,principalSum=0,interestSum=0,invoiceAmountSum=0;
    for(var i in $scope.finRepaySkeds) {
        rentActualSum = $scope.finRepaySkeds[i].rentActual * 1 + rentActualSum;//应收租金
        principalSum = $scope.finRepaySkeds[i].principal * 1 + principalSum;//当期本金
        interestSum = $scope.finRepaySkeds[i].interest * 1 + interestSum;//当期利息
        invoiceAmountSum = $scope.finRepaySkeds[i].invoiceAmount * 1 + invoiceAmountSum;//开票金额
    }
    $scope.finRepaySked.groupDistrict='合计';
    $scope.finRepaySked.rentActual=rentActualSum.toFixed(2);
    $scope.finRepaySked.principal=principalSum.toFixed(2);
    $scope.finRepaySked.interest=interestSum.toFixed(2);
    $scope.finRepaySked.invoiceAmount=invoiceAmountSum.toFixed(2);

    $scope.sumAmount = function (){
        var rentActualSum=0,principalSum=0,interestSum=0,invoiceAmountSum=0;
        for(var i in $scope.finRepaySkeds) {
            rentActualSum = $scope.finRepaySkeds[i].rentActual * 1 + rentActualSum;//应收租金
            principalSum = $scope.finRepaySkeds[i].principal * 1 + principalSum;//当期本金
            interestSum = $scope.finRepaySkeds[i].interest * 1 + interestSum;//当期利息
            invoiceAmountSum = $scope.finRepaySkeds[i].invoiceAmount * 1 + invoiceAmountSum;//开票金额
        }
        $scope.finRepaySked.groupDistrict='合计';
        $scope.finRepaySked.rentActual=rentActualSum.toFixed(2);
        $scope.finRepaySked.principal=principalSum.toFixed(2);
        $scope.finRepaySked.interest=interestSum.toFixed(2);
        $scope.finRepaySked.invoiceAmount=invoiceAmountSum.toFixed(2);
    }

    //提交开票信息post
    $scope.save = function () {
        if(checkData()) {
            $scope.submit = true;
            $http.post('fin_repay_sked/finRepaySkedInvoice',$scope.finRepaySkeds).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("app/finance_fin_repay_sked_list").search({'msg':'开票成功'});
                else
                    modalAlert($modal,data.message);
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            });
        }else{
            $scope.formValidate = true;
        }

    }


    function checkData() {
        for(var i = 0;i<$scope.finRepaySkeds.length;i++) {
            if((Number($scope.finRepaySkeds[i].invoiceAmount)>0 && CommonStringUtils.isTrimBlank($scope.finRepaySkeds[i].invoiceDate))
            || (Number($scope.finRepaySkeds[i].invoiceAmount)<=0 && CommonStringUtils.isNotTrimBlank($scope.finRepaySkeds[i].invoiceDate))) {
                modalAlert($modal,"第"+(i+1)+"行开票金额和日期必须同时存在");
                return false;
            }
        }
        return true;
    }

    //监听批量录入的日期
    $scope.init = false;
    $scope.$watch("allInvoiceDate",function(newVal,oldVal){
        if($scope.init){
            angular.forEach($scope.finRepaySkeds,function (val) {
                val.invoiceDate = newVal;
            })
        }else{
            $scope.init = true;
        }
    })


  //返回
    $scope.goBack = function () {
        $location.path('app/finance_fin_repay_sked_list');
    }

}])
;
