/**
 * Created by niehaibing on 2018-03-27.
 */
app.controller('intrst_factor_save_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http, $modal, toaster,$location) {
    //启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);
    //匹配类型
    $scope.factorTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.factorType);

    $scope.intrstFactor={};
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    $scope.showCheck=$location.search()['operate']=='check'||false;


    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;
            alert(JSON.stringify($scope.intrstFactor))
            console.log($scope.intrstFactor)

            $http.post('intrst_factor/saveIntrstFactor', $scope.intrstFactor).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("app/product_intrst_factor_list").search({messageType:'saveIntrstFactor'});
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }


    }

    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/product_intrst_factor_list");
    };

}]);


