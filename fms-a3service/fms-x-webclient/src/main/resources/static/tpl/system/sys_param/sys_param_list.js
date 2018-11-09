/**
 * Created by yanfengbo on 2018-03-09.
 */
app.controller('sys_param_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {
    //添加，修改成功提示信息
    $scope.timer = $timeout(function () {
        $scope.messageType=$location.search()['messageType'];
        if($scope.messageType == 'saveSysParam'){
            toaster_success('添加系统常量成功',toaster);
        }else if($scope.messageType=='modifySysParam'){
            toaster_success('编辑系统常量成功',toaster);
        }

    }, 5);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_param/findSysParamByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_param_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('paramKeyId'),
            defaultDetail('paramKey','detailSysParam','参数主键','20%',$compile,$scope,'paramKeyId'),
            {title:'参数名称',data:'paramName',width:'20%'},
            {title:'参数值',data:'paramValue',width:'20%'},
            {title:'开始日期',data:'validStartDate',width:'20%'},
            {title:'结束日期',data:'validEndDate',width:'20%'},
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.paramKey = $scope.paramKey;
        params.paramName = $scope.paramName;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchSysParam = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetSysParam = function(){
        $scope.paramKey = "";
        $scope.paramName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    // 添加
    $scope.saveSysParam = function(){
        $location.path('app/system_sys_param_save').search({'frameTitle':'添加系统常量','operate':'save'});

    }

    // 修改
    $scope.modifySysParam = function(paramKeyId){
        var rowsIds =  $scope.dataTable.getRowsIds('paramKeyId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/system_sys_param_modify').search({'frameTitle':'修改系统常量','operate':'update','paramKeyId': rowsIds[0]});

        }

    }

    // 详情
    $scope.detailSysParam = function(paramKeyId){

        $location.path('/app/system_sys_param_detail').search({'frameTitle':'系统常量详情','operate':'check','paramKeyId': paramKeyId});

    }

    //删除
    $scope.deleteSysParam = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('paramKeyId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('sys_param/deleteSysParamByParamKeyIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        CommonCodeUtils.setCommonParamValues(data.data);
                        toaster_success('删除系统常量信息成功', toaster);
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
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.system,CommonServiceType.excelTypes.one,
            'sys_param/findSysParamByPage',dataTableParams($scope));
    }
}])
;