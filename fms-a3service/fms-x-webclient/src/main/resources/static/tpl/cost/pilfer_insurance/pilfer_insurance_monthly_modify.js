/**
 * Created by yangyiquan on 2018-05-18.
 */
app.controller('pilfer_insurance_monthly_modify_controller', ['$scope', '$http','$modal','toaster','$location','$compile','$filter', function ($scope, $http,$modal,toaster,$location,$compile,$filter) {

    $scope.pilferInsuranceIds = $location.search()['pilferInsuranceIds'];;//选择的盗抢险数据
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.httpData = true;
    $scope.notUpload = false;
    $scope.msgInfo = null;
    //附件对象
    $scope.bizFilesList= [];
    $scope.monthlyPilferInsuranceVo = {taskId:$location.search()['taskId']};
    $scope.backUrl = '/app/cost_pilfer_insurance_monthly_list';

    $scope.monthlyPilferInsuranceNo = $location.search()['serviceId'] || "";//退回时这里有月结任务号
    if(isNotNullEmpty($scope.monthlyPilferInsuranceNo)){
        $scope.backUrl = '/app/home';
        $scope.monthlyPilferInsuranceVo.monthlyPilferInsuranceNo = $scope.monthlyPilferInsuranceNo;
        //获取财务付款数据
        $http.get('contpay/findContPayByBizCodeAndPaymentType?paymentType='+CommonCodeUtils.bizTypes.pilfer+'&bizCode='+ $scope.monthlyPilferInsuranceNo).success(function(data){
            $scope.contPay = data.data;
            $scope.monthlyPilferInsuranceVo.recAccBank = $scope.contPay.recAccBank;
            $scope.monthlyPilferInsuranceVo.recAccountName = $scope.contPay.recAccountName;
            $scope.monthlyPilferInsuranceVo.recAccountNo = $scope.contPay.recAccountNo;
        });
    }

    //退回时附件回显
    if(isNotNullEmpty($scope.monthlyPilferInsuranceNo)){
        $http.get('monthly_pilfer_insurance/findMonthlyPilferInsuranceVoByPilferInsuranceNo?monthlyPilferInsuranceNo='+ $scope.monthlyPilferInsuranceNo).success(function(data){
            //附件赋值
            $scope.bizFilesList = data.data.bizFilesList;
        });
    }

    $http.post(
         'pilfer_insurance/findPilferInsuranceMonthlysVos',
         {pageFlag: 1, pilferInsuranceIds: $scope.pilferInsuranceIds,monthlyPilferInsuranceNo:$scope.monthlyPilferInsuranceNo}
    ).success(function (data) {
        if (data.code == Response.successCode){
            var totalCost = 0;
            $scope.tableData = data.data.data;
            $scope.tableData.forEach(function (data,index) {
                totalCost = numAddSub(totalCost,data.billPilferInsuranceCost*1,1);
                if(data.billPilferInsuranceCost == data.pilferInsuranceCost){
                    data.consistent = "一致";
                } else {
                    data.consistent = "不一致";
                }
                var date = data.expectInstallDate;
                var month= $filter('date')(date, 'yyyy-MM');
                data.billMonth =  month;
            });
            $scope.monthlyPilferInsuranceVo.totalCost = totalCost;
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
                selectBank:function () {
                    return {organizationType: CommonCodeUtils.organizationType.gpsManuFacturer}
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                // $scope.monthlyPilferInsuranceVo.groupCode = data.groupCode;
                // $scope.monthlyPilferInsuranceVo.groupBankNo = data.groupBankNo;
                $scope.monthlyPilferInsuranceVo.recAccBank = data.accBankName;
                $scope.monthlyPilferInsuranceVo.recAccountName = data.accountName;
                $scope.monthlyPilferInsuranceVo.recAccountNo = data.accountNo;
                $scope.monthlyPilferInsuranceVo.recEleBankNo = data.eleAccountNo;
                $scope.monthlyPilferInsuranceVo.recAccBranch = data.accBranchBank;
            }
        },function(){

        });
    }

    //保存
    $scope.save = function () {
        if(!$scope.form.$invalid && !$scope.notUpload) {
            $scope.submit = true;
            $scope.monthlyPilferInsuranceVo.pilferInsurances = $scope.tableData;
            $scope.monthlyPilferInsuranceVo.bizFilesList = $scope.bizFilesList;
            $http.post('monthly_pilfer_insurance/saveMonthlyPilferInsuranceWithPI', $scope.monthlyPilferInsuranceVo).success(function (data) {
                if (data.code == Response.successCode){
                    if(isNotNullEmpty($scope.monthlyPilferInsuranceNo))
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'申请成功'});
                    else
                        $location.path("app/cost_pilfer_insurance_monthly_list").search({type:"save"});
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
        if(a.billPilferInsuranceCost == a.pilferInsuranceCost)
            a.consistent = "一致";
        else
            a.consistent = "不一致";

        $scope.tableData.forEach(function (data,index) {
            totalCost = numAddSub(totalCost,data.billPilferInsuranceCost*1,1);
        });
        $scope.monthlyPilferInsuranceVo.totalCost = totalCost;
    }
}]);


