/**
 * Created by niehaibing on 2018-03-27.
 */
app.controller('intrst_factor_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {

    $scope.intrstFactor={};
    $scope.frameTitle=$location.search()['frameTitle'];

    $scope.showCheck=$location.search()['operate']=='check'||false;

    if ($scope.showCheck) {
        $http.get('intrst_factor/findIntrstFactorByIntrstFactorId?intrstFactorId='+ $location.search()['intrstFactorId']).success(function(data){
            $scope.intrstFactor = data.data;
            $scope.intrstFactor.enableFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,$scope.intrstFactor.enableFlag);
            $scope.intrstFactor.factorTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.factorType,$scope.intrstFactor.factorType);
        });
    }

    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/product_intrst_factor_list");
    };

}]);


