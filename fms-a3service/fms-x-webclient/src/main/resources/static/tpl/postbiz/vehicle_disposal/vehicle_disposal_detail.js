/**
 * Created by wangxue on 2018-09-12.
 */
app.controller('vehicle_disposal_detail_controller', ['$scope', '$http','$modal', '$location', function ($scope, $http,$modal, $location) {

    $scope.vehicleDisposalVo = {};
    $scope.detailShow = false;


    // 查看详情页面
    $scope.taskNo = $location.search()['disposalTaskNo'];
    $scope.vehicleDisposalId = $location.search()['vehicleDisposalId'];

    // 处置任务号
    $scope.disposalTaskNo = $scope.$parent.disposalTaskNo;
    // $scope.httpData = false; // 附件不显示

    // 页面初始化
    function init() {
        console.log($scope.disposalTaskNo);
        if (isUndefinedNull($scope.disposalTaskNo) || isEmpty($scope.disposalTaskNo)) {
            console.log('TaskNo;' + $scope.taskNo);
            $scope.detailShow = true;
            $scope.disposalTaskNo = $scope.taskNo;
        }
        var findUrl = 'vehicle_disposal/findVehicleDisposalVoByVehicleDisposalId?vehicleDisposalId=' + $scope.vehicleDisposalId;
        if ($scope.disposalTaskNo) {
            findUrl = 'vehicle_disposal/findVehicleDisposalVoByDisposalTaskNo?disposalTaskNo=' + $scope.disposalTaskNo;
        }
        $http.get(findUrl).success(function (result) {
            if (result.code == Response.successCode) {
                $scope.vehicleDisposalVo = result.data;
                // 车辆处置方式
                $scope.vehicleDisposalVo.disposalStatusName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.disposalStatus,$scope.vehicleDisposalVo.disposalStatus);
                // 附件显示
                if ($scope.vehicleDisposalVo.disposalStatus == CommonCodeUtils.disposalType.capitalAssets) {
                    // 转固定资产的场合，显示附件
                    $scope.httpData = true;
                }
            } else {
                modalAlert($modal, result.message);
            }
        }).error(function (err) {
            modalAlert($modal, err);
        });
    }
    init();

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

    // 监控页面显示信息变化
    $scope.$watch("vehicleDisposalVo",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal){
            $scope.$emit("vehicleDisposalDetailToFather",$scope.vehicleDisposalVo);
        }
    },true);

    // 返回
    $scope.backUp = function () {
        $location.path("app/postbiz_vehicle_disposal_list");
    };
}]);


