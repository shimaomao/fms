app.controller('deposit_contract_sign_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {
    //操作分类列表
    $scope.contRequestPayActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contRequestPayActType);
    //附件对象
    $scope.formValidate = false;

    $scope.submit = false;

    $scope.submitUrl = null;

    //合同附件区分
    $scope.fileFlag = true;

    $scope.$on('suppleUploadToFather',function (e,data) {
        $scope.suppleUploadVo = data;
    });

    $scope.depositTaskNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];

    $scope.basFileTypes = CommonCodeUtils.basFileTypes.depositChangeContractFile;

    $scope.suppleUploadVo = {depositTaskNo: $scope.depositTaskNo,actType:'1',notUpload:false,notUploadInfo:'请上传附件',
        taskId:$location.search()['taskId'],taskDefinitionKey:$location.search()['taskDefinitionKey']};

    $scope.submitInfo = function(){

        if(!$scope.form.$invalid) {
            // 判断附件是否上传
            if($scope.suppleUploadVo.notUpload){
                modalAlert($modal,$scope.suppleUploadVo.notUploadInfo);
                $scope.submit = false;
                return false;
            }
            //获得提交的url
            if($scope.suppleUploadVo.actType == "1"){
                $scope.submitUrl = "deposit_change_task/suppleUpload";
            }else{
                $scope.submitUrl = "deposit_change_task/suppleSendBack";
            }
            if(CommonObjectUtils.isNotExist($scope.submitUrl)){
                modalAlert($modal,"请选择操作分类");
            }else{
                $scope.submit = true;
                $http.post($scope.submitUrl,$scope.suppleUploadVo).success(function(data){
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

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.depositChange;
    $scope.wfLogNo = $scope.depositTaskNo;
}]);