/**
 * Created by qiaomengnan on 2018-05-25.
 */
app.controller('gps_dispatch_detail_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.gpsDispatch={};

    $scope.formValidate = false;

    $scope.submit = false;




    $http.get('gps_dispatch/findGpsDispatchDetailByContNo?contNo=' + $location.search()['contNo']).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.gpsDispatch = data.data;
            $scope.gpsDispatch.applyType = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.applyType,$scope.gpsDispatch.applyType);
            $scope.gpsDispatch.licenseAttr = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,$scope.gpsDispatch.licenseAttr);
            $scope.gpsDispatch.gpsSeller = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsSeller,$scope.gpsDispatch.gpsSeller);
            $scope.gpsDispatch.installProvince = AreaUtils.getAreaName($scope.gpsDispatch.installProvince);
            $scope.gpsDispatch.installCity = AreaUtils.getAreaName($scope.gpsDispatch.installCity);
            $scope.gpsDispatch.installCounty = AreaUtils.getAreaName($scope.gpsDispatch.installCounty);
            $scope.gpsDispatch.dispatchFlag = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsDispatchFlag,$scope.gpsDispatch.dispatchFlag);
            $scope.gpsDispatch.installStatus = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsInstallStatus,$scope.gpsDispatch.installStatus);

            $scope.gpsSellerList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gpsSeller);
            $scope.gpsDispatchFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gpsDispatchFlag);
            $scope.gpsInstallStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gpsInstallStatus);

            $scope.gpsDispatch.gpsSeller = $scope.gpsDispatch.gpsSeller == null?"":$scope.gpsDispatch.gpsSeller;
            $scope.gpsDispatch.installProvince = $scope.gpsDispatch.installProvince == null?"":$scope.gpsDispatch.installProvince;
            $scope.gpsDispatch.installCity = $scope.gpsDispatch.installCity == null?"":$scope.gpsDispatch.installCity;
            $scope.gpsDispatch.installCounty = $scope.gpsDispatch.installCounty == null?"":$scope.gpsDispatch.installCounty;
            $scope.gpsDispatch.dispatchFlag = $scope.gpsDispatch.dispatchFlag == null?"":$scope.gpsDispatch.dispatchFlag;
            $scope.gpsDispatch.installStatus = $scope.gpsDispatch.installStatus == null?"":$scope.gpsDispatch.installStatus;

        } else
            modalAlert($modal,data.message);
    }).error(function(data){
        modalAlert($modal,data);
    })


    //拿到省市县
    $scope.provinceList= AreaUtils.getAllProvinceList();
    $scope.cityList = AreaUtils.getAllCityList();
    $scope.areaList= AreaUtils.getAllAreaList();

    $scope.changeProvince = function() {
        $scope.gpsDispatch.installCity = "";
    }

    $scope.changeCity = function() {
        $scope.gpsDispatch.installCounty = "";
    }


    $scope.goBack = function(){
        $location.path('app/cost_gps_dispatch_list');
    };


}]);


