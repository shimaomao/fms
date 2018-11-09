/**
 * Created by license_idx on 2018-09-11.
 */
app.controller('license_idx_save_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.licenseIdx={};

    $scope.formValidate = false;

    $scope.notUpload = false;
    $scope.msgInfo = null;

    $scope.submit = false;

    //指标状态
    $scope.licenseStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseIdxStatus);

    //附件对象
    $scope.bizFilesList= [];
    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {
        // 上传附件信息
        $scope.licenseIdx.bizFilesList = $scope.bizFilesList;

        if(!$scope.form.$invalid && !$scope.notUpload) {

            $scope.submit = true;

            $http.post('license_idx/saveLicenseIdx', $scope.licenseIdx).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("app/postbiz_license_idx_list").search({type:'save'});
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

    //选择所属分公司
    $scope.selectGroupname = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/product/product/product_user.html'+getCacheTime(),
            controller: 'product_user_controller',
            resolve:{
                setData: function () {
                    return {
                        "checkboxOrRadio": Radio
                    };
                }
            }
        });
        rtn.result.then(function (data) {
            if(isNotUndefinedNull(data)){
                $scope.licenseIdx.group_name = data.groupName;
                $scope.licenseIdx.idxGroup = data.groupId;
                $scope.licenseIdx.group_district = data.groupDistrict;
            }
        },function(){

        });
    };

    $scope.checkLicenseIdxNo = function() {
        var licenseIdxNo = $scope.licenseIdx.licenseIdxNo;
        $http.get('license_idx/checkLicenseIdxVoBylicenseIdxNo?licenseIdxNo='+ licenseIdxNo).success(function(data){
            if(data.data!=null && data.data.licenseIdxNo!=""){
                modalAlert($modal,'该指标编号已存在，请重新录入！');
                $scope.licenseIdx.licenseIdxNo="";
            }
        });
    }

    /**
     * 返回窗口
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("app/postbiz_license_idx_list");
    };

}]);


