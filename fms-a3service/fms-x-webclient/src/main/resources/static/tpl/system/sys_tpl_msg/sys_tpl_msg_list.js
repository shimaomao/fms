/**
 * Created by wubaoliang on 2018-03-12.
 */
app.controller('sys_tpl_msg_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {

    $scope.tplType = '1';  // 模板类型：短信

    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加短信模板信息成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑短信模板信息成功',toaster);
        }
    }, 100);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_tpl/findSysTplVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_tpl_msg_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('tplId'),
            defaultDetail('tplName','detailSysTplMsg','模板名称','20%',$compile,$scope, 'tplId'),
            {title:'短信模板类型代码',data:'tplTypeKey',width:'20%'},
            {title:'短信模板类型名称',data:'tplTypeName',width:'20%'},
            {title:'启用标志',data:'enableFlag',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,data);
                }
            },
            {title:'模板内容',data:'tplContent',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.tplName = $scope.tplName;
        params.tplTypeName = $scope.tplTypeName;
        params.tplType = $scope.tplType;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchSysTplMsg = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetSysTplMsg = function(){
        $scope.tplName = "";
        $scope.tplTypeName = "";
        $scope.dataTable.fnDraw(true);//刷新
    };


    $scope.saveSysTplMsg = function(){
        $location.path('/app/system_sys_tpl_msg_save');
    };

    $scope.modifySysTplMsg = function(tplId){
        var rowsIds =  $scope.dataTable.getRowsIds('tplId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/system_sys_tpl_msg_modify').search({'tplId': rowsIds[0]});
        }
    };


    $scope.detailSysTplMsg = function(tplId){
        $location.path('/app/system_sys_tpl_msg_detail').search({'tplId': tplId});
    };

    $scope.deleteSysTplMsg = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('tplId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('sys_tpl/deleteSysTplsByTplIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除短信模板信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')
        }
    }

    // 导出excel
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.system,CommonServiceType.excelTypes.one,
            'sys_tpl/findSysTplVosByPage',dataTableParams($scope));
    };

}])
;