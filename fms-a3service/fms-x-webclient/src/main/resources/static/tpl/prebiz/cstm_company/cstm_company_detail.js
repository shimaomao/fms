/**
 * Created by ningyangyang on 2018-03-27.
 */
app.controller('cstm_company_detail_controller', ['$scope', '$http','$modal', '$modalInstance','cstmCompany', function ($scope, $http,$modal, $modalInstance,cstmCompany) {

    $scope.cstmCompany=cstmCompany;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


