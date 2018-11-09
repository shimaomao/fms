/**
 * Created by niehaibing on 2018-03-17.
 */
app.controller('bas_vehicle_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {
    //查询参数
    $scope.params = setData.getter();
    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'saveManufacturer') {
            toaster_success('添加制造商信息成功', toaster);
        }else if ($scope.type == 'saveBrand') {
            toaster_success('添加品牌信息成功',toaster);
        } else if ($scope.type == 'saveSeries') {
            toaster_success('添加车系信息成功',toaster);
        } else if ($scope.type == 'saveVehicle') {
            toaster_success('添加车型信息成功',toaster);
        } else if ($scope.type == 'modifyManufacturer') {
            toaster_success('编辑制造商信息成功',toaster);
        } else if ($scope.type == 'modifyBrand') {
            toaster_success('编辑品牌信息成功',toaster);
        } else if ($scope.type == 'modifySeries') {
            toaster_success('编辑车系信息成功',toaster);
        } else if ($scope.type == 'modifyVehicle') {
            toaster_success('编辑车型信息成功',toaster);
        }

    }, 100);


    //车等级list
    $scope.vehicleLevelList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleLevel);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'bas_vehicle/findBasVehiclesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_vehicle_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('vehicleId'),
            defaultDetail('vehicleCode','detailBasVehicle','车型代码','20%',$compile,$scope,'vehicleId'),
            {title:'车型名称',data:'vehicleName',width:'20%'},
            {title:'级别',data:'vehicleLevel',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleLevel,data);
                }
            },
            {title:'上级车型代码',data:'parentVehicleCode',width:'20%'},
            {title:'首字母',data:'firstLetter',width:'20%'},
           /* {title:'车辆大类(*1-乘用车；2-商用车)',data:'vehicleType1',width:'20%'},*/
            {title:'车辆分类',data:'vehicleType2',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleType2,data);
                }
            },
            {title:'指导价格',data:'guidePrice',width:'20%'},
            {title:'排量',data:'displacement',width:'20%'},
            {title:'座位数量',data:'seat',width:'20%'},
            {title:'车型年款',data:'modelYear',width:'20%'},
            {title:'吨位',data:'weight',width:'20%'},
            {title:'功率',data:'power',width:'20%'},
            {title:'轮毂尺寸',data:'wheelSize',width:'20%'},
            {title:'排放标准',data:'effluentStd',width:'20%'},
            {title:'是否新能源车',data:'newEnergy',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.newEnergy,data);
                }
            },
            {title:'启用标志',data:'enableFlag',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,data);
                }
            },
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchBasVehicle = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetBasVehicle = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveBasVehicle = function(vehicleLevel){
        $location.path('/app/baseinfo_bas_vehicle_save').search({vehicleLevel:vehicleLevel});
    }

    $scope.modifyBasVehicle = function(vehicleId){
        var rowsIds =  $scope.dataTable.getRowsIds('vehicleId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/baseinfo_bas_vehicle_modify').search({vehicleId:rowsIds[0]});
        }

    }


    $scope.detailBasVehicle = function(vehicleId){
        $location.path('/app/baseinfo_bas_vehicle_detail').search({'vehicleId': vehicleId});
    }

    $scope.deleteBasVehicle = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('vehicleId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{
            modalConfirm($modal,function(){
                $http.delete('bas_vehicle/deleteBasVehiclesByVehicleIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.baseinfo,CommonServiceType.excelTypes.one,
            'bas_vehicle/findBasVehiclesByPage',dataTableParams($scope));
    }
}])
;