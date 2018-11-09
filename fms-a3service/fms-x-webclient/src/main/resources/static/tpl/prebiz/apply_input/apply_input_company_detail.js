/**
 * Created by ningyangyang on 2018/4/11.
 */

app.controller('apply_input_company_detail_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster, $compile, $location) {
    $scope.applyNo = $location.search()['applyNo'];

    // 返回
    $scope.goBack = function () {

    };

}]);
