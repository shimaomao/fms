/**
 * Created by yanfengbo on 2018-03-09.
 */
app.controller('overdue_condition_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {

    $scope.overdueCondition={};


    $scope.frameTitle=$location.search()['frameTitle'];

    $scope.showCheck=$location.search()['operate']=='check'||false;

    if ($scope.showCheck) {

        $http.get('overdue_condition/findOverdueConditionByOverdueConditionId?overdueConditionId='+ $location.search()['overdueConditionId']).success(function(data){
            $scope.overdueCondition = data.data;
            $scope.overdueCondition.enableFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,$scope.overdueCondition.enableFlag);
            $scope.overdueCondition.overdueRiskName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.overdueRisk,$scope.overdueCondition.overdueRisk);

        });
    }



    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/postbiz_overdue_condition_list");
    };

}]);


