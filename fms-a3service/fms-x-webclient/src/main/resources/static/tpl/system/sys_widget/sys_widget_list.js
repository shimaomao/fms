/**
 * Created by wangxue on 2018-03-09.
 */
app.controller('sys_widget_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    // 取得画面控件的类型
    $scope.widgetType = '0';
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_widget/findSysWidgetsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_widget_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('widgetUuid'),
            defaultDetail('widgetId','detailSysWidget','识别ID','20%',$compile,$scope,'widgetUuid'),
            {title:'类型',data:'widgetType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.sys_widget_type,data);
                }
            },
            {title:'名称',data:'widgetName',width:'20%'},
            {title:'提示信息',data:'memo',width:'20%'}
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.widgetId = $scope.widgetId;
        params.widgetName = $scope.widgetName;
        params.widgetType = $scope.widgetType;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchSysWidget = function(){
        $scope.dataTable.fnDraw(true);
    };

    $scope.resetSysWidget = function(){
        $scope.widgetId = "";
        $scope.widgetName = "";
        $scope.dataTable.fnDraw(true);//刷新
    };

    // 画面项目管理
    $scope.itemManage = function () {
        var rowsIds =  $scope.dataTable.getRowsIds('widgetUuid');//主键
        if(rowsIds.length < 1) {
            modalAlert($modal, '请您选择需要管理的画面项目！');
        } else if(rowsIds.length > 1) {
            modalAlert($modal, '只能同时管理一个画面项目！');
        }else{
            var sysWidget = $scope.dataTable.getRow(rowsIds[0],'widgetUuid');
            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/system/sys_widget_attribute/sys_widget_attribute_list.html'+getCacheTime(),
                controller: 'sys_widget_attribute_list_controller',
                resolve:{
                    sysWidget : function (){ return sysWidget }
                }
            });
            rtn.result.then(function (status) {

            },function(){
            });
        }

    };

    // 查看详情
    $scope.detailSysWidget = function(widgetUuid){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_widget/sys_widget_detail.html'+getCacheTime(),
            controller: 'sys_widget_detail_controller',
            resolve:{
                sysWidget : function (){ return $scope.dataTable.getRow(widgetUuid,'widgetUuid') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    };

    // 刷新项目权限缓存
    $scope.flushSysWidgetAttributeCache = function(){
        $http.post('sys_widget_attribute/resetSysWidgetAttributeVoByTreeToRedis').success(function (data) {
            if (data.code == Response.successCode) {
                toaster_success('刷新项目权限缓存成功', toaster);
                common_widget_attribute_value = data.data;
            }else
                modalAlert($modal,data.message);
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    }

}])
;