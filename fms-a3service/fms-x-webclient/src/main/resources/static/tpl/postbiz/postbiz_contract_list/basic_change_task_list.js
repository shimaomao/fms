/**
 * Created by yangyiquan on 2018-04-28.
 */
app.controller('basic_change_task_list_controller', ['$scope', '$http', '$modal', 'toaster', '$compile', '$location', '$localStorage','setData', function ($scope, $http, $modal, toaster, $compile, $location, $localStorage,setData) {

    // 从其他画面跳转到的弹出信息显示
    $scope.type = $location.search()['type'];
    $scope.msg = $location.search()['msg'];
    if ($scope.type == 'cancel') {
        toaster_success($scope.msg, toaster);
    }
    //查询参数
    $scope.params = setData.getter();
    //参数配置
    $scope.dataTableProperties = {
        //ajax url 和类型
        dataTableAjax: {
            url: 'basic_change_task/findBasicChangeTaskListByPage',
            type: "GET",
        },
        //table的html id
        dataTableId: 'contract_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('taskNo'),
            defaultDetail('taskNo','detailTaskNo','任务号','10%',$compile,$scope, 'taskNo'),
            {title: '承租人', data: 'name', width: '10%'},
            {
                title: '变更类型', data: 'changeType', width: '10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.changeType, data);
                }
            },
            {title: '任务状态', data: 'taskStatus', width: '10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus, data);
                }
            },
            {title: '当前节点用户', data: 'presentUser', width: '10%'},
            {title: '任务发起人', data: 'submitUser', width: '10%'},
            {title: '任务发起时间', data: 'submitDate', width: '10%'},
            {title: '申请编号', data: 'applyNo', width: '10%'},
            {title: '合同编号', data: 'contNo', width: '10%'},
            {title: '车架号', data: 'vinNo', width: '10%'},
            {title: '变更后承租人', data: 'newName', width: '10%'},
            {title: '展期期限', data: 'deferMaturity', width: '10%'},
            {title: '展期金额', data: 'deferAmount', width: '10%',
                render: function (data, type, row, meta) {
                    if (row.changeType == CommonCodeUtils.changeType.basicChange){
                        return "";
                    } else {
                        return data;
                    }
                }
            },
            {title: '补充保证金', data: 'supplementDeposit', width: '10%',
                render: function (data, type, row, meta) {
                    if (row.changeType == CommonCodeUtils.changeType.basicChange){
                        return "";
                    } else {
                        return data;
                    }
                }
            },
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

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
    }

    $scope.resetContractList = function () {
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

    //导出数据表
    $scope.exportExcel = function () {
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.prebiz, CommonServiceType.excelTypes.one,
            'basic_change_task/findBasicChangeTaskListByPage', dataTableParams($scope));
    }
    app.postbiz_deposit_change_detail
    $scope.detailTaskNo = function (taskNo) {
        var row = $scope.dataTable.getRow(taskNo,'taskNo');
        if (row.changeType == CommonCodeUtils.changeType.basicChange){
            if (row.applyType == CommonCodeUtils.applyType.person){
                $location.path('app/postbiz_person_basic_change_detail').search({taskNo:taskNo});
            } else {
                $location.path('app/postbiz_company_basic_change_detail').search({taskNo:taskNo});
            }
        } else if (row.changeType == CommonCodeUtils.changeType.depositChange){
            $location.path('app/postbiz_deposit_change_detail').search({serviceId:taskNo,flag:true});
        }else if(row.changeType == CommonCodeUtils.changeType.deferTask){
            //展期任务
            $location.path('app/postbiz_defer_task_detail_page').search({deferTaskNo:taskNo,contNo:row.contNo});
        }else if(row.changeType == CommonCodeUtils.changeType.changeLessee){
            $location.path('app/postbiz_basic_change_detail').search({applyNo:taskNo});
        }
        console.log(row);
    }

    $scope.basicChangeCancel = function () {
        var rows = $scope.dataTable.getRows();
        if (rows.length < 1){
            modalAlert($modal, '请您选择需要取消的订单！');
        } else {
            $http.post('basic_change_task/isTaskCanBeCancel', {basicTaskNo:rows[0].taskNo}).success(function (data) {
                if (data.code == Response.successCode){
                    var frameTitle = "";
                    if (rows[0].changeType == '1'){
                        // 基本信息变更
                        frameTitle = '基本信息变更取消';
                    } else if (rows[0].changeType == '2'){
                        // 如果是合同展期
                        frameTitle = '合同展期取消';
                    } else if (rows[0].changeType == '3'){
                        // 保证金变更
                        frameTitle = '保证金变更取消';
                    } else {
                        // 变更承租人
                        frameTitle = '变更承租人取消';
                    }
                    // 如果变更类型是基本信息变更
                    $location.path('app/postbiz_basic_change_cancel').search({
                        basicTaskNo:rows[0].taskNo,
                        changeType:rows[0].changeType,
                        frameTitle:frameTitle
                    });
                } else{
                    modalAlert($modal,data.message);
                }
            }).error(function(data){
                modalAlert($modal,data);
            })
        }
    };

}])
;