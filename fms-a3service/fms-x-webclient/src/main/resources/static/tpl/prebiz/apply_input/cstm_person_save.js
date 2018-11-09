/**
 * Created by ningyangyang on 2018-03-26.
 */
app.controller('cstm_person_save_controller', ['$scope', '$http','$modal','toaster','$location', '$compile','$rootScope',function ($scope, $http,$modal,toaster,$location,$compile,$rootScope) {


    $scope.applyNo = $scope.$parent.applyNo;
    $scope.applyType = $scope.$parent.applyType;

    $scope.cstmContactList = $scope.$parent.cstmContactList;
    $scope.cstmPerson = $scope.$parent.cstmPerson;
    $scope.cstmPersJob= $scope.$parent.cstmPersJob ;
    $scope.cstmPersMate= $scope.$parent.cstmPersMate ;
    $scope.cstmPersAddr =$scope.$parent.cstmPersAddr ;
    $scope.rationalityPurchase = $scope.$parent.rationalityPurchase;
    $scope.cstmPerson.quasiDriveModel = "";

    //任务id
    $scope.taskId = $scope.$parent.taskId;

    //从报价单画面跳转
    var quotationDeviceVo = $location.search()['quotationDeviceVo'];
    if(quotationDeviceVo) {
        quotationDeviceVo = JSON.parse(quotationDeviceVo);
        $scope.cstmPerson.name = quotationDeviceVo.name;
    }

    $scope.$watch("cstmPerson",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal){
            if($scope.cstmPerson.marriageStatus==2 || $scope.cstmPerson.marriageStatus==4){
                $scope.cstmPersMate.isCommonBorrower = 0;
            }
            $scope.$emit("personToFather",$scope.cstmPerson);
        }
    },true);
    $scope.$watch("cstmPersJob",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal !==oldVal)
        $scope.$emit("persJobToFather",$scope.cstmPersJob);
    },true);
    $scope.$watch("cstmPersMate",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal){
            $scope.$emit("persMateToFather",$scope.cstmPersMate);
        }
    },true);
    $scope.$watch("cstmPersAddr",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal)
        $scope.$emit("persAddrToFather",$scope.cstmPersAddr);
    },true);
    $scope.$watch("cstmContactList",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal)
        $scope.$emit("contactToFather",$scope.cstmContactList);
    },true);
    $scope.$watch("rationalityPurchase",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal)
            $scope.$emit("rationalityPurchaseToFather",$scope.rationalityPurchase);
    },true);
    $scope.$watch("remark",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal)
            $scope.$emit("remarkToFather",$scope.remark);
    });


    if($scope.applyNo){
           $http.get('apply_input/findApplyCstmPersonByApplyNo?applyNo='+ $scope.applyNo).success(function (data) {
               $scope.applyInputVo = data.data;
               $scope.cstmContactList = $scope.applyInputVo.cstmContactList;
               $scope.cstmPerson = $scope.applyInputVo.cstmPerson;
               $scope.cstmPersJob= $scope.applyInputVo.cstmPersJob ;
               $scope.cstmPersMate= $scope.applyInputVo.cstmPersMate ;
               $scope.cstmPersAddr =$scope.applyInputVo.cstmPersAddr ;
               $scope.rationalityPurchase =$scope.applyInputVo.rationalityPurchase ;
               $scope.remark =$scope.applyInputVo.remark ;
               initProperty();
               initTable();
           });
       }
       function initProperty(){
           $scope.cstmPerson.certifType == null?$scope.cstmPerson.certifType='': $scope.cstmPerson.certifType;
           $scope.cstmPerson.sex == null?$scope.cstmPerson.sex='':$scope.cstmPerson.sex;
           $scope.cstmPerson.marriageStatus == null?$scope.cstmPerson.marriageStatus='':$scope.cstmPerson.marriageStatus;
           $scope.cstmPerson.censusType == null?$scope.cstmPerson.censusType='':$scope.cstmPerson.censusType;
           $scope.cstmPerson.eduBgType == null?$scope.cstmPerson.eduBgType='':$scope.cstmPerson.eduBgType;
           $scope.cstmPerson.ethnicType == null?$scope.cstmPerson.ethnicType='':$scope.cstmPerson.ethnicType;
           $scope.cstmPersJob.industry == null?$scope.cstmPersJob.industry='':$scope.cstmPersJob.industry;
           $scope.cstmPersJob.profession == null?$scope.cstmPersJob.profession='':$scope.cstmPersJob.profession;
           $scope.cstmPersJob.position == null?$scope.cstmPersJob.position='':$scope.cstmPersJob.position;
           $scope.cstmPersJob.compProv == null?$scope.cstmPersJob.compProv='':$scope.cstmPersJob.compProv;
           $scope.cstmPersJob.compCity == null?$scope.cstmPersJob.compCity='':$scope.cstmPersJob.compCity;
           $scope.cstmPersJob.compCounty == null?$scope.cstmPersJob.compCounty='':$scope.cstmPersJob.compCounty;
           $scope.cstmPersMate.certifType == null?$scope.cstmPersMate.certifType='':$scope.cstmPersMate.certifType;
           $scope.cstmPersMate.position == null?$scope.cstmPersMate.position='':$scope.cstmPersMate.position;
           $scope.cstmPersMate.compProv == null?$scope.cstmPersMate.compProv='':$scope.cstmPersMate.compProv;
           $scope.cstmPersMate.compCity == null?$scope.cstmPersMate.compCity='':$scope.cstmPersMate.compCity;
           $scope.cstmPersMate.compCounty == null?$scope.cstmPersMate.compCounty='':$scope.cstmPersMate.compCounty;
           $scope.cstmPersAddr.resideCond == null?$scope.cstmPersAddr.resideCond='':$scope.cstmPersAddr.resideCond;
           $scope.cstmPersAddr.resideYear == null?$scope.cstmPersAddr.resideYear='':$scope.cstmPersAddr.resideYear;
           $scope.cstmPersAddr.resideProv == null?$scope.cstmPersAddr.resideProv='':$scope.cstmPersAddr.resideProv;
           $scope.cstmPersAddr.resideCity == null?$scope.cstmPersAddr.resideCity='':$scope.cstmPersAddr.resideCity;
           $scope.cstmPersAddr.resideCounty == null?$scope.cstmPersAddr.resideCounty='':$scope.cstmPersAddr.resideCounty;
           $scope.cstmPersAddr.censusProv == null?$scope.cstmPersAddr.censusProv='':$scope.cstmPersAddr.censusProv;
           $scope.cstmPersAddr.censusCity == null?$scope.cstmPersAddr.censusCity='':$scope.cstmPersAddr.censusCity;
           $scope.cstmPersAddr.censusCounty == null?$scope.cstmPersAddr.censusCounty='':$scope.cstmPersAddr.censusCounty;
           $scope.cstmPersAddr.propertyType == null?$scope.cstmPersAddr.propertyType='':$scope.cstmPersAddr.propertyType;
           $scope.cstmPersAddr.propertyProv == null?$scope.cstmPersAddr.propertyProv='':$scope.cstmPersAddr.propertyProv;
           $scope.cstmPersAddr.propertyCity == null?$scope.cstmPersAddr.propertyCity='':$scope.cstmPersAddr.propertyCity;
           $scope.cstmPersAddr.propertyCounty == null?$scope.cstmPersAddr.propertyCounty='':$scope.cstmPersAddr.propertyCounty;
           $scope.cstmPerson.quasiDriveModel == null?$scope.cstmPerson.quasiDriveModel='':$scope.cstmPerson.quasiDriveModel;
           $scope.rationalityPurchase.customerSource == null?$scope.rationalityPurchase.customerSource='':$scope.rationalityPurchase.customerSource;
           $scope.rationalityPurchase.purposePurchase == null?$scope.rationalityPurchase.purposePurchase='':$scope.rationalityPurchase.purposePurchase;
           $scope.rationalityPurchase.chooseReason == null?$scope.rationalityPurchase.chooseReason='':$scope.rationalityPurchase.chooseReason;
           $scope.cstmPersMate.isCommonBorrower == null?$scope.cstmPersMate.isCommonBorrower='':$scope.cstmPersMate.isCommonBorrower;
           $scope.cstmPersAddr.isHaveProperty == null?$scope.cstmPersAddr.isHaveProperty='':$scope.cstmPersAddr.isHaveProperty;

       }
    //客户性别
    $scope.genderList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gender);
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
    //准驾车型
    var typeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.quasiDriveModel);
    $scope.quasiDriveModelList =typeList.sort(CommonNumberUtils.compare('orderNo'));
    //是否共同借款人
    $scope.isCommonBorrowerList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.isCommonBorrower);
    //是否有房产
    $scope.isHavePropertyList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.isHaveProperty);
    //生肖
    $scope.chineseZodiacList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.chineseZodiac);
    //客户来源
    $scope.customerSourceList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.customerSource);
    //购车目的
    $scope.purposePurchaseList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.purposePurchase);
    //选择万量原因
    $scope.chooseReasonList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.chooseReason);
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
        if ($scope.cstmPersJob.compProv =="") {
            $scope.cityListJob = {};
            $scope.areaListJob={};
        } else {
            $scope.cityListJob=$scope.cityMapJob;
        }
        $scope.cstmPersJob.compCity="";
        $scope.cstmPersJob.compCounty="";
    }
    $scope.changeCityJob = function() {

        if ($scope.cstmPersJob.compCity =="") {
            $scope.areaListJob={};
        } else {
            $scope.areaListJob=$scope.areaMapJob;
        }
        $scope.cstmPersJob.compCounty="";

    }
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
        $scope.cstmPersMate.compCity="";
        $scope.cstmPersMate.compCounty="";
    }
    $scope.changeCityMate = function() {

        if ($scope.cstmPersMate.compCity =="") {
            $scope.areaListMate={};
        } else {
            $scope.areaListMate=$scope.areaMapMate;
        }
        $scope.cstmPersMate.compCounty="";

    }
    $scope.cityMap=common_area_value[common_area_code.getCityList];
    //key - arealist
    $scope.areaMap=common_area_value[common_area_code.getAreaList];
    $scope.provinceList=common_area_value[common_area_code.getProvinceList];
    //修改初始化地区
    $scope.cityList =$scope.cityMap;
    $scope.areaList=$scope.areaMap;
    //地址省市县调用
    $scope.changeCountryAddr = function() {
        if ($scope.cstmPersAddr.resideProv =="") {
            $scope.cityList = {};
            $scope.areaList={};
        } else {
            $scope.cityList=$scope.cityMap;
        }
        $scope.cstmPersAddr.resideCity="";
        $scope.cstmPersAddr.resideCounty="";
    }
    $scope.changeCityAddr = function() {

        if ($scope.cstmPersAddr.resideCity =="") {
            $scope.areaList={};
        } else {
            $scope.areaList=$scope.areaMap;
        }
        $scope.cstmPersAddr.resideCounty="";

    }
    $scope.cityMapCensus=common_area_value[common_area_code.getCityList];
    //key - arealist
    $scope.areaMapCensus=common_area_value[common_area_code.getAreaList];
    $scope.provinceListCensus=common_area_value[common_area_code.getProvinceList];
    //修改初始化地区
    $scope.cityListCensus =$scope.cityMapCensus;
    $scope.areaListCensus=$scope.areaMapCensus;
    //地址户籍省市县调用
    $scope.changeCountryCensus = function() {
        if ($scope.cstmPersAddr.censusProv =="") {
            $scope.cityListCensus = {};
            $scope.areaListCensus={};
        } else {
            $scope.cityListCensus=$scope.cityMapCensus;
        }
        $scope.cstmPersAddr.censusCity="";
        $scope.cstmPersAddr.censusCounty="";
    }
    $scope.changeCityCensus = function() {

        if ($scope.cstmPersAddr.censusCity =="") {
            $scope.areaListCensus={};
        } else {
            $scope.areaListCensus=$scope.areaMapCensus;
        }
        $scope.cstmPersAddr.censusCounty="";

    }
    $scope.cityMapProperty=common_area_value[common_area_code.getCityList];
    //key - arealist
    $scope.areaMapProperty=common_area_value[common_area_code.getAreaList];
    $scope.provinceListProperty=common_area_value[common_area_code.getProvinceList];
    //修改初始化地区
    $scope.cityListProperty =$scope.cityMapProperty;
    $scope.areaListProperty=$scope.areaMapProperty;
    //地址房产省市县调用
    $scope.changeCountryProperty = function() {
        if ($scope.cstmPersAddr.propertyProv =="") {
            $scope.cityListProperty = {};
            $scope.areaListProperty={};
        } else {
            $scope.cityListProperty=$scope.cityMapProperty;
        }
        $scope.cstmPersAddr.propertyCity="";
        $scope.cstmPersAddr.propertyCounty="";
    }
    $scope.changeCityProperty = function() {

        if ($scope.cstmPersAddr.propertyCity =="") {
            $scope.areaListProperty={};
        } else {
            $scope.areaListProperty=$scope.areaMapProperty;
        }
        $scope.cstmPersAddr.propertyCounty="";

    }

    //新增联系人
    $scope.saveContact = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/apply_input/cstm_contact_append.html'+getCacheTime(),
            controller: 'cstm_contact_append_controller',
            resolve:{
                cstmContactList:function () {
                    return [];
                },
                applyType:function () {
                    return $scope.applyType;
                }
            }
        });
        rtn.result.then(function (data) {
            $scope.cstmContactList.push(data[0]);
           initTable();
        },function(){
        });
    }
   //联系人列表
    initTable();
     function initTable(){
         // var tableData = [];
         // if($scope.cstmContactList.length>0){
         //     for(var i in $scope.cstmContactList){
         //         var node =[$scope.cstmContactList[i].name,$scope.cstmContactList[i].relation,$scope.cstmContactList[i].mobileNo,$scope.cstmContactList[i].resideAddr,i];
         //         tableData.push(node);
         //     }
         // }
         //参数配置
         $scope.dataTableProperties= {
             //table的html id
             dataTableId:'contact_table',
             dataTableColumn:[
                    {title:'联系人姓名',data:'name'},
                    {title:'是否租金联系人',data:'rentFlag',
                        render:function (data) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.yesNoFlag,data);
                        }
                    },
                    {title:'联系人关系',data:'relation',
                        render:function (data) {
                            if($scope.applyType==1){
                                return CommonCodeUtils.getCodeValueName('relationPer2',data);
                            }else{
                                return CommonCodeUtils.getCodeValueName('relationPerComp',data);
                            }
                        }
                    },
                    {title:'联系人号码',data:'mobileNo'},
                    {title:'联系人所在省份',data:'resideProv',
                     render:function (data) {
                         if(data){
                             return AreaUtils.getAreaName(data);
                         }else{
                             return "";
                         }
                     }
                    },
                    {title:'联系人所在城市',data:'resideCity',
                      render:function (data) {
                          if(data){
                              return AreaUtils.getAreaName(data);
                          }else{
                              return "";
                          }
                      }
                    },
                    {title:'联系人所在区县',data:'resideCounty',
                        render:function (data) {
                            if(data){
                                return AreaUtils.getAreaName(data);
                            }else{
                                return "";
                            }
                        }
                    },
                    {title:'联系人地址',data:'resideAddr'},
                    {title:'操作',data:'contactNo',
                         render: function (data, type, row, meta) {
                             var html = '<a style="color:#2dc9ff" ng-click="modContact('+'\''+data+'\''+')"></i>编辑</a>'
                                 + '&nbsp<a style="color:#2dc9ff" ng-click="delContact('+'\''+data+'\''+')"></i>删除</a>';
                             return html;
                         },
                         fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                             $compile(nTd)($scope);
                         }
                    }],
             dataTableData: $scope.cstmContactList
         }

         CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
    }
    // 编辑联系人
    $scope.modContact = function (data) {
        for(var i in $scope.cstmContactList){
            if($scope.cstmContactList[i].contactNo == data){
                var cstmContactList = [];
                cstmContactList[0] = $scope.cstmContactList[i];
                cstmContactList[0].index = i;
                $scope.cstmContactList.splice(i,1);
                        //新增联系人
                        var rtn = $modal.open({
                            backdrop : 'static',
                            size:'lg',
                            templateUrl: 'tpl/prebiz/apply_input/cstm_contact_append.html'+getCacheTime(),
                            controller: 'cstm_contact_append_controller',
                            resolve:{
                                cstmContactList:function () {
                                    return cstmContactList;
                                },
                                applyType:function () {
                                    return $scope.applyType;
                                }
                            }
                        });
                        rtn.result.then(function (data) {
                            $scope.cstmContactList.splice(data[0].index, 0, data[0]);
                            // $scope.cstmContactList.push(data[0]);
                            initTable();
                        },function(){
                        });
            }
        }
    };
   //删除表中联系人
    $scope.delContact = function (data) {
        for(var i in $scope.cstmContactList){
            if($scope.cstmContactList[i].contactNo == data){
                $scope.cstmContactList.splice(i,1);
                initTable();
                break;
            }
        }
    }

    // $scope.initPersCertiNo = function () {
    //     var certiType =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType,$scope.cstmPerson.certifType);
    //     var persCertiNo = document.getElementById('persCertiNo');
    //     if(certiType == '身份证'){
    //         persCertiNo.setAttribute('ng-pattern','/^\\d{6}(18|19|20)?\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|X)$/');
    //         $compile(persCertiNo)($scope);
    //         console.log(persCertiNo)
    //     }else{
    //         persCertiNo.setAttribute('ng-pattern','/^[0-9a-zA_Z]+$/');
    //         $compile(persCertiNo)($scope);
    //         console.log(persCertiNo)
    //     }
    // }
    //
    // $scope.initMateCertiNo = function () {
    //     var certiType =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType,$scope.cstmPersMate.certifType);
    //     var mateCertiNo = document.getElementById('mateCertiNo');
    //     if(certiType == '身份证'){
    //         mateCertiNo.setAttribute('ng-pattern','/^\\d{6}(18|19|20)?\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|X)$/');
    //         $compile(mateCertiNo)($scope);
    //         console.log(mateCertiNo)
    //     }else{
    //         mateCertiNo.setAttribute('ng-pattern','/^[0-9a-zA_Z]+$/');
    //         $compile(mateCertiNo)($scope);
    //         console.log(mateCertiNo)
    //     }
    // }


    $scope.vali = function () {
        cardIdCheck( $scope.cstmPerson.certifType,'persCertiNo',$compile,$scope);
    }
    $scope.mateValidate = function () {
        cardIdCheck($scope.cstmPersMate.certifType,'mateCertiNo',$compile,$scope);
    }

    $rootScope.mateCertifNo = $scope.cstmPersMate.certifNo;
    //crm信息带入
    $scope.selectCertifNo = function (type) {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/apply_input/crm_person_list.html'+getCacheTime(),
            controller: 'crm_person_list_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {
            if(data){
                $http.get('crm_person/findCrmPersonByCertifNo?certifNo='+data).success(function (data) {
                    if (data.code == Response.successCode){
                        console.log(data);
                        if(type == 1){
                            delete data.data.cstmPerson.applyNo;
                            delete data.data.cstmPersJob.applyNo;
                            delete data.data.cstmPersAddr.applyNo;
                            $scope.cstmPerson = $.extend(true,$scope.cstmPerson,data.data.cstmPerson);
                            $scope.cstmPerson.actCarUser = $scope.cstmPerson.name;
                            $scope.cstmPerson.driLicenseNo = $scope.cstmPerson.certifNo;
                            $scope.cstmPerson.actLicenseNo = $scope.cstmPerson.licenseNo;
                            $scope.cstmPerson.actIssueDate = $scope.cstmPerson.firstIssueDate;
                            $scope.cstmPerson.actDrivingAge = $scope.cstmPerson.drivingAge;
                            $scope.cstmPerson.quasiDriveModel == null?$scope.cstmPerson.quasiDriveModel='':$scope.cstmPerson.quasiDriveModel;
                            $scope.cstmPersJob = $.extend(true,$scope.cstmPersJob,data.data.cstmPersJob);
                            $scope.cstmPersAddr = $.extend(true,$scope.cstmPersAddr,data.data.cstmPersAddr);
                        }else{
                            if(data.data.cstmPersMate.applyNo){
                                delete data.data.cstmPersMate.applyNo;
                            }
                            $scope.cstmPersMate = $.extend(true,$scope.cstmPersMate,data.data.cstmPersMate);
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

   //  //校验合法性
   // $scope.mateIdCheck = function(){
   //     cardIdValidation($scope.cstmPersMate.certifType,$scope.cstmPersMate.certifNo,$modal);
   // }
   //  $scope.setAge = function () {
   //      if(cardIdValidation($scope.cstmPerson.certifType,$scope.cstmPerson.certifNo,$modal)){
   //          var certiType =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType,$scope.cstmPerson.certifType);
   //          if($scope.cstmPerson.certifNo && certiType=='身份证'){
   //              var cardId = $scope.cstmPerson.certifNo;
   //              if( cardId.length == 18){
   //                  var year = cardId.substr(6,4);
   //                  var date = new Date().getFullYear();
   //                  $scope.cstmPerson.age = parseInt(date) - parseInt(year) +1;
   //              }else if( cardId.length == 15){
   //                  var year = cardId.substr(6,2);
   //                  var date = new Date().getFullYear();
   //                  $scope.cstmPerson.age = parseInt(date) - parseInt(year)-1899;
   //              }
   //          }
   //      }
   //
   //  }

    //获取驾龄
    $scope.$watch('cstmPerson.firstIssueDate',function (newVal, oldVal) {
        if(newVal){
            var year = getDrivingAge(newVal);
            $scope.cstmPerson.drivingAge = year;
        }else{
            $scope.cstmPerson.drivingAge = 0;
        }
    });

    //获取驾龄
    $scope.$watch('cstmPerson.actIssueDate',function (newVal, oldVal) {
        if(newVal){
            var year = getDrivingAge(newVal);
            $scope.cstmPerson.actDrivingAge = year;
        }else{
            $scope.cstmPerson.actDrivingAge = 0;
        }
    });

    //地址同步
    $scope.synchroniz = function (type) {
        if(type == 1){
            $scope.cstmPersAddr.censusProv = $scope.cstmPersAddr.resideProv;
            $scope.cstmPersAddr.censusCity = $scope.cstmPersAddr.resideCity;
            $scope.cstmPersAddr.censusCounty = $scope.cstmPersAddr.resideCounty;
        }else{
            $scope.cstmPersAddr.propertyProv = $scope.cstmPersAddr.resideProv;
            $scope.cstmPersAddr.propertyCity = $scope.cstmPersAddr.resideCity;
            $scope.cstmPersAddr.propertyCounty = $scope.cstmPersAddr.resideCounty;
        }
    };
    //根据身份证获取
    $scope.changeCertifNo = function () {
        var isTrue = false;
        if($scope.cstmPerson.certifNo){
            isTrue = /(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/.test($scope.cstmPerson.certifNo);
        }
        if(isTrue){
            $scope.cstmPerson.chineseZodiac = getPet($scope.cstmPerson.certifNo);
            $scope.cstmPerson.birthDate = getBirthday($scope.cstmPerson.certifNo);
            $scope.cstmPerson.sex = getSex($scope.cstmPerson.certifNo);
            $scope.cstmPerson.age = getAge($scope.cstmPerson.certifNo);
        }
    };

    //checkbox赋值
    $scope.checkboxValue = function (name,value) {
        $scope.form[name].$dirty = true;
        var itemList = $scope[name+'List'];
        var item = $scope.cstmPerson[name];
        if(!item){
            item = [];
        }else{
            item = item.split(',');
        }
        var index = item.indexOf(value);
        if(index==-1){
            item.push(value);
        }else{
            item.splice(index,1);
        }
        $scope.cstmPerson[name] = CommonStringUtils.arrToString(item);
    };
}]);
