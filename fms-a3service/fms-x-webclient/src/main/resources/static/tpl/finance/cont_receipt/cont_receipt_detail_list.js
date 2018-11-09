/**
 * Created by lijunjun on 2018-05-08.
 */
app.controller('cont_receipt_detail_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile, $location,$timeout,setData) {
    $scope.maxDate = {maxDate:'#F{$dp.$D(\'validEndDate\')}'};
    $scope.minDate = {minDate:'#F{$dp.$D(\'validStartDate\')}'};

    $scope.maxDate2 = {maxDate2:'#F{$dp.$D(\'validEndDate2\')}'};
    $scope.minDate2 = {minDate2:'#F{$dp.$D(\'validStartDate2\')}'};

    //款项类型
    $scope.receiptBizTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.receiptBizType);

    //凭证生成状态
    $scope.invoiceVoucherStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.invoiceVoucherStatus);

    //查询参数
    $scope.params = setData.getter();
    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.messageType = $location.search()['messageType'];
        if ($scope.messageType == 'InvoiceSuccess') {
            toaster_success('开具发票成功', toaster);
        }
    }, 100);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cont_repay_sked/findContReceiptDetailsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'cont_repay_sked_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contReceiptExamId'),
            //{title:'合同编号',data:'contNo',width:'20%'},
            {title:'区域',data:'groupDistrict',width:'20%'},
            {title:'客户姓名',data:'name',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'合同号',data:'contNo',width:'20%'},
            {title:'期数',data:'period',width:'20%'},
            {title:'应还款日',data:'repayDate',width:'20%'},
            {title:'实际还款日',data:'receiptDate',width:'20%'},
            {title:'应收租金',data:'rentActual',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data){
                        data = "-";
                    }
                    return data;
                }
            },
            {title:'实收租金',data:'crsReceiptAmount',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data){
                        data = "-";
                    }
                    return data;
                }
            },
            {title:'应收罚息',data:'receivableOverdueAmount',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data){
                        data = "-";
                    }
                    return data;
                }
            },
            {title:'实收罚息',data:'coReceiptAmount',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data){
                        data = "-";
                    }
                    return data;
                }
            },
            {title:'到账日期',data:'accountReceiptDate',width:'20%'},
            {title:'到账金额',data:'receiptAmount',width:'20%'},
            {title:'剩余金额',data:'restAmount',width:'20%'},
            {title:'付款户名',data:'payAccountName',width:'20%'},
            {title:'付款备注',data:'memo',width:'20%'},
            {title:'勾稽金额',data:'receiptExamAmount',width:'20%'},
            {title:'勾稽状态',data:'receiptExamStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.receiptExamStatus,data);
                }
            },
            {title:'勾稽时间',data:'updateTime',width:'20%'},
            {title:'收款银行',data:'recAccBranch',width:'20%'},
            {title:'收款账号',data:'recAccountNo',width:'20%'},
            {title:'收款户名',data:'recAccountName',width:'20%'},
            {title:'发票开具时间',data:'invoiceDate',width:'20%'},
            {title:'开票备注',data:'invoiceMemo',width:'20%'},
            {title:'款项类型',data:'receiptBizType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.receiptBizType,data);
                }
            },{title:'凭证状态',data:'voucherStatus',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        data = 0;
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceVoucherStatus,data);
                }
            },

            // {title:'逾期罚息额',data:'overdueAmount',width:'20%',
            //     render: function (data, type, row, meta) {
            //         if(!data){
            //             data = "-";
            //         }
            //         return data;
            //     }
            // },
            //
            //
            //
            // {title:'付款银行',data:'payAccBank',width:'20%'},
            // {title:'付款账号',data:'payAccountNo',width:'20%'},

        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
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


    $scope.searchContRepaySked = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetContRepaySked = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }
    
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.finance,CommonServiceType.excelTypes.three,
            'cont_repay_sked/findContReceiptDetailsByPage', dataTableParams($scope));
    }


    //生成凭证
    $scope.generate = function () {
        var rows =  $scope.dataTable.getRows();
        if(rows.length < 1)
            modalAlert($modal,'请您选择需要生成凭证的信息');
        else{
            var rowIds = [];
            for(var i in rows){
                var row = rows[i];
                if(CommonStringUtils.isNotTrimBlank(row['voucherStatus']) && row['voucherStatus'] == CommonCodeUtils.yesNoFlag.yes){
                    modalAlert($modal,'合同号: ' + row['contNo'] + ',已经生成凭证,不能重复生成凭证');
                    return;
                }

                rowIds.push(row['contReceiptExamId']);
            }

            modalConfirm($modal,function(){
                $http.put('cont_repay_sked/makeVoucher', rowIds).success(function (data) {
                    if (data.code == Response.successCode){
                        modalAlert($modal,"生成凭证成功");
                        $scope.dataTable.fnDraw(true);//刷新
                    } else
                        modalAlert($modal,data.message);
                    $scope.submit = false;
                }).error(function(data){
                    modalAlert($modal,data);
                    $scope.submit = false;
                })
            },null,"确认生成凭证吗?");
        }
    }

}])
;