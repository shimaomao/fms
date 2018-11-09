/**
 * 过户任务：财务确认收款
 * Created by wangxue on 2018/9/10.
 */
app.controller('transfer_receipt_controller', ['$scope', '$http','$modal', 'toaster','$location', '$filter',function ($scope, $http, $modal, toaster, $location, $filter) {

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.receiptVoList = [];

    $scope.transferInfoVo = {transferNo:$location.search()['serviceId'], taskId:$location.search()['taskId'],
        examineSts:'1',taskDefinitionKey:$location.search()['taskDefinitionKey']};

    $scope.transferNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];

    // 获取子页面的数据
    $scope.$on('transferInfoVoToFather',function (e,data) {
        // 退保金额
        $scope.transferInfoVo.chargeAmount = data.retreatsAmount;
        $scope.transferInfoVo.retreatsAmount = data.retreatsAmount;
    });

    //增加银行信息
    $scope.add = function () {
        var obj = {
            receiptDate: getToday()
        };
        $scope.receiptVoList.push(obj);
    };
    //删除银行信息
    $scope.del = function (index) {
        $scope.receiptVoList.splice(index,1);
    };

    // 确认收款
    $scope.submitInfo = function () {
        if(!$scope.form.$invalid) {
            if(CommonArrayUtils.isNullOrLengthZero($scope.receiptVoList)){
                modalAlert($modal,"请填写收款银行信息！");
                return;
            }
            $scope.submit = true;
            // 付款信息
            $scope.transferInfoVo.receiptVoList = $scope.receiptVoList;
            $http.post('transfer_info/transferReceipt', $scope.transferInfoVo).success(function (result) {
                if (result.code == Response.successCode){
                    $location.path('/app/home').search({"type": 'homeToastInfo', "msg":'财务确认收款成功'})
                } else {
                    modalAlert($modal, result.message);
                }
                $scope.submit = false;
            }).error(function(result){
                modalAlert($modal, result);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }

    };

    // 返回
    $scope.goBack = function () {
        $location.path("/app/home");
    };

    //数据字典类型选择
    $scope.selectBasBankInfo = function(index){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_bank_info_select_controller',
            resolve:{
                selectBank: function () {
                    return {organizationType: CommonCodeUtils.organizationType.userGroup}
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.receiptVoList[index].recAccBank = data.accBankName;
                $scope.receiptVoList[index].recAccountName = data.accountName;
                $scope.receiptVoList[index].recAccountNo = data.accountNo;
                $scope.receiptVoList[index].recEleBankNo = data.eleAccountNo;
                $scope.receiptVoList[index].recAccBranch = data.accBranchBank;
            }
        },function(){
        });
    }

    //计算实收总金额
    $scope.setInputVal = function() {
        var total = 0;
        for(var i=0;i<$scope.receiptVoList.length;i++){
            total = numAddSub(total,$scope.receiptVoList[i].receiptAmount,1)
        }
        $scope.transferInfoVo.receiptActualAmount = total;
    };

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
        }else{
            return (num1 * baseNum - num2 * baseNum) / baseNum;
        }

    }
}]);
