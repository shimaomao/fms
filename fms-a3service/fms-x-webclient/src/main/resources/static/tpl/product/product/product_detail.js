/**
 * Created by niehaibing on 2018-03-23.
 */
app.controller('product_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {
    $scope.productId = ($location.search()["productId"]);

    $http.get("product/findProductVoByProductId?productId="+$scope.productId).success(function (data) {
        if(data.code == Response.successCode){
            console.log(data);
            $scope.product = data.data;
        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    //获取利率方案表头数据
    $http.get('intrst_factor/findIntrstFactorAllList').success(function (data) {
        if(data.code == Response.successCode){
            $scope.factorData = data.data;
        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });
    //获取融资项目checkbox数据
    $http.get("fin_item/findAllFinItemList").success(function (data) {
        if(data.code == Response.successCode){
            $scope.prodFinItemA = $.extend(true,{},data.data);
            $scope.prodFinItemB = $.extend(true,{},data.data);
            $scope.prodFinItemC = $.extend(true,{},data.data);
            $scope.prodFinItemD = $.extend(true,{},data.data);
        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });
    //车辆类型
    $scope.vehicleFormList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleForm);
    //申请类型
    $scope.applyTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.applyType);
    //车辆种类
    $scope.vehicleTypelList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleType);
    //牌照属性
    $scope.licenseAttrList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr);
    //租金支付模式
    $scope.rentPayModeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.rentPayMode);
    //GPS安装情况
    $scope.gpsInstModeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gpsInstMode);
    //还款方式
    $scope.repayModeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.repayMode);
    //还款频率
    $scope.repayRateList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.repayRate);
    //保证金返还方式
    $scope.depositRtnModeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.depositRtnMode);
    //融资期限
    $scope.finPeriodTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.finPeriodType);
    //手续费收取方式
    $scope.chargePayModeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.chargePayMode);

    /*取消*/
    $scope.goBack = function () {
        $location.path('/app/product_product_list').search({
            "productId": null
        });
    };
}]);
/*获取数据字典的codeValueName*/
app.filter('getCodeValueName', function() {
    return function(data,name,type,dataGroup) {
        if(type == 1){
            var result = '';
            if(data != null){
                var dataArray=data.split(",");
            }
            for(x in dataArray){
                result+=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes[name],dataArray[x])+",";
            }
            if(result!=""){
                return result.substring(0,result.length-1);
            }else{
                return "";
            }
            return result;
        }else{
            return dataGroup.factorValueFrom + '~' + dataGroup.factorValueTo;
        }

    };
});

