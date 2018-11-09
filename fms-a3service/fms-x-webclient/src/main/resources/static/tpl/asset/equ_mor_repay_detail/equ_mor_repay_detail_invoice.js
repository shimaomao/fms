/**
 * Created by ningyangyang on 2018/8/21.
 */
app.controller('equ_mor_repay_detail_invoice_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {

    $scope.equMorRepayDetail = {};
    $scope.equMorRepayDetails = JSON.parse($location.search()['equMorRepayDetails']);
    //提交开票信息post
    $scope.save = function () {

        $scope.submit = true;
        $http.post('equ_mor_repay_detail/updateEquMorRepayDetailPayStatus',$scope.equMorRepayDetails).success(function (data) {
        if (data.code == Response.successCode)
            $location.path("app/asset_equ_mor_repay_detail_list").search({'msg':'更新成功'});
        else
            modalAlert($modal,data.message);
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        });

    }

    //监听批量录入的日期
    $scope.init = false;
    $scope.$watch("allInvoiceDate",function(newVal,oldVal){
        if($scope.init){
            angular.forEach($scope.equMorRepayDetails,function (val) {
                val.payUpdateDate = newVal;
            })
        }else{
            $scope.init = true;
        }
    })


    //返回
    $scope.goBack = function () {
        $location.path('app/asset_equ_mor_repay_detail_list');
    }

}])
;
