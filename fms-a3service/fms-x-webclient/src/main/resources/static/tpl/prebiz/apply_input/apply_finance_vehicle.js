/**
 * Created by wangxue on 2018/4/2.
 */

app.controller('apply_finance_vehicle_controller',['$scope', '$http','$modal','toaster','$state','$location', function ($scope, $http, $modal, toaster,$state,$location) {
    // 融资方案信息
    $scope.applyFinanceVo = $scope.$parent.financeInfo.applyFinanceVo;
    // 车辆和融资明细信息
    $scope.vehicleFinList = $scope.$parent.financeInfo.vehicleFinList;
    // 申请类型
    $scope.applyType = $scope.applyFinanceVo.applyType;

    //系统常量
    var defaultAmout = CommonCodeUtils.getCommonParamValue('gpsFee');
    $scope.gpsValue = 0;
    // 车辆类型
    //$scope.vehicleForm = $scope.applyFinanceVo.vehicleForm;
    //判断是否是二手车
    if($state.current.name == 'app.old_apply_input' || $state.current.name == 'app.old_apply_input_company'){
        $scope.isOldCar = true;
        $scope.vehicleForm = 2;
    }else{
        $scope.isOldCar = false;
        $scope.vehicleForm = 1;
    }
    $scope.vehicleFormName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleForm,$scope.vehicleForm);

    $scope.vehTabClass = [];
    $scope.vehTabContentClass = [];
    $scope.applyVehicleId = '';
    $scope.vehicleDelDisabled = true;

    // 订单编号
    $scope.applyNo = $scope.$parent.applyNo;
    if (isNotUndefinedNull($scope.applyNo) && $scope.applyNo != '') {
        // 更新
        $http.get('apply_input/findApplyFinanceVehicleByApplyNo?applyNo='+ $scope.applyNo).success(function (data) {
            $scope.applyInputVo = data.data;
            // 融资方案信息
            $scope.applyFinanceVo = $scope.applyInputVo.applyFinanceVo;
            // 车辆和融资明细信息
            $scope.vehicleFinList = $scope.applyInputVo.applyVehicleVoList;
            // 车辆类型
            $scope.vehicleForm = $scope.applyFinanceVo.vehicleForm;
            $scope.vehicleFormName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleForm,$scope.vehicleForm);
            $scope.applyFinanceVo.vehicleFormName = $scope.vehicleFormName;
            // 申请类型
            $scope.applyFinanceVo.applyType = $scope.applyType;
            // 产品大类
            $scope.productCatgName = $scope.applyFinanceVo.productCatgName;

            if (CommonObjectUtils.isNotExist($scope.applyFinanceVo.finPeriodType)) {
                $scope.gpsValue = 0;
            }else{
                $scope.gpsValue = getYearCountByFinPeriod($scope.applyFinanceVo.finPeriodType)*defaultAmout;
            }

            //判断是否是二手车
            if($scope.vehicleForm == 2){
                $scope.isOldCar = true;
            }else{
                $scope.isOldCar = false;
            }
            // 初始化
            init();
        });
    } else {
        // 申请类型
        $scope.applyFinanceVo.applyType = $scope.applyType;
        // 车辆类型
        $scope.applyFinanceVo.vehicleForm = $scope.vehicleForm;
        $scope.applyFinanceVo.vehicleFormName = $scope.vehicleFormName;
        // 添加初始化
        init();
    }
    //从报价单画面跳转
    var quotationDeviceVo = $location.search()['quotationDeviceVo'];
    if(quotationDeviceVo) {
        quotationDeviceVo = JSON.parse(quotationDeviceVo);
        //取得产品方案信息
        $http.get('product/findProductVoByProduct?product=' + quotationDeviceVo.product).success(function (result) {
            if (result.code == Response.successCode) {
                var productVo = result.data;
                // 修改的场合信息初始化
                initForQuotation(productVo);
            }
        });
    }
    function initForQuotation(productVo){
        //报价单id
        $scope.applyFinanceVo.quotationDeviceId = quotationDeviceVo.quotationDeviceId;
        //申请类型
        if(quotationDeviceVo.applyType == "11" || quotationDeviceVo.applyType == "12"){
            $scope.applyFinanceVo.applyType = 1;
            $scope.applyType = 1;
        }else{
            $scope.applyFinanceVo.applyType = 2;
            $scope.applyType = 2;
        }
        //车辆类型
        if(quotationDeviceVo.applyType == "12"){
            $scope.applyFinanceVo.vehicleform = 2;
            $scope.isOldCar = true;
            $scope.vehicleForm = 2;
        }else{
            $scope.applyFinanceVo.vehicleform = 1;
            $scope.isOldCar = false;
            $scope.vehicleForm = 1;
        }
        //车辆类型
        $scope.vehicleFormName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleForm,$scope.vehicleForm);
        //产品大类
        $scope.applyFinanceVo.productCatg = productVo.productCatg;
        //产品方案
        $scope.applyFinanceVo.product = productVo.product;
        //业务类型
        $scope.licenseAttrList = CommonCodeUtils.getCommonCodesByValues(CommonCodeUtils.codeTypes.licenseAttr,productVo.licenseAttr);
        $scope.applyFinanceVo.licenseAttr = quotationDeviceVo.quotationType;

        //还款频率
        $scope.applyFinanceVo.repayRate = productVo.repayRate;
        $scope.applyFinanceVo.repayRateName =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.repayRate,$scope.applyFinanceVo.repayRate);
        //租金支付模式
        $scope.applyFinanceVo.rentPayMode = productVo.rentPayMode;
        $scope.applyFinanceVo.rentPayModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.rentPayMode,$scope.applyFinanceVo.rentPayMode);
        //还款方式
        $scope.applyFinanceVo.repayMode = productVo.repayMode;
        $scope.applyFinanceVo.repayModeName =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.repayMode,$scope.applyFinanceVo.repayMode);
        //保证金返还方式
        $scope.applyFinanceVo.depositRtnMode = productVo.depositRtnMode;
        $scope.applyFinanceVo.depositRtnModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.depositRtnMode,$scope.applyFinanceVo.depositRtnMode);

        //gps安装
        $scope.gpsInstModeList = CommonCodeUtils.getCommonCodesByValues(CommonCodeUtils.codeTypes.gpsInstMode, productVo.gpsInstMode);
        // 手续费收取方式
        $scope.chargePayModeList = CommonCodeUtils.getCommonCodesByValues(CommonCodeUtils.codeTypes.chargePayMode,productVo.chargePayMode);

        // 产品利率方案
        $scope.prodIntrstList = productVo.prodIntrstVoList;
        // 产品利率方案因子为空，则默认设置该利率方案
        if (isNotUndefinedNull($scope.prodIntrstList) && $scope.prodIntrstList.length > 0) {
            for(var i = 0; i < $scope.prodIntrstList.length; i++){
                var factorList = $scope.prodIntrstList[i].prodIntrstVoList;
                if(isUndefinedNull(factorList) || factorList.length == 0){
                    setIntrstInfo($scope.prodIntrstList[i]);
                }
            }
        }
        //客户利率
        $scope.applyFinanceVo.intrstRate = quotationDeviceVo.customerInterestRate;

        //申请金额-->	投资总额
        $scope.applyFinanceVo.investTotal = quotationDeviceVo.applicationAmount;
        //融资额
        $scope.applyFinanceVo.finTotal = quotationDeviceVo.financingAmount;
        //手续费
        // $scope.applyFinanceVo.charge = quotationDeviceVo.serviceCharge;

        //贷款期限
        $scope.finPeriodTypeList = CommonCodeUtils.getCommonCodesByValues(CommonCodeUtils.codeTypes.finPeriodType,productVo.finPeriodType);
        $scope.applyFinanceVo.finPeriodType = quotationDeviceVo.loanTerm;

        //首付款
        $scope.applyFinanceVo.initPerc = quotationDeviceVo.downPaymentRatio;
        $scope.applyFinanceVo.initAmount = quotationDeviceVo.firstPayment;
        //保证金
        $scope.applyFinanceVo.depositPerc = quotationDeviceVo.marginLevel;
        $scope.applyFinanceVo.deposit = quotationDeviceVo.bond;
        //尾付款
        $scope.applyFinanceVo.finalPerc = quotationDeviceVo.tailProportion;
        $scope.applyFinanceVo.finalAmount = quotationDeviceVo.tailMoney;
        //年供
        $scope.applyFinanceVo.annualSupplyRate = quotationDeviceVo.annualSupplyRate;
        $scope.applyFinanceVo.annualSupplyAmount = quotationDeviceVo.annualSupplyAmount;
        //出租人
        $scope.applyFinanceVo.belongGroup = quotationDeviceVo.groupCode;
        $scope.applyFinanceVo.belongGroupName = quotationDeviceVo.groupName;
        //irr
        $scope.applyFinanceVo.irr = quotationDeviceVo.irr;

        //每期租金
        $scope.applyFinanceVo.rent = quotationDeviceVo.monthlySupply;
        //万量税费
        $scope.applyFinanceVo.tax = quotationDeviceVo.tax;
        //贷款利息
        $scope.applyFinanceVo.loanInterest = quotationDeviceVo.loanInterest;

        //车辆信息各项目设值
        convertApplyVehicle(quotationDeviceVo);
        //根据产品方案和年限生成车辆融资明细
        $scope.finItemList = setFinDetailItemByFinPeriodType(productVo.finItemVoList, $scope.applyFinanceVo.finPeriodType);
        $scope.vehicleFinList[0].applyFinDetailVoList = $scope.finItemList;

        //车辆融资信息各项目设值
        convertFinItemList(quotationDeviceVo);

        sunFinanceInvestTotal();
        initTypes();
    }



    function convertApplyVehicle(quotationDeviceVo) {

        //车型
        $scope.vehicleFinList[0].vehicleCode = quotationDeviceVo.vehicleCode;
        $scope.vehicleFinList[0].vehicleName = quotationDeviceVo.vehicleName;
        //车型信息
        //获取车辆信息
        $http.get('bas_vehicle/findBasVehicleVoByVehicleCode?vehicleCode='+ quotationDeviceVo.vehicleCode).success(function (result) {
            if (result.code == Response.successCode){
                var basVehicle = result.data;
                setApplyVehicleVo($scope.vehicleFinList[0].applyVehicleId, basVehicle);
            }
        });

        //续保押金
        $scope.vehicleFinList[0].renewalDeposit = quotationDeviceVo.renewDeposit;
        //代收手续费
        $scope.vehicleFinList[0].salesCharge = quotationDeviceVo.restitutionFee;
        //手续费
        $scope.vehicleFinList[0].charge = quotationDeviceVo.serviceCharge;
        //渠道佣金
        $scope.vehicleFinList[0].channelCommission = quotationDeviceVo.channelCommission;
        //现金奖励
        $scope.vehicleFinList[0].cashReward = quotationDeviceVo.cashReward;
        //内部提成
        $scope.vehicleFinList[0].internalFormation = quotationDeviceVo.internalFormation;
        //回购价
        $scope.vehicleFinList[0].backPurchase = quotationDeviceVo.backPurchase;
    }

    function convertFinItemList(quotationDeviceVo){
        //融资项目明细初始化
        //
        var finItemList = $scope.vehicleFinList[0].applyFinDetailVoList;
        var convertItems = {
            carprice : ['cehicleTransactionPrice'],        //车款
            purchasetax : ['purchaseTax'],         //购置税
            insurance : ['commercialInsurance','highRiskVehicleTax'],            //商业保险，交强险车船税
            license : ['boardServiceCharge'],          //上牌综合服务 -gps费用
            extra : ['fineQuality'],            //精品加装
        };

        $scope.gpsValue = getYearCountByFinPeriod(quotationDeviceVo.loanTerm)*defaultAmout;
        // $scope.gpsValue = 0.0;
        if(finItemList){
            for (var index = 0; index < finItemList.length; index++ ) {
                if(finItemList[index].finItemYear>1){
                    continue;
                }
                var finItem = finItemList[index].finItem;
                // if(finItem == 'gps'){
                //     finItemList[index].finAmount = $scope.gpsValue;
                //     continue;
                // }
                // // 上牌费
                // if(finItem == 'license'){
                //     finItemList[index].finAmount = Number($scope.gpsValue) *(-1);
                // }
                //如果报价单中该融资明细项目存在
                if(isNotUndefinedNull(convertItems[finItem])){
                    for(var i = 0; i < convertItems[finItem].length; i++){
                        var value = quotationDeviceVo[convertItems[finItem][i]];
                        if(isNotUndefinedNull(value)){
                            finItemList[index].finAmount += quotationDeviceVo[convertItems[finItem][i]];
                        }
                    }
                }
            }
            return finItemList;
        }

    }

    // 融资信息发生变化时
    $scope.$watch('applyFinanceVo', function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
            $scope.$parent.financeInfo.applyFinanceVo = $scope.applyFinanceVo;
        }
    }, true);
    // 融资信息发生变化时
    $scope.$watch('vehicleFinList.length', function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal !== oldVal) {
            $scope.$parent.financeInfo.vehicleFinList = $scope.vehicleFinList;
        }
    }, true);

    // 产品利率方案
    $scope.prodIntrstList = [];
    // 利率项目
    $scope.intrstFactorList= [];
    // 是否挂靠
    $scope.linkFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.linkFlag);
    // 融资期限
    $scope.finPeriodTypeList = [];
    // 牌照属性
    $scope.licenseAttrList = [];
    // 手续费收取方式
    $scope.chargePayModeList = [];
    // 融资明细项目
    $scope.finItemList = [];

    function initTypes(){
    // 投资总额、首尾付总额、保证金总额
    if($scope.applyFinanceVo.initAmount == Math.ceil(CommonDecimalUtils.getAmountByPerc($scope.applyFinanceVo.initPerc, $scope.applyFinanceVo.initFinalTotal, 0))){
        $scope.initType = 1;
    }else{
        $scope.initType = 0;
    }
    if($scope.applyFinanceVo.finalAmount == CommonDecimalUtils.getAmountByPerc($scope.applyFinanceVo.finalPerc, $scope.applyFinanceVo.finalTotal, 0)){
        $scope.finalType = 1;
    }else{
        $scope.finalType = 0;
    }
    if($scope.applyFinanceVo.deposit == CommonDecimalUtils.getAmountByPerc($scope.applyFinanceVo.depositPerc, $scope.applyFinanceVo.depositTotal, 0)){
        $scope.depositType = 1;
    }else{
        $scope.depositType = 0;
    }
    if($scope.applyFinanceVo.annualSupplyAmount == CommonDecimalUtils.getAmountByPerc($scope.applyFinanceVo.annualSupplyRate, $scope.applyFinanceVo.finTotal, 0)){
        $scope.annualType = 1;
    }else{
        $scope.annualType = 0;
    }
    // $scope.initType = $scope.finalType = $scope.depositType = $scope.annualType = 1;
    }

    // 页面初始化
    function init() {
        // 初始化车辆信息
        if ($scope.vehicleFinList.length == 0) {
            var applyVehicleVo = {};
            applyVehicleVo.applyVehicleId = new Date().getTime();
            applyVehicleVo.deleteFlag = false;
            applyVehicleVo.linkFlag = '0';
            applyVehicleVo.vehicleCount = 1;
            applyVehicleVo.renewalDeposit = 0.0;
            applyVehicleVo.salesCharge = 0.0;
            applyVehicleVo.backPurchase = 0.0;
            applyVehicleVo.licenseFee = 0.0;
            applyVehicleVo.charge = 0.0;
            applyVehicleVo.channelCommission = 0.0;
            applyVehicleVo.cashReward = 0.0;
            applyVehicleVo.internalFormation = 0.0;
            $scope.vehicleFinList.push(applyVehicleVo);
        }
        // 根据当前登录用户 获取经销商信息
        /*$http.get('bas_partner/findBasPartnerByLoginUser').success(function (result) {
            $scope.basPartner = result.data;
        });*/
        // 根据当前登录用户 获取经销商信息
        /*$http.get('sys_user/findUserDetailByUser').success(function (result) {
            $scope.sysUser = result.data;
        });*/
        // 根据经销商取得全部的产品数据
        var url = 'product/findProductVoListByGroupCodes?vehicleForm=' + $scope.vehicleForm + '&applyType=' + $scope.applyType;
        $http.get(url).success(function (result) {
            $scope.productList = result.data;
            $scope.productAllList = result.data;
            $scope.productCatgList = getProductCatgList($scope.productList);
        });
        // 取得利率因子项目
        $http.get('intrst_factor/findIntrstFactorAllList').success(function (result) {
            var list =  result.data;
            if (isNotUndefinedNull(list)) {
                for (var index = 0; index < list.length; index++) {
                    $scope.intrstFactorList.push(list[index].factorCode);
                    // 融资项目信息发生变化时
                    $scope.$watch("applyFinanceVo." + list[index].factorCode, function (newVal,oldVal) {
                        if (newVal !== oldVal) {
                            setProIntrstVo();
                        }
                    });
                }
            }
        });
        // 判断是否取得产品方案信息 修改的场合
        if (isNotUndefinedNull($scope.applyFinanceVo.product) && $scope.applyFinanceVo.product != '') {
            // 取得产品方案信息
            $http.get('product/findProductVoByProduct?product=' + $scope.applyFinanceVo.product).success(function (result) {
                if (result.code == Response.successCode) {
                    var productVo = result.data;
                    // 修改的场合信息初始化
                    modifyInitApplyFinance(productVo);


                }
            });
        } else {
            initApplyFinanceInfo();
        }
        // 初始化车辆信息tab
        initVehicleTabHide();
        $scope.vehTabClass[$scope.vehicleFinList[0].applyVehicleId] = "selectTab";
        $scope.vehTabContentClass[$scope.vehicleFinList[0].applyVehicleId] = "tab-content";
        $scope.applyVehicleId = $scope.vehicleFinList[0].applyVehicleId;
    }

    // 根据取得的全部产品取得产品大类list
    function getProductCatgList(productList) {
        var productCatgList = [];
        var tempList = [];
        if (isNotUndefinedNull(productList)) {
            for (var index = 0; index < productList.length; index++) {
                if (isNotUndefinedNull(productList[index].productCatg)
                    && !CommonArrayUtils.vagueContains(productList[index].productCatg, tempList)) {
                    var data = {};
                    data.productCatg = productList[index].productCatg;
                    data.productCatgName = productList[index].productCatgName;
                    productCatgList.push(data);
                    tempList.push(data.productCatg);
                }
            }
        }
        return productCatgList;
    }

    // 选择产品大类
    $scope.onChangeProductCatg = function () {
        if (isNotUndefinedNull($scope.applyFinanceVo.productCatg) && $scope.applyFinanceVo.productCatg != '') {
            for (var i = 0; i < $scope.productCatgList.length; i++) {
                if ($scope.productCatgList[i].productCatg == $scope.applyFinanceVo.productCatg) {
                    $scope.applyFinanceVo.productCatgName = $scope.productCatgList[i].productCatgName;
                    $scope.productCatgName = $scope.productCatgList[i].productCatgName;
                }
            }
        } else {
            $scope.applyFinanceVo.productCatgName = "";
            $scope.productCatgName = "";
        }
        $scope.productList = getProductListByProductCatg($scope.applyFinanceVo.productCatg, $scope.productAllList);
        // 初始化
        $scope.applyFinanceVo.product = "";
        initApplyFinanceInfo();
    };

    // 根据产品大类取得产品方案list
    function getProductListByProductCatg(productCatg, productAllList) {
        var productList = [];
        if (isNotUndefinedNull(productAllList) && isNotUndefinedNull(productCatg) && productCatg != '') {
            for (var index = 0; index < productAllList.length; index++) {
                if (productCatg == productAllList[index].productCatg) {
                    productList.push(productAllList[index]);
                }
            }
        } else {
            productList = [].concat(productAllList);
        }
        return productList;
    }

    // 选择产品方案
    $scope.onChangeProduct = function () {
        if (isUndefinedNull($scope.applyFinanceVo.product) || $scope.applyFinanceVo.product == "") {
            //未选择产品方案信息时
            initApplyFinanceInfo();
        } else {
            //产品大类
            if (isUndefinedNull($scope.applyFinanceVo.productCatg) || $scope.applyFinanceVo.productCatg == '') {
                for (var index = 0; index < $scope.productList.length; index++) {
                    var data = $scope.productList[index];
                    if ($scope.applyFinanceVo.product == data.product) {
                        $scope.applyFinanceVo.productCatg = data.productCatg;
                        $scope.applyFinanceVo.productCatgName = data.productCatgName;
                        $scope.productCatgName = data.productCatgName;
                    }
                }
            }
            //选定产品方案时
            $http.get('product/findProductVoByProduct?product=' + $scope.applyFinanceVo.product).success(function (result) {
                if (result.code == Response.successCode) {
                    //出租人
                    // applyFinanceVo.belongGroupName = $scope.applyFinanceVo.belongGroupName;
                    // applyFinanceVo.belongGroup = $scope.applyFinanceVo.belongGroup;

                    //$scope.applyFinanceVo = result.data;
                    $scope.applyFinanceVo = $.extend(true,$scope.applyFinanceVo,result.data);
                    $scope.applyFinanceVo.productCatgName = $scope.productCatgName;
                    // 车辆类型
                    $scope.applyFinanceVo.vehicleForm = $scope.vehicleForm;
                    $scope.applyFinanceVo.vehicleFormName = $scope.vehicleFormName;
                    // 申请类型
                    $scope.applyFinanceVo.applyType = $scope.applyType;
                    initFinanceVoAmountData();
                    setApplyFinanceConstant();
                    // 融资明细项目
                    $scope.finItemList = result.data.finItemVoList.sort(CommonNumberUtils.compare('orderNo'));
                    console.log($scope.finItemList)
                    setFinItemList();
                    // 产品利率方案
                    $scope.prodIntrstList = $scope.applyFinanceVo.prodIntrstVoList;
                    // 产品利率方案因子为空，则默认设置该利率方案
                    if (isNotUndefinedNull($scope.prodIntrstList) && $scope.prodIntrstList.length > 0) {
                        for(var i = 0; i < $scope.prodIntrstList.length; i++){
                            var factorList = $scope.prodIntrstList[i].prodIntrstVoList;
                            if(isUndefinedNull(factorList) || factorList.length == 0){
                                setIntrstInfo($scope.prodIntrstList[i]);
                                return;
                            }
                        }
                    }

                    // 判断产品是否符合车型数据
                    var vehicleCodeList = $scope.applyFinanceVo.vehicleCodeList;
                    var vehicleTypes = $scope.applyFinanceVo.vehicleType;
                    for (var index = 0; index < $scope.vehicleFinList.length; index++) {
                        if (!checkVehicleCode($scope.vehicleFinList[index], vehicleCodeList, vehicleTypes)) {
                            modalAlert($modal,"选择的产品方案没有以下所选车辆的全部权限，请重新选择");
                            //产品初始化
                            $scope.applyFinanceVo.product = "";
                            initApplyFinanceInfo();
                            return;
                        }
                    }
                    if (isNotUndefinedNull(vehicleTypes) && vehicleTypes != ''
                        && isNotUndefinedNull(vehicleCodeList) && vehicleCodeList.length > 0) {

                    }
                } else {
                    modalAlert($modal,"未找到产品方案信息，请重新选择产品方案");
                    // 产品初始化
                    $scope.applyFinanceVo.product = "";
                    initApplyFinanceInfo();
                }
            });
        }
    };

    // 判断车辆是否有该产品的权限
    function checkVehicleCode(vehicleFin, vehicleCodeList, vehicleTypes) {
        if (isUndefinedNull(vehicleFin.vehicleCode) || vehicleFin.vehicleCode == '') {
            return true;
        } else if (checkVehicleType(vehicleFin.vehicleType, vehicleTypes) && checkProductVehicle(vehicleFin,vehicleCodeList)) {
            return true;
        }
        return false;
    }

    // 判断选择的车辆类型是否符合
    function checkVehicleType(vehicleType, vehicleTypes) {
        if (isNotUndefinedNull(vehicleTypes) && vehicleTypes != '') {
            var list = CommonStringUtils.split(',',vehicleTypes);
            if (CommonArrayUtils.vagueContains(vehicleType,list)) {
                return true;
            }
            return false;
        } else {
            return true;
        }
    }

    // 判断选择的车型在产品中是否哟偶权限
    function checkProductVehicle(data, vehicleCodeList) {
        if (isNotUndefinedNull(vehicleCodeList) && vehicleCodeList.length > 0) {
            if (CommonArrayUtils.vagueContains(data.vehicleCode, vehicleCodeList)
                || (isNotUndefinedNull(data.vehSeriesCode) && CommonArrayUtils.vagueContains(data.vehSeriesCode, vehicleCodeList))
                || (isNotUndefinedNull(data.vehSeriesCode) && CommonArrayUtils.vagueContains(data.vehBrandCode, vehicleCodeList))
                || (isNotUndefinedNull(data.vehSeriesCode) && CommonArrayUtils.vagueContains(data.vehMakerCode, vehicleCodeList))) {
                return true;
            }
            return false;
        } else {
            return true;
        }
    }

    // 设置融资方案信息中的可选项目信息
    function setApplyFinanceConstant() {
        // 还款频率
        $scope.applyFinanceVo.repayRateName =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.repayRate,$scope.applyFinanceVo.repayRate);
        // 租金支付模式
        $scope.applyFinanceVo.rentPayModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.rentPayMode,$scope.applyFinanceVo.rentPayMode);
        // 还款方式
        $scope.applyFinanceVo.repayModeName =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.repayMode,$scope.applyFinanceVo.repayMode);
        // 保证金返还方式
        $scope.applyFinanceVo.depositRtnModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.depositRtnMode,$scope.applyFinanceVo.depositRtnMode);
        // 手续费收取方式
        // $scope.applyFinanceVo.chargePayModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.chargePayMode,$scope.applyFinanceVo.chargePayMode);
        $scope.chargePayModeList = CommonCodeUtils.getCommonCodesByValues(CommonCodeUtils.codeTypes.chargePayMode,$scope.applyFinanceVo.chargePayMode);
        $scope.applyFinanceVo.chargePayMode = '';
        // 融资期限
        $scope.finPeriodTypeList = CommonCodeUtils.getCommonCodesByValues(CommonCodeUtils.codeTypes.finPeriodType,$scope.applyFinanceVo.finPeriodType);
        $scope.applyFinanceVo.finPeriodType = '';

        // 牌照属性
        $scope.licenseAttrList = CommonCodeUtils.getCommonCodesByValues(CommonCodeUtils.codeTypes.licenseAttr,$scope.applyFinanceVo.licenseAttr);
        $scope.applyFinanceVo.licenseAttr = '';

        // 车辆种类
        // $scope.vehicleTypeList = CommonCodeUtils.getCommonCodesByValues(CommonCodeUtils.codeTypes.vehicleType,$scope.applyFinanceVo.vehicleType);
        // $scope.applyFinanceVo.vehicleType = '';
        // GPS安装情况
        var gpsInstMode = '';
        if ($scope.applyFinanceVo.gpsInstMode == '3') {
            $scope.gpsInstModeList = CommonCodeUtils.getCommonCodesByValues(CommonCodeUtils.codeTypes.gpsInstMode, '1,2');
            for (var i = 0; i < $scope.vehicleFinList.length; i++) {
                if ($scope.vehicleFinList[i].gpsInstMode == '' || isUndefinedNull($scope.vehicleFinList[i].gpsInstMode)) {
                    $scope.vehicleFinList[i].gpsInstMode = '1';
                }
            }
        } else {
            $scope.gpsInstModeList = CommonCodeUtils.getCommonCodesByValues(CommonCodeUtils.codeTypes.gpsInstMode, $scope.applyFinanceVo.gpsInstMode);
            // gpsInstMode = $scope.applyFinanceVo.gpsInstMode;
            // for (var index = 0; index < $scope.vehicleFinList.length; index++) {
            //     $scope.vehicleFinList[index].gpsInstMode = gpsInstMode;
            // }
            }
        $scope.applyFinanceVo.gpsInstMode = '';
    }

    // 初始化融资方案信息和融资项目明细信息
    function initApplyFinanceInfo() {
        var applyFinanceVo = {};
        applyFinanceVo.productCatg = $scope.applyFinanceVo.productCatg;
        applyFinanceVo.productCatgName = $scope.applyFinanceVo.productCatgName;
        // 车辆类型
        applyFinanceVo.vehicleForm = $scope.vehicleForm;
        applyFinanceVo.vehicleFormName = $scope.vehicleFormName;
        // 申请类型
        applyFinanceVo.applyType = $scope.applyType;
        //出租人
        applyFinanceVo.belongGroupName = $scope.applyFinanceVo.belongGroupName;
        applyFinanceVo.belongGroup = $scope.applyFinanceVo.belongGroup;
        //销售
        applyFinanceVo.salesCounselor = $scope.applyFinanceVo.salesCounselor;
        applyFinanceVo.salesCounselorMobno = $scope.applyFinanceVo.salesCounselorMobno;
        $scope.applyFinanceVo = applyFinanceVo;
        initFinanceVoAmountData();
        // 还款期限
        $scope.finPeriodTypeList = [];
        // 牌照属性
        $scope.licenseAttrList = [];
        // 融资明细
        $scope.finItemList = [];
        // 车辆种类
        $scope.vehicleTypeList = [];
        // 产品利率方案
        $scope.prodIntrstList = [];
        setFinItemList();
    }

    // 金额信息初始化为0
    function initFinanceVoAmountData() {
        var zero = 0.0;
        $scope.applyFinanceVo.chargeRate = zero;
        $scope.applyFinanceVo.charge = zero;
        $scope.applyFinanceVo.depositPerc = zero;
        $scope.applyFinanceVo.deposit = zero;
        $scope.applyFinanceVo.finalPerc = zero;
        $scope.applyFinanceVo.finalAmount = zero;
        $scope.applyFinanceVo.initPerc = zero;
        $scope.applyFinanceVo.initAmount = zero;
        $scope.applyFinanceVo.investTotal = zero;
        $scope.applyFinanceVo.finTotal = zero;
        $scope.applyFinanceVo.intrstRate = zero;
        $scope.applyFinanceVo.onetimeCharge = zero;
        $scope.applyFinanceVo.initFinalTotal = zero;
        $scope.applyFinanceVo.finalTotal = zero;
        $scope.applyFinanceVo.depositTotal = zero;
        $scope.applyFinanceVo.annualSupplyRate = zero;
        $scope.applyFinanceVo.annualSupplyAmount = zero;

    }

    // 设置车辆的融资明细项目
    function setFinItemList() {
        for (var i = 0; i < $scope.vehicleFinList.length; i++) {
            if (isNotUndefinedNull($scope.vehicleFinList[i])) {
                $scope.vehicleFinList[i].applyFinDetailVoList = copyFinItemArray($scope.finItemList);
                $scope.vehicleFinList[i].investTotal = 0.0;
                // $scope.vehicleFinList[i].renewalDeposit = 0.0;
                // $scope.vehicleFinList[i].salesCharge = 0.0;
                // $scope.vehicleFinList[i].backPurchase = 0.0;
                // $scope.vehicleFinList[i].licenseFee = 0.0;
                //$scope.vehicleFinList[i].charge = 0.0;
                // $scope.vehicleFinList[i].channelCommission = 0.0;
                // $scope.vehicleFinList[i].cashReward = 0.0;
                // $scope.vehicleFinList[i].internalFormation = 0.0;
            }
        }
    }

    // 选择车型
    $scope.selectBasVehicle = function (applyVehicleId) {
        var basVehicle = {};
        basVehicle.vehicleLevel = '4';// 级别  4-车型
        basVehicle.vehicleCodeList = $scope.applyFinanceVo.vehicleCodeList; // 产品的车型
        basVehicle.vehicleType = $scope.applyFinanceVo.vehicleType; // 产品的车辆种类
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_vehicle/bas_vehicle_list_select.html'+getCacheTime(),
            controller: 'bas_vehicle_list_select_controller',
            resolve:{
                basVehicle: function () { return basVehicle;}
            }
        });
        rtn.result.then(function (status) {
            if(isNotUndefinedNull(status)) {
                setApplyVehicleVo(applyVehicleId, status);
            }
        },function(){
        });
    };

    // 设置车辆信息
    function setApplyVehicleVo(applyVehicleId, basVehicle) {
        for (var i = 0; i < $scope.vehicleFinList.length; i++) {
            if (isNotUndefinedNull($scope.vehicleFinList[i])
                && applyVehicleId == $scope.vehicleFinList[i].applyVehicleId) {
                // 车型
                $scope.vehicleFinList[i].vehicleCode = basVehicle.vehicleCode;
                $scope.vehicleFinList[i].vehicleName = basVehicle.vehicleName;
                // 制造商
                $scope.vehicleFinList[i].vehMakerCode = basVehicle.vehMakerCode;
                $scope.vehicleFinList[i].vehMakerName = basVehicle.vehMakerName;
                // 品牌
                $scope.vehicleFinList[i].vehBrandCode = basVehicle.vehBrandCode;
                $scope.vehicleFinList[i].vehBrandName = basVehicle.vehBrandName;
                // 车系
                $scope.vehicleFinList[i].vehSeriesCode = basVehicle.vehSeriesCode;
                $scope.vehicleFinList[i].vehSeriesName = basVehicle.vehSeriesName;
                // 车辆指导价
                $scope.vehicleFinList[i].guidePrice = basVehicle.guidePrice;
                // 车辆种类
                $scope.vehicleFinList[i].vehicleType2 = basVehicle.vehicleType2;
                $scope.vehicleFinList[i].vehicleTypeName = CommonCodeUtils.getCodeValueName('vehicleType2', basVehicle.vehicleType2);
                //是否新能源
                $scope.vehicleFinList[i].newEnergy = basVehicle.newEnergy;
                //购置税
                $scope.vehicleFinList[i].referPurchaseTax = Math.ceil(basVehicle.guidePrice/purchaseTaxRate);
                //保险
                $scope.vehicleFinList[i].referInsuranceFee = Math.ceil(basVehicle.guidePrice*commercialInsuranceRate);
                //折扣率
                $scope.getDiscountRate($scope.vehicleFinList[i]);
            }
        }
    }

    // 融资期限发生变化时

    $scope.onChangFinPeriodType = function () {
        var finPeriod = '';
        if (CommonObjectUtils.isNotExist($scope.applyFinanceVo.finPeriodType)) {
            $scope.gpsValue = 0;
        }else{
            finPeriod = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.finPeriodType, $scope.applyFinanceVo.finPeriodType);
            $scope.gpsValue = getYearCountByFinPeriod($scope.applyFinanceVo.finPeriodType)*defaultAmout;
        }
        $scope.applyFinanceVo.finPeriodTypeName = finPeriod;
        $scope.finItemList = setFinDetailItemByFinPeriodType($scope.finItemList, finPeriod);
        for (var i = 0; i < $scope.vehicleFinList.length; i++) {
            if (isNotUndefinedNull($scope.vehicleFinList[i].applyFinDetailVoList) && $scope.vehicleFinList[i].applyFinDetailVoList.length > 0) {
                $scope.vehicleFinList[i].applyFinDetailVoList = setFinDetailItemByFinPeriodType($scope.vehicleFinList[i].applyFinDetailVoList, finPeriod);
            } else {
                $scope.vehicleFinList[i].applyFinDetailVoList = setFinDetailItemByFinPeriodType($scope.finItemList, finPeriod);
            }
            //GPS费
            var length = $scope.vehicleFinList[i].applyFinDetailVoList.length;
            for(var j=0;j<length;j++){
                if($scope.vehicleFinList[i].applyFinDetailVoList[j].finItem == "gps"){
                    if($scope.vehicleFinList[i].gpsInstMode == 2){
                        $scope.vehicleFinList[i].applyFinDetailVoList[j].finAmount = 0;
                    }else{
                        $scope.vehicleFinList[i].applyFinDetailVoList[j].finAmount = $scope.gpsValue;
                    }
                }
            }
        }
        sunFinanceInvestTotal();
    };

    // 设置融资项目明细信息
    function setFinDetailItemByFinPeriodType(finItemList, finPeriod) {
        var yearCount = getYearCountByFinPeriod(finPeriod);
        var arry = [];
        var tempFinItem = '';
        var tempDataList = [];
        for (var i = 0; i < finItemList.length; i++) {
            if (tempFinItem == finItemList[i].finItem) {
                tempDataList.push(copyFinItem(finItemList[i]));
            } else {
                if (tempFinItem != '') {
                    arry = arry.concat(getFinItemDataList(yearCount, tempDataList));
                }
                tempFinItem = finItemList[i].finItem;
                tempDataList = [];
                tempDataList.push(copyFinItem(finItemList[i]));
            }
        }
        if (tempFinItem != '') {
            arry = arry.concat(getFinItemDataList(yearCount, tempDataList));
        }
        return arry;
    }

    // 取得融资项目
    function getFinItemDataList(yearCount, tempDataList) {
        var arry = [];
        if (tempDataList[0].finMode == '2') {
            // 分年
            if (yearCount > 1) {
                var startIndex = tempDataList.length;
                if (startIndex < yearCount) {
                    if (startIndex == 1) {
                        startIndex = 0;
                    } else {
                        arry = arry.concat(tempDataList);
                    }
                    var split = CommonStringUtils.split('(', tempDataList[0].finItemName);
                    var finItemName = split[0];
                    for(var j = startIndex + 1; j <= yearCount; j++) {
                        var temp =  getFinItemData(tempDataList[0]);
                        temp.finItemName = finItemName + '(第' + j + '年)';
                        temp.finItemYear = j;
                        arry.push(temp);
                    }
                } else if (startIndex > yearCount) {
                    for(var i = 0; i < yearCount; i++) {
                        arry.push(tempDataList[i]);
                    }
                } else {
                    arry = arry.concat(tempDataList);
                }

            } else {
                var data = getFinItemData(tempDataList[0]);
                var itemName = CommonStringUtils.split('(', tempDataList[0].finItemName);
                data.finItemName = itemName[0];
                arry.push(data);
            }
        } else {
            arry = copyFinItemArray(tempDataList);
        }

        return arry
    }

    // 获得融资项目
    function getFinItemData(data) {
        var temp =  {};
        // temp.finItemId = new Date().Format("yyyyMMddHHmmss");
        // temp.finItemId = new Date().getTime();
        temp.finItem = data.finItem;
        temp.finMode = data.finMode;
        temp.editMode = data.editMode;
        temp.finItemType = data.finItemType;
        temp.initFinalItemFlag = data.initFinalItemFlag;
        temp.finalItemFlag = data.finalItemFlag;
        temp.depositItemFlag = data.depositItemFlag;
        //融资明细额初始化
        temp.finAmount = 0;
        // temp.finAmount = data.finAmount;
        return temp;
    }

    // 复制对象
    function copyFinItem(data) {
        var copyFinItem = {};
        for (var item in data) {
            copyFinItem[item] = data[item];
        }
        if(isUndefinedNull(copyFinItem.finAmount)){
            copyFinItem.finAmount = 0;
        }
        if(copyFinItem.finItem == "gps"){
            copyFinItem.finAmount = $scope.gpsValue;
        }
        return copyFinItem;
    }
    // 复制对象数组
    function copyFinItemArray(finItemList) {
        var array = [];
        for (var index = 0; index < finItemList.length; index++ ) {
            array.push(copyFinItem(finItemList[index]));
        }
        return array;
    }

    // 计算出融资期限的年限
    function getYearCountByFinPeriod(value) {
        if (value == '') {
            return 1;
        }
        return Math.ceil(value / 12);
    }

    // 选择实际销售方
    $scope.selectBasPartner = function (applyVehicleId) {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_sales/bas_sales_list_select.html'+getCacheTime(),
            controller: 'bas_sales_list_select_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(isNotUndefinedNull(status)) {
                for (var i = 0; i < $scope.vehicleFinList.length; i++) {
                    if (isNotUndefinedNull($scope.vehicleFinList[i])
                        && applyVehicleId == $scope.vehicleFinList[i].applyVehicleId) {
                        // 实际销售方
                        $scope.vehicleFinList[i].saleGroupCode = status.salesCode;
                        $scope.vehicleFinList[i].saleGroupName = status.salesName;
                    }
                }
            }
        },function(){
        });
    };
    // 融资总额发生变化时
    $scope.$watch('applyFinanceVo.investTotal', function (newVal, oldVal) {
        if (newVal != null && newVal !== oldVal &&oldVal && isNotUndefinedNull(oldVal)) {
            // 首付比例
            if ($scope.initType == 0) {
                $scope.checkInitAmount();
            } else {
                $scope.checkInitPerc();
            }
            // 融资额
            $scope.applyFinanceVo.finTotal = $scope.applyFinanceVo.investTotal -  $scope.applyFinanceVo.initAmount;
            // // 尾付比例
            // if ($scope.finalType == 0) {
            //     $scope.checkFinalAmount();
            // } else {
            //     $scope.checkFinalPerc();
            // }
        }
    }, true);


    // 首付项目总额发生变化时
    $scope.$watch('applyFinanceVo.initFinalTotal', function (newVal, oldVal) {
        if (newVal != null && newVal !== oldVal && isNotUndefinedNull(oldVal)) {
            // 首付比例
            if ($scope.initType == 0) {
                $scope.checkInitAmount();
            } else {
                $scope.checkInitPerc();
            }
            // // 尾付比例
            // if ($scope.finalType == 0) {
            //     $scope.checkFinalAmount();
            // } else {
            //     $scope.checkFinalPerc();
            // }
        }
    }, true);


    // 尾付项目总额发生变化时
    $scope.$watch('applyFinanceVo.finalTotal', function (newVal, oldVal) {
        if (newVal != null && newVal !== oldVal && isNotUndefinedNull(oldVal)) {
            // // 首付比例
            // if ($scope.initType == 0) {
            //     $scope.checkInitAmount();
            // } else {
            //     $scope.checkInitPerc();
            // }
            // 尾付比例
            if ($scope.finalType == 0) {
                $scope.checkFinalAmount();
            } else {
                $scope.checkFinalPerc();
            }
        }
    }, true);

    // 保证金总额发生变化时
    $scope.$watch('applyFinanceVo.depositTotal', function (newVal, oldVal) {
        if (newVal !== oldVal && isNotUndefinedNull(oldVal)) {
            // 保证金
            if ($scope.depositType == 0) {
                $scope.checkDeposit();
            } else {
                $scope.checkDepositPerc();
            }
        }
    }, true);

    // 融资额变化时
    $scope.$watch('applyFinanceVo.finTotal', function (newVal, oldVal) {
        if (newVal !== oldVal && isNotUndefinedNull(oldVal)) {
            // 年供
            if ($scope.annualType == 0) {
                $scope.checkAnnualAmount();
            } else {
                $scope.checkAnnualPerc();
            }
        }
    }, true);

    // 判断输入的保证金率是否符合要求，并计算保证金
    $scope.checkDepositPerc = function () {
        // 最后输入的保证金和保证金率 0：金额 1：比例
        $scope.depositType = 1;
        // 保证金
        $scope.applyFinanceVo.deposit = CommonDecimalUtils.getAmountByPerc($scope.applyFinanceVo.depositPerc, $scope.applyFinanceVo.depositTotal, 0);

    };

    // 判断输入的保证金是否符合要求,并计算出保证金率
    $scope.checkDeposit = function () {
        // 最后输入的保证金和保证金率 0：金额 1：比例
        $scope.depositType = 0;
        // 保证金率
        $scope.applyFinanceVo.depositPerc = CommonDecimalUtils.getPercByAmount($scope.applyFinanceVo.deposit, $scope.applyFinanceVo.depositTotal, 0);

    };

    // 判断输入的尾付比例是否符合要求，并计算尾付金额
    $scope.checkFinalPerc = function () {
        // 最后输入的尾付金额和尾付金比例 0：金额 1：比例
        $scope.finalType = 1;
        // 尾付金额
        $scope.applyFinanceVo.finalAmount = CommonDecimalUtils.getAmountByPerc($scope.applyFinanceVo.finalPerc, $scope.applyFinanceVo.finalTotal, 0);

        $scope.notSameZero(2);
    };

    // 判断输入的尾付金额是否符合要求,并计算出尾付比例
    $scope.checkFinalAmount = function () {
        // 最后输入的尾付金额和尾付金比例 0：金额 1：比例
        $scope.finalType = 0;
        // 尾付比例
        $scope.applyFinanceVo.finalPerc = CommonDecimalUtils.getPercByAmount($scope.applyFinanceVo.finalAmount, $scope.applyFinanceVo.finalTotal, 0);
        $scope.notSameZero(2);
    };

    // 判断输入的首付比例是否符合要求，并计算首付金额
    $scope.checkInitPerc = function () {
        // 最后输入的首付金额和首付金比例 0：金额 1：比例
        $scope.initType = 1;
        // 首付金额
        $scope.applyFinanceVo.initAmount = Math.ceil(CommonDecimalUtils.getAmountByPerc($scope.applyFinanceVo.initPerc, $scope.applyFinanceVo.initFinalTotal, 0));
        // //年供金额
        // $scope.applyFinanceVo.annualSupplyAmount = CommonDecimalUtils.getAmountByPerc($scope.applyFinanceVo.annualSupplyRate, $scope.applyFinanceVo.finTotal, 0);
        // 融资额
        $scope.applyFinanceVo.finTotal = $scope.applyFinanceVo.investTotal -  $scope.applyFinanceVo.initAmount;

        //$scope.annualSupplyRateChange();
        $scope.notSameZero(1);
    };


    // 判断输入的首付金额是否符合要求,并计算出首付比例
    $scope.checkInitAmount = function () {
        // 最后输入的首付金额和首付金比例 0：金额 1：比例
        $scope.initType = 0 ;
        // 首付金额
        $scope.applyFinanceVo.initPerc = CommonDecimalUtils.getPercByAmount($scope.applyFinanceVo.initAmount, $scope.applyFinanceVo.initFinalTotal, 0);
        // //年供金额
        // $scope.applyFinanceVo.annualSupplyRate = CommonDecimalUtils.getPercByAmount($scope.applyFinanceVo.annualSupplyAmount, $scope.applyFinanceVo.finTotal, 0);
        // 融资额
        $scope.applyFinanceVo.finTotal = $scope.applyFinanceVo.investTotal -  $scope.applyFinanceVo.initAmount;


        //$scope.annualSupplyRateChange();
        $scope.notSameZero(1);
    };


    // 判断输入的年供比例是否符合要求，并计算首付金额
    $scope.checkAnnualPerc = function () {
        // 年供金额
        $scope.applyFinanceVo.annualSupplyAmount = CommonDecimalUtils.getAmountByPerc($scope.applyFinanceVo.annualSupplyRate, $scope.applyFinanceVo.finTotal, 0);
        // 最后输入的首付金额和首付金比例 0：金额 1：比例
        $scope.annualType = 1;
    }

    // 判断输入的年供比例是否符合要求，并计算首付金额
    $scope.checkAnnualAmount = function () {
        //年供金额
        $scope.applyFinanceVo.annualSupplyRate = CommonDecimalUtils.getPercByAmount($scope.applyFinanceVo.annualSupplyAmount, $scope.applyFinanceVo.finTotal, 0);
        // 最后输入的首付金额和首付金比例 0：金额 1：比例
        $scope.annualType = 0;
    }


    // 增加车辆和融资明细信息时
    $scope.addVehicleInfo = function () {
        var applyVehicleVo = {};
        applyVehicleVo.applyVehicleId = new Date().getTime();
        applyVehicleVo.deleteFlag = true;
        applyVehicleVo.linkFlag = '0';
        applyVehicleVo.investTotal = 0.0;
        applyVehicleVo.renewalDeposit = 0.0;
        applyVehicleVo.salesCharge = 0.0;
        applyVehicleVo.backPurchase = 0.0;
        applyVehicleVo.licenseFee = 0.0;
        applyVehicleVo.vehicleCount = 1;
        applyVehicleVo.charge = 0.0;
        applyVehicleVo.channelCommission = 0.0;
        applyVehicleVo.cashReward = 0.0;
        applyVehicleVo.internalFormation = 0.0;
        if ($scope.applyFinanceVo.gpsInstMode == '3') {
            applyVehicleVo.gpsInstMode= '1';
        } else {
            // applyVehicleVo.gpsInstMode = $scope.applyFinanceVo.gpsInstMode;
        }
        applyVehicleVo.applyFinDetailVoList = copyFinItemArray($scope.finItemList);
        $scope.vehicleFinList.push(applyVehicleVo);
        // 显示追加的车辆信息页签
        $scope.openFinVehicleInfo(applyVehicleVo.applyVehicleId,$scope.vehicleFinList.length - 1);
    };

    // 删除车辆和融资明细信息时
    $scope.delVehicleInfo = function () {
        var applyVehicleId =  $scope.applyVehicleId;
        var vehicleFinList = [];
        for (var i = 0; i < $scope.vehicleFinList.length; i++) {
            var data = $scope.vehicleFinList[i];
            if (applyVehicleId != data.applyVehicleId) {
                vehicleFinList.push(data);
            }
        }
        $scope.vehicleFinList = vehicleFinList;
        // 显示第一个也签
        var lastIndex = $scope.vehicleFinList.length - 1;
        $scope.openFinVehicleInfo($scope.vehicleFinList[lastIndex].applyVehicleId,lastIndex);
        sunFinanceInvestTotal();
    };

    // 融资项目的融资金额发生变化时
    $scope.changeFinItemAmount = function () {
        // 重新计算投资额信息
        sunFinanceInvestTotal();
    };

    // 计算全部车辆的投资总额
    function sunFinanceInvestTotal() {
        var investTotal = 0.0;
        var initFinalTotal = 0.0;
        var finalTotal = 0.0;
        var depositTotal = 0.0;
        for (var i = 0; i <  $scope.vehicleFinList.length; i++) {
            sumVehicleInvestTotal($scope.vehicleFinList[i]);
            if (isUndefinedNull($scope.vehicleFinList[i].vehicleCount) || $scope.vehicleFinList[i].vehicleCount == '') {
                $scope.vehicleFinList[i].vehicleCount = 0;
            }
            investTotal += Number($scope.vehicleFinList[i].investTotal) * Number($scope.vehicleFinList[i].vehicleCount);
            initFinalTotal += Number($scope.vehicleFinList[i].initFinalTotal) * Number($scope.vehicleFinList[i].vehicleCount);
            finalTotal += Number($scope.vehicleFinList[i].finalTotal) * Number($scope.vehicleFinList[i].vehicleCount);
            depositTotal += Number($scope.vehicleFinList[i].depositTotal) * Number($scope.vehicleFinList[i].vehicleCount);
        }
        $scope.applyFinanceVo.investTotal = Math.ceil(investTotal);
        $scope.applyFinanceVo.initFinalTotal = Math.ceil(initFinalTotal);
        $scope.applyFinanceVo.finalTotal = Math.ceil(finalTotal);
        $scope.applyFinanceVo.depositTotal = depositTotal;

        // 融资额
        // $scope.applyFinanceVo.finTotal = investTotal - Number($scope.applyFinanceVo.initAmount);
        // $scope.checkInitPerc();
    }

    // 计算单车的投资总额
    function sumVehicleInvestTotal(vehicleFin) {
        var itemList = vehicleFin.applyFinDetailVoList;
        var investTotal =  0.0;
        var initFinalTotal = 0.0;
        var finalTotal = 0.0;
        var depositTotal = 0.0;
        if (isNotUndefinedNull(itemList) && itemList.length > 0) {
            for (var i = 0; i < itemList.length; i++) {
                if (isNotUndefinedNull(itemList[i].finAmount)) {
                    investTotal += Number(itemList[i].finAmount);
                    // 首付融资项目
                    if (itemList[i].initFinalItemFlag == 1) {
                        initFinalTotal += Number(itemList[i].finAmount);
                    }
                    // 尾付融资项目
                    if (itemList[i].finalItemFlag == 1) {
                        finalTotal += Number(itemList[i].finAmount);
                    }
                    // 保证金项目
                    if (itemList[i].depositItemFlag == 1) {
                        depositTotal += Number(itemList[i].finAmount);
                    }
                }
            }
        }
        vehicleFin.investTotal = Math.ceil(investTotal);
        vehicleFin.initFinalTotal = initFinalTotal;
        vehicleFin.finalTotal = finalTotal;
        vehicleFin.depositTotal = depositTotal;
    }

    function setIntrstInfo(prodIntrstVo){
        // 利率方案
        $scope.applyFinanceVo.intrstNo = prodIntrstVo.intrstNo;
        // 手续费率
        $scope.applyFinanceVo.chargeRate = Number(prodIntrstVo.chargeRate);
        // 利率方式
        $scope.applyFinanceVo.intrstRateMode = prodIntrstVo.intrstRateMode;
        $scope.applyFinanceVo.intrstRateModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.intrstRateMode, $scope.applyFinanceVo.intrstRateMode);
        // 客户利率
        $scope.applyFinanceVo.intrstRate = Number(prodIntrstVo.intrstRate);
        // 一次性手续费
        $scope.applyFinanceVo.charge = prodIntrstVo.onetimeCharge;

    }
    // 根据产品的利率因子，获取产品的利率方案
    function setProIntrstVo() {
        var prodIntrstList = $scope.prodIntrstList;
        if (isInputData()) {
            if (isNotUndefinedNull(prodIntrstList) && prodIntrstList.length > 0) {
                for (var i = 0; i < prodIntrstList.length; i++) {
                    if (checkProdIntrstVo(prodIntrstList[i].prodIntrstFactorVoList)) {
                        // $scope.applyFinanceVo.onetimeCharge = prodIntrstList[i].onetimeCharge;
                        setIntrstInfo(prodIntrstList[i]);
                        return;
                    }
                }
                // 利率方案
                $scope.applyFinanceVo.intrstNo = '';
                // 手续费率
                $scope.applyFinanceVo.chargeRate = 0.0;
                // 利率方式
                $scope.applyFinanceVo.intrstRateMode = '';
                $scope.applyFinanceVo.intrstRateModeName = '';
                // 客户利率
                $scope.applyFinanceVo.intrstRate = 0.0;
                // 一次性手续费
                $scope.applyFinanceVo.charge = 0.0;

                // $scope.applyFinanceVo.finPeriodType = "";
                // modalAlert($modal, "找不到对应的利率方案请重新设置");
            // } else if (isNotUndefinedNull($scope.applyFinanceVo.product) && $scope.applyFinanceVo.product != '') {
            } else {
                // 利率方案
                $scope.applyFinanceVo.intrstNo = '';
                // 手续费率
                $scope.applyFinanceVo.chargeRate = 0.0;
                // 利率方式
                $scope.applyFinanceVo.intrstRateMode = '';
                $scope.applyFinanceVo.intrstRateModeName = '';
                // 客户利率
                $scope.applyFinanceVo.intrstRate = 0.0;
                // 一次性手续费
                $scope.applyFinanceVo.charge = 0.0;
                // modalAlert($modal, "选择的产品没有利率方案");
            }
        }
    }

    // 判断利率因子是否全部输入
    function isInputData() {
        for (var i = 0; i < $scope.intrstFactorList.length; i ++) {
            var value = $scope.intrstFactorList[i];
            if (isUndefinedNull($scope.applyFinanceVo[value])) {
                // if (isUndefinedNull($scope.applyFinanceVo[value]) || $scope.applyFinanceVo[value] == '') {
                return false;
            }
        }
        return true;
    }

    // 判断当前条件是否符合利率方案
    function checkProdIntrstVo(intrstFactorList) {
        if (isNotUndefinedNull(intrstFactorList)) {
            for (var index = 0; index < intrstFactorList.length; index++) {
                var value = $scope.applyFinanceVo[intrstFactorList[index].factorCode];
                if (isNotUndefinedNull(value)) {
                    if (!checkIntrstFactor(value, intrstFactorList[index])) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    // 判断当前因子是否符合条件
    function checkIntrstFactor(value, intrstFactor) {
        if ('1' == intrstFactor.factorType) {
            var list = CommonStringUtils.splitComma(intrstFactor.factorValueFrom.replace('，',CommonStringUtils.COMMA));
            if (CommonArrayUtils.vagueContains(value, list)) {
                return true;
            }
        } else {
            if (CommonDecimalUtils.isValueSection(value,Number(intrstFactor.factorValueFrom) * 100.0, Number(intrstFactor.factorValueTo) * 100.0)) {
                return true;
            }
        }
        return false;
    }

    // 修改的融资车辆信息初始化
    function modifyInitApplyFinance(productVo) {
        // 还款频率
        $scope.applyFinanceVo.repayRateName =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.repayRate,$scope.applyFinanceVo.repayRate);
        // 租金支付模式
        $scope.applyFinanceVo.rentPayModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.rentPayMode,$scope.applyFinanceVo.rentPayMode);
        // 还款方式
        $scope.applyFinanceVo.repayModeName =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.repayMode,$scope.applyFinanceVo.repayMode);
        // 保证金返还方式
        $scope.applyFinanceVo.depositRtnModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.depositRtnMode,$scope.applyFinanceVo.depositRtnMode);
        // 利率方式
        if (CommonObjectUtils.isExist($scope.applyFinanceVo.intrstRateMode)) {
            $scope.applyFinanceVo.intrstRateModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.intrstRateMode, $scope.applyFinanceVo.intrstRateMode);
        }
        // 手续费收取方式
        $scope.chargePayModeList = CommonCodeUtils.getCommonCodesByValues(CommonCodeUtils.codeTypes.chargePayMode,productVo.chargePayMode);
        // 融资期限
        $scope.finPeriodTypeList = CommonCodeUtils.getCommonCodesByValues(CommonCodeUtils.codeTypes.finPeriodType,productVo.finPeriodType);
        // 牌照属性
        $scope.licenseAttrList = CommonCodeUtils.getCommonCodesByValues(CommonCodeUtils.codeTypes.licenseAttr,productVo.licenseAttr);

        // GPS安装情况
        // $scope.applyFinanceVo.gpsInstMode = productVo.gpsInstMode;
        if ($scope.applyFinanceVo.gpsInstMode == '3') {
            $scope.gpsInstModeList = CommonCodeUtils.getCommonCodesByValues(CommonCodeUtils.codeTypes.gpsInstMode, '1,2');
        } else {
            $scope.gpsInstModeList = CommonCodeUtils.getCommonCodesByValues(CommonCodeUtils.codeTypes.gpsInstMode, productVo.gpsInstMode);
        }
        // 首付比例区间
        $scope.applyFinanceVo.initPercFrom = productVo.initPercFrom;
        $scope.applyFinanceVo.initPercTo = productVo.initPercTo;
        // 首付金额区间
        $scope.applyFinanceVo.initAmountFrom = productVo.initAmountFrom;
        $scope.applyFinanceVo.initAmountTo = productVo.initAmountTo;
        // 尾付比例区间
        $scope.applyFinanceVo.finalPercFrom = productVo.finalPercFrom;
        $scope.applyFinanceVo.finalPercTo = productVo.finalPercTo;
        // 尾付金额区间
        $scope.applyFinanceVo.finalAmountFrom = productVo.finalAmountFrom;
        $scope.applyFinanceVo.finalAmountTo = productVo.finalAmountTo;
        // 保证金率区间
        $scope.applyFinanceVo.depositPercFrom = productVo.depositPercFrom;
        $scope.applyFinanceVo.depositPercTo = productVo.depositPercTo;
        // 保证金区间
        $scope.applyFinanceVo.depositFrom = productVo.depositFrom;
        $scope.applyFinanceVo.depositTo = productVo.depositTo;
        // 融资明细项目
        $scope.applyFinanceVo.finItemVoList = productVo.finItemVoList
        // 融资期限
        var finPeriod = '';
        if (isNotUndefinedNull($scope.applyFinanceVo.finPeriodType) && $scope.applyFinanceVo.finPeriodType != '') {
            finPeriod = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.finPeriodType, $scope.applyFinanceVo.finPeriodType);
        }
        $scope.applyFinanceVo.finPeriodTypeName = finPeriod;
        $scope.finItemList = setFinDetailItemByFinPeriodType($scope.applyFinanceVo.finItemVoList,finPeriod);
        // 产品利率方案
        $scope.prodIntrstList = productVo.prodIntrstVoList;
        // 产品权限的车辆Code
        $scope.applyFinanceVo.vehicleCodeList = productVo.vehicleCodeList;
        // 产品的车辆种类
        $scope.applyFinanceVo.vehicleType =  productVo.vehicleType;
        // 根据产品大类取得产品list
        $scope.productList = getProductListByProductCatg($scope.applyFinanceVo.productCatg, $scope.productAllList);
        // 首付项目
        var initFinalItemList = [];
        // 尾付项目
        var finalItemList = [];
        // 保证金项目
        var depositItemList = [];
        if (isNotUndefinedNull(productVo.finItemVoList) && productVo.finItemVoList.length > 0) {
            for (var i = 0; i < productVo.finItemVoList.length; i++) {
                var data = productVo.finItemVoList[i];
                // 首尾付融资项目
                if (data.initFinalItemFlag == 1) {
                    initFinalItemList.push(data.finItem);
                }
                if(data.finalItemFlag == 1){
                    finalItemList.push(data.finItem);
                }
                // 保证金项目
                if (data.depositItemFlag == 1) {
                    depositItemList.push(data.finItem)
                }
            }
        }
        var initFinalTotal = 0;
        var finalTotal = 0;
        var depositTotal = 0;
        // 融资车辆信息
        for (var index = 0; index < $scope.vehicleFinList.length; index++) {
            // 车辆种类
            $scope.vehicleFinList[index].vehicleType2 = $scope.vehicleFinList[index].vehicleType2;
            /*if (CommonObjectUtils.isExist($scope.vehicleFinList[index].vehicleType)) {
                $scope.vehicleFinList[index].vehicleTypeName = CommonCodeUtils.getCodeValueName('vehicleType2', $scope.vehicleFinList[index].vehicleType);

            }*/
            // 投资总额
            var investTotal = 0;
            // 首付金额
            var vehicleInitFinalTotal = 0;
            // 尾付金额
            var vehicleFinalTotal = 0;

            // 保证金金额
            var vehicleDepositTotal = 0;
            if (isNotUndefinedNull($scope.vehicleFinList[index].applyFinDetailVoList)) {
                var applyFinDetailVoList = $scope.vehicleFinList[index].applyFinDetailVoList;
                for (var t = 0; t < applyFinDetailVoList.length; t++) {
                    investTotal += Number(applyFinDetailVoList[t].finAmount);
                    applyFinDetailVoList[t].initFinalItemFlag = 0;
                    applyFinDetailVoList[t].finalItemFlag = 0;
                    applyFinDetailVoList[t].depositItemFlag = 0;
                    // 首付项目
                    if (CommonArrayUtils.vagueContains(applyFinDetailVoList[t].finItem,initFinalItemList)) {
                        applyFinDetailVoList[t].initFinalItemFlag = 1;
                        vehicleInitFinalTotal += Number(applyFinDetailVoList[t].finAmount);
                    }
                    // 尾付项目
                    if (CommonArrayUtils.vagueContains(applyFinDetailVoList[t].finItem,finalItemList)) {
                        applyFinDetailVoList[t].finalItemFlag = 1;
                        vehicleFinalTotal += Number(applyFinDetailVoList[t].finAmount);
                    }
                    // 保证金项目
                    if (CommonArrayUtils.vagueContains(applyFinDetailVoList[t].finItem,depositItemList)) {
                        applyFinDetailVoList[t].depositItemFlag = 1;
                        vehicleDepositTotal += Number(applyFinDetailVoList[t].finAmount);
                    }
                }
            }
            $scope.vehicleFinList[index].investTotal = Math.ceil(investTotal);
            $scope.vehicleFinList[index].initFinalTotal = vehicleInitFinalTotal;
            $scope.vehicleFinList[index].finalTotal = vehicleFinalTotal;
            $scope.vehicleFinList[index].depositTotal = vehicleDepositTotal;
            initFinalTotal += vehicleInitFinalTotal * Number($scope.vehicleFinList[index].vehicleCount);
            finalTotal += vehicleFinalTotal * Number($scope.vehicleFinList[index].vehicleCount);
            depositTotal += vehicleDepositTotal * Number($scope.vehicleFinList[index].vehicleCount);
            // 删除按钮
            if (index == 0) {
                $scope.vehicleFinList[index].deleteFlag = true;
            } else {
                $scope.vehicleFinList[index].deleteFlag = false;
            }
        }
        // 首付总额
        $scope.applyFinanceVo.initFinalTotal = initFinalTotal;
        // 尾付总额
        $scope.applyFinanceVo.finalTotal = finalTotal;
        // 保证金总额
        $scope.applyFinanceVo.depositTotal = depositTotal;
        // 设置融资信息的利率方案序号
        if (isInputData()) {
            if (isNotUndefinedNull($scope.prodIntrstList) && $scope.prodIntrstList.length > 0) {
                for (var i = 0; i < $scope.prodIntrstList.length; i++) {
                    if (checkProdIntrstVo($scope.prodIntrstList[i].prodIntrstFactorVoList)) {
                        // 利率方案
                        $scope.applyFinanceVo.intrstNo = $scope.prodIntrstList[i].intrstNo;
                       break;
                    }
                }
            }
        }
    }

    // 点击车辆信息页签
    $scope.openFinVehicleInfo = function (vehicleId, index) {
        initVehicleTabHide();
        $scope.vehTabClass[vehicleId] = "selectTab";
        $scope.vehTabContentClass[vehicleId] = "tab-content";
        var name = '#' + vehicleId;
        $(name).fadeIn();
        $scope.applyVehicleId = vehicleId;
        if(index == 0){
            $scope.vehicleDelDisabled = true;
        }else{
            $scope.vehicleDelDisabled = false;
        }
        //$scope.vehicleDelDisabled = $scope.vehicleFinList[index].deleteFlag != true;
    };

    // 车辆信息tabClass初始化
    function initVehicleTabHide() {
        for (var i = 0; i < $scope.vehicleFinList.length; i++) {
            $scope.vehTabClass[$scope.vehicleFinList[i].applyVehicleId] = "noneTab";
            $scope.vehTabContentClass[$scope.vehicleFinList[i].applyVehicleId] = "tab-content ng-hide";
        }
    }

    //报价单计算

    //出租人
    $scope.selectUser = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/product/product/product_user.html'+getCacheTime(),
            controller: 'product_user_controller',
            resolve:{
                setData: function () {
                    return {
                        "checkboxOrRadio": Radio
                    };
                }
            }
        });
        rtn.result.then(function (data) {
            if(isNotUndefinedNull(data)){
                $scope.applyFinanceVo.belongGroup = data.groupCode;
                $scope.applyFinanceVo.belongGroupName = data.groupName;
            }
        },function(){

        });
    };

    //年供比例
    $scope.annualSupplyRateChange = function () {
        if($scope.applyFinanceVo.annualSupplyRate>0 && $scope.applyFinanceVo.finPeriodType!=36 && $scope.applyFinanceVo.finPeriodType!=48){
            $scope.applyFinanceVo.annualSupplyRate = 0;
            modalAlert($modal,"如果年供比例输入值，则融资期限只能是36或48");
            return false;
        }
    };

    //盗抢险投保渠道
    $scope.changeTheftInsuranceType = function (vehicleFin) {
        if(vehicleFin.theftInsuranceType == 0){
            vehicleFin.theftInsuranceFlag = '0';
        }else{
            vehicleFin.theftInsuranceFlag = '1';
        }
    };

    //保险，购置税
    $scope.guidePriceChange = function(vehicleFin){

    };

    /**
     * 折扣率、参考购置税、参考保险费
     * 系统常量
     * 保险：commercialInsuranceRate
     * 购置税：purchaseTaxRate
     */
    var commercialInsuranceRate = CommonCodeUtils.getCommonParamValue('commercialInsuranceRate');
    var purchaseTaxRate = CommonCodeUtils.getCommonParamValue('purchaseTaxRate');
    $scope.getDiscountRate = function (vehicleFin) {
        var length = vehicleFin.applyFinDetailVoList.length;
        var num;
        for(var i=0;i<length;i++){
            if(vehicleFin.applyFinDetailVoList[i].finItem == "carprice"){
                num = vehicleFin.applyFinDetailVoList[i].finAmount*100;
                break;
            }
        }
        if(vehicleFin.guidePrice != 0)
            vehicleFin.priceOffRate = Math.ceil(num/vehicleFin.guidePrice);
        else
            vehicleFin.priceOffRate = 0;
        sunFinanceInvestTotal();
    };

    $scope.changeGps = function(vehicleFin){
        var length = vehicleFin.applyFinDetailVoList.length;
        for(var i=0;i<length;i++){
            if(vehicleFin.applyFinDetailVoList[i].finItem == "gps"){
                if(vehicleFin.gpsInstMode == 2){
                    vehicleFin.applyFinDetailVoList[i].finAmount = 0;
                }else{
                    vehicleFin.applyFinDetailVoList[i].finAmount = $scope.gpsValue;
                }
                break;
            }
        }
        sunFinanceInvestTotal();
    };

    //报价单计算
    $scope.quotationCalculation = function (type) {
        var applyInputVo = {};
        applyInputVo.applyFinanceVo = $scope.applyFinanceVo;
        applyInputVo.applyVehicleVoList = $scope.vehicleFinList;
        applyInputVo.applyType = $scope.applyType;
        if($scope.applyType == 1){
            applyInputVo.cstmName = $scope.$parent.cstmPerson.name;
        }else{
            applyInputVo.cstmName = $scope.$parent.cstmCompany.name;
        }
        /*报价单计算前台，加判断：
        产品方案
        融资期限
        业务类型*/
        if($scope.form.product.$invalid || $scope.form.finPeriodType.$invalid || $scope.form.licenseAttr.$invalid){
            $scope.form.product.$dirty = true;
            $scope.form.finPeriodType.$dirty = true;
            $scope.form.licenseAttr.$dirty = true;
            if($scope.form.product.$invalid){
                toaster_info("请填写产品方案！",toaster);
                return false;
            }
            if($scope.form.finPeriodType.$invalid){
                toaster_info("请填写融资期限！",toaster);
                return false;
            }
            if($scope.form.licenseAttr.$invalid){
                toaster_info("请填写业务类型！",toaster);
                return false;
            }

        }else{
            //报价单计算
            if(type == 0){
                $http.post('apply_input/saveQuotationDeviceInfo',applyInputVo).success(function (data) {
                    if(data.code == Response.successCode){
                        var result = data.data;
                        $scope.applyFinanceVo.irr = result.irr;
                        $scope.applyFinanceVo.rent = result.monthlySupply;
                        $scope.applyFinanceVo.tax = result.tax;
                        $scope.applyFinanceVo.loanInterest = result.loanInterest;
                        $scope.applyFinanceVo.quotationDeviceId = result.quotationDeviceId;
                        toaster_info("报价单计算成功！",toaster);
                    }else{
                        modalAlert($modal,data.message);
                    }
                }).error(function (err) {
                    modalAlert($modal,err);
                });
            }else{
                //报价单打印
                $http.post('apply_input/printQuotationDeviceInfo',applyInputVo).success(function (data) {
                    if(data.code == Response.successCode){
                        var result = data.data;
                        $scope.applyFinanceVo.irr = result.irr;
                        $scope.applyFinanceVo.rent = result.monthlySupply;
                        $scope.applyFinanceVo.tax = result.tax;
                        $scope.applyFinanceVo.loanInterest = result.loanInterest;
                        $scope.applyFinanceVo.quotationDeviceId = result.quotationDeviceId;
                        //pdf生成
                        console.log(result.filePath);
                        window.parent.open('file/downloadFile?fileCompletePath='+result.filePath);
                        toaster_info("报价单打印成功！",toaster);
                    }else{
                        modalAlert($modal,data.message);
                    }
                }).error(function (err) {
                    modalAlert($modal,err);
                });
            }

        }
    };

    //年供比例 和尾付比例不能同时输入大于0
    $scope.notSameZero = function (type) {
        var isTrue = ($scope.applyFinanceVo.finalPerc*1>0 || $scope.applyFinanceVo.finalAmount*1>0) && ($scope.applyFinanceVo.annualSupplyRate*1>0 || $scope.applyFinanceVo.annualSupplyAmount*1>0);
        if(type == 1){
            if(isTrue){
                $scope.applyFinanceVo.annualSupplyRate = 0;
                $scope.applyFinanceVo.annualSupplyAmount = 0;
                modalAlert($modal,"年供比例和尾付比例不能同时输入大于0");
            }
        }else{
            if(isTrue){
                $scope.applyFinanceVo.finalPerc = 0;
                $scope.applyFinanceVo.finalAmount = 0;
                modalAlert($modal,"年供比例和尾付比例不能同时输入大于0");
            }
        }
    };

    //融资期限不是36 48 年供不可编辑
    $scope.$watch('applyFinanceVo.finPeriodType',function () {
        if($scope.applyFinanceVo.finPeriodType!=36 && $scope.applyFinanceVo.finPeriodType!=48){
            $scope.isAnnualSupplyRate = true;
        }else{
            $scope.isAnnualSupplyRate = false;
        }
    });

}]);