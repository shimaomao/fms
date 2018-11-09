/**
 * Created by ningyangyang on 2018-03-07.
 */
app.controller('sys_menu_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location','$timeout','setData',function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {
    //查询参数
    $scope.params = setData.getter();

    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加菜单信息成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑菜单信息成功',toaster);
        }
    }, 100);

    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.common_status)
        //consValueArr(common_constant_code.common_status);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_menu/findSysMenuVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_menu_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox("menuId"),

            defaultDetail('menuName','detailSysMenu','菜单名称','20%',$compile,$scope,"menuId","parMenuName"),
            // {title:'菜单名称',data:'menuName',width:'20%'},
            {title:'启用标识',data:'enableFlag',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,data)
                    //consValue(common_constant_code.common_status,data);
                }
            },
             {title:'上级菜单',data:'parMenuName',width:'20%',
                 render: function (data, type, row, meta) {
                     if(data == null)
                         return '无上级菜单'
                     return data;
                     //return consValue(common_constant_code.common_status,data);
                 }
             },
             {title:'菜单级别',data:'menuLevel',width:'20%',
                 render:function(data, type, row, meta){
                     return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.menuLevel,data);
                 }
             },
             {title:'菜单链接',data:'menuLink',width:'20%'},
             {title:'排序',data:'orderNo',width:'20%'},
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox,
    }
  //$scope.list = msgList;
    //请求的参数
    function dataTableParams($scope){
        /*var params = {};
        params.menuName = $scope.menuName;
        params.menuLevel = $scope.menuLevel;*/
        var params = $scope.params;
        setData.setter(params);
        return params;
    }
    $scope.menuLevels = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.menuLevel);

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchSysMenu = function(){

        $scope.dataTable.fnDraw(true);
    }

    $scope.resetSysMenu = function(){
       /*$scope.menuName = "";
        $scope.menuLevel = "";*/
        $scope.params = {};

        $scope.dataTable.fnDraw(true);//刷新
    }


    //新增
    $scope.saveSysMenu = function(){

        $location.path('/app/system_sys_menu_save');

    }

    $scope.modifySysMenu = function(menuId){
        var rowsIds =  $scope.dataTable.getRowsIds('menuId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            $location.path('/app/system_sys_menu_modify').search({'menuId': rowsIds[0]});

        }

    }

    //菜单详情
    $scope.detailSysMenu = function(menuId){

        var sysMenu = $scope.dataTable.getRow(menuId,'menuId');
        //alert(sysMenu);
        $location.path('/app/system_sys_menu_detail').search({'SysMenu': sysMenu});
    }

    $scope.deleteSysMenu = function(){
        var rowsIds =  $scope.dataTable.getRowsIds("menuId");
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('sys_menu/deleteSysMenusByMenuIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除菜单信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.system,CommonServiceType.excelTypes.one,
            'sys_menu/findSysMenuVosByPage',dataTableParams($scope));
    }
}])
;