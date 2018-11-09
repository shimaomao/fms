/**
 * Created by qiaomengnan on 2018-05-25.
 */
app.controller('financial_voucher_data_detail_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.formValidate = false;
    $scope.submit = false;
    $scope.voucherNo = $location.search()['voucherNo'];
    $scope.finVouDatas = [];

    $http.get('financial_voucher_data/findFinVouDataVoDetails?voucherNo=' + $scope.voucherNo).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.finVouDatas = data.data;
        } else
            modalAlert($modal,data.message);
    }).error(function(data){
        modalAlert($modal,data);
    })


    $scope.assisDetail = function(voucherDataId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/finance/financial_voucher_data/financial_voucher_assis_detail.html?datetime='+getTimestamp(),
            controller: 'financial_voucher_assis_detail_controller',
            resolve:{
                voucherDataId: function(){return voucherDataId}
            }
        });
        rtn.result.then(function (data) {

        },function(){
        });
    }

    $scope.goBack = function(){
        $location.path('app/financial_voucher_summary_list');
    };

}]);


