/**
 * Created by yangyiquan on 2018-04-28.
 */
app.controller('basic_change_list_controller', ['$scope', '$http', '$modal', 'toaster', '$compile', '$location', '$localStorage','setData', function ($scope, $http, $modal, toaster, $compile, $location, $localStorage,setData) {

    //查询参数
    $scope.params = setData.getter();
    // 从其他画面跳转到的弹出信息显示
    $scope.type = $location.search()['type'];
    $scope.msg = $location.search()['msg'];
    if ($scope.type == 'submit') {
        toaster_success($scope.msg, toaster);
    }
    //订单状态
    $scope.bizStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.bizStatus);
    //申请类型
    $scope.applyTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.applyType);
    //业务类型
    $scope.licenseAttrList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr);
    //导出权限
    $scope.exportFlag = true;
    //展期任务信息
    $scope.deferTask = {};
    //参数配置
    $scope.dataTableProperties = {
        //ajax url 和类型
        dataTableAjax: {
            url: 'basic_change_task/findContractListByPage',
            type: "GET",
        },
        //table的html id
        dataTableId: 'contract_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contractId'),
            defaultDetail('contNo', 'detailContract', '合同编号', '10%', $compile, $scope, 'contractId'),
            // {title: '合同编号', data: 'contNo', width: '10%'},
            {title: '申请编号', data: 'applyNo', width: '10%'},
            {title: '出租人', data: 'groupName', width: '10%'},
            {title: '承租人', data: 'name', width: '10%'},
            {title: '车架号', data: 'vinNo', width: '10%'},
            {title: '车牌号', data: 'vehicleLicenseNo', width: '10%'},
            {
                title: '申请类型', data: 'applyType', width: '10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.applyType, data);
                }
            },
            {
                title: '业务类型', data: 'licenseAttr', width: '10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr, data);
                }
            },
            {
                title: '车辆类型', data: 'vehicleForm', width: '10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleForm, data);
                }
            },
            // {title: '当前节点用户', data: 'presentUser', width: '10%'},
            {title: '合同生效日期', data: 'contractValidDate', width: '10%'},
            {title: '车辆品牌', data: 'vehBrandCodeName', width: '10%'},
            {title: '车型', data: 'vehicleCodeName', width: '10%'},
            {title: '产品名称', data: 'productName', width: '10%'},
            {title: '融资期限', data: 'finPeriodType', width: '10%'},
            {title: '申请金额', data: 'investTotal', width: '10%'},
            {title:'首付金额',data:'initAmount',width:'10%'},
            {title:'融资金额',data:'finTotal',width:'10%'},
            {title:'贷款利息',data:'loanInterest',width:'10%'},
            {title:'保证金',data:'deposit',width:'10%'},
            {title:'租金',data:'rent',width:'10%'},
            {title:'尾付金额',data:'finalAmount',width:'10%'},
            {title:'年供金额',data:'annualSupplyAmount',width:'10%'},
            {title:'还款状态',data:'paymentSts',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.paymentSts,data);
                }
            },
            {title: '客户证件号码', data: 'certifNo', width: '10%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    };

    //请求的参数
    function dataTableParams($scope) {
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties, dataTableParams, $scope);


    $scope.searchContractList = function () {
        $scope.dataTable.fnDraw(true);
    };

    $scope.resetContractList = function () {
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    };


    //导出数据表
    $scope.exportExcel = function () {
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.prebiz, CommonServiceType.excelTypes.one,
            'contract/findContractListByPage', dataTableParams($scope));
    };

    //导出权限控制
    var roles = $localStorage.user.roles;
    for (var i in roles) {
        if (roles[i].role == CommonCodeUtils.role.QY || roles[i].role == CommonCodeUtils.role.YW) {
            $scope.exportFlag = false;
        }
    }

    //基本信息更改
    $scope.basicChange = function () {
        var rows = $scope.dataTable.getRows();
        if (rows.length < 1) {
            modalAlert($modal, "请您选择需要修改的信息！");
        } else if (rows.length > 1) {
            modalAlert($modal, "只能同时修改一条数据！");
        } else {
            $http.post('basic_change_task/checkBasicChangeTask', rows[0]).success(function (data) {
                if (data.code == Response.successCode){
                    if (rows[0].applyType == CommonCodeUtils.applyType.person){
                        //个人基本信息修改页面
                        $location.path('app/postbiz_person_basic_change_save').search({applyNo:rows[0].applyNo,applyType:rows[0].applyType, type:'list'});
                    } else {
                        //企业基本信息修改页面
                        $location.path('app/postbiz_company_basic_change_save').search({applyNo:rows[0].applyNo,applyType:rows[0].applyType, type:'list'});
                    }
                } else{
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
        }
    };

    //承租人变更
    $scope.changeUser = function(type){
        var rows = $scope.dataTable.getRows();
        console.log(rows);
        if (rows.length < 1) {
            modalAlert($modal, "请您选择需要修改的信息！");
        } else if (rows.length > 1) {
            modalAlert($modal, "只能同时修改一条数据！");
        } else {
            //基本信息修改页面
            var obj = {
                applyNoParams:rows[0].applyNo,
                contNo:rows[0].contNo,
                serviceType:type,
                type:'contract',
                contractDate:rows[0].contractDate,
                bizStatus:rows[0].bizStatus
            };
            $http.get('change_lessee_task/findChangeLesseeTaskByContNo?contNo='+rows[0].contNo).success(function (data) {
                $scope.changeLesseeTask = data.data;
                if(isNotUndefinedNull($scope.changeLesseeTask)){
                    modalAlert($modal, "该条合同有正在进行中的变更承租人任务！");
                }else{
                    $location.path('app/postbiz_basic_change_save').search(obj);
                }
            });
        }
    };
    
    //展期任务申请
    $scope.deferTaskApply = function () {
        var rows = $scope.dataTable.getRows();
        if (rows.length < 1) {
            modalAlert($modal, "请您选择需要修改的信息！");
        } else if (rows.length > 1) {
            modalAlert($modal, "只能同时修改一条数据！");
        }
        $scope.deferTask.contNo = rows[0].contNo;
        //获取展期合同信息
        $http.post('defer_task/findDeferTaskByTaskNo',$scope.deferTask).success(function(data){
            if (data.code == Response.successCode){
                $scope.deferTask1 = data.data;
                if(isNotUndefinedNull($scope.deferTask1)){
                    modalAlert($modal, "该条合同已经进行过展期！");
                }else if (rows[0].finalAmount == 0){
                    modalAlert($modal, "尾付金额为0不能展期");
                } else {
                    //跳转到申请页面
                    $location.path('app/postbiz_defer_task_apply_page').search({'contNo':rows[0].contNo});
                }
            } else{
                modalAlert($modal,data.message);
            }
        });

    }

    //增加保证金
    $scope.depositChange = function () {
        var rows = $scope.dataTable.getRows();
        if (rows.length < 1) {
            modalAlert($modal, "请您选择需要申请的信息！");
        } else if (rows.length > 1) {
            modalAlert($modal, "只能同时申请一条数据！");
        }
        $scope.selectedContNo = rows[0].contNo;
        //获取保证变更任务信息
        $http.get('deposit_change_task/findDepositChangeTaskByContNo?contNo=' + $scope.selectedContNo).success(function(data){
            $scope.flag = data.data;
            if(!$scope.flag){
                modalAlert($modal, "该条合同有正在进行中的保证金变更申请！");
            }else {
                //跳转到申请页面
                $location.path('app/postbiz_deposit_change_apply').search({'cont_no':rows[0].contNo,'type':'baisc_change'});
            }
        });
    }

    //合同详情查看
    $scope.detailContract = function(contractId){
        var contract =  $scope.dataTable.getRow(contractId,'contractId')
        $location.path("app/prebiz_apply_input_detail").search(
            {
                'applyNo':contract.applyNo
                ,'contNo':contract.contNo
                ,'applyType':contract.applyType
                ,'type':'basicchange'
                ,'contractDate':contract.contractDate
                ,'bizStatus':contract.bizStatus
                ,'contractValidDate':contract.contractValidDate
                ,'contractRequestDate':contract.contractRequestDate
            });
    }

}]);
app.directive('buttonClick', ['$parse',function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attr) {
            var $this;
            $(element).click(function (e) {
                $this = $(this).next();
                $this.css({'display':'block'});
                e.stopPropagation();
                $(document).click(function () {
                    $this.css({'display':'none'});
                });
            });
        }
    };
}]);