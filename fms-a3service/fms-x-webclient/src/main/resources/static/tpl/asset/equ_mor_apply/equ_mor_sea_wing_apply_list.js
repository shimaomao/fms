/**
 * Created by qiaomengnan on 2018-05-30.
 */
app.controller('equ_mor_sea_wing_apply_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {

    $timeout(function () {
        var msg = $location.search()['msg'];
        if(CommonObjectUtils.isExist(msg)) {
            toaster_success(msg, toaster);
            $location.search({msg:null});
        }
    })
    //查询参数
    $scope.params = setData.getter();

    //抵押状态
    $scope.mortgageStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.mortgageStatus);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'equ_mor_apply/findEquMorSeaWingApplyVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'equ_mor_charge_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contractId'),
            defaultDetail('contNo','detailEquMorDetail','合同号','20%',$compile,$scope,'contractId'),
            {title:'品牌',data:'vehBrandCodeName',width:'20%'},
            {title:'业务类型',data:'licenseAttr',width:'20%',render: function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data)
                }},
            {title:'出租人',data:'belongGroupName',width:'20%'},
            {title:'承租人',data:'lessee',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'融资金额',data:'finTotal',width:'20%'},
            {title:'融资期限',data:'finPeriodType',width:'20%'},
            {title:'放款日期',data:'contractValidDate',width:'20%'},
            {title:'租金',data:'rent',width:'20%'},
            {title:'剩余期数',data:'surplusPeriod',width:'20%'},
            {title:'剩余租金',data:'surplusRent',width:'20%'},
            {title:'抵押任务号',data:'equMorTaskNo',width:'20%'},
            {title:'资方',data:'management',width:'20%',render: function(data){ return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.management,data); }},
            {title:'抵押任务状态',data:'mortgageServStatus',width:'20%',render: function(data){ return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data); }},
            {title:'抵押状态',data:'mortgageStatus',width:'20%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.mortgageStatus,data)
                }
            },
            {title:'当前节点用户',data:'presentUser',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    $scope.callback = function (data) {
        //var data = $scope.dataTable;
        var tableData = data.data;
        var finTotalSum = 0,rentSum=0,surplusRentSum=0;
        for(var i=0;i<tableData.length;i++){
            finTotalSum = tableData[i].finTotal*1 + finTotalSum;
            rentSum = tableData[i].rent*1 + rentSum;
            surplusRentSum = tableData[i].surplusRent*1 + surplusRentSum;
        }
        var html = '<tr>' +
            '<th>合计</th>' +
            '<td colspan="6"></td>' +
            '<td>'+finTotalSum.toFixed(2)+'</td>' +
            '<td colspan="2"></td>' +
            '<td>'+rentSum.toFixed(2)+'</td>' +
            '<td colspan="1"></td>' +
            '<td>'+surplusRentSum.toFixed(2)+'</td>' +
            '<td colspan="5"></td>' +
            '</tr>';
        $('#equ_mor_charge_table tbody').append(html);
    };
    //请求的参数
    function dataTableParams($scope){
       /* params = {};
        params.contNo = $scope.contNo;
        params.gtSurplusPeriod = $scope.gtSurplusPeriod;
        params.ltSurplusPeriod = $scope.ltSurplusPeriod;*/
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
        /*$scope.contNo = "";*/
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.inputEquMorApply = function(){
        var rows =  $scope.dataTable.getRows();
        if(rows.length < 1)
            modalAlert($modal,'请您选择需要申请的合同信息');
        else if(rows.length > 1)
            modalAlert($modal,'只能同时申请一条合同信息');
        else {
            var row = rows[0];
            if(CommonStringUtils.isNotTrimBlank(row['equMorTaskNo'])){
                modalAlert($modal,'合同号:' + row['contNo'] + ',已抵押,不可再次进行抵押');
                return;
            }
            $location.path('/app/asset_equ_mor_sea_wing_apply_input').search({'contNo':row['contNo']})
        }

    }

    $scope.detailEquMorCharge = function(equMorChargeId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/asset/equ_mor_charge/equ_mor_charge_detail.html'+getCacheTime(),
            controller: 'equ_mor_charge_detail_controller',
            resolve:{
                equMorCharge : function (){ return $scope.dataTable.getRow(equMorChargeId,'equMorChargeId') }
            }
        });
        rtn.result.then(function (status) {
        },function(){
        });
    }

    $scope.detailEquMorDetail = function (contractId) {
        var data = $scope.dataTable.getRow(contractId,'contractId')
        if(isNotUndefinedNull(data.equMorTaskNo)){
            $location.path('/app/asset_equ_mor_sea_wing_apply_list_detail').search({'equMorTaskNo':data.equMorTaskNo,type:'list'});
        }else{
            toaster_info('该条信息未抵押',toaster);
        }
    }


}])
;