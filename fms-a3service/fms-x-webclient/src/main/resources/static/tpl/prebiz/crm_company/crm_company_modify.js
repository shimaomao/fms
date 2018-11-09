/**
 * Created by ningyangyang on 2018-05-23.
 */
app.controller('crm_company_modify_controller', ['$scope', '$http','$modal','toaster','$location','$compile', function ($scope, $http,$modal,toaster,$location,$compile) {
    $scope.crmCompany={};
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.companyId = $location.search()['companyId'];

    if($scope.companyId){
        $http.get('crm_company/findCrmCompanyByCompanyId?companyId='+ $scope.companyId).success(function (data) {
            if (data.code == Response.successCode) {
                $scope.crmCompany = data.data;
                console.log(data);
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };

    //证件类型
    $scope.certifTypeList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.certifType);
    //企业性质
    $scope.compTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.compType);
    //经营地址类型
    $scope.compAddrTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.compAddrType);
    //地区信息
    //key - citylist
    $scope.cityMap=common_area_value[common_area_code.getCityList];
    //key - arealist
    $scope.areaMap=common_area_value[common_area_code.getAreaList];
    $scope.provinceList=common_area_value[common_area_code.getProvinceList];
    //修改初始化地区
    $scope.cityList =$scope.cityMap;
    $scope.areaList=$scope.areaMap;
    $scope.changeCountry = function() {
        if ($scope.crmCompany.compProv =="") {
            $scope.cityList = {};
            $scope.areaList={};
        } else {
            $scope.cityList=$scope.cityMap;
        }
        $scope.crmCompany.compCity="";
        $scope.crmCompany.compCounty="";
    };
    $scope.changeCity = function() {
        if ($scope.crmCompany.compCity =="") {
            $scope.areaList={};
        } else {
            $scope.areaList=$scope.areaMap;
        }
        $scope.crmCompany.compCounty="";

    };

    $scope.registerCityList =$scope.cityMap;
    $scope.registerAreaList=$scope.areaMap;
    $scope.changeRegisterCountry = function() {
        if ($scope.crmCompany.registerProv =="") {
            $scope.registerCityList = {};
            $scope.registerAreaList={};
        } else {
            $scope.registerCityList=$scope.cityMap;
        }
        $scope.crmCompany.registerCity="";
        $scope.crmCompany.registerCounty="";
    };
    $scope.changeRegisterCity = function() {
        if ($scope.crmCompany.registerCity =="") {
            $scope.registerAreaList={};
        } else {
            $scope.registerAreaList=$scope.areaMap;
        }
        $scope.crmCompany.registerCounty="";

    };

    //保存/提交
    $scope.save = function (type) {
        if(type == 1){
            if(!$scope.form.$invalid) {
                $scope.submit = true;
                $http.post("crm_company/saveCrmCompany", $scope.crmCompany).success(function (data) {
                    if (data.code == Response.successCode){
                        $scope.goBack();
                        toaster_info("保存成功！",toaster);
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
        }else{
            if(!$scope.form.$invalid) {
                $scope.submit = true;
                $http.put("crm_company/modifyCrmCompany", $scope.crmCompany).success(function (data) {
                    if (data.code == Response.successCode){
                        $scope.goBack();
                        toaster_info("修改成功！",toaster);
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
    };

    //返回
    $scope.goBack = function () {
        $location.path('/app/crm_person_list').search({
            "companyId": null
        });
    };

    $scope.certiValidate = function () {
        cardIdCheck( $scope.crmCompany.certifType,'compCertiNo',$compile,$scope);
    };
}]);


