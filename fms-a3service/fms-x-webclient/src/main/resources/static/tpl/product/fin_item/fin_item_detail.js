/**
 * Created by niehaibing on 2018-03-21.
 */
app.controller('fin_item_detail_controller', ['$scope', '$http','$modal', '$location', function ($scope, $http,$modal,$location ) {
    $scope.finItem={};
    //牌照类型list
    $scope.licenseAttrList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr);
    //融资方式list
    $scope.finModeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.finMode);

    $http.get('fin_item/findFinItemByFinItemId?finItemId='+ $location.search()['finItemId']).success(function(data){
        $scope.finItem = data.data;
        $scope.finItem.editMode=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.editMode,$scope.finItem.editMode);
        $scope.finItem.payMode=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.payMode,$scope.finItem.payMode);

    });

   // $scope.finItem=finItem;

    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(status){

        $location.path("app/product_fin_item_list");
    };

}]);


