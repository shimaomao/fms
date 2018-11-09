/**
 * Created by wubaoliang on 2018-03-12.
 */
app.controller('sys_tpl_type_contract_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location', '$timeout', function ($scope, $http, $modal, toaster,$compile, $location, $timeout) {

    $scope.tplType = '2';// 模板种类：合同

    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加文件模板类型信息成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑文件模板类型信息成功',toaster);
        }
    }, 100);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_tpl_type/findSysTplTypesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_tpl_type_contract_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('tplTypeId'),
            defaultDetail('tplTypeKey','detailSysTplTypeContract','文件模板代码','20%',$compile,$scope, 'tplTypeId'),
            {title:'文件模板名称',data:'tplTypeName',width:'20%'},
            // {title:'模板种类',data:'tplType',width:'20%'},
            {title:'文件名',data:'tplFileName',width:'20%'},
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'updater',width:'20%'},
            // {title:'默认模板内容',data:'tplContent',width:'20%'},
            // {title:'可设置项目',data:'tplItemName',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    };

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.tplTypeKey = $scope.tplTypeKey;
        params.tplTypeName = $scope.tplTypeName;
        params.tplType = $scope.tplType;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);

    // 查询
    $scope.searchSysTplTypeContract = function(){
        $scope.dataTable.fnDraw(true);
    };
    // 重置
    $scope.resetSysTplTypeContract = function(){
        $scope.tplTypeKey = "";
        $scope.tplTypeName = "";
        $scope.dataTable.fnDraw(true);//刷新
    };

    // 添加
    $scope.saveSysTplTypeContract = function(){
        $location.path('/app/system_sys_tpl_type_contract_save');
    };

    // 修改
    $scope.modifySysTplTypeContract = function(tplTypeId){
        var rowsIds =  $scope.dataTable.getRowsIds('tplTypeId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/system_sys_tpl_type_contract_modify').search({'tplTypeId': rowsIds[0]});
        }
    };

    // 查看详情
    $scope.detailSysTplTypeContract = function(tplTypeId){
        $location.path('/app/system_sys_tpl_type_contract_detail').search({'tplTypeId': tplTypeId});
    };

    // 删除
    $scope.deleteSysTplTypeContract = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('tplTypeId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('sys_tpl_type/deleteSysTplTypesByTplTypeIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除文件模板类型信息成功', toaster);
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
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.system,CommonServiceType.excelTypes.two,
            'sys_tpl_type/findSysTplTypesByPage',dataTableParams($scope));
    };

}])
;