/**
 * Created by lijunjun on 2018-05-23.
 */
app.controller('quotation_device_modify_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location', function ($scope, $http, $modal, toaster,$compile, $location) {

    $scope.quotationDeviceVo = {};
    //报价类型
    $scope.quotationTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.quotationType);
    //申请类型
    $scope.applyTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.applyType);

    $http.get('quotation_device/findSysParam').success(function (data) {
        if (data.code == Response.successCode){
            $scope.commercialInsuranceRate = data.data.commercialInsuranceRate;//保险费率
            $scope.purchaseTaxRate = data.data.purchaseTaxRate;//购置税税率
        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    $http.get('quotation_device/findQuotationDeviceByQuotationDeviceId?quotationDeviceId='+$location.search()['quotationDeviceId']).success(function (data) {
        $scope.quotationDeviceVo = data.data;
    });


    //车辆标签价监视
    $scope.$watch('quotationDeviceVo.cehicleLabelPrice', function(newVal, oldVal){
        if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
            $scope.quotationDeviceVo.purchaseTax = Math.ceil(newVal/((1+$scope.purchaseTaxRate*1)*10));
            $scope.quotationDeviceVo.commercialInsurance = Math.ceil(newVal*($scope.commercialInsuranceRate*1));
        }
    });

    //车辆成交价监视
    // 购置税监视
    $scope.$watch('quotationDeviceVo.cehicleTransactionPrice + quotationDeviceVo.purchaseTax + quotationDeviceVo.commercialInsurance + quotationDeviceVo.boardServiceCharge + quotationDeviceVo.highRiskVehicleTax + quotationDeviceVo.fineQuality', function(newVal, oldVal){
        if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
            // 申请金额=车辆成交价+购置税+商业保险+上牌综合服务+交强险车船税+精品/选装
            $scope.quotationDeviceVo.applicationAmount = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.cehicleTransactionPrice)
                + CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.purchaseTax) + CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.commercialInsurance)
                + CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.boardServiceCharge) + CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.highRiskVehicleTax)
                + CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.fineQuality));
        }
    });

    //申请金额监视
    $scope.$watch('quotationDeviceVo.applicationAmount', function(newVal, oldVal){
        if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
            //首付款=申请金额*首付比例
            $scope.quotationDeviceVo.firstPayment = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
                * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.downPaymentRatio) * 0.01);
            //尾付款=申请金额*尾付比例
            $scope.quotationDeviceVo.tailMoney = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
                * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.tailProportion) * 0.01);
            //融资额=申请金额-首付款
            $scope.quotationDeviceVo.financingAmount = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
                - CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.firstPayment));
            //保证金=申请金额*保证金比例
            $scope.quotationDeviceVo.bond = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
                * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.marginLevel) * 0.01);
        }
    });

    //融资额监视
    $scope.$watch('quotationDeviceVo.financingAmount', function(newVal, oldVal){
        if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
            //年供金额=融资额*年供比例
            $scope.quotationDeviceVo.annualSupplyAmount = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.financingAmount)
                * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.annualSupplyRate));
        }
    });

    //首付比例监视
    $scope.$watch('quotationDeviceVo.downPaymentRatio', function(newVal, oldVal){
        if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
            //首付款=申请金额*首付比例
            $scope.quotationDeviceVo.firstPayment = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
                * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.downPaymentRatio) * 0.01);
        }
    });

    //尾付比例监视
    $scope.$watch('quotationDeviceVo.tailProportion', function(newVal, oldVal){
        if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
            //尾付款=申请金额*尾付比例
            $scope.quotationDeviceVo.tailMoney = Math.ceil($scope.quotationDeviceVo.applicationAmount)
                * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.tailProportion * 0.01);
        }
    });

    //大客户补贴比例监视
    $scope.$watch('quotationDeviceVo.customerSubsidyRatio', function(newVal, oldVal){
        if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
            //大客户补贴金额=车辆标签价*大客户补贴比例
            $scope.quotationDeviceVo.customerSubsidyAmount = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.cehicleLabelPrice)
                * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.customerSubsidyRatio) * 0.01);
        }
    });

    //年供比例监视
    $scope.$watch('quotationDeviceVo.annualSupplyRate', function(newVal, oldVal){
        if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
            //年供金额=年供比例*融资额
            $scope.quotationDeviceVo.annualSupplyAmount = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.annualSupplyRate)
                * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.financingAmount) * 0.01);
        }
    });

    //保证金比例监视
    $scope.$watch('quotationDeviceVo.marginLevel', function(newVal, oldVal){
        if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
            //保证金=申请金额*保证金比例
            $scope.quotationDeviceVo.bond = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
                * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.marginLevel) * 0.01);
        }
    });

    $scope.firstPaymentChange = function () {
        //首付比例=首付款/申请金额
        $scope.quotationDeviceVo.downPaymentRatio = Math.ceil(100 * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.firstPayment)
            /CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount));

        //融资额=申请金额-首付款
        $scope.quotationDeviceVo.financingAmount = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
            - CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.firstPayment));
    }

    $scope.tailMoneyChange = function () {
        //首付比例=首付款/申请金额
        $scope.quotationDeviceVo.tailProportion = Math.ceil(100 * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.tailMoney)
            /CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount));
    }

    $scope.annualSupplyAmountChange = function () {
        //年供比例=年供金额/融资额
        $scope.quotationDeviceVo.annualSupplyRate = Math.ceil(100 * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.annualSupplyAmount)
            /CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.financingAmount));
    }

    $scope.calculate = function () {
        $http.post('quotation_device/saveQuotationDeviceInfo', $scope.quotationDeviceVo).success(function (result) {
            if (result.code == Response.successCode) {
                $scope.quotationDeviceVo = result.data;
            } else {
                modalAlert($modal,result.message);
            }
            $scope.submit = false;
        });
    }

    // 选择车型
    $scope.selectBasVehicle = function () {
        var basVehicle = {};
        basVehicle.vehicleLevel = '4';// 级别  4-车型
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_vehicle/bas_vehicle_list_select.html'+getCacheTime(),
            controller: 'bas_vehicle_list_select_controller',
            resolve:{
                basVehicle: function () { return basVehicle;}
            }
        });
        rtn.result.then(function (basVehicle) {
            if(basVehicle){
                $scope.quotationDeviceVo.vehicleName = basVehicle.vehicleName;
                $scope.quotationDeviceVo.vehicleCode = basVehicle.vehicleCode;
            }
        },function(){
        });
    };

    $scope.backUp = function () {
        $location.path("app/prebiz_quotation_device_list");
    }

    //跳转
    //todo
    $scope.goApplyInput = function(){
        $scope.calculate();
        //参数：$scope.quotationDeviceVo
        //申请类型：个人
        if($scope.quotationDeviceVo.applyType == "" || $scope.quotationDeviceVo.applyType == "" ){

        }else{
            //申请类型：企业
        }
    }
}]);