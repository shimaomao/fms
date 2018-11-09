/**
 * Created by yangyiquan on 2018-05-09.
 */
app.controller('contRepayAccount_modify_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    // 开户行
    $scope.accBankList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.openingBank);
    //定金是否抵扣车款
    $scope.deductibleFeesList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.deductibleFees);

    $scope.contRepayAccount={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('contRepayAccount/findContRepayAccountByContNo?contNo='+ $location.search()['contNo']).success(function(data){
        console.info(data.data);
        $scope.contRepayAccount = data.data;
    });

    /**
     * 修改客户还款信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('contRepayAccount/modifyContRepayAccount', $scope.contRepayAccount).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("app/prebiz_cont_repay_account_list").search({type:"modify"});
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
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/prebiz_cont_repay_account_list");
    };

}]);


