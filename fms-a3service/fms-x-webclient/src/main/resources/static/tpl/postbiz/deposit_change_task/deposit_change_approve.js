app.controller('deposit_change_approve_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {
    //操作分类列表
    $scope.contRequestPayActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contRequestPayActType);
    //附件对象
    $scope.formValidate = false;

    $scope.submit = false;

    $scope.submitUrl = null;

    $scope.depositTaskNo = $location.search()['serviceId'];
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];

    $scope.depositApproveVo = {depositTaskNo: $scope.depositTaskNo,actType:'1',
        taskId:$location.search()['taskId'],taskDefinitionKey:$location.search()['taskDefinitionKey']};

    $scope.submitInfo = function(){

        if(!$scope.form.$invalid) {
            //获得提交的url
            if($scope.depositApproveVo.actType == "1"){
                $scope.submitUrl = "deposit_change_task/approval";
            }else{
                $scope.submitUrl = "deposit_change_task/sendBack";
            }
            if(CommonObjectUtils.isNotExist($scope.submitUrl)){
                modalAlert($modal,"请选择操作分类");
            }else{
                $scope.submit = true;
                $http.post($scope.submitUrl,$scope.depositApproveVo).success(function(data){
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

    //拒绝
    $scope.refuse = function(){

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.post('deposit_change_task/refuse',$scope.depositApproveVo).success(function(data){
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
    $scope.wfLogType = CommonCodeUtils.bizTypes.depositChange;
    $scope.wfLogNo = $scope.depositTaskNo;
}]);