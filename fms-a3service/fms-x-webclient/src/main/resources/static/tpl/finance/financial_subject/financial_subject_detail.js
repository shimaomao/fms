/**
 * Created by yanfengbo on 2018-06-20.
 */
app.controller('financial_subject_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {

    $scope.financialSubject={};

    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.showCheck=$location.search()['operate']=='check'||false;

    if ($scope.showCheck) {
        $http.get('financial_subject/findFinancialSubjectBySubjectId?subjectId='+ $location.search()['subjectId']).success(function(data){
            $scope.financialSubject = data.data;
            $scope.assisAccountTypeList = $scope.financialSubject.assisAccountTypeVos;
        });
    }

    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/finance_financial_subject_list");
    };

}]);


