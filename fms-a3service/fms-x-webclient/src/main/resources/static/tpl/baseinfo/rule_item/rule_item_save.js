/**
 * Created by qiaomengnan on 2018-05-17.
 */
app.controller('rule_item_save_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {


    $scope.ruleItem={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.ruleItemTypes = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.ruleItemType);
    $scope.ruleTypes = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.ruleType);


    /**
     * 保存规则引擎项目信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('rule_item/saveRuleItem', $scope.ruleItem).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("app/baseinfo_rule_item").search({messageType:'saveRuleItem'});
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


