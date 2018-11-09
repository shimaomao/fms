

app.controller('cont_inspect_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {
    //合同文件核查审批意见
    $scope.contInspectActTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contInspectActType);

    //财务付款退回原因
    $scope.contInspectReasonList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contInspectReason);



    $scope.contInspect={};
    $scope.contNo = $location.search()['contNo'];
    $scope.applyNo = $location.search()['applyNo'];
    $scope.applyType = $location.search()['applyType'];
    $scope.taskId = $location.search()['taskId'];

    $scope.contInspect = {applyNo: $location.search()['applyNo'],contNo:$location.search()['contNo'],
        applyType:$location.search()['applyType'],taskId:$location.search()['taskId']};

    $scope.contInspect.contInspectActType = '1';

    $scope.formValidate = false;

    //提交
    $scope.url="";
    //$scope.contInspectActType={};


    $scope.$watch('contInspect.contInspectActType', function(){
        if($scope.contInspect.contInspectActType == '0'){
            $scope.contInspect.contInspectReason = '';
        }
    })

    $scope.save = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            if($scope.contInspect.contInspectActType=="1"){
                $scope.url=" cont_inspect/approval";//同意
            }else{
                $scope.url="cont_inspect/sendBack";//退回
                $scope.contInspect.contInspectReasonKey = 'contInspectReasonKey';//合同文件核查取消原因Key
            }

            $http.post($scope.url, $scope.contInspect).success(function (data) {
                if (data.code == Response.successCode){

                    if($scope.contInspect.contInspectActType=="1"){
                        //modalAlert($modal,"提交成功")
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                    }else{
                        //modalAlert($modal,"退回成功")
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'退回成功'});
                    }
                }else{
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

    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("/app/home");
    };
    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.apply;
    $scope.wfLogNo = $scope.applyNo;
    $scope.wfLogSubNo = $scope.contNo;
}]);

