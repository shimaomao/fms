/**
 * Created by ningyangyang on 2018/4/8.
 */
//新增联系人信息
app.controller('cstm_contact_append_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','cstmContactList','applyType',function ($scope, $http,$modal, $modalInstance,toaster,cstmContactList,applyType) {
    //担保人关系
    if(applyType==1){
        $scope.relationTypeList = CommonCodeUtils.getCommonCodes('relationPer2');
    }else{
        $scope.relationTypeList = CommonCodeUtils.getCommonCodes('relationPerComp');
    }
    $scope.rentFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.yesNoFlag);
    $scope.cstmContact={};
    $scope.cstmContact.rentFlag = '0';

    $scope.formValidate = false;

    $scope.submit = false;
    $scope.cstmContactList = cstmContactList;
    if ($scope.cstmContactList && $scope.cstmContactList.length > 0){
        $scope.cstmContact.contactNo = $scope.cstmContactList[0].contactNo;
        $scope.cstmContact.name = $scope.cstmContactList[0].name;
        $scope.cstmContact.rentFlag = $scope.cstmContactList[0].rentFlag;
        $scope.cstmContact.relation = $scope.cstmContactList[0].relation;
        $scope.cstmContact.mobileNo = $scope.cstmContactList[0].mobileNo;
        $scope.cstmContact.resideProv = $scope.cstmContactList[0].resideProv;
        $scope.cstmContact.resideCity = $scope.cstmContactList[0].resideCity;
        $scope.cstmContact.resideCounty = $scope.cstmContactList[0].resideCounty;
        $scope.cstmContact.resideAddr = $scope.cstmContactList[0].resideAddr;
        $scope.index = $scope.cstmContactList[0].index;
    }
    //添加第一个用户信息
    /**
     * 保存菜单信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {
            if ($scope.cstmContactList && $scope.cstmContactList.length > 0){
                $scope.cstmContact.contactNo = $scope.cstmContactList[0].contactNo?Math.random()*100000+$scope.cstmContactList.length:$scope.cstmContactList[0].contactNo;
            } else {
                $scope.cstmContact.contactNo = Math.random()*100000+$scope.cstmContactList.length;
            }
            $scope.cstmContact.resideProv = $scope.cstmContact.resideProv?$scope.cstmContact.resideProv:"";
            $scope.cstmContact.resideCity = $scope.cstmContact.resideCity?$scope.cstmContact.resideCity:"";
            $scope.cstmContact.resideCounty = $scope.cstmContact.resideProv?$scope.cstmContact.resideCounty:"";
            $scope.cstmContact.resideAddr = $scope.cstmContact.resideAddr?$scope.cstmContact.resideAddr:"";
            $scope.cstmContact.index = $scope.index;
            $scope.cstmContactList.splice(0,1);
            $scope.cstmContactList.push($scope.cstmContact);
            $scope.close($scope.cstmContactList);
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }


    }
    //地区信息
    //key - citylist
    $scope.cityMap=common_area_value[common_area_code.getCityList];
    //key - arealist
    $scope.areaMap=common_area_value[common_area_code.getAreaList];
    $scope.provinceList=common_area_value[common_area_code.getProvinceList];
    //修改初始化地区
    $scope.cityList =$scope.cityMap;
    $scope.areaList=$scope.areaMap;
    //联系人省市县调用
    $scope.changeCountryReside = function() {
        if ($scope.cstmContact.resideProv =="") {
            $scope.cityList = {};
            $scope.areaList={};
        } else {
            $scope.cityList=$scope.cityMap;
        }
        $scope.cstmContact.resideCity="";
        $scope.cstmContact.resideCounty="";
    }
    $scope.changeCityReside = function() {

        if ($scope.cstmContact.resideCity =="") {
            $scope.areaList={};
        } else {
            $scope.areaList=$scope.areaMap;
        }
        $scope.cstmContact.resideCounty="";

    }
    /**
     * 关闭窗口
     * @param status
     */
    var datas = $scope.cstmContactList
    $scope.close = function(){
        $modalInstance.close(datas);
    };
}]);