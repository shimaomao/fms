/**
 * Created by yanfengbo on 2018-05-22.
 */
app.controller('car_collect_comp_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {
    $scope.carCollectComp={};

    $scope.areaName=AreaUtils.getAllAreaName();

    $scope.frameTitle=$location.search()['frameTitle'];

    $scope.showCheck=$location.search()['operate']=='check'||false;

    $scope.detailFlag = 0;

    //附件对象
    $scope.treeFileId = "tree_file_car_collect_comp";
    $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.carCollectCompFile};

    if ($scope.showCheck) {
        $http.get('car_collect_comp/findCarCollectCompByCarCollectCompId?carCollectCompId='+ $location.search()['carCollectCompId']).success(function(data){
            $scope.carCollectComp = data.data;
            $scope.bizFilesList.bizFilesInfo = $scope.carCollectComp.bizfilesVo.bizFilesInfo;
            $scope.bizFilesList.bizFilesListVos = $scope.carCollectComp.bizfilesVo.bizFilesListVos;
        });
    }

    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/postbiz_car_collect_comp_list");
    };

}]);


