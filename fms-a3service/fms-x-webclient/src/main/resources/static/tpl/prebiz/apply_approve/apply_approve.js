app.controller('apply_approve_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {
    //操作分类列表
    $scope.contRequestPayActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contRequestPayActType);
    //附件对象
    $scope.formValidate = false;

    $scope.submit = false;

    $scope.submitUrl = null;

    $scope.applyNo = $location.search()['applyNo'];
    $scope.contNo = $location.search()['contNo'];
    $scope.applyType = $location.search()['applyType'];
    $scope.taskId = $location.search()['taskId'];
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];

    $scope.applyApproveVo = {applyNo: $location.search()['applyNo'],contNo:$location.search()['contNo'],actType:'1',
        applyType:$location.search()['applyType'],taskId:$location.search()['taskId'],taskDefinitionKey:$location.search()['taskDefinitionKey']};

    $scope.submitInfo = function(){

        if(!$scope.form.$invalid) {
            //获得提交的url
            if($scope.applyApproveVo.actType == "1"){
                $scope.submitUrl = "apply_approve/approval";
            }else{
                $scope.submitUrl = "apply_approve/sendBack";
            }
            if(CommonObjectUtils.isNotExist($scope.submitUrl)){
                modalAlert($modal,"请选择操作分类");
            }else{
                $scope.submit = true;
                $http.post($scope.submitUrl,$scope.applyApproveVo).success(function(data){
                    if (data.code == Response.successCode){
                        $location.path("/app/home").search({type:'homeToastInfo', msg:'审批成功'});
                    } else {
                        modalAlert($modal,data.message);
                    }
                    $scope.submit = false;
                }).error(function(data){
                    modalAlert($modal,data);
                    $scope.submit = false;
                })
            }
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }

    }


    // 返回
    $scope.goBack = function () {
        $location.path('/app/home');
    };

    $scope.zxtb = function () {
        window.parent.open('/#/app/credit_model?applyNo='+$scope.applyNo);
    }

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.apply;
    $scope.wfLogNo = $scope.applyNo;
}]);