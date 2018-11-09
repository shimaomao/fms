/**
 * Created by yanfengbo on 2018-05-22.
 */
app.controller('car_collect_comp_list_select_controller', ['$scope', '$http', '$modal','$compile','$modalInstance', function ($scope, $http, $modal,$compile,$modalInstance) {


    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'car_collect_comp/findCarCollectCompsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'car_collect_comp_select_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('carCollectCompId'),
            defaultDetail('carCollectCompCode','detailCarCollectComp','收车机构代码','20%',$compile,$scope,'carCollectCompId'),
            {title:'收车机构名称',data:'carCollectCompName',width:'20%'},
            {title:'联系电话',data:'contactTel',width:'20%'},
            {title:'联系地址',data:'address',width:'20%'},
            {title:'邮箱',data:'mailAddress',width:'20%'},
            {title:'所在省份',data:'addrProv',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'所在城市',data:'addrCity',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.carCollectCompCode = $scope.carCollectCompCode;
        params.carCollectCompName = $scope.carCollectCompName;
        return params;
    }

    // 初始化
    $scope.init = function(){
        //创建dataTable 封装了datatable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };


    $scope.searchCarCollectComp = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetCarCollectComp = function(){
        $scope.carCollectCompCode = "";
        $scope.carCollectCompName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }
    
    // 确认
    $scope.confirm = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('carCollectCompId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择收车机构信息！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时选中一条数据！');
        else{
            var data = $scope.dataTable.getRow(rowsIds[0],'carCollectCompId');
            $modalInstance.close(data);
        }
    };


    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close(null);
    };
}])
;