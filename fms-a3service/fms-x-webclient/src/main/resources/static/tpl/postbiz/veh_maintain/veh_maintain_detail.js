/**
 * Created by qinmuqiao on 2018-09-15.
 */
app.controller('veh_maintain_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {

    $scope.vehMaintain={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.httpData = true;
    $scope.notUpload = false;

    //附件对象
    $scope.bizFilesList= [];

    $http.get('veh_maintain/findVehMaintainVoByVehMaintainId?vehMaintainId='+$location.search()['vehMaintainId']).success(function(data){
        $scope.vehMaintain = data.data;
        $scope.vehMaintain.maintainFlagVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.maintainFlag,$scope.vehMaintain.maintainFlag)
        $scope.bizFilesList = $scope.vehMaintain.bizFilesList;
    });

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(status){
        $location.path('/app/postbiz_veh_maintain_list');
    };

}]);


