/**
 * 车辆出库处理
 * Created by wangxue on 2018/9/15.
 */
app.controller('vehicle_export_controller', ['$scope', '$http','$modal', '$location', function ($scope, $http, $modal, $location) {

    $scope.formValidate = false;

    $scope.submit = false;

    // 处置任务号
    $scope.disposalTaskNo = $location.search()['serviceId'];

    // 任务信息
    $scope.vehicleDisposalVo = {};
    $scope.vehicleDisposalVo.disposalTaskNo = $scope.disposalTaskNo;// 处置任务号
    // $scope.vehicleDisposalVo.notUpload = true;


    // 监控页面显示信息变化
    $scope.$watch("vehicleDisposalVo",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal){
            $scope.$emit("vehicleExportToFather",$scope.vehicleDisposalVo);
        }
    },true);

}]);
