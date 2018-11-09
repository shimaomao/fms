/**
 * Created by wangxue on 2018/9/6.
 */

app.controller('transfer_settlement_controller', ['$scope', '$http','$modal', 'toaster','$location', function ($scope, $http, $modal, toaster, $location) {

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.transferInfoVo = {transferNo:$location.search()['serviceId'], taskId:$location.search()['taskId']};

   // 引用过户详情
    $scope.transferNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];

    // 引用流程日志共通
    $scope.wfLogSubNo = '';

    // 获取子页面的数据
    $scope.$on('transferInfoVoToFather',function (e,data) {
        $scope.transferInfoVo.transferCost = data.transferCost;
        $scope.transferInfoVo.transferDeposit = data.transferDeposit;
        $scope.transferInfoVo.deposit = data.deposit;
        $scope.transferInfoVo.retreatsAmount = data.retreatsAmount;
        $scope.transferInfoVo.totalCost = data.totalCost;
        $scope.transferInfoVo.insurancDealType = data.insurancDealType;// 保险处置方式
        if ($scope.transferInfoVo.insurancDealType == '2') {
            // 退保的场合
            $scope.retreatsAmountShow = true;
        } else {
            $scope.retreatsAmountShow = false;
        }
        // 收款银行信息
        $scope.transferInfoVo.recAccBank = data.recAccBank;
        $scope.transferInfoVo.recAccountName = data.recAccountName;
        $scope.transferInfoVo.recAccountNo = data.recAccountNo;
        $scope.transferInfoVo.recEleBankNo = data.recEleBankNo;
        $scope.transferInfoVo.recAccBranch = data.recAccBranch;
        $scope.transferInfoVo.bizFilesList = data.bizFilesList;
        $scope.transferInfoVo.applyBizFilesList = data.applyBizFilesList;// 申请附件信息
    });

    // 提交
    $scope.submitInfo = function () {
        if (!$scope.form.$invalid) {
            // 判断附件是否上传
            if ($scope.transferInfoVo.notUpload) {
                modalAlert($modal, "请上传" + $scope.transferInfoVo.notFileTypeName + "类型文件");
                return;
            }
            $scope.submit = true;
            // 费用结算提交处理
            $scope.transferInfoVo.taskId = $scope.taskId; // 任务ID
            $http.post('transfer_info/submitTransferSettlement', $scope.transferInfoVo).success(function (result) {
                if (result.code == Response.successCode){
                    $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                } else {
                    modalAlert($modal, result.message);
                }
                $scope.submit = false;
            }).error(function (result) {
                modalAlert($modal, result);
                $scope.submit = false;
            });
        } else {
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    // 暂存
    $scope.saveInfo = function () {
        $scope.submit = true;
        // 费用结算暂存处理
        $http.post('transfer_info/saveTransferSettlement', $scope.transferInfoVo).success(function (result) {
            if (result.code == Response.successCode){
                toaster_info("暂存成功", toaster);
            } else {
                modalAlert($modal, result.message);
            }
            $scope.submit = false;
        }).error(function (result) {
            modalAlert($modal, result);
            $scope.submit = false;
        });
    };

    // 返回
    $scope.goback = function () {
        $location.path("/app/home");
    };

    // 监听退保金额
    $scope.$watch('transferInfoVo.retreatsAmount', function (newVal, oldVal) {
        sumTransferAllAmount();
    });

    // 监听过户手续费
    $scope.$watch('transferInfoVo.transferCost', function (newVal, oldVal) {
       sumTransferAllAmount();
    });

    // 计算费用总额
   function sumTransferAllAmount() {
        console.log('费用总额（计算前）：' + $scope.transferInfoVo.totalCost);
        if (isNotUndefinedNull($scope.transferInfoVo.retreatsAmount) && isNotUndefinedNull($scope.transferInfoVo.transferCost)) {
            var totalCost = Number($scope.transferInfoVo.retreatsAmount) + Number($scope.transferInfoVo.deposit)
                + Number($scope.transferInfoVo.transferDeposit) - Number($scope.transferInfoVo.transferCost);
            console.log(totalCost);
            $scope.transferInfoVo.totalCost = CommonDecimalUtils.formatDecimal(totalCost, 2);
        }
        console.log('费用总额（计算后）：' + $scope.transferInfoVo.totalCost);
    };

}]);
