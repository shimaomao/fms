/**
 * Created by wangxue on 2018/4/10.
 */

app.controller('apply_finance_vehicle_detail_controller', ['$scope', '$http','$modal','toaster', function ($scope, $http, $modal, toaster) {

    // 订单编号
    $scope.applyNo = $scope.$parent.applyNo;
    $scope.vehTabClass = [];
    $scope.vehTabContentClass = [];

    // 合同编号
    $scope.contNo = $scope.$parent.contNo;
    var url = 'apply_input/findApplyFinanceVehicleByApplyNo?applyNo='+ $scope.applyNo;
    if (isNotUndefinedNull($scope.contNo) && $scope.contNo != '') {
        url += '&contNo='+ $scope.contNo;
    }
    $http.get(url).success(function (data) {
        $scope.applyInputVo = data.data;
        console.log(data.data)
        // 融资方案信息
        $scope.applyFinanceVo = $scope.applyInputVo.applyFinanceVo;
        // 车辆和融资明细信息
        $scope.vehicleFinList = $scope.applyInputVo.applyVehicleVoList;
        // 申请人的机构代码
        $scope.basPartner = $scope.applyInputVo.basPartnerVo;
        //销售顾问信息
        $scope.sysUser = $scope.applyInputVo.sysUser;
        // 初始化
        init();
    });

    function init() {
        // 申请类型
        $scope.applyFinanceVo.vehicleFormName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleForm,$scope.applyFinanceVo.vehicleForm);
        //判断是否是二手车
        if($scope.applyFinanceVo.vehicleForm == 2){
            $scope.isOldCar = true;
        }else {
            $scope.isOldCar = false;
        }
        if (CommonObjectUtils.isExist($scope.applyFinanceVo.product)) {
            // 还款频率
            $scope.applyFinanceVo.repayRateName =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.repayRate,$scope.applyFinanceVo.repayRate);
            // 租金支付模式
            $scope.applyFinanceVo.rentPayModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.rentPayMode,$scope.applyFinanceVo.rentPayMode);
            // 还款方式
            $scope.applyFinanceVo.repayModeName =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.repayMode,$scope.applyFinanceVo.repayMode);
            // 手续费收取方式
            $scope.applyFinanceVo.chargePayModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.chargePayMode,$scope.applyFinanceVo.chargePayMode);
            // 保证金返还方式
            $scope.applyFinanceVo.depositRtnModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.depositRtnMode,$scope.applyFinanceVo.depositRtnMode);
            // 融资期限
            $scope.applyFinanceVo.finPeriodTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.finPeriodType,$scope.applyFinanceVo.finPeriodType);
            // 牌照属性
            $scope.applyFinanceVo.licenseAttrName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,$scope.applyFinanceVo.licenseAttr);
            // 利率方式
            $scope.applyFinanceVo.intrstRateModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.intrstRateMode, $scope.applyFinanceVo.intrstRateMode);

        }
        // 融资车辆信息
        for (var index = 0; index < $scope.vehicleFinList.length; index++) {
            // 车辆种类
            if (CommonObjectUtils.isExist($scope.vehicleFinList[index].vehicleType1) && $scope.vehicleFinList[index].vehicleType1 != '') {
                $scope.vehicleFinList[index].vehicleTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleType1, $scope.vehicleFinList[index].vehicleType1);

            }
            // GPS安装情况
            if (CommonObjectUtils.isExist($scope.vehicleFinList[index].gpsInstMode) && $scope.vehicleFinList[index].gpsInstMode != '') {
                $scope.vehicleFinList[index].gpsInstModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsInstMode, $scope.vehicleFinList[index].gpsInstMode);
            }
            // 是否挂靠
            $scope.vehicleFinList[index].linkFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.linkFlag, $scope.vehicleFinList[index].linkFlag);
            // 投资总额
            var investTotal = 0;
            if (isNotUndefinedNull($scope.vehicleFinList[index].applyFinDetailVoList)) {
                var applyFinDetailVoList = $scope.vehicleFinList[index].applyFinDetailVoList;
                for (var t = 0; t < applyFinDetailVoList.length; t++) {
                    if (CommonObjectUtils.isExist(applyFinDetailVoList[t].finAmount) && applyFinDetailVoList[t].finAmount != '') {
                        investTotal += Number(applyFinDetailVoList[t].finAmount);
                    }
                }
            }
            $scope.vehicleFinList[index].investTotal = investTotal.toFixed(2);
        }
        // 融资车页签
        initVehicleTabHide();
        $scope.vehTabClass[$scope.vehicleFinList[0].applyVehicleId] = "selectTab";
        $scope.vehTabContentClass[$scope.vehicleFinList[0].applyVehicleId] = "tab-content";
    }

    // 点击车辆信息页签
    $scope.openFinVehicleInfo = function (vehicleId) {
        initVehicleTabHide();
        $scope.vehTabClass[vehicleId] = "selectTab";
        $scope.vehTabContentClass[vehicleId] = "tab-content";
        var name = '#' + vehicleId;
        $(name).fadeIn();
    };

    // 车辆信息tabClass初始化
    function initVehicleTabHide() {
        for (var i = 0; i < $scope.vehicleFinList.length; i++) {
            $scope.vehTabClass[$scope.vehicleFinList[i].applyVehicleId] = "noneTab";
            $scope.vehTabContentClass[$scope.vehicleFinList[i].applyVehicleId] = "tab-content ng-hide";
        }
    }

    $scope.overdueSales = function (num) {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/overdue_cstm/overdue_sales.html'+getCacheTime(),
            controller: 'overdue_sales_controller',
            resolve:{
                paramsData: function () {
                    return {
                        "contNo": num
                    }
                }
            }
        });
        rtn.result.then(function (data) {

        },function(){

        });
    };

}]);