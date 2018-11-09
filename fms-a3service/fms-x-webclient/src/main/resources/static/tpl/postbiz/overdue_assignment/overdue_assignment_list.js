/**
 * Created by lijunjun on 2018-05-16.
 */
app.controller('overdue_assignment_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'overdue_assignment/findOverdueAssignmentByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'overdue_assignment_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('overdueAssignmentId'),
            defaultDetail('overdueCstmId','detailOverdueAssignment','逾期客户ID','20%',$compile,$scope),
            {title:'分配日期',data:'assignDate',width:'20%'},
            {title:'催收类型',data:'assignmentType',width:'20%'},
            {title:'分配人员账号',data:'assignUser',width:'20%'},
            {title:'是否新进数',data:'fistOverdueFlag',width:'20%'},
            {title:'任务处理状态',data:'assignmentSts',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.overdueCstmId = $scope.overdueCstmId;
        params.assignDate = $scope.assignDate;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchOverdueAssignment = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetOverdueAssignment = function(){
        $scope.overdueCstmId = "";
        $scope.assignDate = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveOverdueAssignment = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/overdue_assignment/overdue_assignment_save.html'+getCacheTime(),
            controller: 'overdue_assignment_save_controller',
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

    $scope.modifyOverdueAssignment = function(overdueAssignmentId){
        var rowsIds =  $scope.dataTable.getRowsIds('overdueAssignmentId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/postbiz/overdue_assignment/overdue_assignment_modify.html'+getCacheTime(),
                controller: 'overdue_assignment_modify_controller',
                resolve:{
                    overdueAssignmentId : function (){ return rowsIds[0] }
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


    $scope.detailOverdueAssignment = function(overdueAssignmentId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/overdue_assignment/overdue_assignment_detail.html'+getCacheTime(),
            controller: 'overdue_assignment_detail_controller',
            resolve:{
                overdueAssignment : function (){ return $scope.dataTable.getRow(overdueAssignmentId,'overdueAssignmentId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteOverdueAssignment = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('overdueAssignmentId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('overdue_assignment/deleteOverdueAssignmentByOverdueAssignmentIds',getDeleteData(rowsIds)).success(function (data) {
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