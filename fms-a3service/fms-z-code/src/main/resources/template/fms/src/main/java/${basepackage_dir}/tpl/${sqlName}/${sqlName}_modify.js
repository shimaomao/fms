<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableNameNew = table.tableNameNew>
<#assign tableNameNewLowerCase = table.tableNameNewLowerCase>
<#assign tableNameNewLowerCaseAll = table.tableNameNewLowerCaseAll>
<#assign pkColumn = table.firstPkColumnName>
<#assign pkColumnFirstLower = table.firstPkColumnNameFirstLower>
/**
 * Created by ${username} on ${.now?string["yyyy-MM-dd"]}.
 */
app.controller('${table.sqlName}_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','${pkColumnFirstLower}', function ($scope, $http,$modal, $modalInstance,toaster,${pkColumnFirstLower}) {

    $scope.${tableNameNewLowerCase!classNameLower}={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('${table.sqlName}/find${tableNameNew!className}By${pkColumn}?${pkColumnFirstLower}='+ ${pkColumnFirstLower}).success(function(data){
        $scope.${tableNameNewLowerCase!classNameLower} = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('${table.sqlName}/modify${tableNameNew!className}', $scope.${tableNameNewLowerCase!classNameLower}).success(function (data) {
                if (data.code == Response.successCode)
                    $scope.close(Response.successMark);
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }


    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


