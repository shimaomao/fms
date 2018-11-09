/**
 * Created by license_idx on 2018-09-26.
 */
app.controller('business_statistics_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {
    $scope.dateParams = JSON.stringify({dateFmt:'yyyy'});
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'report_statistics/findBusinessStatisticsVoByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'business_statistics_table',
        //table的列
        dataTableColumn: [
            {title:'合同生效月份',data:'contractSerachDate',width:'20%'},
            {title:'月度合计',data:'monthlyNumber',width:'20%'},
            {title:'累计台数',data:'cumulativeNumber',width:'20%'},
            {title:'总融资额',data:'finTotal',width:'20%'},
            {title:'累计融资额',data:'accumulatedTotal',width:'20%'},
            {title:'单台融资额',data:'averagefinTotal',width:'20%'},
            {title:'IRR',data:'averageIrr',width:'20%'},
            {title:'经销商台数',data:'distributorsVehicle',width:'20%'},
            {title:'经销商融资额',data:'distributorsFintotal',width:'20%'},
            {title:'企业客户台数',data:'enterpriseVehicle',width:'20%'},
            {title:'企业融资额',data:'enterpriseFintotal',width:'20%'},
            {title:'零售客户合计',data:'personalVehicle',width:'20%'},
            {title:'零售客户融资额',data:'personalFintotal',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio,
        paging: false
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.yearInquiries = $scope.yearInquiries;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchBusinessStatistics = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetBusinessStatistics = function(){
        $scope.yearInquiries = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    //融资租赁业务统计报表数据excel导出
    $scope.reportBusinessStatisticsExport = function () {
        var yearInquiries = $scope.yearInquiries;
        var hrefUrl = 'report_statistics/reportBusinessStatisticsExport?yearInquiries='+yearInquiries;
        window.parent.open(hrefUrl);
    }

}])
;