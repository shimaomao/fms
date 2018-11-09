/**
 * Created by yangyiquan on 2018-05-18.
 */
app.controller('gps_dispatch_monthly_modify_controller', ['$scope', '$http','$modal','toaster','$location','$compile','$filter', function ($scope, $http,$modal,toaster,$location,$compile,$filter) {

    $scope.dispatchIds = $location.search()['dispatchIds'];;//选择的gps数据
    console.log($scope.dispatchIds)
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.httpData = true;
    $scope.notUpload = false;
    $scope.msgInfo = null;
    $scope.monthlySettlementVo = {taskId:$location.search()['taskId']};
    $scope.backUrl = '/app/cost_gps_dispatch_monthly_list';
    //附件对象
    $scope.bizFilesList= [];

    $scope.monthlySettlementNo = $location.search()['serviceId'] || "";//退回时这里有月结任务号
    if(isNotNullEmpty($scope.monthlySettlementNo)){
        $scope.backUrl = '/app/home';
        $scope.monthlySettlementVo.monthlySettlementNo = $scope.monthlySettlementNo;
        //获取财务付款数据
        $http.get('contpay/findContPayByBizCodeAndPaymentType?paymentType='+CommonCodeUtils.bizTypes.gps+'&bizCode='+ $scope.monthlySettlementNo).success(function(data){
            $scope.contPay = data.data;
            $scope.monthlySettlementVo.recAccBank = $scope.contPay.recAccBank;
            $scope.monthlySettlementVo.recAccountName = $scope.contPay.recAccountName;
            $scope.monthlySettlementVo.recAccountNo = $scope.contPay.recAccountNo;
        });
    }

    //退回时附件回显
    if(isNotNullEmpty($scope.monthlySettlementNo)){
        $http.get('monthly_settlement/findMonthlySettlementVoBySettlementNo?monthlySettlementNo='+ $scope.monthlySettlementNo).success(function(data){
            //附件赋值
            $scope.bizFilesList = data.data.bizFilesList;
        });
    }

    $http.post(
         'gps_dispatch/findGpsDispatchMonthlysVos',
         {pageFlag: 1, dispatchIds: $scope.dispatchIds,monthlySettlementNo:$scope.monthlySettlementNo}
    ).success(function (data) {
        if (data.code == Response.successCode){
            var totalCost = 0;
            $scope.tableData = data.data.data;
            console.log($scope.tableData);
            $scope.tableData.forEach(function (data,index) {
                totalCost = numAddSub(totalCost,data.billTotalCost*1,1);
                if(data.billTotalCost == data.totalCost){
                    data.consistent = "一致";
                }else {
                    data.consistent = "不一致";
                }
                var date = data.expectInstallDate;
                var month= $filter('date')(date, 'yyyy-MM');
                data.billMonth =  month;
            });
            $scope.monthlySettlementVo.totalCost = totalCost;
        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    //银行选择
    $scope.selectBasBankInfo = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_bank_info_select_controller',
            resolve:{
                selectBank: function () {
                    return {organizationType: CommonCodeUtils.organizationType.gpsManuFacturer}
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.monthlySettlementVo.recAccBank = data.accBankName;
                $scope.monthlySettlementVo.recAccountName = data.accountName;
                $scope.monthlySettlementVo.recAccountNo = data.accountNo;
                $scope.monthlySettlementVo.recEleBankNo = data.eleAccountNo;
                $scope.monthlySettlementVo.recAccBranch = data.accBranchBank;
            }
        },function(){

        });
    }

    //保存
    $scope.save = function () {
        if(!$scope.form.$invalid && !$scope.notUpload) {
            $scope.submit = true;
            $scope.monthlySettlementVo.gpsDispatches = $scope.tableData;
            $scope.monthlySettlementVo.bizFilesList = $scope.bizFilesList;
            $http.post('monthly_settlement/saveMonthlySettlementWithGps', $scope.monthlySettlementVo).success(function (data) {
                if (data.code == Response.successCode){
                    if(isNotNullEmpty($scope.monthlySettlementNo))
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'申请成功'});
                    else
                        $location.path("app/cost_gps_dispatch_monthly_list").search({type:"save"});
                }
                else{
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            if($scope.form.$invalid){
                toaster_info(promptInfo.submitWarn,toaster);
            }else{
                toaster_info($scope.msgInfo,toaster);
            }
            $scope.formValidate = true;
        }
    };
    //取消
    $scope.close = function () {
        $location.path($scope.backUrl).search({});
    };

    //type=1-相加，否则相减num1-num2
    function numAddSub(num1,num2,type) {
        //要相加的两个数(小数)
        var baseNum, baseNum1, baseNum2;
        try {
            baseNum1 = num1.toString().split(".")[1].length;
        } catch (e) {
            baseNum1 = 0;
        }
        try {
            baseNum2 = num2.toString().split(".")[1].length;
        } catch (e) {
            baseNum2 = 0;
        }
        baseNum = Math.pow(10, Math.max(baseNum1, baseNum2));
        if(type == 1){
            return (num1 * baseNum + num2 * baseNum) / baseNum;
        }else if(type == 2){
            return (num1 * baseNum - num2 * baseNum) / baseNum;
        }

    }
    
    
    $scope.changeValue = function (a) {
        var totalCost = 0;
        a.billTotalCost = numAddSub(numAddSub(a.equipmentCost*1 , a.installationCost*1,1) , a.changeCost*1,1);
        if(a.billTotalCost == a.totalCost)
            a.consistent = "一致";
        else
            a.consistent = "不一致";

        $scope.tableData.forEach(function (data,index) {
            totalCost = numAddSub(totalCost,data.billTotalCost*1,1);
        });
        $scope.monthlySettlementVo.totalCost = totalCost;
    }
}]);


