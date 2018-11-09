

app.controller('surrender_charge_confirm_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.transferInfoRetreatsVo={};
    $scope.formValidate = false;
    $scope.httpData = true;
    $scope.processLogShow = true;
    //审批操作
    $scope.surrenderChargeActTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.surrenderChargeActType)

    $scope.serviceId = $location.search()['serviceId'];
    $scope.retreatsNo = $scope.serviceId;
    $scope.taskId = $location.search()['taskId'];
    $scope.submit = false;

    //获取回显数据
    $http.get('transfer_info/findTransferInfoRetreatVoByRetreatsNo?&retreatsNo='+$scope.serviceId).success(function(data){
        $scope.transferInfoRetreatsVo = data.data;
        $scope.transferInfoRetreatsVo.actType =  $scope.surrenderChargeActTypeList[0].codeValue;
        //保险类型
        if ($scope.transferInfoRetreatsVo.insuranceType) {
            $scope.insuranceSelectInfoList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes[$scope.transferInfoRetreatsVo.insuranceType]);
        }
    });

    /**
     * 提交申请
     */
    $scope.url="";
    $scope.submitInfo = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.url="transfer_info/payment";//提交
            $scope.transferInfoRetreatsVo.serviceId = $scope.serviceId;
            $scope.transferInfoRetreatsVo.taskId = $scope.taskId;
            $http.post($scope.url, $scope.transferInfoRetreatsVo).success(function (data) {
                if (data.code == Response.successCode){
                    if($scope.transferInfoRetreatsVo.actType=="0"){
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



