/**
 * Created by lijunjun on 2018-04-14.
 */
app.controller('cont_print_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster, $compile, $location) {

    $scope.submit = false;
    $scope.formValidate = false;
    $scope.contPrintInfo = {applyNo: $location.search()['applyNo'], taskId: $location.search()['taskId'],
        contNo: $location.search()['contNo'], applyType: $location.search()['applyType']};

    $scope.applyNo = $location.search()['applyNo'];
    $scope.taskId = $location.search()['taskId'];
    $scope.applyType = $location.search()['applyType'];
    $scope.contNo = $location.search()['contNo'];

    // 初始化赋值合同打印类型
    $scope.contPrintInfo.contPrintMode = "1";
    //附件对象
    $scope.bizFilesList = {bizFilesInfo:{}};
    // 获取合同打印操作类型Mode赋值
    $scope.contPrintModeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contPrintActType);
    // 获取打印退回原因List
    $scope.printSendBackReasonList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.printSendBackReason);


    /**
     * 合同打印
     */
    $scope.contPrint = function () {
            if(!$scope.form.$invalid) {
                $scope.submit = true;
                if($scope.contPrintInfo.contPrintMode == 1){
                    $http.post('cont_print/print', $scope.contPrintInfo).success(function (result) {
                        if (result.code == Response.successCode) {
                            $location.path("/app/home").search({type:'homeToastInfo', msg:'打印成功'});
                        } else {
                            modalAlert($modal,result.message);
                        }
                        $scope.submit = false;
                    });
                }else{
                    $http.post('cont_print/sendBack', $scope.contPrintInfo).success(function (result) {
                        if (result.code == Response.successCode) {
                            $location.path("/app/home").search({type:'homeToastInfo', msg:'退回成功'});
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
    $scope.wfLogSubNo = $scope.contNo;

}]);