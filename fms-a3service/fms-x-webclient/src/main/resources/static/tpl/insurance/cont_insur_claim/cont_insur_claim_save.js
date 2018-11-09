/**
 * Created by yanfengbo on 2018-05-14.
 */
app.controller('cont_insur_claim_save_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.contInsurClaim={};
    $scope.httpData = true;
    $scope.notUpload = false;
    $scope.msgInfo = null;
    $scope.formValidate = false;
    //文件对象
   /* $scope.fileValue  = {fileVos:[],fileVoUrls:[]};
    $scope.treeFileId = "insurance_file_tree";*/
    //附件对象
    $scope.bizFilesList= [];
    $scope.submit = false;
    $scope.contNo = $location.search()['contNo']== 'undefined'?null:$location.search()['contNo'];
    $scope.contVehinsId = $location.search()['contVehinsId']== 'undefined'?null:$location.search()['contVehinsId'];
    $scope.contInsurClaimId = $location.search()['contInsurClaimId'] == 'undefined'?null:$location.search()['contInsurClaimId'];
    $scope.serviceId = $location.search()['serviceId']== 'undefined'?null:$location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId']== 'undefined'?null:$location.search()['taskId'];
    init();
    function init(){
        if(isUndefinedNull($scope.contNo)){
            $scope.contNo = '';
        }
        if(isUndefinedNull($scope.contVehinsId)){
            $scope.contVehinsId = '';
        }
        if(isUndefinedNull($scope.serviceId)){
            $scope.serviceId = '';
        }
        if(isUndefinedNull($scope.taskId)){
            $scope.taskId = '';
        }
            $http.get('cont_insur_claim/findDetailedByContNo?contVehinsId='+$scope.contVehinsId+'&contInsurClaimId='+$scope.contInsurClaimId+'&serviceId='+$scope.serviceId).success(function(data){
                //任务号不为空时说明是退回待提交,否则是初次提交或未退回的状态
                if(isNotUndefinedNull($location.search()['serviceId'])){
                    $scope.contInsurClaim = data.data;
                    //附件赋值
                    $scope.bizFilesList = $scope.contInsurClaim.bizFilesList;
                    //保险类型
                    $scope.insuranceTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes[$scope.contInsurClaim.insuranceType]);
                    console.log($scope.insuranceTypeList)
                    var insuranceSelectInfo = $scope.contInsurClaim.insuranceSelectInfo;
                    if(isNotUndefinedNull(insuranceSelectInfo)){
                        $scope.infoArrayList = insuranceSelectInfo.split(',');
                        for(var i in $scope.infoArrayList){
                            for(var j in $scope.insuranceTypeList){
                                if($scope.insuranceTypeList[j].codeValue == $scope.infoArrayList[i])
                                    $scope.insuranceTypeList[j].orderNo = 1;
                            }
                        }
                    }
                }else {
                    //保险理赔id不为空说明时是未退回的状态,可回显并新录一条,否则是初次提交的
                    if(isNotUndefinedNull(data.data.contInsurClaimId)){
                        $scope.contInsurClaim = data.data;
                        $scope.contInsurClaim = data.data;
                        //保险类型
                        $scope.insuranceTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes[$scope.contInsurClaim.insuranceType]);
                        console.log($scope.insuranceTypeList)
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
                    }else {
                        $scope.contInsurClaim = data.data;
                        $scope.contInsurClaim = data.data;
                        $scope.contInsurClaim.returnFlag=1;
                        $scope.contInsurClaim.returnMode=1;
                        //申请日期默认当前日期
                        var myDate = new Date();
                        year = myDate.getFullYear();
                        month = myDate.getMonth()+1;
                        day = myDate.getDate();
                        var time = year+'-' + month+'-'+day
                        $scope.contInsurClaim.insurClaimDate = time;
                        //保险类型
                        $scope.insuranceTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes[$scope.contInsurClaim.insuranceType]);
                        console.log($scope.insuranceTypeList)
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
                    }
                }
                console.log(data);
            })
    }

    //是否需要退还
    $scope.returnFlagList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.returnFlag);
    //退还方式
    $scope.returnModeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.returnMode);

    $scope.postFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.postFlag);

    //银行选择
    // $scope.selectBasBankInfo = function(){
    //     var rtn = $modal.open({
    //         backdrop : 'static',
    //         size:'lg',
    //         templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
    //         controller: 'bas_bank_info_select_controller',
    //         resolve:{
    //              selectBank: null
    //         }
    //     });
    //     rtn.result.then(function (data) {
    //         if(data != null) {
    //             $scope.contInsurClaim.accBank = data.accBankName;
    //             $scope.contInsurClaim.accountName = data.accountName;
    //             $scope.contInsurClaim.accountNo = data.accountNo;
    //             $scope.valid = false;
    //         }
    //     },function(){
    //
    //     });
    // }


    /**
     * 保险理赔申请
     */
    $scope.save = function () {

        if(!$scope.form.$invalid && !$scope.notUpload) {
            $scope.submit = true;
            // $scope.contInsurClaim.contNo = $scope.contNo;
            // $scope.contInsurClaim.contVehinsId = $scope.contVehinsId;
            // $scope.contInsurClaim.bizfilesVo = $scope.bizFilesList;
            // $scope.contInsurClaim.insurClaimStatus= $scope.insurClaimStatus;
            // $scope.contInsurClaim.contInsurClaimId=$scope.contInsurClaimId;
            $scope.contInsurClaim.taskId=$scope.taskId;
            $scope.contInsurClaim.serviceId=$scope.serviceId;
            if($scope.taskId){
                $scope.contInsurClaim.insurClaimStatus = '0504';
                // $scope.contInsurClaim.bizfilesVo = $scope.bizFilesList;
                $scope.contInsurClaim.bizFilesList = $scope.bizFilesList;
            }else{
                $scope.contInsurClaim.contNo = $scope.contNo;
                $scope.contInsurClaim.contVehinsId = $scope.contVehinsId;
                // $scope.contInsurClaim.bizfilesVo = $scope.bizFilesList;
                $scope.contInsurClaim.bizFilesList = $scope.bizFilesList;
                $scope.contInsurClaim.contInsurClaimId=$scope.contInsurClaimId;
                $scope.contInsurClaim.insurClaimStatus= '';
            }

            console.log($scope.contInsurClaim.validStartDay)
            //$scope.contInsurClaim.validEndDay
            $http.post('cont_insur_claim/saveContInsurClaim', $scope.contInsurClaim).success(function (data) {
                if (data.code == Response.successCode){
                    if($scope.taskId){
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                    }else{
                        modalAlert($modal,'申请成功');
                        $location.path('app/insurance_cont_insur_claim_list')
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
            if($scope.form.$invalid){
                toaster_info(promptInfo.submitWarn,toaster);
            }else{
                toaster_info($scope.msgInfo,toaster);
            }
            $scope.formValidate = true;
        }


    }



    /**
     * 关闭窗口
     * @param status
     */
    $scope.goback = function(){
        if($scope.taskId){
            $location.path('/app/home')
        }else{
            $location.path('app/insurance_cont_insur_claim_list')
        }
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.contInsurClaim;
    $scope.wfLogNo = $scope.serviceId;

}]);


