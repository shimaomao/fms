/**
 * Created by huchenghao on 2018-03-09.
 */
app.controller('sys_code_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {
    //查询参数
    $scope.params = setData.getter();
    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加数据字典数值信息成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑数据字典数值信息成功',toaster);
        }
    }, 100);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_code/findSysCodesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_code_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('codeValueId'),
            defaultDetail('codeType','detailSysCode','数据字典类型代码','20%',$compile,$scope,'codeValueId'),
            {title:'数据字典类型名称',data:'codeTypeName',width:'20%'},
            {title:'数据字典代码',data:'codeValue',width:'20%'},
            {title:'数据字典名称',data:'codeValueName',width:'20%'},
            {title:'启用标志',data:'enableFlag',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,data);
                }
            },
            {title:'排序',data:'orderNo',width:'20%'},
            {title:'更新时间',data:'updateTime',width:'20%',
                render: function (data, type, row, meta) {
                    return new Date(data).Format("yyyy-MM-dd HH:mm:ss");
                }
            },
            {title:'更新人员',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchSysCode = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetSysCode = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveSysCode = function(){
        $location.path('/app/system_code_handler').search({'frameTitle':'添加数据字典数值','operate':'save'});
    }

    $scope.modifySysCode = function(codeValueId){
        var rowsIds =  $scope.dataTable.getRowsIds('codeValueId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/system_code_handler').search({'frameTitle':'修改数据字典数值','operate':'update', 'codeValueId': rowsIds[0]});
        }
    }


    $scope.detailSysCode = function(codeValueId){
        $location.path('/app/system_code_handler').search({'frameTitle':'数据字典数值详情','operate':'detail', 'codeValueId': codeValueId});
    }

    $scope.deleteSysCode = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('codeValueId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('sys_code/deleteSysCodeByCodeValueIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除数据字典数值成功', toaster);
                        //前端数据字典重新赋值
                        CommonCodeUtils.setCommonCodeValues(data.data);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

    $scope.flushSysCodeCache = function(){
        $http.get('sys_code/initCommonCodeValue').success(function (data) {
            if(data.code == Response.successCode) {
                toaster_success('数据字典数值缓存刷新成功', toaster);
                //前端数据字典重新赋值
                CommonCodeUtils.setCommonCodeValues(data.data);
            }
            else
                modalAlert($modal,data.message);
        })
    }

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.system,CommonServiceType.excelTypes.one,
            'sys_code/findSysCodesByPage',dataTableParams($scope));
    }

}])
;