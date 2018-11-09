/**
 * Created by yanfengbo on 2018-05-14.
 */
app.controller('overdue_exempt_detail_query_controller', ['$scope', '$http','$modal','toaster','$location','$compile',function ($scope, $http,$modal,toaster,$location,$compile) {

    $scope.contOverdueOneVo={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.serviceId = $location.search()['overdueExemptNo']

    $http.get('overdue_exempt/findDetailByServiceId?serviceId='+ $scope.serviceId).success(function(data){
        $scope.overdueExempt = data.data;
        $scope.contOverdueOneVo = $scope.overdueExempt.contOverdueOneVo;

        console.log(data);
        $scope.dataTableProperties= {
            //table的html id
            dataTableId:'overdueExemptQueryDetail_table',
            //table的列
            dataTableColumn: [
                // defaultCheckBox('contOverdueId'),
                {title:'合同编号',data:'contNo',width:'20%'},
                {title:'期数',data:'period',width:'20%'},
                {title:'逾期天数',data:'overdueDays',width:'20%'},
                {title:'还款日',data:'repayDate',width:'20%'},
                {title:'每期客户租金',data:'eachRent',width:'20%'},
                {title:'罚息金额',data:'overdueAmount',width:'20%'},
                {title:'罚息已收金额',data:'receiptAmount',width:'20%'},
                {title:'已免除罚息金额',data:'exemptAmount',width:'20%'},
                {title:'罚息剩余金额',data:'restOverdueAmount',width:'20%'},
                {title:'免除金额',data:'manualExemptAmount',width:'20%'},
            ],
            dataTableData: $scope.overdueExempt.contOverdueVoList
        };
        $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
        $compile($("#overdueExemptQueryDetail_table"))($scope);
        $scope.callback = function () {
            var tableData = $scope.overdueExempt.contOverdueVoList;
            var eachRentSum=0,overdueAmountSum=0,receiptAmountSum=0,exemptAmountSum=0,restOverdueAmountSum=0,manualExemptAmountSum=0;
            for(var i=0;i<tableData.length;i++){
                eachRentSum = tableData[i].eachRent*1 + eachRentSum;
                overdueAmountSum = tableData[i].overdueAmount*1 + overdueAmountSum;
                receiptAmountSum = tableData[i].receiptAmount*1 + receiptAmountSum;
                exemptAmountSum = tableData[i].exemptAmount*1 + exemptAmountSum;
                restOverdueAmountSum = tableData[i].restOverdueAmount*1 + restOverdueAmountSum;
                manualExemptAmountSum = tableData[i].manualExemptAmount*1 + manualExemptAmountSum;
            }
            var html = '<tr>' +
                '<th>合计</th>' +
                '<td colspan="3"></td>' +
                '<td>'+eachRentSum.toFixed(2)+'</td>' +
                '<td>'+overdueAmountSum.toFixed(2)+'</td>' +
                '<td>'+receiptAmountSum.toFixed(2)+'</td>' +
                '<td>'+exemptAmountSum.toFixed(2)+'</td>' +
                '<td>'+restOverdueAmountSum.toFixed(2)+'</td>' +
                '<td>'+manualExemptAmountSum.toFixed(2)+'</td>' +
                '</tr>';
            $('#overdueExemptQueryDetail_table tbody').append(html);
        };
        $scope.callback();
    });



    /**
     * 关闭窗口
     * @param status
     */
    $scope.goback = function(){
        $location.path('app/cost_overdue_exempt_list_query')
    };

}]);





