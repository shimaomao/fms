/**
 * Created by yanfengbo on 2018-03-26.
 */
app.controller('bas_bank_info_detail_controller', ['$scope', '$http','$modal','$location','$rootScope', function ($scope, $http,$modal,$location,$rootScope) {

    $scope.basBankInfo={};
    $scope.httpData = true;
    //附件对象
    $scope.bizFilesList= [];
    $scope.frameTitle=$location.search()['frameTitle'];

    $scope.showCheck=$location.search()['operate']=='check'||false;

    $scope.areaName=AreaUtils.getAllAreaName();

    if ($scope.showCheck) {

        $http.get('bas_bank_info/findBasBankInfoByBankId?bankId='+ $location.search()['bankId']).success(function(data){
            $scope.basBankInfo = data.data;
            //附件赋值
            $scope.bizFilesList = $scope.basBankInfo.bizFilesList;
            $scope.basBankInfo.enableFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,$scope.basBankInfo.enableFlag);
            $scope.basBankInfo.accDefaultName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.accDefault,$scope.basBankInfo.accDefault);
            $scope.basBankInfo.openingBankName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.openingBank,$scope.basBankInfo.accBank);
            $scope.basBankInfo.organizationTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.organizationType,$scope.basBankInfo.organizationType);
            $scope.basBankInfo.accountNoStatusName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.accountNoStatus,$scope.basBankInfo.accountNoStatus);
            if ($scope.basBankInfo.organizationType == 4){
                $scope.basBankInfo.organizationIdName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsAccType,$scope.basBankInfo.organizationId);
            }else if ($scope.basBankInfo.organizationType == 5){
                $scope.basBankInfo.organizationIdName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.mortgageAccType,$scope.basBankInfo.organizationId);
            }else if ($scope.basBankInfo.organizationType == 6){
                $scope.basBankInfo.organizationIdName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.insuranceAccType,$scope.basBankInfo.organizationId);
            }
        });
    }



    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/baseinfo_bas_bank_info_list");
    };

}]);





