/**
 * Created by yanfengbo on 2018-05-14.
 */
app.controller('bas_bank_info_approve_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http,$modal,toaster,$location) {

    $scope.basBankInfo={};
    $scope.httpData = true;
    //附件对象
    $scope.bizFilesList= [];
    $scope.formValidate = false;

    $scope.submit = false;
    $scope.insurClaimApproveTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.insurClaimApproveType)

    $scope.areaName=AreaUtils.getAllAreaName();
    $scope.taskId = $location.search()['taskId'];
    $scope.serviceId = $location.search()['serviceId']
    init();
    function init(){
        if(isUndefinedNull($scope.serviceId)){
            $scope.serviceId = null;
        }else {
            $http.get('bas_bank_info/findBasBankInfoByBankId?bankId='+ $scope.bankId+'&serviceId='+$scope.serviceId).success(function(data){
                $scope.basBankInfo = data.data;
                //附件赋值
                $scope.bizFilesList = $scope.basBankInfo.bizFilesList;
                $scope.basBankInfo.actType='0';
                console.log(data.data);
                $scope.basBankInfo.enableFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,$scope.basBankInfo.enableFlag);
                $scope.basBankInfo.accDefaultName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.accDefault,$scope.basBankInfo.accDefault);
                $scope.basBankInfo.openingBankName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.openingBank,$scope.basBankInfo.accBank);
                $scope.basBankInfo.organizationTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.organizationType,$scope.basBankInfo.organizationType);
                $scope.basBankInfo.accountNoStatusName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.accountNoStatus,$scope.basBankInfo.accountNoStatus);
                if ($scope.basBankInfo.organizationType == 4){
                    $scope.basBankInfo.organizationIdName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsAccType,$scope.basBankInfo.organizationId);
                }else if ($scope.basBankInfo.organizationType == 5){
                    $scope.basBankInfo.organizationIdName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.mortgageAccType,$scope.basBankInfo.organizationId);
                }else if ($scope.basBankInfo.organizationType == 6){
                    $scope.basBankInfo.organizationIdName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.insuranceAccType,$scope.basBankInfo.organizationId);
                }
            });
        }
    }

    /**
     * 保存组织机构属性信息
     */

    $scope.modify = function () {

        if($scope.basBankInfo.actType == '0'){
            $scope.url = 'bas_bank_info/approval';
        }else if($scope.basBankInfo.actType == '1'){
            $scope.url = 'bas_bank_info/sendBack';
        }
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.basBankInfo.taskId = $scope.taskId = $location.search()['taskId'];
            $scope.basBankInfo.serviceId = $scope.serviceId = $location.search()['serviceId'];
            console.log($scope.basBankInfo)
            $http.put($scope.url, $scope.basBankInfo).success(function (data) {
                if (data.code == Response.successCode){
                    if($scope.basBankInfo.actType=="0"){
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
    $scope.wfLogType = CommonCodeUtils.bizTypes.basBankInfo;
    $scope.wfLogNo = $scope.serviceId;

}]);



