app.controller('apply_conditional_agree_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {
    //当前流程的key
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];
    //附件对象
    $scope.formValidate = false;
    //风控经理审核操作
    if($scope.taskDefinitionKey == 'contract_generation_diragree')
        $scope.applyAgreeConditionalActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.applyAgreeConditionalActType);
    else
        //副总审核操作
        $scope.applyAgreeConditionalActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.applyAgreeConditionalActType2);

    $scope.submit = false;
    $scope.isQuotationCalculation = false;//是否点击过报价器计算

    $scope.submitUrl = null;

    $scope.applyNo = $location.search()['applyNo'];
    $scope.contNo = $location.search()['contNo'];
    $scope.applyType = $location.search()['applyType'];
    $scope.taskId = $location.search()['taskId'];

    $scope.applyConditionalAgreeVo = {applyNo: $location.search()['applyNo'],contNo:$location.search()['contNo'],
        applyType:$location.search()['applyType'],taskId:$location.search()['taskId'],taskDefinitionKey:$location.search()['taskDefinitionKey']};

    $http.get('apply_conditional_agree/findApplyConditionalAgreeVoByApplyNo?applyNo='+$scope.applyNo).success(function (data) {
        if(data.code == Response.successCode){
            $scope.applyConditionalAgreeVo.windcontrManagerProposal = data.data.windcontrManagerProposal;
            $scope.applyConditionalAgreeVo.applyFinance = data.data.applyFinance;
            $scope.applyConditionalAgreeVo.mortgageFlag = data.data.mortgageFlag;
            $scope.applyConditionalAgreeVo.riskAmount = data.data.riskAmount;
        }
    });

    $scope.submitInfo = function(){

        if(!$scope.form.$invalid) {
            //获得提交的url
            $scope.submitUrl = 'apply_conditional_agree/approve';
            if(CommonObjectUtils.isNotExist($scope.applyConditionalAgreeVo.actType)){
                modalAlert($modal,"请选择操作分类");
            }else{
                if($scope.applyConditionalAgreeVo.actType == '2'){//有条件同意时需计算报价器
                    if(!$scope.isQuotationCalculation){
                        modalAlert($modal,"请重新计算报价器");
                        return;
                    }
                }
                $scope.submit = true;
                $http.post($scope.submitUrl,$scope.applyConditionalAgreeVo).success(function(data){
                    if (data.code == Response.successCode){
                        $location.path("/app/home").search({type:'homeToastInfo', msg:'审批成功'});
                    } else {
                        modalAlert($modal,data.message);
                    }
                    $scope.submit = false;
                }).error(function(data){
                    modalAlert($modal,data);
                    $scope.submit = false;
                })
            }
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }

    }


    // 返回
    $scope.goBack = function () {
        $location.path('/app/home');
    };


    $scope.changePerc = function(name,value){
        $scope.isQuotationCalculation = false;
        $scope.applyConditionalAgreeVo.applyFinance[name] = CommonDecimalUtils.getAmountByPercAndCeil(value,$scope.applyConditionalAgreeVo.applyFinance.investTotal,2);
    }

    $scope.changeAmount = function(name,value){
        $scope.isQuotationCalculation = false;
        $scope.applyConditionalAgreeVo.applyFinance[name] = CommonDecimalUtils.getPercByAmount(value,$scope.applyConditionalAgreeVo.applyFinance.investTotal,2);
    }

    //首付额改变时计算融资额
    $scope.$watch('applyConditionalAgreeVo.applyFinance.initAmountAgree',function(newValue,oldValue){
        if ($scope.applyConditionalAgreeVo.applyFinance){
            $scope.applyConditionalAgreeVo.applyFinance.finTotalAgree = Math.ceil(CommonDecimalUtils.formatDecimal(numAddSub($scope.applyConditionalAgreeVo.applyFinance.investTotal,
                $scope.applyConditionalAgreeVo.applyFinance.initAmountAgree,2),2));
        }
    });

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.apply;
    $scope.wfLogNo = $scope.applyNo;


    /**
     * 报价单计算
     */
    $scope.quotationCalculation = function(){

        //获得提交的url
        $scope.submitUrl = 'apply_conditional_agree/quotationCalculation';
        $scope.submit = true;
        $http.post($scope.submitUrl,$scope.applyConditionalAgreeVo.applyFinance).success(function(data){
            $scope.submit = false;
            if (data.code == Response.successCode){
                toaster_info("报价单计算成功",toaster);
                var result = data.data;
                $scope.isQuotationCalculation = true;
                $scope.applyConditionalAgreeVo.applyFinance.irrAgree = result.irr;
                $scope.applyConditionalAgreeVo.applyFinance.rentAgree = result.monthlySupply;
                $scope.applyConditionalAgreeVo.applyFinance.taxAgree = result.tax;
            } else {
                modalAlert($modal,data.message);
            }
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })

        /*if(!$scope.form.$invalid) {

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }*/
    }

    function numAddSub(num1,num2,type) {
        //要相加的两个数(小数)
        var baseNum, baseNum1, baseNum2;
        try {
            baseNum1 = num1.toString().split(".")[1].length;
        } catch (e) {
            baseNum1 = 0;
        }
        try {
            baseNum2 = num2.toString().split(".")[1].length;
        } catch (e) {
            baseNum2 = 0;
        }
        baseNum = Math.pow(10, Math.max(baseNum1, baseNum2));
        if(type == 1){
            return (num1 * baseNum + num2 * baseNum) / baseNum;
        }else{
            return (num1 * baseNum - num2 * baseNum) / baseNum;
        }
    }

    //获取数据
    $http.get('apply_risk/findApplyRiskInit?applyNo='+$scope.applyNo).success(function (data) {
        if(data.code == Response.successCode){
            $scope.riskData = data.data;
            $scope.riskData.taskId = $location.search()['taskId'];
            //向子控制器广播数据
            $scope.$broadcast('riskDataToSon', $scope.riskData );
            console.log($scope.riskData);

        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    $scope.disabled = true;
    $scope.detailFlag = 0;

    // 加入黑名单
    $scope.addBlacklist = function () {
        var registerType = "1"; //登记类型：风控审批
        // 获取客户中的全部申请编号集合
        var applyNoList = [];
        applyNoList.push($scope.applyNo);
        var basBlacklistVo = {"registerType": registerType, "applyNoList": applyNoList};
        $http.post('bas_blacklist/saveBasBlacklistByApplyNo',basBlacklistVo).success(function (result) {
            if (result.code == Response.successCode){
                toaster_success("加入黑名单成功！",toaster);
            }else{
                modalAlert($modal,result.message);
            }
        }).error(function (result) {
            modalAlert($modal,result);
        })
    }

    // 初始化根据订单编号查询黑名单信息
    $scope.basBlacklists = [];
    function initBasBlacklistInfo() {
        $http.get('bas_blacklist/findBasBlacklistVosByApplyNo?applyNo=' + $scope.applyNo).success(function (result) {
            if (result.code == Response.successCode) {
                $scope.basBlacklists = result.data;
            }
        })
    }
    initBasBlacklistInfo();

}]);