/**
 * Created by lijunjun on 2018-09-01.
 */
app.controller('collection_task_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','setData', function ($scope, $http, $modal, toaster,$compile, $location,setData) {
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
            url : 'collection_task/findCollectionTasksByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'collection_task_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('collectionTaskId'),
            defaultDetail('collectionTaskNo','detailCollectionTask','任务号','20%',$compile,$scope, 'collectionTaskNo'),
            // {title:'任务号',data:'collectionTaskNo',width:'20%'},
            {title:'任务状态',data:'collectionTaskStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus, data);
                }
            },
            {title:'当前节点用户',data:'presentUser',width:'20%'},
            {title:'承租人',data:'cstmName',width:'20%'},
            {title:'证件类型',data:'certifType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType, data);
                }
            },
            {title:'证件号',data:'certifNo',width:'20%'},
            {title:'数据来源 ',data:'dataSource',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.dataSourceType, data);
                }
            },
            {title:'催收级别',data:'collectionLevel',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.collectionLevel, data);
                }
            },
            {title:'派单类型 ',data:'dispatchType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.dispatchType, data);
                }
            },
            {title:'派单人',data:'dispatchUserName',width:'20%'},
            {title:'任务登记人',data:'registerUserName',width:'20%'},
            {title:'申请上门时间',data:'applyVisitDate',width:'20%'},
            {title:'发起人',data:'applyUser',width:'20%'},
            {title:'发起时间',data:'applyDate',width:'20%'},
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


    $scope.searchCollectionTask = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetCollectionTask = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }
    
    $scope.saveCollectionTask = function () {
        var rows = $scope.dataTable.getRows();
        if (rows.length < 1) {
            $location.path('app/postbiz_collection_task_save').search({type:'list'});
        } else if (rows.length > 1) {
            modalAlert($modal, "只能选择一条数据！");
        } else {
            $scope.collectionTaskVo = rows[0];
            $http.post('collection_task/isCollectionTaskExit', $scope.collectionTaskVo).success(function (data) {
                if (data.code == Response.successCode){
                    if ($scope.collectionTaskVo.dataSource == CommonCodeUtils.dataSource.auto && $scope.collectionTaskVo.collectionTaskStatus == '3711'){
                        $location.path('app/postbiz_collection_task_save').search({
                            type:'list',
                            collectionTaskNo: rows[0].collectionTaskNo,
                            overdueCstmId: rows[0].overdueCstmId,
                        });
                    } else {
                        $location.path('app/postbiz_collection_task_save').search({
                            overdueCstmId: rows[0].overdueCstmId,
                            type:'list'
                        });
                    }
                } else {
                    modalAlert($modal,data.message);
                }
            });
        }
    }

    //导出数据表
    $scope.exportCollectionTask = function () {
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.postbiz, CommonServiceType.excelTypes.one,
            'collection_task/findCollectionTasksByPage', dataTableParams($scope));
    }

    $scope.detailCollectionTask = function(collectionTaskNo){
        $location.path("app/postbiz_collection_task_detail").search({'collectionTaskNo': collectionTaskNo});
    }

}])
;