/**
 * Created by qinmuqiao on 2018-10-26.
 */
app.controller('equ_mor_repay_detail_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','setData','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,setData,$location,$timeout) {
    //查询参数
    $scope.params = setData.getter();
    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.msg = $location.search()['msg'];
        if ($scope.msg) {
            toaster_success($scope.msg, toaster);
        }
    }, 100);

    $scope.equRepayStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.equRepayStatus);
    $scope.managementList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.management);



    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'equ_mor_repay_detail/selectEquMorRepayDetailVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'equ_mor_repay_detail_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('equMorRepayDetailId'),
            // defaultDetail('equMorTaskNo','detailEquMorRepayDetail','资方抵押任务号','20%',$compile,$scope,'equMorRepayDetailId'),
            {title:'资方抵押任务号',data:'equMorTaskNo',width:'20%'},
            {title:'客户合同编号',data:'clientContNo',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'承租人',data:'tenantUser',width:'20%'},
            {title:'资方名称',data:'management',width:'20%',
                render:function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.management, data);
                }},
            {title:'期数',data:'period',width:'5%'},
            {title:'应还日期',data:'repayDate',width:'20%'},
            {title:'租金',data:'rent',width:'20%'},
            {title:'还款状态',data:'equRepayStatus',width:'20%',
                render:function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.equRepayStatus, data);
                }},
            {title:'还款日期',data:'payUpdateDate',width:'20%'},
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


    $scope.searchEquMorRepayDetail = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetEquMorRepayDetail = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

    //跳转到开票页面
    $scope.invoice = function(){
        var rows = $scope.dataTable.getRows();
        if(rows.length < 1){
            modalAlert($modal,'请您选择需要更新的数据');
            return;
        }
        for(var i in rows){
            if(rows[i].payUpdateDate) {
                modalAlert($modal,'当前选择包含已还款数据，请重新选择');
                return;
            }
        }
        $location.path('app/asset_equ_mor_repay_detail_invoice').search({'equMorRepayDetails':JSON.stringify(rows)});
    }

    $scope.detailEquMorRepayDetail = function(equMorRepayDetailId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/asset/equ_mor_repay_detail/equ_mor_repay_detail_detail.html'+getCacheTime(),
            controller: 'equ_mor_repay_detail_detail_controller',
            resolve:{
                equMorRepayDetail : function (){ return $scope.dataTable.getRow(equMorRepayDetailId,'equMorRepayDetailId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.asset,CommonServiceType.excelTypes.one,
            'equ_mor_repay_detail/selectEquMorRepayDetailVosByPage',dataTableParams($scope));
    }

}])
;