/**
 * Created by qiaomengnan on 2018-05-30.
 */
app.controller('equ_mor_detail_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData',function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {
    //查询参数
    $scope.params = setData.getter();
    //还款状态
    $scope.paymentStsList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.paymentSts);
    //抵押状态
    $scope.mortgageStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.mortgageStatus);

    $timeout(function () {
        var msg = $location.search()['msg'];
        if(CommonObjectUtils.isExist(msg)) {
            toaster_success(msg, toaster);
            $location.search({msg:null});
        }
    })
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'equ_mor_detail/findEquMorDetailVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'equ_mor_detail_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('equMorDetailId'),
            {title:'合同编号',data:'mainContNo',width:'20%'},
             {title:'出租人',data:'lessor',width:'20%'},
             defaultDetail('lessee','detailEquMorDetail','承租人','20%',$compile,$scope,'equMorDetailId'),
             //{title:'承租人',data:'lessee',width:'20%'},
             {title:'车架号',data:'vinNo',width:'20%'},
             {title:'业务类型',data:'serviceType',width:'20%',
                render:function(data){
                   return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data)
                }
            },
            {title:'抵押状态',data:'mortgageStatus',width:'20%',
                render:function(data){
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.mortgageStatus,data)
                }
            },
            {title:'解押任务号',data:'equRelTaskNo',width:'20%'},
            {title:'解押任务状态',data:'reliefStatus',width:'20%',
                render: function(data){ return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data); }
            },
            {title:'解押当前节点用户',data:'presentUser',width:'20%'},
            {title:'还款状态',data:'paymentSts',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.paymentSts,data);
                }
            },
            {title:'融资期限',data:'finPeriodType',width:'20%'},
            {title:'经销商',data:'salesName',width:'20%'},
            {title:'资方',data:'management',width:'20%',
            render:function (data) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.management,data)
            }
            },
            {title:'抵押地',data:'mortgageAddr',width:'20%'},
            {title:'抵押日期',data:'mortgageDate',width:'20%'},
            {title:'抵押权人',data:'mortgagee',width:'20%'},
            {title:'还款日',data:'repayDate',width:'20%'},
            {title:'租金(元)',data:'rent',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    $scope.serviceTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr);

    //请求的参数
    function dataTableParams($scope){
        /*params = {};
        params.mainContNo = $scope.mainContNo;
        params.vinNo = $scope.vinNo;
        params.lessee = $scope.lessee;
        params.serviceType = $scope.serviceType;*/
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchEquMorDetail = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetEquMorDetail = function(){
        /*params.mainContNo = "";
        $scope.vinNo = "";
        $scope.lessee = "";
        $scope.serviceType = "";*/
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveEquMorDetail = function(){
        var rows = $scope.dataTable.getRows();
        for(var i in rows){
            if(rows[i].mortgageStatus != '0'){
                modalAlert($modal,'非抵押状态不能提交!');
                return false;
                $scope.submit = false;
            }
        }
        var rowsIds =  $scope.dataTable.getRowsIds('equMorDetailId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要解押的数据！');
        else
            $location.path('/app/asset_equ_mor_detail_apply').search({'Ids':rowsIds});
    }

    $scope.detailEquMorDetail = function(equMorDetailId){
        var rowsId =  $scope.dataTable.getRow(equMorDetailId,'equMorDetailId')
        $location.path('/app/asset_equ_mor_detail_detail').search({'equRelTaskNo':rowsId.equRelTaskNo,'mortgageStatus':rowsId.mortgageStatus});
    }

    //导出数据表
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.asset,CommonServiceType.excelTypes.one,
            'equ_mor_detail/findEquMorDetailVosByPage',dataTableParams($scope));
    }

}])
;