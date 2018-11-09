/**
 * Created by ningyangyang on 2018/4/11.
 */
app.controller('cstm_company_detail_controller', ['$scope', '$http','$modal','toaster','$location', '$compile',function ($scope, $http,$modal,toaster,$location,$compile) {


    $scope.applyNo = $scope.$parent.applyNo;
    $scope.historyBtn = $scope.$parent.historyBtn;
    //准驾车型
    $scope.quasiDriveModelList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.quasiDriveModel);
    $http.get('apply_input/findApplyCstmPersonByApplyNo?applyNo='+ $scope.applyNo).success(function (data) {
        $scope.applyInputVo = data.data;
        $scope.cstmContactList = $scope.applyInputVo.cstmContactList;
        $scope.cstmCompany = $scope.applyInputVo.cstmCompany;
        $scope.rationalityPurchase = $scope.applyInputVo.rationalityPurchase;
        $scope.stockAssetsList = $scope.applyInputVo.stockAssetsList;
        $scope.companyType1 = $scope.applyInputVo.companyType1;
        $scope.companyType2 = $scope.applyInputVo.companyType2;
        if($scope.companyType1 == CommonCodeUtils.companyType.company){
            $scope.companyType2 = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.companyTypeComp,$scope.companyType2);
        }else{
            $scope.companyType2 = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.companyTypeSale,$scope.companyType2);
        }
        $scope.cstmCompany.quasiDriveModel == null?$scope.cstmCompany.quasiDriveModel='':$scope.cstmCompany.quasiDriveModel;
        initTable();
        init();
        $scope.changeStock();
    });
   //初始化
    function init(){
        $scope.cstmCompany.certifTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType,$scope.cstmCompany.certifType);
        $scope.cstmCompany.compProvName = AreaUtils.getAreaName( $scope.cstmCompany.compProv)
        $scope.cstmCompany.compCityName = AreaUtils.getAreaName( $scope.cstmCompany.compCity)
        $scope.cstmCompany.compCountyName = AreaUtils.getAreaName( $scope.cstmCompany.compCounty)
        $scope.cstmCompany.compTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.compType,$scope.cstmCompany.compType);
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
                        return AreaUtils.getAreaName(data);
                    }
                },
                {title:'联系人所在城市',data:'resideCity',
                    render:function (data) {
                        return AreaUtils.getAreaName(data);
                    }
                },
                {title:'联系人所在区县',data:'resideCounty',
                    render:function (data) {
                        return AreaUtils.getAreaName(data);
                    }
                },
                {title:'联系人地址',data:'resideAddr'},
            ],
            dataTableData: $scope.cstmContactList
        }

        CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
    }

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

    //查看开票信息变更历史
    $scope.invoiceHistory = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/postbiz_contract_list/invoice_hi_change.html'+getCacheTime(),
            controller: 'postbiz_invoice_hi_change_controller',
            resolve:{
                socialCertifNo:function () {
                    return  $scope.cstmCompany.socialCertifNo;
                }
            }
        });
    };

    //查看基本信息变更历史
    $scope.basicHistory = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/postbiz_contract_list/comp_basic_hi_change.html'+getCacheTime(),
            controller: 'postbiz_comp_basic_hi_change_controller',
            resolve:{
                applyNo:function () {
                    return  $scope.cstmCompany.applyNo;
                }
            }
        });
    };
}]);