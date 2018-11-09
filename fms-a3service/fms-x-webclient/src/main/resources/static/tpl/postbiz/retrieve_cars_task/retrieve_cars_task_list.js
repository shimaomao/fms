/**
 * Created by ningyangyang on 2018-09-12.
 */
app.controller('retrieve_cars_task_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData',function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {

    $timeout(function () {
        var msg = $location.search()['msg'];
        if(CommonObjectUtils.isExist(msg)) {
            toaster_success(msg, toaster);
            $location.search({msg:null});
        }
    })

    $scope.retrieveCarsTask = {}

    //查询参数
    $scope.params = setData.getter();
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'retrieve_cars_task/findRetrieveCarsTaskVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'retrieve_cars_task_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('retrieveCarId'),
            // {title:'操作',data:'retrieveCarId',width:'20%',render:function(data){
            //     return '<a class="a1" ng-click="toLaunchTask(\''+data+'\')">发起任务</a>&nbsp;&nbsp;&nbsp;' +
            //         '<a class="a1" ng-click="detailRetrieveCarsTask(\''+data+'\')">任务详情</a>';
            // }, fnCreatedCell: function (nTd) {
            //     $compile(nTd)($scope);
            // }},
            defaultDetail('retrieveCarTaskNo', 'detailRetrieveTask', '收车任务号', '20%', $compile, $scope, 'retrieveCarId'),
            {title:'合同编号',data:'contNo',width:'20%'},
            {title:'承租人',data:'cstmName',width:'20%'},
            {title:'车架号',data:'overdueContVinNo',width:'20%'},
            {title:'车牌号',data:'vehicleLicenseNo',width:'20%'},
            {title:'收车原因',data:'retrieveReason',width:'20%'},
            {title:'发起日',data:'submitDate',width:'20%'},
            {title:'收车结果',data:'retrieveResult',width:'20%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.retrieveResult,data)
                }
            },
            {title:'预估收车佣金',data:'forRetrAmount',width:'20%'},
            {title:'派单类型',data:'dispachType',width:'20%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.dispatchType,data)
                }
            },
            {title:'入库地点',data:'storageAddr',width:'20%'},
            {title:'任务状态',data:'taskStatus',width:'20%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data)
                }
            },
            {title:'申请编号',data:'applyNo',width:'20%'},
            {title:'当前用户',data:'presentUser',width:'20%'},
            {title:'发起人',data:'submitUser',width:'20%'},
            {title:'登记人',data:'registerPeople',width:'20%'},
            {title:'GPS厂商',data:'gpsSeller',width:'20%',
                render:function(data){
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsSeller,data)
                }
            },
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


    $scope.searchRetrieveCarsTask = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetRetrieveCarsTask = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }
    //派单类型
    $scope.dispatchTypes = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.dispatchType);
    //订单状态
    $scope.bizStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.bizStatus);




    $scope.launchTask = function () {
        $location.path('app/postbiz_retrieve_cars_task_launch')
    }
    //发起收车任务
    $scope.toLaunchTask = function (retrieveCarId) {
        var row = $scope.dataTable.getRow(retrieveCarId,"retrieveCarId");
        if(row){
            $scope.retrieveCarsTask.contNo = row.contNo;
            $http.post('retrieve_cars_task/checkRetrieveCarsTask',$scope.retrieveCarsTask).success(function (data) {
                $scope.retrieveCarsTask1 = data.data;
                if(isNotUndefinedNull($scope.retrieveCarsTask1))
                // if(CommonStringUtils.isNotTrimBlank(row.presentUser))
                //     modalAlert($modal,"该任务正在进行收车任务，请等待收车结束后再申请");
                // else if(row.taskStatus == '4413' && (row.retrieveResult == CommonCodeUtils.yesNoFlag.yes)){
                //     modalAlert($modal,"该任务已经完成");
                // }
                    modalAlert($modal,"该任务正在进行收车任务，请等待收车结束后再申请");
                else
                    $location.path('app/postbiz_retrieve_cars_task_launch').search({contNo:row.contNo,overdueContId:row.overdueContId});
            })
        }else if(!row){
            $location.path('app/postbiz_retrieve_cars_task_launch').search({contNo:''});
        }
            //modalAlert($modal,"请选择需要发起任务的信息");
    }


    // $scope.test1 = function () {
    //     var rows = $scope.dataTable.getRows();
    //     $location.path('app/postbiz_retrieve_cars_task_risk').search({serviceId:rows[0].retrieveCarTaskNo});
    // }
    //
    // $scope.test2 = function () {
    //     var rows = $scope.dataTable.getRows("retrieveCarId");
    //     $location.path('app/postbiz_retrieve_cars_task_approve').search({serviceId:rows[0].retrieveCarTaskNo});
    // }

    /**
     *  收车任务详情
     */
    $scope.detailRetrieveTask = function (retrieveCarId) {
        var row = $scope.dataTable.getRow(retrieveCarId,"retrieveCarId");
        $location.path('app/postbiz_retrieve_cars_task_detail').search({retrieveCarTaskNo:row.retrieveCarTaskNo})
    }
    /**
     *  导出数据
     */
    $scope.exportRetrieveCarsTask = function () {
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.postbiz,CommonServiceType.excelTypes.one,
            'retrieve_cars_task/findRetrieveCarsTaskVosByPage',dataTableParams($scope));
    }

}])
;