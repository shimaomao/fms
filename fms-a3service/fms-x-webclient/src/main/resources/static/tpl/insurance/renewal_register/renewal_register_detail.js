/**
 * Created by ningyangyang on 2018/7/17.
 */
/**
 * Created by ningyangyang on 2018-05-14.
 * 续保详情
 */
app.controller('renewal_register_detail_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.renewalRegister={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.renewalTaskNo = $location.search()['renewalTaskNo']

    $http.get('renewal_register/findRenewalRegistersByTaskNo?renewalTaskNo='+$scope.renewalTaskNo).success(function(data){
        console.log(data.data)
        $scope.renewalRegister = data.data;
        $scope.wfLogNo = $scope.renewalRegister.renewalTaskNo;
        //保险类型
        $scope.insuranceTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes[$scope.renewalRegister.insuranceType]);
        console.log($scope.insuranceTypeList)
        var insuranceSelectInfo = $scope.renewalRegister.insuranceSelectInfo;
        if(isNotUndefinedNull(insuranceSelectInfo)){
            $scope.infoArrayList = insuranceSelectInfo.split(',');
            for(var i in $scope.infoArrayList){
                for(var j in $scope.insuranceTypeList){
                    if($scope.insuranceTypeList[j].codeValue == $scope.infoArrayList[i])
                        $scope.insuranceTypeList[j].orderNo = 1;
                }
            }
        }
    })

    //是否融保险
    $scope.finFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.finFlag);
    //保险购买方式
    $scope.insurPurTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.insurPurType);


    /**
     * 关闭窗口
     * @param status
     */
    $scope.goback = function(){
        $location.path('/app/insurance_renewal_register_list');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.renewal;
    $scope.wfLogNo = $scope.renewalRegister.renewalTaskNo;
}])