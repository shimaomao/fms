/**
 * Created by niehaibing on 2018-03-21.
 */
app.controller('product_catg_detail_controller', ['$scope', '$http','$modal', '$location', function ($scope, $http,$modal, $location) {
    $scope.productCatg={};

    //车辆类型
    $scope.vehicleFormList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleForm);
    //车辆种类
    $scope.vehicleTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleType);
    //申请类型
    $scope.applyTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.applyType);

    $http.get('product_catg/findProductCatgByProductCatgId?productCatgId='+ $location.search()['productCatgId']).success(function(data){
        $scope.productCatg = data.data;
        $scope.productCatg.enableFlag=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,$scope.productCatg.enableFlag);
    });

    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("app/product_product_catg_list");
    };

}]);


