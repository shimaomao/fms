/**
 * Created by yanfengbo on 2018-05-14.
 */
app.controller('cont_insur_claim_approve_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http,$modal,toaster,$location) {

    $scope.contInsurClaim={};

    $scope.formValidate = false;
    $scope.httpData = true;
    $scope.submit = false;
    //附件对象
    $scope.bizFilesList= [];

    $scope.insurClaimApproveTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.insurClaimApproveType)


    $scope.bizFilesList={bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.insuranceFile}
    $scope.detailFlag = CommonFileUtils.detailFlags.detail;
    $scope.taskId = $location.search()['taskId'];
    $scope.serviceId = $location.search()['serviceId']
    init();
    function init(){
        if(isUndefinedNull($scope.serviceId)){
            $scope.serviceId = null;
        }
            $http.get('cont_insur_claim/findDetailContInsurClaim?&serviceId='+$scope.serviceId).success(function(data){
                $scope.contInsurClaim = data.data;
                console.log(data.data);
                $scope.contInsurClaim.actType =  $scope.insurClaimApproveTypeList[1].codeValue;
               /* $scope.bizFilesList.bizFilesInfo = $scope.contInsurClaim.bizfilesVo.bizFilesInfo;
                $scope.bizFilesList.bizFilesListVos = $scope.contInsurClaim.bizfilesVo.bizFilesListVos;*/
                //附件赋值
                $scope.bizFilesList = $scope.contInsurClaim.bizFilesList;
                //保险类型
                $scope.insuranceTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes[$scope.contInsurClaim.insuranceType]);
                var insuranceSelectInfo = $scope.contInsurClaim.insuranceSelectInfo;
                if(isNotUndefinedNull(insuranceSelectInfo)) {
                    $scope.infoArrayList = insuranceSelectInfo.split(',');
                    for (var i in $scope.infoArrayList) {
                        for (var j in $scope.insuranceTypeList) {
                            if ($scope.insuranceTypeList[j].codeValue == $scope.infoArrayList[i])
                                $scope.insuranceTypeList[j].orderNo = 1;
                        }
                    }
                }
                //是否需要退还
                $scope.returnFlagList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.returnFlag);
                //退还方式
                $scope.returnModeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.returnMode);
            })

    }

    $scope.treeFileId = "insurance_file_tree";


    /**
     * 保存组织机构属性信息
     */

    $scope.modify = function () {

        if($scope.contInsurClaim.actType == '0'){
            $scope.url = 'insur_claim_check/approval';
        }else if($scope.contInsurClaim.actType == '1'){
            $scope.url = 'insur_claim_check/sendBack';
        }
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.contInsurClaim.taskId = $scope.taskId = $location.search()['taskId'];
            $http.put($scope.url, $scope.contInsurClaim).success(function (data) {
                if (data.code == Response.successCode){
                    if($scope.contInsurClaim.actType=="0"){
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                    }else{
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'退回成功'});
                    }
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

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.contInsurClaim;
    $scope.wfLogNo = $scope.serviceId;

}]);


