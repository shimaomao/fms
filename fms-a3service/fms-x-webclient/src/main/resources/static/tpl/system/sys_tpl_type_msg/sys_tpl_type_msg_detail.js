/**
 * Created by wubaoliang on 2018-03-12.
 */
app.controller('sys_tpl_type_msg_detail_controller', ['$scope', '$http','$modal', '$location', function ($scope, $http,$modal,$location) {

    $scope.tplItemList = [];
    // 取得模板类型信息
    $http.get('sys_tpl_type/findSysTplTypeVoByTplTypeId?tplTypeId='+ $location.search()['tplTypeId']).success(function(data){
        $scope.sysTplType = data.data;
        $scope.tplItemList = $scope.sysTplType.tplItemList;
    });

    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("app/system_sys_tpl_type_msg_list");
    };

}]);


