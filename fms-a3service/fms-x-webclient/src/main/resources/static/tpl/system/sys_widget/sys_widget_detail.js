/**
 * Created by wangxue on 2018-03-09.
 */
app.controller('sys_widget_detail_controller', ['$scope', '$http','$modal', '$modalInstance','sysWidget', function ($scope, $http,$modal, $modalInstance,sysWidget) {

    $scope.sysWidget=sysWidget;
    $scope.sysWidget.widgetTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.sys_widget_type,$scope.sysWidget.widgetType);

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


