/**
 * Created by niehaibing on 2018-03-21.product_catg_list_select_controller
 */
app.controller('product_catg_list_select_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {
    // 启用标识
    $scope.enableFlagList = consValueArr(common_constant_code.common_status);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'product_catg/findProductCatgsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'product_catg_select_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('productCatgId'),
         /*   defaultDetail('productCatg','detailProductCatg','产品大类代码','20%',$compile,$scope,'productCatgId'),*/
            {title:'产品大类代码',data:'productCatg',width:'20%'},
            {title:'产品大类名称',data:'productCatgName',width:'20%'},
         /*   {title:'产品大类描述',data:'productCatgMemo',width:'20%'},
            {title:'车辆类型',data:'vehicleForm',width:'20%'},
            {title:'申请类型',data:'applyType',width:'20%'},
            {title:'车辆种类',data:'vehicleType',width:'20%'},
            {title:'启用标志',data:'enableFlag',width:'20%'},*/
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.productCatg = $scope.productCatg;
        params.productCatgName = $scope.productCatgName;
        return params;
    }

    $scope.init = function(){
        //创建dataTable 封装了datatable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };

    $scope.searchProductCatg = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetProductCatg = function(){
        $scope.productCatg = "";
        $scope.productCatgName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }
// 确认
    $scope.confirm = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('productCatgId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择上级代码！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时选中一条数据！');
        else{
            var data = $scope.dataTable.getRow(rowsIds[0],'productCatgId');
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

}])
;