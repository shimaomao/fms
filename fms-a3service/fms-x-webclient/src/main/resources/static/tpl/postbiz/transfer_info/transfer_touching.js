/**
 * 过户任务：财务审核
 * Created by wangxue on 2018/9/11.
 */
app.controller('transfer_touching_controller', ['$scope', '$http','$modal', 'toaster','$location', function ($scope, $http, $modal, toaster, $location) {
    $scope.formValidate = false;

    $scope.submit = false;

    $scope.transferInfoVo = {transferNo:$location.search()['serviceId'], taskId:$location.search()['taskId'],
        examineSts:'1',taskDefinitionKey:$location.search()['taskDefinitionKey']};
    // 详情页面
    $scope.transferNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];

    // 获取子页面的数据
    $scope.$on('transferInfoVoToFather',function (e,data) {
        $scope.transferInfoVo.belongGroup = data.belongGroup;// 出租人
        $scope.transferInfoVo.cstmName = data.cstmName; // 承租人
        // 付款银行信息
        $scope.transferInfoVo.payAccBank = data.payAccBank;
        $scope.transferInfoVo.payAccountName = data.payAccountName;
        $scope.transferInfoVo.payAccountNo = data.payAccountNo;
        $scope.transferInfoVo.payEleBankNo = data.payEleBankNo;
        $scope.transferInfoVo.payAccBranch = data.payAccBranch;
    });

    // 提交
    $scope.submitInfo = function () {
        if (!$scope.form.$invalid) {
            $scope.submit = true;
            $http.post('transfer_info/transferApproval', $scope.transferInfoVo).success(function (result) {
                if (result.code == Response.successCode){
                    $location.path('/app/home').search({type:'homeToastInfo', msg:'审核成功'});
                }else{
                    modalAlert($modal, result.message);
                }

                $scope.submit = false;
            }).error(function(result){
                modalAlert($modal, result);
                $scope.submit = false;
            })
        } else {
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    // 打印付款单
    $scope.printPayment = function () {
        if(isUndefinedNull($scope.transferInfoVo.payAccBranch)){
            modalAlert($modal,'请选择付款信息');
            $scope.submit = false;
            return false;
        }
        console.log($scope.transferInfoVo);
        CommonFileUtils.downloadFilePost('transfer_info/printPaymentForm',$scope.transferInfoVo
            ,$http,$modal,$scope);
    };

    /**
     * 返回
     * @param status
     */
    $scope.goback = function(){
        $location.path("/app/home");
    };

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
                $scope.transferInfoVo.payAccBank = data.accBankName;
                $scope.transferInfoVo.payAccountName = data.accountName;
                $scope.transferInfoVo.payAccountNo = data.accountNo;
                $scope.transferInfoVo.payEleBankNo = data.eleAccountNo;
                $scope.transferInfoVo.payAccBranch = data.accBranchBank;
            }
        },function(){

        });
    };

}]);
