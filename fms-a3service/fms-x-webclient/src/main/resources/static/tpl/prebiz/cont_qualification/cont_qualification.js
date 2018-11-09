/**
 * Created by lijunjun on 2018-04-14.
 */
app.controller('cont_qualification_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster, $compile, $location) {

    $scope.submit = false;
    $scope.formValidate = false;
    $scope.contQualificationVo = {applyNo: $location.search()['applyNo'], taskId: $location.search()['taskId'],
        contNo: $location.search()['contNo'], applyType: $location.search()['applyType'],backReasonKey:'qualificationSendBackReason'};

    $scope.applyNo = $location.search()['applyNo'];
    $scope.taskId = $location.search()['taskId'];
    $scope.applyType = $location.search()['applyType'];
    $scope.contNo = $location.search()['contNo'];

    // 初始化赋值合同资管类型
    $scope.contQualificationVo.contQualificationMode = "1";
    //附件对象
    $scope.bizFilesList = {bizFilesInfo:{}};
    // 获取合同资管操作类型Mode赋值
    $scope.contQualificationModeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contQualificationActType);
    // 获取资管退回原因List
    $scope.backReasonList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.qualificationSendBackReason);


    /**
     * 合同资管
     */
    $scope.contQualification = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            if($scope.contQualificationVo.contQualificationMode == 1){
                $http.post('cont_qualification/approve', $scope.contQualificationVo).success(function (result) {
                    if (result.code == Response.successCode) {
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                    } else {
                        modalAlert($modal,result.message);
                    }
                    $scope.submit = false;
                });
            }else{
                $http.post('cont_qualification/sendBack', $scope.contQualificationVo).success(function (result) {
                    if (result.code == Response.successCode) {
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'退回成功'});
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