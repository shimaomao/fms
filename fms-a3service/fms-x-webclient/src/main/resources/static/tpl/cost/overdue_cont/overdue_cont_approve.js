/**
 * Created by yanfengbo on 2018-05-14.
 */
app.controller('overdue_cont_approve_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http,$modal,toaster,$location) {

    $scope.overdueCont={};

    $scope.formValidate = false;

    $scope.submit = false;
    $scope.insurClaimApproveTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.insurClaimApproveType)

    $scope.taskId = $location.search()['taskId'];
    $scope.serviceId = $location.search()['serviceId']

    $http.get('overdue_cont/findDetailByServiceId?serviceId='+ $scope.serviceId).success(function(data){
        $scope.overdueCont = data.data;
        console.log(data);
        $scope.dataTableProperties= {
            //table的html id
            dataTableId:'overdueContApprove_table',
            //table的列
            dataTableColumn: [
                defaultCheckBox('contOverdueId'),
                {title:'合同编号',data:'contNo',width:'20%'},
                {title:'期数',data:'period',width:'20%'},
                {title:'逾期天数',data:'overdueDays',width:'20%'},
                {title:'罚息金额',data:'overdueAmount',width:'20%'},
                {title:'罚息已收金额',data:'receiptAmount',width:'20%'},
                {title:'以免除罚息金额',data:'exemptAmount',width:'20%'},
                {title:'罚息剩余金额',data:'restOverdueAmount',width:'20%'},
                {title:'免除金额',data:'manualExemptAmount',width:'20%'},
            ],
            dataTableSelectType: CheckBox,
            dataTableData: $scope.overdueCont.contOverdueVoList
        };
        $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
        $compile($("#overdueContApprove_table"))($scope);
    });

    /**
     * 保存组织机构属性信息
     */

    $scope.modify = function () {

        if($scope.overdueCont.actType == '0'){
            $scope.url = 'overdue_cont/approval';
        }else if($scope.overdueCont.actType == '1'){
            $scope.url = 'overdue_cont/sendBack';
        }
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.overdueCont.taskId = $scope.taskId = $location.search()['taskId'];
            $scope.overdueCont.serviceId = $scope.serviceId = $location.search()['serviceId'];
            $http.put($scope.url, $scope.overdueCont).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path('/app/home')
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

}]);




