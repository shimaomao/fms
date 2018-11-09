/**
 * Created by yangyiquan on 2018-04-28.
 */
app.controller('contract_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$localStorage','setData',function ($scope, $http, $modal, toaster,$compile,$location,$localStorage,setData) {
    $scope.maxDate = {maxDate:'#F{$dp.$D(\'validEndDate\')}'};
    $scope.minDate = {minDate:'#F{$dp.$D(\'validStartDate\')}'};

    $scope.maxDateLeaseTermEnd = {maxDateLeaseTermEnd:'#F{$dp.$D(\'validEndDateLeaseTermEnd\')}'};
    $scope.minDateLeaseTermEnd = {minDateLeaseTermEnd:'#F{$dp.$D(\'validStartDateLeaseTermEnd\')}'};

    //查询参数
    $scope.params = setData.getter();
    //订单状态
    $scope.bizStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.bizStatus);
    //申请类型
    $scope.companyTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.companyType);
    //业务类型
    $scope.licenseAttrList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr);
    //还款状态
    $scope.paymentStsList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.paymentSts);
    //款项状态
    $scope.fundStatusObjList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.fundStatus);
    //导出权限
    $scope.exportFlag = true;
    //主页传递的款项状态初始化
    if(CommonObjectUtils.isExist($location.search()['fundStatus'])){
        $scope.params.fundStatus = $location.search()['fundStatus']; //款项状态
    }
    //主页传递的合同生效日期开始日
    if(CommonObjectUtils.isExist($location.search()['validStartTime'])){
        $scope.params.validStartTime = $location.search()['validStartTime']; //合同生效开始日
    }
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'contract/findContractListByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'contract_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contractId'),
            defaultDetail('contNo','detailContract','合同编号','10%',$compile,$scope,'contractId'),
            {title:'申请编号',data:'applyNo',width:'10%'},
            {title:'出租人',data:'groupName',width:'10%'},
            {title:'承租人',data:'name',width:'10%'},
            {title:'车架号',data:'vinNo',width:'10%'},
            {title:'车牌号',data:'vehicleLicenseNo',width:'10%'},
            /*{title:'申请类型',data:'applyType',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.applyType,data);
                }
            },*/
            {title:'业务类型',data:'licenseAttr',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data);
                }
            },
            {title:'车辆类型',data:'vehicleForm',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleForm,data);
                }
            },
            {title:'当前节点用户',data:'presentUser',width:'10%'},
            {title:'当前节点用户名',data:'presentUserName',width:'10%'},
            {title:'合同申请状态',data:'bizStatus',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data);
                }
            },
            {title:'合同生效日期',data:'contractValidDate',width:'10%'},
            {title:'合同生成日期',data:'contractDate',width:'10%'},
            {title:'车辆品牌',data:'vehBrandCodeName',width:'10%'},
            {title:'车型',data:'vehicleCodeName',width:'10%'},
            {title:'产品名称',data:'productName',width:'10%'},
            {title:'融资期限',data:'finPeriodType',width:'10%'},
            {title:'申请金额',data:'investTotal',width:'10%'},
            // {title:'首付比例',data:'initPerc',width:'10%'},
            {title:'首付金额',data:'initAmount',width:'10%'},
            {title:'融资金额',data:'finTotal',width:'10%'},
            {title:'贷款利息',data:'loanInterest',width:'10%'},
            {title:'保证金',data:'deposit',width:'10%'},
            {title:'租金',data:'rent',width:'10%'},
            {title:'尾付金额',data:'finalAmount',width:'10%'},
            {title:'年供金额',data:'annualSupplyAmount',width:'10%'},
            {title:'标签价',data:'guidePrice',width:'10%'},
            {title:'车款',data:'carpriceFee',width:'20%'},
            {title:'购置税',data:'purchasetaxFee',width:'20%'},
            {title:'保险',data:'insuranceFee',width:'20%'},
            {title:'精品/家装',data:'extraFee',width:'20%'},
            {title:'GPS',data:'gpsFee',width:'20%'},
            {title:'上牌',data:'licenseFee',width:'20%'},
            {title:'延保',data:'extendFee',width:'20%'},
            {title:'其他费用',data:'otherFee',width:'20%'},
            {title:'还款状态',data:'paymentSts',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.paymentSts,data);
                }
            },
            {title:'IRR',data:'irr',width:'10%'},
            {title:'产品大类',data:'productCatgName',width:'10%'},
            {title:'实际销售方',data:'salesName',width:'10%'},
            {title:'申请类型',data:'companyType1',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.companyType,data);
                }
            },
            {title:'类别',data:'companyType2',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.companyType2,data);
                }
            },
           /* {title:'申请类型',data:'companyType1',width:'10%'},
            {title:'类别',data:'companyType2',width:'10%'},*/
            {title:'车辆分类',data:'vehicleType2',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleType2,data);
                }
            },
            {title:'客户证件号码',data:'certifNo',width:'10%'},
            // {title:'订单提出人',data:'applyUser',width:'10%'},
            // {title:'业务经理',data:'applyUser',width:'10%'},
            {title:'业务经理',data:'applyUserName',width:'10%'},
            {title:'首次提交日期',data:'applyFirsbtDate',width:'10%'},
            {title:'提交日期',data:'applySubmitDate',width:'10%'},
            {title:'制造商',data:'vehMakerCodeName',width:'10%'},
            {title:'车系',data:'vehSeriesCodeName',width:'10%'},
            {title:'还款日',data:'repayDay',width:'10%'},
            {title:'租赁期限开始日',data:'leaseTermStartDate',width:'10%'},
            {title:'租赁期限结束日',data:'leaseTermEndDate',width:'10%'},
            {title:'GPS-SIM卡号',data:'gpsNo',width:'10%'}
            // {title:'手续费收取方式',data:'chargePayMode',width:'10%',
            //     render: function (data, type, row, meta) {
            //         return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.chargePayMode,data);
            //     }
            // },
            // {title:'手续费比例',data:'chargeRate',width:'10%'},
            // {title:'手续费',data:'charge',width:'10%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    $scope.callback = function (data) {
        //var data = $scope.dataTable;
        var tableData = data.data;
        var /*chargeSum=0,*/initAmountSum=0,investTotalSum=0,finTotalSum=0,rentSum=0,depositSum=0,finalAmountSum=0,annualSupplyAmountSum=0,loanInterestSum=0,guidePriceSum=0,
            carpriceFeeSum=0,purchasetaxFeeSum=0,insuranceFeeSum=0,extraFeeSum=0,gpsFeeSum=0,licenseFeeSum=0,extendFeeSum=0,otherFeeSum=0;
        for(var i=0;i<tableData.length;i++){
            // chargeSum = tableData[i].charge*1 + chargeSum;
            initAmountSum = tableData[i].initAmount*1 + initAmountSum;
            investTotalSum = tableData[i].investTotal*1 + investTotalSum;
            finTotalSum = tableData[i].finTotal*1 + finTotalSum;
            loanInterestSum = tableData[i].loanInterest*1 + loanInterestSum;
            rentSum = tableData[i].rent*1 + rentSum;
            depositSum = tableData[i].deposit*1 + depositSum;
            finalAmountSum = tableData[i].finalAmount*1 + finalAmountSum;
            annualSupplyAmountSum = tableData[i].annualSupplyAmount*1 + annualSupplyAmountSum;
            guidePriceSum = tableData[i].guidePrice*1 + guidePriceSum;
            carpriceFeeSum = tableData[i].carpriceFee*1 + carpriceFeeSum;
            purchasetaxFeeSum = tableData[i].purchasetaxFee*1 + purchasetaxFeeSum;
            insuranceFeeSum = tableData[i].insuranceFee*1 + insuranceFeeSum;
            extraFeeSum = tableData[i].extraFee*1 + extraFeeSum;
            gpsFeeSum = tableData[i].gpsFee*1 + gpsFeeSum;
            licenseFeeSum = tableData[i].licenseFee*1 + licenseFeeSum;
            extendFeeSum = tableData[i].extendFee*1 + extendFeeSum;
            otherFeeSum = tableData[i].otherFee*1 + otherFeeSum;
        }
        var html = '<tr>' +
            '<th>合计</th>' +
            '<td colspan="17"></td>' +
            // '<td>'+chargeSum.toFixed(2)+'</td>' +
            '<td>'+investTotalSum.toFixed(2)+'</td>' +
            '<td>'+initAmountSum.toFixed(2)+'</td>' +
            '<td>'+finTotalSum.toFixed(2)+'</td>' +
            '<td>'+loanInterestSum.toFixed(2)+'</td>' +
            '<td>'+depositSum.toFixed(2)+'</td>' +
            '<td>'+rentSum.toFixed(2)+'</td>' +
            '<td>'+finalAmountSum.toFixed(2)+'</td>' +
            '<td>'+annualSupplyAmountSum.toFixed(2)+'</td>' +
            '<td>'+guidePriceSum.toFixed(2)+'</td>' +
            '<td>'+carpriceFeeSum.toFixed(2)+'</td>' +
            '<td>'+purchasetaxFeeSum.toFixed(2)+'</td>' +
            '<td>'+insuranceFeeSum.toFixed(2)+'</td>' +
            '<td>'+extraFeeSum.toFixed(2)+'</td>' +
            '<td>'+gpsFeeSum.toFixed(2)+'</td>' +
            '<td>'+licenseFeeSum.toFixed(2)+'</td>' +
            '<td>'+extendFeeSum.toFixed(2)+'</td>' +
            '<td>'+otherFeeSum.toFixed(2)+'</td>' +
            '</tr>';
        $('#contract_table tbody').append(html);

        // function buildTotalData() {
        //     var tableData = data.all;
        //     var /*chargeSum=0,*/initAmountSum = 0, investTotalSum = 0, finTotalSum = 0, rentSum = 0, depositSum = 0, finalAmountSum = 0, annualSupplyAmountSum = 0, loanInterestSum = 0, guidePriceSum = 0,
        //         carpriceFeeSum = 0, purchasetaxFeeSum = 0, insuranceFeeSum = 0, extraFeeSum = 0, gpsFeeSum = 0, licenseFeeSum = 0, extendFeeSum = 0, otherFeeSum = 0;
        //     for (var i = 0; i < tableData.length; i++) {
        //         // chargeSum = tableData[i].charge*1 + chargeSum;
        //         initAmountSum = tableData[i].initAmount * 1 + initAmountSum;
        //         investTotalSum = tableData[i].investTotal * 1 + investTotalSum;
        //         finTotalSum = tableData[i].finTotal * 1 + finTotalSum;
        //         loanInterestSum = tableData[i].loanInterest * 1 + loanInterestSum;
        //         rentSum = tableData[i].rent * 1 + rentSum;
        //         depositSum = tableData[i].deposit * 1 + depositSum;
        //         finalAmountSum = tableData[i].finalAmount * 1 + finalAmountSum;
        //         annualSupplyAmountSum = tableData[i].annualSupplyAmount * 1 + annualSupplyAmountSum;
        //         guidePriceSum = tableData[i].guidePrice * 1 + guidePriceSum;
        //         carpriceFeeSum = tableData[i].carpriceFee * 1 + carpriceFeeSum;
        //         purchasetaxFeeSum = tableData[i].purchasetaxFee * 1 + purchasetaxFeeSum;
        //         insuranceFeeSum = tableData[i].insuranceFee * 1 + insuranceFeeSum;
        //         extraFeeSum = tableData[i].extraFee * 1 + extraFeeSum;
        //         gpsFeeSum = tableData[i].gpsFee * 1 + gpsFeeSum;
        //         licenseFeeSum = tableData[i].licenseFee * 1 + licenseFeeSum;
        //         extendFeeSum = tableData[i].extendFee * 1 + extendFeeSum;
        //         otherFeeSum = tableData[i].otherFee * 1 + otherFeeSum;
        //     }
        //     var html = '<tr>' +
        //         '<th>总计</th>' +
        //         '<td colspan="17"></td>' +
        //         // '<td>'+chargeSum.toFixed(2)+'</td>' +
        //         '<td>' + investTotalSum.toFixed(2) + '</td>' +
        //         '<td>' + initAmountSum.toFixed(2) + '</td>' +
        //         '<td>' + finTotalSum.toFixed(2) + '</td>' +
        //         '<td>' + loanInterestSum.toFixed(2) + '</td>' +
        //         '<td>' + depositSum.toFixed(2) + '</td>' +
        //         '<td>' + rentSum.toFixed(2) + '</td>' +
        //         '<td>' + finalAmountSum.toFixed(2) + '</td>' +
        //         '<td>' + annualSupplyAmountSum.toFixed(2) + '</td>' +
        //         '<td>' + guidePriceSum.toFixed(2) + '</td>' +
        //         '<td>' + carpriceFeeSum.toFixed(2) + '</td>' +
        //         '<td>' + purchasetaxFeeSum.toFixed(2) + '</td>' +
        //         '<td>' + insuranceFeeSum.toFixed(2) + '</td>' +
        //         '<td>' + extraFeeSum.toFixed(2) + '</td>' +
        //         '<td>' + gpsFeeSum.toFixed(2) + '</td>' +
        //         '<td>' + licenseFeeSum.toFixed(2) + '</td>' +
        //         '<td>' + extendFeeSum.toFixed(2) + '</td>' +
        //         '<td>' + otherFeeSum.toFixed(2) + '</td>' +
        //         '</tr>';
        //     $('#contract_table tbody').append(html);
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

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);





    $scope.searchContractList = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetContractList = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

    //合同详情查看
    $scope.detailContract = function(contractId){
        var contract =  $scope.dataTable.getRow(contractId,'contractId')
        $location.path("app/prebiz_apply_input_detail").search({'applyNo':contract.applyNo,'contNo':contract.contNo,'applyType':contract.applyType,'type':'contract'
            ,'contractDate':contract.contractDate,'bizStatus':contract.bizStatus,'contractValidDate':contract.contractValidDate,'contractRequestDate':contract.contractRequestDate});
    }

    //试算
    $scope.preCount = function(){
        var rows = $scope.dataTable.getRows();
        if(rows && rows.length == 1) {
            var contract =  rows[0];
            if(contract.bizStatus != CommonCodeUtils.codeValues.contractValid) {
                modalAlert($modal,'只能试算已生效的合同！');
                return;
            }
            if(contract.paymentSts != CommonCodeUtils.codeValues.uncleared) {
                modalAlert($modal,'已结清合同无法试算！');
                return;
            }
            var repayDay = contract.repayDay*1;
            var nowDay = new Date().getDate();
            if(nowDay && nowDay*1 == repayDay){
                modalAlert($modal,'还款日当天不能试算提前还款！');
                return;
            }

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/cost/cont_prepayment/cont_prepayment_try_count.html?datetime='+getTimestamp(),
                controller: 'cont_prepayment_try_count_controller',
                resolve:{
                    contData: function () {
                        return contract.contNo;
                    }
                }
            });
            rtn.result.then(function (data) {

            },function(){
            });

        }else{
            modalAlert($modal,'请您选择一条需要试算的数据！');
        }
    };


    //导出数据表
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.prebiz,CommonServiceType.excelTypes.one,
            'contract/findContractListByPage',dataTableParams($scope));
    }


  //导出权限控制
    var roles =  $localStorage.user.roles;
    for(var i in roles){
        if(roles[i].role == CommonCodeUtils.role.QY || roles[i].role == CommonCodeUtils.role.YW){
            $scope.exportFlag = false;
        }
    }


}])
;