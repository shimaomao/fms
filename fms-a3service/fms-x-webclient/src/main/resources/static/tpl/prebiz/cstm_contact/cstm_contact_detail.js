/**
 * Created by ningyangyang on 2018-03-27.
 */
app.controller('cstm_contact_detail_controller', ['$scope', '$http','$modal', '$modalInstance','cstmContact', function ($scope, $http,$modal, $modalInstance,cstmContact) {

    $scope.cstmContact=cstmContact;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


