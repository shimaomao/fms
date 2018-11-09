/**
 * Created by wangxue on 2018/3/15.
 */

app.controller('sys_tpl_type_select_controller', ['$scope', '$http', '$modal','$modalInstance','tplType', function ($scope, $http, $modal, $modalInstance, tplType) {

    $scope.tplType = tplType;

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_tpl_type/findSysTplTypesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_tpl_type_select_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('tplTypeId'),
            {title:'模板类型代码',data:'tplTypeKey',width:'20%'},
            {title:'模板类型名称',data:'tplTypeName',width:'20%'},
            {title:'模板种类',data:'tplType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.tplType,data);
                }
            },
            {title:'默认模板内容',data:'tplContent',width:'20%'}
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

    // 初始化
    $scope.init = function(){
        //创建dataTable 封装了datatable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };

    // 查询
    $scope.searchSysTplType = function(){
        $scope.dataTable.fnDraw(true);
    };
    // 重置
    $scope.resetSysTplType = function(){
        $scope.tplTypeKey = "";
        $scope.tplTypeName = "";
        $scope.dataTable.fnDraw(true);//刷新
    };

    // 确认
    $scope.confirm = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('tplTypeId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择模板类型！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时选中一条数据！');
        else{
            var data = $scope.dataTable.getRow(rowsIds[0],'tplTypeId');
            if(data == null) {
                modalAlert($modal,'请选择模板类型');
            } else {
                $modalInstance.close(data);
            }
        }
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close(null);
    };

    // 导出excel
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.system,CommonServiceType.excelTypes.three,
            'sys_tpl_type/findSysTplTypesByPage',dataTableParams($scope));
    };

}]);
