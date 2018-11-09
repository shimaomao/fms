/**
 * Created by ningyangyang on 2018-05-23.
 */
app.controller('crm_person_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {
    $scope.personId = $location.search()['personId'];
    $http.get('crm_person/findCrmPersonByPersonId?personId='+$scope.personId).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.crmPerson = data.data;
        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    //返回
    $scope.goBack = function () {
        $location.path('/app/crm_person_list').search({
            "personId": null
        });
    };
}]);


