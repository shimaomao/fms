/**
 * Created by lijunjun on 2018-09-12.
 */
app.controller('lawsuit_task_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location','setData',function ($scope, $http, $modal, toaster,$compile,$location,setData) {
    //查询参数
    $scope.params = setData.getter();
    //订单状态
    $scope.bizStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.bizStatus);
    // 从其他画面跳转到的弹出信息显示
    $scope.type = $location.search()['type'];
    $scope.msg = $location.search()['msg'];
    if ($scope.type == 'submit') {
        toaster_success($scope.msg, toaster);
    }
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'lawsuit_task/findLawsuitTasksByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'lawsuit_task_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('lawsuitTaskNo'),
            defaultDetail('lawsuitTaskNo','detailLawsuitTask','诉讼任务号','20%',$compile,$scope, 'lawsuitTaskNo'),
            {title:'诉讼任务状态',data:'lawsuitTaskStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus, data);
                }
            },
            {title:'当前节点用户',data:'presentUser',width:'20%'},
            {title:'申请编号',data:'applyNo',width:'20%'},
            {title:'合同编号',data:'contNo',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'车牌号',data:'vehicleLicenseNo',width:'20%'},
            {title:'承租人',data:'cstmName',width:'20%'},
            {title:'任务发起人',data:'submitUser',width:'20%'},
            {title:'任务发起时间',data:'submitDate',width:'20%'},
            {title:'诉讼类型',data:'lawsuitType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.lawsuitType, data);
                }
            },
            {title:'诉讼原因',data:'lawsuitReason',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.lawsuitReason, data);
                }
            },
            {title:'派单类型',data:'dispatchType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.dispatchType, data);
                }
            },
            {title:'登记人',data:'registerUserName',width:'20%'}
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope){
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchLawsuitTask = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetLawsuitTask = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

    $scope.exportLawsuitTask = function () {
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.postbiz, CommonServiceType.excelTypes.one,
            'lawsuit_task/findLawsuitTasksByPage', dataTableParams($scope));
    };

    $scope.originatingTask = function () {
        var rows = $scope.dataTable.getRows();
        console.log(rows);
        if (rows.length < 1) {
            $location.path('app/postbiz_lawsuit_task_save').search({type:'list'});
        } else if (rows.length > 1) {
            modalAlert($modal, "只能选择一条数据！");
        } else {
            $scope.lawsuitTaskVo = rows[0];
            $http.post('lawsuit_task/isLawsuitTaskExit', $scope.lawsuitTaskVo.overdueContId).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path('app/postbiz_lawsuit_task_save').search({
                        overdueContId: $scope.lawsuitTaskVo.overdueContId,
                        type:'list'
                    });
                } else {
                    modalAlert($modal,data.message);
                }
            });
        }
    };

    $scope.detailLawsuitTask = function (lawsuitTaskNo) {
        console.log(lawsuitTaskNo);
        $location.path('app/postbiz_lawsuit_task_detail').search({lawsuitTaskNo:lawsuitTaskNo});
    };


}])
;