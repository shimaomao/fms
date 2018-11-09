/**
 * Created by qiaohao on 2018/6/5.
 */
app.controller('equ_mor_charge_finance_receipt_tab_controller', ['$scope', '$http', '$modal', 'toaster','$location', function ($scope, $http, $modal, toaster,$location) {
    $scope.equMorTaskNo = $location.search()['serviceId'];
    $scope.equMorCharge = {}
    $scope.equMorDetails = [];

    $scope.equMorChargeFinReceiptVo = {taskId:$location.search()['taskId'],equMorTaskNo:$scope.equMorTaskNo,taskDefinitionKey:$location.search()['taskDefinitionKey']}

    $http.get('equ_mor_apply/findFinanceTouchingVo?equMorTaskNo=' + $scope.equMorTaskNo).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.equMorDetails = data.data.equMorDetailVos;
            $scope.equMorCharge = data.data.equMorCharge;
            var management = "";
            if ($scope.equMorDetails && $scope.equMorDetails.length > 0){
                for(var index in $scope.equMorDetails){
                    if (!management){
                        $scope.management = $scope.equMorDetails[index].management;
                        break;
                    }
                }
            }
        }
        else
            modalAlert($modal,data.message);
    }).error(function(data){
        modalAlert($modal,data);
    })


    $scope.contReceiptVos = [];

    //银行选择
    $scope.selectBasBankInfo = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_bank_info_select_controller',
            resolve:{
                selectBank: function () {
                    return { organizationType: CommonCodeUtils.organizationType.userGroup}
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.contReceiptVos.push({
                    recAccBank:data.accBankName,
                    recAccountNo:data.accountNo,
                    recAccountName:data.accountName,
                    recEleBankNo:data.eleAccountNo,
                    recAccBranch:data.accBranchBank,
                    receiptDate:data.receiptDate?data.receiptDate:getToday(),
                    memo:data.memo
                })
            }
        },function(){

        });
    }

    //删除收款银行信息
    $scope.del = function(data){
        for(var i in $scope.contReceiptVos){
            if($scope.contReceiptVos[i].recAccountNo == data){
                $scope.contReceiptVos.splice(i,1)
                return;
            }
        }
    }

    //返回到主页
    $scope.goBack = function () {
        $location.path("app/home");
    }


    $scope.save = function(){


        if(!$scope.form.$invalid) {

            $scope.submit = true;
            var check = true;

            if($scope.contReceiptVos.length < 1){
                modalAlert($modal,"请选择收款银行");
                check = false;
            }

            for(var i in $scope.contReceiptVos){
                if(CommonObjectUtils.isNotExist($scope.contReceiptVos[i]['receiptAmount'])){
                    check =false;
                    modalAlert($modal,"请输入实收金额");
                    break;
                }
            }

            if(check) {
                $scope.equMorChargeFinReceiptVo.contReceiptVos = $scope.contReceiptVos;
                $http.post('equ_mor_apply/financeReceipt', $scope.equMorChargeFinReceiptVo).success(function (data) {
                    if (data.code == Response.successCode) {
                        $location.path("/app/home").search({type: 'homeToastInfo', msg: '确认收款成功'});
                    } else {
                        modalAlert($modal, data.message);
                        $scope.submit = false;
                    }
                }).error(function (data) {
                    modalAlert($modal, data);
                    $scope.submit = false;
                })
            }else{
                $scope.submit = false;
            }

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }


    }



}])
;