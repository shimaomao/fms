app.controller('apply_manage_approve_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    $scope.formValidate = false;
    //操作分类列表
    $scope.contRequestPayActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.manageApprovalActType);

    $scope.submit = false;

    $scope.submitUrl = null;

    $scope.applyNo = $location.search()['applyNo'];
    $scope.contNo = $location.search()['contNo'];
    $scope.applyType = $location.search()['applyType'];
    $scope.taskId = $location.search()['taskId'];
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];
    console.log($scope.applyNo)

    $scope.applyManageApproveVo = {applyNo: $location.search()['applyNo'],contNo:$location.search()['contNo'],
        applyType:$location.search()['applyType'],taskId:$location.search()['taskId'],taskDefinitionKey:$location.search()['taskDefinitionKey']};

    $scope.submitInfo = function(){

        if(!$scope.form.$invalid) {

            if(CommonObjectUtils.isNotExist($scope.applyManageApproveVo.actType)){
                modalAlert($modal,"请选择操作分类");
            }else{
                //获得提交的url
                if($scope.applyManageApproveVo.actType == "1"){//同意
                    $scope.submitUrl = "apply_manage_approve/approval";
                }else if($scope.applyManageApproveVo.actType == "2"){//退回
                    $scope.submitUrl = "apply_manage_approve/sendBack";
                }else{//退回风控经理
                    $scope.submitUrl = "apply_manage_approve/backToDiragree";
                }
                $scope.submit = true;
                $http.post($scope.submitUrl,$scope.applyManageApproveVo).success(function(data){
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

    //获取数据
    $http.get('apply_risk/findApplyRiskInit?applyNo='+$scope.applyNo).success(function (data) {
        if(data.code == Response.successCode){
            $scope.riskData = data.data;
            $scope.riskData.taskId = $location.search()['taskId'];
            //向子控制器广播数据
            $scope.$broadcast('riskDataToSon', $scope.riskData );
            console.log($scope.riskData);

        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.apply;
    $scope.wfLogNo = $scope.applyNo;
    //控制风控页面
    $scope.disabled = true;
    $scope.detailFlag = 0;

}]);