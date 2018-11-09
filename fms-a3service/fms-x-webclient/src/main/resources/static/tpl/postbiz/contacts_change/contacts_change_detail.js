/**
 * Created by lijunjun on 2018-09-01.
 */
app.controller('contacts_change_detail_controller', ['$scope', '$http','$modal', '$modalInstance','contactsChange', function ($scope, $http,$modal, $modalInstance,contactsChange) {

    $scope.contactsChange=contactsChange;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


