/**
 * Created by license_idx on 2018-09-26.
 */
app.controller('approval_statistics_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {
    $scope.dateParams = JSON.stringify({dateFmt:'yyyy'});

    //融资租赁审批数据统计报表数据excel导出
    $scope.reportApprovalStatisticsExport = function () {
        var yearInquiries = $scope.yearInquiries;
        var hrefUrl = 'report_statistics/reportApprovaltatisticsExport?yearInquiries='+yearInquiries;
        window.parent.open(hrefUrl);
    }

}])
;