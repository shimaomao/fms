/**
 * Created by ningyangyang on 2018-06-20.
 */
app.controller('financial_voucher_detail_save_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.financialVoucherDetail={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.crdrFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.crdrFlag);

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;
            $scope.financialVoucherDetail.assisAccountTypes = null;
            $http.post('financial_voucher_detail/saveFinancialVoucherDetail', $scope.financialVoucherDetail).success(function (data) {
                if (data.code == Response.successCode){
                    modalAlert($modal,Response.successMessage);
                    $location.path('app/financial_voucher_detail_list');
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
    //选择凭据类型
    $scope.selectVoucherType = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/finance/financial_voucher_detail/financial_voucher_list_select.html?datetime='+getTimestamp(),
            controller: 'financial_voucher_list_select_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.financialVoucherDetail.voucherType = data;
            }
        },function(){

        });
    }

    //选择科目代码
    $scope.selectSubjectCd = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/finance/financial_subject/financial_subject_select_list.html?datetime='+getTimestamp(),
            controller: 'financial_subject_select_list_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.financialVoucherDetail.subjectCd = data.subjectCd;
                var assisAccountTypes =  data.assisAccountTypeVos
                var str = '';
                for(var i in assisAccountTypes){
                    if(i == assisAccountTypes.length - 1){
                        str = str + assisAccountTypes[i].assisAccountTypeName;
                    }else{
                        str = str + assisAccountTypes[i].assisAccountTypeName + '/';
                    }
                }
                $scope.financialVoucherDetail.assisAccountTypes = str;
            }
        },function(){

        });
    }

    $scope.yesNoFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.yesNoFlag);
    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(status){
        $location.path('app/financial_voucher_detail_list');
    };

}]);


