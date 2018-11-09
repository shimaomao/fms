app.controller('apply_agree_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {
    $scope.formValidate = false;

    $scope.submit = false;

    $scope.submitUrl = null;

    $scope.applyNo = $location.search()['applyNo'];
    $scope.contNo = $location.search()['contNo'];
    $scope.applyType = $location.search()['applyType'];
    $scope.taskId = $location.search()['taskId'];
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];
    $scope.approveFlag = 1;

    $scope.applyConditionalAgreeVo = {applyNo: $location.search()['applyNo'],contNo:$location.search()['contNo'],
        applyType:$location.search()['applyType'],taskId:$location.search()['taskId'],taskDefinitionKey:$location.search()['taskDefinitionKey']};

    $http.get('apply_conditional_agree/findApplyConditionalAgreeVoByApplyNo?applyNo='+$scope.applyNo).success(function (data) {
        if(data.code == Response.successCode){
            $scope.applyConditionalAgreeVo.applyFinance = data.data.applyFinance;
            $scope.applyConditionalAgreeVo.riskAmount = data.data.riskAmount;
        }
    });

    //同意
    $scope.submitInfo = function(){
        if(!$scope.form.$invalid) {
            $scope.submitUrl = 'apply_conditional_agree/agreeOrNot';
            if(CommonObjectUtils.isNotExist($scope.applyConditionalAgreeVo.actType)){
                modalAlert($modal,"请选择操作分类");
            }else{
                $scope.submit = true;
                $http.post($scope.submitUrl,$scope.applyConditionalAgreeVo).success(function(data){
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

    //同意
    $scope.agreeInfo = function () {
        $scope.applyConditionalAgreeVo.actType = 0;
        $scope.submitInfo();
    }
    //不同意
    $scope.notAgreeInfo = function () {
        $scope.applyConditionalAgreeVo.actType = 1;
        $scope.submitInfo();
    }


    // 返回
    $scope.goBack = function () {
        $location.path('/app/home');
    };

    $scope.changePerc = function(name,value){
        $scope.applyConditionalAgreeVo.applyFinance[name] = $scope.applyConditionalAgreeVo.applyFinance.investTotal*value;
    }

    $scope.changeAmount = function(name,value){
        $scope.applyConditionalAgreeVo.applyFinance[name] = value/$scope.applyConditionalAgreeVo.applyFinance.investTotal;
    }

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.apply;
    $scope.wfLogNo = $scope.applyNo;

}]);