/**
 * Created by ningyangyang on 2018/6/8.
 */
/**
 * Created by huzongcheng
 * 增加保证金财务确认收款
 */
app.controller('deposit_finance_receipt_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.baseData={};
    $scope.depositFinance={};

    $scope.depositFinanceVoList = [];

    $scope.depositTaskNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.formValidate = false;
    $scope.submit = false;

    $scope.getData = function () {
        var url = 'deposit_change_task/findApplyInfoByContNo?';
        if(isNotUndefinedNull($scope.depositTaskNo)){
            url = url + '&depositTaskNo=' + $scope.depositTaskNo;
        } else if (isNotUndefinedNull($scope.cont_no)){
            url = url + 'contNo=' + $scope.cont_no;
        }
        $http.get(url).success(function (data) {
            if(data.code == Response.successCode){
                $scope.baseData = data.data;
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };
    $scope.getData();

    /**
     * 确认收款
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.depositFinance.depositFinanceVoList = $scope.depositFinanceVoList;
            $scope.depositFinance.depositTaskNo = $scope.depositTaskNo;
            $scope.depositFinance.taskId  = $scope.taskId
            $http.post('deposit_change_task/financeReceipt', $scope.depositFinance).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path('/app/home').search({"type": 'homeToastInfo', "msg":'财务确认收款成功'})
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
     * 退回上一级
     */
    $scope.sendBack = function(){
        $scope.submit = true;
        if(isUndefinedNull($scope.depositFinance.remark)){
            modalAlert($modal,'请输入备注');
            $scope.submit = false;
            return false;
        }
        $scope.depositFinance.depositTaskNo = $scope.depositTaskNo;
        $scope.depositFinance.taskId  = $scope.taskId
        $http.post('deposit_change_task/financeSendBack', $scope.depositFinance).success(function (data) {
            if (data.code == Response.successCode){
                $location.path('/app/home').search({"type": 'homeToastInfo', "msg":'退回成功'})
            }
            else
                modalAlert($modal,data.message);
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    }

    $scope.add = function () {
        var obj = {
            recAccBank:'',
            recAccountName:'',
            recAccountNo:'',
            recEleBankNo:'',
            receiptAmount:0,
            memo:'',
            receiptDate: getToday()
        };
        $scope.depositFinanceVoList.push(obj);
    };
    //删除银行信息
    $scope.del = function (index) {
        $scope.depositFinanceVoList.splice(index,1);
    };
    //选择银行信息
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
                $scope.depositFinanceVoList[index].recAccBank = data.accBankName;
                $scope.depositFinanceVoList[index].recAccountName = data.accountName;
                $scope.depositFinanceVoList[index].recAccountNo = data.accountNo;
                $scope.depositFinanceVoList[index].recEleBankNo = data.eleAccountNo;
                $scope.depositFinanceVoList[index].recAccBranch = data.accBranchBank;
            }
        },function(){
        });
    }

    //查看逾期详情
    $scope.overdue = function () {
        //取得逾期客户id
        $http.get('deposit_change_task/findOverdueCstmId?certifNo='+$scope.baseData.certifNo).success(function (data) {
            if(data.code == Response.successCode){
                var overdueCstmId = data.data;
                if(CommonStringUtils.isTrimBlank(overdueCstmId)){
                    modalAlert($modal,'该客户未发生过逾期');
                } else {
                    var id = overdueCstmId;
                    var url = 'app.postbiz_overdue_cstm_modify?overdueCstmId=' + overdueCstmId
                        + '&detail=true&isTab=true';
                    var title = '逾期详情';
                    var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
                    if(window.parent.addTab){
                        window.parent.addTab(html);
                    }
                }
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goback = function(){
        $location.path('/app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.depositChange;
    $scope.wfLogNo = $scope.depositTaskNo;

}]);



