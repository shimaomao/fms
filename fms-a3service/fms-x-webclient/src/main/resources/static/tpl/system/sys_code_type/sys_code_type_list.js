/**
 * Created by huchenghao on 2018-03-08.
 */
app.controller('sys_code_type_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {
    //查询参数
    $scope.params = setData.getter();
    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加数据字典类型信息成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑数据字典类型信息成功',toaster);
        }
    }, 100);

    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.common_status);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_code_type/findSysCodeTypesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_code_type_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('codeType'),
            defaultDetail('codeType','detailSysCodeType','数据字典类型代码','20%',$compile,$scope,'codeType'),
            {title:'数据字典类型名称',data:'codeTypeName',width:'20%'},
            {title:'启用标志',data:'enableFlag',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,data);
                }
            },
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


    $scope.searchSysCodeType = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetSysCodeType = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveSysCodeType = function(){
        $location.path('/app/system_code_type_handler').search({'frameTitle':'添加数据字典类型','operate':'save'});
    }

    $scope.modifySysCodeType = function(syscodeType){
        var rowsIds =  $scope.dataTable.getRowsIds('codeType');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/system_code_type_handler').search({'frameTitle':'修改数据字典类型','operate':'update', 'codeType': rowsIds[0]});
        }

    }


    $scope.detailSysCodeType = function(syscodeType){
        $location.path('/app/system_code_type_handler').search({'frameTitle':'数据字典类型详情','operate':'detail', 'codeType': syscodeType});
    }


    $scope.deleteSysCodeType = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('codeType');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{
            modalConfirm($modal,function(){
                $http.delete('sys_code_type/deleteSysCodeTypeByIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除数据字典类型信息成功', toaster);
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

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.system,CommonServiceType.excelTypes.one,
            'sys_code_type/findSysCodeTypesByPage',dataTableParams($scope));
    }

}])
;