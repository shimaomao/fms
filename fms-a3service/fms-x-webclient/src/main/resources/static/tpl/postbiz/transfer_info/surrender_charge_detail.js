/**
 * Created by fangshaofeng on 2018-10-30.
 */
app.controller('surrender_charge_detail_controller', ['$scope', '$http','$modal', '$filter', '$location', function ($scope, $http, $modal, $filter, $location) {

    $scope.transferInfoRetreatsVo = {};

    // 流程日志
    $scope.wfLogSubNo = '';

    $scope.retreatsNo = $location.search()['retreatsNo'];

    $scope.contNo = $location.search()['contNo'];
    // 初始化查询页面详情
    $scope.findUrl = 'transfer_info/findTransferInfoRetreatVoByRetreatsNo?retreatsNo=' + $scope.retreatsNo;
    $http.get($scope.findUrl).success(function (result) {
        if(result.code == Response.successCode){
            $scope.transferInfoRetreatsVo = result.data;
            setCodeValue();
        }else{
            modalAlert($modal, result.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    function setCodeValue() {
        // 保险生效日
        $scope.transferInfoRetreatsVo.validStartDay = $filter('date')($scope.transferInfoRetreatsVo.validStartDay, 'yyyy-MM-dd');
        // 保险失效日
        $scope.transferInfoRetreatsVo.validEndDay = $filter('date')($scope.transferInfoRetreatsVo.validEndDay, 'yyyy-MM-dd');
        // 合同生效日期
        $scope.transferInfoRetreatsVo.contractValidDate = $filter('date')($scope.transferInfoRetreatsVo.contractValidDate, 'yyyy-MM-dd');
        // 结清状态
        $scope.transferInfoRetreatsVo.paymentStsVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.paymentSts, $scope.transferInfoRetreatsVo.paymentSts);
        //保险类型
        if ($scope.transferInfoRetreatsVo.insuranceType){
            $scope.insuranceSelectInfoList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes[$scope.transferInfoRetreatsVo.insuranceType]);
        }
    }

    // 返回
    $scope.backUp = function () {
        $location.path("app/postbiz_transfer_info_retreats_list");
    };

}]);


