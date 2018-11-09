/**
 * Created by ningyangyang on 2018-05-14.
 * 续保确认客户类型
 */
app.controller('renewal_register_confirm_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.renewalRegister={};

    $scope.formValidate = false;
    //文件对象
    $scope.fileValue  = {fileVos:[],fileVoUrls:[]};

    //附件对象
    $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.renewalRegisterFile};

    $scope.detailFlag = CommonFileUtils.detailFlags.upload;

    $scope.treeFileId = "renewalRegister_file_tree";
    $scope.submit = false;

    $scope.renewalTaskNo = $location.search()['serviceId']
    $scope.taskId = $location.search()['taskId']

    $scope.renewalContVehinsId =  $location.search()['renewalContVehinsId'];
    $scope.renewalRegisterId =  $location.search()['renewalRegisterId'];
    $scope.contNo =  $location.search()['contNo'];

        $http.get('renewal_register/findRenewalRegistersByTaskNo?renewalTaskNo='+$scope.renewalTaskNo).success(function(data){
            console.log(data.data)
            $scope.renewalRegister = data.data;
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
    //是否融保险
    $scope.finFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.finFlag);
    //保险购买方式
    $scope.insurPurTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.insurPurType);

    /**
     * 续保再次上传
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            // $scope.renewalRegister.renewalContVehinsId = $scope.renewalContVehinsId
            // $scope.renewalRegister.renewalRegisterId = $scope.renewalRegisterId
            // $scope.renewalRegister.contNo = $scope.contNo
            // $scope.renewalRegister.bizfilesVo = $scope.bizFilesList;
            $scope.renewalRegister.renewalTaskNo = $scope.renewalTaskNo;
            $scope.renewalRegister.taskId = $scope.taskId;
            $http.post('renewal_register/reSaveContInsuranceFromRenewalRegister', $scope.renewalRegister).success(function (data) {
                if (data.code == Response.successCode){
                    //modalAlert($modal,'确认信息成功');
                    $location.path('/app/home').search({"type": 'homeToastInfo', "msg":'确认信息成功'})
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
        $location.path('/app/home');
    };
    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.renewal;
    $scope.wfLogNo = $scope.renewalTaskNo;

}]);