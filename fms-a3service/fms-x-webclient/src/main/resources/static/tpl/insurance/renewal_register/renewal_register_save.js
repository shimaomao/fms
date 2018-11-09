/**
 * Created by ningyangyang on 2018-05-14.
 * 续保确认客户类型
 */
app.controller('renewal_register_save_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.renewalRegister={};

    $scope.formValidate = false;
    //文件对象
    $scope.fileValue  = {fileVos:[],fileVoUrls:[]};

    //附件对象
    $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.renewalRegisterFile};

    $scope.detailFlag = CommonFileUtils.detailFlags.upload;

    $scope.treeFileId = "renewalRegister_file_tree";
    $scope.submit = false;

    $scope.renewalContVehinsId =  $location.search()['renewalContVehinsId'];
    $scope.renewalRegisterId =  $location.search()['renewalRegisterId'];
    $scope.contNo =  $location.search()['contNo'];
    if(isNotUndefinedNull($scope.renewalRegisterId)){
        $http.get('renewal_register/findRenewalRegistersByPage?renewalRegisterId='+$scope.renewalRegisterId).success(function(data){
            console.log((data.data.data)[0])
            $scope.renewalRegister = (data.data.data)[0];
            //保险类型
            $scope.insuranceTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes[$scope.renewalRegister.insuranceType]);
            console.log($scope.insuranceTypeList)
            var insuranceSelectInfo = $scope.renewalRegister.insuranceSelectInfo;
            $scope.infoArrayList = []
            if(insuranceSelectInfo){
                $scope.infoArrayList = insuranceSelectInfo.split(',');
            }
            for(var i in $scope.infoArrayList){
                for(var j in $scope.insuranceTypeList){
                    if($scope.insuranceTypeList[j].codeValue == $scope.infoArrayList[i])
                        $scope.insuranceTypeList[j].orderNo = 'check';
                }
            }
        })
    }
    //是否融保险
    $scope.finFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.finFlag);
    //保险购买方式
    $scope.insurPurTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.insurPurType);

    /**
     * 续保上传
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.post('renewal_register/saveContInsuranceFromRenewalRegister', $scope.renewalRegister).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path('app/insurance_renewal_register_list').search({"type": 'homeToastInfo', "msg":'确认信息成功'})
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
        $location.path('app/insurance_renewal_register_list');
    };
    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.renewal;
    $scope.wfLogNo = $scope.renewalTaskNo;
}]);
