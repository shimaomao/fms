/**
 * Created by ningyangyang on 2018-05-25.
 */
app.controller('common_borrower_detail_controller', ['$scope', '$http','$modal', '$modalInstance','commonBorrower', function ($scope, $http,$modal, $modalInstance,commonBorrower) {

    $scope.commonBorrower=commonBorrower;
    //关闭窗口
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


