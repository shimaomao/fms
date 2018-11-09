/**
 * Created by niehaibing on 2018-03-15.
 */
app.controller('bas_area_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {
    // 取得模板信息
    $http.get('bas_area/findBasAreaByAreaId?areaId='+ $location.search()['areaId']).success(function(data){
        $scope.basArea = data.data;
        $scope.basArea.areaLevel = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.areaLevel,$scope.basArea.areaLevel);

    });


    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(status){

        $location.path("app/baseinfo_bas_area_list");
    };

}]);


