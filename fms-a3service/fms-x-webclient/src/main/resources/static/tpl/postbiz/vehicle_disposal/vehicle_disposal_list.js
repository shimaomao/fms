/**
 * Created by wangxue on 2018-09-12.
 */
app.controller('vehicle_disposal_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {
    //查询参数
    $scope.params = setData.getter();
    // 判断显示message
    $scope.timer = $timeout(function () {
        var message = $location.search()['msg'];
        if (isNotUndefinedNull(message) && isNotEmpty(message)) {
            toaster_success(message, toaster);
        }
    }, 100);
    // 获取车辆处置方式
    $scope.disposalStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.disposalStatus);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'vehicle_disposal/findVehicleDisposalVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'vehicle_disposal_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('vehicleDisposalId'),
            defaultDetail('contNo','detailVehicleDisposal','合同编号','20%',$compile,$scope, 'vehicleDisposalId'),
            // {title:'合同编号',data:'contNo',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'车牌号',data:'vehicleLicenseNo',width:'20%'},
            {title:'承租人',data:'cstmName',width:'20%'},
            {title:'出租人',data:'rentPerson',width:'20%'},
            {title:'发动机号',data:'engineNo',width:'20%'},
            {title:'收车时间',data:'recoverySubmitDate',width:'20%'},
            {title:'收车费用',data:'recoveryAmount',width:'20%'},
            {title:'入库时间',data:'storageDate',width:'20%'},
            {title:'入库地点',data:'storageAddr',width:'20%'},
            {title:'GPS厂商',data:'gpsSeller',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsSeller, data);
                }
            },
            {title:'融资额',data:'finTotal',width:'20%'},
            {title:'融资期限',data:'finPeriodType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.finPeriodType, data);
                }
            },
            {title:'车辆处置方式',data:'disposalStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.disposalStatus, data);
                }
            },
            {title:'车辆处置状态',data:'vehicleDisposalStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleDisposalStatus, data);
                }
            },
            {title:'车辆处置任务状态',data:'disposalTaskStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus, data);
                }
            },
            {title:'出库时间',data:'shipmentDate',width:'20%'},
            {title:'出库经办人',data:'agent',width:'20%'},
            {title:'出库经办人联系方式',data:'agentMobileNo',width:'20%'},
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

    // 查询
    $scope.searchVehicleDisposal = function(){
        $scope.dataTable.fnDraw(true);
    };

    // 重置
    $scope.resetVehicleDisposal = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    };

    // 车辆处置申请
    $scope.vehDisposalApply = function () {
        // 获取选中的数据
        var rows =  $scope.dataTable.getRows();
        if (rows.length < 1) {
            modalAlert($modal,'请您选择需要申请的数据！');
        } else {
            if (rows[0].vehicleDisposalStatus != '0') {
                modalAlert($modal,'车辆处置任务已完成，不可再次申请');
                return;
            }
            if (isNotUndefined(rows[0].disposalTaskNo) && isNotEmpty(rows[0].disposalTaskNo)
                 && rows[0].disposalTaskStatus != '0799') {
                modalAlert($modal,'车辆处置任务已发起，不可重复申请');
                return;
            }
            $location.path('app/postbiz_vehicle_disposal_apply').search({"vehicleDisposalId": rows[0].vehicleDisposalId});
        }
    };

    // 车辆处置详情
    $scope.detailVehicleDisposal = function (vehicleDisposalId) {
        var data = $scope.dataTable.getRow(vehicleDisposalId,'vehicleDisposalId');
        $location.path('/app/postbiz_vehicle_disposal_detail').search({'vehicleDisposalId':data.vehicleDisposalId, 'disposalTaskNo': data.disposalTaskNo});
    }

}])
;