/**
 * Created by huchenghao on 2018/3/10.
 */

app.controller('cont_create_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {

   //合同属性对象
    $scope.applyNo = $location.search()['applyNo'];
    $scope.contNo = $location.search()['contNo'];
    $scope.applyType = $location.search()['applyType'];
    $scope.taskId = $location.search()['taskId'];
    $scope.contCreate={};

    $scope.accBankList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.openingBank);

    //定金是否抵扣车款
    $scope.deductibleFeesList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.deductibleFees);

    $scope.formValidate = false;
    $scope.submit = false;
        $http.get('cont_create/findContCreateByContNo?contNo='+$scope.contNo).success(function (data) {
            $scope.contCreate = data.data;
            $scope.contCreate.contNo=$location.search()["contNo"];
            $scope.contCreate.applyNo=$location.search()["applyNo"];
            $scope.contCreate.applyType=$location.search()["applyType"];
            $scope.contCreate.taskId = $location.search()["taskId"];
        });
    /**
     * 保存合同信息
     */
    $scope.save = function () {
        if(!$scope.form.$invalid) {
                    $scope.submit = true;
            if($scope.contCreate.deductibleFees == '1' && (!($scope.contCreate.vehDeposit>0))){
                modalAlert($modal,"定金金额必须大于零");
                $scope.submit = false;
                return false;
            }
                    $http.post('cont_create/saveContCreate', $scope.contCreate).success(function (data) {
                        if (data.code == Response.successCode){
                            toaster_success('生成合同成功！',toaster);
                            $location.path("/app/home")
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
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    //取消合同
    $scope.cancel = function () {
        if(isNullEmpty($scope.contCreate.memo)){
            toaster_info("请填写审批备注",toaster);
            return;
        }
        modalConfirm($modal,function(){
            $scope.submit = true;
            $http.post('cont_create/cancelContCreate', $scope.contCreate).success(function (data) {
                if (data.code == Response.successCode){
                    toaster_success('取消合同成功！',toaster);
                    $location.path("/app/home")
                }
                else{
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
        },null,'您确定需要取消吗？');
    };

    //银行选择
    $scope.selectBasBankInfo = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_bank_info_select_controller',
            resolve:{
                selectBank: function () {
                    return {organizationType: CommonCodeUtils.organizationType.basPartner}
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.contCreate.groupCode = data.groupCode;
                $scope.contCreate.groupBankNo = data.groupBankNo;
                $scope.contCreate.recAccBank = data.accBankName;
                $scope.contCreate.recAccBranchBank = data.accBranchBank;
                $scope.contCreate.recAccountName = data.accountName;
                $scope.contCreate.recAccountNo = data.accountNo;
            }
        },function(){

        });
    }
    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("/app/home")
    };

    //选择所属指标信息
    $scope.selectLicenseIdx = function () {
        var syspambelongroup = $scope.contCreate.syspambelonGroup;//用户代码
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/license_idx/license_idx.html',
            controller: 'license_idx_controller',
            resolve:{
                setData: function () {
                    return {
                        "checkboxOrRadio": Radio
                    };
                },
                syspambelongroup:function () {
                    return syspambelongroup;
                }
            }
        });
        rtn.result.then(function (data) {
            if(isNotUndefinedNull(data)){
                $scope.contCreate.licenseIdxNo = data.licenseIdxNo;
            }
        },function(){

        });
    };
    /**
     * 判断定金金额
     */
    // $scope.$watch("vehDeposit",function () {
    //
    // })
    $scope.judgeDeposit = function () {
        if($scope.contCreate.deductibleFees == '1' && (!($scope.contCreate.vehDeposit>0))){
            modalAlert($modal,"定金金额必须大于零");
            $scope.submit = false;
        }
    }

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.apply;
    $scope.wfLogNo = $scope.applyNo;
    $scope.wfLogSubNo = $scope.contNo;

}]);