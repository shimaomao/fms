/**
 * Created by yangyiquan on 2018-03-26.
 */
app.controller('monthly_settlement_approve_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {


    $scope.formValidate = false;
    $scope.httpData = true;
    //附件对象
    $scope.bizFilesList= [];
    //审批操作
    $scope.contRequestPayActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contRequestPayActType);

    $scope.monthlySettlementApproveVo = {monthlySettlementNo:$location.search()['serviceId'], taskId:$location.search()['taskId'],
        approvalFlag:'1'};

    $scope.monthlySettlementNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.submit = false;

    //获取月结数据
    $http.get('monthly_settlement/findMonthlySettlementVoBySettlementNo?monthlySettlementNo='+ $scope.monthlySettlementNo).success(function(data){
        $scope.monthlySettlementVo = data.data;
        //附件赋值
        $scope.bizFilesList = $scope.monthlySettlementVo.bizFilesList;
    });
    //获取财务付款数据
    $http.get('contpay/findContPayByBizCodeAndPaymentType?paymentType='+CommonCodeUtils.bizTypes.gps+'&bizCode='+ $scope.monthlySettlementNo).success(function(data){
        $scope.contPay = data.data;
    });

    //获取月结明细数据
    $http.post(
        'gps_dispatch/findGpsDispatchMonthlysVos',
        {monthlySettlementNo: $scope.monthlySettlementNo}
    ).success(function (data) {
        if (data.code == Response.successCode){
            $scope.tableData = data.data.data;
            $scope.tableData.forEach(function (data,index) {
                if(data.billTotalCost == data.totalCost)
                    data.consistent = "一致";
                else
                    data.consistent = "不一致";
            });
        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    /**
     * 提交月结申请
     */
    $scope.url="";
    $scope.submitInfo = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.url="monthly_settlement_approve/approval";//提交

            $http.post($scope.url, $scope.monthlySettlementApproveVo).success(function (data) {
                if (data.code == Response.successCode){

                    if($scope.monthlySettlementApproveVo.approvalFlag=="1"){
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                    }else{
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'退回成功'});
                    }
                }else{
                    modalAlert($modal,data.message);
                }

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
     * 返回
     * @param status
     */
    $scope.goback = function(){
        $location.path("/app/home").search({
            operate: null,
            contNo: null
        });
    };
}]);


