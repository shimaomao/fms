/**
 * Created by qiaohao on 2018/7/11.
 */
app.controller('financial_voucher_summary_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','setData', function ($scope, $http, $modal, toaster,$compile,$location,setData) {

    $scope.submit = false;
    $scope.maxDate = {maxDate:'#F{$dp.$D(\'validEndDate\')}'};
    $scope.minDate = {minDate:'#F{$dp.$D(\'validStartDate\')}'};
    //发送状态
    $scope.sendStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.finVouSummarySendStatus);
    //取得凭证类型
    $http.get('financial_voucher/findFinancialVouchersByPage?pageFlag=1').success(function (result) {
        if (result.code == Response.successCode) {
            $scope.voucherTypeList = result.data.data;
        }
    });


    //查询参数
    $scope.params = setData.getter();
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'financial_voucher_summary/findFinancialVoucherSummaryVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'financial_voucher_data_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('voucherSummaryId'),
            defaultDetail('voucherNo','detailFinancialVoucherData','凭证号','8%',$compile,$scope,'voucherSummaryId'),
            {title:'业务号',data:'voucherBizCode',width:'8%'},
            {title:'出租人',data:'groupName',width:'8%'},
            {title:'承租人',data:'name',width:'8%'},
            {title:'业务日期',data:'voucherBizDate',width:'8%'},
            {title:'凭证类型',data:'voucherTypeName',width:'8%'},
            {title:'凭证区域',data:'voucherGroup',width:'8%'},
            {title:'最后一次发送状态',data:'sendStatus',width:'8%',render:function (data) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.finVouSummarySendStatus,data);
            }},
            {title:'最后一次发送批次号',data:'sendBatchNo',width:'8%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        /*params = {};
        params.voucherNo = $scope.voucherNo;
        params.voucherBizCode = $scope.voucherBizCode;*/
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchFinancialVoucherData = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetFinancialVoucherData = function(){
       /* $scope.voucherNo = "";
        $scope.voucherBizCode = "";*/
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.finance,CommonServiceType.excelTypes.one,
            'financial_voucher_data/findFinVouDataVosByPage',dataTableParams($scope));
    }

    $scope.detailFinancialVoucherData = function(voucherNo){
        var row = $scope.dataTable.getRow(voucherNo,"voucherSummaryId");
        if(CommonObjectUtils.isExist(row))
            $location.path('/app/financial_voucher_data_detail').search({voucherNo:row.voucherNo});
        else
            modalAlert($modal,"请选择需要查看明细的数据");
    }

    $scope.sendData = function () {
        var rows = $scope.dataTable.getRows("voucherSummaryId");
        if(rows.length < 1)
            modalAlert($modal,"请选择需要发送的凭证数据");
        else{
            $scope.submit = true;
            var voucherSummaryIds = [];
            for(var i in rows){
                if(rows[i].sendStatus == CommonCodeUtils.finVouSummarySendStatus.send){
                    $scope.submit = false;
                    modalAlert($modal,"凭证号" + rows[i].voucherNo + "已发送过，不可重复发送");
                    return;
                }
                voucherSummaryIds.push(rows[i].voucherSummaryId);
            }
            $http.post( 'financial_voucher_send/sendFinancialVoucher', voucherSummaryIds).success(function (data) {
                if (data.code == Response.successCode){
                    if(data.data.code == 0) {
                        $scope.submit = false;
                        toaster_info("凭证数据发送成功", toaster);
                        $scope.dataTable.fnDraw(true);//刷新
                    } else{
                        $scope.submit = false;
                        modalAlert($modal,"凭证数据发送失败,失败原因:" + data.data.msg);
                    }
                }else{
                    $scope.submit = false;
                    modalAlert($modal,data.message);
                }
            }).error(function (err) {
                $scope.submit = false;
                modalAlert($modal,err);
            });
        }
    }

}])
;