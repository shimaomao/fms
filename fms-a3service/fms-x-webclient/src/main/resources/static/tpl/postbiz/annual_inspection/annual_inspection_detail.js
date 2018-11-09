/**
 * Created by qinmuqiao on 2018-09-08.
 */
app.controller('annual_inspection_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {

    $scope.annualInspection={};

    // 编辑用户组层级
    $http.get('annual_inspection/findAnnualInspectionVoByAnnualInspectionId?annualInspectionId='+$location.search()['annualInspectionId']).success(function(data){
        $scope.annualInspection = data.data;
        $scope.annualInspection.annualInspectStatusVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.annualInspectStatus,$scope.annualInspection.annualInspectStatus)

    });
    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(){
        $location.path('app/postbiz_annual_inspection_list');
    };

}]);


