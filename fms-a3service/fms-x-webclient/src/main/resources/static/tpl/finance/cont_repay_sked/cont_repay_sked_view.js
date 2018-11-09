/**
 * Created by ningyangyang on 2018-07-16.
 */
app.controller('cont_repay_sked_view_controller', ['$scope', '$http', '$modal', 'toaster','$compile','setData', function ($scope, $http, $modal, toaster,$compile,setData) {
    $scope.maxDate = {maxDate:'#F{$dp.$D(\'validEndDate\')}'};
    $scope.minDate = {minDate:'#F{$dp.$D(\'validStartDate\')}'};

    $scope.censuDate = {censuDate:'#F{$dp.$D(\'censuMonth\')}',dateFmt:'yyyy-MM'};

    $scope.maxDateReceiptDate = {maxDateReceiptDate:'#F{$dp.$D(\'validEndDateReceiptDate\')}'};
    $scope.minDateReceiptDate = {minDateReceiptDate:'#F{$dp.$D(\'validStartDateReceiptDate\')}'};

    //还款状态
    $scope.paymentStsList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.paymentSts);
    //逾期状态
    $scope.overdueFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.overdueFlag);

    //查询参数
    $scope.params = setData.getter();
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cont_repay_sked/findContRepaySkedDetailByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'cont_repay_sked_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('repaySkedId'),
            //defaultDetail('contNo','detailContRepaySked','合同编号','20%',$compile,$scope,'repaySkedId'),
            {title:'归属公司',data:'groupDistrict',width:'20%'},
            {title:'客户名称',data:'name',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'业务类型',data:'licenseAttr',width:'20%',
            render:function (data) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data)
            }
            },
            {title:'申请类型',data:'applyType',width:'20%',
            render:function(data,type,row,meta){
                if(isUndefinedNull(row.companyType2)|| !row.companyType2){
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
            {title:'实际还款日',data:'receiptDate',width:'20%'},
            {title:'实收租金',data:'receiptAmount',width:'20%'},
            {title:'当期本金',data:'principal',width:'20%'},
            {title:'剩余本金',data:'restPrincipal',width:'20%'},
            {title:'当期利息',data:'interest',width:'20%'},
            {title:'逾期状态',data:'overdueStatus',width:'20%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.overdueFlag,data)
                }
            },
            {title:'罚息额',data:'overdueAmount',width:'20%'},
            {title:'罚息免除金额',data:'exemptAmount',width:'20%'},
            {title:'罚息已收金额',data:'overdueReceiptAmount',width:'20%'},
            {title:'发票开票时间',data:'invoiceDate',width:'20%'},
            {title:'备注',data:'memo',width:'20%'},
            {title:'开票备注',data:'invoiceMemo',width:'20%'},
            {title:'收款户名',data:'recAccountName',width:'20%'},
            {title:'收款银行',data:'recAccBank',width:'20%'},
            {title:'收款账号',data:'recAccountNo',width:'20%'},
            {title:'合同编号',data:'contNo',width:'20%'},
            {title:'成交日期',data:'dealDate',width:'20%'},
            // {title:'手续费用',data:'charge',width:'20%'},


            //
            //
            // {title:'暂不扣款标志',data:'repayFlag',width:'20%'},
            //
            // {title:'保证金',data:'deposit',width:'20%'},
            //
            // {title:'财务租金',data:'finRent',width:'20%'},
            // {title:'财务本金',data:'finRprincipal',width:'20%'},
            // {title:'财务利息',data:'finRinterest',width:'20%'},
            // {title:'财务剩余本金',data:'finRestPrincipal',width:'20%'},
            // {title:'财务主营收入',data:'finRevenue',width:'20%'},
            // {title:'财务税金',data:'finRtax',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    $scope.callback = function (data) {
        var tableData = data.data;
        var rentActualSum=0,
            principalSum=0,
            interestSum=0,
            restPrincipalSum=0,
            overdueAmountSum=0,
            /*finRentSum=0,
            finRprincipalSum=0,
            finRinterestSum=0,
            finRestPrincipalSum=0,
            finRevenueSum=0,
            finRtaxSum=0,*/
            exemptAmountSum=0,
            overdueReceiptAmountSum=0,
            receiptAmountSum=0;
        for(var i=0;i<tableData.length;i++){
            rentActualSum = tableData[i].rentActual*1 + rentActualSum;//应收租金
            principalSum = tableData[i].principal*1 + principalSum;//当期本金
            interestSum = tableData[i].interest*1 + interestSum;//当期利息
            restPrincipalSum = tableData[i].restPrincipal*1 + restPrincipalSum;//剩余本金
            overdueAmountSum = tableData[i].overdueAmount*1 + overdueAmountSum;//罚息额
            exemptAmountSum = tableData[i].exemptAmount*1 + exemptAmountSum;//罚息免除金额
            overdueReceiptAmountSum = tableData[i].overdueReceiptAmount*1 + overdueReceiptAmountSum;//罚息已收金额
            /*finRentSum = tableData[i].finRent*1 + finRentSum;
            finRprincipalSum = tableData[i].finRprincipal*1 + finRprincipalSum;
            finRinterestSum = tableData[i].finRinterest*1 + finRinterestSum;
            finRestPrincipalSum = tableData[i].finRestPrincipal*1 + finRestPrincipalSum;
            finRevenueSum = tableData[i].finRevenue*1 + finRevenueSum;
            finRtaxSum = tableData[i].finRtax*1 + finRtaxSum;*/
            receiptAmountSum = tableData[i].receiptAmount*1 + receiptAmountSum;//实收租金
        }
        var html = '<tr>' +
            '<th>合计</th>' +
            '<td colspan="8"></td>' +
            '<td>'+rentActualSum.toFixed(2)+'</td>' +
            '<td colspan="3"></td>' +
            '<td>'+receiptAmountSum+'</td>' +
            '<td>'+principalSum.toFixed(2)+'</td>' +
            '<td>'+restPrincipalSum.toFixed(2)+'</td>' +
            '<td>'+interestSum.toFixed(2)+'</td>' +
            '<td></td>' +
            '<td>'+overdueAmountSum.toFixed(2)+'</td>' +
            '<td>'+exemptAmountSum.toFixed(2)+'</td>' +
            '<td>'+overdueReceiptAmountSum.toFixed(2)+'</td>' +
            '<td colspan="8"></td>' +
            '</tr>';
        $('#cont_repay_sked_table tbody').append(html);

        // function buildTotalData() {
        //     var tableData = data.all;
        //     var rentActualSum=0,
        //         principalSum=0,
        //         interestSum=0,
        //         restPrincipalSum=0,
        //         overdueAmountSum=0,
        //         exemptAmountSum=0,
        //         overdueReceiptAmountSum=0,
        //         receiptAmountSum=0;
        //     for(var i=0;i<tableData.length;i++){
        //         rentActualSum = tableData[i].rentActual*1 + rentActualSum;
        //         principalSum = tableData[i].principal*1 + principalSum;
        //         interestSum = tableData[i].interest*1 + interestSum;
        //         restPrincipalSum = tableData[i].restPrincipal*1 + restPrincipalSum;
        //         overdueAmountSum = tableData[i].overdueAmount*1 + overdueAmountSum;
        //         exemptAmountSum = tableData[i].exemptAmount*1 + exemptAmountSum;
        //         overdueReceiptAmountSum = tableData[i].overdueReceiptAmount*1 + overdueReceiptAmountSum;
        //         receiptAmountSum = tableData[i].receiptAmount*1 + receiptAmountSum;
        //     }
        //     var html = '<tr>' +
        //         '<th>总计</th>' +
        //         '<td colspan="8"></td>' +
        //         '<td>'+rentActualSum.toFixed(2)+'</td>' +
        //         '<td colspan="3"></td>' +
        //         '<td>'+receiptAmountSum+'</td>' +
        //         '<td>'+principalSum.toFixed(2)+'</td>' +
        //         '<td>'+restPrincipalSum.toFixed(2)+'</td>' +
        //         '<td>'+interestSum.toFixed(2)+'</td>' +
        //         '<td></td>' +
        //         '<td>'+overdueAmountSum.toFixed(2)+'</td>' +
        //         '<td>'+exemptAmountSum.toFixed(2)+'</td>' +
        //         '<td>'+overdueReceiptAmountSum.toFixed(2)+'</td>' +
        //         '<td colspan="8"></td>' +
        //         '</tr>';
        //     $('#cont_repay_sked_table tbody').append(html);
        // }
        //
        // buildTotalData();
    };

    //请求的参数
    function dataTableParams($scope){
        var params = $scope.params;
        setData.setter(params);
        return params;
    }
    //扣款状态
    $scope.repayStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.repayStatus);
    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
   //业务类型
    $scope.licenseAttrList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr)

    $scope.searchContRepaySked = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetContRepaySked = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

    $scope.detailContRepaySked = function(repaySkedId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/finance/cont_repay_sked/cont_repay_sked_detail.html'+getCacheTime(),
            controller: 'cont_repay_sked_detail_controller',
            resolve:{
                contRepaySked : function (){ return $scope.dataTable.getRow(repaySkedId,'repaySkedId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    //导出数据表
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.finance,CommonServiceType.excelTypes.four,
            'cont_repay_sked/findContRepaySkedDetailExport',dataTableParams($scope));
    }
    //导出未结清车辆租金明细表
    $scope.settleExcel = function(){
        $scope.params.exportFlag = "1";
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.finance,CommonServiceType.excelTypes.seven,
            'cont_repay_sked/findContRepaySkedSettleExport',dataTableParams($scope));
    }
    //导出结清车辆租金明细表
    $scope.settleEndExcel = function(){
        $scope.params.exportFlag = "2";
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.finance,CommonServiceType.excelTypes.sex,
            'cont_repay_sked/findContRepaySkedSettleEndExport',dataTableParams($scope));
    }
    //未收租金明细表
    $scope.unpaidRent = function(){
        $scope.params.exportFlag = "3";
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.finance,CommonServiceType.excelTypes.eight,
            'cont_repay_sked/findContRepaySkedUnpaidRentExport',dataTableParams($scope));
    }
    //实收租金明细表
    $scope.paidRent = function(){
        $scope.params.exportFlag = "4";
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.finance,CommonServiceType.excelTypes.nine,
            'cont_repay_sked/findContRepaySkedPaidRentExport',dataTableParams($scope));
    }



}])
;

app.directive('buttonClick', ['$parse',function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attr) {
            var $this;
            $(element).click(function (e) {
                $this = $(this).next();
                $this.css({'display':'block'});
                e.stopPropagation();
                $(document).click(function () {
                    $this.css({'display':'none'});
                });
            });
        }
    };
}]);