/**
 * Created by qinmuqiao on 2018-09-19.
 */
app.controller('sec_hand_inventory_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {

    $scope.secHandInventory={};

    $http.get('sec_hand_inventory/findSecHandInventoryVoBySecHandId?secHandId='+$location.search()['secHandId']).success(function(data){
        $scope.secHandInventory = data.data;
        $scope.secHandInventory.statusVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.secHandStatus,$scope.secHandInventory.status)
        $scope.secHandInventory.carSourceVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.secHandCarSource,$scope.secHandInventory.carSource)

    });

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(status){
        $location.path('app/postbiz_sec_hand_inventory_list');
    };

}]);


