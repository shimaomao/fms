app.controller('pribiz_cont_charge_controller', ['$scope', '$http','$modal','$compile','$location', 'toaster',function ($scope, $http,$modal,$compile,$location,toaster) {

    $scope.contRequestPayActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contRequestPayActType);
    $scope.submit = false;
    $scope.formValidate = false;

    //初始化定义银行信息
    $scope.contReceiptVoList = [];
    $scope.contReceiptPayVo = {};
    $scope.applyNo = $location.search()['applyNo'];
    $scope.contNo = $location.search()['contNo'];
    $scope.applyType = $location.search()['applyType'];
    $scope.taskId = $location.search()['taskId'];
    $http.get('cont_receipt_pay/findContReceiptPayVoByContNo?contNo='+$location.search()['contNo']).success(function (data) {

        $scope.contReceiptPayVo = data.data;
        $scope.contReceiptPayVo.contNo=$location.search()["contNo"];
        $scope.contReceiptPayVo.applyNo=$location.search()["applyNo"];
        $scope.contReceiptPayVo.applyType=$location.search()["applyType"];
        $scope.contReceiptPayVo.taskId=$location.search()["taskId"];
        $scope.contReceiptPayVo.insuranceStatus='1';//默认提交
        $scope.contReceiptPayVo.memo = "";
        //计算实际收款总额
        $scope.setInputVal();

        /*$scope.dataTableProperties= {
            //table的html id
            dataTableId:'cont_receipt_table',
            //table的列
            dataTableColumn: [
                {title:'收款类型',data:'chargeFund',width:'20%',
                    render: function (data, type, row, meta) {
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.payFundName,data);
                    }
                },
                {title:'应收金额',data:'chargeAmount',width:'20%',
                    render: function (data, type, row, meta) {
                        return '<span id="'+row.chargeFund+'">'+data+'</span>';
                    }}
            ],
            dataTableData: $scope.contReceiptPayVo.contChargeList
        };
        $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
        $compile($("#cont_receipt_table"))($scope);*/
    }).error(function(data){
        modalAlert($modal,"请求失败");
    });



    //增加银行信息
    $scope.add = function () {
        var obj = {};
        $scope.contReceiptVoList.push(obj);
    };
    //删除银行信息
    $scope.del = function (index) {
        $scope.contReceiptVoList.splice(index,1);
    };

    /**
     * 提交信息
     */
    $scope.submitCont = function () {
        $scope.url="";
        if(isNullEmpty($scope.contReceiptPayVo.insuranceStatus)){
            toaster_info("请选择审批提交还是退回！",toaster);
            return;
        }
        $scope.bankFlag = true;

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            if($scope.contReceiptPayVo.insuranceStatus=="1"){

                $scope.contReceiptPayVo.contChargeReceiptVoList.forEach(function (row,index) {
                    if(isNullEmpty(row.recAccBranch) && row.receiptAmount>0){
                        $scope.bankFlag = false;
                    }
                });
                if(!$scope.bankFlag){
                    modalAlert($modal,"请选择实收金额大于0的收款银行");
                    $scope.submit = false;
                    return;
                }
                $scope.url="cont_receipt_pay/submitContCharge";//提交
            }else{
                $scope.url="cont_receipt_pay/backContCharge";//退回
            }
            $http.post($scope.url, $scope.contReceiptPayVo).success(function (data) {
                if (data.code == Response.successCode){
                    if($scope.contReceiptPayVo.insuranceStatus=="1"){
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                    }else{
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'退回成功'});
                    }
                }else{
                    modalAlert($modal,data.message);
                }

                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    }

    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("/app/home");
    };

    //收款银行选择
    $scope.selectBasBankInfo = function(a){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_bank_info_select_controller',
            resolve:{
                selectBank: function () {
                    return {organizationType: CommonCodeUtils.organizationType.userGroup}
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                a.recAccBank = data.accBankName;
                a.recAccountName = data.accountName;
                a.recAccountNo = data.accountNo;
                a.recEleBankNo = data.eleAccountNo;
                a.recAccBranch = data.accBranchBank;
                a.finassSubjectCd = data.finassSubjectCd;
            }
        },function(){
        });
    }

    //是否交首期租金
    $scope.changeFirstRent = function(){
        var rows = $scope.contReceiptPayVo.contChargeReceiptVoList;
        console.log(rows);
        if($scope.contReceiptPayVo.chargeFirstRent == CommonCodeUtils.yesNoFlag.yes){//收首期租金
            if(rows && rows.length>0){
                for(var i = 0;i<rows.length;i++){
                    if(rows[i].chargeFund == 'firstRent'){//首期租金
                        rows[i].chargeAmount = $scope.contReceiptPayVo.rent;
                        $scope.contReceiptPayVo.totalAmount = numAddSub($scope.contReceiptPayVo.totalAmount,$scope.contReceiptPayVo.rent,1);
                    }
                }
            }
        }else{//不收首期租金
            if(rows && rows.length>0){
                for(var i = 0;i<rows.length;i++){
                    if(rows[i].chargeFund == 'firstRent'){//首期租金
                        rows[i].chargeAmount = 0;
                        $scope.contReceiptPayVo.totalAmount = numAddSub($scope.contReceiptPayVo.totalAmount,$scope.contReceiptPayVo.rent,2);
                    }
                }
            }
        }
    }

    // 抵扣金额change事件
    $scope.chargeDeductionAmount = function(a){
        if (a){
            a.receiptAmount = a.chargeAmount - (a.chargeDeductionAmount== null?0:a.chargeDeductionAmount);
        }
        // 计算实收总金额
        var total = 0;
        for(var i=0;i<$scope.contReceiptPayVo.contChargeReceiptVoList.length;i++){
            total = numAddSub(total,$scope.contReceiptPayVo.contChargeReceiptVoList[i].receiptAmount,1)
        }
        $scope.contReceiptPayVo.totalActualAmount = total;
    }

    // 实收金额change事件
    $scope.setInputVal = function(a) {
        // 计算实收总金额
        var total = 0;
        for(var i=0;i<$scope.contReceiptPayVo.contChargeReceiptVoList.length;i++){
            total = numAddSub(total,$scope.contReceiptPayVo.contChargeReceiptVoList[i].receiptAmount,1)
        }
        $scope.contReceiptPayVo.totalActualAmount = total;

        /*if (a){
            a.chargeDeductionAmount = a.chargeAmount - (a.receiptAmount==null?0:a.receiptAmount);
        }*/
    };

    function numAddSub(num1,num2,type) {
        if(isNullEmpty(num1)){
            num1 = 0;
        }
        if(isNullEmpty(num2)){
            num2 = 0;
        }
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

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.apply;
    $scope.wfLogNo = $scope.applyNo;
    $scope.wfLogSubNo = $scope.contNo;

}]);


