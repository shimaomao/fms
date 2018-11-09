/**
 * Created by ningyangyang on 2018-03-30.
 */
app.controller('guarantee_pers_save_controller', ['$scope', '$http','$modal','toaster','$location','$modalInstance' ,'guaranteePersList','cstmCompany','$compile','applyType',function ($scope, $http,$modal,toaster,$location,$modalInstance,guaranteePersList,cstmCompany,$compile,applyType) {
    $scope.guaranteePers={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.guaranteePersList = guaranteePersList;
    $scope.cstmCompany = cstmCompany;

    //承租人与担保人关系
    if(applyType==1){
        $scope.relationTypeList = CommonCodeUtils.getCommonCodes('relationPer2');
    }else{
        $scope.relationTypeList = CommonCodeUtils.getCommonCodes('relationPerComp');
    }
    //担保人与担保人关系
    $scope.relationTypeList2 = CommonCodeUtils.getCommonCodes('guaRelationPer');
    if($scope.guaranteePersList.length>=2){
        $scope.isRequire = true;
    }else{
        $scope.isRequire = false;
    }

    //企业申请信息录入时，承租人与担保人关系是 【股东或法人】 时，带入企业基本信息中的单位信息
    var flag = true;
    $scope.$watch('guaranteePers.relation',function () {
        if(flag && ($scope.guaranteePers.relation==5 || $scope.guaranteePers.relation==6)){
            $scope.guaranteePers = $.extend(true,$scope.guaranteePers,$scope.cstmCompany);
            flag = false;
        }
    });
    //证件类型
    $scope.certifTypeList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.certifType);
    //担保人性别
    $scope.genderList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gender);
    //客户职业
    $scope.professionTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.professionType);
    //客户职位
    $scope.positionTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.positionType);
    //行业所属类别
    $scope.industryTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.industryType);
    //居住状况
    $scope.resideCondList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.resideCond);
    //居住年份
    $scope.resideYearList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.resideYear);
    //是否有房产
    $scope.isHavePropertyList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.isHaveProperty);
    //婚姻状况
    $scope.marriageStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.marriageStatus);
    //房产类型
    $scope.propertyTypeList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.propertyType);

    //地区信息
    //key - citylist
    $scope.cityMap=common_area_value[common_area_code.getCityList];
    //key - arealist
    $scope.areaMap=common_area_value[common_area_code.getAreaList];
    $scope.provinceList=common_area_value[common_area_code.getProvinceList];

    $scope.censusCityList = $scope.cityMap;
    $scope.censusCountyList = $scope.areaMap;

    $scope.propertyCityList = $scope.cityMap;
    $scope.propertyCountyList = $scope.areaMap;

    $scope.mateCompCityList = $scope.cityMap;
    $scope.mateCompCountyList = $scope.areaMap;
    $scope.changeP = function (a,b,c,cityList,countryList) {
        if ($scope.guaranteePers[a] =="") {
            $scope[cityList] = [];
            $scope[countryList] = [];
        } else {
            $scope[cityList] = $scope.cityMap;
        }
        $scope.guaranteePers[b]="";
        $scope.guaranteePers[c]="";
    };
    $scope.changeC = function(a,b,c,cityList,countryList) {
        if ($scope.guaranteePers[b] =="") {
            $scope[countryList] = [];
        } else {
            $scope[countryList] = $scope.areaMap;
        }
        $scope.guaranteePers[c]="";
    };

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
    };
    $scope.changeCity = function() {
        if ($scope.guaranteePers.resideCity =="") {
            $scope.areaList={};
        } else {
            $scope.areaList=$scope.areaMap;
        }
        $scope.guaranteePers.resideCounty="";
    };
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
    };
    $scope.changeCityJob = function() {

        if ($scope.guaranteePers.compCity =="") {
            $scope.areaListJob={};
        } else {
            $scope.areaListJob=$scope.areaMapJob;
        }
        $scope.guaranteePers.compCounty="";

    };
    /**
     * 保存担保人信息
     */
    $scope.save = function () {
        if(!$scope.form.$invalid) {
            $scope.guaranteePers.type = '个人';
            $scope.guaranteePers.guarPersNo = Math.random()*10000+$scope.guaranteePers.certifNo;

            var flag = true;
            if($scope.guaranteePers.isCommGuarantee == 1){
                var obj = {
                    name: $scope.guaranteePers.mateName,
                    relation: '',
                    certifNo: $scope.guaranteePers.mateCertifNo,
                    certifType: $scope.guaranteePers.mateCertifType,
                    mobileNo:$scope.guaranteePers.mateMobileNo,
                    guaRelation:'pp5',
                    /*relation:$scope.guaranteePers.relation,*/
                    sex:$scope.guaranteePers.sex == 1?0:1,
                    guarPersNo: Math.random()*10000+$scope.guaranteePers.mateCertifNo,
                    whetherSpouse: 1,
                    mateName:$scope.guaranteePers.name,
                    mateCertifType:$scope.guaranteePers.certifType,
                    mateCertifNo:$scope.guaranteePers.certifNo,
                    mateMobileNo:$scope.guaranteePers.mobileNo,
                    mateCompName:$scope.guaranteePers.compName,
                    mateCompTel:$scope.guaranteePers.compTel,
                    mateCompProv:$scope.guaranteePers.compProv,
                    mateCompCity:$scope.guaranteePers.compCity,
                    mateCompCounty:$scope.guaranteePers.compCounty,
                    mateCompAddr:$scope.guaranteePers.compAddr,
                    matePosition:$scope.guaranteePers.position,
                    mateSalary:$scope.guaranteePers.salary,
                    isCommGuarantee: 1,
                };
                obj = $.extend(false,$scope.guaranteePers,obj);
                if(obj.guarPersId){
                    delete obj.guarPersId;
                    delete obj.applyNo;
                }
                for (var i in $scope.guaranteePersList) {
                    if($scope.guaranteePers.mateCertifNo == $scope.guaranteePersList[i].certifNo){
                        flag = false;
                    }
                }
            }else{
                for (var i in $scope.guaranteePersList) {
                    if($scope.guaranteePers.mateCertifNo == $scope.guaranteePersList[i].certifNo){
                        $scope.guaranteePersList.splice(i,1);
                    }
                }
            }
            $scope.guaranteePersList.push($scope.guaranteePers);
            if(flag && $scope.guaranteePers.isCommGuarantee == 1){
                $scope.guaranteePersList.push(obj);
            }
            $scope.close($scope.guaranteePersList);
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }


    };

    //检验身份证的长度
    $scope.guaranteePersValidate  = function(){
        cardIdCheck( $scope.guaranteePers.certifType,'guaranteePersCertiNo',$compile,$scope);
    };
    // //校验合法性
    // $scope.idValidation = function(){
    //     cardIdValidation($scope.guaranteePers.certifType,$scope.guaranteePers.certifNo,$modal);
    // }

  //提交验证
  //   function check(){
  //       return cardIdValidation($scope.guaranteePers.certifType,$scope.guaranteePers.certifNo,$modal)
  //
  //   }

    // {
    //     var certiType =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType,$scope.guaranteePers.certifType);
    //     var guaranteePersCertiNo = document.getElementById('guaranteePersCertiNo');
    //     if(certiType == '身份证'){
    //         guaranteePersCertiNo.setAttribute('ng-pattern','/^\\d{6}(18|19|20)?\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|X)$/');
    //         $compile(guaranteePersCertiNo)($scope);
    //         console.log(guaranteePersCertiNo)
    //     }else{
    //         guaranteePersCertiNo.setAttribute('ng-pattern','/^[0-9a-zA_Z]+$/');
    //         $compile(guaranteePersCertiNo)($scope);
    //         console.log(guaranteePersCertiNo)
    //     }
    // }
    /**
     * 关闭窗口
     * @param status
     */
    var datas = $scope.guaranteePersList;
    $scope.close = function(){
        $modalInstance.close(datas);
    };

    $scope.selectCertiNo = function (type) {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/apply_input/crm_person_list.html'+getCacheTime(),
            controller: 'crm_person_list_controller',
            resolve:{}
        });
        rtn.result.then(function (data) {
            if(data){
                $http.get('crm_person/findCrmPersonByCertifNo?certifNo='+data).success(function (data) {
                    console.log(data);
                    if (data.code == Response.successCode){
                        if(type == 1){
                            $scope.guaranteePers = $.extend(true,$scope.guaranteePers,data.data.cstmPersAddr,data.data.cstmPersJob,data.data.cstmPersJob,data.data.cstmPerson);
                        }else{
                            $scope.guaranteePers = $.extend(true,$scope.guaranteePers,data.data.guaranteeMate);
                        }

                    }else{
                        modalAlert($modal,data.message);
                    }
                }).error(function (err) {
                    modalAlert($modal,err);
                });
            }
        },function(){
        });
    };
    //根据身份证获取
    $scope.$watch('guaranteePers.certifNo',function (newValue,oldValue) {
        var isTrue = false;
        if($scope.guaranteePers.certifNo){
            isTrue = /(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/.test($scope.guaranteePers.certifNo);
        }
        if(isTrue){
            $scope.guaranteePers.birthDate = getBirthday($scope.guaranteePers.certifNo);
            $scope.guaranteePers.sex = getSex($scope.guaranteePers.certifNo);
        }
    });

    $scope.mateValidate = function () {
        cardIdCheck($scope.guaranteePers.mateCertifType,'mateCertiNo2',$compile,$scope);
    };
    
    //同步地址
    $scope.synchroniz = function (type) {
        if(type == 1){
            $scope.guaranteePers.censusProv = $scope.guaranteePers.resideProv;
            $scope.guaranteePers.censusCity = $scope.guaranteePers.resideCity;
            $scope.guaranteePers.censusCounty = $scope.guaranteePers.resideCounty;
        }else{
            $scope.guaranteePers.propertyProv = $scope.guaranteePers.resideProv;
            $scope.guaranteePers.propertyCity = $scope.guaranteePers.resideCity;
            $scope.guaranteePers.propertyCounty = $scope.guaranteePers.resideCounty;
        }
    };
}]);


