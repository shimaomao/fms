/**
 * Created by yangyiquan on 2018-6-04.
 */
app.controller('borrow_task_payment_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.borrowTaskBackVo={};
    $scope.formValidate = false;
    $scope.submit = false;

    $http.get('orig_file_detail/getBorrowTaskMakeVoucherByBorrowBackTaskNo?borrowBackTaskNo='+$location.search()['serviceId']).success(function (data) {
        console.log(data.data);
        $scope.borrowTaskBackVo = data.data;
        $scope.borrowTaskBackVo.borrowBackTaskNo = $location.search()['serviceId'];
        $scope.borrowTaskBackVo.taskId = $location.search()['taskId'];
    });

    /**
     * 审核通过
     */
    $scope.save = function () {
        if(!$scope.form.$invalid){
            $scope.submit = true;
            $http.post('orig_file_detail/borrowPayment',$scope.borrowTaskBackVo).success(function(data) {
                if (data.code == Response.successCode){
                    $location.path("app/home");
                }else{
                    modalAlert($modal, data.message);
                }
                $scope.submit = false;
            })
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    }

    /**
     * 退回上一级
     */
    $scope.sendBack = function () {
        $scope.submit = true;
        $http.post('orig_file_detail/borrowPaymentBack',$scope.borrowTaskBackVo).success(function(data) {
            if (data.code == Response.successCode){
                $location.path("app/home");
            }else{
                modalAlert($modal, data.message);
                $scope.submit = false;
            }
        })
    }

    //返回到主页
    $scope.backHome = function () {
        $location.path('app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.origBorrowBack;
    $scope.wfLogNo = $location.search()['serviceId'];
}]);


