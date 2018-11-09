/**
 * Created by qiaomengnan on 2018-05-25.
 */
app.controller('pilfer_insurance_monthly_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {
    //日期控件格式
    $scope.dateParams = JSON.stringify({dateFmt:'yyyy-MM-dd'});
    //月结状态
    $scope.bizStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.bizStatus);
    //gps厂商
    $scope.gpsSellerList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gpsSeller);
    //盗抢险投保渠道
    $scope.theftInsuranceTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.theftInsuranceType);

    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('申请成功', toaster);
        }
    }, 100);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'pilfer_insurance/findPilferInsuranceMonthlysVosListByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'pilfer_insurance_monthly_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('pilferInsuranceId'),
            // defaultDetail('contNo','detailGpsDispatch','合同编号','20%',$compile,$scope,'pilferInsuranceId'),
            {title:'出租人',data:'rentPerson',width:'20%'},
            {title:'承租人',data:'lessee',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'GPS派单日期',data:'expectInstallDate',width:'20%'},
            {title:'融资期限',data:'finPeriodType',width:'20%'},
            {title:'投保期限',data:'timeLimit',width:'20%'},
            {title:'盗抢险费用',data:'pilferInsuranceCost',width:'20%'},
            {title:'账单费用',data:'billPilferInsuranceCost',width:'20%',
                render: function (data, type, row, meta) {
                    if(isNullEmpty(row.monthlyPilferInsuranceNo))
                        return "";
                    return data;
                }
            },
            {title:'是否一致',data:'billPilferInsuranceCost',width:'20%',
                render: function (data, type, row, meta) {
                    if(isNullEmpty(row.monthlyPilferInsuranceNo)){
                        return "";
                    }else{
                        if(row.billPilferInsuranceCost == row.pilferInsuranceCost)
                            return "一致";
                        else
                            return "不一致";
                    }
                }
            },
            {title:'月结任务号',data:'monthlyPilferInsuranceNo',width:'20%'},
            {title:'月结状态',data:'monthlyPilferInsuranceSts',width:'20%',
                render: function (data, type, row, meta) {
                    if(isNullEmpty(data))
                        return "";
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data);
                }
            },
            {title:'盗抢险投保渠道',data:'theftInsuranceType',width:'20%',render: function (data, type, row, meta) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.theftInsuranceType,data);
            }},
            {title:'gps厂商',data:'gpsSeller',width:'20%',render: function (data, type, row, meta) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsSeller,data);
            }},
            {title:'当前审批人',data:'presentUser',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }


    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.monthlyPilferInsuranceNo = $scope.monthlyPilferInsuranceNo;
        params.monthlyPilferInsuranceSts = $scope.monthlyPilferInsuranceSts;
        params.lessee = $scope.lessee;
        params.vinNo = $scope.vinNo;
        params.groupDistrict = $scope.groupDistrict;
        params.gpsSeller = $scope.gpsSeller;
        params.theftInsuranceType = $scope.theftInsuranceType;
        params.expectInstallStartDateStr = $scope.expectInstallStartDateStr;
        params.expectInstallEndDateStr = $scope.expectInstallEndDateStr;

        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);

    //查询
    $scope.searchGpsDispatch = function(){
        $scope.dataTable.fnDraw(true);
    }
    //重置
    $scope.resetGpsDispatch = function(){
        $scope.monthlyPilferInsuranceNo = '';
        $scope.monthlyPilferInsuranceSts = '';
        $scope.lessee = "";
        $scope.vinNo = "";
        $scope.groupDistrict = "";
        $scope.gpsSeller = "";
        $scope.theftInsuranceType = "";
        $scope.expectInstallStartDateStr = "";
        $scope.expectInstallEndDateStr = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    //申请月结
    $scope.applyMonthLy = function(){
        var rows = $scope.dataTable.getRows();
        var flag = true;
        var pilferInsuranceIds = [];
        if(rows.length==0){
            modalAlert($modal,'请至少选择一条数据！');
        }else{
            rows.forEach(function (row,index) {
                if(isNotNullEmpty(row.monthlyPilferInsuranceNo)){
                    flag = false;
                    return ;
                }else{
                    pilferInsuranceIds.push(row.pilferInsuranceId);
                }
            });
            if(flag)
                $location.path('/app/cost_pilfer_insurance_monthly_modify').search({'pilferInsuranceIds':pilferInsuranceIds});
            else{
                modalAlert($modal,'请选择还未审批的数据！');
                return;
            }
        }

    }

    //测试审批
    $scope.approve = function () {
        var monthlyPilferInsuranceNo =  '0000000002';//业务号
        if(monthlyPilferInsuranceNo){
            $location.path('/app/cost_monthly_pilfer_insurance_approve').search({
                'operate':'approve',
                'monthlyPilferInsuranceNo': monthlyPilferInsuranceNo

            });
        } else{
            modalAlert($modal,'请您选择需要审批的数据！');
        }
    }

    //测试制单
    $scope.makeVoucher = function () {
        var monthlySettlementNo =  '0000000005';//业务号
        if(monthlySettlementNo){
            $location.path('/app/finance_pilfer_monthly_make_voucher').search({
                'operate':'approve',
                'monthlySettlementNo': monthlySettlementNo

            });
        } else{
            modalAlert($modal,'请您选择需要审批的数据！');
        }
    }

    //测试付款
    $scope.payment = function () {
        var monthlySettlementNo =  '0000000005';//业务号
        if(monthlySettlementNo){
            $location.path('/app/finance_pilfer_monthly_payment').search({
                'operate':'approve',
                'monthlySettlementNo': monthlySettlementNo

            });
        } else{
            modalAlert($modal,'请您选择需要审批的数据！');
        }
    }

}])
;