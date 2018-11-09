/**
 * Created by license_idx on 2018-09-11.
 */
app.controller('license_idx_modify_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.licenseIdx={};

    $scope.formValidate = false;
    //附件对象
    $scope.bizFilesList= [];

    $scope.submit = false;
    var licenseIdxId = $location.search()['licenseIdxId'];
    $scope.licenseIdxzt = $location.search()['licenseIdxzt'];

    //指标状态
    $scope.licenseStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseIdxStatus);

    $http.get('license_idx/findLicenseIdxVoByLicenseIdxId?licenseIdxId='+ licenseIdxId).success(function(data){
        $scope.licenseIdx = data.data;
        $scope.bizFilesList = $scope.licenseIdx.bizFilesList;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {
        // 上传附件信息
        $scope.licenseIdx.bizFilesList = $scope.bizFilesList;
        if(!$scope.form.$invalid && !$scope.notUpload) {

            $scope.submit = true;

            $http.put('license_idx/modifyLicenseIdx', $scope.licenseIdx).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("app/postbiz_license_idx_list").search({type:'modify'});
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            if($scope.form.$invalid){
                toaster_info(promptInfo.submitWarn,toaster);
            }else{
                toaster_info($scope.msgInfo,toaster);
            }
            $scope.formValidate = true;
        }
    }

    /**
     * 返回窗口
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("app/postbiz_license_idx_list");
    };
}]);


