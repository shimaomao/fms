/**
 * Created by lijunjun on 2018-06-02.
 */
app.controller('quotation_device_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location','setData', function ($scope, $http, $modal, toaster,$compile, $location,setData) {
    //查询参数
    $scope.params = setData.getter();
    //申请类型
    $scope.applyTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.quoApplyType);

    //录入区分
    $scope.quotationEntryDistinctionList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.quotationEntryDistinction);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'quotation_device/findQuotationDevicesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'quotation_device_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('quotationDeviceId'),
            // defaultDetail('name','detailQuotationDevice','客户姓名','20%',$compile,$scope),
            {title:'客户姓名',data:'name',width:'20%'},
            // {title:'申请类型',data:'applyType',width:'20%',
            //     render: function (data, type, row, meta) {
            //         return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.applyType,data);
            //     }
            // },
            // {title:'生成日期',data:'generationDate',width:'20%'},
            // {title:'报价类型',data:'quotationType',width:'20%',
            //     render: function (data, type, row, meta) {
            //         return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.quotationType,data);
            //     }
            // },
            {title:'报价时间',data:'quotationDate',width:'20%'},
            {title:'参考出租人',data:'lessor',width:'20%'},
            {title:'车型代码',data:'vehicleCode',width:'20%'},
            {title:'车型名称',data:'vehicleName',width:'20%'},
            {title:'参考车型',data:'models',width:'20%'},
            {title:'车辆标签价',data:'cehicleLabelPrice',width:'20%'},
            {title:'车辆成交价',data:'cehicleTransactionPrice',width:'20%'},
            {title:'车辆采购价',data:'cehiclePurchasingPrice',width:'20%'},
            {title:'购置税',data:'purchaseTax',width:'20%'},
            {title:'商业保险',data:'commercialInsurance',width:'20%'},
            {title:'上牌综合服务',data:'boardServiceCharge',width:'20%'},
            {title:'交强险车船税',data:'highRiskVehicleTax',width:'20%'},
            {title:'精品',data:'fineQuality',width:'20%'},
            {title:'申请金额',data:'applicationAmount',width:'20%'},
            {title:'手续费',data:'serviceCharge',width:'20%'},
            {title:'融资额',data:'financingAmount',width:'20%'},
            {title:'返还经销商手续费',data:'restitutionFee',width:'20%'},
            {title:'续保押金',data:'renewDeposit',width:'20%'},
            {title:'渠道佣金',data:'channelCommission',width:'20%'},
            {title:'现金奖励',data:'cashReward',width:'20%'},
            {title:'内部提成',data:'internalFormation',width:'20%'},
            {title:'贷款期限',data:'loanTerm',width:'20%'},
            //{title:'大客户补贴比例',data:'customerSubsidyRatio',width:'20%'},
            //{title:'大客户补贴金额',data:'customerSubsidyAmount',width:'20%'},
            {title:'首付款比例',data:'downPaymentRatio',width:'20%'},
            {title:'首付款',data:'firstPayment',width:'20%'},
            {title:'保证金比例',data:'marginLevel',width:'20%'},
            {title:'保证金',data:'bond',width:'20%'},
            {title:'尾款比例',data:'tailProportion',width:'20%'},
            {title:'尾款金额',data:'tailMoney',width:'20%'},
            {title:'年供比例',data:'annualSupplyRate',width:'20%'},
            {title:'年供金额',data:'annualSupplyAmount',width:'20%'},
            {title:'客户利率',data:'customerInterestRate',width:'20%'},
            {title:'月供',data:'monthlySupply',width:'20%'},
            {title:'贸易收入',data:'tradeIncome',width:'20%'},
            {title:'项目粗利',data:'projectCoarseProfit',width:'20%'},
            {title:'贷款利息',data:'loanInterest',width:'20%'},
            {title:'静态收益率',data:'staticRateOfReturn',width:'20%'},
            {title:'增值税节税',data:'vatTaxSaving',width:'20%'},
            {title:'所得税节税',data:'incomeTaxSaving',width:'20%'},
            {title:'需动用资金',data:'needToUseFunds',width:'20%'},
            {title:'IRR',data:'irr',width:'20%'},
            {title:'业务经理',data:'applyUserName',width:'10%'},
            {title:'订单提出机构',data:'applyGroupName',width:'10%'},
            {title:'申请类型',data:'applyType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.quoApplyType,data);
                }
            },
            {title:'录入区分',data:'quotationEntryDistinction',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.quotationEntryDistinction,data);
                }
            },
            {title:'备注',data:'remarks',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        // params = {};
        // params.name = $scope.name;
        // params.applyType = $scope.applyType;
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchQuotationDevice = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetQuotationDevice = function(){
        // $scope.name = "";
        // $scope.applyType = "";
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

    $scope.modifyQuotationDevice = function(quotationDeviceId){
        var rowsIds =  $scope.dataTable.getRowsIds('quotationDeviceId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path("app/prebiz_quotation_device_calculate").search({"quotationDeviceId":rowsIds[0],"detailFlag":true});
            // $location.path("app/prebiz_quotation_device_modify").search({"quotationDeviceId":rowsIds[0]});
        }

    }

    //导出数据表
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.prebiz,CommonServiceType.excelTypes.one,
            'quotation_device/findQuotationDevicesByPage',dataTableParams($scope));
    }

}])
;