/**
 * Created by ningyangyang on 2018/4/26.
 */
app.controller('guarantee_pers_detail_controller', ['$scope', '$http','$modal','toaster','$location','$modalInstance' ,'guaranteePers','applyType',function ($scope, $http,$modal,toaster,$location,$modalInstance,guaranteePers,applyType) {
    $scope.guaranteePers =  guaranteePers;

    //承租人与担保人关系
    if(applyType==1){
        $scope.relationTypeName = 'relationPer2';
    }else{
        $scope.relationTypeName = 'relationPerComp';
    }
    /*//证件类型
    $scope.guaranteePers.certifTypeName =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType,$scope.guaranteePers.certifType)
    //担保人性别
    $scope.guaranteePers.genderName =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gender,$scope.guaranteePers.sex);
    //担保人关系
    $scope.guaranteePers.relationName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.relationType,$scope.guaranteePers.relation)
    //客户职业
    $scope.guaranteePers.professionName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.professionType,$scope.guaranteePers.profession)
    //客户职位
    $scope.guaranteePers.positionName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.positionType,$scope.guaranteePers.position);
    //行业所属类别
    $scope.guaranteePers.industryName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.industryType,$scope.guaranteePers.industry);

    //地区信息
    //居住地信息
    $scope.guaranteePers.resideProvName = AreaUtils.getAreaName($scope.guaranteePers.resideProv)
    $scope.guaranteePers.resideCityName = AreaUtils.getAreaName($scope.guaranteePers.resideCity)
    $scope.guaranteePers.resideCountyName = AreaUtils.getAreaName($scope.guaranteePers.resideCounty)
   //单位地址信息
    $scope.guaranteePers.compProvName = AreaUtils.getAreaName($scope.guaranteePers.compProv)
    $scope.guaranteePers.compCityName = AreaUtils.getAreaName($scope.guaranteePers.compCity)
    $scope.guaranteePers.compCountyName = AreaUtils.getAreaName($scope.guaranteePers.compCounty)


    //地区信息
    //key - citylist
    $scope.cityMap=common_area_value[common_area_code.getCityList];
    //key - arealist
    $scope.areaMap=common_area_value[common_area_code.getAreaList];
    $scope.provinceList=common_area_value[common_area_code.getProvinceList];
    //修改初始化地区
    $scope.cityList =$scope.cityMap;
    $scope.areaList=$scope.areaMap;
    //担保人信息省市县调用
    $scope.changeCountry = function() {
        if ($scope.guaranteePers.resideProv =="") {
            $scope.cityList = {};
            $scope.areaList={};
        } else {
            $scope.cityList=$scope.cityMap;
        }
        $scope.guaranteePers.resideCity="";
        $scope.guaranteePers.resideCounty="";
    }
    $scope.changeCity = function() {

        if ($scope.guaranteePers.resideCity =="") {
            $scope.areaList={};
        } else {
            $scope.areaList=$scope.areaMap;
        }
        $scope.guaranteePers.resideCounty="";

    }
    //地区信息
    //key - citylist
    $scope.cityMapJob=common_area_value[common_area_code.getCityList];
    //key - arealist
    $scope.areaMapJob=common_area_value[common_area_code.getAreaList];
    $scope.provinceListJob=common_area_value[common_area_code.getProvinceList];
    //修改初始化地区
    $scope.cityListJob =$scope.cityMapJob;
    $scope.areaListJob=$scope.areaMapJob;
    //职业省市县调用
    $scope.changeCountryJob = function() {
        if ($scope.guaranteePers.compProv =="") {
            $scope.cityListJob = {};
            $scope.areaListJob={};
        } else {
            $scope.cityListJob=$scope.cityMapJob;
        }
        $scope.guaranteePers.compCity="";
        $scope.guaranteePers.compCounty="";
    }
    $scope.changeCityJob = function() {

        if ($scope.guaranteePers.compCity =="") {
            $scope.areaListJob={};
        } else {
            $scope.areaListJob=$scope.areaMapJob;
        }
        $scope.guaranteePers.compCounty="";

    }*/

    console.log(guaranteePers)
    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close();
    };

}]);


