/**
 * Created by lijunjun on 2018-05-07.
 */
app.controller('cont_receipt_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile, $location,$timeout,setData) {
    $scope.maxDate = {maxDate:'#F{$dp.$D(\'validEndDate\')}'};
    $scope.minDate = {minDate:'#F{$dp.$D(\'validStartDate\')}'};

    //申请类型
    $scope.companyTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.companyType);
    //企业类型2_企业
    $scope.companyTypeCompList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.companyTypeComp);
    //企业类型2_经销商
    $scope.companyTypeSaleList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.companyTypeSale);

    //查询参数
    $scope.params = setData.getter();
    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.msg = $location.search()['msg'];
        if ($scope.msg) {
            toaster_success($scope.msg, toaster);
        }
    }, 100);

    $scope.changeCompanyType = function () {
        $scope.params.companyType2 = "";
    };

    //参数配置

    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cont_receipt/findContReceiptsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'cont_receipt_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contReceiptId'),
            // defaultDetail('receiptDate','detailContReceipt','到账日期','20%',$compile,$scope),
            {title:'到账日期',data:'receiptDate',width:'20%'},
            {title:'付款户名',data:'payAccountName',width:'20%'},
            {title:'付款备注',data:'memo',width:'20%'},
            {title:'到账金额',data:'receiptAmount',width:'20%'},
            {title:'剩余金额',data:'restAmount',width:'20%'},
            {title:'收款户名',data:'recAccountName',width:'20%'},
            {title:'收款银行',data:'recAccBank',width:'20%'},
            {title:'收款账号',data:'recAccountNo',width:'20%'},
            {title:'到账时刻',data:'receiptTime',width:'20%'},
            // {title:'付款银行',data:'payAccBank',width:'20%'},
            // {title:'付款账号',data:'payAccountNo',width:'20%'},



        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    };

    //请求的参数
    function dataTableParams($scope){
        $scope.params.start = 0;
        var params = {
            memo: $scope.params.memo,
            payAccountName: $scope.params.name,
            recAccountName: $scope.params.groupDistrict
        };
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchContReceipt = function(){
        $scope.dataTable.fnDraw(true);
        $scope.dataTableRepaySked.fnDraw(true);
    };

    $scope.resetContReceipt = function(){
        $scope.params = {};
        /*$scope.vinNo = "";
        $scope.receiptDateSearch = "";
        $scope.receiptBizType = "";
        $scope.memo = "";
        $scope.name = "";
        $scope.groupDistrict = "";
        $scope.repayDateSearchStart = "";
        $scope.repayDateSearchEnd = "";
        $scope.rentActual = "";*/
        $scope.dataTable.fnDraw(true);//刷新
        $scope.dataTableRepaySked.fnDraw(true);
    };


    //参数配置
    $scope.dataTablePropertiesRepaySked= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cont_repay_sked/findContRepaySkedsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'cont_repay_sked_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('repaySkedId'),
            {title:'应还款日',data:'repayDate',width:'20%'},
            {title:'承租人',data:'name',width:'20%'},
            {title:'合同号',data:'contNo',width:'20%'},
            {title:'区域',data:'groupDistrict',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'期数',data:'period',width:'20%'},
            {title:'应收租金',data:'rentActual',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data){
                        data = "-";
                    }
                    return data;
                }
            }, {
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
                    return numAddSub(data,row.exemptAmount,2);
                }
            }, {
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
            },
            {title:'实际还款日',data:'receiptDate',width:'20%'},
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
            {title:'备注',data:'memo',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    $scope.callback = function (allChecked) {
        var selectFlag = false;
        var rentTotal=0,overdueTotal=0,
            rentSelected=0,overdueSelected=0;
        var nTrs = $scope.dataTableRepaySked.fnGetNodes();
        for(var i = 0; i < nTrs.length; i++){
            rentTotal = $scope.dataTableRepaySked.fnGetData(nTrs[i]).rentActual*1 + rentTotal;
            overdueTotal = $scope.dataTableRepaySked.fnGetData(nTrs[i]).overdueAmount*1-$scope.dataTableRepaySked.fnGetData(nTrs[i]).exemptAmount*1 + overdueTotal;
            if($(nTrs[i]).find('[name=ids]:checkbox').prop('checked')){
                selectFlag = true;
                rentSelected = $scope.dataTableRepaySked.fnGetData(nTrs[i]).rentActual*1 + rentSelected;
                overdueSelected = $scope.dataTableRepaySked.fnGetData(nTrs[i]).overdueAmount*1-$scope.dataTableRepaySked.fnGetData(nTrs[i]).exemptAmount*1 + overdueSelected;
            }
        }
        //如果有选择的但不是全选
        if(selectFlag && !allChecked){
            rentTotal = rentSelected;
            overdueTotal = overdueSelected;
        }
        var html = '<tr>' +
            '<th>合计</th>' +
            '<td colspan="6"></td>' +
            '<td>'+rentTotal.toFixed(2)+'</td>' +
            '<td></td>' +
            '<td>'+overdueTotal.toFixed(2)+'</td>' +
            '</tr>';
        //先移除原先的合计行
        $("tr:contains('合计')").remove();
        //追加最新的合计行
        $('#cont_repay_sked_table tbody').append(html);
    };

    //单选触发
    function changeCheckBox(value,flag,$scope){
        $scope.callback();
    }

    //全选触发
    $timeout(function(){
        $("#cont_repay_sked_table_wrapper [name='all_checked']").click(function () {
            $scope.callback(true);
        });
    });

    //请求的参数
    function dataTableParamsRepaySked($scope){
        $scope.params.start = 0;
        var params = $scope.params;
        /*var params = {
            vinNo: $scope.vinNo,
            rentActual: $scope.params.rentActual,
            repayDateSearchStart: $scope.params.repayDateSearchStart,
            repayDateSearchEnd: $scope.params.repayDateSearchEnd,
            receiptBizType: $scope.params.receiptBizType,
            name: $scope.params.name,
            receiptDateSearch: $scope.params.receiptDateSearch,
            groupDistrict: $scope.params.groupDistrict
        };*/
        setData.setter(params);
        return params;
    }



    //创建dataTable
    $scope.dataTableRepaySked = createTable($scope.dataTablePropertiesRepaySked,dataTableParamsRepaySked,$scope,changeCheckBox);

    $scope.detailContRepaySked = function (id,type,data) {
        if(data != 0){
            $location.path("app/finance_cont_repay_sked_list").search({receiptBizType:type, repaySkedId:id});
        }else{
            modalAlert($modal,"已认领金额为空");
        }

    };

    // 认领
    $scope.claimed = function () {
        modalConfirm($modal,function(){
            var receiptIdRowsIds =  $scope.dataTable.getRows();//主键
            var repaySkedIdRowsIds =  $scope.dataTableRepaySked.getRows();//主键
            $http.post('cont_receipt/receipt', {'contReceiptVoList':receiptIdRowsIds, 'contRepaySkedVoList':repaySkedIdRowsIds, 'solveFlag':'0'}).success(function (result) {
                if (result.code == Response.successCode) {
                    modalAlert($modal,"认领成功");
                    $scope.dataTable.fnDraw(true);
                    $scope.dataTableRepaySked.fnDraw(true);
                } else {
                    modalAlert($modal,result.message);
                }
                $scope.submit = false;
            });
        },null,'您确定需要认领吗？')
    };

    // 手动勾稽
    $scope.manualReceipt = function () {
        var repaySkedIdRows = $scope.dataTableRepaySked.getRows();
        if(repaySkedIdRows.length==0){
            modalAlert($modal,'请至少选择一条需要勾稽的数据！');
        }else{
            $location.path('/app/finance_cont_receipt_manual_checked').search({'repaySkedIdRows':JSON.stringify(repaySkedIdRows),'solveFlag':'1'});
        }
    };

    // 勾稽
    $scope.receipt = function () {
        var receiptIdRowsIds =  $scope.dataTable.getRows();//主键
        if(receiptIdRowsIds.length==0){
            modalAlert($modal,'请至少选择一条收款数据！');
            return;
        }
        var repaySkedIdRowsIds =  $scope.dataTableRepaySked.getRows();//主键
        if(repaySkedIdRowsIds.length==0){
            modalAlert($modal,'请至少选择一条需要勾稽的数据！');
            return;
        }
        modalConfirm($modal,function(){
            /*var restTotalAmount = 0;//剩余金额合计
            for(var i in  receiptIdRowsIds){
                restTotalAmount += (receiptIdRowsIds[i].restAmount?receiptIdRowsIds[i].restAmount:0);
            }
            var beReceiptTotalAmount = 0;//待勾稽租金合计
            var claimedTotalAmount = 0;//已认领金额合计
            for(var i in  repaySkedIdRowsIds){
                if(repaySkedIdRowsIds[i].receiptBizType == CommonCodeUtils.receiptBizType.repaymentAmount){
                    beReceiptTotalAmount += (repaySkedIdRowsIds[i].rentActual?repaySkedIdRowsIds[i].rentActual:0);
                } else {
                    beReceiptTotalAmount += (repaySkedIdRowsIds[i].overdueAmount?repaySkedIdRowsIds[i].overdueAmount:0);
                }
                claimedTotalAmount += (repaySkedIdRowsIds[i].claimedAmount?repaySkedIdRowsIds[i].claimedAmount:0);
            }*/
            // 勾稽的场合：收款明细的剩余金额合计 < 待勾稽明细金额合计 - 已认领金额合计时，警告：剩余金额不足，不能勾稽，请认领
            /*if(restTotalAmount < beReceiptTotalAmount - claimedTotalAmount){
                modalAlert($modal,'剩余金额不足，不能勾稽，请认领！');
            } else {

            }*/

            $http.post('cont_receipt/receipt', {'contReceiptVoList':receiptIdRowsIds, 'contRepaySkedVoList':repaySkedIdRowsIds, 'solveFlag':'1'}).success(function (result) {
                if (result.code == Response.successCode) {
                    modalAlert($modal,"勾稽成功");
                    $scope.dataTable.fnDraw(true);
                    $scope.dataTableRepaySked.fnDraw(true);
                } else {
                    modalAlert($modal,result.message);
                }
                $scope.submit = false;
            });
        },null,'您确定需要勾稽吗？')
    }

    //收款明细导出
    $scope.exportContReceiptExcel = function () {
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.finance,CommonServiceType.excelTypes.one,
            'cont_receipt/findContReceiptsByPage',dataTableParams($scope));
    }

    //待勾稽租金导出
    $scope.exportContRepaySkedExcel = function () {
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.finance,CommonServiceType.excelTypes.one,
            'cont_repay_sked/findContRepaySkedsByPage',dataTableParamsRepaySked($scope));
    }

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

}])
;