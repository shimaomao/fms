/**
 * Created by wangxue on 2018/3/22.
 */

app.controller('bas_vehicle_list_select_controller', ['$scope', '$http', '$modal','$modalInstance','basVehicle','$compile', function ($scope, $http, $modal, $modalInstance,basVehicle,$compile) {

    // 级别
    $scope.vehicleLevel = basVehicle.vehicleLevel;
    // 产品方案代码
    if (isNotUndefinedNull(basVehicle.vehicleCodeList)) {
        $scope.vehicleCodeList = basVehicle.vehicleCodeList;
        var count = 0;
        $scope.vehicleCodes = '';
        for (var index = 0; index < $scope.vehicleCodeList.length; index++) {
            if (count > 0) {
                $scope.vehicleCodes += CommonStringUtils.COMMA;
            }
            $scope.vehicleCodes += $scope.vehicleCodeList[index];
            count++;
        }
    } else {
        $scope.vehicleCodeList = [];
        $scope.vehicleCodes = '';
    }

    // 车辆种类
    if (isNotUndefinedNull(basVehicle.vehicleType)) {
        $scope.vehicleTypes = basVehicle.vehicleType;
        $scope.vehicleTypeList =  CommonStringUtils.splitComma(basVehicle.vehicleType.replace('，',CommonStringUtils.COMMA));
    } else {
        $scope.vehicleTypeList = [];
        $scope.vehicleTypes = '';
    }

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'bas_vehicle/findBasVehiclesVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_vehicle_list_select_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('vehicleId'),
            {
                title: '车型代码',
                data: 'vehicleCode',
                width: '30%',
                render: function (data, type, row, meta) {
                    return "<a class=\"a1\" ng-click=\"directSelect('"+row.vehicleId+"')\">"+data+"</a>";
                },
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    $compile(nTd)($scope);
                }
            },
            /*{title:'车型代码',data:'vehicleCode',width:'20%'},*/
            {title:'车型名称',data:'vehicleName',width:'20%'},
            {title:'车辆大类',data:'vehicleType1',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleType,data);
                }
            },
            /*   {title:'车辆分类(*乘用车/皮卡/微面/轻卡/轻客)',data:'vehicleType2',width:'20%'},*/
            {title:'指导价格',data:'guidePrice',width:'20%'},
            {title:'制造商代码',data:'vehMakerCode',width:'20%'},
            {title:'制造商名称',data:'vehMakerName',width:'20%'},
            {title:'品牌代码',data:'vehBrandCode',width:'20%'},
            {title:'品牌名称',data:'vehBrandName',width:'20%'},
            {title:'车系代码',data:'vehSeriesCode',width:'20%'},
            {title:'车系名称',data:'vehSeriesName',width:'20%'},
            {title:'启用标志',data:'enableFlag',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,data);
                }
            },
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    };

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.vehicleName = $scope.vehicleName;
        params.vehMakerName = $scope.vehMakerName;
        params.vehBrandName = $scope.vehBrandName;
        params.vehSeriesName = $scope.vehSeriesName;
        params.vehicleLevel = $scope.vehicleLevel;
        params.vehicleCodes = $scope.vehicleCodes;
        params.vehicleTypes = $scope.vehicleTypes;
        params.guidePrice = $scope.guidePrice;
        params.enableFlag='0';//启用状态的数据
        return params;
    }

    // 初始化
    $scope.init = function(){
        //创建dataTable 封装了datatable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };

    $scope.searchBasVehicle = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetBasVehicle = function(){
        $scope.vehicleName = '';
        $scope.vehMakerName = '';
        $scope.vehBrandName = '';
        $scope.vehSeriesName = '';
        $scope.guidePrice = '';
        $scope.dataTable.fnDraw(true);//刷新
    }

    // 确认
    $scope.confirm = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('vehicleId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择车型信息！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时选中一条数据！');
        else{
            var data = $scope.dataTable.getRow(rowsIds[0],'vehicleId');
            if (checkProductVehicle(data, $scope.vehicleCodeList) && checkVehicleType(data.vehicleType1,$scope.vehicleTypeList)) {
                $modalInstance.close(data);
            } else {
                modalAlert($modal, "产品中没有此车型，请重新选择车型");
            }
        }
    };

    // 判断选择的车辆类型是否符合
    function checkVehicleType(vehicleType1, vehicleTypeList) {
        if (isNotUndefinedNull(vehicleTypeList) && vehicleTypeList.length > 0) {
            if (CommonArrayUtils.vagueContains(vehicleType1,vehicleTypeList)) {
                return true;
            }
            return false;
        } else {
            return true;
        }
    }

    // 判断选择的车型在产品中是否哟偶权限
    function checkProductVehicle(data, vehicleCodeList) {
        if (isNotUndefinedNull(vehicleCodeList) && vehicleCodeList.length > 0) {
            if (CommonArrayUtils.vagueContains(data.vehicleCode, vehicleCodeList)
                || (isNotUndefinedNull(data.vehSeriesCode) && CommonArrayUtils.vagueContains(data.vehSeriesCode, vehicleCodeList))
                || (isNotUndefinedNull(data.vehSeriesCode) && CommonArrayUtils.vagueContains(data.vehBrandCode, vehicleCodeList))
                || (isNotUndefinedNull(data.vehSeriesCode) && CommonArrayUtils.vagueContains(data.vehMakerCode, vehicleCodeList))) {
                return true;
            }
            return false;
        } else {
            return true;
        }
    }

    $scope.directSelect = function (vehicleId) {
        var data = $scope.dataTable.getRow(vehicleId,'vehicleId');
        $modalInstance.close(data);
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close(null);
    };

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.baseinfo,CommonServiceType.excelTypes.two,
            'bas_vehicle/findBasVehiclesVosByPage',dataTableParams($scope));
    }
}]);