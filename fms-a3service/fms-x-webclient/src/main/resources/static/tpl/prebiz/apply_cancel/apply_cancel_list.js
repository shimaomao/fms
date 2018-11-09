/**
 * Created by yanfengbo
 * 融资申请取消
 */
app.controller('apply_cancel_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {
    //订单状态
    $scope.bizStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.bizStatus);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'apply_cancel/findApplyCancelsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'apply_cancel_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('applyNo'),
            defaultDetail('applyNo','detailApplyCancel','订单编号','20%',$compile,$scope,'applyNo'),
            {title:'申请姓名',data:'name',width:'20%'},
            {title:'申请类型',data:'applyType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.applyType,data);

                }
            },
            {title:'车辆类型',data:'vehicleForm',width:'20%',
                render: function (data, type, row, meta) {
                    var vehicleForm="";
                    if(data != null){
                        var dataArray=data.split(",");
                    }
                    for(x in dataArray){
                        vehicleForm+=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleForm,dataArray[x])+",";
                    }
                    if(vehicleForm!=""){
                        return vehicleForm.substring(0,vehicleForm.length-1);
                    }else{
                        return "";
                    }

                }
            },
            {title:'证件号码',data:'certifNo',width:'20%'},
            {title:'订单提出人',data:'applyUser',width:'20%'},
            {title:'订单提出机构',data:'groupName',width:'20%'},
            {title:'当前节点用户',data:'presentUser',width:'20%'},
            {title:'首次提交日期',data:'applyFirsbtDate',width:'20%'},
            {title:'提交日期',data:'applySubmitDate',width:'20%'},
            {title:'订单状态',data:'bizStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data);

                }
            },
            {title:'产品方案名称',data:'productName',width:'20%'},
            {title:'牌照属性',data:'licenseAttr',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data);

                }
            },
            {title:'融资期限',data:'finPeriodType',width:'20%'},
            {title:'手续费收取方式',data:'chargePayMode',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.chargePayMode,data);

                }
            },
            {title:'手续费率',data:'chargeRate',width:'20%'},
            {title:'手续费',data:'charge',width:'20%'},
            {title:'首付比例',data:'initPerc',width:'20%'},
            {title:'首付金额',data:'initAmount',width:'20%'},
            {title:'投资总额',data:'investTotal',width:'20%'},
            {title:'融资金额',data:'finTotal',width:'20%'},
            {title:'每期租金',data:'rent',width:'20%'},
            {title:'保证金费用',data:'deposit',width:'20%'},
            {title:'合作商',data:'partnerName',width:'20%'},




        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.applyNo = $scope.applyNo;
        params.name = $scope.name;
        params.bizStatus = $scope.bizStatus;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchApplyCancel = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetApplyCancel = function(){
        $scope.applyNo = "";
        $scope.name = "";
        $scope.bizStatus = "";
        $scope.dataTable.fnDraw(true);//刷新
    }




    // 修改
    $scope.modifyApplyCancel = function(applyNo) {
        var rowsIds = $scope.dataTable.getRowsIds('applyNo');//主键
        var row =  $scope.dataTable.getRow(applyNo,rowsIds[0]);
        if (rowsIds.length < 1)
            modalAlert($modal, '请您选择需要取消的订单！');
        else if (rowsIds.length > 1)
            modalAlert($modal, '只能同时取消一笔订单！');
        else {
            $location.path('/app/prebiz_apply_cancel_handler').search({

                'frameTitle':'融资申请取消',
                'operate':'update',
                'bizStatus': row.bizStatus,
                'applyNo': rowsIds[0]

            });

        }
    }

    //删除
    $scope.deleteApplyCancel = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('applyCancelId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('apply_cancel/deleteApplyCancelByParamKeyIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除system信息成功', toaster);
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
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.prebiz,CommonServiceType.excelTypes.one,
            'apply_cancel/findApplyCancelsByPage',dataTableParams($scope));
    }
}])
;
