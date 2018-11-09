
app.controller('pilfer_insurance_input_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {
    $scope.$on('filesToFather',function (e,data) {
        $scope.bizFilesList = data;
    });

    $scope.pilferInsurance={};

    $scope.formValidate = false;
    $scope.httpData = true;
    $scope.notUpload = false;
    $scope.msgInfo = null;
    $scope.submit = false;

    $scope.gpsSellerList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gpsSeller);

    //附件对象
   /* $scope.treeFileId = "tree_file_pilferInsurance";
    $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.pilferInsuranceFile};*/
    //附件对象
    $scope.bizFilesList= [];


    $http.get('pilfer_insurance/findPilferInsuranceVoByContNo?contNo=' + $location.search()['contNo']).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.pilferInsurance = data.data;
            /*$scope.bizFilesList.bizFilesInfo = $scope.pilferInsurance.bizfilesVo.bizFilesInfo;
            $scope.bizFilesList.bizFilesListVos = $scope.pilferInsurance.bizfilesVo.bizFilesListVos;*/
            //附件赋值
            $scope.bizFilesList = $scope.pilferInsurance.bizFilesList;
            // $scope.pilferInsurance.applyType = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.applyType,$scope.pilferInsurance.applyType);
            // $scope.pilferInsurance.licenseAttr = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,$scope.pilferInsurance.licenseAttr);
            //
            // $scope.gpsSellerList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gpsSeller);
            // $scope.pilferInsuranceFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.pilferInsuranceFlag);
            // $scope.gpsInstallStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gpsInstallStatus);
            //
            // $scope.pilferInsurance.gpsSeller = $scope.pilferInsurance.gpsSeller == null?"":$scope.pilferInsurance.gpsSeller;
            // $scope.pilferInsurance.installProvince = $scope.pilferInsurance.installProvince == null?"":$scope.pilferInsurance.installProvince;
            // $scope.pilferInsurance.installCity = $scope.pilferInsurance.installCity == null?"":$scope.pilferInsurance.installCity;
            // $scope.pilferInsurance.installCounty = $scope.pilferInsurance.installCounty == null?"":$scope.pilferInsurance.installCounty;
            // $scope.pilferInsurance.dispatchFlag = $scope.pilferInsurance.dispatchFlag == null?"":$scope.pilferInsurance.dispatchFlag;
            // $scope.pilferInsurance.installStatus = $scope.pilferInsurance.installStatus == null?"":$scope.pilferInsurance.installStatus;

        } else
            modalAlert($modal,data.message);
    }).error(function(data){
        modalAlert($modal,data);
    })

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        // $scope.pilferInsurance.bizfilesVo = $scope.bizFilesList;
        // 上传附件信息
        $scope.pilferInsurance.bizFilesList = $scope.bizFilesList;

        if(!$scope.form.$invalid && !$scope.notUpload) {

            $scope.submit = true;
            if(isNotUndefinedNull($scope.pilferInsurance.pilferInsuranceId)){
                //更新
                $http.put('pilfer_insurance/modifyPilferInsurance', $scope.pilferInsurance).success(function (data) {
                    if (data.code == Response.successCode) {
                        $location.path('app/cost_pilfer_insurance_list').search({messageType:'pilferInsuranceInput'});
                    }else
                        modalAlert($modal,data.message);
                    $scope.submit = false;
                }).error(function(data){
                    modalAlert($modal,data);
                    $scope.submit = false;
                })
            }else {
                //新增
                $scope.pilferInsurance.contNo = $location.search()['contNo'];
                $http.post('pilfer_insurance/savePilferInsurance', $scope.pilferInsurance).success(function (data) {
                    if (data.code == Response.successCode) {
                        $location.path('app/cost_pilfer_insurance_list').search({messageType:'pilferInsuranceInput'});
                    }else
                        modalAlert($modal,data.message);
                    $scope.submit = false;
                }).error(function(data){
                    modalAlert($modal,data);
                    $scope.submit = false;
                })
            }
        }else{
            if($scope.form.$invalid){
                toaster_info(promptInfo.submitWarn,toaster);
            }else{
                toaster_info($scope.msgInfo,toaster);
            }
            $scope.formValidate = true;
        }


    }




    $scope.goBack = function(){
        $location.path('app/cost_pilfer_insurance_list');
    };


}]);



