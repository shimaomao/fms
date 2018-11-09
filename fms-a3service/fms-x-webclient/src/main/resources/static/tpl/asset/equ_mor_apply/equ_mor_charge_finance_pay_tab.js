/**
 * Created by qiaohao on 2018/6/5.
 */
app.controller('equ_mor_charge_finance_pay_tab_controller', ['$scope', '$http', '$modal', 'toaster','$location', function ($scope, $http, $modal, toaster,$location) {
    $scope.equMorCharge = {};
    $scope.equMorDetails = [];
    $scope.equMorCharge = {};
    $scope.equMorTaskNo = $location.search()['serviceId'];
    $scope.equMorChargeFinPayVo = {taskId:$location.search()['taskId'],equMorTaskNo:$scope.equMorTaskNo,taskDefinitionKey:$location.search()['taskDefinitionKey']}

    $http.get('equ_mor_apply/findFinanceTouchingVo?equMorTaskNo=' + $scope.equMorTaskNo).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.equMorDetails = data.data.equMorDetailVos;
            $scope.equMorCharge = data.data.equMorCharge;
            $scope.basBankInfoVo = data.data.basBankInfoVo;
            var management = "";
            if ($scope.equMorDetails && $scope.equMorDetails.length > 0){
                for(var index in $scope.equMorDetails){
                    if (!management){
                        $scope.management = $scope.equMorDetails[index].management;
                        break;
                    }
                }
            }
        }
        else
            modalAlert($modal,data.message);
    }).error(function(data){
        modalAlert($modal,data);
    })

    $scope.save = function(){
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.post('equ_mor_apply/financePay', $scope.equMorChargeFinPayVo).success(function (data) {
                if (data.code == Response.successCode) {
                    $location.path("/app/home").search({type: 'homeToastInfo', msg: '付款成功'});
                } else {
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
        if(CommonStringUtils.isNotTrimBlank($scope.equMorChargeFinPayVo.memo)){
            $scope.submit = true;
            $http.post('equ_mor_apply/equMorApplyReturn', $scope.equMorChargeFinPayVo).success(function (data) {
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