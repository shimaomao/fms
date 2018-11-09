app.controller('risk_report_company_save_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster, $compile, $location) {
    $scope.dateParams = JSON.stringify({dateFmt:'yyyy.MM'});
    $scope.dateParams1 = JSON.stringify({dateFmt:'yyyy-MM'});

    $scope.disabled = $scope.$parent.disabled;
    $scope.$on('riskDataToSon',function (e,data) {
        $scope.riskData = data;
        var length = $scope.riskData.riskPersonVoGuarList.length;
        if(length>0){
            for(var i=0;i<length;i++){
                $scope.riskData.riskPersonVoGuarList[i].pbcCredit.debitRestRatio = $scope.riskData.riskPersonVoGuarList[i].pbcCredit.debitRestRatio?$scope.riskData.riskPersonVoGuarList[i].pbcCredit.debitRestRatio:0;
                $scope.riskData.riskPersonVoGuarList[i].pbcCredit.debitUsedRatio = $scope.riskData.riskPersonVoGuarList[i].pbcCredit.debitUsedRatio?$scope.riskData.riskPersonVoGuarList[i].pbcCredit.debitUsedRatio:0;
            }
        }
    });

    $scope.$watch('riskData',function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal){
            $scope.$emit("riskDataToFather",$scope.riskData);
        }
    },true);

    //人行征信信息
    //贷款余额占授信额度比例（ B/A*100% ）
    $scope.percentageA = function (a) {
        if(a.pbcCredit.creditAmount && a.pbcCredit.creditRest){
            a.pbcCredit.debitRestRatio = percentage(a.pbcCredit.creditAmount,a.pbcCredit.creditRest,1);
        }else{
            a.pbcCredit.debitRestRatio = 0;
        }
        a.pbcCredit.elseCreditRest = a.pbcCredit.creditRest-a.pbcCredit.propertyCreditRest-a.pbcCredit.carCreditRest;
        if (isNotUndefinedNull(a.pbcCredit.elseCreditRest) && !isNaN(a.pbcCredit.elseCreditRest))
            a.pbcCredit.elseCreditRest = Math.round(a.pbcCredit.elseCreditRest.toFixed(2) * 100) / 100;
    };
    //贷记卡已使用信用额度占授信额度比例（F/E*100%）
    $scope.percentageB = function (a) {
        if(a.pbcCredit.debitCardAmount && a.pbcCredit.debitCardUsed){
            a.pbcCredit.debitUsedRatio = percentage(a.pbcCredit.debitCardAmount,a.pbcCredit.debitCardUsed,1);
        }else{
            a.pbcCredit.debitUsedRatio = 0;
        }
    };
    //其他贷款余额
    $scope.otherRest = function (a) {
        a.pbcCredit.elseCreditRest = a.pbcCredit.creditRest - a.pbcCredit.propertyCreditRest - a.pbcCredit.carCreditRest;
        if (isNotUndefinedNull(a.pbcCredit.elseCreditRest) && !isNaN(a.pbcCredit.elseCreditRest))
            a.pbcCredit.elseCreditRest = Math.round(a.pbcCredit.elseCreditRest.toFixed(2) * 100) / 100;

    };
    //最早卡户记录距今月数
    $scope.getMonNum = function (a) {
        if(a.pbcCredit.firstCreditYm != null){
            a.pbcCredit.monthMax = getMonNum(a.pbcCredit.firstCreditYm);
        }
    };

    //小数点后两位百分比
    function percentage(number1, number2,type) {
        if(number1==0 || number2==0){
            return 0;
        }else{
            if(type==1){
                return (Math.round(number2 / number1 * 10000) / 100.00 + "%");
            }else{
                return (number2/number1).toFixed(2);
            }
        }

    }

    //计算流水 平均/合计
    $scope.setSumAver = function (data,index) {
        var length = data.accountDetailLists.length;
        var number = 0;
        var $incomeSum = 0,$receiptSum = 0,$actualIncomeSum = 0;
        var $incomeAver = 0,$receiptAver = 0,$actualIncomeAver = 0;
        var b = data.accountDetailLists[index];
        b.actualIncome = Math.round(b.income - b.receipt);
        for(var i=0;i<length;i++){
            if(CommonObjectUtils.isExist(data.accountDetailLists[i].income) && data.accountDetailLists[i].yearMon){
                $incomeSum += data.accountDetailLists[i].income*1;
                number++;
            }
            if(CommonObjectUtils.isExist(data.accountDetailLists[i].receipt) && data.accountDetailLists[i].yearMon){
                $receiptSum += data.accountDetailLists[i].receipt*1;
            }
            if(CommonObjectUtils.isExist(data.accountDetailLists[i].actualIncome) && data.accountDetailLists[i].yearMon){
                $actualIncomeSum += data.accountDetailLists[i].actualIncome*1;
            }
        }
        data.incomeSum = Math.round($incomeSum);
        data.receiptSum = Math.round($receiptSum);
        data.actualIncomeSum = Math.round($actualIncomeSum);

        data.incomeAver = Math.round($incomeSum/number);
        data.receiptAver = Math.round($receiptSum/number);
        data.actualIncomeAver = Math.round($actualIncomeSum/number);

    };

    //计算流水 日均存款结余余额
    $scope.getIntrest = function(data,quarterIntrest,dayIntrest){
        data[dayIntrest] = Math.round(data[quarterIntrest]*4/0.0035);
    };

    //收入负债比测算
    $scope.debtRatio = function (data,a,b,c,d) {
        //购车每月租金
        var rent = 0;
        if($scope.riskData.riskMgmtComp){
            rent = $scope.riskData.riskMgmtComp.rent;
        }
        //如果计算的是承租人收入负债比，则不再计算每月租金
        if(data.lesseeRevenue){
            rent = 0;
        }
        if(!rent){
            rent = 0;
        }

        if(data.lesseeRevenue && data.lesseeProfitRatio){
            data.lesseeAmount = Math.round(data.lesseeRevenue*data.lesseeProfitRatio/12/100);
        }else{
            data.lesseeAmount = 0;
        }
        if(data.lesseeRepay || data.rent){
            data.lesseeDebtAmount = Math.round(data.lesseeRepay*1 + data.rent*1);
        }else{
            data.lesseeDebtAmount = 0;
        }
        if(data[c]*1+rent*1 && data[b]){
            data[a] = percentage(data[c]*1+rent*1,data[b],2);
        }else{
            data[a] = 0;
        }

        //如果是租金，重新计算所有担保人收入负债比
        if(d == "rent"){
            for(var i = 0;i<$scope.riskData.riskMgmtGuaranteeList.length;i++){
                $scope.debtRatio($scope.riskData.riskMgmtGuaranteeList[i],'guaranteeDebtRatio','guaranteeAmount','guaranteeRepay');
            }
        }
    };
}]);