/**
 * Created by license_idx on 2018-09-26.
 */
app.controller('report_statistics_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {
    $scope.dateParams = JSON.stringify({dateFmt:'yyyy-MM'});
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'report_statistics/findReportStatisticsVoByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'report_statistics_table',
        //table的列
        dataTableColumn: [
            {title:'用户所属区域',data:'groupDistrict',width:'20%'},
            {title:'合同生效月份',data:'contractSerachDate',width:'20%'},
            {title:'经销商试乘试驾车/救援车',data:'drivingVehicle',width:'20%'},
            {title:'经销商代步车',data:'stepCar',width:'20%'},
            {title:'经销商员工购车',data:'employeesCar',width:'20%'},
            {title:'零售客户标准企业',data:'customerEnterprise',width:'20%'},
            {title:'零售客户标准个人',data:'customerPerson',width:'20%'},
            {title:'零售客户回租',data:'customerLeaseback',width:'20%'},
            {title:'零售客户二手车',data:'customersHandCar',width:'20%'},
            {title:'零售客户摩托车',data:'customerMotorcycle',width:'20%'},
            {title:'经销商合计',data:'distributorTotal',width:'20%'},
            {title:'零售客户合计',data:'totalRetailCustomers',width:'20%'},
            {title:'本月合计',data:'monthSum',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.groupDistrict = $scope.groupDistrict;
        params.contractSerachDate = $scope.contractSerachDate;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchReportStatistics = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetReportStatistics = function(){
        $scope.groupDistrict = "";
        $scope.contractSerachDate = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    //当月提报数据统计导出
    $scope.reportStatisticsExport = function () {
        var groupDistrict = $scope.groupDistrict;
        var contractSerachDate = $scope.contractSerachDate;
        var hrefUrl = 'report_statistics/reportstatisticsExport?groupDistrict='+groupDistrict+'&contractSerachDate='+contractSerachDate;
        window.parent.open(hrefUrl);
    }

}])
;