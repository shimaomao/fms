/**
 * Created by yanfengbo on 2018-05-14.
 */
app.controller('cont_insur_claim_receivables_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http,$modal,toaster,$location) {

    $scope.contInsurClaim={};

    $scope.formValidate = false;
    $scope.httpData = true;
    $scope.submit = false;
    //附件对象
    $scope.bizFilesList= [];
    //初始化定义银行信息
    $scope.contReceiptVoList = [];
    $scope.contInsurClaim = {};

    $scope.insurClaimApproveTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.insurClaimApproveType)


    $scope.bizFilesList={bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.insuranceFile}
    $scope.detailFlag = CommonFileUtils.detailFlags.detail;
    $scope.taskId = $location.search()['taskId'];
    $scope.serviceId = $location.search()['serviceId']
    init();
    function init(){
        if(isUndefinedNull($scope.serviceId)){
            $scope.serviceId = null;
        }
        $http.get('cont_insur_claim/findDetailContInsurClaim?&serviceId='+$scope.serviceId).success(function(data){
            $scope.contInsurClaim = data.data;
            console.log(data.data);
            $scope.contInsurClaim.actType =  $scope.insurClaimApproveTypeList[1].codeValue;
            /* $scope.bizFilesList.bizFilesInfo = $scope.contInsurClaim.bizfilesVo.bizFilesInfo;
             $scope.bizFilesList.bizFilesListVos = $scope.contInsurClaim.bizfilesVo.bizFilesListVos;*/
            //附件赋值
            $scope.bizFilesList = $scope.contInsurClaim.bizFilesList;
            //保险类型
            $scope.insuranceTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes[$scope.contInsurClaim.insuranceType]);
            var insuranceSelectInfo = $scope.contInsurClaim.insuranceSelectInfo;
            if(isNotUndefinedNull(insuranceSelectInfo)) {
                $scope.infoArrayList = insuranceSelectInfo.split(',');
                for (var i in $scope.infoArrayList) {
                    for (var j in $scope.insuranceTypeList) {
                        if ($scope.insuranceTypeList[j].codeValue == $scope.infoArrayList[i])
                            $scope.insuranceTypeList[j].orderNo = 1;
                    }
                }
            }
            //是否需要退还
            $scope.returnFlagList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.returnFlag);
            //退还方式
            $scope.returnModeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.returnMode);
        })

    }

    $scope.treeFileId = "insurance_file_tree";


    /**
     * 保存组织机构属性信息
     */

    $scope.modify = function () {
        $scope.contInsurClaim.contReceiptList = $scope.contReceiptVoList;
        $scope.bankFlag = true;
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            if($scope.contInsurClaim.actType == '0'){
                if(isNullEmpty($scope.contInsurClaim.contReceiptList) || $scope.contInsurClaim.contReceiptList.length==0){
                    modalAlert($modal,"请选择收款银行后再提交！");
                    $scope.submit = false;
                    return;
                }

                $scope.contInsurClaim.contReceiptList.forEach(function (row,index) {
                    if(isNullEmpty(row.recAccBranch)){
                        $scope.bankFlag = false;
                    }
                });
                if(!$scope.bankFlag){
                    modalAlert($modal,"请选择所有收款银行后再提交！");
                    $scope.submit = false;
                    return;
                }
                $scope.url = 'insur_claim_check/Receivables';
            }else if($scope.contInsurClaim.actType == '1'){
                $scope.url = 'insur_claim_check/refunds';
            }
            $scope.contInsurClaim.taskId = $scope.taskId = $location.search()['taskId'];
            $http.put($scope.url, $scope.contInsurClaim).success(function (data) {
                if (data.code == Response.successCode){
                    if($scope.contInsurClaim.actType=="0"){
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
    $scope.wfLogType = CommonCodeUtils.bizTypes.contInsurClaim;
    $scope.wfLogNo = $scope.serviceId;

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
        $scope.setInputVal();
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
        $scope.contInsurClaim.receiptsAmount = total;
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


