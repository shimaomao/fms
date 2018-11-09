/**
 * Created by yangyiquan on 2018-03-26.
 */
app.controller('cont_prepayment_approve_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.contPrepaymentVo = {contPrepaymentNo:$location.search()['contPrepaymentNo']};
    $scope.$on('contPrepaymentToFather',function (e,data) {
        $scope.contPrepaymentVo = data;
    });

    $scope.formValidate = false;

    $scope.contPrepaymentNo = $location.search()['contPrepaymentNo'];
    $scope.submit = false;

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.contPrepayment;
    $scope.wfLogNo = $scope.contPrepaymentNo;

    /**
     * 提交提前还款信息
     */
    $scope.url="";
    $scope.submitInfo = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.contPrepaymentVo.memo = $scope.memo;
            $http.post('prepayment_auto_job/manualCancelPrepayment', $scope.contPrepaymentVo).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path("app/cost_cont_prepayment_list").search({type:"cancel"});
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
        $location.path('app/cost_cont_prepayment_list');
    };
}]);


