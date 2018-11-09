app.controller('cont_receipt_manual_checked_controller', ['$scope', '$http','$modal','$compile','$location', 'toaster',function ($scope, $http,$modal,$compile,$location,toaster) {

    $scope.submit = false;
    $scope.formValidate = false;

    //初始化定义银行信息
    $scope.contReceiptVoList = [];
    $scope.contReceiptPostVo = {};

    $scope.contReceiptPostVo.contRepaySkedVoList = JSON.parse($location.search()['repaySkedIdRows']);
    $scope.contReceiptPostVo.solveFlag = $location.search()['solveFlag'];
    $scope.dataTableProperties= {
        //table的html id
        dataTableId:'cont_receipt_table',
        //table的列
        dataTableColumn: [
            {title:'合同编号',data:'contNo',width:'20%'},
            {title:'承租人',data:'name',width:'20%'},
            {title:'区域',data:'groupDistrict',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'期数',data:'period',width:'20%'},
            {title:'收款日期',data:'repayDate',width:'20%'},
            {title:'每期客户实际租金',data:'rentActual',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data){
                        data = "-";
                    }
                    return data;
                }
            },
            {
                title: '已收租金',
                data: 'alreadyReceiptAmount',
                width: '20%',
                render: function (data, type, row, meta) {
                    if (row.receiptBizType == 0) {
                        if (!data) {
                            data = 0;
                        }
                    } else {
                        data = "-";
                    }
                    return data;
                }
            },
            {title:'应收罚息',data:'overdueAmount',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data){
                        return "-";
                    }
                    return numAddSub(data,row.exemptAmount,2);;
                }
            },{
                title: '已收罚息',
                data: 'alreadyReceiptAmount',
                width:'20%',
                render: function (data, type, row, meta) {
                    if(row.receiptBizType == 1){
                        if(!data){
                            data = 0;
                        }
                    }else{
                        data = "-";
                    }
                    return data;
                }
            },{title:'备注',data:'memoChecked',width:'20%',
                render: function (data, type, row, meta) {
                    return creatMemoInput('memoChecked',meta,data);
                },
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    $compile(nTd)($scope);
                }
            }/*,{title:'开票日期',data:'invoiceDate',width:'20%',
                render: function (data, type, row, meta) {
                    return creatInvoiceDate('invoiceDate',meta,data);
                },
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    $compile(nTd)($scope);
                }
            }*/
        ],
        dataTableData: $scope.contReceiptPostVo.contRepaySkedVoList
    };

    $scope.callback = function () {
        var tableData = $scope.contReceiptPostVo.contRepaySkedVoList;
        var rentTotal=0,overdueTotal=0;
        for(var i=0;i<tableData.length;i++){
            rentTotal = tableData[i].rentActual*1 + rentTotal;
            overdueTotal = tableData[i].overdueAmount*1-tableData[i].exemptAmount*1 + overdueTotal;
        }
        var html = '<tr>' +
            '<th>合计</th>' +
            '<td colspan="5"></td>' +
            '<td>'+rentTotal.toFixed(2)+'</td>' +
            '<td></td>' +
            '<td>'+overdueTotal.toFixed(2)+'</td>' +
            '</tr>';
        $('#cont_receipt_table tbody').append(html);
    };

    $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
    $scope.callback();
    $compile($("#cont_receipt_table"))($scope);



    //增加银行信息
    $scope.add = function () {
        var obj = {receiptDate:new Date().Format("yyyy-MM-dd")};
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
        $scope.contReceiptPostVo.contReceiptVoList = $scope.contReceiptVoList;
        if($scope.contReceiptPostVo.contReceiptVoList.length <= 0){
            modalAlert($modal,"请选择收款银行后再提交！");
            return;
        }
        $scope.bankFlag = true;
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.contReceiptPostVo.contReceiptVoList.forEach(function (row,index) {
                if(isNullEmpty(row.recAccBranch)){
                    $scope.bankFlag = false;
                }
            });
            if(!$scope.bankFlag){
                modalAlert($modal,"请选择所有收款银行后再提交！");
                $scope.submit = false;
                return;
            }

            $http.post("cont_receipt/manualReceipt", $scope.contReceiptPostVo).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path('/app/finance_cont_receipt_list').search({type:'homeToastInfo', msg:'提交成功'});
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
    $scope.goBack = function(){
        $location.path("/app/finance_cont_receipt_list");
    };

    //银行选择
    $scope.selectBasBankInfo = function(index){
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
                $scope.contReceiptVoList[index].recAccBank = data.accBankName;
                $scope.contReceiptVoList[index].recAccountName = data.accountName;
                $scope.contReceiptVoList[index].recAccountNo = data.accountNo;
                $scope.contReceiptVoList[index].recEleBankNo = data.eleAccountNo;
                $scope.contReceiptVoList[index].recAccBranch = data.accBranchBank;
            }
        },function(){
        });
    }


    //计算实收总金额
   /* $scope.setInputVal = function() {
        var total = 0;
        for(var i=0;i<$scope.contReceiptVoList.length;i++){
            total = numAddSub(total,$scope.contReceiptVoList[i].receiptAmount,1)
        }
        $scope.contReceiptPostVo.totalActualAmount = total;
    };*/

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

    //创建备注
    function creatMemoInput(name,meta,data) {
        if(isUndefinedNull(data)){
            data = "";
        }
        var html = "";
        html += "<input limit-word='255' name=\""+name+""+meta.row+"\" type=\"text\" class=\"form-control\" ng-model=\""+name+""+meta.row+"\" ng-change=\"setMemoInputVal("+name+""+meta.row+","+meta.row+",'"+name+"');\" ng-init=\""+name+""+meta.row+"='"+data+"'\" " +
            "autocomplete=\"off\" />";
        return html;
    }
    $scope.setMemoInputVal = function(a,meta,name) {
        var nTr = $scope.dataTable.fnGetData();
        nTr[meta][name] = a;
    };

    //创建开票日期
    function creatInvoiceDate(name,meta,data) {
        if(isUndefinedNull(data)){
            data = "";
        }
        var html = "";
        html += "<input name=\""+name+""+meta.row+"\" type=\"text\" class=\"form-control\" ng-model=\""+name+""+meta.row+"\" ng-change=\"setInvoicedateVal("+name+""+meta.row+","+meta.row+",'"+name+"');\" ng-init=\""+name+""+meta.row+"='"+data+"'\" " +
            " onClick=\"WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer',onpicked:function(){$(this).trigger('change')}})\" autocomplete=\"off\" />";
        return html;
    }
    $scope.setInvoicedateVal = function(a,meta,name) {
        var nTr = $scope.dataTable.fnGetData();
        nTr[meta][name] = a;
    };

}]);


