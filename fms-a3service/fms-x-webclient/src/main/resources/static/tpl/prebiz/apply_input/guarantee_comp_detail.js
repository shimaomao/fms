/**
 * Created by ningyangyang on 2018/4/26.
 */
app.controller('guarantee_comp_detail_controller', ['$scope', '$http','$modal','toaster','$location','$modalInstance','guaranteeComp','applyType',function ($scope, $http,$modal,toaster,$location,$modalInstance,guaranteeComp,applyType) {
    $scope.guaranteeComp=guaranteeComp;

    //承租人与担保人关系
    if(applyType==1){
        $scope.guaranteeComp.relationName = CommonCodeUtils.getCodeValueName('relationPerComp',$scope.guaranteeComp.relation);
    }else{
        $scope.guaranteeComp.relationName = CommonCodeUtils.getCodeValueName('relationComp2',$scope.guaranteeComp.relation);
    }

    $scope.formValidate = false;

    $scope.submit = false;
    
    //企业性质
    $scope.guaranteeComp.compTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.compType,$scope.guaranteeComp.compType)
    //证件类型
    $scope.guaranteeComp.certifTypeName =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType,$scope.guaranteeComp.certifType)

    //地区信息
    //省
    $scope.guaranteeComp.compProvName = AreaUtils.getAreaName($scope.guaranteeComp.compProv)
    //市
    $scope.guaranteeComp.compCityName = AreaUtils.getAreaName($scope.guaranteeComp.compCity)
    //区县
    $scope.guaranteeComp.compCountyName = AreaUtils.getAreaName($scope.guaranteeComp.compCounty)


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
        if ($scope.guaranteeComp.compProv =="") {
            $scope.cityList = {};
            $scope.areaList={};
        } else {
            $scope.cityList=$scope.cityMap;
        }
        $scope.guaranteeComp.compCity="";
        $scope.guaranteeComp.compCounty="";
    }
    $scope.changeCity = function() {

        if ($scope.guaranteeComp.compCity =="") {
            $scope.areaList={};
        } else {
            $scope.areaList=$scope.areaMap;
        }
        $scope.guaranteeComp.compCounty="";

    }

    console.log($scope.guaranteeComp);
    /**
     * 关闭窗口
     * @param status
     */
    var datas = $scope.guaranteeCompList;
    $scope.close = function(){
        $modalInstance.close(datas);
    };
}]);



