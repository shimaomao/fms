/**
 * Created by yanfengbo on 2018-05-11.
 */
app.controller('overdue_condition_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {
    //添加，修改成功提示信息
    $scope.timer = $timeout(function () {
        $scope.messageType=$location.search()['messageType'];
        if($scope.messageType == 'saveOverdueCondition'){
            toaster_success('添加逾期状态信息成功',toaster);
        }else if($scope.messageType=='modifyOverdueCondition'){
            toaster_success('编辑逾期状态信息成功',toaster);
        }

    }, 5);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'overdue_condition/findOverdueConditionsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'overdue_condition_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('overdueConditionId'),
            defaultDetail('overdueCondCd','detailOverdueCondition','逾期状态代码','20%',$compile,$scope,'overdueConditionId'),
            {title:'逾期状态名称',data:'overdueCondName',width:'20%'},
            {title:'逾期风险等级',data:'overdueRisk',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.overdueRisk,data);
                }
            },
            {title:'逾期状态详情代码',data:'overdueDetailType',width:'20%'},
            {title:'逾期状态备注',data:'overdueMeno',width:'20%'},
            {title:'启用标志',data:'enableFlag',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,data);
                }
            },
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'creator',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.overdueCondCd = $scope.overdueCondCd;
        params.overdueCondName = $scope.overdueCondName;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchOverdueCondition = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetOverdueCondition = function(){
        $scope.overdueCondCd = "";
        $scope.overdueCondName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    // 添加
    $scope.saveOverdueCondition = function(){
        $location.path('app/postbiz_overdue_condition_save').search({'frameTitle':'添加逾期状态信息','operate':'save'});
    }

    // 修改
    $scope.modifyOverdueCondition = function(overdueConditionId){
        var rowsIds =  $scope.dataTable.getRowsIds('overdueConditionId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/postbiz_overdue_condition_modify').search({'frameTitle':'修改逾期状态信息','operate':'update','overdueConditionId': rowsIds[0]});

        }
    }


    // 详情
    $scope.detailOverdueCondition = function(overdueConditionId){
        $location.path('/app/postbiz_overdue_condition_detail').search({'frameTitle':'逾期状态信息详情','operate':'check','overdueConditionId': overdueConditionId});
    }

    //删除
    $scope.deleteOverdueCondition = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('overdueConditionId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('overdue_condition/deleteOverdueConditionsByOverdueConditionIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除逾期状态信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

    //导出excel
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.postbiz,CommonServiceType.excelTypes.one,
            'overdue_condition/findOverdueConditionsByPage',dataTableParams($scope));
    }
}])
;