/**
 * Created by fangshaofeng on 2018/10/29.
 */

app.controller('surrender_charge_approve_controller', ['$scope', '$http', '$modal', 'toaster', '$location', '$filter', function ($scope, $http, $modal, toaster, $location, $filter) {
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.surrenderChargeActTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.surrenderChargeActType)

    /*$scope.contNo = $location.search()['contNo'];
     $scope.findNo = $scope.contNo;
     $scope.findUrl = 'transfer_info/findTransferInfoRetreatsByVo?contNo=';
     $scope.transferNo = $location.search()['transferNo'];*/
    $scope.taskId = $location.search()['taskId'];
    $scope.processLogShow = false;
    $scope.fromHome = false;
    $scope.transferInfoRetreatsVo = {};
    //从我的任务中进来
    if (isNotUndefinedNull($location.search()['serviceId']) && isNotEmpty($location.search()['serviceId'])) {
        $scope.fromHome = $scope.processLogShow = true;
        $scope.retreatsNo = $location.search()['serviceId'];
        /*$scope.findNo = $scope.transferNo;*/
        $scope.findUrl = 'transfer_info/findTransferInfoRetreatVoByRetreatsNo?retreatsNo=' + $scope.retreatsNo;
    }

    // 获取页面显示信息
    $http.get($scope.findUrl).success(function (result) {
        if (result.code == Response.successCode) {
            console.log(result);
            $scope.transferInfoRetreatsVo = result.data;
            setCodeValue();
        } else {
            modalAlert($modal, result.message);
        }
    }).error(function (err) {
        modalAlert($modal, err);
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
        if ($scope.transferInfoRetreatsVo.insuranceType) {
            $scope.insuranceSelectInfoList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes[$scope.transferInfoRetreatsVo.insuranceType]);
        }
        // 过户流程处理任务ID
        $scope.transferInfoRetreatsVo.taskId = $scope.taskId;
        $scope.transferInfoRetreatsVo.actType = $scope.surrenderChargeActTypeList[0].codeValue;
    }

    // 返回
    $scope.backUp = function () {
        $location.path('/app/home');
    };

    // 提交
    $scope.submitInfo = function () {
        if ($scope.transferInfoRetreatsVo.actType == '0') {
            $scope.url = 'transfer_info/approval';
        } else if ($scope.transferInfoRetreatsVo.actType == '1') {
            $scope.url = 'transfer_info/sendBack';
        }
        if (!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.transferInfoRetreatsVo.taskId = $scope.taskId = $location.search()['taskId'];
            $http.put($scope.url, $scope.transferInfoRetreatsVo).success(function (data) {
                if (data.code == Response.successCode) {
                    if ($scope.transferInfoRetreatsVo.actType == "0") {
                        $location.path('/app/home').search({type: 'homeToastInfo', msg: '提交成功'});
                    } else {
                        $location.path('/app/home').search({type: 'homeToastInfo', msg: '退回成功'});
                    }
                }
                else
                    modalAlert($modal, data.message);
                $scope.submit = false;
            }).error(function (data) {
                modalAlert($modal, data);
                $scope.submit = false;
            })
        } else {
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn, toaster);
        }
    };

}]);