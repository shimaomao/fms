/**
 * Created by qiaohao on 2018/2/1.
 */
app.controller('act_re_procdef_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    $scope.sysDataDicParent = {id:common_constant_data_dic_value.common_parent_id,
        dataDicName:consValue(common_constant_code.common_parent_id,common_constant_data_dic_value.common_parent_id)};

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'act_re_procdef/findActReProcdefVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'act_re_procdef_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox(),
            {title:'流程分类',data:'category',width:'20%'},
            {title:'流程标识',data:'key',width:'20%'},
            {title:'流程名称',data:'name',width:'20%'},
            {title:'流程图',data:'diagramResourceName',width:'20%'},
            {title:'流程版本',data:'version',width:'20%'},
            {title:'更新时间',data:'deploymentTime',width:'20%'}
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.dataDicName = $scope.dataDicName;
        params.dataDicCode = $scope.dataDicCode;
        params.dataDicParentId = common_constant_data_dic_value.common_parent_id;

        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchActReProcdef = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetActReProcdef = function(){
        $scope.description="";
        $scope.dataTable.fnDraw(true);//框架内部方法
    }


    $scope.saveActReProcdef = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/activiti/act_re_procdef/act_re_procdef_save.html'+getCacheTime(),
            controller: 'act_re_procdef_save_controller',
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

    $scope.modifyActReProcdef = function(sysResourceId){
        var rowsIds =  $scope.dataTable.getRowsIds('id');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/system/act_re_procdef/act_re_procdef_modify.html'+getCacheTime(),
                controller: 'act_re_procdef_modify_controller',
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


    $scope.deleteActReProcdef = function(){
        var rowsIds =  $scope.dataTable.getRowsIds();
        if(rowsIds.length < 1){
            alert('请选择要删除的数据');
        }else{
            modalConfirm($modal,function(){
                $http.delete('act_re_procdef/deleteActReProcdefByIds',getDeleteData(rowsIds)).success(function (data) {
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


}])
;