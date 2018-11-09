/**
 * Created by liujinge on 2018-03-23.
 */
app.controller('cont_confirm_bef_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster, $compile, $location) {

    $scope.submit = false;
    $scope.formValidate = false;

    $scope.contConfirmBefInfo = {applyNo:$location.search()['applyNo'], taskId: $location.search()['taskId'],
        applyType: $location.search()['applyType'], contNo:$location.search()['contNo']};
    $scope.applyNo = $location.search()['applyNo'];
    $scope.taskId = $location.search()['taskId'];
    $scope.applyType = $location.search()['applyType'];
    $scope.contNo = $location.search()['contNo'];
    $scope.contConfirmBefInfo.confirmBefContMode = '1';
    // 获取合同前确认Mode赋值
    $scope.confirmBefContModeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.confirmBefCont);
    $scope.pulldownList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.cancelReason);

    $scope.$watch('contConfirmBefInfo.confirmBefContMode', function(){
        if($scope.contConfirmBefInfo.confirmBefContMode != '2'){
            $scope.contConfirmBefInfo.cancelReason = '';
        }
    })

    /**
     * 合同生成确认
     */
    $scope.contConfirmBef = function () {
            if(!$scope.form.$invalid) {
                $scope.submit = true;
                if($scope.contConfirmBefInfo.confirmBefContMode == 1){
                    $http.post('cont_confirm_bef/confirm', $scope.contConfirmBefInfo).success(function (result) {
                        if (result.code == Response.successCode) {
                            $location.path('/app/home').search({type:'homeToastInfo', msg:'合同生成前确认成功'});
                        } else {
                            modalAlert($modal,result.message);
                        }
                        $scope.submit = false;
                    });
                }else if($scope.contConfirmBefInfo.confirmBefContMode == 2){
                    $scope.contConfirmBefInfo.cancelRemark = $scope.contConfirmBefInfo.remark1;
                    $scope.contConfirmBefInfo.cancelReasonKey = "cancelReasonKey";
                    $http.put('apply_cancel/modifyApplyCancel', $scope.contConfirmBefInfo).success(function (result) {
                        if (result.code == Response.successCode) {
                            $location.path('/app/home').search({type:'homeToastInfo', msg:'合同生成前确认取消成功'});
                        } else {
                            modalAlert($modal,result.message);
                        }
                        $scope.submit = false;
                    });
                }else if($scope.contConfirmBefInfo.confirmBefContMode == 3){
                    $http.post('cont_confirm_bef/returnDealer', $scope.contConfirmBefInfo).success(function (result) {
                        if (result.code == Response.successCode) {
                            $location.path('/app/home').search({type:'homeToastInfo', msg:'退回到申请成功'});
                        } else {
                            modalAlert($modal,result.message);
                        }
                        $scope.submit = false;
                    });
                }
            } else{
                $scope.formValidate = true;
                toaster_info(promptInfo.submitWarn,toaster);
            }
    };


    // 返回
    $scope.goBack = function () {
        $location.path('/app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.apply;
    $scope.wfLogNo = $scope.applyNo;

}]);