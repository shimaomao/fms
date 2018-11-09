/**
 * Created by yangyiquan on 2018/5/3
 */
app.controller('contract_detail_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster, $compile, $location) {
    $scope.applyNo = $location.search()['applyNo'];
    $scope.applyType = $location.search()['applyType'];
    $scope.contNo = $location.search()['contNo'];
    // 返回
    $scope.goBack = function () {
        $location.path("app/prebiz_contract_list");
    };

}]);