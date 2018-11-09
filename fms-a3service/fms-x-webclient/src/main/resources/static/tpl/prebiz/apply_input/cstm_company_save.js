/**
 * Created by ningyangyang on 2018-03-27.
 */
app.controller('cstm_company_save_controller', ['$scope', '$http','$modal','toaster','$compile','$location','$filter',function ($scope, $http,$modal,toaster,$compile,$location,$filter) {

    $scope.cstmCompany =  $scope.$parent.cstmCompany;
    $scope.cstmCompany.quasiDriveModel = "";
    $scope.applyType =  $scope.$parent.applyType;
    $scope.cstmContactList = $scope.$parent.cstmContactList;
    $scope.rationalityPurchase = $scope.$parent.rationalityPurchase;
    $scope.companyType = $scope.$parent.companyType;
    $scope.stockAssetsList = [];

    //任务id
    $scope.taskId = $scope.$parent.taskId;

    //从报价单画面跳转
    var quotationDeviceVo = $location.search()['quotationDeviceVo'];
    if(quotationDeviceVo) {
        quotationDeviceVo = JSON.parse(quotationDeviceVo);
        $scope.cstmCompany.name = quotationDeviceVo.name;
    }

    $scope.$watch("cstmCompany",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal)
            $scope.$emit("companyToFather",$scope.cstmCompany);
    },true);
    $scope.$watch("companyType",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal)
            $scope.$emit("companyTypeToFather",$scope.companyType);
    },true);
    $scope.$watch("cstmContactList",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal)
            $scope.$emit("contactsToFather",$scope.cstmContactList);
    },true);
    $scope.$watch("rationalityPurchase",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal)
            $scope.$emit("rationalityPurchaseToFather",$scope.rationalityPurchase);
    },true);
    $scope.$watch("stockAssetsList",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal)
            $scope.$emit("stockAssetsListToFather",$scope.stockAssetsList);
    },true);
    $scope.$watch("remark",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal)
            $scope.$emit("remarkToFather",$scope.remark);
    });
   $scope.applyNo = $scope.$parent.applyNo;
    if($scope.applyNo){
        $http.get('apply_input/findApplyCstmPersonByApplyNo?applyNo='+ $scope.applyNo).success(function (data) {
            $scope.applyInputVo = data.data;
            $scope.cstmContactList = $scope.applyInputVo.cstmContactList;
            $scope.cstmCompany = $scope.applyInputVo.cstmCompany;
            $scope.stockAssetsList = $scope.applyInputVo.stockAssetsList;
            $scope.rationalityPurchase =$scope.applyInputVo.rationalityPurchase ;
            $scope.companyType.companyType1 =$scope.applyInputVo.companyType1 ;
            $scope.remark =$scope.applyInputVo.remark ;
            if($scope.companyType.companyType1 == CommonCodeUtils.companyType.company){
                $scope.companyTypeList2 = $scope.companyTypeCompList;
            }else if($scope.companyType.companyType1 == CommonCodeUtils.companyType.sale){
                $scope.companyTypeList2 = $scope.companyTypeSaleList;
            }else {
                $scope.compTypeList2 = [];
            }
            $scope.companyType.companyType2 =$scope.applyInputVo.companyType2 ;

            initTable();
            initProperty();
        });
    }
   function initProperty(){
       $scope.cstmCompany.compProv==null?$scope.cstmCompany.compProv='':$scope.cstmCompany.compProv;
       $scope.cstmCompany.compCity==null?$scope.cstmCompany.compCity='':$scope.cstmCompany.compCity;
       $scope.cstmCompany.compCounty==null?$scope.cstmCompany.compCounty='':$scope.cstmCompany.compCounty;
       $scope.cstmCompany.certifType==null?$scope.cstmCompany.certifType='':$scope.cstmCompany.certifType;
       $scope.cstmCompany.compType==null?$scope.cstmCompany.compType='':$scope.cstmCompany.compType;
       $scope.cstmCompany.quasiDriveModel == null?$scope.cstmCompany.quasiDriveModel='':$scope.cstmCompany.quasiDriveModel;
   }

    //证件类型
    $scope.certifTypeList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.certifType);
    //发票类型
    $scope.invoiceTypeList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.invoiceType);
    //准驾车型
    var typeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.quasiDriveModel);
    $scope.quasiDriveModelList =typeList.sort(CommonNumberUtils.compare('orderNo'));
    //客户来源
    $scope.customerSourceList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.customerSource);
    //购车目的
    $scope.purposePurchaseList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.purposePurchase);
    //选择万量原因
    $scope.chooseReasonList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.chooseReason);
    //企业性质
    $scope.compTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.compType);
    $scope.compTypeList2 = [];
    //企业类型1
    $scope.companyTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.companyType);
    //企业类型2_企业
    $scope.companyTypeCompList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.companyTypeComp);
    //企业类型2_经销商
    $scope.companyTypeSaleList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.companyTypeSale);

    $scope.changeCompanyType = function () {
        if($scope.companyType.companyType1 == CommonCodeUtils.companyType.company){
            $scope.companyTypeList2 = $scope.companyTypeCompList;
        }else if($scope.companyType.companyType1 == CommonCodeUtils.companyType.sale){
            $scope.companyTypeList2 = $scope.companyTypeSaleList;
        }else {
            $scope.compTypeList2 = [];
        }

        $scope.companyType.companyType2 = "";
    };

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
        if ($scope.cstmCompany.compProv =="") {
            $scope.cityList = {};
            $scope.areaList={};
        } else {
            $scope.cityList=$scope.cityMap;
        }
        $scope.cstmCompany.compCity="";
        $scope.cstmCompany.compCounty="";
    };
    $scope.changeCity = function() {

        if ($scope.cstmCompany.compCity =="") {
            $scope.areaList={};
        } else {
            $scope.areaList=$scope.areaMap;
        }
        $scope.cstmCompany.compCounty="";

    };
    //修改注册地址
    $scope.registerCityList =$scope.cityMap;
    $scope.registerCountyList=$scope.areaMap;
    $scope.changeRegisterProv = function() {
        if ($scope.cstmCompany.registerProv =="") {
            $scope.registerCityList = {};
            $scope.registerCountyList={};
        } else {
            $scope.registerCityList=$scope.cityMap;
        }
        $scope.cstmCompany.registerCity="";
        $scope.cstmCompany.registerCounty="";
    };
    $scope.changeRegisterCity = function() {

        if ($scope.cstmCompany.registerCity =="") {
            $scope.registerCountyList={};
        } else {
            $scope.registerCountyList=$scope.areaMap;
        }
        $scope.cstmCompany.registerCountyList="";

    };
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
            // $scope.cstmContactList=data;
            initTable();
        },function(){
        });
    };
    //联系人列表
    initTable();
    function initTable(){
        /*var tableData = [];
        if($scope.cstmContactList && $scope.cstmContactList.length>0){
            for(var i in $scope.cstmContactList){
                var node =[$scope.cstmContactList[i].name,$scope.cstmContactList[i].relation,$scope.cstmContactList[i].mobileNo,$scope.cstmContactList[i].resideAddr,i];
                tableData.push(node);
            }
        }*/
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
                }
            ],
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

    // $scope.initCertiNo = function () {
    //     var certiType =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType,$scope.cstmCompany.certifType);
    //     var compCertiNo = document.getElementById('compCertiNo');
    //     if(certiType == '身份证'){
    //         compCertiNo.setAttribute('ng-pattern','/^\\d{6}(18|19|20)?\\d{2}(0[1-9]|1[12])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|X)$/');
    //         $compile(compCertiNo)($scope);
    //     }else{
    //         compCertiNo.setAttribute('ng-pattern','/^[0-9a-zA_Z]+$/');
    //         $compile(compCertiNo)($scope);
    //     }
    // }

    $scope.certiValidate = function () {
        cardIdCheck($scope.cstmCompany.certifType,'compCertiNo',$compile,$scope);
    }

    //crm企业
    $scope.selectCompany = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/apply_input/crm_company_list.html'+getCacheTime(),
            controller: 'crm_company_list_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {
            if(data){
                if(data.applyNo){
                    delete data.applyNo;
                }
                $scope.cstmCompany = $.extend(true,$scope.cstmCompany,data);
                $scope.cstmCompany.quasiDriveModel == null?$scope.cstmCompany.quasiDriveModel='':$scope.cstmCompany.quasiDriveModel;
                $scope.stockAssetsList = data.crmStockAssetsVoList;

            }
        },function(){
        });
    };

    //获取驾龄
    $scope.$watch('cstmCompany.firstIssueDate',function () {
        if($scope.cstmCompany.firstIssueDate){
            $scope.cstmCompany.drivingAge = getDrivingAge($scope.cstmCompany.firstIssueDate);
        }else{
            $scope.cstmCompany.drivingAge = 0;
        }
    });

    //成立年限
    $scope.changeEstablDate = function () {
        if($scope.cstmCompany.establDate){
            $scope.cstmCompany.establYear = getDrivingAge($scope.cstmCompany.establDate);
        }else{
            $scope.cstmCompany.establYear = 0;
        }
    };

    //股东信息
    //添加
    $scope.addStockAssets = function () {
        $scope.stockAssetsList.push({
            shareholderName:'',
            shareRatio:'',
            contribution:''
        });
    };
    //删除
    $scope.delStockAssets = function (index) {
        $scope.stockAssetsList.splice(index,1);
        $scope.changeStock();
    };

    //发票抬头
    // $scope.$watch('cstmCompany.name',function (newVal,oldVal) {
    //     if (isNotUndefinedNull(newVal)&& newVal != oldVal){
    //         $scope.cstmCompany.ticketOpening = $scope.cstmCompany.name;
    //     }
    // });
    //开票名
    $scope.invoiceSet = function () {
        $scope.cstmCompany.ticketOpening = $scope.cstmCompany.name;
    }

    //同步地址
    $scope.synchroniz = function (type) {
      if(type == 1){
          if($scope.cstmCompany.registerProv && $scope.cstmCompany.registerCity && $scope.cstmCompany.registerCounty && $scope.cstmCompany.registerAddr){
              $scope.cstmCompany.invoiceMailAddr = $filter('getAreaName')($scope.cstmCompany.registerProv)+'-'+$filter('getAreaName')($scope.cstmCompany.registerCity)+'-'+$filter('getAreaName')($scope.cstmCompany.registerCounty)+'-'+$scope.cstmCompany.registerAddr;
          }else{
              $scope.form.registerProv.$dirty = true;
              $scope.form.registerCity.$dirty = true;
              $scope.form.registerCounty.$dirty = true;
              $scope.form.registerAddr.$dirty = true;
              modalAlert($modal,"请先填写注册地址");
          }
      }else{
          if($scope.cstmCompany.compProv && $scope.cstmCompany.compCity && $scope.cstmCompany.compCounty && $scope.cstmCompany.compAddr){
              $scope.cstmCompany.invoiceMailAddr = $filter('getAreaName')($scope.cstmCompany.compProv)+'-'+$filter('getAreaName')($scope.cstmCompany.compCity)+'-'+$filter('getAreaName')($scope.cstmCompany.compCounty)+'-'+$scope.cstmCompany.compAddr;
          }else{
              $scope.form.compProv.$dirty = true;
              $scope.form.compCity.$dirty = true;
              $scope.form.compCounty.$dirty = true;
              $scope.form.compAddr.$dirty = true;
              modalAlert($modal,"请先填写经营地址");
          }
      }
    };


    //checkbox赋值
    $scope.checkboxValue = function (name,value) {
        $scope.form[name].$dirty = true;
        var itemList = $scope[name+'List'];
        var item = $scope.cstmCompany[name];
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
        $scope.cstmCompany[name] = CommonStringUtils.arrToString(item);
    };

    //计算股份总额
    $scope.changeStock = function () {
        var arr = $scope.stockAssetsList;
        var shareRatioSum = 0,contributionSum = 0;
        for(var i=0;i<arr.length;i++){
            if(arr[i].shareRatio){
                shareRatioSum += arr[i].shareRatio*1;
            }
            if(arr[i].contribution){
                contributionSum += arr[i].contribution*1;
            }
        }
        $scope.shareRatioSum = shareRatioSum.toFixed(2);
        $scope.contributionSum = contributionSum.toFixed(2);
    };
}]);


