/**
 * 提前还款出库处理
 * Created by wangxue on 2018/9/15.
 */
app.controller('deposit_change_export_controller',['$scope', '$http','$modal','toaster','$location',function ($scope, $http, $modal, toaster, $location) {

    $scope.formValidate = false;

    // 提前还款任务信息
    $scope.depositTaskNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];


    // 车辆出库信息
    $scope.$on('vehicleExportToFather', function (e, data) {
       $scope.vehicleDisposalVo =  data;
    });

    $scope.submit = false;

    // 提交提前还款出库此信息
    $scope.submitInfo = function () {
        if(!$scope.form.$invalid) {
            if(CommonObjectUtils.isNotExist($scope.vehicleDisposalVo.bizFilesList) || $scope.vehicleDisposalVo.bizFilesList.length < 1){
                modalAlert($modal,"请上传车辆出库附件");
            }else {
                $scope.submit = true;
                // 提交处理
                $scope.depositApproveVo = {depositTaskNo: $scope.depositTaskNo,taskId:$location.search()['taskId'],
                    remark:$scope.vehicleDisposalVo.remark,shipmentDate:$scope.vehicleDisposalVo.shipmentDate,
                    agent:$scope.vehicleDisposalVo.agent,agentMobileNo:$scope.vehicleDisposalVo.agentMobileNo,
                    bizFilesList:$scope.vehicleDisposalVo.bizFilesList};
                $http.post('deposit_change_task/export', $scope.depositApproveVo).success(function (result) {
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
            }
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