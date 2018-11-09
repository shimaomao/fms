/**
 * Created by wangxue on 2018-03-09.
 */
app.controller('sys_widget_attribute_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$modalInstance','sysWidget', function ($scope, $http, $modal, toaster,$compile,$modalInstance,sysWidget) {

    $scope.sysWidget = sysWidget;

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_widget_attribute/findSysWidgetAttributeVoByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_widget_attribute_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('widgetConId'),
            defaultDetail('eleWidgetId','detailSysWidgetAttribute','项目ID','20%',$compile,$scope, 'widgetConId'),
            {title:'项目名称',data:'eleWidgetName',width:'20%'},
            {title:'项目是否显示',data:'showMod',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.sys_widget_mod,data);
                }
            },
            {title:'项目是否编辑',data:'writeMod',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.sys_widget_mod,data);
                }
            },
            {title:'项目是否必须',data:'checkMod',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.sys_widget_mod,data);
                }
            },
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    };

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.frmWidgetId = $scope.sysWidget.widgetId;
        params.eleWidgetId = $scope.eleWidgetId;
        params.eleWidgetName = $scope.eleWidgetName;
        return params;
    }

    $scope.init = function(){
        //创建dataTable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };


    $scope.searchSysWidgetAttribute = function(){
        $scope.dataTable.fnDraw(true);
    };

    $scope.resetSysWidgetAttribute = function(){
        $scope.eleWidgetId = "";
        $scope.eleWidgetName = "";
        $scope.dataTable.fnDraw(true);//刷新
    };


    // 新增项目权限
    $scope.saveSysWidgetAttribute = function(){
        var sysWidgetAttribute = {};
        sysWidgetAttribute.frameWidgetId = common_frame_widget_id.F000001;
        sysWidgetAttribute.frmWidgetId = $scope.sysWidget.widgetId;
        sysWidgetAttribute.frmWidgetName = $scope.sysWidget.widgetName;
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_widget_attribute/sys_widget_attribute_handler.html'+getCacheTime(),
            controller: 'sys_widget_attribute_handler_controller',
            resolve:{
                sysWidgetAttribute: function () {
                    return sysWidgetAttribute;
                }
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加项目权限信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    };

    // 更新项目权限
    $scope.modifySysWidgetAttribute = function(widgetConId){
        var rowsIds =  $scope.dataTable.getRowsIds('widgetConId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            var sysWidgetAttribute = $scope.dataTable.getRow(rowsIds[0],'widgetConId');
            sysWidgetAttribute.frameWidgetId = common_frame_widget_id.F000002;
            sysWidgetAttribute.frmWidgetName = $scope.sysWidget.widgetName;
            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/system/sys_widget_attribute/sys_widget_attribute_handler.html'+getCacheTime(),
                controller: 'sys_widget_attribute_handler_controller',
                resolve:{
                    sysWidgetAttribute : function (){ return sysWidgetAttribute }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑项目权限信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }
    };
    // 详情
    $scope.detailSysWidgetAttribute = function(widgetConId){
        var sysWidgetAttribute =  $scope.dataTable.getRow(widgetConId,'widgetConId');
        sysWidgetAttribute.frameWidgetId = common_frame_widget_id.F000003;
        sysWidgetAttribute.frmWidgetName = $scope.sysWidget.widgetName;
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_widget_attribute/sys_widget_attribute_handler.html'+getCacheTime(),
            controller: 'sys_widget_attribute_handler_controller',
            resolve:{
                sysWidgetAttribute : function (){ return sysWidgetAttribute;}
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    };

    // 删除项目权限
    $scope.deleteSysWidgetAttribute = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('widgetConId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('sys_widget_attribute/deleteSysWidgetAttributeByWidgetConIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除项目权限信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}])
;