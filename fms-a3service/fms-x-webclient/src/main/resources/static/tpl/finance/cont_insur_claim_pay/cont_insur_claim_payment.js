
app.controller('cont_insur_claim_payment_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.contInsurClaim={};
    $scope.formValidate = false;
    $scope.httpData = true;
    //审批操作
    $scope.insurClaimApproveTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.insurClaimApproveType)

    // $scope.bizFilesList={bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.insuranceFile}
    // $scope.detailFlag = CommonFileUtils.detailFlags.detail;
    //附件对象
    $scope.bizFilesList= [];

    $scope.serviceId = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.submit = false;

    //获取回显数据
    $http.get('cont_insur_claim/findDetailContInsurClaim?&serviceId='+$scope.serviceId).success(function(data){
        $scope.contInsurClaim = data.data;
        $scope.contInsurClaim.actType =  $scope.insurClaimApproveTypeList[1].codeValue;
        // $scope.bizFilesList.bizFilesInfo = $scope.contInsurClaim.bizfilesVo.bizFilesInfo;
        // $scope.bizFilesList.bizFilesListVos = $scope.contInsurClaim.bizfilesVo.bizFilesListVos;
        //附件赋值
        $scope.bizFilesList = $scope.contInsurClaim.bizFilesList;
        console.log(data.data);
    });
    $scope.treeFileId = "insurance_file_tree";

    /**
     * 提交申请
     */
    $scope.url="";
    $scope.submitInfo = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.url="cont_insur_claim_pay/payment";//提交
            $scope.contInsurClaim.serviceId = $scope.serviceId;
            $scope.contInsurClaim.taskId = $scope.taskId;
            $http.post($scope.url, $scope.contInsurClaim).success(function (data) {
                if (data.code == Response.successCode){

                    if($scope.contInsurClaim.actType=="0"){
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                    }else{
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
    $scope.goback = function(){
        $location.path("/app/home").search({
            operate: null,
            contNo: null
        });
    };
    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.contInsurClaim;
    $scope.wfLogNo = $scope.serviceId;
}]);



