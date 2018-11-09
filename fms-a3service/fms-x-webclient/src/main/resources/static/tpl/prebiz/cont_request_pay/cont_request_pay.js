/**
 * Created by huchenghao on 2018-03-26.
 */
app.controller('cont_request_pay_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.contRequestPay={};
    $scope.carpriceName='';

    $scope.formValidate = false;
    $scope.contRequestPayActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contRequestPayActType);

    $scope.applyNo = $location.search()['applyNo'];
    $scope.contNo = $location.search()['contNo'];
    $scope.applyType = $location.search()['applyType'];
    $scope.taskId = $location.search()['taskId'];
    $scope.submit = false;
    //请款附件对象
    $scope.fileInfo = {
        notUpload: false,
        notUploadInfo: '',
        notFileType: '',
        notFileTypeName:''
    };
    //$scope.detailFlag = 0;
    // $scope.treeFileId = "tree_file_requestPay";
    // $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.requestPayFile};

    $http.get('cont_request_pay/findContRequestPayByContNo?contNo='+$scope.contNo).success(function (data) {
        if(data.code == Response.successCode){
            $scope.contRequestPay=data.data;
            console.log($scope.contRequestPay)

            $scope.contRequestPay.contNo=$location.search()["contNo"];
            $scope.contRequestPay.applyNo=$location.search()["applyNo"];
            $scope.contRequestPay.applyType=$location.search()["applyType"];
            $scope.contRequestPay.taskId=$location.search()["taskId"];
            // if(isNotNullEmpty($scope.contRequestPay.deductibleFees))
            //     $scope.contRequestPay.deductibleFeesShow=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.deductibleFees,$scope.contRequestPay.deductibleFees);
            // if(isNotNullEmpty($scope.contRequestPay.licenseAttr))
            //     $scope.contRequestPay.licenseAttrShow=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,$scope.contRequestPay.licenseAttr);

            // $scope.bizFilesList.bizFilesInfo = $scope.contRequestPay.bizFilesVo.bizFilesInfo;
            // $scope.bizFilesList.bizFilesListVos = $scope.contRequestPay.bizFilesVo.bizFilesListVos;


        }
});

    //银行选择
    $scope.selectBasBankInfo = function(a){
        var finItemBankType = {
            carprice : CommonCodeUtils.organizationType.basSales,        //车款
            // purchasetax :  CommonCodeUtils.organizationType.individualAccount,         //购置税
            insurance :  CommonCodeUtils.organizationType.insuranceCompany,          //商业保险，交强险车船税
            gps: CommonCodeUtils.organizationType.gpsManuFacturer,
            // license :  CommonCodeUtils.organizationType.userGroup,
            // extra : CommonCodeUtils.organizationType.userGroup,            //精品加装
        };
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_bank_info_select_controller',
            resolve:{
                selectBank: function () {
                    if(isNotUndefinedNull(finItemBankType[a.finItem])){
                        return {organizationType: finItemBankType[a.finItem]}
                    }else {
                        return null
                    }
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                a.contPay.recAccBank = data.accBankName;
                a.contPay.recAccountName = data.accountName;
                a.contPay.recAccountNo = data.accountNo;
                a.contPay.recEleBankNo = data.eleAccountNo;
                a.contPay.recAccBranch = data.accBranchBank;
            }
        },function(){

        });
    };

    /**
     * 提交请款信息
     */
    $scope.url="";
    $scope.submitContRequestPay = function () {

        if(isNullEmpty($scope.contRequestPay.insuranceStatus)){
            modalAlert($modal,"请选择提交还是退回！");
            return;
        }

        console.log($scope.fileInfo);
        $scope.correct = true;
        if($scope.fileInfo.notUpload && $scope.contRequestPay.insuranceStatus==1){
            modalAlert($modal, "请上传" + $scope.fileInfo.notFileTypeName + "类型文件");
            $scope.correct = false;
            return;
        }

        $scope.bankFlag = true;
        if(!$scope.form.$invalid && $scope.correct) {
            $scope.submit = true;
            if($scope.contRequestPay.insuranceStatus=="1"){
                $scope.contRequestPay.contFinPayVoList.forEach(function (row,index) {
                    if(row.contPay.payAmount>0 && isNullEmpty(row.contPay.recAccBranch)){
                        $scope.bankFlag = false;
                    }
                });
                if(!$scope.bankFlag){
                    modalAlert($modal,"请选择所有付款额大于0的收款银行后再提交！");
                    $scope.submit = false;
                    return;
                }
                $scope.url="cont_request_pay/submitContRequestPay";//提交
            }else{
                $scope.url="cont_request_pay/sendBack";//退回
            }

            if(!checkAccountName() && $scope.contRequestPay.insuranceStatus=="1") {
                var size = "md";
                modalConfirm($modal,function(){
                    subminCommon();
                },function () {
                    $scope.submit = false;
                },"实际销售方:【"+$scope.contRequestPay.saleGroupName+"】<br>车款账户名称: 【"+$scope.carpriceName+"】<br>名称不一致，是否暂存？",null,size);
            }else{
                subminCommon();
            }

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }

    }

    function subminCommon() {
        $http.post($scope.url, $scope.contRequestPay).success(function (data) {
            if (data.code == Response.successCode){

                if($scope.contRequestPay.insuranceStatus=="1"){
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
    }

    /**
     * 暂存请款信息
     */
    $scope.saveContRequestPay = function () {
        if(!checkAccountName()) {
            var size = "md";
            modalConfirm($modal,function(){
                saveCommon();
            },null,"实际销售方:【"+$scope.contRequestPay.saleGroupName+"】<br>车款账户名称: 【"+$scope.carpriceName+"】<br>名称不一致，是否暂存？",null,size);
        }else {
            saveCommon();
        }
    };
    
    //暂存方法
    function saveCommon() {
        $scope.submit = true;
        //获取附件
        // $scope.contRequestPay.bizFilesVo = $scope.bizFilesList;
        $http.post('cont_request_pay/saveContRequestPay', $scope.contRequestPay).success(function (data) {
            var memo = $scope.contRequestPay.memo;
            if (data.code == Response.successCode){
                modalAlert($modal,"暂存成功");
                $http.get('cont_request_pay/findContRequestPayByContNo?contNo='+$scope.contNo).success(function (data) {
                    if(data.code == Response.successCode){
                        $scope.contRequestPay=data.data;
                        console.log($scope.contRequestPay)

                        $scope.contRequestPay.contNo=$location.search()["contNo"];
                        $scope.contRequestPay.applyNo=$location.search()["applyNo"];
                        $scope.contRequestPay.applyType=$location.search()["applyType"];
                        $scope.contRequestPay.taskId=$location.search()["taskId"];
                        $scope.contRequestPay.memo = memo;
                    }
                });
            }else{
                modalAlert($modal,data.message);
            }
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    }
    
    //检查车款付款银行是否是实际销售方
    function checkAccountName() {
        for(var i = 0;i<$scope.contRequestPay.contFinPayVoList.length;i++) {
            var row = $scope.contRequestPay.contFinPayVoList[i];
            if(row.finItem == 'carprice' && row.contPay.recAccountName != $scope.contRequestPay.saleGroupName){
                $scope.carpriceName=row.contPay.recAccountName;
                return false;
            }
        }
        return true;
    }

    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("/app/home");
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.apply;
    $scope.wfLogNo = $scope.applyNo;
    $scope.wfLogSubNo = $scope.contNo;
}]);


