/**
 * Created by yangyiquan on 2018-05-04.
 */
app.controller('bas_blacklist_detail_controller', ['$scope', '$http','$modal', '$location', function ($scope, $http,$modal, $location) {

    $scope.basBlacklist={};


    $scope.frameTitle=$location.search()['frameTitle'];

    $scope.showCheck=$location.search()['operate']=='check'||false;

    if($scope.showCheck){
        $http.get('bas_blacklist/findBasBlacklistByBlacklistId?blacklistId='+ $location.search()['blacklistId']).success(function(data){
            $scope.basBlacklist = data.data;
            $scope.basBlacklist.blackLevelName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.blackLevel,$scope.basBlacklist.blackLevel);
            $scope.basBlacklist.sourceName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.source,$scope.basBlacklist.source);
        });
    }


    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/baseinfo_bas_blacklist_list");
    };

}]);


