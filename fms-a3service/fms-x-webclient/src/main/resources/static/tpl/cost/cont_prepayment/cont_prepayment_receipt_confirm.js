app.controller('pribiz_cont_charge_controller', ['$scope', '$http','$modal','$compile','$location', 'toaster',function ($scope, $http,$modal,$compile,$location,toaster) {

    /*$scope.contRequestPayActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contRequestPayActType);*/
    $scope.submit = false;
    $scope.formValidate = false;

    //初始化定义银行信息
    $scope.contReceiptVoList = [];
    $scope.contPrepaymentVo = {};
    $scope.contPrepaymentNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $http.get('cont_prepayment/findContPrepaymentWithDetailByContPrepaymentNo?contPrepaymentNo='+ $scope.contPrepaymentNo).success(function (data) {

        $scope.contPrepaymentVo = data.data;
        $scope.contPrepaymentVo.taskId=$location.search()["taskId"];
    });



    //增加银行信息
    $scope.add = function () {
        var obj = {
            receiptDate: getToday()
        };
        $scope.contReceiptVoList.push(obj);
    };
    //删除银行信息
    $scope.del = function (index) {
        $scope.contReceiptVoList.splice(index,1);
    };

    /**
     * 提交请款信息
     */
    $scope.submitCont = function () {
        $scope.contPrepaymentVo.contReceiptList = $scope.contReceiptVoList;
        $scope.url="";
        $scope.bankFlag = true;
        if(!$scope.form.$invalid) {
            $scope.submit = true;

            if(isNullEmpty($scope.contPrepaymentVo.contReceiptList) || $scope.contPrepaymentVo.contReceiptList.length==0){
                modalAlert($modal,"请选择收款银行后再提交！");
                $scope.submit = false;
                return;
            }

            $scope.contPrepaymentVo.contReceiptList.forEach(function (row,index) {
                if(isNullEmpty(row.recAccBranch)){
                    $scope.bankFlag = false;
                }
            });
            if(!$scope.bankFlag){
                modalAlert($modal,"请选择所有收款银行后再提交！");
                $scope.submit = false;
                return;
            }
            $scope.url="cont_prepayment_approve/receiptConfirm";//提交

            $http.post($scope.url, $scope.contPrepaymentVo).success(function (data) {
                if (data.code == Response.successCode){

                    $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});

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
    $scope.goBack = function(status){
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
                $scope.contReceiptVoList[index].recAccBank = data.accBankName;
                $scope.contReceiptVoList[index].recAccountName = data.accountName;
                $scope.contReceiptVoList[index].recAccountNo = data.accountNo;
                $scope.contReceiptVoList[index].recEleBankNo = data.eleAccountNo;
                $scope.contReceiptVoList[index].recAccBranch = data.accBranchBank;
            }
        },function(){
        });
    }

    //计算实收总金额
    $scope.setInputVal = function() {
        var total = 0;
        for(var i=0;i<$scope.contReceiptVoList.length;i++){
            total = numAddSub(total,$scope.contReceiptVoList[i].receiptAmount,1)
        }
        $scope.contPrepaymentVo.receiptActualAmount = total;
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


