app.controller('bas_vehicle_save_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.basVehicle={};
    //启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);

    $scope.formValidate = false;

    $scope.submit = false;
    $scope.vehicleLevelList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleLevel);

    $scope.basVehicle.vehicleLevel=$location.search()['vehicleLevel'];
    /*//车辆种类
    $scope.vehicleType1List=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleType1);*/
    //车辆分类
    $scope.vehicleType2List=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleType2);
    //是否新能源车
    $scope.newEnergyList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.newEnergy);


    $scope.title='';
    $scope.CODE='';
    $scope.name='';
    if($scope.basVehicle.vehicleLevel=="1"){
        $scope.title="添加制造商";
        $scope.CODE='制造商';
    }else if($scope.basVehicle.vehicleLevel=="2"){
        $scope.title="添加品牌";
        $scope.name="制造商";
        $scope.CODE='品牌';
    }else if($scope.basVehicle.vehicleLevel=="3"){
        $scope.title="添加车系";
        $scope.name="品牌";
        $scope.CODE='车系';
    }else if($scope.basVehicle.vehicleLevel=="4"){
        $scope.title="添加车型";
        $scope.name="车系";
        $scope.CODE='车型';

        $scope.basVehicle.vehicleType1 = 1;//默认 乘用车
        $scope.basVehicle.vehicleType2 = 1;//默认 乘用车
        $scope.basVehicle.newEnergy = 0;//默认 不是新能源车
    }

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.post('bas_vehicle/saveBasVehicle', $scope.basVehicle).success(function (data) {
                if (data.code == Response.successCode){
                    if($scope.basVehicle.vehicleLevel=="1"){
                        $location.path("app/baseinfo_bas_vehicle_list").search({type:'saveManufacturer'});
                    }else if($scope.basVehicle.vehicleLevel=="2"){
                        $location.path("app/baseinfo_bas_vehicle_list").search({type:'saveBrand'});
                    }else if($scope.basVehicle.vehicleLevel=="3"){
                        $location.path("app/baseinfo_bas_vehicle_list").search({type:'saveSeries'});
                    }else if($scope.basVehicle.vehicleLevel=="4"){
                        $location.path("app/baseinfo_bas_vehicle_list").search({type:'saveVehicle'});
                    }
                } else{
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }


    }


    //选择上级
    $scope.select = function(vehicleLevel){
        var basVehicle = {};
        basVehicle.vehicleLevel=vehicleLevel;
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_vehicle/bas_vehicle_list_level_select.html'+getCacheTime(),
            controller: 'bas_vehicle_list_select_level_controller',
            resolve:{
                basVehicle:function(){
                    return basVehicle;
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.basVehicle.parentVehicleCode=data.vehicleCode;
                $scope.basVehicle.parentVehicleName=data.vehicleName;
            }
        },function(){

        });
    }
    /**
     * 返回
     * @param status
     */
    $scope.goback = function(){
        $location.path("app/baseinfo_bas_vehicle_list");
    };

}]);


