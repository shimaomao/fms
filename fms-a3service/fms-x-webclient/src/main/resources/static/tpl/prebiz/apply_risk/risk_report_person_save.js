app.controller('risk_report_person_save_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster, $compile, $location) {
    $scope.dateParams = JSON.stringify({dateFmt:'yyyy.MM'});
    $scope.dateParams1 = JSON.stringify({dateFmt:'yyyy-MM'});

    $scope.disabled = $scope.$parent.disabled;
    $scope.applyType = $scope.$parent.applyType;
    $scope.$on('riskDataToSon',function (e,data) {
        $scope.riskData = data;
        if($scope.applyType == 1){
            $scope.relationStr = 'relationPer2';
        }else{
            $scope.relationStr = 'relationPerComp';
        }
    });

    $scope.$watch('riskData',function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal){
            if($scope.riskData.riskPersonVoMain != null){
                //贷款余额占授信额度比例（ B/A*100% ）
                if($scope.riskData.riskPersonVoMain.pbcCredit.creditAmount && $scope.riskData.riskPersonVoMain.pbcCredit.creditRest){
                    $scope.riskData.riskPersonVoMain.pbcCredit.debitRestRatio = percentage($scope.riskData.riskPersonVoMain.pbcCredit.creditAmount,$scope.riskData.riskPersonVoMain.pbcCredit.creditRest,1);
                }else{
                    $scope.riskData.riskPersonVoMain.pbcCredit.debitRestRatio = 0;
                }
                //贷记卡已使用信用额度占授信额度比例（F/E*100%）
                if($scope.riskData.riskPersonVoMain.pbcCredit.debitCardAmount && $scope.riskData.riskPersonVoMain.pbcCredit.debitCardUsed){
                    $scope.riskData.riskPersonVoMain.pbcCredit.debitUsedRatio = percentage($scope.riskData.riskPersonVoMain.pbcCredit.debitCardAmount,$scope.riskData.riskPersonVoMain.pbcCredit.debitCardUsed,1);
                }else{
                    $scope.riskData.riskPersonVoMain.pbcCredit.debitUsedRatio = 0;
                }
                //最早卡户记录距今月数
                if(oldVal){
                    if(newVal.riskPersonVoMain.pbcCredit.firstCreditYm != oldVal.riskPersonVoMain.pbcCredit.firstCreditYm){
                        $scope.riskData.riskPersonVoMain.pbcCredit.monthMax = getMonNum(newVal.riskPersonVoMain.pbcCredit.firstCreditYm);
                    }
                }else {
                    if(newVal.riskPersonVoMain.pbcCredit.firstCreditYm){
                        $scope.riskData.riskPersonVoMain.pbcCredit.monthMax = getMonNum(newVal.riskPersonVoMain.pbcCredit.firstCreditYm);
                    }
                }
                //其他贷款余额
                $scope.riskData.riskPersonVoMain.pbcCredit.elseCreditRest = $scope.riskData.riskPersonVoMain.pbcCredit.creditRest-$scope.riskData.riskPersonVoMain.pbcCredit.propertyCreditRest-$scope.riskData.riskPersonVoMain.pbcCredit.carCreditRest;
                if (isNotUndefinedNull($scope.riskData.riskPersonVoMain.pbcCredit.elseCreditRest) && !isNaN($scope.riskData.riskPersonVoMain.pbcCredit.elseCreditRest))
                    $scope.riskData.riskPersonVoMain.pbcCredit.elseCreditRest = Math.round($scope.riskData.riskPersonVoMain.pbcCredit.elseCreditRest.toFixed(2) * 100) / 100;
            }
            $scope.$emit("riskDataToFather",$scope.riskData);
        }
    },true);

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
                number ++;
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
        if($scope.riskData.riskMgmtPerson){
            rent = $scope.riskData.riskMgmtPerson.rent;
        }
        //如果计算的是承租人收入负债比，则不再计算每月租金
        if(data.lesseeSalary){
            rent = 0;
        }
        if(!rent){
            rent = 0;
        }

        if(data.lesseeSalary && data.lesseeElseSalary){
            data.lesseeAmount = Math.round(data.lesseeSalary*1 + data.lesseeElseSalary*1);
        }else{
            data.lesseeAmount = 0;
        }
        if(data.lesseeRepay && data.rent){
            data.lesseeDebtAmount = Math.round(data.lesseeRepay*1 + data.rent*1);
        }else{
            data.lesseeDebtAmount = 0;
        }

        if(data[c] && data[b]){
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
