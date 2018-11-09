/**
 * Created by ningyangyang on 2018/3/30.
 */
app.controller('borrower_info_detail_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$rootScope',function ($scope, $http, $modal, toaster,$compile,$location,$rootScope) {
    $scope.borrowerList = [];
    $scope.applyNo = $scope.$parent.applyNo;

    $scope.mateCertifNo = $rootScope.mateCertifNo;
    if($scope.applyNo){
        $http.get('apply_input/findApplyGuaranteeByApplyNo?applyNo='+ $scope.applyNo).success(function (data) {
            $scope.borrowerList = data.data.commonBorrowerList;
        });
    }


    $scope.detail = function (data) {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/common_borrower/common_borrower_detail.html'+getCacheTime(),
            controller: 'common_borrower_detail_controller',
            resolve:{
                commonBorrower: function () {
                    return data;
                }
            }
        });
        rtn.result.then(function (data) {

        },function(){
        });
    };
}])
;