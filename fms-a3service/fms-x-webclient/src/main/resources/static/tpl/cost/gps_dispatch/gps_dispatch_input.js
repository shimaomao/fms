/**
 * Created by qiaomengnan on 2018-05-25.
 */
app.controller('gps_dispatch_input_controller', ['$scope', '$http','$modal','toaster','$location','$timeout', function ($scope, $http,$modal,toaster,$location,$timeout) {
    $scope.dateParams = JSON.stringify({dateFmt:'yyyy-MM-dd HH:mm:ss'});

    $scope.gpsDispatch={};

    $scope.formValidate = false;

    $scope.submit = false;

    //拿到省市县
    $scope.provinceList= AreaUtils.getAllProvinceList();
    $scope.cityList = AreaUtils.getAllCityList();
    $scope.areaList= AreaUtils.getAllAreaList();

    $scope.modifyFlag = false;
    $http.get('gps_dispatch/findGpsDispatchDetailByContNo?contNo=' + $location.search()['contNo']).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.gpsDispatch = data.data;
            $scope.gpsDispatch.applyType = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.applyType,$scope.gpsDispatch.applyType);
            $scope.gpsDispatch.licenseAttr = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,$scope.gpsDispatch.licenseAttr);

            $scope.gpsSellerList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gpsSeller);
            $scope.gpsDispatchFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gpsDispatchFlag);
            $scope.gpsInstallStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gpsInstallStatus);

            $scope.gpsDispatch.gpsSeller = $scope.gpsDispatch.gpsSeller == null?"":$scope.gpsDispatch.gpsSeller;
            $scope.gpsDispatch.installProvince = $scope.gpsDispatch.installProvince == null?"":$scope.gpsDispatch.installProvince;
            $scope.gpsDispatch.installCity = $scope.gpsDispatch.installCity == null?"":$scope.gpsDispatch.installCity;
            $scope.gpsDispatch.installCounty = $scope.gpsDispatch.installCounty == null?"":$scope.gpsDispatch.installCounty;
            $scope.gpsDispatch.dispatchFlag = $scope.gpsDispatch.dispatchFlag == null?"":$scope.gpsDispatch.dispatchFlag;
            $scope.gpsDispatch.installStatus = $scope.gpsDispatch.installStatus == null?"":$scope.gpsDispatch.installStatus;
            $scope.gpsDispatch.dispatchWorkerUser = $scope.gpsDispatch.dispatchWorkerUser == null?"":$scope.gpsDispatch.dispatchWorkerUser;
            if(CommonObjectUtils.isExist($scope.gpsDispatch.dispatchId) && CommonStringUtils.isNotTrimBlank($scope.gpsDispatch.dispatchId)){
                $scope.modifyFlag = true;
            }
            $scope.defalutValue();
        } else
            modalAlert($modal,data.message);
    }).error(function(data){
        modalAlert($modal,data);
    })

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            if($scope.modifyFlag){
                $http.put('gps_dispatch/modifyGpsDispatch', $scope.gpsDispatch).success(function (data) {
                    if (data.code == Response.successCode) {
                        $location.path('app/cost_gps_dispatch_list').search({msg:'派单成功'});
                    }else {
                        modalAlert($modal, data.message);
                        $scope.submit = false;
                    }
                }).error(function(data){
                    modalAlert($modal,data);
                    $scope.submit = false;
                })
            }else{
                $http.post('gps_dispatch/saveGpsDispatch', $scope.gpsDispatch).success(function (data) {
                    if (data.code == Response.successCode) {
                        $location.path('app/cost_gps_dispatch_list').search({msg:'派单成功'});
                    }else {
                        modalAlert($modal, data.message);
                        $scope.submit = false;
                    }
                }).error(function(data){
                    modalAlert($modal,data);
                    $scope.submit = false;
                })
            }
        }else{

            $scope.formValidate = true;
            remindMsg($timeout,toaster);
        }
    };

    //天易接口查询
    $scope.query = function(){
        if($scope.gpsDispatch != null && CommonStringUtils.isNotTrimBlank($scope.gpsDispatch.dispatchId) && CommonStringUtils.isNotTrimBlank($scope.gpsDispatch.contNo) ) {
            //查询应该使用派单时的申请编号
            $http.get('gps_dispatch/findTyGpsDisPatch?dispatchId=' + $scope.gpsDispatch.dispatchId + "&tyOrderNo=" + $scope.gpsDispatch.contNo).success(function (data) {
                console.log(data)
                if (data.code == Response.successCode) {
                    modalAlert($modal, "查询成功,订单状态：" + CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsInstallStatus, data.data.installStatus));

                    $scope.gpsDispatch.wiredDeviceNo = data.data.wiredDeviceNo;
                    $scope.gpsDispatch.wirelessDeviceNo = data.data.wirelessDeviceNo;
                    $scope.gpsDispatch.installUser = data.data.installUser;
                    $scope.gpsDispatch.installUserMobileNo = data.data.installUserMobileNo;
                    $scope.gpsDispatch.installStatus = data.data.installStatus;
                } else {
                    modalAlert($modal, data.message);
                }
            }).error(function (data) {
                modalAlert($modal, data);
            })
        }
    }

    //如果是天易并且派单的话,但是派单号和派单id又不存在 则清空安装信息
    $scope.$watch("gpsDispatch.gpsSeller + gpsDispatch.dispatchFlag ",function(){
        if($scope.gpsDispatch != null) {
            if ($scope.gpsDispatch.gpsSeller == CommonCodeUtils.gpsSellerTypes.ty && $scope.gpsDispatch.dispatchFlag == CommonCodeUtils.yesNoFlag.yes) {
                if(CommonStringUtils.isTrimBlank($scope.gpsDispatch.dispatchId) || CommonStringUtils.isTrimBlank($scope.gpsDispatch.tyOrderNo)){
                    $scope.gpsDispatch.wiredDeviceNo = "";
                    $scope.gpsDispatch.wirelessDeviceNo  = "";
                    $scope.gpsDispatch.installUser  = "";
                    $scope.gpsDispatch.installUserMobileNo  = "";
                    $scope.gpsDispatch.installStatus  = "";
                }
            }
        }
    });


    //计算费用总额
    $scope.checkTotalCost = function(){
        $scope.gpsDispatch.totalCost =  CommonNumberUtils.addTotal([$scope.gpsDispatch.gpsWiredCost,$scope.gpsDispatch.gpsWirelessCost,$scope.gpsDispatch.installCost,$scope.gpsDispatch.reformCost]);
    }

    //监听值 计算费用
    $scope.$watch("gpsDispatch.gpsWiredCost + gpsDispatch.gpsWirelessCost + gpsDispatch.installCost + gpsDispatch.reformCost ",function(){
        $scope.checkTotalCost();
    });

    //默认值
    $scope.defalutValue = function(){
        //gps有线数量
        $scope.gpsDispatch.gpsWiredNum =  CommonObjectUtils.isExist($scope.gpsDispatch.gpsWiredNum) ? $scope.gpsDispatch.gpsWiredNum : 0;
        //gps无线数量
        $scope.gpsDispatch.gpsWirelessNum =  CommonObjectUtils.isExist($scope.gpsDispatch.gpsWirelessNum) ? $scope.gpsDispatch.gpsWirelessNum : 0;
        //安装费用
        $scope.gpsDispatch.installCost =  CommonObjectUtils.isExist($scope.gpsDispatch.installCost) ? $scope.gpsDispatch.installCost : 0;
        //拆改费
        $scope.gpsDispatch.reformCost =  CommonObjectUtils.isExist($scope.gpsDispatch.reformCost) ? $scope.gpsDispatch.reformCost : 0;
        //有线设备费用
        $scope.gpsDispatch.gpsWiredCost =  CommonObjectUtils.isExist($scope.gpsDispatch.gpsWiredCost) ? $scope.gpsDispatch.gpsWiredCost : 0;
        //无线设备费用
        $scope.gpsDispatch.gpsWirelessCost =  CommonObjectUtils.isExist($scope.gpsDispatch.gpsWirelessCost) ? $scope.gpsDispatch.gpsWirelessCost : 0;
    }

    //回到上页
    $scope.goBack = function(){
        $location.path('app/cost_gps_dispatch_list');
    };

    $scope.storage = function () {
        $http.post('gps_dispatch/storageGpsDispatch', $scope.gpsDispatch).success(function (data) {
            if (data.code == Response.successCode) {
                $location.path('app/cost_gps_dispatch_list').search({msg:'暂存成功'});
            }else {
                modalAlert($modal, data.message);
                $scope.submit = false;
            }
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    }


    $scope.$watch("dispatchWorkerUserObject",function (n,o) {
        if(CommonObjectUtils.isExist(n) && n != ""){
            var obj = JSON.parse(n);
            $scope.gpsDispatch.dispatchWorkerUser = obj.codeValueName;
            $scope.gpsDispatch.dispatchWorkerUserMobileNo = obj.codeValue;
        }else{
            $scope.gpsDispatch.dispatchWorkerUser = "";
            $scope.gpsDispatch.dispatchWorkerUserMobileNo = "";
        }
    });


}]);


