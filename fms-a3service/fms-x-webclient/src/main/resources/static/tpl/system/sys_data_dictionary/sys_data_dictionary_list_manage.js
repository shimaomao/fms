/**
 * Created by qiaohao on 2018/2/27.
 */
app.controller('sys_data_dictionary_list_manage_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$modalInstance','sysDataDic', function ($scope, $http, $modal, toaster,$compile,$modalInstance,sysDataDic) {

    $scope.sysDataDicParent = sysDataDic;

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_data_dictionary/findSysDataDictionaryVoByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_data_dictionary_manage_table_' + $scope.dataDicParentId,
        //table的列
        dataTableColumn: [
            defaultCheckBox(),
            defaultDetail('dataDicName','detailSysDataDictionary','字典名称','20%',$compile,$scope),
            {title:'字典编码',data:'dataDicCode',width:'20%'},
            {title:'上级字典',data:'dataDicParentName',width:'20%',
                render: function (data, type, row, meta) {
                    if(row.dataDicParentId == 0)
                        return '无上级';
                    else
                        return data;
                }},
            {title:'状态',data:'dataDicDisable',width:'20%',
                render: function (data, type, row, meta) {
                    if(data == 0)
                        return '启用';
                    else
                        return '禁用';
                }
            },
            {title:'备注',data:'dataDicDesc',width:'20%'}
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.dataDicName = $scope.dataDicName;
        params.dataDicCode = $scope.dataDicCode;
        params.dataDicParentId = $scope.sysDataDicParent.id;
        return params;
    }

    $scope.init = function(){
        $("#sys_data_dictionary_manage_table").attr("id","sys_data_dictionary_manage_table_" + $scope.dataDicParentId)
        //创建dataTable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    }

    $scope.searchSysDataDictionary = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetSysDataDictionary = function(){
        $scope.description="";
        $scope.dataTable.fnDraw(true);//框架内部方法
    }


    $scope.saveSysDataDictionary = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_data_dictionary/sys_data_dictionary_save.html'+getCacheTime(),
            controller: 'sys_data_dictionary_save_controller',
            resolve:{
                sysDataDicParent: function(){return $scope.sysDataDicParent}
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加数据字典信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifySysDataDictionary = function(sysResourceId){
        var rowsIds =  $scope.dataTable.getRowsIds('id');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/system/sys_data_dictionary/sys_data_dictionary_modify.html'+getCacheTime(),
                controller: 'sys_data_dictionary_modify_controller',
                resolve:{
                    sysDataDicId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑数据字典信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    $scope.detailSysDataDictionary = function(sysDataDicId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_data_dictionary/sys_data_dictionary_detail.html'+getCacheTime(),
            controller: 'sys_data_dictionary_detail_controller',
            resolve:{
                sysDataDic : function (){ return $scope.dataTable.getRow(sysDataDicId) }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteSysDataDictionary = function(){
        var rowsIds =  $scope.dataTable.getRowsIds();
        if(rowsIds.length < 1){
            alert('请选择要删除的数据');
        }else{
            modalConfirm($modal,function(){
                $http.delete('sys_data_dictionary/deleteSysDataDictionaryByIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除数据字典信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        alert(data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

    $scope.manageSysDataDictionary = function(){
        var rowsIds =  $scope.dataTable.getRowsIds();
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要管理的数据字典');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时管理一条数据字典');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/system/sys_data_dictionary/sys_data_dictionary_list_manage.html'+getCacheTime(),
                controller: 'sys_data_dictionary_list_manage_controller',
                resolve:{
                    sysDataDic : function (){ return $scope.dataTable.getRow() }
                }
            });
            rtn.result.then(function (status) {

            },function(){
            });
        }
    }

}])
;