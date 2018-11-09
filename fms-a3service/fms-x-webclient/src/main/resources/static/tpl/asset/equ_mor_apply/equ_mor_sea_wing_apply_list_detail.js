/**
 * Created by qiaohao on 2018/5/31.
 */
app.controller('equ_mor_sea_wing_apply_list_detail_controller', ['$scope', '$http', '$modal', 'toaster', '$location', function ($scope, $http, $modal, toaster, $location) {

    $scope.equMorTask = {};

    $scope.equMorDetail = {};

    $scope.equMorApplyVo = {};

    $scope.equMorTaskNo = $location.search()['equMorTaskNo']?$location.search()['equMorTaskNo']:$scope.$parent.equMorTaskNo;
    $scope.type = $location.search()['type'];

        $http.get('equ_mor_apply/findEquMorApplyVoByEquMorTaskNo?equMorTaskNo=' + $scope.equMorTaskNo).success(function (data) {
            if (data.code == Response.successCode) {
                $scope.equMorApplyVo = data.data;
                console.log($scope.equMorApplyVo)
                $scope.contFinDetailVosList = $scope.equMorApplyVo.contFinDetailVos;
                $scope.equMorApplyVo.rentPayModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.rentPayMode, $scope.equMorApplyVo.rentPayMode);
                $scope.equMorApplyVo.licenseAttrName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr, $scope.equMorApplyVo.licenseAttr);
                $scope.equMorTask = data.data.equMorTaskVo;
                $scope.equMorDetail = data.data.equMorDetailVo;
                //合同保证金比例设为固定值30%
                $scope.equMorDetail.contractMarginRatio = 30;
                //业务类别不为尾款业务时,尾款比例设为固定值0%
                if($scope.equMorDetail.serviceCategory!=1){
                    $scope.equMorDetail.balanceRatio = 0;
                }
            }
            else
                modalAlert($modal, data.message);
        }).error(function (data) {
            modalAlert($modal, data);
        })


    $scope.managementList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.management);
    $scope.mortgageProcessList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.mortgageProcess);
    $scope.finPeriodTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.finPeriodType);
    //业务类别
    $scope.serviceCategoryList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.serviceCategory);
    //租赁期限
    $scope.leasePeriodList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.leasePeriod);

    //业务类别为常规业务时的租赁期限
    $scope.leasePeriodCgList = [];
    //业务类别为尾款业务时的租赁期限
    $scope.leasePeriodWkList = [];

    for (var j = 0; j < $scope.serviceCategoryList.length; j++) {
        //业务类别为常规业务
        if ($scope.serviceCategoryList[j].codeValue == "0") {
            //得到业务类别为常规业务下的租赁期限list
            for (var i = 0; i < $scope.leasePeriodList.length; i++) {

                if ($scope.leasePeriodList[i].codeValue == "1" || $scope.leasePeriodList[i].codeValue == "2" || $scope.leasePeriodList[i].codeValue == "3") {
                    $scope.leasePeriodCgList.push($scope.leasePeriodList[i])
                }
            }
        }

        //业务类别为尾款业务
        if ($scope.serviceCategoryList[j].codeValue == "1") {
            //得到业务类别为尾款业务下的租赁期限list
            for (var i = 0; i < $scope.leasePeriodList.length; i++) {
                if ($scope.leasePeriodList[i].codeValue == "4" || $scope.leasePeriodList[i].codeValue == "5") {
                    $scope.leasePeriodWkList.push($scope.leasePeriodList[i])
                }
            }
        }
    }

    $scope.goBack = function () {
        $location.path('app/asset_equ_mor_sea_wing_apply_list');

    }

    $scope.print = function () {
        if (CommonObjectUtils.isExist($scope.equMorTask.equMorTaskNo)) {
            CommonFileUtils.downloadFileGet('equ_mor_apply/printEquMorChargeSeaWingApply', {equMorTaskNo: $scope.equMorTask.equMorTaskNo}
                , $http, $modal, $scope);
        }else{
            modalAlert($modal, '无法获取任务号!');
        }
    }

}])

;
