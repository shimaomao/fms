/**
 * Created by qiaomengnan on 2018-05-17.
 */
app.controller('rule_consequence_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','ruleType' , 'ruleConsequence', function ($scope, $http,$modal, $modalInstance,toaster,ruleType,ruleConsequence) {

    $scope.ruleConsequence= ruleConsequence;

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.logicTypes = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.logicType);
    $scope.ruleItems = [];
    $scope.ruleItemNames = {};
    $http.get('rule_item/findRuleItemsByRuleTypeAndItemType?ruleType='+ruleType+'&itemType='+CommonCodeUtils.codeValues.ruleItemTypeConsequence).success(function (data) {
        if (data.code == Response.successCode){
            $scope.ruleItems = data.data;
            for(var i in $scope.ruleItems){
                var ruleItem = $scope.ruleItems[i];
                $scope.ruleItemNames[ruleItem.ruleItemKey] = ruleItem.ruleItemName;
            }
        } else
            modalAlert($modal,data.message);

    }).error(function(data){
        modalAlert($modal,data);

    })

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {
        if(!$scope.form.$invalid) {
            $scope.ruleConsequence.conseqItemKeyName = $scope.ruleItemNames[$scope.ruleConsequence.conseqItemKey];
            $modalInstance.close($scope.ruleConsequence);
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close();
    };

}]);


