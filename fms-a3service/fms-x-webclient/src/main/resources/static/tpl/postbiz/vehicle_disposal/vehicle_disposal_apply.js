/**
 * 车辆处置申请
 * Created by wangxue on 2018/9/13.
 */

app.controller('vehicle_disposal_apply_controller', ['$scope', '$http','$modal', 'toaster','$location', '$filter', function ($scope, $http, $modal, toaster, $location, $filter) {

    $scope.formValidate = false;

    $scope.submit = false;

    // 获取车辆处置方式
    $scope.disposalStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.disposalStatus);

    $scope.vehicleDisposalVo = {};
    $scope.httpData = false; // 附件显示

    // 页面初始化
    function init() {
        var url = 'vehicle_disposal/findVehicleDisposalVoByVehicleDisposalId?vehicleDisposalId=';
        $http.get(url + $location.search()['vehicleDisposalId']).success(function (result) {
            if (result.code == Response.successCode) {
                $scope.vehicleDisposalVo = result.data;
                if (isUndefinedNull($scope.vehicleDisposalVo.disposalStatus)) {
                    $scope.vehicleDisposalVo.disposalStatus = "";
                    $scope.vehicleDisposalVo.residualValue = 0;
                }
                console.log("vehicleDisposalVo:" + $scope.vehicleDisposalVo);
            } else {
                modalAlert($modal,result.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    }
    init();

    // 提交
    $scope.submitInfo = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.post('vehicle_disposal/submitVehicleDisposalApply', $scope.vehicleDisposalVo).success(function (result) {
                if (result.code == Response.successCode){
                    $location.path("app/postbiz_vehicle_disposal_list").search({msg:"车辆处置申请提交成功"});
                } else {
                    modalAlert($modal,result.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            });
        } else{
            toaster_info(promptInfo.submitWarn,toaster);
            $scope.formValidate = true;
        }
    };

    // 返回
    $scope.backUp = function () {
        $location.path("app/postbiz_vehicle_disposal_list");
    };

    //查看逾期详情
    $scope.overdueDetail = function () {
        //取得逾期客户id
        $http.get('deposit_change_task/findOverdueCstmId?certifNo='+$scope.vehicleDisposalVo.certifNo).success(function (data) {
            if(data.code == Response.successCode){
                var overdueCstmId = data.data;
                if(CommonStringUtils.isTrimBlank(overdueCstmId)){
                    modalAlert($modal,'该客户未发生过逾期');
                } else {
                    var id = overdueCstmId;
                    var url = 'app.postbiz_overdue_cstm_modify?overdueCstmId=' + overdueCstmId
                        + '&detail=true&isTab=true';
                    var title = '逾期详情';
                    var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
                    if(window.parent.addTab){
                        window.parent.addTab(html);
                    }
                }
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };

    // 强制结清
    $scope.contPrepayment = function () {
        var url = 'vehicle_disposal/findDisposalTaskNoByContNo?disposalStatus=1&contNo=';
        $http.get(url + $scope.vehicleDisposalVo.contNo).success(function (result) {
            if(result.code == Response.successCode){
                var disposalTaskNo = result.data;
                if(CommonStringUtils.isNotTrimBlank(disposalTaskNo)){
                    modalAlert($modal,'该合同已经发起提前结清');
                } else {
                    var contNo = $scope.vehicleDisposalVo.contNo;
                    var url = 'app.cost_cont_prepayment_modify?operate=save&contNo=' + contNo + '&detail=true';
                    var title = '提前还款申请';
                    var html = "<a data-id=\""+contNo+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
                    if(window.parent.addTab){
                        window.parent.addTab(html);
                    }
                }
            }else{
                modalAlert($modal,result.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };

    // 增加保证金
    $scope.depositChang = function () {
        var url = 'vehicle_disposal/findDisposalTaskNoByContNo?disposalStatus=3&contNo=';
        $http.get(url + $scope.vehicleDisposalVo.contNo).success(function (result) {
            if(result.code == Response.successCode){
                var disposalTaskNo = result.data;
                if(CommonStringUtils.isNotTrimBlank(disposalTaskNo)){
                    modalAlert($modal,'该合同已经发起增加保证金任务');
                } else {
                    // 打开增加保证金申请页签
                    var contNo = $scope.vehicleDisposalVo.contNo;
                    var url = 'app.postbiz_deposit_change_apply?type=vehicle_disposal&cont_no=' + contNo;
                    var title = '增加保证金申请';
                    var html = "<a data-id=\""+contNo+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
                    if(window.parent.addTab){
                        window.parent.addTab(html);
                    }
                }
            }else{
                modalAlert($modal,result.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };

    // 车辆处置方式改变的场合
    $scope.changeDisposalStatus = function () {
        // 附件显示
        if ($scope.vehicleDisposalVo.disposalStatus == '2') {
            // 转固定资产的场合，显示附件
            $scope.httpData = true;
        } else {
            $scope.httpData = false;
            $scope.vehicleDisposalVo.residualValue = 0;
        }
    }

}]);