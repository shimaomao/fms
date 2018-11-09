/**
 * Created by qiaomengnan on 2018-05-17.
 */
app.controller('rule_item_detail_controller', ['$scope', '$http','$modal', '$modalInstance','ruleItem', function ($scope, $http,$modal, $modalInstance,ruleItem) {

    $scope.ruleItem=ruleItem;

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


