/**
 * Created by yangyiquan on 2018-09-10.
 */
app.controller('invoice_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','setData','$timeout',function ($scope, $http, $modal, toaster,$compile,$location,setData,$timeout) {

    $timeout(function () {
        var msg = $location.search()['msg'];
        if(CommonObjectUtils.isExist(msg)) {
            toaster_success(msg, toaster);
            $location.search({msg:null});
        }
    })

    $scope.maxDate2 = {maxDate2:'#F{$dp.$D(\'validEndDate2\')}'};
    $scope.minDate2 = {minDate2:'#F{$dp.$D(\'validStartDate2\')}'};

    //查询参数
    $scope.params = setData.getter();
    //业务类型
    $scope.licenseAttrList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'invoice/findInvoiceVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'invoice_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('invoiceId'),
            {title:'合同编号',data:'contNo',width:'8%'},
            {title:'开票类型',data:'invoiceDataType',width:'8%',render: function (data) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceDataType,data);
            }},
            {title:'发票类型',data:'cstmInvoiceType',width:'8%',render:function (data) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceType,data);
            }},
            {title:'开票区分',data:'invoiceFlag',width:'8%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceFlag,data)
                }
            },
            {title:'发票号码',data:'invoiceNo',width:'8%'},
            {title:'明细信息',data:'detailNo',width:'8%'},
            {title:'收款金额',data:'receiveActualAccount',width:'8%'},
            {title:'收款日期',data:'receiveDate',width:'8%'},
            {title:'开票日期',data:'invoiceDate',width:'8%'},
            {title:'开票状态',data:'invoiceStatus',width:'8%',render:function(data){
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceStatus,data);
            }},
            {title:'开票税率',data:'invoiceTax',width:'8%'},
            {title:'打印状态',data:'printStatus',width:'8%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.printStatus,data)
                }
            },
            {title:'开票金额',data:'invoiceAmount',width:'8%'},
            {title:'开票备注',data:'invoiceMemo',width:'8%'},
            {title:'凭证状态',data:'invoiceVoucherStatus',width:'8%',render:function (data) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceVoucherStatus,data);
            }},
            {title:'承租人',data:'lessee',width:'8%'},
            {title:'车架号',data:'vinNo',width:'8%'},
            {title:'出租人',data:'lessor',width:'8%'},
            {title:'申请类型',data:'applyType',width:'8%',render:function (data) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.applyType,data);
            }},
            {title:'业务类型',data:'licenseAttr',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data);
                }
            },
            {title:'开票名',data:'ticketOpening',width:'8%'},
            {title:'税号',data:'dutyParagraph',width:'8%'},
            {title:'发票地址',data:'invoiceAddr',width:'8%'},
            {title:'开户行',data:'bankName',width:'8%'},
            {title:'账号',data:'accountNumber',width:'8%'},

        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //日期参数
    $scope.maxDate = {maxDate:'#F{$dp.$D(\'endReceiveDate\')}'};
    $scope.minDate = {minDate:'#F{$dp.$D(\'beginReceiveDate\')}',validStartDate:'#F{$dp.$D(\'beginReceiveDate\',{d:+1})}'};

    $scope.invoiceDataTypes = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.invoiceDataType);
    $scope.invoiceStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.invoiceStatus);
    $scope.cstmInvoiceTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.invoiceType);
    $scope.printStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.printStatus);
    $scope.invoiceFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.invoiceFlag);

    //请求的参数
    function dataTableParams($scope){
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchInvoice = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetInvoice = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

    //手动开票
    $scope.invoiceManual = function () {
        var rows =  $scope.dataTable.getRows('invoiceId');//主键
        if(rows.length < 1)
            modalAlert($modal,'请您选择需要手动开票的信息');
        else {
            for(var i in rows){
                var row = rows[i];
                if(CommonStringUtils.isNotTrimBlank(row['invoiceStatus']) && row['invoiceStatus'] != CommonCodeUtils.invoiceStatus.noInvoice){
                    modalAlert($modal,'合同号: ' + row['contNo'] + ',已经开票,不能重复开票');
                    return;
                }
            }
            $location.path("app/postbiz_invoice_manual").search({invoices:rows});
        }
    }

    //自动开票
    $scope.autoManual = function () {
        var rows =  $scope.dataTable.getRows('invoiceId');//主键
        if(rows.length < 1)
            modalAlert($modal,'请您选择需要自动开票的信息');
        else{
            var rowIds = [];
            for(var i in rows){
                var row = rows[i];
                if(CommonStringUtils.isNotTrimBlank(row['invoiceStatus']) && row['invoiceStatus'] != CommonCodeUtils.invoiceStatus.noInvoice){
                    modalAlert($modal,'合同号: ' + row['contNo'] + ',已经开票,不能重复开票');
                    return;
                }
                rowIds.push(row['invoiceId']);
            }

            modalConfirm($modal,function(){
                $http.put('invoice/autoManual', rowIds).success(function (data) {
                    // if (data.code == Response.successCode){
                    //     if(data.data.invoiceAutos.length == 0){
                    //         modalAlert($modal,'开票失败，请联系管理员');
                    //     }
                    //     else
                    //         // $location.path('app/postbiz_invoice_auto_list').search({invoiceAuto:data.data.invoiceAutos,msg:'开票成功'})
                    //     {
                    //         modalAlert($modal,'开票成功')
                    //         $scope.dataTable.fnDraw(true);//刷新
                    //     }
                    // }else
                    //     modalAlert($modal,data.message);
                    // $scope.submit = false;

                    if (data.code == Response.successCode){
                        var rtn = $modal.open({
                            keyboard: false,
                            backdrop : 'static',
                            size:'lg',
                            templateUrl: 'tpl/postbiz/invoice/invoice_printinv_confirm.html?datetime='+getTimestamp(),
                            controller: 'invoice_printinv_confirm_controller',
                            resolve:{
                                invoiceResult:function () {
                                    return data.data;
                                }
                            }
                        });
                        rtn.result.then(function () {
                            if(data.data.invoiceAutos.length > 0){
                                $scope.dataTable.fnDraw(true);//刷新
                            }
                        },function(){

                        });
                    } else
                        modalAlert($modal,data.message);
                    $scope.submit = false;
                }).error(function(data){
                    modalAlert($modal,data);
                    $scope.submit = false;
                })
            },null,"确认开票吗?");

        }
    }

    //开票作废
    $scope.cancel = function () {
        var rowIds =  $scope.dataTable.getRowsIds('invoiceId');//主键
        if(rowIds.length < 1)
            modalAlert($modal,'请您选择需要作废的信息');
        else{
            for(var i in rowIds){
                var row = $scope.dataTable.getRow(rowIds[i],'invoiceId');
                if(CommonStringUtils.isTrimBlank(row['invoiceStatus']) || row['invoiceStatus'] == CommonCodeUtils.invoiceStatus.noInvoice){
                    modalAlert($modal,'合同号: ' + row['contNo'] + ',还未开票,无法作废');
                    return;
                }
            }
            modalConfirm($modal,function(){
                $http.put('invoice/cancelInvoice', rowIds).success(function (data) {
                    if (data.code == Response.successCode){
                        modalAlert($modal,"作废成功");
                        $scope.dataTable.fnDraw(true);//刷新
                    } else
                        modalAlert($modal,data.message);
                    $scope.submit = false;
                }).error(function(data){
                    modalAlert($modal,data);
                    $scope.submit = false;
                })
            },null,"确认作废吗?");
        }
    }

    //手动打印
    $scope.manualPrintinv = function () {

        var rows =  $scope.dataTable.getRows('invoiceId');//主键
        if(rows.length < 1)
            modalAlert($modal,'请您选择需要打印的信息');
        else{
            var rowIds = [];
            for(var i in rows){
                var row = rows[i];
                // if(CommonStringUtils.isNotTrimBlank(row['invoiceStatus']) && row['invoiceStatus'] == CommonCodeUtils.invoiceStatus.invoice){
                //     modalAlert($modal,'合同号: ' + row['contNo'] + ',已经打印,不能重复打印');
                //     return;
                // }
                if(CommonStringUtils.isNotTrimBlank(row['invoiceStatus']) && row['invoiceStatus'] == CommonCodeUtils.invoiceStatus.noInvoice){
                    modalAlert($modal,'合同号: ' + row['contNo'] + ',还未开票,无法打印');
                    return;
                }else if(row['invoiceFlag'] != CommonCodeUtils.printStatus.print){
                    modalAlert($modal,'非自动开票信息无法打印');
                    return;
                }else if(row['printStatus'] == CommonCodeUtils.printStatus.print){
                    modalAlert($modal,'该发票已打印');
                    return;
                }

                rowIds.push(row['invoiceNo']);
            }

            // modalConfirm($modal,function(){
             $location.path('app/postbiz_invoice_auto_list').search({invoiceNos:rowIds})
                // $http.post('invoice/findInvoiceAutos', rowIds).success(function (data) {
                //     if (data.code == Response.successCode){
                //
                //     }else
                //         modalAlert($modal,data.message);
                // }).error(function(data){
                //     modalAlert($modal,data);
                //     $scope.submit = false;
                // })
            // },null,"确认打印吗?");
        }
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
                if(CommonStringUtils.isNotTrimBlank(row['invoiceVoucherStatus']) && row['invoiceVoucherStatus'] == CommonCodeUtils.yesNoFlag.yes){
                    modalAlert($modal,'合同号: ' + row['contNo'] + ',已经生成凭证,不能重复生成凭证');
                    return;
                }
                /*if(CommonStringUtils.isNotTrimBlank(row['invoiceStatus']) && row['invoiceStatus'] == CommonCodeUtils.invoiceStatus.noInvoice){
                    modalAlert($modal,'合同号: ' + row['contNo'] + ',还未开票,无法打印');
                    return;
                }*/
                rowIds.push(row['invoiceId']);
            }

            modalConfirm($modal,function(){
                $http.put('invoice/makeVoucher', rowIds).success(function (data) {
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

    $scope.saveInvoice = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/invoice/invoice_save.html'+getCacheTime(),
            controller: 'invoice_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加postbiz信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifyInvoice = function(invoiceId){
        var rowsIds =  $scope.dataTable.getRowsIds('invoiceId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/postbiz/invoice/invoice_modify.html'+getCacheTime(),
                controller: 'invoice_modify_controller',
                resolve:{
                    invoiceId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑postbiz信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    $scope.detailInvoice = function(invoiceId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/invoice/invoice_detail.html'+getCacheTime(),
            controller: 'invoice_detail_controller',
            resolve:{
                invoice : function (){ return $scope.dataTable.getRow(invoiceId,'invoiceId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteInvoice = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('invoiceId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('invoice/deleteInvoicesByInvoiceIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除postbiz信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

    //导出excel
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.postbiz,CommonServiceType.excelTypes.one,
            'invoice/findInvoiceVosByPage',dataTableParams($scope));
    }

}])
;