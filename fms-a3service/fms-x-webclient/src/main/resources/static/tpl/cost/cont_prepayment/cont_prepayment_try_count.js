/**
 * Created by yangyiquan on 2018-05-10.
 */
app.controller('cont_prepayment_try_count_controller', ['$scope', '$http','$modal','toaster','$location','$compile','$modalInstance','contData', function ($scope, $http,$modal,toaster,$location,$compile,$modalInstance,contData) {

    $scope.contPrepayment={};

    $scope.formValidate = false;

    $scope.submit = false;

    if(CommonObjectUtils.isExist(contData))
        $scope.contNo = contData;

    $scope.frameTitle = $location.search()['frameTitle'];
    $scope.findUrl = 'cont_prepayment/findContPrepaymentWithDetailByContNo?contNo=';
    $scope.show = true;//查看明细
    $scope.findNo = $scope.contNo;//查询编号，根据合同号或业务号查询

    $http.get($scope.findUrl + $scope.findNo).success(function(data){
        console.log(data);
        if(data.code == Response.successCode){
            $scope.contPrepayment = data.data;
            $scope.contPrepaymentNo = $scope.contPrepayment.contPrepaymentNo;

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
                $scope.contPrepayment.payMentAmount  = Math.abs($scope.contPrepayment.prepayActualAmount)
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
                    {title:'实际金额',data:'prepayActualAmount',width:'20%'},
                    /*{title:'实际金额',data:'prepayActualAmount',width:'20%',
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
                    }*/
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
        }
        if($scope.contPrepayment.prepayActualAmount<0){
            $scope.contPrepayment.payMentAmount  = Math.abs($scope.contPrepayment.prepayActualAmount)
            $scope.contPrepayment.receiveAmount = 0;
        }else{
            $scope.contPrepayment.receiveAmount = $scope.contPrepayment.prepayActualAmount;
            $scope.contPrepayment.payMentAmount = 0;
        }
        $scope.contPrepayment.difference = CommonDecimalUtils.formatDecimal(numAddSub(total,$scope.contPrepayment.prepayTrialAmount,2),2);
    };
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

    $scope.close = function(){
        $modalInstance.close();
    };

}]);


