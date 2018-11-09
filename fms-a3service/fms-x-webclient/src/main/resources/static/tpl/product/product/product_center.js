/**
 * Created by niehaibing on 2018-03-23.
 */

app.controller('product_center_controller', ['$scope', '$http','$modal', 'toaster','$location','$filter', function ($scope, $http,$modal,toaster,$location,$filter) {
    $scope.product={
        vehicleForm:[],     //车辆类型
        applyType: [],      //申请类型
        vehicleType: [],    //车辆种类
        licenseAttr: [],    //牌照属性
        //rentPayMode: [],    //租金支付模式
        gpsInstMode: [],    //GPS安装情况
        //repayMode: [],    //还款方式
        //repayRate: [],    //还款频率
        //depositRtnMode: [],    //保证金返还方式
        finPeriodType: [],    //融资期限
        chargePayMode: [],    //手续费收取方式
        prodFinItems: [], //融资项目
        prodFinItemsIF: [], //首尾付基数
        prodFinItemsFinal: [], //首尾付基数
        prodFinItemsDep: [], //保证金基数
        initPercFrom: 0,
        initPercTo: 100,
        initAmountFrom: 0,
        initAmountTo: 9999999999.0,
        finalPercFrom: 0,
        finalPercTo: 100,
        finalAmountFrom: 0,
        finalAmountTo: 9999999999.0,
        finRiskFrom: 0,
        finRiskTo: 100,
        depositFrom: 0,
        depositTo: 9999999999.0,
        depositPercFrom: 0,
        depositPercTo: 100,
        finTotalFrom: 0,
        finTotalTo: 9999999999.0,
        annualSupplyRateFrom: 0,
        annualSupplyRateTo: 100,
        annualSupplyAmountFrom: 0,
        annualSupplyAmountTo: 9999999999.0,
        irrFrom: 0,
        irrTo: 9999999999.0,
        endDate:'2099-12-31',
        prodIntrstVoList: [],   //利率方案
        prodVehicleVopList: [], //车型输入辅助
        prodFileVoList: [],     //产品附件输入辅助
        prodGroupVoList: []     //用户组输入辅助

    };

    $scope.productId = ($location.search()["productId"]);
    /*$scope.productId存在：修改 不存在：添加*/
    if($scope.productId){
        $http.get("product/findProductVoByProductId?productId="+$scope.productId).success(function (data) {
            if(data.code == Response.successCode){
                $scope.product = data.data;
                if(!data.data.productCatg){
                    $scope.product.productCatg = '';
                }
                $scope.stringToArr();
            }else{
                modalAlert($modal,data.message);

            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    }

    $scope.formValidate = false;

    $scope.submit = false;
    //获取产品大类数据
    $http.get("product_catg/findProductCatgListByAll").success(function (data) {
        if(data.code == Response.successCode){
            $scope.productCatgList = data.data
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

    //checkbox赋值
    $scope.checkboxValue = function (name,value) {
        $scope.form[name].$dirty = true;
        var itemList = $scope[name+'List'];
        var item = $scope.product[name];
        var index = item.indexOf(value);
        if(index==-1){
            item.push(value);
        }else{
            item.splice(index,1);
            if(itemList){
                for(var i = 0;i<itemList.length;i++){
                    if(itemList[i].checked){
                        return
                    }
                }
                $scope.product[name] = [];
            }
        }
    };

    /**
     * 保存组织机构属性信息
     * vehicleForm:[],     //车辆类型
     applyType: [],      //申请类型
     vehicleType: [],    //车辆种类
     licenseAttr: [],    //牌照属性
     rentPayMode: [],    //租金支付模式
     gpsInstMode: [],    //GPS安装情况
     repayMode: [],    //还款方式
     repayRate: [],    //还款频率
     depositRtnMode: [],    //保证金返还方式
     finPeriodType: [],    //融资期限
     chargePayMode: [],    //手续费收取方式
     */
    $scope.save = function () {
        //验证checkbox必填
        if($scope.product.vehicleForm.length != 0 &&
            $scope.product.applyType.length != 0 &&
            $scope.product.vehicleType.length != 0 &&
            $scope.product.licenseAttr.length != 0 &&
            //$scope.product.rentPayMode.length != 0 &&
            $scope.product.gpsInstMode.length != 0 &&
            //$scope.product.repayMode.length != 0 &&
            //$scope.product.repayRate.length != 0 &&
            //$scope.product.depositRtnMode.length != 0 &&
            $scope.product.finPeriodType.length != 0 &&
            $scope.product.chargePayMode.length != 0 &&
            $scope.product.prodFinItems.length != 0 &&
            $scope.product.prodFinItemsIF.length != 0 &&
            $scope.product.prodFinItemsFinal.length != 0 &&
            $scope.product.prodFinItemsDep.length != 0 &&
            $scope.product.productCatg &&
            checkProdIntrstVoList()){
            $scope.correct = true;
        }else{
            $scope.correct = false;
        }
        if(!$scope.form.$invalid && $scope.correct) {
            $scope.submit = true;
            $scope.arrToString();

            $http.post('product/saveProduct', $scope.product).success(function (data) {
                if (data.code == Response.successCode){
                    if($scope.productId){
                        $location.path('/app/product_product_list').search({"productId": null, type:'modify'});
                    }else{
                        $location.path('/app/product_product_list').search({"productId": null, type:'save'});
                    }
                }else{
                    $scope.stringToArr();
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function(data){
                $scope.stringToArr();
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };
    /*取消*/
    $scope.close = function () {
        $location.path('/app/product_product_list').search({
            "productId": null
        });
    };
    /*删除*/
    $scope.delete = function (index,type) {
        if($scope.productId && type == 'prodIntrstVoList'){
            var obj = $scope.product[type][index];
            obj.intrstDelFlag = 1;
            $scope.product[type].splice(index,1);
            $scope.product[type].push(obj);
        }else{
            $scope.product[type].splice(index,1);
        }
    };
    //check产品利率方案
    function checkProdIntrstVoList(){
        var canEdit = $filter('intrstShow')($scope.product.prodIntrstVoList);
        if(canEdit){
            modalAlert($modal,'利率方案列表不能为空');
            return false;
        }
        return true;
    }
    /*checkbox值的转换*/
    $scope.arrToString = function () {
        $scope.product.vehicleForm = CommonStringUtils.arrToString($scope.product.vehicleForm);
        $scope.product.applyType = CommonStringUtils.arrToString($scope.product.applyType);
        $scope.product.vehicleType = CommonStringUtils.arrToString($scope.product.vehicleType);
        $scope.product.licenseAttr = CommonStringUtils.arrToString($scope.product.licenseAttr);
        //$scope.product.rentPayMode = CommonStringUtils.arrToString($scope.product.rentPayMode);
        $scope.product.gpsInstMode = CommonStringUtils.arrToString($scope.product.gpsInstMode);
        //$scope.product.repayMode = CommonStringUtils.arrToString($scope.product.repayMode);
        //$scope.product.repayRate = CommonStringUtils.arrToString($scope.product.repayRate);
        //$scope.product.depositRtnMode = CommonStringUtils.arrToString($scope.product.depositRtnMode);
        $scope.product.finPeriodType = CommonStringUtils.arrToString($scope.product.finPeriodType);
        $scope.product.chargePayMode = CommonStringUtils.arrToString($scope.product.chargePayMode);
    };
    $scope.stringToArr = function () {
        $scope.product.vehicleForm = $scope.product.vehicleForm ? $scope.product.vehicleForm.split(",") : [];
        $scope.product.applyType = $scope.product.applyType ? $scope.product.applyType.split(",") : [];
        $scope.product.vehicleType = $scope.product.vehicleType ? $scope.product.vehicleType.split(",") : [];
        $scope.product.licenseAttr = $scope.product.licenseAttr ? $scope.product.licenseAttr.split(",") : [];
        //$scope.product.rentPayMode = $scope.product.rentPayMode ? $scope.product.rentPayMode.split(",") : [];
        $scope.product.gpsInstMode = $scope.product.gpsInstMode ? $scope.product.gpsInstMode.split(",") : [];
        //$scope.product.repayMode = $scope.product.repayMode ? $scope.product.repayMode.split(",") : [];
        //$scope.product.repayRate = $scope.product.repayRate ? $scope.product.repayRate.split(",") : [];
        //$scope.product.depositRtnMode = $scope.product.depositRtnMode ? $scope.product.depositRtnMode.split(",") : [];
        $scope.product.finPeriodType = $scope.product.finPeriodType ? $scope.product.finPeriodType.split(",") : [];
        $scope.product.chargePayMode = $scope.product.chargePayMode ? $scope.product.chargePayMode.split(",") : [];
    };
    /*增加利率方案*/
    $scope.add = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/product/product/product_intrst.html'+getCacheTime(),
            controller: 'product_intrst_controller',
            resolve:{
                intrstData: function () {
                    return {
                        "data":"",
                        "index":""
                    }
                }
            }
        });
        rtn.result.then(function (data) {
            if(data){
                $scope.product.prodIntrstVoList.push(data.data);
            }else{

            }
        },function(){

        });
    };
    /*修改利率方案*/
    $scope.edit = function (index,data) {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/product/product/product_intrst.html'+getCacheTime(),
            controller: 'product_intrst_controller',
            resolve:{
                intrstData: function () {
                    return {
                        "index": index,
                        "data": $.extend(true,{},data)
                    }
                }
            }
        });
        rtn.result.then(function (data) {
            if(data){
                $scope.product.prodIntrstVoList[data.index] = data.data;
            }

        },function(){

        });
    };
    /*车型输入辅助*/
    $scope.addCarModels = function () {
        var rtn = $modal.open({
            backdrop : 'static',

            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_vehicle/bas_vehicle_list_level_select.html'+getCacheTime(),
            controller: 'bas_vehicle_list_select_level_controller',
            resolve:{
                basVehicle : function () {
                    return {
                        vehicleLevel: '',
                        vehicleCodeList: '',
                        vehicleType: ''
                    };
                }
            }
        });
        rtn.result.then(function (data) {
            if(data){
                var arr = $scope.product.prodVehicleVopList.concat(data);
                $scope.product.prodVehicleVopList = CommonStringUtils.filterDuplication(arr,'vehicleId');
            }
        },function(){

        });
    };
    /*产品附件输入辅助*/
    $scope.addInputAuxiliary = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_file_type/bas_file_type_list_select.html'+getCacheTime(),
            controller: 'bas_file_type_list_select_controller',
            resolve:{
                setData: function () {
                    return {
                        "checkboxOrRadio": CheckBox
                    };
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null){
                if(data instanceof Array){
                    var arr = $scope.product.prodFileVoList.concat(data);
                    $scope.product.prodFileVoList = CommonStringUtils.filterDuplication(arr,'fileTypeId');
                }else{
                    $scope.product.prodFileVoList.push(data);
                }
            }
        },function(){

        });
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
            var arr = $scope.product.prodGroupVoList.concat(data);
            $scope.product.prodGroupVoList = CommonStringUtils.filterDuplication(arr,'groupId');
        },function(){

        });
    };

}]);

