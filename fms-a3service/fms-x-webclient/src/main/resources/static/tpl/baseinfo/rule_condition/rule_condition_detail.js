/**
 * Created by qiaomengnan on 2018-05-17.
 */
app.controller('rule_condition_detail_controller', ['$scope', '$http','$modal', '$modalInstance','ruleCondition', function ($scope, $http,$modal, $modalInstance,ruleCondition) {

    $scope.ruleCondition=ruleCondition;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


