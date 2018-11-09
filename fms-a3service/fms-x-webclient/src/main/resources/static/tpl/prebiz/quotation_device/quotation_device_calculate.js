/**
 * Created by lijunjun on 2018-05-23.
 */
app.controller('quotation_device_calculate_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {
    $scope.quotationDeviceVo = {};
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.detailFlag = $location.search()['detailFlag'];

    $scope.quotationDeviceVo.customerInterestRate = 0;//客户利率初始化
    $scope.quotationDeviceVo.cehicleLabelPrice = 0;//车辆标签价初始化
    $scope.quotationDeviceVo.cehicleTransactionPrice = 0;//车辆成交价初始化
    $scope.quotationDeviceVo.cehiclePurchasingPrice = 0;//车辆采购价初始化
    $scope.quotationDeviceVo.purchaseTax = 0;//购置税初始化
    $scope.quotationDeviceVo.commercialInsurance = 0;//商业保险初始化
    $scope.quotationDeviceVo.boardServiceCharge = 0;//上牌综合服务初始化
    $scope.quotationDeviceVo.highRiskVehicleTax = 0;//交强险车船税初始化
    $scope.quotationDeviceVo.fineQuality = 0;//精品/选装初始化
    $scope.quotationDeviceVo.applicationAmount = 0;//申请金额初始化
    $scope.quotationDeviceVo.serviceCharge = 0;//手续费初始化
    $scope.quotationDeviceVo.financingAmount = 0;//融资额（计息）初始化
    $scope.quotationDeviceVo.restitutionFee = 0;//返还经销商手续费初始化
    $scope.quotationDeviceVo.renewDeposit = 0;//续保押金初始化
    $scope.quotationDeviceVo.channelCommission = 0;//渠道佣金初始化
    $scope.quotationDeviceVo.cashReward = 0;//现金奖励初始化
    $scope.quotationDeviceVo.internalFormation = 0;//内部提成初始化
    // $scope.quotationDeviceVo.loanTerm = 0;//贷款期限初始化
    $scope.quotationDeviceVo.customerSubsidyRatio = 0;//大客户补贴比例初始化
    $scope.quotationDeviceVo.customerSubsidyAmount = 0;//大客户补贴金额初始化
    $scope.quotationDeviceVo.backPurchase = 0;//回购价初始化
    $scope.quotationDeviceVo.downPaymentRatio = 0;//首付款比例初始化
    $scope.quotationDeviceVo.firstPayment = 0;//首付款初始化
    $scope.quotationDeviceVo.marginLevel = 0;//保证金比例初始化
    $scope.quotationDeviceVo.bond = 0;//保证金初始化
    $scope.quotationDeviceVo.tailProportion = 0;//尾款比例初始化
    $scope.quotationDeviceVo.tailMoney = 0;//尾款金额初始化
    $scope.quotationDeviceVo.annualSupplyRate = 0;//年供比例初始化
    $scope.quotationDeviceVo.annualSupplyAmount = 0;//年供金额初始化
    //报价类型
    $scope.quotationTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr);
    //申请类型
    $scope.applyTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.quoApplyType);

    // 投资总额、首尾付总额、保证金总额：1-根据比例算金额；0-根据金额算比例
    $scope.initType = $scope.finalType = $scope.depositType = 1;

    //获取产品方案
    $http.get('product/findProductVoListByGroupCodes').success(function (result) {
        if (result.code == Response.successCode){
            $scope.productList = result.data;
        }else{
            modalAlert($modal,result.message);
        }
    });

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
    $scope.quotationDeviceId = $location.search()['quotationDeviceId'];
    if(isNotUndefinedNull($scope.quotationDeviceId)){
        $http.get('quotation_device/findQuotationDeviceByQuotationDeviceId?quotationDeviceId='+$scope.quotationDeviceId).success(function (data) {
            if (data.code == Response.successCode){
                $scope.quotationDeviceVo = data.data;
                init();
                console.log($scope.quotationDeviceVo);
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    }
    function init(){
        if($scope.quotationDeviceVo.firstPayment == Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
                * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.downPaymentRatio) * 0.01)){
            $scope.initType  = 1;
        }else{
            $scope.initType  = 0;
        }
        if($scope.quotationDeviceVo.tailMoney == Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
                * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.tailProportion) * 0.01)){
            $scope.finalType = 1;
        }else{
            $scope.finalType = 0;
        }
        if($scope.quotationDeviceVo.bond == Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
                * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.marginLevel) * 0.01)){
            $scope.depositType = 1;
        }else{
            $scope.depositType = 0;
        }
        // 投资总额、首尾付总额、保证金总额：1-根据比例算金额；0-根据金额算比例
        // $scope.initType = $scope.finalType = $scope.depositType = 1;

    }

    //车辆标签价监视
    $scope.$watch('quotationDeviceVo.cehicleLabelPrice', function(newVal, oldVal){
        if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
            if ($scope.purchaseTaxRate){
                $scope.quotationDeviceVo.purchaseTax = Math.ceil(newVal/$scope.purchaseTaxRate*1);
            }
            if ($scope.commercialInsuranceRate){
                $scope.quotationDeviceVo.commercialInsurance = Math.ceil(newVal*($scope.commercialInsuranceRate*1));
            }
            sunInvestTotal();
        }
    });

    //车辆成交价监视
    // 购置税监视
    $scope.changeTracsactionPrice = function(){
        $scope.quotationDeviceVo.cehiclePurchasingPrice = $scope.quotationDeviceVo.cehicleTransactionPrice;
        sunInvestTotal();
    };

    // 所有融资项目的融资金额发生变化时
    $scope.changeFinItemAmount = function () {
        // 重新计算投资额信息
        sunInvestTotal();
    };

    //合计申请金额
    function sunInvestTotal(){
        // 申请金额=车辆成交价+购置税+商业保险+上牌综合服务+交强险车船税+精品/选装
        $scope.quotationDeviceVo.applicationAmount = Math.ceil(
            CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.cehicleTransactionPrice)
            + CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.purchaseTax)
            + CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.commercialInsurance)
            + CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.boardServiceCharge)
            + CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.highRiskVehicleTax)
            + CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.fineQuality));
    }

    
    //申请金额监视
    $scope.$watch('quotationDeviceVo.applicationAmount', function(newVal, oldVal){
        if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
            //首付款=申请金额*首付比例
            if($scope.initType == 1){
                $scope.quotationDeviceVo.firstPayment = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
                    * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.downPaymentRatio) * 0.01);
            }else{
                //首付比例=首付款/申请金额
                $scope.quotationDeviceVo.downPaymentRatio = Math.round(100 * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.firstPayment)
                    /CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount));
            }
            //根据首付款计算 融资额
            //融资额=申请金额-首付款
            $scope.quotationDeviceVo.financingAmount = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
                - CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.firstPayment));

            //尾付款=申请金额*尾付比例
            if($scope.finalType == 1){
                $scope.quotationDeviceVo.tailMoney = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
                    * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.tailProportion) * 0.01);
            }else{
                //尾付比例=尾付款/申请金额
                $scope.quotationDeviceVo.tailProportion = Math.round(100 * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.tailMoney)
                    /CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount));
            }

            //保证金=申请金额*保证金比例
            if($scope.depositType == 1) {
                $scope.quotationDeviceVo.bond = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
                    * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.marginLevel) * 0.01);
            }else{
                //保证金比例=保证金/申请金额
                $scope.quotationDeviceVo.marginLevel = Math.round(100 * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.bond)
                    /CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount));

            }
        }
    });

    //融资额监视
    $scope.$watch('quotationDeviceVo.financingAmount', function(newVal, oldVal){
        if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
            //年供金额=融资额*年供比例
            $scope.quotationDeviceVo.annualSupplyAmount = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.financingAmount)
                * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.annualSupplyRate) * 0.01);
        }
    });

    // //首付比例监视
    // $scope.$watch('quotationDeviceVo.downPaymentRatio', function(newVal, oldVal){
    //     if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
    //         //首付款=申请金额*首付比例
    //         $scope.quotationDeviceVo.firstPayment = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
    //             * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.downPaymentRatio) * 0.01);
    //     }
    // });

    //首付比例Change事件
    $scope.downPaymentRatioChange = function () {
        $scope.initype = 1;
        //首付款=申请金额*首付比例
        $scope.quotationDeviceVo.firstPayment = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
            * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.downPaymentRatio) * 0.01);
        //融资额=申请金额-首付款
        $scope.quotationDeviceVo.financingAmount = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
            - CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.firstPayment));
    };

    //尾付比例Change事件
    $scope.tailProportionChange=function () {

        if($scope.quotationDeviceVo.tailProportion*1 > 0 && $scope.quotationDeviceVo.annualSupplyRate*1 != 0 ){
            $scope.quotationDeviceVo.tailProportion = 0;
            modalAlert($modal,"年供产品不可输入尾付");
        }
        $scope.finalType = 1;
        //尾付款=申请金额*尾付比例
        $scope.quotationDeviceVo.tailMoney = Math.ceil($scope.quotationDeviceVo.applicationAmount
            * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.tailProportion * 0.01));

    };

    // //尾付比例监视
    // $scope.$watch('quotationDeviceVo.tailProportion', function(newVal, oldVal){
    //     if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
    //         //尾付款=申请金额*尾付比例
    //         $scope.quotationDeviceVo.tailMoney = Math.ceil($scope.quotationDeviceVo.applicationAmount
    //             * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.tailProportion * 0.01));
    //     }
    // });

    //大客户补贴比例监视
    // $scope.$watch('quotationDeviceVo.customerSubsidyRatio', function(newVal, oldVal){
    //     if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
    //         //大客户补贴金额=车辆标签价*大客户补贴比例
    //         $scope.quotationDeviceVo.customerSubsidyAmount = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.cehicleLabelPrice)
    //             * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.customerSubsidyRatio) * 0.01);
    //     }
    // });

    //年供比例监视
    $scope.annualSupplyRateChange = function(){
        //融资期限不是24/36
        if($scope.quotationDeviceVo.loanTerm != '48' && $scope.quotationDeviceVo.loanTerm != '36' && $scope.quotationDeviceVo.annualSupplyRate*1 > 0){
            $scope.quotationDeviceVo.annualSupplyRate = 0;
            modalAlert($modal,"融资期限是24或者36时才可输入年供比例");
        }
        if(($scope.quotationDeviceVo.tailProportion*1 != 0 || $scope.quotationDeviceVo.tailMoney*1 != 0) 
            && $scope.quotationDeviceVo.annualSupplyRate*1 > 0){
            $scope.quotationDeviceVo.annualSupplyRate = 0;
            modalAlert($modal,"有尾付，不可输入年供比例");
        }
        //年供金额=年供比例*融资额
        $scope.quotationDeviceVo.annualSupplyAmount = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.annualSupplyRate)
            * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.financingAmount) * 0.01);
    };

    // //年供金额修改比例监视
    // $scope.annualSupplyAmountChange = function(){
    //         //年供比例=申请金额*保证金比例
    //         $scope.quotationDeviceVo.bond = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
    //             * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.marginLevel) * 0.01);
    // };

    // //首付款监视
    // $scope.$watch('quotationDeviceVo.firstPayment', function(newVal, oldVal){
    //     if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
    //         //融资额=申请金额-首付款
    //         $scope.quotationDeviceVo.financingAmount = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
    //             - CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.firstPayment));
    //     }
    // });

    $scope.firstPaymentChange = function () {
        $scope.initType = 0;
        //首付比例=首付款/申请金额
        $scope.quotationDeviceVo.downPaymentRatio = Math.round(100 * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.firstPayment)
            /CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount));

        //融资额=申请金额-首付款
        $scope.quotationDeviceVo.financingAmount = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
            - CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.firstPayment));
    };
    
    $scope.tailMoneyChange = function () {

        if($scope.quotationDeviceVo.tailMoney*1 >0 && $scope.quotationDeviceVo.annualSupplyRate*1 != 0 ){
            $scope.quotationDeviceVo.tailMoney = 0;
            modalAlert($modal,"年供产品不可输入尾付");
        }
        $scope.finalType = 0;
        //尾付比例=尾付款/申请金额
        $scope.quotationDeviceVo.tailProportion = Math.round(100 * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.tailMoney)
            /CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount));


    };

    $scope.bondChange = function () {
        $scope.depositType = 0;
        //保证金比例=保证金/申请金额
        $scope.quotationDeviceVo.marginLevel = Math.round(100 * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.bond)
            /CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount));

    };
    $scope.marginLevelChange = function(){
        $scope.depositType = 1;
        $scope.quotationDeviceVo.bond = Math.ceil(CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.applicationAmount)
            * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.marginLevel) * 0.01);
    }

    // $scope.annualSupplyAmountChange = function () {
    //     //年供比例=年供金额/融资额
    //     if (!$scope.quotationDeviceVo.annualSupplyRate && $scope.quotationDeviceVo.annualSupplyRate == 0){
    //         $scope.quotationDeviceVo.annualSupplyRate = Math.ceil(100 * CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.annualSupplyAmount)
    //             /CommonDecimalUtils.TrimDecimal($scope.quotationDeviceVo.financingAmount));
    //     }
    // };
    // $scope.quotationDeviceVo = {"name":"张三","applyType":"11","quotationType":"0","customerInterestRate":14,"vehicleName":"测试车型","vehicleCode":"yyqtest","cehicleLabelPrice":318800,"purchaseTax":27248,"commercialInsurance":12752,"applicationAmount":343800,"firstPayment":17190,"tailMoney":0,"financingAmount":326610,"bond":34380,"annualSupplyAmount":0,"cehicleTransactionPrice":300000,"cehiclePurchasingPrice":300000,"boardServiceCharge":3800,"highRiskVehicleTax":0,"fineQuality":0,"serviceCharge":0,"restitutionFee":0,"renewDeposit":10000,"channelCommission":0,"cashReward":0,"internalFormation":0,"loanTerm":24,"customerSubsidyRatio":0,"customerSubsidyAmount":0,"downPaymentRatio":5,"marginLevel":10,"tailProportion":0,"remarks":"jklsdf"};
    function calculateData(actMode){
        //尾付比例和年供比例不能同时录入
        if (($scope.quotationDeviceVo.tailProportion*1>0 ||  $scope.quotationDeviceVo.tailProportion*1 > 0 )
            && ($scope.quotationDeviceVo.annualSupplyRate*1>0 || $scope.quotationDeviceVo.annualSupplyRate*1 > 0)){
            modalAlert($modal, "尾付与年供不能同时录入");
            return;
        }
        // //尾付金额和年供金额不能同时录入
        // if (($scope.quotationDeviceVo.tailMoney && $scope.quotationDeviceVo.tailMoney != 0)
        //     && ($scope.quotationDeviceVo.annualSupplyAmount && $scope.quotationDeviceVo.annualSupplyAmount != 0)){
        //     modalAlert($modal, "尾付金额与年供金额不能同时录入");
        //     return;
        // }
        if(!$scope.form.$invalid){
            $scope.submit = true;

            //计算
            if(actMode == '1' || actMode == '3'){
                $http.post('quotation_device/saveQuotationDeviceInfo', $scope.quotationDeviceVo).success(function (result) {
                    if (result.code == Response.successCode) {
                        $scope.quotationDeviceVo = result.data;
                        // if (actMode == '1'){
                        //
                        // }
                        //跳转
                        if(actMode == '3'){
                            var url;
                            switch ($scope.quotationDeviceVo.applyType*1){
                                //个人新车
                                case 11:
                                    url = "app/prebiz_apply_input";
                                    break;
                                //个人二手车
                                case 12:
                                    url = "app/old_apply_input";
                                    break;
                                //企业新车
                                case 21:
                                    url = "app/prebiz_apply_input_company";
                                    break;
                            }
                            url = '#/'+url+'?quotationDeviceVo='+JSON.stringify($scope.quotationDeviceVo);
                            window.open(url,'_self');
                            /*var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
                            if(window.parent.addTab){
                                window.parent.addTab(html);
                            }*/
                            /*$location.path(url).search({
                                "quotationDeviceVo": JSON.stringify($scope.quotationDeviceVo)
                            });*/
                        }
                    } else {
                        modalAlert($modal,result.message);
                    }
                    $scope.submit = false;
                });
            } else {
                $http.post('quotation_device/printQuotationDevice', $scope.quotationDeviceVo).success(function (result) {
                    if (result.code == Response.successCode) {
                        $scope.quotationDeviceVo = result.data;
                        //pdf生成
                        console.log(result.data.filePath);
                        window.parent.open('file/downloadFile?fileCompletePath='+result.data.filePath);
                    } else {
                        modalAlert($modal,result.message);
                    }
                    $scope.submit = false;
                });
            }
        } else {
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    }
    //计算
    $scope.calculate = function () {
        console.log($scope.quotationDeviceVo);
        calculateData('1');
    };
    
    $scope.printQuotationDevice = function () {
        console.log($scope.quotationDeviceVo);
        calculateData('2');
    };


    //跳转
     $scope.jump = function () {
         console.log($scope.quotationDeviceVo);
         calculateData('3');
     };

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
                $scope.quotationDeviceVo.cehicleLabelPrice = basVehicle.guidePrice;
            }
        },function(){
        });
    };

    $scope.backUp = function () {
        $location.path("app/prebiz_quotation_device_list");
    };

    /*用户组输入辅助*/
    $scope.addUser = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/product/product/product_user.html'+getCacheTime(),
            controller: 'product_user_controller',
            resolve:{
                setData: function () {
                    return {
                        "checkboxOrRadio": CheckBox
                    };
                }
            }
        });
        rtn.result.then(function (data) {
            if (data){
                // if (data.length > 1){
                //     modalAlert($modal, "最多只能选择一条数据");
                //     return;
                // }
                // if (data){
                    $scope.quotationDeviceVo.groupName = data.groupName;
                    $scope.quotationDeviceVo.groupCode = data.groupCode;
                    $scope.quotationDeviceVo.registeredAddr = data.registeredAddr;
                // }
            }
        },function(){

        });
    };

}]);