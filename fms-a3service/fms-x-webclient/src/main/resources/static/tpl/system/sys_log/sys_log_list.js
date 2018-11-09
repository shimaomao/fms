/**
 * Created by yanfengbo on 2018-04-10.
 */
app.controller('sys_log_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_log/findSysLogsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_log_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('logId'),
            defaultDetail('actWidgetId','detailSysLog','操作识别ID','20%',$compile,$scope,'logId'),
            {title:'操作人员',data:'user',width:'20%'},
            {title:'操作开始时间',data:'startTime',width:'20%'},
            {title:'操作结束时间',data:'endTime',width:'20%'},
            {title:'参数信息',data:'actParamInfo',width:'20%'},
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'creator',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.actWidgetId = $scope.actWidgetId;
        params.user = $scope.user;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchSysLog = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetSysLog = function(){
        $scope.actWidgetId = "";
        $scope.user = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveSysLog = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_log/sys_log_save.html'+getCacheTime(),
            controller: 'sys_log_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加system信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifySysLog = function(logId){
        var rowsIds =  $scope.dataTable.getRowsIds('logId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/system/sys_log/sys_log_modify.html'+getCacheTime(),
                controller: 'sys_log_modify_controller',
                resolve:{
                    logId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑system信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    //详情
    $scope.detailSysLog = function(logId){
       $location.path('/app/system_sys_log_detail').search({'frameTitle':'日志管理详情','operate':'check','logId':logId})
    }


    $scope.deleteSysLog = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('logId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('sys_log/deleteSysLogByLogIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除system信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }
    //导出excel
    $scope.exportExcel = function(){
        CommonServiceType.exportExcelMaxData(CommonServiceType.serviceTypes.system,CommonServiceType.excelTypes.one,
            'sys_log/findSysLogsByPage',dataTableParams($scope));
    }

}])
;