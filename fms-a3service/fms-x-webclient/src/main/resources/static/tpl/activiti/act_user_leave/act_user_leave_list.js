/**
 * Created by qiaomengnan on 2018-03-14.
 */
app.controller('act_user_leave_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'act_user_leave/findActUserLeavesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'act_user_leave_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('leaveId'),
            defaultDetail('leaveTitle','detailActUserLeave','请假标题','20%',$compile,$scope,"leaveId"),
            {title:'请假天数',data:'leaveDay',width:'20%'},
            {title:'请假原因',data:'leaveRemark',width:'20%'},
            {title:'状态',data:'leaveStatus',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.leaveTitle = $scope.leaveTitle;
        params.leaveDay = $scope.leaveDay;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchActUserLeave = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetActUserLeave = function(){
        $scope.leaveTitle = "";
        $scope.leaveDay = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveActUserLeave = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/activiti/act_user_leave/act_user_leave_save.html'+getCacheTime(),
            controller: 'act_user_leave_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('申请请假已提交',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifyActUserLeave = function(leaveId){
        var rowsIds =  $scope.dataTable.getRowsIds('leaveId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/activiti/act_user_leave/act_user_leave_modify.html'+getCacheTime(),
                controller: 'act_user_leave_modify_controller',
                resolve:{
                    leaveId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑activiti信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    $scope.detailActUserLeave = function(leaveId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/activiti/act_user_leave/act_user_leave_detail.html'+getCacheTime(),
            controller: 'act_user_leave_detail_controller',
            resolve:{
                actUserLeave : function (){ return $scope.dataTable.getRow(leaveId,'leaveId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteActUserLeave = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('leaveId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('act_user_leave/deleteActUserLeavesByLeaveIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除activiti信息成功', toaster);
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