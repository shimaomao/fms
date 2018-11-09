/**
 * Created by ningyangyang on 2018/4/9.
 */

app.controller('cstm_person_detail_controller', ['$scope', '$http','$modal','toaster','$location', '$compile',function ($scope, $http,$modal,toaster,$location,$compile) {
    $scope.applyNo = $scope.$parent.applyNo;
    $scope.applyType = $scope.$parent.applyType;
    $scope.historyBtn = $scope.$parent.historyBtn;
    //准驾车型
    $scope.quasiDriveModelList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.quasiDriveModel);

    $http.get('apply_input/findApplyCstmPersonByApplyNo?applyNo='+ $scope.applyNo).success(function (data) {
            $scope.applyInputVo = data.data;
            console.log($scope.applyInputVo);
            $scope.cstmContactList = $scope.applyInputVo.cstmContactList;
            $scope.cstmPerson = $scope.applyInputVo.cstmPerson;
            $scope.cstmPersJob= $scope.applyInputVo.cstmPersJob ;
            $scope.cstmPersMate= $scope.applyInputVo.cstmPersMate ;
            $scope.cstmPersAddr =$scope.applyInputVo.cstmPersAddr ;
            $scope.rationalityPurchase =$scope.applyInputVo.rationalityPurchase ;
            $scope.cstmPerson.quasiDriveModel == null?$scope.cstmPerson.quasiDriveModel='':$scope.cstmPerson.quasiDriveModel;
            console.log($scope.cstmPersAddr);
        initTable();
        init();
        });

    function init(){
        //证件类型
        $scope.cstmPerson.certifTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType, $scope.cstmPerson.certifType);
        //个人客户性别
        $scope.cstmPerson.sexName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gender,$scope.cstmPerson.sex);
        //个人婚姻状况
        $scope.cstmPerson.marriageStatusName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.marriageStatus,$scope.cstmPerson.marriageStatus)
        $scope.cstmPerson.censusTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.censusType,$scope.cstmPerson.censusType);
        $scope.cstmPerson.eduBgTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.eduBgType,$scope.cstmPerson.eduBgType);
        $scope.cstmPerson.ethnicTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.ethnicType,$scope.cstmPerson.ethnicType);
        $scope.cstmPersJob.industryName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.industryType,$scope.cstmPersJob.industry);
        $scope.cstmPersJob.professionName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.professionType, $scope.cstmPersJob.profession);
        $scope.cstmPersJob.positionName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.positionType,$scope.cstmPersJob.position);
       // $scope.cstmPersJob.workYearName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.workYear,$scope.cstmPersJob.workYear);
        $scope.cstmPersJob.compProvName = AreaUtils.getAreaName($scope.cstmPersJob.compProv)
        $scope.cstmPersJob.compCityName = AreaUtils.getAreaName($scope.cstmPersJob.compCity);
        $scope.cstmPersJob.compCountyName = AreaUtils.getAreaName($scope.cstmPersJob.compCounty);
        $scope.cstmPersMate.certifTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType,$scope.cstmPersMate.certifType)
        $scope.cstmPersMate.positionName =  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.positionType,$scope. cstmPersMate.position);
        $scope.cstmPersMate.compProvName  = AreaUtils.getAreaName($scope.cstmPersMate.compProv);
        $scope.cstmPersMate.compCityName  = AreaUtils.getAreaName($scope.cstmPersMate.compCity);
        $scope.cstmPersMate.compCountyName  = AreaUtils.getAreaName($scope.cstmPersMate.compCounty);
        $scope.cstmPersAddr.resideCondName  = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.resideCond,$scope.cstmPersAddr.resideCond);
        $scope.cstmPersAddr.resideYearName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.resideYear,$scope.cstmPersAddr.resideYear);
        $scope.cstmPersAddr.resideProvName = AreaUtils.getAreaName($scope.cstmPersAddr.resideProv);
        $scope.cstmPersAddr.resideCityName = AreaUtils.getAreaName($scope.cstmPersAddr.resideCity);
        $scope.cstmPersAddr.resideCountyName = AreaUtils.getAreaName($scope.cstmPersAddr.resideCounty);
        $scope.cstmPersAddr.censusProvName = AreaUtils.getAreaName($scope.cstmPersAddr.censusProv);
        $scope.cstmPersAddr.censusCityName = AreaUtils.getAreaName($scope.cstmPersAddr.censusCity);
        $scope.cstmPersAddr.censusCountyName = AreaUtils.getAreaName($scope.cstmPersAddr.censusCounty);
        $scope.cstmPersAddr.propertyTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.propertyType,$scope.cstmPersAddr.propertyType);
        $scope.cstmPersAddr.propertyProvName = AreaUtils.getAreaName($scope.cstmPersAddr.propertyProv);
        $scope.cstmPersAddr.propertyCityName = AreaUtils.getAreaName($scope.cstmPersAddr.propertyCity);
        $scope.cstmPersAddr.propertyCountyName = AreaUtils.getAreaName($scope.cstmPersAddr.propertyCounty);

    }
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
                        if(isNullEmpty(data))
                            return '';
                        return AreaUtils.getAreaName(data);
                    }
                },
                {title:'联系人所在城市',data:'resideCity',
                    render:function (data) {
                        if(isNullEmpty(data))
                            return '';
                        return AreaUtils.getAreaName(data);
                    }
                },
                {title:'联系人所在区县',data:'resideCounty',
                    render:function (data) {
                        if(isNullEmpty(data))
                            return '';
                        return AreaUtils.getAreaName(data);
                    }
                },
                {title:'联系人地址',data:'resideAddr'},
            ],
            dataTableData: $scope.cstmContactList
        };

        CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
    }

    //查看基本信息变更历史
    $scope.basicHistory = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/postbiz_contract_list/pers_basic_hi_change.html'+getCacheTime(),
            controller: 'postbiz_pers_basic_hi_change_controller',
            resolve:{
                applyNo:function () {
                    return  $scope.cstmPerson.applyNo;
                }
            }
        });
    };

}]);

