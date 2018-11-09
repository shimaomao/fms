/**
 * 提前还款出库处理
 * Created by wangxue on 2018/9/15.
 */
app.controller('cont_prepayment_vehicle_export_controller',['$scope', '$http','$modal','toaster','$location',function ($scope, $http, $modal, toaster, $location) {

    $scope.formValidate = false;

    // 提前还款任务信息
    $scope.contPrepaymentNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];


    // 车辆出库信息
    $scope.$on('vehicleExportToFather', function (e, data) {
       $scope.vehicleDisposalVo =  data;
    });

    $scope.submit = false;

    // 提交提前还款出库此信息
    $scope.submitInfo = function () {
        // 判断附件是否上传
        if($scope.vehicleDisposalVo.notUpload){
            modalAlert($modal, "请上传" + $scope.vehicleDisposalVo.notFileTypeName + "类型文件");
            return false;
        }
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            // 提交处理
            $scope.vehicleDisposalVo.taskId = $scope.taskId;// 流程任务ID
            $http.post('cont_prepayment/prePayVehicleShipment', $scope.vehicleDisposalVo).success(function (result) {
                if (result.code == Response.successCode) {
                    $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                } else {
                    modalAlert($modal, result.message);
                }
                $scope.submit = false;
            }).error(function (data) {
                modalAlert($modal, data);
                $scope.submit = false;
            })
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    /**
     * 返回
     */
    $scope.goBack = function(){
        $location.path("/app/home");
    };

}]);