/**
 * Created by yangyiquan on 2018-04-28.
 */
app.controller('apply_list_select_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$localStorage','setData',function ($scope, $http, $modal, toaster,$compile,$location,$localStorage,setData) {
    $scope.approveMaxDate = {maxDate:'#F{$dp.$D(\'approveEndDate\')}'};
    $scope.approveMinDate = {minDate:'#F{$dp.$D(\'approveStartDate\')}'};

    $scope.submitMaxDate = {maxDate:'#F{$dp.$D(\'submitEndDate\')}'};
    $scope.submitMinDate = {minDate:'#F{$dp.$D(\'submitStartDate\')}'};


    //查询参数
    $scope.params = setData.getter();
    //订单状态
    $scope.bizStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.bizStatus);
    //申请类型
    $scope.applyTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.applyType);
    //业务类型
    $scope.licenseAttrList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr);
    //风控审批结果
    $scope.windcontrApprovalStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.windcontrApprovalStatus);
    //终审审批结果
    $scope.finalApprovalStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.finalApprovalStatus);
    //订单状态
    $scope.applyStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.applyStatus);
    //导出权限
    $scope.exportFlag = true;
    //是否显示审核人员
    $scope.hasApproveUser = false;
    //主页订单状态大类初始值
    if(CommonObjectUtils.isExist($location.search()['applyStatus'])){
        $scope.params.applyStatus = $location.search()['applyStatus'];
    }
    //主页查询方式
    if(CommonObjectUtils.isExist($location.search()['searchType'])){
        $scope.params.searchType = $location.search()['searchType']; //不为空则代表是主页跳转过来的，1：最近30天、2：本月、3：当日
    }
    //主页传递的订单提出开始日
    if(CommonObjectUtils.isExist($location.search()['submitStartTime'])){
        $scope.params.submitStartTime = $location.search()['submitStartTime']; //订单提出日
    }
    //获取初审人员
    $http.get('overdue_cstm/findAssignUsers').success(function(data){
        if (data.code == Response.successCode){
            $scope.sysUserList = data.data;
        }else{
            modalAlert($modal,data.message);
        }
    });

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'apply/findApplyListByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'apply_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('applyNo'),
            defaultDetail('applyNo','detailApply','申请编号','10%',$compile,$scope,'applyNo'),
            {title:'出租人',data:'groupName',width:'10%'},
            {title:'承租人',data:'name',width:'10%'},
            {title:'申请类型',data:'applyType',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.applyType,data);
                }
            },
            {title:'车辆类型',data:'vehicleForm',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleForm,data);
                }
            },
            {title:'客户证件号码',data:'certifNo',width:'10%'},
            // {title:'订单提出人',data:'applyUser',width:'10%'},
            {title:'业务经理',data:'applyUserName',width:'10%'},
            {title:'订单提出机构',data:'applyGroupName',width:'10%'},
            {title:'当前节点用户',data:'presentUser',width:'10%'},
            {title:'当前节点用户名',data:'presentUserName',width:'10%'},
            {title:'首次提交日期',data:'applyFirsbtDate',width:'10%'},
            {title:'提交日期',data:'applySubmitDate',width:'10%'},
            {title:'订单状态',data:'bizStatus',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data);
                }
            },
            {title:'产品名称',data:'productName',width:'10%'},
            {title:'车型名称',data:'vehicleName',width:'10%'},
            {title:'业务类型',data:'licenseAttr',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data);
                }
            },
            {title:'融资期限',data:'finPeriodType',width:'10%'},
            {title:'手续费收取方式',data:'chargePayMode',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.chargePayMode,data);
                }
            },
            {title:'手续费比例',data:'chargeRate',width:'10%'},
            {title:'手续费',data:'charge',width:'10%'},
            {title:'首付比例',data:'initPerc',width:'10%'},
            {title:'首付金额',data:'initAmount',width:'10%'},
            {title:'投资总额',data:'investTotal',width:'10%'},
            {title:'融资金额',data:'finTotal',width:'10%'},
            {title:'订单租金',data:'rent',width:'10%'},
            {title:'保证金费用',data:'deposit',width:'10%'},
            {title:'风控审批结果',data:'windcontrApprovalStatus',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.windcontrApprovalStatus,data);
                }
            },
            {title:'终审审批结果',data:'finalApprovalStatus',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.finalApprovalStatus,data);
                }
            },
            {title:'风控初审人员',data:'approveUser',width:'10%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        var params = $scope.params;
        /*params.applyNo = $scope.applyNo;
        params.name = $scope.name;
        params.groupDistrict = $scope.groupDistrict;
        params.applyType = $scope.applyType;
        params.bizStatus = $scope.bizStatus;
        params.licenseAttr = $scope.licenseAttr;
        params.guarantee = $scope.guarantee;
        params.submitStartTime = $scope.submitStartTime; //订单提出日区间
        params.submitEndTime = $scope.submitEndTime; //订单提出日区间
        params.approveStartTime = $scope.approveStartTime; //审批通过日区间
        params.approveEndTime = $scope.approveEndTime; //审批通过日区间*/
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);

    //只能风控看到风控初审人员
    var roles2 = $localStorage.user.roles;
    var flagg = false;
    setColumnVisible($scope.dataTable,29,flagg);
    for (var i in roles2) {
        if (roles2[i].role == CommonCodeUtils.role.FK101 || roles2[i].role == CommonCodeUtils.role.FK102) {
            flagg =true;
        }
    }
    setColumnVisible($scope.dataTable,29,flagg);

    $scope.hasApproveUser = flagg;

    //查询
    $scope.searchApplyList = function(){
        $scope.dataTable.fnDraw(true);
    }

    //重置
    $scope.resetApplyList = function(){
        $scope.params = {};
        /*$scope.applyNo = "";
        $scope.name = "";
        $scope.groupDistrict = "";
        $scope.applyType = "";
        $scope.bizStatus = "";
        $scope.licenseAttr = "";
        $scope.guarantee = "";
        $scope.submitStartTime = ""; //订单提出日区间
        $scope.submitEndTime = ""; //订单提出日区间
        $scope.approveStartTime = ""; //审批通过日区间
        $scope.approveEndTime = ""; //审批通过日区间*/
        $scope.dataTable.fnDraw(true);//刷新
    }

    //申请详情查看
    $scope.detailApply = function(applyNo){
        var apply =  $scope.dataTable.getRow(applyNo,'applyNo');
        $location.path("app/prebiz_apply_input_detail").search({'applyNo':apply.applyNo,'applyType':apply.applyType,'type':'apply','bizStatus':apply.bizStatus});
    }

    //导出权限控制
    var roles =  $localStorage.user.roles;
    for(var i in roles){
        if(roles[i].role == CommonCodeUtils.role.QY || roles[i].role == CommonCodeUtils.role.YW){
            $scope.exportFlag = false;
        }
    }
}])
;