/**
 * Created by ningyangyang on 2018-05-03.
 */
app.controller('orig_file_detail_detail_controller', ['$scope', '$http','$modal', '$modalInstance','origFileDetail', function ($scope, $http,$modal, $modalInstance,origFileDetail) {

    $scope.origFileDetail=origFileDetail;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


