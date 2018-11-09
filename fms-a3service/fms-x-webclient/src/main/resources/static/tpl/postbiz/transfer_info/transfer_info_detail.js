/**
 * Created by wangxue on 2018-08-30.
 */
app.controller('transfer_info_detail_controller', ['$scope', '$http','$modal', '$filter', '$location', function ($scope, $http, $modal, $filter, $location) {

    // 保险处置
    $scope.insurancDealTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.insurancDealType);
    // $scope.transferNo = $scope.$parent.transferNo;
    // $scope.traskId = $scope.$parent.traskId;
    $scope.transCostShow = $scope.payInfoShow = $scope.transFileShow = false;
    $scope.transApplyShow = true; // 过户申请信息是否显示
    $scope.processLogShow = true; // 流程日志信息是否显示
    $scope.transApplyFileShow = false; // 过户申请附件不显示
    $scope.isDetail = true;
    if ($location.search()['serviceId']) {
        $scope.isDetail = false;
        $scope.transferNo = $location.search()['serviceId'];
        $scope.taskId = $location.search()['taskId'];
        $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];
    } else {
        $scope.transferNo = $location.search()['transferNo'];
        $scope.contNo = $location.search()['contNo'];
    }
    // 流程日志
    $scope.wfLogSubNo = '';

    $scope.transferInfoVo = {};

    // 初始化信息显示
    function initDisable() {
        if ($scope.isDetail) {
            // 单独的详情页面的场合
            if (isUndefinedNull($scope.transferNo)) {
                $scope.transApplyShow = false; // 过户申请信息不显示
                $scope.processLogShow = false; // 流程日志不显示
            } else {
                $scope.transApplyFileShow = true; // 过户申请附件显示
            }
            $scope.transCostShow = $scope.payInfoShow = false; // 费用信息和付款银行信息不显示
            $scope.transFileShow = false; // 附件信息不显示
        } else {
            // 当前处理
            // var key = $scope.$parent.taskDefinitionKey;
            var key = $scope.taskDefinitionKey;
            if (key == CommonCodeUtils.actRuTaskApprovalUrl.transfer_task.transfer_task_review.name) {
                // 资管复核,显示附件信息
                $scope.transFileShow = true;
            }
            // 流程日志
            if (key == CommonCodeUtils.actRuTaskApprovalUrl.transfer_task.transfer_task_settlement.name) {
                // 费用结算，流程日志不显示
                $scope.processLogShow = false;
            }
            // 费用信息
            if (key == CommonCodeUtils.actRuTaskApprovalUrl.transfer_task.transfer_task_review.name
                || key == CommonCodeUtils.actRuTaskApprovalUrl.transfer_task.transfer_task_touching.name
                || key == CommonCodeUtils.actRuTaskApprovalUrl.transfer_task.transfer_task_check.name
                || key == CommonCodeUtils.actRuTaskApprovalUrl.transfer_task.transfer_task_loan.name) {
                // 资管复审、财务审核、总经理审核、财务确认付款
                $scope.transCostShow = true;
            }
            // 付款银行信息
            if (key == CommonCodeUtils.actRuTaskApprovalUrl.transfer_task.transfer_task_check.name
                || key == CommonCodeUtils.actRuTaskApprovalUrl.transfer_task.transfer_task_loan.name) {
                // 总经理审核、财务确认付款
                $scope.payInfoShow = true;
            }
            // 申请附件信息
            if (key == CommonCodeUtils.actRuTaskApprovalUrl.transfer_task.transfer_task_approval.name
                || key == CommonCodeUtils.actRuTaskApprovalUrl.transfer_task.transfer_task_review.name) {
                // 过户申请审核，资管审核
                $scope.transApplyFileShow = true; // 过户申请附件显示
            }

        }
    }
    initDisable();

    // 初始化查询页面详情
    $scope.findUrl = 'transfer_info/findTransferDetailByTransferNo?transferNo=' + $scope.transferNo;
    // 获取页面显示信息
    if (isUndefinedNull($scope.transferNo)) {
        $scope.findUrl =  'transfer_info/findTransferDetailByContNo?contNo=' + $scope.contNo;
    }
    $http.get($scope.findUrl).success(function (result) {
        if(result.code == Response.successCode){
            $scope.transferInfoVo = result.data;
            // 提前还款状态
            $scope.transferInfoVo.prepaymentStsVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus, $scope.transferInfoVo.prepaymentSts);
            setCodeValue();
            if ($scope.isDetail) {
                if ($scope.transferInfoVo.transferSts == '1') {
                    // 过户状态为已过户,过户费用显示
                    $scope.transCostShow = true;
                    $scope.transFileShow = true; // 附件信息显示
                    if ($scope.transferInfoVo.payAccBranch) {
                        // 付款银行不为空，显示付款银行信息
                        $scope.payInfoShow = true;
                    }
                }
            }
        }else{
            modalAlert($modal, result.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    function setCodeValue() {
        // 过户申请日期
        $scope.transferInfoVo.transferApplyDate = $filter('date')($scope.transferInfoVo.transferApplyDate, 'yyyy-MM-dd');
        // 行驶证登记日期
        $scope.transferInfoVo.vehicleDrivingLicenseRegisterDate = $filter('date')($scope.transferInfoVo.vehicleDrivingLicenseRegisterDate, 'yyyy-MM-dd');
        // 保险失效日
        $scope.transferInfoVo.validEndDay = $filter('date')($scope.transferInfoVo.validEndDay, 'yyyy-MM-dd');
        // 合同生效日期
        $scope.transferInfoVo.contractValidDate = $filter('date')($scope.transferInfoVo.contractValidDate, 'yyyy-MM-dd');
        // 结清状态
        $scope.transferInfoVo.paymentStsVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.paymentSts, $scope.transferInfoVo.paymentSts);
        // 抵押状态
        $scope.transferInfoVo.mortgageStatusVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.mortgageStatus, $scope.transferInfoVo.mortgageStatus);
        // 资方
        $scope.transferInfoVo.managementVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.management, $scope.transferInfoVo.management);
        // 登记证文件状态
        $scope.transferInfoVo.origFileDetailStatusVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.origFileDetailStatus,$scope.transferInfoVo.origFileDetailStatus);
        // 过户流程处理任务ID
        $scope.transferInfoVo.taskId = $scope.taskId;
        //附件赋值
        $scope.bizFilesList = $scope.transferInfoVo.bizFilesList;
        if ($scope.transferInfoVo.insurancDealType == '2') {
            // 退保的场合
            $scope.retreatsAmountShow = true;
        } else {
            $scope.retreatsAmountShow = false;
        }
    }

    //查看还款计划表
    $scope.overdueSales = function () {
        var contNo = $scope.transferInfoVo.contNo;
        if(contNo){
            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/postbiz/overdue_cstm/overdue_sales.html'+getCacheTime(),
                controller: 'overdue_sales_controller',
                resolve:{
                    paramsData: function () {
                        return {
                            "contNo": contNo
                        }
                    }
                }
            });
            rtn.result.then(function (data) {

            },function(){

            });
        } else{
            modalAlert($modal,'合同号不存在！');
        }
    };

    $scope.$watch("transferInfoVo",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal){
            $scope.$emit("transferInfoVoToFather",$scope.transferInfoVo);
        }
    },true);

    // 返回
    $scope.backUp = function () {
        $location.path("app/postbiz_transfer_info_list");
    };

}]);


