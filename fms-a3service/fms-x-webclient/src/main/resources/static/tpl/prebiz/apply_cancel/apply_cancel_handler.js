

app.controller('apply_cancel_handler_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {
    //取消原因
    $scope.applyCancel={/*cancelReasonKey:"cancelReasonKey"*/};
    $scope.formValidate = false;

    $scope.submit = false;


    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.bizStatus=$location.search()['bizStatus'];
    console.log($scope.bizStatus)
    $scope.showUpdate=$location.search()['operate']=='update'||false;

    if ($scope.showUpdate) {
        $http.get('apply_cancel/findApplyCancelVoByApplyNo?applyNo='+ $location.search()['applyNo']).success(function(data){
            $scope.applyCancel = data.data;
            if($scope.applyCancel.bizStatus != $scope.bizStatus){
                modalAlert($modal,"订单状态已更新，请返回重新选择");
                $scope.submit = true;
                return;
            }
            $scope.applyCancel.cancelReasonKey="cancelReasonKey";
            $scope.applyCancel.bizStatusName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,$scope.applyCancel.bizStatus);
            $scope.cancelReasonList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.cancelReason);
        });
    }




    /**
     * 修改融资申请取消
     */
    $scope.modify = function () {


        if(!$scope.form.$invalid) {

            $scope.submit = true;
            $scope.applyCancel.cancelReason = $scope.cancelReason;
            $http.put('apply_cancel/modifyApplyCancel', $scope.applyCancel).success(function (data) {
                if (data.code == Response.successCode){
                    /*toaster_success('编辑成功',toaster);*/
                    $location.path("app/prebiz_apply_cancel_list");
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
        $location.path("app/prebiz_apply_cancel_list");
    };
}]);

