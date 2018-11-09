/**
 * Created by ningyangyang on 2018-03-30.
 */
app.controller('guarantee_comp_save_controller', ['$scope', '$http','$modal','toaster','$location','guaranteeCompList','$modalInstance','$compile','applyType',function ($scope, $http,$modal,toaster,$location,guaranteeCompList,$modalInstance,$compile,applyType) {
    $scope.guaranteeComp={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.guaranteeCompList = guaranteeCompList;
    
    //承租人与担保人关系
    if(applyType==1){
        $scope.relationTypeCompList = CommonCodeUtils.getCommonCodes('relationPerComp');
    }else{
        $scope.relationTypeCompList = CommonCodeUtils.getCommonCodes('relationComp2');
    }
    //担保人与担保人关系
    $scope.relationTypeCompList2 = CommonCodeUtils.getCommonCodes('guaRelationComp');
    if($scope.guaranteeCompList.length>=2){
        $scope.isRequire = true;
    }else{
        $scope.isRequire = false;
    }

    //保存担保企业信息
    $scope.save = function () {
        if(!$scope.form.$invalid ) {
            $scope.guaranteeComp.type = '企业';
            $scope.guaranteeComp.guarCompNo = Math.random()*10000+$scope.guaranteeComp.socialCertifNo
            $scope.guaranteeCompList.push($scope.guaranteeComp)
            $scope.close($scope.guaranteeCompList);
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }

    };
    //企业性质
    $scope.compTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.compType)
    //证件类型
    $scope.certifTypeList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.certifType);
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
    };
    $scope.changeCity = function() {

        if ($scope.guaranteeComp.compCity =="") {
            $scope.areaList={};
        } else {
            $scope.areaList=$scope.areaMap;
        }
        $scope.guaranteeComp.compCounty="";

    };
    //修改初始化地区
    $scope.registerCityList =$scope.cityMap;
    $scope.registerCountyList=$scope.areaMap;
    //担保人信息省市县调用
    $scope.changeRegisterProv = function() {
        if ($scope.guaranteeComp.registerProv =="") {
            $scope.registerCityList = {};
            $scope.registerCountyList={};
        } else {
            $scope.registerCityList=$scope.cityMap;
        }
        $scope.guaranteeComp.registerCity="";
        $scope.guaranteeComp.registerCounty="";
    };
    $scope.changeRegisterCity = function() {

        if ($scope.guaranteeComp.registerCity =="") {
            $scope.registerCountyList={};
        } else {
            $scope.registerCountyList=$scope.areaMap;
        }
        $scope.guaranteeComp.registerCountyList="";

    };

    //身份证验证
    $scope.guaranteeCompValidate = function () {
        cardIdCheck( $scope.guaranteeComp.certifType,'guaranteeCompCertiNo',$compile,$scope);
    };

    // //校验合法性
    // $scope.idValidation = function(){
    //     return  cardIdValidation($scope.guaranteeComp.certifType,$scope.guaranteeComp.certifNo,$modal);
    // }
    //提交验证
    function check(){
        return cardIdValidation($scope.guaranteeComp.certifType,$scope.guaranteeComp.certifNo,$modal)

    }
    /**
     * 关闭窗口
     * @param status
     */
    var datas = $scope.guaranteeCompList;
    $scope.close = function(){
        $modalInstance.close(datas);
    };

    $scope.selectSocialCertifNo = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/apply_input/crm_company_list.html'+getCacheTime(),
            controller: 'crm_company_list_controller',
            resolve:{}
        });
        rtn.result.then(function (data) {
            if(data){
                console.log(data);
                $scope.guaranteeComp = data;
            }
        },function(){
        });
    };
}]);


