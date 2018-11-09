/**
 * Created by license_idx on 2018-09-26.
 */
app.controller('monthly_rent_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','setData', function ($scope, $http, $modal, toaster,$compile,$location,setData) {
    $scope.dateParams = JSON.stringify({dateFmt:'yyyy-MM'});

    //查询参数
    $scope.params = setData.getter();

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'monthly_rent/findMonthlyRentsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'monthly_rent_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('monthlyRentId'),
            {title:'月份',data:'censusMonth',width:'20%'},
            {title:'本月应收金额(元)',data:'monthRent',width:'20%'},
            {title:'本月应收客户数',data:'monthCount',width:'20%'},
            {title:'本月实收金额(元)',data:'receiptAmount',width:'20%'},
            {title:'本月实收客户数',data:'receiptCount',width:'20%'},
            {title:'累计逾期金额(元)',data:'overdueRent',width:'20%'},
            {title:'累计逾期客户数',data:'overdueCount',width:'20%'},
            {title:'累计逾期实收金额(元)',data:'overdueReceipt',width:'20%'},
            {title:'累计逾期实收客户数',data:'overdueReCount',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }
    //请求的参数
    function dataTableParams($scope){
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchReportStatistics = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetReportStatistics = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

    //有模板excel导出测试
    $scope.excelExport = function () {
        var rowsIds =  $scope.dataTable.getRowsIds('monthlyRentId');//主键
        if(rowsIds.length < 1){
            modalAlert($modal,'请您选择需要导出的数据！');
        } else{
            var hrefUrl = 'monthly_rent/excelExport?monthlyRentId='+ rowsIds;
            window.parent.open(hrefUrl);
        }
    }

}])
;