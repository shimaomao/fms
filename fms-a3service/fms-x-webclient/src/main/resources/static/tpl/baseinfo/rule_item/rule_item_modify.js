/**
 * Created by qiaomengnan on 2018-05-17.
 */
app.controller('rule_item_modify_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.ruleItem={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.ruleItemTypes = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.ruleItemType);
    $scope.ruleTypes = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.ruleType);

    $http.get('rule_item/findRuleItemByRuleItemId?ruleItemId='+ $location.search()['ruleItemId']).success(function(data){
        $scope.ruleItem = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('rule_item/modifyRuleItem', $scope.ruleItem).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("app/baseinfo_rule_item").search({messageType:'modifyRuleItem'});
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }

    }


    $scope.goBack = function(){
        $location.path('app/baseinfo_rule_item');
    };


}]);


