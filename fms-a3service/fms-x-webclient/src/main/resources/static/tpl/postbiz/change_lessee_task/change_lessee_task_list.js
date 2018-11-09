/**
 * Created by ningyangyang on 2018-09-10.
 */
app.controller('change_lessee_task_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'change_lessee_task/findChangeLesseeTasksByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'change_lessee_task_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('taskId'),
            defaultDetail('taskNo','detailChangeLesseeTask','变更任务号','20%',$compile,$scope),
            {title:'变更任务状态',data:'taskStatus',width:'20%'},
            {title:'合同号',data:'contNo',width:'20%'},
            {title:'当前节点用户',data:'presentUser',width:'20%'},
            {title:'任务提出人',data:'submitUser',width:'20%'},
            {title:'任务提出时间',data:'submitDate',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.taskNo = $scope.taskNo;
        params.taskStatus = $scope.taskStatus;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchChangeLesseeTask = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetChangeLesseeTask = function(){
        $scope.taskNo = "";
        $scope.taskStatus = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveChangeLesseeTask = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/change_lessee_task/change_lessee_task_save.html'+getCacheTime(),
            controller: 'change_lessee_task_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加postbiz信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifyChangeLesseeTask = function(taskId){
        var rowsIds =  $scope.dataTable.getRowsIds('taskId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/postbiz/change_lessee_task/change_lessee_task_modify.html'+getCacheTime(),
                controller: 'change_lessee_task_modify_controller',
                resolve:{
                    taskId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑postbiz信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    $scope.detailChangeLesseeTask = function(taskId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/change_lessee_task/change_lessee_task_detail.html'+getCacheTime(),
            controller: 'change_lessee_task_detail_controller',
            resolve:{
                changeLesseeTask : function (){ return $scope.dataTable.getRow(taskId,'taskId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteChangeLesseeTask = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('taskId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('change_lessee_task/deleteChangeLesseeTasksByTaskIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除postbiz信息成功', toaster);
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