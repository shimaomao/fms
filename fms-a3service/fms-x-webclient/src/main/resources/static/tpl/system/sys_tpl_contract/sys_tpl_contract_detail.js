/**
 * Created by wubaoliang on 2018-03-12.
 */
app.controller('sys_tpl_contract_detail_controller', ['$scope', '$http','$modal', '$location', function ($scope, $http,$modal, $location) {

    // 取得模板信息
    $http.get('sys_tpl/findSysTplVoByTplId?tplId='+ $location.search()['tplId']).success(function(data){
        $scope.sysTpl = data.data;
        $scope.sysTpl.enableFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag, $scope.sysTpl.enableFlag);
    });

    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("app/system_sys_tpl_contract_list");
    };

}]);


