/**
 * Created by yangyiquan on 2018-05-10.
 */
app.controller('cont_prepayment_modify_controller', ['$scope', '$http','$modal','toaster','$location','$compile', function ($scope, $http,$modal,toaster,$location,$compile) {

    $scope.contPrepayment={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.frameTitle = $location.search()['frameTitle'];
    $scope.backUrl = 'app/cost_cont_prepayment_list';
    $scope.findUrl = 'cont_prepayment/findContPrepaymentWithDetailByContNo?contNo=';
    $scope.applySave = $location.search()['operate']=='save' || false;;//初次申请
    $scope.show = $location.search()['operate']=='show' || false;//查看明细
    $scope.approveShow = false;//审批查看
    $scope.approveSave = false;//审批退回再提交
    $scope.contNo = $location.search()['contNo'];
    $scope.contPrepaymentNo = $location.search()['contPrepaymentNo'];
    $scope.findNo = $scope.contNo;//查询编号，根据合同号或业务号查询
    $scope.wfLogSubNo = '';
    //$scope.payment = false;
    $scope.receiptFlag = false;
    $scope.detail = $location.search()['detail'];

    $scope.$watch("contPrepayment",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal){
            $scope.$emit("contPrepaymentToFather",$scope.contPrepayment);
        }
    },true);

    //从我的任务中进来,或者有任务号，就用任务号查询
    if(!$scope.contNo || $scope.contPrepaymentNo){
        $scope.contPrepaymentNo = $location.search()['serviceId'] || $scope.contPrepaymentNo;
        $scope.findNo = $scope.contPrepaymentNo;
        $scope.findUrl = 'cont_prepayment/findContPrepaymentWithDetailByContPrepaymentNo?contPrepaymentNo=';
    }

    $http.get($scope.findUrl + $scope.findNo).success(function(data){
        console.log(data);
        if(data.code == Response.successCode){
            $scope.contPrepayment = data.data;
            $scope.contPrepaymentNo = $scope.contPrepayment.contPrepaymentNo;
            // 过户状态
            $scope.contPrepayment.transferHandleStsName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus, $scope.contPrepayment.transferHandleSts);
            // if($scope.contPrepayment.prepaymentSts == '0709'|| $scope.contPrepayment.prepaymentSts == '0711'|| $scope.contPrepayment.prepaymentSts == '0710'){
            //
            //     $scope.payment = true;
            // }
            if($scope.contPrepayment.prepaymentSts==CommonCodeUtils.codeValues.prepaymentSts && !$scope.show && !$scope.applySave){//退回待二次提交
                $scope.contPrepayment.taskId = $location.search()['taskId'];
                $scope.approveSave = true;
                $scope.backUrl = '/app/home';
            }else if(!$scope.show && !$scope.applySave){//另外三个状态都不是，就是审批查看
                $scope.approveShow = true;
            }
            console.log($scope)

            var length = $scope.contPrepayment.contPrepayDetails.length;
            var totalTrial = 0,totalActual = 0,type = 1;
            for(var i=0;i<length;i++){
                if($scope.contPrepayment.contPrepayDetails[i].prepaymDetailItem=='deposit' ||
                    $scope.contPrepayment.contPrepayDetails[i].prepaymDetailItem=='renewalDeposit' ||
                    $scope.contPrepayment.contPrepayDetails[i].prepaymDetailItem=='otherSubtract'){
                    type = 2;
                }else{
                    type = 1;
                }
                //参考金额
                if($scope.contPrepayment.contPrepayDetails[i].prepayTrialAmount != null){

                    totalTrial = numAddSub(totalTrial,$scope.contPrepayment.contPrepayDetails[i].prepayTrialAmount,type);
                }
                //实际金额
                if($scope.contPrepayment.contPrepayDetails[i].prepayActualAmount != null){
                    totalActual = numAddSub(totalActual,$scope.contPrepayment.contPrepayDetails[i].prepayActualAmount,type);
                }else{
                    $scope.contPrepayment.contPrepayDetails[i].prepayActualAmount = "";
                }

            }
            $scope.contPrepayment.prepayTrialAmount = CommonDecimalUtils.formatDecimal(totalTrial,2);
            $scope.contPrepayment.prepayActualAmount = CommonDecimalUtils.formatDecimal(totalActual,2);
            if($scope.contPrepayment.prepayActualAmount<0){
                $scope.receiptFlag = true;
            }
            if($scope.contPrepayment.prepayActualAmount<0){
                $scope.contPrepayment.payMentAmount  = Math.abs($scope.contPrepayment.prepayActualAmount);
                if (!isUndefinedNull($scope.contPrepayment.transferTotalCost)) {
                    // 实际总金额加上过户总额
                    $scope.contPrepayment.payMentAmount += $scope.contPrepayment.transferTotalCost;
                }
                $scope.contPrepayment.payMentAmount = CommonDecimalUtils.formatDecimal($scope.contPrepayment.payMentAmount,2);
                $scope.contPrepayment.receiveAmount = 0;
            }else{
                $scope.contPrepayment.receiveAmount = $scope.contPrepayment.prepayActualAmount;
                $scope.contPrepayment.payMentAmount = 0;
            }
            $scope.contPrepayment.difference = CommonDecimalUtils.formatDecimal(numAddSub(totalActual,totalTrial,2),2);


            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'prepayment_table',
                //table的列
                dataTableColumn: [
                    {title:'项目',data:'prepaymDetailItem',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.prepaymDetailItem,data);
                        }
                    },
                    {title:'参考金额',data:'prepayTrialAmount',width:'20%'},
                    {title:'实际金额',data:'prepayActualAmount',width:'20%',
                        render: function (data, type, row, meta) {
                            return creatInput('prepayActualAmount',meta,data);
                        },
                        fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                            $compile(nTd)($scope);
                        }
                    },{title:'备注',data:'memo',width:'20%',
                        render: function (data, type, row, meta) {
                            return creatMemoInput('memo',meta,data);
                        },
                        fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                            $compile(nTd)($scope);
                        }
                    }
                ],
                dataTableData: $scope.contPrepayment.contPrepayDetails
            };
            $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
            $compile($("#prepayment_table"))($scope);

        }else {
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });
    $scope.prepaymentTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.prepaymentType);
    /**
     * 保存提前还款信息
     */
    $scope.save = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.contPrepayment.contPrepayDetails = $scope.dataTable.fnGetData();
            $http.post('cont_prepayment/saveContPrepaymentWithDetail', $scope.contPrepayment).success(function (data) {
                if (data.code == Response.successCode){
                    if($scope.approveSave){
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                    }else{
                        $location.path("app/cost_cont_prepayment_list").search({type:"save"});
                    }
                }
                else{
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
        }else{
            $scope.formValidate = true;
        }
    };

    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path($scope.backUrl);
    };

    $scope.setInputVal = function(a,meta,name) {
        var nTr = $scope.dataTable.fnGetData();
        var length = nTr.length;
        var total = 0;
        nTr[meta][name] = a;
        for(var i=0;i<length;i++){
            if(nTr[i][name]){
                if(nTr[i].prepaymDetailItem=='deposit' || nTr[i].prepaymDetailItem=='renewalDeposit' || nTr[i].prepaymDetailItem=='otherSubtract'){
                    total = numAddSub(total,nTr[i][name],2)
                }else{
                    total = numAddSub(total,nTr[i][name],1)
                }
            }
        }
        $scope.contPrepayment.prepayActualAmount = CommonDecimalUtils.formatDecimal(total,2);
        if($scope.contPrepayment.prepayActualAmount<0){
            $scope.receiptFlag = true;
        } else {
            $scope.receiptFlag = false;
            initRecAccInfo();
        }
        if($scope.contPrepayment.prepayActualAmount<0){
            $scope.contPrepayment.payMentAmount  = CommonDecimalUtils.formatDecimal(Math.abs($scope.contPrepayment.prepayActualAmount),2);
            $scope.contPrepayment.receiveAmount = 0;
        }else{
            $scope.contPrepayment.receiveAmount = $scope.contPrepayment.prepayActualAmount;
            $scope.contPrepayment.payMentAmount = 0;
        }
        $scope.contPrepayment.difference = CommonDecimalUtils.formatDecimal(numAddSub(total,$scope.contPrepayment.prepayTrialAmount,2),2);
    };

    // 置空收款银行信息
    function initRecAccInfo() {
        $scope.contPrepayment.recAccBank = "";// 收款银行
        $scope.contPrepayment.recAccBranch = "";// 收款银行分行
        $scope.contPrepayment.recAccountName = "";// 收款账户名
        $scope.contPrepayment.recAccountNo = "";// 收款卡号

    }

    //创建金额输入框
    function creatInput(name,meta,data) {
        var html = "";
        data = data*1;
        if($scope.approveSave || $scope.applySave){
            html += "<input name=\""+name+""+meta.row+"\" type=\"number\" class=\"form-control\" ng-model=\""+name+""+meta.row+"\" ng-change=\"setInputVal("+name+""+meta.row+","+meta.row+",'"+name+"');\" ng-init=\""+name+""+meta.row+"="+data+"\" required />";
        }else{
            html += "<input name=\""+name+""+meta.row+"\" type=\"number\" class=\"form-control\" ng-model=\""+name+""+meta.row+"\" ng-change=\"setInputVal("+name+""+meta.row+","+meta.row+",'"+name+"');\" ng-init=\""+name+""+meta.row+"="+data+"\" disabled />";
        }
        html += "<span class=\"form-info\" ng-show=\" (form."+name+""+meta.row+".$dirty && form."+name+""+meta.row+".$error.required) || (form."+name+""+meta.row+".$error.required && formValidate)\">不能为空</span>";
        return html;
    }

    //创建备注
    function creatMemoInput(name,meta,data) {
        if(isUndefinedNull(data)){
            data = "";
        }
        var html = "";
        if($scope.approveSave || $scope.applySave){
            html += "<input limit-word='255' name=\""+name+""+meta.row+"\" type=\"text\" class=\"form-control\" ng-model=\""+name+""+meta.row+"\" ng-change=\"setMemoInputVal("+name+""+meta.row+","+meta.row+",'"+name+"');\" ng-init=\""+name+""+meta.row+"='"+data+"'\" />";
        }else{
            html += "<input name=\""+name+""+meta.row+"\" type=\"text\" class=\"form-control\" ng-model=\""+name+""+meta.row+"\" title=\""+data+"\" ng-init=\""+name+""+meta.row+"='"+data+"'\" disabled />";
        }
        return html;
    }

    $scope.setMemoInputVal = function(a,meta,name) {
        var nTr = $scope.dataTable.fnGetData();
        nTr[meta][name] = a;
    };

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

    /**
     * 打印提前还款信息
     */
    $scope.print = function () {
        // if(!$scope.form.$invalid) {
            $scope.contPrepayment.contPrepayDetails = $scope.dataTable.fnGetData();

            CommonFileUtils.downloadFilePost('cont_prepayment/printPrepayment',$scope.contPrepayment
                ,$http,$modal,$scope);

        // }else{
        //     $scope.formValidate = true;
        // }
    };


    //查看还款计划表
    $scope.overdueSales = function () {
        var contNo = $scope.contPrepayment.contNo;
        console.log(contNo)
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


    //查看逾期详情
    $scope.overdueDetail = function () {
        //取得逾期客户id
        $http.get('deposit_change_task/findOverdueCstmId?certifNo='+$scope.contPrepayment.certifNo).success(function (data) {
            if(data.code == Response.successCode){
                var overdueCstmId = data.data;
                if(CommonStringUtils.isTrimBlank(overdueCstmId)){
                    modalAlert($modal,'该客户未发生过逾期');
                } else {
                    var id = overdueCstmId;
                    var url = 'app.postbiz_overdue_cstm_modify?overdueCstmId=' + overdueCstmId
                        + '&detail=true&isTab=true';
                    var title = '逾期详情';
                    var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
                    if(window.parent.addTab){
                        window.parent.addTab(html);
                    }
                }
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };

}]);


