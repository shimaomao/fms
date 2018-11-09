/**
 * Created by niehaibing on 2018-03-15.
 */
app.controller('bas_area_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {
    //查询参数
    $scope.params = setData.getter();
    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加省市县信息成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑省市县信息成功',toaster);
        }
    }, 100);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'bas_area/findBasAreasByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_area_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('areaId'),
            defaultDetail('areaCode','detailBasArea','省市县代码','20%',$compile,$scope,'areaId'),
            {title:'省市县名称',data:'areaName',width:'20%'},
            {title:'省市县级别',data:'areaLevel',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.areaLevel,data);
                }
            },
            {title:'上级省市县名称',data:'parentAreaName',width:'20%'},
            {title:'上级省市县代码',data:'parentAreaCode',width:'20%'},
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchBasArea = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetBasArea = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

    $scope.saveBasArea = function(){
        $location.path('app/baseinfo_bas_area_save');
    }

// 修改
    $scope.modifyBasArea  = function(areaId){
        var rowsIds =  $scope.dataTable.getRowsIds('areaId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/baseinfo_bas_area_modify').search({'areaId': rowsIds[0]});
        }
    };

    $scope.detailBasArea = function(areaId){
        $location.path('/app/baseinfo_bas_area_detail').search({'areaId': areaId});

    }

    $scope.deleteBasArea = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('areaId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('bas_area/deleteBasAreasByAreaIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除省市县信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

    // 导出功能
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.baseinfo, CommonServiceType.excelTypes.one,
            'bas_area/findBasAreasByPage',dataTableParams($scope));
    }

    $scope.flushBasAreaCache = function(){
        $http.get('bas_area/initBasAreas').success(function (data) {
            if(data.code == Response.successCode) {
                toaster_success('省市缓存刷新成功', toaster);
                //前端数据字典重新赋值
                AreaUtils.setCommonAreaValues(data.data);
            }
            else
                modalAlert($modal,data.message);
        })
    }

}])
;