/**
 * Created by ningyangyang on 2018-07-17.
 */
app.controller('fin_repay_sked_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {
    $scope.maxDate = {maxDate:'#F{$dp.$D(\'validEndDate\')}'};
    $scope.minDate = {minDate:'#F{$dp.$D(\'validStartDate\')}'};

    $scope.maxDateReceiptDate = {maxDateReceiptDate:'#F{$dp.$D(\'validEndDateReceiptDate\')}'};
    $scope.minDateReceiptDate = {minDateReceiptDate:'#F{$dp.$D(\'validStartDateReceiptDate\')}'};

    //还款状态
    $scope.paymentStsList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.paymentSts);
    //逾期状态
    $scope.overdueFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.overdueFlag);
    //是否先开票
    $scope.invoicePropFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.yesNoFlag);
    //开票状态
    $scope.invoiceStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.invoiceStatus);
    //查询参数
    $scope.params = setData.getter();
    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.msg = $location.search()['msg'];
        if ($scope.msg) {
            toaster_success($scope.msg, toaster);
        }
    }, 100);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'fin_repay_sked/findFinRepaySkedsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'fin_repay_sked_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('finRepaySkedId'),
            //defaultDetail('contNo','detailFinRepaySked','合同编号','20%',$compile,$scope,'finRepaySkedId'),
            {title:'归属公司',data:'groupDistrict',width:'20%',
            render:function (data) {
                if(!data){
                    return "";
                }else{
                    return data
                }
            }
            },
            {title:'客户名称',data:'name',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'业务类型',data:'licenseAttr',width:'20%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data)
                }
            },
            {title:'申请类型',data:'applyType',width:'20%',
                render:function(data,type,row,meta){
                    if(isUndefinedNull(row.companyType2) || !row.companyType2){
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.applyType,data)
                    }else{
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.companyType,data)
                    }
                }
            },
            {title:'分类',data:'companyType2',width:'20%',
                render:function(data,type,row,meta){
                    //alert(row.applyType);
                    if(row.applyType == CommonCodeUtils.companyType.company){
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.companyTypeComp,data)
                    }else if(row.applyType == CommonCodeUtils.companyType.sale){
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.companyTypeSale,data)
                    }else
                        return ""
                }
            },
            {title:'期数',data:'period',width:'20%'},
            {title:'应还款日',data:'repayDate',width:'20%'},
            {title:'应收租金',data:'rentActual',width:'20%'},
            {title:'实际还款日',data:'receiptDate',width:'20%'},
            {title:'实收租金',data:'receiptAmount',width:'20%'},//没找到字段
            {title:'当期本金',data:'principal',width:'20%'},
            {title:'当期利息',data:'interest',width:'20%'},
            {title:'逾期状态',data:'overdueStatus',width:'20%',    //没找到字段
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.overdueFlag,data)
                }
            },
            {title:'罚息额',data:'overdueAmount',width:'20%'},
            {title:'罚息免除金额',data:'exemptAmount',width:'20%'},
            {title:'罚息已收金额',data:'overdueReceiptAmount',width:'20%'},
            {title:'财务本金',data:'finRprincipal',width:'20%'},
            {title:'财务利息',data:'finRinterest',width:'20%'},
            {title:'是否先开票',data:'invoiceProp',width:'20%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.yesNoFlag,data)
                }
            },
            {title:'发票开票时间',data:'invoiceDate',width:'20%'},
            {title:'开票金额',data:'invoiceAmount',width:'20%'},
            {title:'开票状态',data:'invoiceStatus',width:'20%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceStatus,data)
                }
            },
            {title:'备注',data:'memo',width:'20%'},
            {title:'开票备注',data:'invoiceMemo',width:'20%'},
            {title:'扣款状态',data:'repayStatus',width:'20%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.repayStatus,data)
                }
            },
            {title:'还款状态',data:'paymentSts',width:'20%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.paymentSts,data)
                }
            },
            {title:'收款户名',data:'recAccountName',width:'20%'},
            {title:'收款银行',data:'recAccBank',width:'20%'},
            {title:'收款账号',data:'recAccountNo',width:'20%'},
            {title:'合同编号',data:'contNo',width:'20%'},
            {title:'成交日期',data:'dealDate',width:'20%'},




            // {title:'收款日期',data:'repayDate',width:'20%'},
            // {title:'月利率',data:'intrstMonthRate',width:'20%'},
            // {title:'每期客户租金',data:'rent',width:'20%'},
            // {title:'当期本金',data:'principal',width:'20%'},
            // {title:'当期利息',data:'interest',width:'20%'},
            // {title:'当期剩余本金',data:'restPrincipal',width:'20%'},
            // {title:'主营收入',data:'revenue',width:'20%'},
            // {title:'税金',data:'tax',width:'20%'},
            // {title:'扣款状态',data:'repayStatus',width:'20%',
            //     render:function (data) {
            //         return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.repayStatus,data)
            //     }
            // },
            // // {title:'扣款结算状态',data:'repaySetStatus',width:'20%',
            // //
            // // },
            // {title:'收款银行',data:'recAccBank',width:'20%'},
            // {title:'收款账号',data:'recAccountNo',width:'20%'},
            // {title:'收款户名',data:'recAccountName',width:'20%'},
            // {title:'到账日期',data:'receiptDate',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    $scope.callback = function (data) {
        var tableData = data.data;
        var rentSum = 0,
            principalSum = 0,
            interestSum = 0,
            restPrincipalSum = 0,
            revenueSum = 0,
            taxSum = 0,
            receiptAmountSum = 0,
            overdueAmountSum = 0,
            exemptAmountSum=0,
            overdueReceiptAmountSum=0,
            finRprincipalSum = 0,
            finRinterestSum = 0,
            invoiceAmountSum = 0;
        for (var i = 0; i < tableData.length; i++) {
            rentSum = tableData[i].rentActual * 1 + rentSum;
            principalSum = tableData[i].principal * 1 + principalSum;
            interestSum = tableData[i].interest * 1 + interestSum;
            restPrincipalSum = tableData[i].restPrincipal * 1 + restPrincipalSum;
            revenueSum = tableData[i].revenue * 1 + revenueSum;
            taxSum = tableData[i].tax * 1 + taxSum;
            receiptAmountSum = tableData[i].receiptAmount * 1 + receiptAmountSum;
            overdueAmountSum = tableData[i].overdueAmount * 1 + overdueAmountSum;
            exemptAmountSum = tableData[i].exemptAmount*1 + exemptAmountSum;
            overdueReceiptAmountSum = tableData[i].overdueReceiptAmount*1 + overdueReceiptAmountSum;
            finRprincipalSum = tableData[i].finRprincipal * 1 + finRprincipalSum;  //财务本金
            finRinterestSum = tableData[i].finRinterest * 1 + finRinterestSum; // 财务利息
            invoiceAmountSum = tableData[i].invoiceAmount * 1 + invoiceAmountSum;
        }
        var html = '<tr id="sked_table_header">' +
            '<th>合计</th>' +
            '<td colspan="8"></td>' +
            '<td>' + rentSum.toFixed(2) + '</td>' +
            '<td colspan="1"></td>' +
            '<td>' + receiptAmountSum.toFixed(2) + '</td>' +
            '<td>' + principalSum.toFixed(2) + '</td>' +
            '<td>' + interestSum.toFixed(2) + '</td>' +
            '<td></td>' +
            '<td>' + overdueAmountSum.toFixed(2) + '</td>' +
            '<td>'+exemptAmountSum.toFixed(2)+'</td>' +
            '<td>'+overdueReceiptAmountSum.toFixed(2)+'</td>' +
            '<td>' + finRprincipalSum.toFixed(2) + '</td>' +
            '<td>' + finRinterestSum.toFixed(2) + '</td>' +
            '<td colspan="2"></td>' +
            '<td>' + invoiceAmountSum.toFixed(2) + '</td>' +
            // '<td>' + restPrincipalSum.toFixed(2) + '</td>' +
            // '<td>' + revenueSum.toFixed(2) + '</td>' +
            // '<td>' + taxSum.toFixed(2) + '</td>' +
            '<td colspan="7"></td>' +
            '</tr>';

        //获取tab
        var  aa = document.getElementById('fin_repay_sked_table');
        //获取tab中ID=myHeader的tr
        if (document.getElementById('sked_table_header')) {
            //有就去更新tr标签
            var  bb = document.getElementById('sked_table_header');
            bb.innerHTML =  html;
        }else {
            //无则添加标签进去
            $('#fin_repay_sked_table tbody').append(html);
        }
        //
        // function buildTotalData() {
        //     var tableData = data.all;
        //     var rentSum = 0,
        //         principalSum = 0,
        //         interestSum = 0,
        //         restPrincipalSum = 0,
        //         revenueSum = 0,
        //         taxSum = 0,
        //         receiptAmountSum = 0,
        //         overdueAmountSum = 0,
        //         exemptAmountSum=0,
        //         overdueReceiptAmountSum=0,
        //         finRprincipalSum = 0,
        //         finRinterestSum = 0,
        //         invoiceAmountSum = 0;
        //     for (var i = 0; i < tableData.length; i++) {
        //         rentSum = tableData[i].rentActual * 1 + rentSum;
        //         principalSum = tableData[i].principal * 1 + principalSum;
        //         interestSum = tableData[i].interest * 1 + interestSum;
        //         restPrincipalSum = tableData[i].restPrincipal * 1 + restPrincipalSum;
        //         revenueSum = tableData[i].revenue * 1 + revenueSum;
        //         taxSum = tableData[i].tax * 1 + taxSum;
        //         receiptAmountSum = tableData[i].receiptAmount * 1 + receiptAmountSum;
        //         overdueAmountSum = tableData[i].overdueAmount * 1 + overdueAmountSum;
        //         exemptAmountSum = tableData[i].exemptAmount*1 + exemptAmountSum;
        //         overdueReceiptAmountSum = tableData[i].overdueReceiptAmount*1 + overdueReceiptAmountSum;
        //         finRprincipalSum = tableData[i].finRprincipal * 1 + finRprincipalSum;  //财务本金
        //         finRinterestSum = tableData[i].finRinterest * 1 + finRinterestSum; // 财务利息
        //         invoiceAmountSum = tableData[i].invoiceAmount * 1 + invoiceAmountSum;
        //     }
        //     var html = '<tr>' +
        //         '<th id="sked_table_totalHeader">总计</th>' +
        //         '<td colspan="8"></td>' +
        //         '<td>' + rentSum.toFixed(2) + '</td>' +
        //         '<td colspan="1"></td>' +
        //         '<td>' + receiptAmountSum.toFixed(2) + '</td>' +
        //         '<td>' + principalSum.toFixed(2) + '</td>' +
        //         '<td>' + interestSum.toFixed(2) + '</td>' +
        //         '<td></td>' +
        //         '<td>' + overdueAmountSum.toFixed(2) + '</td>' +
        //         '<td>'+exemptAmountSum.toFixed(2)+'</td>' +
        //         '<td>'+overdueReceiptAmountSum.toFixed(2)+'</td>' +
        //         '<td>' + finRprincipalSum.toFixed(2) + '</td>' +
        //         '<td>' + finRinterestSum.toFixed(2) + '</td>' +
        //         '<td colspan="2"></td>' +
        //         '<td>' + invoiceAmountSum.toFixed(2) + '</td>' +
        //         '<td colspan="7"></td>' +
        //         '</tr>';
        //     //获取tab
        //     var  aa = document.getElementById('fin_repay_sked_table');
        //     //获取tab中ID=myHeader的tr
        //     if (document.getElementById('sked_table_totalHeader')) {
        //         //有就去更新tr标签
        //         var  bb = document.getElementById('sked_table_totalHeader');
        //         bb.innerHTML =  html;
        //     }else {
        //         //无则添加标签进去
        //         $('#fin_repay_sked_table tbody').append(html);
        //     }
        // }
        //
        // buildTotalData();
    }

    //请求的参数
    function dataTableParams($scope){
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    //扣款状态
    $scope.repayStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.repayStatus);
    //业务类型
    $scope.licenseAttrList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr);

    $scope.searchFinRepaySked = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetFinRepaySked = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

   //跳转到开票页面
    $scope.invoice = function(){
      var rows = $scope.dataTable.getRows();
      if(rows.length < 1){
          modalAlert($modal,'请您选择需要开票的数据');
      }
      else {
          for(var i in rows){
              var row = rows[i];
              if(CommonStringUtils.isNotTrimBlank(row['invoiceStatus']) && row['invoiceStatus'] != CommonCodeUtils.invoiceStatus.noInvoice){
                  modalAlert($modal,'合同号: ' + row['contNo'] + ',已经开票,不能重复开票');
                  return;
              }
          }
      }
      $location.path('app/finance_fin_repay_sked_invoice').search({'finRepaySkeds':JSON.stringify(rows)});
    }


    //批量修改开票属性
    $scope.editInvoiceProp = function(){
        var rows = $scope.dataTable.getRows();
        if(rows.length < 1){
            modalAlert($modal,'请您选择需要修改的数据');
        }else{
            $location.path('app/finance_edit_invoice_prop').search({'finRepaySkeds':JSON.stringify(rows)});
        }
    }

    //导出excel
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.finance,CommonServiceType.excelTypes.five,
            'fin_repay_sked/findFinRepaySkedsByPage',dataTableParams($scope));
    }

}])
;