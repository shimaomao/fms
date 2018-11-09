/**
 * Created by niehaibing on 2018-03-20.
 */
app.controller('bas_vehicle_detail_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.basVehicle={};

    $scope.formValidate = false;

    $scope.submit = false;
    $http.get('bas_vehicle/findBasVehicleByVehicleId?vehicleId='+ $location.search()['vehicleId']).success(function(data){
        $scope.basVehicle = data.data;
        $scope.basVehicle.enableFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,$scope.basVehicle.enableFlag);
        // $scope.basVehicle.vehicleType1Name=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleType1,$scope.basVehicle.vehicleType1)
        $scope.basVehicle.vehicleType2Name=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleType2,$scope.basVehicle.vehicleType2)
        $scope.basVehicle.newEnergyName=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.newEnergy,$scope.basVehicle.newEnergy)
        $scope.title='';
        $scope.CODE='';
        $scope.name='';
        if($scope.basVehicle.vehicleLevel=="1"){
            $scope.title="查看制造商";
            $scope.CODE='制造商';
        }else if($scope.basVehicle.vehicleLevel=="2"){
            $scope.title="查看品牌";
            $scope.name="制造商";
            $scope.CODE='品牌';
        }else if($scope.basVehicle.vehicleLevel=="3"){
            $scope.title="查看车系";
            $scope.name="品牌";
            $scope.CODE='车系';
        }else if($scope.basVehicle.vehicleLevel=="4"){
            $scope.title="查看车型";
            $scope.name="车系";
            $scope.CODE='车型';
        }

    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.put('bas_vehicle/modifyBasVehicle', $scope.basVehicle).success(function (data) {
                if (data.code == Response.successCode){
                    if($scope.basVehicle.vehicleLevel=="1"){
                        $location.path("app/baseinfo_bas_vehicle_list").search({type:'modifyManufacturer'});
                    }else if($scope.basVehicle.vehicleLevel=="2"){
                        $location.path("app/baseinfo_bas_vehicle_list").search({type:'modifyBrand'});
                    }else if($scope.basVehicle.vehicleLevel=="3"){
                        $location.path("app/baseinfo_bas_vehicle_list").search({type:'modifySeries'});
                    }else if($scope.basVehicle.vehicleLevel=="4"){
                        $location.path("app/baseinfo_bas_vehicle_list").search({type:'modifyVehicle'});
                    }
                }else{
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
            templateUrl: 'tpl/baseinfo/bas_vehicle/bas_vehicle_list_select.html'+getCacheTime(),
            controller: 'bas_vehicle_list_select_controller',
            resolve:{
                basVehicle:function(){
                    return basVehicle;
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {

            }
        },function(){

        });
    }

    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/baseinfo_bas_vehicle_list");
    };
}]);


