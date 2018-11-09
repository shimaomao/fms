/**
 * Created by ningyangyang on 2018-05-23.
 */
app.controller('crm_company_detail_controller', ['$scope', '$http','$modal', '$location', function ($scope, $http,$modal, $location) {

    $scope.companyId = $location.search()['companyId'];

    $http.get('crm_company/findCrmCompanyByCompanyId?companyId='+ $scope.companyId).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.crmCompany = data.data;
        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    //返回
    $scope.goBack = function () {
        $location.path('/app/crm_person_list').search({
            "companyId": null
        });
    };
}]);


