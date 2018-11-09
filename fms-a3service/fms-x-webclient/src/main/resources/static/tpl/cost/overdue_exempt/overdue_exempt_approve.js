/**
 * Created by yanfengbo on 2018-05-14.
 */
app.controller('overdue_exempt_approve_controller', ['$scope', '$http','$modal','toaster','$location','$compile',function ($scope, $http,$modal,toaster,$location,$compile) {

    $scope.contOverdueOneVo={};

    $scope.formValidate = false;

    $scope.submit = false;
    $scope.insurClaimApproveTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.insurClaimApproveType)

    $scope.taskId = $location.search()['taskId'];
    $scope.serviceId = $location.search()['serviceId']

    $http.get('overdue_exempt/findDetailByServiceId?serviceId='+ $scope.serviceId).success(function(data){
        $scope.overdueExempt = data.data;
        $scope.contOverdueOneVo = $scope.overdueExempt.contOverdueOneVo;
        $scope.overdueExempt.actType='1';
        console.log(data);
        $scope.dataTableProperties= {
            //table的html id
            dataTableId:'overdueExemptApprove_table',
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
            dataTableSelectType: CheckBox,
            dataTableData: $scope.overdueExempt.contOverdueVoList
        };
        $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
        $compile($("#overdueExemptApprove_table"))($scope);
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
            $('#overdueExemptApprove_table tbody').append(html);
        };
        $scope.callback();
    });

    /**
     * 保存组织机构属性信息
     */

    $scope.modify = function () {

        if($scope.overdueExempt.actType == '0'){
            $scope.url = 'overdue_exempt/approval';
        }else if($scope.overdueExempt.actType == '1'){
            $scope.url = 'overdue_exempt/sendBack';
        }
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.overdueExempt.taskId = $scope.taskId = $location.search()['taskId'];
            $scope.overdueExempt.serviceId = $scope.serviceId = $location.search()['serviceId'];
            $http.put($scope.url, $scope.overdueExempt).success(function (data) {
                if (data.code == Response.successCode){
                    if($scope.overdueExempt.actType=="0"){
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                    }else{
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'退回成功'});
                    }
                }
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }


    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goback = function(){
        $location.path('/app/home')
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.overdueExempt;
    $scope.wfLogNo = $scope.serviceId;

}]);




