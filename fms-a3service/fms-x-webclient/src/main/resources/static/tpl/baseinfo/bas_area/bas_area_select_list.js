/**
 * Created by niehaibing on 2018-03-15.
 */
app.controller('bas_area_select_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$modalInstance','basArea', function ($scope, $http, $modal, toaster,$compile,$modalInstance,basArea) {

    $scope.basArea = basArea;
    $scope.dataTableProperties= {

        dataTableAjax : {
            url : 'bas_area/findBasAreasByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_area_select_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('areaId'),
            defaultDetail('areaCode','detailBasArea','省市县代码','20%',$compile,$scope,'areaId'),
            {title:'省市县名称',data:'areaName',width:'20%'},
            // {title:'省市县代码',data:'areaCode',width:'20%'},
           /* {title:'省市县级别',data:'areaLevel',width:'20%'},*/
           /* {title:'上级省市县名称',data:'parentAreaName',width:'20%'},*/
           /* {title:'上级省市县代码',data:'parentAreaCode',width:'20%'},*/
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.areaCode = $scope.areaCode;
        params.areaName = $scope.areaName;
        return params;
    }

    //创建dataTable
   // $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    // 初始化
    $scope.init = function(){
        //创建dataTable 封装了datatable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };
    $scope.searchBasArea = function(){
        console.log("11111111")
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetBasArea = function(){
        $scope.areaCode = "";
        $scope.areaName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    // 确认
    $scope.confirm = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('areaId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择上级代码！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时选中一条数据！');
        else{
            var data = $scope.dataTable.getRow(rowsIds[0],'areaId');
            if(data == null) {
                modalAlert($modal,'请选择选择上级代码');
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


    /**
     * 点击首列选中并关闭当前弹出框
     * @param areaId
     */
    $scope.detailBasArea = function (areaId) {
        var data = $scope.dataTable.getRow(areaId, 'areaId');
        $modalInstance.close(data);
    }

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.baseinfo,CommonServiceType.excelTypes.two,
            'bas_area/findBasAreasByPage',dataTableParams($scope));
    }

}])
;