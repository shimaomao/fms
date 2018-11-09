/**
 * Created by ningyangyang on 2018-03-26.
 */
app.controller('cstm_person_detail_controller', ['$scope', '$http','$modal', '$modalInstance','cstmPerson', function ($scope, $http,$modal, $modalInstance,cstmPerson) {

    $scope.cstmPerson=cstmPerson;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


