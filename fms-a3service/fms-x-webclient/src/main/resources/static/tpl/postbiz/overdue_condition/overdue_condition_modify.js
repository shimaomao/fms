

app.controller('overdue_condition_modify_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {
    // 启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);
    // 逾期风险等级
    $scope.overdueRiskList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.overdueRisk);
    $scope.overdueCondition={};
    $scope.formValidate = false;
    $scope.submit = false;

    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    $scope.showCheck=$location.search()['operate']=='check'||false;

    if ($scope.showUpdate||$scope.showCheck) {
        $http.get('overdue_condition/findOverdueConditionByOverdueConditionId?overdueConditionId='+ $location.search()['overdueConditionId']).success(function(data){
            $scope.overdueCondition = data.data;
        });
    }


    $scope.modify = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.put('overdue_condition/modifyOverdueCondition', $scope.overdueCondition).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path("app/postbiz_overdue_condition_list").search({messageType:'modifyOverdueCondition'});
                }
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


    };
    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/postbiz_overdue_condition_list");
    };
}]);
