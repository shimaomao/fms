/**
 * Created by license_idx on 2018-09-12.
 */
app.controller('license_idx_detail_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.licenseIdx={};

    $scope.formValidate = false;
    //附件对象
    $scope.bizFilesList= [];

    $scope.submit = false;
    var licenseIdxId = $location.search()['licenseIdxId'];

    $http.get('license_idx/findLicenseIdxVoByLicenseIdxId?licenseIdxId='+ licenseIdxId).success(function(data){
        $scope.licenseIdx = data.data;
        $scope.bizFilesList = $scope.licenseIdx.bizFilesList;
    });


    /**
     * 返回窗口
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("app/postbiz_license_idx_list");
    };
}]);


