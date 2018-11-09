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
app.controller('${table.sqlName}_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : '${table.sqlName}/find${tableNameNew!className}sByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'${table.sqlName}_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('${pkColumnFirstLower}'),
            <#assign index = 0>
            <#list table.columns as column>
            <#if column.columnNameFirstLower!=pkColumnFirstLower && column.columnNameFirstLower!="createTime" && column.columnNameFirstLower!="creator" && column.columnNameFirstLower!="updateTime" && column.columnNameFirstLower!="updater" && column.columnNameFirstLower!="delFlag">
            <#if index == 0>
            defaultDetail('${column.columnNameFirstLower}','detail${tableNameNew!className}','${(column.remarks!="")?string(column.remarks,column.columnNameFirstLower)}','20%',$compile,$scope),
            <#else>
            {title:'${(column.remarks!="")?string(column.remarks,column.columnNameFirstLower)}',data:'${column.columnNameFirstLower}',width:'20%'},
            </#if>
            <#assign index = index + 1>
            </#if>
            </#list>
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        <#assign index = 0>
        <#list table.columns as column>
        <#if column.columnNameFirstLower!=pkColumnFirstLower && column.columnNameFirstLower!="createTime" && column.columnNameFirstLower!="creator" && column.columnNameFirstLower!="updateTime" && column.columnNameFirstLower!="updater" && column.columnNameFirstLower!="delFlag">
        <#if index < 2>
        params.${column.columnNameFirstLower} = $scope.${column.columnNameFirstLower};
        </#if>
        <#assign index = index + 1>
        </#if>
        </#list>
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.search${tableNameNew!className} = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.reset${tableNameNew!className} = function(){
        <#assign index = 0>
        <#list table.columns as column>
        <#if column.columnNameFirstLower!=pkColumnFirstLower && column.columnNameFirstLower!="createTime" && column.columnNameFirstLower!="creator" && column.columnNameFirstLower!="updateTime" && column.columnNameFirstLower!="updater" && column.columnNameFirstLower!="delFlag">
        <#if index < 2>
        $scope.${column.columnNameFirstLower} = "";
        </#if>
        <#assign index = index + 1>
        </#if>
        </#list>
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.save${tableNameNew!className} = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/${servername}/${table.sqlName}/${table.sqlName}_save.html'+getCacheTime(),
            controller: '${table.sqlName}_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加${servicename}成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modify${tableNameNew!className} = function(${pkColumnFirstLower}){
        var rowsIds =  $scope.dataTable.getRowsIds('${pkColumnFirstLower}');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/${servername}/${table.sqlName}/${table.sqlName}_modify.html'+getCacheTime(),
                controller: '${table.sqlName}_modify_controller',
                resolve:{
                    ${pkColumnFirstLower} : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑${servicename}成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    $scope.detail${tableNameNew!className} = function(${pkColumnFirstLower}){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/${servername}/${table.sqlName}/${table.sqlName}_detail.html'+getCacheTime(),
            controller: '${table.sqlName}_detail_controller',
            resolve:{
                ${tableNameNewLowerCase!classNameLower} : function (){ return $scope.dataTable.getRow(${pkColumnFirstLower},'${pkColumnFirstLower}') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.delete${tableNameNew!className} = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('${pkColumnFirstLower}');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('${table.sqlName}/delete${tableNameNew!className}sBy${pkColumn}s',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除${servicename}成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

}])
;