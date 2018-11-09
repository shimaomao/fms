<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableNameNew = table.tableNameNew>
<#assign tableNameNewLowerCase = table.tableNameNewLowerCase>
<#assign tableNameNewLowerCaseAll = table.tableNameNewLowerCaseAll>
/**
 * Created by ${username} on ${.now?string["yyyy-MM-dd"]}.
 */
app.controller('${table.sqlName}_detail_controller', ['$scope', '$http','$modal', '$modalInstance','${tableNameNewLowerCase!classNameLower}', function ($scope, $http,$modal, $modalInstance,${tableNameNewLowerCase!classNameLower}) {

    $scope.${tableNameNewLowerCase!classNameLower}=${tableNameNewLowerCase!classNameLower};

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


