/**
 * Created by ningyangyang on 2018-06-23.
 */
app.controller('assis_account_type_detail_controller', ['$scope', '$http', '$modal', '$location',  function ($scope, $http, $modal, $location) {

        $scope.assisAccountType={};

        $http.get('assis_account_type/findAssisAccountTypeByAssisAccountTypeId?assisAccountTypeId='+ $location.search()['assisAccountTypeId']).success(function(data){
            $scope.assisAccountType = data.data;
        });
        /**
         * 返回
         * @param status
         */
        $scope.close = function(status){
            $location.path("app/assis_account_type_list");
        };

}]);


