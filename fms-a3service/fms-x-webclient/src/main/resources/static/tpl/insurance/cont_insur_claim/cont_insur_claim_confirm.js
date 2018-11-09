/**
 * Created by ningyangyang on 2018/5/22.
 */
app.controller('cont_insur_claim_confirm_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http,$modal,toaster,$location) {

    $scope.contInsurClaim={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.insurClaimApproveTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.insurClaimApproveType)


    $scope.bizFilesList={bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.insuranceFile}
    $scope.detailFlag = CommonFileUtils.detailFlags.detail;
    $scope.contInsurClaimId = $location.search()['contInsurClaimId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.serviceId = $location.search()['serviceId']
    init();
    function init(){
        if(isUndefinedNull($scope.contInsurClaimId)){
            $scope.contInsurClaimId = null;
        }
        if(isUndefinedNull($scope.serviceId)){
            $scope.serviceId = null;
        }
        $http.get('cont_insur_claim/findDetailContInsurClaim?contInsurClaimId='+$scope.contInsurClaimId+'&serviceId='+$scope.serviceId).success(function(data){
            $scope.contInsurClaim = data.data;
            $scope.contInsurClaim.postFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.postFlag,$scope.contInsurClaim.postFlag);
            console.log(data.data);
            $scope.contInsurClaim.actType = '0';
            $scope.bizFilesList.bizFilesInfo = $scope.contInsurClaim.bizfilesVo.bizFilesInfo;
            $scope.bizFilesList.bizFilesListVos = $scope.contInsurClaim.bizfilesVo.bizFilesListVos;
        })

    }

    $scope.treeFileId = "insurance_file_tree";


    /**
     * 保存组织机构属性信息
     */

    $scope.modify = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.contInsurClaim.taskId = $scope.taskId = $location.search()['taskId'];
            $http.put('insur_claim_check/approval', $scope.contInsurClaim).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path('/app/home')
                }
                else
                    modalAlert($modal,data.message);
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
     * 关闭窗口
     * @param status
     */
    $scope.goback = function(){
        $location.path('/app/home')
    };

}]);



