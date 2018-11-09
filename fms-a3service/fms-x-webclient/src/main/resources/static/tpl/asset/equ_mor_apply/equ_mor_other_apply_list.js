/**
 * Created by qiaomengnan on 2018-05-30.
 */
app.controller('equ_mor_apply_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {

    $timeout(function () {
        var msg = $location.search()['msg'];
        if(CommonObjectUtils.isExist(msg)) {
            toaster_success(msg, toaster);
            $location.search({msg:null});
        }
    })
    //查询参数
    $scope.params = setData.getter();
    //融资期限
    $scope.finPeriodTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.finPeriodType);
    //申请类型
    $scope.companyTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.companyType);
    //抵押状态
    $scope.mortgageStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.mortgageStatus);
    //资方
    $scope.managementList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.management);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'equ_mor_apply/findEquMorOtherApplyVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'equ_mor_charge_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contractId'),
            defaultDetail('contNo','detailEquMorDetail','合同号','20%',$compile,$scope,'contractId'),
            //{title:'合同号',data:'contNo',width:'20%'},
            {title:'品牌',data:'vehBrandCodeName',width:'20%'},
            {title:'业务类型',data:'licenseAttr',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data)
                }},
            {title:'出租人',data:'belongGroupName',width:'20%'},
            {title:'客户姓名',data:'lessee',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'车型',data:'vehicleCodeName',width:'10%'},
            {title:'车牌号',data:'vehicleLicenseNo',width:'10%'},
            {title:'发动机号',data:'engineNo',width:'10%'},
            {title:'申请类型',data:'companyType1',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.companyType,data);
                }
            },
            {title:'抵押状态',data:'mortgageStatus',width:'20%',
             render:function (data) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.mortgageStatus,data)
            }
            },
            {title:'车款',data:'carpriceFee',width:'20%'},
            {title:'购置税',data:'purchasetaxFee',width:'20%'},
            {title:'保险',data:'insuranceFee',width:'20%'},
            {title:'其他费用',data:'otherFee',width:'20%'},
            {title:'申请金额',data:'investTotal',width:'20%'},
            {title:'融资金额',data:'finTotal',width:'20%'},
            {title:'融资期限',data:'finPeriodType',width:'20%'},
            {title:'放款日期',data:'contractValidDate',width:'20%'},
            {title:'客户租金',data:'rent',width:'20%'},

            {title:'抵押期数',data:'leasePeriod',width:'20%'},
            {title:'还款日',data:'repayDate',width:'20%'},
            {title:'起租日',data:'equStartDate',width:'20%'},
            {title:'到期日',data:'equEndDate',width:'20%'},
            {title:'抵押保证金',data:'margin',width:'20%'},
            {title:'抵押合同金额',data:'equFinAmount',width:'20%'},
            {title:'抵押月租',data:'equRent',width:'20%'},
            {title:'手续费',data:'factorge',width:'20%'},
            {title:'服务费',data:'serviceCharge',width:'20%'},

            {title:'剩余期数',data:'surplusPeriod',width:'20%'},
            {title:'剩余租金',data:'surplusRent',width:'20%'},
            {title:'抵押任务号',data:'equMorTaskNo',width:'20%'},
            {title:'抵押合同号',data:'mortgageContNo',width:'20%'},
            {title:'资方',data:'management',width:'20%',render: function(data){ return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.management,data); }},
            {title:'抵押任务状态',data:'mortgageServStatus',width:'20%',render: function(data){ return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data); }},
            {title:'当前节点用户',data:'presentUser',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    $scope.callback = function (data) {
        //var data = $scope.dataTable;
        var tableData = data.data;
        var carpriceFeeSum=0,purchasetaxFeeSum=0,insuranceFeeSum=0,otherFeeSum=0,investTotalSum = 0,finTotalSum = 0,rentSum=0,marginSum=0,equFinAmountSum=0,equRentSum=0,factorgeSum=0,
            serviceChargeSum=0,surplusRentSum=0;
        for(var i=0;i<tableData.length;i++){
            carpriceFeeSum = tableData[i].carpriceFee*1 + carpriceFeeSum;
            purchasetaxFeeSum = tableData[i].purchasetaxFee*1 + purchasetaxFeeSum;
            insuranceFeeSum = tableData[i].insuranceFee*1 + insuranceFeeSum;
            otherFeeSum = tableData[i].otherFee*1 + otherFeeSum;
            investTotalSum = tableData[i].investTotal*1 + investTotalSum;
            finTotalSum = tableData[i].finTotal*1 + finTotalSum;
            rentSum = tableData[i].rent*1 + rentSum;
            marginSum = tableData[i].margin*1 + marginSum;
            equFinAmountSum = tableData[i].equFinAmount*1 + equFinAmountSum;
            equRentSum = tableData[i].equRent*1 + equRentSum;
            factorgeSum = tableData[i].factorge*1 + factorgeSum;
            serviceChargeSum = tableData[i].serviceCharge*1 + serviceChargeSum;
            surplusRentSum = tableData[i].surplusRent*1 + surplusRentSum;
        }
        var html = '<tr>' +
            '<th>合计</th>' +
            '<td colspan="11"></td>' +
            '<td>'+carpriceFeeSum.toFixed(2)+'</td>' +
            '<td>'+purchasetaxFeeSum.toFixed(2)+'</td>' +
            '<td>'+insuranceFeeSum.toFixed(2)+'</td>' +
            '<td>'+otherFeeSum.toFixed(2)+'</td>' +
            '<td>'+investTotalSum.toFixed(2)+'</td>' +
            '<td>'+finTotalSum.toFixed(2)+'</td>' +
            '<td colspan="2"></td>' +
            '<td>'+rentSum.toFixed(2)+'</td>' +
            '<td colspan="4"></td>' +
            '<td>'+marginSum.toFixed(2)+'</td>' +
            '<td>'+equFinAmountSum.toFixed(2)+'</td>' +
            '<td>'+equRentSum.toFixed(2)+'</td>' +
            '<td>'+factorgeSum.toFixed(2)+'</td>' +
            '<td>'+serviceChargeSum.toFixed(2)+'</td>' +
            '<td colspan="1"></td>' +
            '<td>'+surplusRentSum.toFixed(2)+'</td>' +
            '<td colspan="5"></td>' +
            '</tr>';
        $('#equ_mor_charge_table tbody').append(html);
    };

    //请求的参数
    function dataTableParams($scope){
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchEquMorApply = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetEquMorApply = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

    $scope.inputEquMorApply = function(){
        var rows =  $scope.dataTable.getRows('contractId');//主键
        if(rows.length < 1)
            modalAlert($modal,'请您选择需要申请的合同信息');
        else {
            for(var i in rows){
                var row = rows[i];
                if(CommonStringUtils.isNotTrimBlank(row['equMorTaskNo'])){
                    modalAlert($modal,'合同号:' + row['contNo'] + ',已抵押,不可再次进行抵押');
                    return;
                }
            }
            $location.path('/app/asset_equ_mor_apply_input').search({applyData:JSON.stringify(rows)});
        }
    }

    $scope.detailEquMorDetail = function (contractId) {
        var data = $scope.dataTable.getRow(contractId,'contractId')
        if(isNotUndefinedNull(data.equMorTaskNo)){
            $location.path('/app/asset_equ_mor_apply_detail').search({'equMorTaskNo':data.equMorTaskNo,type:'list'});
        }else{
            toaster_info('该条信息未抵押',toaster);
        }
    }
    //导出数据表
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.asset,CommonServiceType.excelTypes.one,
            'equ_mor_apply/findEquMorOtherApplyVosByPage',dataTableParams($scope));
    }

    //导出抵押申请一览数据
    $scope.exportExcel2 = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.asset,CommonServiceType.excelTypes.two,
            'equ_mor_apply/findEquMorOtherApplyVosByPage',dataTableParams($scope));
    }

}])
;