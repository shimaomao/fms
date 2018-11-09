/**
 * Created by yanfengbo on 2018-05-17.
 */
app.controller('renewal_register_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {
    $scope.maxDate = {maxDate:'#F{$dp.$D(\'validEndDate\')}'};
    $scope.minDate = {minDate:'#F{$dp.$D(\'validStartDate\')}'};

    //查询参数
    $scope.params = setData.getter();
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
            url : 'renewal_register/findRenewalRegistersByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'renewal_register_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('renewalRegisterId'),
            defaultDetail('contNo','detailRenewalRegister','合同编号','20%',$compile,$scope,'renewalRegisterId'),
            //{title:'合同编号',data:'contNo',width:'20%'},
            {title:'出租人',data:'lessor',width:'20%'},
            {title:'承租人',data:'name',width:'20%'},
            {title:'续保任务状态',data:'renewalStatus',width:'20%',
                render:function(data){
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data)
                }
            },
            {title:'担保人',data:'guaranteePersList',width:'20%',
            render:function (data) {
                var str='';
                for(var i in data){
                    if(i==data.length-1){
                        var info = data[i].name+'-'+data[i].mobileNo;
                        str+=info;
                    }else{
                        var info = data[i].name+'-'+data[i].mobileNo+',';
                        str+=info;
                    }
                }
                return str;
            }
            },
            {title:'联系方式',data:'mobileNo',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'车牌号',data:'vehicleLicenseNo',width:'20%'},
            {title:'业务类型',data:'serviceType',width:'20%',
                render:function(data){
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data)
                }
            },
            {title:'融资期限',data:'finPeriodType',width:'20%'},
            {title:'保险融资金额',data:'contFinDetailList',width:'20%',
                render:function (data) {
                    var str='';
                    for(var i in data){
                        if(i == data.length - 1){
                            var info = data[i].finItemYear+'-'+data[i].finAmount;
                            str+=info
                        }else{
                            var info = data[i].finItemYear+'-'+data[i].finAmount+',';
                            str+=info
                        }
                    }
                    return str;
                }
            },
            {title:'续保押金(元)',data:'renewalDeposit',width:'20%'},
            {title:'当前投保公司',data:'insCompName',width:'20%'},
            {title:'当前投保金额(元)',data:'insFee',width:'20%'},
            // {title:'盗抢险投保渠道',data:'theftInsuranceType',width:'20%',
            // render:function (data) {
            //     return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.theftInsuranceType,data)
            // }
            // },
            {title:'实际用车人',data:'driver',width:'20%'},
            {title:'实际用车人手机号',data:'driverMobno',width:'20%'},
            {title:'当前节点用户',data:'presentUser',width:'20%'},
            {title:'保险失效日',data:'renewalDeadlineDate',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope){
       /* params = {};
        params.contNo = $scope.contNo;
        params.name = $scope.name;
        params.vinNo = $scope.vinNo;
        params.serviceType = $scope.serviceType;*/
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
   //业务类型
    $scope.serviceTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr);

    $scope.searchRenewalRegister = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetRenewalRegister = function(){
        /*$scope.contNo = "";
        $scope.name = "";
        $scope.vinNo = "";
        $scope.serviceType = "";*/
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.uploadRenewalRegister = function(){
        var rowsIds=$scope.dataTable.getRows()
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要上传的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时上传一条数据！');
        else if(rowsIds[0].renewalStatus != '0500'){
            modalAlert($modal,'该续保信息不允许续保');
            return false;
            $scope.submit = false;
        }
        else{
            $location.path('app/insurance_renewal_register_save').search({'frameTitle':'续保上传','operate':'save','renewalContVehinsId':rowsIds[0].renewalContVehinsId,'renewalRegisterId':rowsIds[0].renewalRegisterId,'contNo':rowsIds[0].contNo});
        }
    }



    //详情
    $scope.detailRenewalRegister = function(renewalRegisterId){
        var data = $scope.dataTable.getRow(renewalRegisterId,'renewalRegisterId')
        if(isNotUndefinedNull(data.renewalContVehinsId)){
            $location.path('/app/insurance_renewal_register_detail').search({'renewalTaskNo':data.renewalTaskNo});
        }else{
            toaster_info('当前保险信息无法查看',toaster);
        }
    }

    //导出数据表
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.insurance,CommonServiceType.excelTypes.one,
            'renewal_register/findRenewalRegistersByPage',dataTableParams($scope));
    }


}])
;