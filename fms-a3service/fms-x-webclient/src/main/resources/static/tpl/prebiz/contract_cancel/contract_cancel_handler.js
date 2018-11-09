

app.controller('contract_cancel_handler_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    $scope.contractCancel={};
    $scope.formValidate = false;

    $scope.submit = false;


    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.bizStatus=$location.search()['bizStatus'];
    console.log($scope.bizStatus)
    $scope.showUpdate=$location.search()['operate']=='update'||false;

    if ($scope.showUpdate) {
        $http.get('contract_cancel/findContractCancelVoByContNo?contNo='+ $location.search()['contNo']).success(function(data){
            $scope.contractCancel = data.data;
            if($scope.contractCancel.bizStatus != $scope.bizStatus){
                modalAlert($modal,"合同状态已更新，请返回重新选择");
                $scope.submit = true;
                return;
            }
            $scope.contractCancel.contractCancelReasonKey="contractCancelReasonKey";
            $scope.contractCancel.bizStatusName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,$scope.contractCancel.bizStatus);
            $scope.contractCancel.vehicleFormName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleForm,$scope.contractCancel.vehicleForm);
            $scope.contractCancelReasonList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contractCancelReason);
        });
    }




    /**
     * 修改融资合同取消
     */
    $scope.modify = function () {


        if(!$scope.form.$invalid) {

            $scope.submit = true;
            $scope.contractCancel.contractCancelReason = $scope.contractCancelReason;
            $http.put('contract_cancel/modifyContractCancel', $scope.contractCancel).success(function (data) {
                if (data.code == Response.successCode){
                    /*toaster_success('编辑成功',toaster);*/
                    $location.path("app/prebiz_contract_cancel_list");
                    modalAlert($modal,"提交成功");
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


    };
    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/prebiz_contract_cancel_list");
    };
}]);

