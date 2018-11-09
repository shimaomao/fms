/**
 * Created by yanfengbo on 2018-05-03.
 */
app.controller('bas_sales_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {


    $scope.basSales={};
    $scope.httpData = true;
    //附件对象
    $scope.bizFilesList= [];
    $scope.areaName=AreaUtils.getAllAreaName();

    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.basSales={vehicleForm:''};
    //车辆类型list
    $scope.vehicleFormList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleForm);

    $scope.showCheck=$location.search()['operate']=='check'||false;

    if ($scope.showCheck) {
        $http.get('bas_sales/findBasSalesBySalesId?salesId='+ $location.search()['salesId']+'&serviceId='+$scope.serviceId).success(function(data){
            $scope.basSales = data.data;
            $scope.basSales.salesTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.salesType,$scope.basSales.salesType);
            $scope.basSales.withinGroupName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.withinGroup,$scope.basSales.withinGroup);
            $scope.basSales.salesTaskStatusName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.salesTaskStatus,$scope.basSales.salesTaskStatus);
            //附件赋值
            $scope.bizFilesList = $scope.basSales.bizFilesList;
        });
    }



    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/baseinfo_bas_sales_list");
    };

}]);


