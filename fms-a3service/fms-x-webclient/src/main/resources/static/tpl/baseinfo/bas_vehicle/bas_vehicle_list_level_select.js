/**
 * Created by wangxue on 2018/3/22.
 */
app.controller('bas_vehicle_list_select_level_controller', ['$scope', '$http', '$modal','$modalInstance','basVehicle', '$compile', function ($scope, $http, $modal, $modalInstance,basVehicle, $compile) {

    // 级别
    $scope.vehicleLevel = basVehicle.vehicleLevel;
    if($scope.vehicleLevel!=undefined&&$scope.vehicleLevel!=''){
        $scope.vehicleLevelFlag=false;
    }else{
        $scope.vehicleLevelFlag=true;
    }
    // 产品方案代码
    $scope.vehicleCodeList = basVehicle.vehicleCodeList;
    // 车辆种类
    $scope.vehicleTypes = basVehicle.vehicleType;
    $scope.vehicleLevelList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleLevel);
    $scope.Name='';
    $scope.Title='';
    if($scope.vehicleLevel=="1"){
        $scope.Title='选择制造商';
        $scope.Name="制造商名称";
    }else if($scope.vehicleLevel=="2"){
        $scope.Name="品牌名称";
        $scope.Title='选择品牌';
    }else if($scope.vehicleLevel=="3"){
        $scope.Name="车系名称";
        $scope.Title='选择车系';
    }else{
        $scope.Title='选择车型信息';
        $scope.Name="车型信息";
    }


    $scope.checkBoxType=CheckBox;

    if($scope.vehicleLevel!=""){
        $scope.checkBoxType=Radio
     }

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'bas_vehicle/findBasVehicleLevelsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_vehicle_list_select_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('vehicleId'),
            defaultDetail('vehicleCode','detailVehicleVo','代码','20%',$compile,$scope,'vehicleId'),
            // {title:'代码',data:'vehicleCode',width:'20%'},
            {title:'名称',data:'vehicleName',width:'20%'},
            {title:'级别',data:'vehicleLevel',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleLevel,data);
                }
            },
            {title:'首字母',data:'firstLetter',width:'20%'},

        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: $scope.checkBoxType
    };

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.vehicleName = $scope.vehicleName;
        params.vehicleLevel = $scope.vehicleLevel;
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
        $scope.dataTable.fnDraw(true);//刷新
    }

    // 确认
    $scope.confirm = function(){
        if(status != 'none') {
            var data=null;
            if($scope.vehicleLevel!=""){
                 data = $scope.dataTable.getRow();
            }else{
                 data = $scope.dataTable.getRows();
            }

            if(data == null)
                modalAlert($modal,'请选择一条数据');
            else
                $modalInstance.close(data);
        }else{
            var data = {id:0,realName:'无上级'};
            $modalInstance.close(data);
        }
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close(null);
    };

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.baseinfo,CommonServiceType.excelTypes.one,
            'bas_vehicle/findBasVehicleLevelsByPage',dataTableParams($scope));
    }

    $scope.detailVehicleVo = function (vehicleId) {
        var data = $scope.dataTable.getRow(vehicleId,'vehicleId');
        $modalInstance.close(data);
    }
}]);