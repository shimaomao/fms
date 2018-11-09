/**
 * Created by qiaomengnan on 2018-05-17.
 */
app.controller('rule_consequence_detail_controller', ['$scope', '$http','$modal', '$modalInstance','ruleConsequence', function ($scope, $http,$modal, $modalInstance,ruleConsequence) {

    $scope.ruleConsequence=ruleConsequence;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


