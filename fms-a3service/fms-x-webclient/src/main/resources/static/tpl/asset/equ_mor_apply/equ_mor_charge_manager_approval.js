/**
 * Created by qiaohao on 2018/6/8.
 */
app.controller('equ_mor_charge_manager_approval_controller', ['$scope', '$http', '$modal', 'toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    $scope.equMorCharge = {};
    $scope.equMorDetails = [];
    $scope.equMorCharge = {};
    $scope.basBankInfoVo = null;
    $scope.equMorTaskNo = $location.search()['serviceId'];
    $scope.managerApproval = {taskId:$location.search()['taskId'],equMorTaskNo:$scope.equMorTaskNo,taskDefinitionKey:$location.search()['taskDefinitionKey']}


    $http.get('equ_mor_apply/findFinanceTouchingVo?equMorTaskNo=' + $scope.equMorTaskNo).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.equMorDetails = data.data.equMorDetailVos;
            $scope.equMorCharge = data.data.equMorCharge;
            $scope.basBankInfoVo = data.data.basBankInfoVo;
        }
        else
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
                $scope.basBankInfoVo = data;
            }
        },function(){

        });
    }

    $scope.save = function(){

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.post('equ_mor_apply/equMorApplyAgree', $scope.managerApproval).success(function (data) {
                if (data.code == Response.successCode) {
                    $location.path("/app/home").search({type: 'homeToastInfo', msg: '审批成功'});
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
        if(CommonStringUtils.isNotTrimBlank($scope.managerApproval.memo)){
            $scope.submit = true;
            $http.post('equ_mor_apply/equMorApplyReturn', $scope.managerApproval).success(function (data) {
                if (data.code == Response.successCode) {
                    $location.path("/app/home").search({type:'homeToastInfo', msg:'退回成功'});
                }
                else {
                    modalAlert($modal, data.message);
                    $scope.submit = false;
                }
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
        }else{
            modalAlert($modal,"请填写备注");
        }

    }


}])
;