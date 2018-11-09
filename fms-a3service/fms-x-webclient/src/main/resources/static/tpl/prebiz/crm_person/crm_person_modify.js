/**
 * Created by ningyangyang on 2018-05-23.
 */
app.controller('crm_person_modify_controller', ['$scope', '$http','$modal','toaster','$compile','$location', function ($scope, $http,$modal,toaster,$compile,$location) {
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.personId = $location.search()['personId'];
    $scope.crmPerson={};
    if($scope.personId){
        $http.get('crm_person/findCrmPersonByPersonId?personId='+$scope.personId).success(function (data) {
            if (data.code == Response.successCode) {
                $scope.crmPerson = data.data;
                console.log(data);
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    }
    //生肖
    $scope.chineseZodiacList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.chineseZodiac);
    //客户性别
    $scope.genderList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gender);
    console.log($scope.genderList);
    //客户婚姻状况
    $scope.marriageStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.marriageStatus);
    //客户户口类型
    $scope.censusTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.censusType);
    //客户学历
    $scope.eduBgTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.eduBgType);
    //证件类型
    $scope.certifTypeList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.certifType);
    //行业所属类别
    $scope.industryTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.industryType);
    //居住年份
    $scope.resideYearList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.resideYear);
    //房产类型
    $scope.propertyTypeList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.propertyType);
    //客户职业
    $scope.professionTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.professionType);
    //客户职位
    $scope.positionTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.positionType);
    //居住状况
    $scope.resideCondList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.resideCond);
    //民族
    $scope.ethnicTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.ethnicType);
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
        if ($scope.crmPerson.compProv =="") {
            $scope.cityListJob = {};
            $scope.areaListJob={};
        } else {
            $scope.cityListJob=$scope.cityMapJob;
        }
        $scope.crmPerson.compCity="";
        $scope.crmPerson.compCounty="";
    };
    $scope.changeCityJob = function() {
        if ($scope.crmPerson.compCity =="") {
            $scope.areaListJob={};
        } else {
            $scope.areaListJob=$scope.areaMapJob;
        }
        $scope.crmPerson.compCounty="";
    };
    $scope.cityMapMate=common_area_value[common_area_code.getCityList];
    //key - arealist
    $scope.areaMapMate=common_area_value[common_area_code.getAreaList];
    $scope.provinceListMate=common_area_value[common_area_code.getProvinceList];
    //修改初始化地区
    $scope.cityListMate =$scope.cityMapMate;
    $scope.areaListMate=$scope.areaMapMate;
    //配偶省市县调用
    $scope.changeCountryMate = function() {
        if ($scope.cstmPersMate.compProv =="") {
            $scope.cityListMate = {};
            $scope.areaListMate={};
        } else {
            $scope.cityListMate=$scope.cityMapMate;
        }
        $scope.crmPerson.compCity="";
        $scope.crmPerson.compCounty="";
    };
    $scope.changeCityMate = function() {
        if ($scope.crmPerson.compCity =="") {
            $scope.areaListMate={};
        } else {
            $scope.areaListMate=$scope.areaMapMate;
        }
        $scope.crmPerson.compCounty="";
    };
    $scope.cityMap=common_area_value[common_area_code.getCityList];
    //key - arealist
    $scope.areaMap=common_area_value[common_area_code.getAreaList];
    $scope.provinceList=common_area_value[common_area_code.getProvinceList];
    //修改初始化地区
    $scope.cityList =$scope.cityMap;
    $scope.areaList=$scope.areaMap;
    //地址省市县调用
    $scope.changeCountryAddr = function() {
        if ($scope.crmPerson.resideProv =="") {
            $scope.cityList = {};
            $scope.areaList={};
        } else {
            $scope.cityList=$scope.cityMap;
        }
        $scope.crmPerson.resideCity="";
        $scope.crmPerson.resideCounty="";
    };
    $scope.changeCityAddr = function() {
        if ($scope.crmPerson.resideCity =="") {
            $scope.areaList={};
        } else {
            $scope.areaList=$scope.areaMap;
        }
        $scope.crmPerson.resideCounty="";
    };
    $scope.cityMapCensus=common_area_value[common_area_code.getCityList];
    //key - arealist
    $scope.areaMapCensus=common_area_value[common_area_code.getAreaList];
    $scope.provinceListCensus=common_area_value[common_area_code.getProvinceList];
    //修改初始化地区
    $scope.cityListCensus =$scope.cityMapCensus;
    $scope.areaListCensus=$scope.areaMapCensus;
    //地址户籍省市县调用
    $scope.changeCountryCensus = function() {
        if ($scope.crmPerson.censusProv =="") {
            $scope.cityListCensus = {};
            $scope.areaListCensus={};
        } else {
            $scope.cityListCensus=$scope.cityMapCensus;
        }
        $scope.crmPerson.censusCity="";
        $scope.crmPerson.censusCounty="";
    };
    $scope.changeCityCensus = function() {
        if ($scope.crmPerson.censusCity =="") {
            $scope.areaListCensus={};
        } else {
            $scope.areaListCensus=$scope.areaMapCensus;
        }
        $scope.crmPerson.censusCounty="";
    };
    $scope.cityMapProperty=common_area_value[common_area_code.getCityList];
    //key - arealist
    $scope.areaMapProperty=common_area_value[common_area_code.getAreaList];
    $scope.provinceListProperty=common_area_value[common_area_code.getProvinceList];
    //修改初始化地区
    $scope.cityListProperty =$scope.cityMapProperty;
    $scope.areaListProperty=$scope.areaMapProperty;
    //地址房产省市县调用
    $scope.changeCountryProperty = function() {
        if ($scope.crmPerson.propertyProv =="") {
            $scope.cityListProperty = {};
            $scope.areaListProperty={};
        } else {
            $scope.cityListProperty=$scope.cityMapProperty;
        }
        $scope.crmPerson.propertyCity="";
        $scope.crmPerson.propertyCounty="";
    };
    $scope.changeCityProperty = function() {
        if ($scope.crmPerson.propertyCity =="") {
            $scope.areaListProperty={};
        } else {
            $scope.areaListProperty=$scope.areaMapProperty;
        }
        $scope.crmPerson.propertyCounty="";
    };

    //验证证件格式
    $scope.vali = function () {
        cardIdCheck( $scope.crmPerson.certifType,'persCertiNo',$compile,$scope);
    };
    $scope.mateValidate = function () {
        if($scope.crmPerson.mateCertifType){
            cardIdCheck($scope.crmPerson.mateCertifType,'mateCertiNo',$compile,$scope);
        }
    };

    $scope.changeCertifNo = function () {
        var isTrue = false;
        if($scope.crmPerson.certifNo){
            isTrue = /(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/.test($scope.crmPerson.certifNo);
        }
        if(isTrue){
            $scope.crmPerson.chineseZodiac = getPet($scope.crmPerson.certifNo);
            $scope.crmPerson.birthDate = getBirthday($scope.crmPerson.certifNo);
            $scope.crmPerson.sex = getSex($scope.crmPerson.certifNo);
        }
    };

    //提交
    $scope.save = function (type) {
        if(type == 1){
            if(!$scope.form.$invalid) {
                $scope.submit = true;
                $http.post("crm_person/saveCrmPerson", $scope.crmPerson).success(function (data) {
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
                $http.put("crm_person/modifyCrmPerson", $scope.crmPerson).success(function (data) {
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

    //婚姻状况
    $scope.marriageChange = function () {
        $scope.crmPerson.mateName = '';
        $scope.crmPerson.mateCertifType = '';
        $scope.crmPerson.mateCertifNo = '';
    };

    //返回
    $scope.goBack = function () {
        $location.path('/app/crm_person_list').search({
            "personId": null
        });
    }
}]);


