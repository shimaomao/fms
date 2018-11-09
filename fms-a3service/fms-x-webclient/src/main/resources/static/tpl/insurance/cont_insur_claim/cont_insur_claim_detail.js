/**
 * Created by yanfengbo on 2018-05-14.
 */
app.controller('cont_insur_claim_detail_controller', ['$scope', '$http','$modal','$location',function ($scope, $http,$modal,$location) {

    $scope.contInsurClaim={};
    $scope.httpData = true;
    /*$scope.treeFileId = "insurance_file_tree";
    $scope.bizFilesList={bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.insuranceFile}
    $scope.detailFlag = CommonFileUtils.detailFlags.detail;*/
    //$scope.contNo =  $location.search()['contNo'];
    //附件对象
    $scope.bizFilesList= [];
    $scope.contVehinsId = $location.search()['contVehinsId'];
    $scope.contInsurClaimId = $location.search()['contInsurClaimId'];
    init();
    function init(){
        if(isNotUndefinedNull($scope.contInsurClaimId)){
            $http.get('cont_insur_claim/findDetailedByContNo?contVehinsId='+$scope.contVehinsId+'&contInsurClaimId='+$scope.contInsurClaimId+'&serviceId='+$scope.serviceId).success(function(data){
                $scope.contInsurClaim = data.data
                $scope.contInsurClaimNoForLog=$scope.contInsurClaim.contInsurClaimNo;
                console.log(data.data);
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

                /**
                 * 引用流程日志共通
                 */
                $scope.wfLogType = CommonCodeUtils.bizTypes.contInsurClaim;
                $scope.wfLogNo = $scope.contInsurClaimNoForLog;

                $scope.$broadcast("logJobToSon",$scope.cstmPersJob);
            })
        }
    }


    /**
     * 文件下载
     */
    $scope.downLoad = function () {
        window.parent.open("file/downloadFile?fileCompletePath=");
    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goback = function(){
        $location.path('app/insurance_cont_insur_claim_list');
    };
}]);


