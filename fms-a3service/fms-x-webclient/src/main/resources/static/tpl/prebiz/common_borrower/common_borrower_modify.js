/**
 * Created by ningyangyang on 2018-05-25.
 */
app.controller('common_borrower_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','$compile','borrower', function ($scope, $http,$modal, $modalInstance,toaster,$compile,borrower) {
    $scope.submit = false;
    $scope.formValidate = false;
    $scope.commonBorrower={};
    if(borrower.data){
        $scope.commonBorrower = borrower.data;
    }
    //证件类型
    $scope.certifTypeList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.certifType);
    //职位
    $scope.positionTypeList =  CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.positionType);

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
        if ($scope.commonBorrower.compProv =="") {
            $scope.cityList = {};
            $scope.areaList={};
        } else {
            $scope.cityList=$scope.cityMap;
        }
        $scope.commonBorrower.compCity="";
        $scope.commonBorrower.compCounty="";
    };
    $scope.changeCity = function() {
        if ($scope.commonBorrower.compCity =="") {
            $scope.areaList={};
        } else {
            $scope.areaList=$scope.areaMap;
        }
        $scope.commonBorrower.compCounty="";

    };

    $scope.certiValidate = function () {
        cardIdCheck( $scope.commonBorrower.certifType,'compCertiNo',$compile,$scope);
    };

    //保存
    $scope.save = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.close({
                data:$scope.commonBorrower,
                index: borrower.index
            });
        }else{
            $scope.formValidate = true;
        }
    };

    //关闭窗口
    $scope.close = function(status){
        $modalInstance.close(status);
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
                        $scope.commonBorrower = $.extend(true,$scope.commonBorrower,data.data.commonBorrower);
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
}]);


