/**
 * Created by yangyiquan on 2018-09-10.
 */
app.controller('monthly_overdue_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','setData', function ($scope, $http, $modal, toaster,$compile,$location,setData) {

    //查询参数
    $scope.params = setData.getter();
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'monthly_overdue/findMonthlyOverduesVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'monthly_overdue_table',
        //table的列
        dataTableColumn: [
            {title:'报表月份',data:'censusMonth',width:'8%'},
            {title:'零售逾期（元）',data:'retailOverdue',width:'8%'},
            {title:'经销商逾期（元）',data:'parOverdue',width:'8%'},
            {title:'总逾期（元）',data:'totalOverdue',width:'8%'},
            {title:'零售总应收（元）',data:'retailAmount',width:'8%'},
            {title:'经销商总应收（元）',data:'parAmount',width:'8%'},
            {title:'总应收（元）',data:'totalAmount',width:'8%'},
            {title:'零售逾期率(%)',data:'retailOverdueRate',width:'8%'},
            {title:'经销商逾期率(%)',data:'parOverdueRate',width:'8%'},
            {title:'总逾期率(%)',data:'totalOverdueRate',width:'8%'},
            {title:'逾期1-7占比(%)',data:'overdue1',width:'8%'},
            {title:'逾期8-15占比(%)',data:'overdue2',width:'8%'},
            {title:'逾期16-30占比(%)',data:'overdue3',width:'8%'},
            {title:'逾期31-60占比(%)',data:'overdue4',width:'8%'},
            {title:'逾期61-90占比(%)',data:'overdue5',width:'8%'},
            {title:'逾期90+占比(%)',data:'overdue6',width:'8%'},
        ],

    }

    //日期参数
    $scope.maxDate = {maxDate:'#F{$dp.$D(\'endMonthlyOverdueDate\')}',dateFmt:'yyyy-MM'};
    $scope.minDate = {minDate:'#F{$dp.$D(\'beginMonthlyOverdueDate\')}',validStartDate:'#F{$dp.$D(\'beginMonthlyOverdueDate\',{d:+1})}',dateFmt:'yyyy-MM'};

    //请求的参数
    function dataTableParams($scope){
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchMonthlyOverdue = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetMonthlyOverdue = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

    //有模板excel导出测试
    $scope.excelExport = function () {
        var params = $scope.params;

        var hrefUrl = 'monthly_overdue/excelExport?beginMonthlyOverdueDate=';
        if(CommonObjectUtils.isExist(params.beginMonthlyOverdueDate)){
            hrefUrl = hrefUrl + params.beginMonthlyOverdueDate;
        }
        if(CommonObjectUtils.isExist(params.endMonthlyOverdueDate)){
            hrefUrl = hrefUrl + '&endMonthlyOverdueDate=' + params.endMonthlyOverdueDate;
        }
        window.parent.open(hrefUrl);

    }



}])
;