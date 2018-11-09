/**
 * Created by ningyangyang on 2018-09-01.
 * 展期申请提交
 */
app.controller('defer_task_apply_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http,$modal,toaster,$location) {

    //传值父页面
    $scope.$watch("deferTask",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal !==oldVal)
            $scope.$emit("deferTaskToFather",$scope.deferTask);
    },true);

    $scope.$on('deferTaskToSon',function (e,data) {
        $scope.deferTask = data;
        $scope.deferTaskNo = $scope.deferTask.deferTaskNo;
    });

    //附件对象
    $scope.treeFileId = "deferContractFileList";
    //contNo:$location.search()['contNo'],taskId:$location.search()['contNo'],deferTaskNo:$location.search()['serviceId']
    //从一览页面获取合同编号
    // $scope.contNo = $location.search()['contNo'];
    // $scope.deferTask.contNo = $scope.contNo;
    // //taskId
    // $scope.taskId = $location.search()['taskId'];
    // //taskNo
    // $scope.deferTaskNo = $location.search()['serviceId'];
    // //获取展期合同信息
    // $http.post('defer_task/findDeferTaskVoByContNo',$scope.deferTask).success(function(data){
    //     $scope.deferTask = data.data;
    // });

    /**
     * 提交展期合同信息
     */
    // $scope.submitDeferTaskApply = function () {
    //
    //     if(!$scope.form.$invalid) {
    //
    //         $scope.submit = true;
    //         if($scope.deferTask.notUpload){
    //             modalAlert($modal,$scope.deferTask.notUploadInfo);
    //             $scope.submit = false;
    //             return false;
    //         }
    //         //合同号
    //         $scope.deferTask.contNo = $scope.contNo;
    //         //taskId
    //         $scope.deferTask.taskId = $scope.taskId;
    //         //taskNo
    //         $scope.deferTask.deferTaskNo = $scope.deferTaskNo;
    //         $http.put('defer_task/submitDeferTaskApply', $scope.deferTask).success(function (data) {
    //             if (data.code == Response.successCode){
    //                 if(!$scope.deferTask.taskId){
    //                     $location.path('').search({"msg":'合同展期申请提交成功'}); //共通页面
    //                 }else{
    //                     $location.path('/app/home').search({"msg":'合同展期申请提交成功'});//我的任务页面
    //                 }
    //             }
    //             else
    //                 modalAlert($modal,data.message);
    //             $scope.submit = false;
    //         }).error(function(data){
    //             modalAlert($modal,data);
    //             $scope.submit = false;
    //         })
    //     }else{
    //         $scope.formValidate = true;
    //         toaster_info(promptInfo.submitWarn,toaster);
    //     }
    //
    //
    // }
    //报价单计算
    $scope.quotation = function () {
        if($scope.form.deferMaturity.$invalid || $scope.form.interestRate.$invalid) {
            $scope.form.deferMaturity.$dirty = true;
            $scope.form.interestRate.$dirty = true;
            if($scope.form.deferMaturity.$invalid){
                toaster_info("请填写展期期限！",toaster);
                return false;
            }
            if($scope.form.interestRate.$invalid){
                toaster_info("请填写利率！",toaster);
                return false;
            }
        }else{
            var quotationDeviceVo= {};
            quotationDeviceVo.applicationAmount = $scope.deferTask.deferAmount;  //申请金额
            quotationDeviceVo.financingAmount = $scope.deferTask.deferAmount; //融资金额
            quotationDeviceVo.cehicleTransactionPrice = $scope.deferTask.deferAmount; //车辆成交价
            quotationDeviceVo.cehicleLabelPrice = $scope.deferTask.deferAmount;//车辆标签价
            quotationDeviceVo.cehiclePurchasingPrice = $scope.deferTask.deferAmount;//车辆采购价
            quotationDeviceVo.downPaymentRatio = 0;  //首付款比例
            quotationDeviceVo.firstPayment = 0;  //首付款
            quotationDeviceVo.annualSupplyRate = 0;//年供比例
            quotationDeviceVo.annualSupplyAmount = 0;//年供金额
            quotationDeviceVo.tailProportion = 0; //尾付比例
            quotationDeviceVo.tailMoney = 0;//尾付金额
            quotationDeviceVo.marginLevel = 0//保证金比例
            quotationDeviceVo.bond = $scope.deferTask.deferDeposit; //保证金
            quotationDeviceVo.quotationType = $scope.deferTask.licenseAttr; //业务类型
            quotationDeviceVo.loanTerm = $scope.deferTask.deferMaturity; //展期期限
            quotationDeviceVo.customerInterestRate = $scope.deferTask.interestRate; //客户利率
            quotationDeviceVo.purchaseTax = 0;//购置税
            quotationDeviceVo.commercialInsurance = 0;//商业保险
            quotationDeviceVo.boardServiceCharge = 0; //上牌综合服务
            quotationDeviceVo.highRiskVehicleTax = 0;//交强险车船税
            quotationDeviceVo.fineQuality = 0;//精品
            quotationDeviceVo.serviceCharge = 0;//手续费
            quotationDeviceVo.restitutionFee = 0;//返还经销商手续费
            quotationDeviceVo.renewDeposit = 0;//续保押金
            quotationDeviceVo.channelCommission = 0;//渠道佣金
            quotationDeviceVo.cashReward = 0;//现金奖励
            quotationDeviceVo.internalFormation = 0;//内部提成
            quotationDeviceVo.customerSubsidyAmount = 0;//大客户补贴金额
            $http.post('quotation_device/calculateQuotationDeviceInfo', quotationDeviceVo).success(function (result) {
                if (result.code == Response.successCode) {
                    // $scope.quotationDeviceVo = result.data;
                    $scope.deferTask.irr = result.data.irr;//irr
                    $scope.deferTask.rent = result.data.monthlySupply;//irr
                    toaster_info("报价单计算成功",toaster);
                } else {
                    modalAlert($modal,result.message);
                }
            });
        }

    }


    //计算退还保证金
    $scope.calculateDeposit = function () {
        if($scope.deferTask.deferDeposit>$scope.deferTask.deposit){
            modalAlert($modal,'展期保证金不能多于原保证金');
            $scope.deferTask.deferDeposit = 0;
        }else if($scope.deferTask.deferDeposit<0){
            modalAlert($modal,'请输入大于0的数字');
            $scope.deferTask.deferDeposit = 0;
        }
        if(!$scope.deferTask.deferDeposit){
            $scope.deferTask.deferDeposit = 0;
        }
        $scope.deferTask.backDeposit = $scope.deferTask.deposit*1 - $scope.deferTask.deferDeposit*1;
    }
    //合同详情
    $scope.contractDetails = function () {
        var id = $scope.deferTask.contNo;
        var url = 'app.prebiz_apply_input_detail?applyNo=' + $scope.deferTask.applyNo
            + '&contNo=' +$scope.deferTask.contNo
            + '&applyType=' +$scope.deferTask.applyType
            + '&type=contract'
            + '&contractDate=' +$scope.contractDate
            + '&bizStatus=' +$scope.bizStatus
            + '&isTab=true';
        var title = '合同详情';
        var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
        if(window.parent.addTab){
            window.parent.addTab(html);
        }
    }
    $scope.finPeriodTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.finPeriodType);

    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(){
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.deferContract;
    $scope.wfLogNo = $scope.deferTask.deferTaskNo;

    //查看还款计划表
    $scope.overdueSales = function () {
        var contNo = $scope.deferTask.contNo;
        if(contNo){
            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/postbiz/overdue_cstm/overdue_sales.html'+getCacheTime(),
                controller: 'overdue_sales_controller',
                resolve:{
                    paramsData: function () {
                        return {
                            "contNo": contNo
                        }
                    }
                }
            });
            rtn.result.then(function (data) {

            },function(){

            });
        } else{
            modalAlert($modal,'合同号不存在！');
        }
    };

    //选择收款银行信息
    $scope.selectBasBankInfo = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_bank_info_select_controller',
            resolve:{
                selectBank:function () {
                    return { organizationType:null}
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.deferTask.recAccBranch = data.accBranchBank;
                $scope.deferTask.recAccBank = data.accBankName;
                $scope.deferTask.recAccountName = data.accountName;
                $scope.deferTask.recAccountNo = data.accountNo;
            }
        },function(){
        });
    }

}]);


