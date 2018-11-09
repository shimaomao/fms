/**
 * Created by qiaomengnan on 2018-05-17.
 */
app.controller('rule_condition_save_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','ruleType', function ($scope, $http,$modal, $modalInstance,toaster,ruleType) {

    $scope.ruleCondition={condLogicValue2:''};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.logicTypes = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.logicType);

    $scope.ruleItems = [];

    $scope.ruleItemNames = {};

    $http.get('rule_item/findRuleItemsByRuleTypeAndItemType?ruleType='+ruleType+'&itemType='+CommonCodeUtils.codeValues.ruleItemTypeCondition).success(function (data) {
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


    $scope.save = function(){
        if(!$scope.form.$invalid) {
            $scope.ruleCondition.condItemKeyName = $scope.ruleItemNames[$scope.ruleCondition.condItemKey];
            $modalInstance.close($scope.ruleCondition);
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    $scope.close = function(){
        $modalInstance.close();
    }


}]);


