/**
 * Created by qiaohao on 2018/6/5.
 */
/*
app.controller('equ_mor_charge_finance_touching_controller', ['$scope', '$http', '$modal', 'toaster','$location', function ($scope, $http, $modal, toaster,$location) {


    $scope.equMorChargeFinTouchingVo = {taskId: $location.search()['taskId'],equMorTaskNo:$location.search()['serviceId'],taskDefinitionKey:$location.search()['taskDefinitionKey']};
    $scope.equMorDetails = [];
    $scope.equMorCharge = {};
    $scope.basBankInfoVo = null;
    $scope.equMorTaskNo = $location.search()['serviceId'];

    $http.get('equ_mor_apply/findFinanceTouchingVo?equMorTaskNo=' + $scope.equMorTaskNo).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.equMorDetails = data.data.equMorDetailVos;
            $scope.equMorCharge = data.data.equMorCharge;
            $scope.basBankInfoVo = data.data.basBankInfoVo;
            $scope.bizFilesList = data.data.bizFilesList;
        } else
            modalAlert($modal,data.message);
    }).error(function(data){
        modalAlert($modal,data);
    })

    //银行选择
    $scope.selectBasBankInfo = function(){
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
                $scope.basBankInfoVo.accBankName = data.accBankName;
                $scope.basBankInfoVo.accBranchBank = data.accBranchBank;
                $scope.basBankInfoVo.accountName = data.accountName;
                $scope.basBankInfoVo.accountNo = data.accountNo;
                $scope.basBankInfoVo.eleAccountNo = data.eleAccountNo;
            }
        },function(){

        });
    }

    $scope.save = function(){
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            var check = true;
            if($scope.basBankInfoVo == null){
                modalAlert($modal,"请选择付款银行");
                check = false;
            }
            if(check) {
                $scope.equMorChargeFinTouchingVo.basBankInfoVo = $scope.basBankInfoVo;
                console.log($scope.equMorChargeFinTouchingVo)
                $http.post('equ_mor_apply/financeTouching', $scope.equMorChargeFinTouchingVo).success(function (data) {
                    if (data.code == Response.successCode) {
                        $location.path("/app/home").search({type: 'homeToastInfo', msg: '制单成功'});
                    }
                    else {
                        modalAlert($modal, data.message);
                        $scope.submit = false;
                    }
                }).error(function (data) {
                    modalAlert($modal, data);
                    $scope.submit = false;
                })
            }else{
                $scope.submit = false;
            }
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }


    }

    //返回到主页
    $scope.goBack = function () {
        $location.path("app/home");
    }

    //退回上一级
    $scope.returnSuperior = function(){
        if(CommonStringUtils.isNotTrimBlank($scope.equMorChargeFinTouchingVo.memo)) {
            $scope.submit = true;
            $http.post('equ_mor_apply/equMorApplyReturn', $scope.equMorChargeFinTouchingVo).success(function (data) {
                if (data.code == Response.successCode) {
                    $location.path("/app/home").search({type: 'homeToastInfo', msg: '退回成功'});
                }
                else {
                    modalAlert($modal, data.message);
                    $scope.submit = false;
                }
            }).error(function (data) {
                modalAlert($modal, data);
                $scope.submit = false;
            })
        }else{
            modalAlert($modal, "请填写备注");
        }
    }

    /!**
     * 资方抵押付款单打印
     *!/
    $scope.printEquMor = function () {
        $scope.equMorChargeFinTouchingVo.equMorCharge = $scope.equMorCharge;
        $scope.equMorChargeFinTouchingVo.equMorDetailVos = $scope.equMorDetails;
        $scope.equMorChargeFinTouchingVo.basBankInfoVo = $scope.basBankInfoVo;
        CommonFileUtils.downloadFilePost('equ_mor_apply/printEquMor',$scope.equMorChargeFinTouchingVo
            ,$http,$modal,$scope);
    }



}])
;*/
