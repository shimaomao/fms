
app.controller('cont_insur_claim_make_voucher_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {
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

    //银行选择
    $scope.selectBasBankInfo = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_bank_info_select_controller',
            resolve:{
                selectBank: function () {
                    return {organizationType: CommonCodeUtils.organizationType.userGroup}
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.contInsurClaim.payAccBank = data.accBankName;
                $scope.contInsurClaim.payAccountName = data.accountName;
                $scope.contInsurClaim.payAccountNo = data.accountNo;
                $scope.contInsurClaim.payAccBranch = data.accBranchBank;
            }
        },function(){

        });
    }

    /**
     * 提交申请
     */
    $scope.submitInfo = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;

            $scope.contInsurClaim.serviceId = $scope.serviceId;
            $scope.contInsurClaim.taskId = $scope.taskId;
            $http.post("cont_insur_claim_pay/makeVoucher", $scope.contInsurClaim).success(function (data) {
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
     * 保险理赔付款单打印
     */
    $scope.printContInsurClaim = function () {
            CommonFileUtils.downloadFilePost('cont_insur_claim_pay/printContInsurClaim',$scope.contInsurClaim
                ,$http,$modal,$scope);
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



