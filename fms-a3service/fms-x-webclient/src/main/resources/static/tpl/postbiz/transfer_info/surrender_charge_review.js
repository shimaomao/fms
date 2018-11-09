
app.controller('surrender_charge_review_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {
    $scope.transferInfoRetreatsVo={};
    $scope.formValidate = false;
    $scope.httpData = true;
    $scope.processLogShow = true;
    $scope.serviceId = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.submit = false;
    $scope.retreatsNo = $scope.serviceId;

    //获取回显数据
    $http.get('transfer_info/findTransferInfoRetreatVoByRetreatsNo?&retreatsNo='+$scope.serviceId).success(function(data){
        $scope.transferInfoRetreatsVo = data.data;
        //保险类型
        if ($scope.transferInfoRetreatsVo.insuranceType) {
            $scope.insuranceSelectInfoList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes[$scope.transferInfoRetreatsVo.insuranceType]);
        }
    });

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
                $scope.transferInfoRetreatsVo.payAccBank = data.accBankName;
                $scope.transferInfoRetreatsVo.payAccountName = data.accountName;
                $scope.transferInfoRetreatsVo.payAccountNo = data.accountNo;
                $scope.transferInfoRetreatsVo.payAccBranch = data.accBranchBank;
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

            $scope.transferInfoRetreatsVo.serviceId = $scope.serviceId;
            $scope.transferInfoRetreatsVo.taskId = $scope.taskId;
            $http.post("transfer_info/makeVoucher", $scope.transferInfoRetreatsVo).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
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
}]);



