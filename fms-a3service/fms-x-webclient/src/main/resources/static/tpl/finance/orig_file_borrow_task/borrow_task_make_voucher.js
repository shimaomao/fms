/**
 * Created by lijunjun on 2018-05-30.
 * 财务制单
 */
app.controller('borrow_task_make_voucher_controller', ['$scope', '$http','$modal','toaster','$location','$compile',function ($scope, $http,$modal,toaster,$location,$compile) {

    $scope.borrowTaskBackVo={};
    $scope.formValidate = false;
    $scope.submit = false;

    $http.get('orig_file_detail/getBorrowTaskMakeVoucherByBorrowBackTaskNo?borrowBackTaskNo='+$location.search()['serviceId']).success(function (data) {
        console.log(data.data);
        $scope.borrowTaskBackVo = data.data;
        $scope.borrowTaskBackVo.borrowBackTaskNo = $location.search()['serviceId'];
        $scope.borrowTaskBackVo.taskId = $location.search()['taskId'];
        // $scope.borrowTaskBackVo.payAccBank = "";
        // $scope.borrowTaskBackVo.payAccountNo = "";
        // $scope.borrowTaskBackVo.payAccountName = "";
        // $scope.borrowTaskBackVo.payEleBankNo = "";
    });

    /**
     * 审核通过
     */
    $scope.save = function () {
        if(!$scope.form.$invalid){
            $scope.submit = true;
            $http.post('orig_file_detail/borrowMakeVoucher',$scope.borrowTaskBackVo).success(function(data) {
                if (data.code == Response.successCode){
                    $location.path("app/home");
                }else{
                    modalAlert($modal, data.message);
                    $scope.submit = false;
                }
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
        $http.post('orig_file_detail/borrowMakeVoucherBack',$scope.borrowTaskBackVo).success(function(data) {
            if (data.code == Response.successCode){
                $location.path("app/home");
            }else{
                modalAlert($modal, data.message);
                $scope.submit = false;
            }
        })
    }

    //选择银行信息
    $scope.selectBasBankInfo = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_bank_info_select_controller',
            resolve:{
                selectBank: function () {
                    return {'organizationType':CommonCodeUtils.organizationType.userGroup};
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.borrowTaskBackVo.payAccBank = data.accBankName;
                $scope.borrowTaskBackVo.payAccountName = data.accountName;
                $scope.borrowTaskBackVo.payAccountNo = data.accountNo;
                $scope.borrowTaskBackVo.payEleBankNo = data.eleAccountNo;
                $scope.borrowTaskBackVo.payAccBranch = data.accBranchBank;
            }
        },function(){
        });
    }

    /**
     * 借阅归还付款单打印
     */
    $scope.printBorrowTask = function () {
        CommonFileUtils.downloadFilePost('orig_file_detail/printBorrowTask',$scope.borrowTaskBackVo
            ,$http,$modal,$scope);
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


