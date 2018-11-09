/**
 * Created by lijunjun on 2018-05-07.
 */
app.controller('cont_prepayment_confirm_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location', function ($scope, $http, $modal, toaster,$compile, $location) {

    $scope.submit = false;
    $scope.formValidate = false;
    $scope.contReceiptVo = {};


    //选择财务明细
    $scope.selectContReceiptDetail = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/asset/cont_prepayment/cont_prepayment_confirm_select_list.html'+getCacheTime(),
            controller: 'cont_prepayment_confirm_select_list_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.contReceiptVo.contReceiptId = data.contReceiptId;
                $http.get('cont_receipt/findContReceiptByContReceiptId?contReceiptId='+ $scope.contReceiptVo.contReceiptId).success(function (data) {
                    $scope.contReceiptVo = data.data;
                    $scope.contReceiptVo.contNo = $location.search()['serviceId'];
                    $scope.contReceiptVo.taskId = $location.search()['taskId'];
                    $scope.contReceiptVo.taskDefinitionKey = $location.search()['taskDefinitionKey'];
                });
            }
        },function(){

        });
    }

    //财务确认
    $scope.financeConfirm = function () {
        debugger;
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            if ($scope.contReceiptVo.restAmount >= $scope.contReceiptVo.financeConfirmAmount){
                $http.post('cont_prepayment/financeConfirm', $scope.contReceiptVo).success(function (result) {
                    if (result.code == Response.successCode) {
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'确认成功'});
                        // modalAlert($modal,"执行成功");
                        // $location.path('/app/home').search({type:'homeToastInfo', msg:'合同生成前确认成功'});
                    } else {
                        modalAlert($modal,result.message);
                    }
                    $scope.submit = false;
                });
            }else{
                modalAlert($model, "剩余金额不足，不能勾稽");
                $scope.submit = false;
            }
        } else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    }
}])
;