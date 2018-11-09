/**
 * Created by niehaibing on 2018-03-15.
 */
app.controller('bas_area_modify_controller', ['$scope', '$http','$modal', 'toaster','$location', function ($scope, $http,$modal, toaster,$location) {

    $scope.basArea={};

    $scope.formValidate = false;

    $scope.submit = false;

    //
    $scope.areaLevelList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.areaLevel);

    $http.get('bas_area/findBasAreaByAreaId?areaId='+ $location.search()['areaId']).success(function(data){
        $scope.basArea = data.data;
    });

    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;


            $http.put('bas_area/modifyBasArea', $scope.basArea).success(function (data) {
                if (data.code == Response.successCode) {
                    $location.path("app/baseinfo_bas_area_list").search({type:"modify"});
                } else {
                    modalAlert($modal,data.message);
                }
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
    $scope.goBack = function(status){
        $location.path("app/baseinfo_bas_area_list");
    };


}]);


