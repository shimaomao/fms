/**
 * Created by lijunjun on 2018-05-16.
 */
app.controller('overdue_cstm_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','setData', function ($scope, $http, $modal, toaster,$compile,$location,setData) {
    //查询参数
    $scope.params = setData.getter();

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
            url : 'overdue_cstm/findOverdueCstmsByPage',
            type:"GET"
        },
        //table的html id
        dataTableId:'overdue_cstm_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('overdueCstmId'),
            defaultDetail('cstmName','overdueDetail','客户姓名','20%',$compile,$scope, 'overdueCstmId'),
            // {title:'客户姓名',data:'cstmName',width:'20%'},
            {title:'出租人',data:'groupName',width:'20%'},
            {title:'证件号码',data:'certifNo',width:'20%'},
            // defaultDetail('cstmName','detailOverdueCstm','客户姓名','20%',$compile,$scope),
            {title:'合同号',data:'contNo',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'车辆类型',data:'vehicleForm',width:'20%',
                render:function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleForm, data);
                }
            },
            {title:'合同生效日期',data:'contractValidDate',width:'20%'},
            {title:'发动机号',data:'engineNo',width:'20%'},
            {title:'车牌号',data:'vehicleLicenseNo',width:'20%'},
            {title:'品牌',data:'vehBrandCodeName',width:'20%'},
            {title:'车型',data:'vehicleCodeName',width:'20%'},
            {title:'车辆配置描述',data:'vehicleComment',width:'20%'},
            {title:'颜色',data:'color',width:'20%'},
            {title:'客户初登日期',data:'cstmFirstOverdueDate',width:'20%'},
            {title:'合同初登日期',data:'contFirstOverdueDate',width:'20%'},
            {title:'客户当前逾期天数',data:'overdueDays',width:'20%'},
            {title:'客户当前逾期期数',data:'overduePeriods',width:'20%'},
            {title:'客户当前逾期本金',data:'overduePrincipal',width:'20%'},
            {title:'客户当前逾期租金',data:'overdueRent',width:'20%'},
            {title:'客户当前逾期罚息',data:'overdueAmount',width:'20%'},
            {title:'合同当前逾期天数',data:'contOverdueDays',width:'20%'},
            {title:'合同当前逾期期数',data:'contOverduePeriods',width:'20%'},
            {title:'合同当前逾期本金',data:'contOverduePrincipal',width:'20%'},
            {title:'合同当前逾期租金',data:'contOverdueRent',width:'20%'},
            {title:'合同当前逾期罚息',data:'contOverdueAmount',width:'20%'},
            {title:'当前是否逾期',data:'overdueFlag',width:'20%',
                render:function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.overdueFlag, data);
                }
            },
            {title:'催收类型',data:'assignmentType',width:'20%',
                render:function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.assignmentType, data);
                }
            },
            {title:'分配人员账号',data:'assignUser',width:'20%'},
            {title:'任务处理状态',data:'assignmentSts',width:'20%',
                render:function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.assignmentSts,data);
                }
            }
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    };

    //请求的参数
    function dataTableParams($scope){
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchOverdueCstm = function(){
        $scope.dataTable.fnDraw(true);
    };

    $scope.resetOverdueCstm = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    };

    $scope.assign = function(){
        var rows = $scope.dataTable.getRows();
        if (rows.length < 1){
            modalAlert($modal,'请选择需要分配催收任务的数据！');
        } else {
            var assignmentSts=rows[0].assignmentSts;
            if(assignmentSts==CommonCodeUtils.assignmentSts.payed){
                modalAlert($modal,'该客户已还款，请重新选择！');
            }
            else {
                $location.path('/app/postbiz_overdue_rwfp').search({
                    'overdueCstmId': rows[0].overdueCstmId,

                });
            }
        }
    };


    $scope.saveOverdueCstm = function(){
        var rows = $scope.dataTable.getRows();
        if (rows.length < 1){
            modalAlert($modal,'请至少选择一条数据！');
        } else {
            $location.path('/app/postbiz_overdue_cstm_modify').search({
                'overdueCstmId': rows[0].overdueCstmId,
                'overdueContId': rows[0].overdueContId,
                'certifNo': rows[0].certifNo,
                'contNo': rows[0].contNo,
            });
        }
    };

    // 导出
    $scope.exportOverdueCstm = function () {
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.postbiz, CommonServiceType.excelTypes.one,
            'overdue_cstm/findOverdueCstmsByPage', dataTableParams($scope));
    };

    // 催收函生成
    $scope.collectionLetterDownload = function () {
        var rows = $scope.dataTable.getRows();
        if (rows.length < 1){
            modalAlert($modal,'请至少选择一条数据！');
        } else {
            $http.post('overdue_cstm/collectionLetterDownload', rows[0]).success(function (data) {
                if (data.code == Response.successCode){
                    //pdf生成
                    console.log('filePath',data.data);
                    window.parent.open('file/downloadFile?fileCompletePath='+data.data.filePath+'&fileName='+data.data.fileName);
                }else{
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
        }
    };

    // 律师函生成
    $scope.lawyerLetterDownload = function () {
        var rows = $scope.dataTable.getRows();
        if (rows.length < 1){
            modalAlert($modal,'请至少选择一条数据！');
        } else {
            $http.post('overdue_cstm/lawyerLetterDownload', rows[0]).success(function (data) {
                if (data.code == Response.successCode){
                    //pdf生成
                    console.log(data.data);
                    window.parent.open('file/downloadFile?fileCompletePath='+data.data.filePath+'&fileName='+data.data.fileName);
                }else{
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
        }
    };

    //查看逾期详情
    $scope.overdueDetail = function (overdueCstmId) {
        $location.path('app/postbiz_overdue_cstm_modify').search({overdueCstmId:overdueCstmId,detail:true});
        /*if(CommonStringUtils.isTrimBlank(overdueCstmId)){
            modalAlert($modal,'请选择逾期客户');
        } else {
            var id = overdueCstmId;
            var url = 'app.postbiz_overdue_cstm_modify?overdueCstmId=' + overdueCstmId
                + '&detail=true&isTab=true';
            var title = '逾期详情';
            var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
            if(window.parent.addTab){
                window.parent.addTab(html);
            }
        }*/
    };

}])
;