/**
 * Created by qiaomengnan on 2018-05-25.
 */
app.controller('gps_dispatch_monthly_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {
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
            url : 'gps_dispatch/findGpsDispatchMonthlysVosListByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'gps_dispatch_monthly_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('dispatchId'),
            // defaultDetail('contNo','detailGpsDispatch','合同编号','20%',$compile,$scope,'dispatchId'),
            {title:'出租人',data:'rentPerson',width:'20%'},
            {title:'承租人',data:'lessee',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'GPS派单日期',data:'expectInstallDate',width:'20%'},
            {title:'账单设备费用',data:'equipmentCost',width:'20%'},
            {title:'账单安装费用',data:'installationCost',width:'20%'},
            {title:'账单拆改费',data:'changeCost',width:'20%'},
            {title:'派单费用合计',data:'totalCost',width:'20%'},
            {title:'账单费用合计',data:'billTotalCost',width:'20%',
                render: function (data, type, row, meta) {
                    if(isNullEmpty(row.monthlySettlementNo))
                        return "";
                    return data;
                }
            },
            {title:'是否一致',data:'totalCost',width:'20%',
                render: function (data, type, row, meta) {
                    if(isNullEmpty(row.monthlySettlementNo)){
                        return "";
                    }else{
                        if(row.totalCost == row.billTotalCost)
                            return "一致";
                        else
                            return "不一致";
                    }
                }
            },
            {title:'月结任务号',data:'monthlySettlementNo',width:'20%'},
            {title:'月结状态',data:'monthlySts',width:'20%',
                render: function (data, type, row, meta) {
                    if(isNullEmpty(data))
                        return "";
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data);
                }
            },
            {title:'gps厂商',data:'gpsSeller',width:'20%',render: function (data, type, row, meta) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsSeller,data);
            }},
            {title:'盗抢险投保渠道',data:'theftInsuranceType',width:'20%',render: function (data, type, row, meta) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.theftInsuranceType,data);
            }},
            {title:'当前审批人',data:'presentUser',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }


    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.monthlySettlementNo = $scope.monthlySettlementNo;
        params.monthlySts = $scope.monthlySts;
        params.groupDistrict = $scope.groupDistrict;
        params.lessee = $scope.lessee;
        params.vinNo = $scope.vinNo;
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
        $scope.monthlySettlementNo = '';
        $scope.monthlySts = '';
        $scope.groupDistrict = '';
        $scope.lessee = '';
        $scope.vinNo = '';
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
        var dispatchIds = [];
        if(rows.length==0){
            modalAlert($modal,'请至少选择一条数据！');
        }else{
            rows.forEach(function (row,index) {
                if(isNotNullEmpty(row.monthlySettlementNo)){
                    flag = false;
                    return;
                }else{
                    dispatchIds.push(row.dispatchId);
                }
            });
            if(flag)
                $location.path('/app/cost_gps_dispatch_monthly_modify').search({'dispatchIds':dispatchIds});
            else{
                modalAlert($modal,'请选择还未审批的数据！');
                return;
            }
        }

    }

    //测试审批
    $scope.approve = function () {
        var monthlySettlementNo =  '0000000005';//业务号
        if(monthlySettlementNo){
            $location.path('/app/cost_gps_dispatch_monthly_approve').search({
                'operate':'approve',
                'monthlySettlementNo': monthlySettlementNo

            });
        } else{
            modalAlert($modal,'请您选择需要审批的数据！');
        }
    }

    //测试制单
    $scope.makeVoucher = function () {
        var monthlySettlementNo =  '0000000005';//业务号
        if(monthlySettlementNo){
            $location.path('/app/finance_gps_monthly_make_voucher').search({
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
            $location.path('/app/finance_gps_monthly_payment').search({
                'operate':'approve',
                'monthlySettlementNo': monthlySettlementNo

            });
        } else{
            modalAlert($modal,'请您选择需要审批的数据！');
        }
    }



    $scope.detailGpsDispatch = function(dispatchId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/cost/gps_dispatch/gps_dispatch_detail.html'+getCacheTime(),
            controller: 'gps_dispatch_detail_controller',
            resolve:{
                gpsDispatch : function (){ return $scope.dataTable.getRow(dispatchId,'dispatchId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }


}])
;