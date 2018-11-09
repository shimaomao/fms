/**
 * Created by qiaohao on 2018/6/1.
 */
app.controller('equ_mor_charge_import_review_controller', ['$scope', '$http', '$modal', 'toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    $scope.equMorChargeVos = [];
    $scope.equMorRepayVos = [];
    $scope.basBankInfoVo = null;
    $scope.equMorTaskNo = $location.search()['serviceId'];
    $scope.equMorChargeImportVo = {equMorTaskNo:$location.search()['serviceId'],taskId:$location.search()['taskId'],taskDefinitionKey:$location.search()['taskDefinitionKey']};


    $http.get('equ_mor_apply/findEquMorChargeImportVo?equMorTaskNo='+$scope.equMorTaskNo).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.equMorChargeVos = data.data.equMorCharges;
            $scope.equMorRepayVos = data.data.equMorRepays;
            $scope.basBankInfoVo = data.data.basBankInfoVo;
            $scope.callback(data.data.equMorRepays);
        } else {
            modalAlert($modal, data.message);
        }
    }).error(function(data){
        modalAlert($modal,data);
    })


    $scope.save = function(){

        if(!$scope.form.$invalid) {

            $scope.submit = true;
            $http.post('equ_mor_apply/equMorChargeImportReview', $scope.equMorChargeImportVo).success(function (data) {
                if (data.code == Response.successCode) {
                    $location.path("/app/home").search({type:'homeToastInfo', msg:'复核成功'});
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
        if(CommonStringUtils.isNotTrimBlank($scope.equMorChargeImportVo.memo)){
            $scope.submit = true;
            $http.post('equ_mor_apply/equMorApplyReturn', $scope.equMorChargeImportVo).success(function (data) {
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
            modalAlert($modal, "请填写备注");
        }
    }

    $scope.callback = function (data) {
        var tableData = data;
        var rentSum=0;
        for(var i=0;i<tableData.length;i++){
            rentSum = tableData[i].rent*1 + rentSum;
        }
        var html = '<tr id="myHeader" class="header">' +
            '<th>合计</th>' +
            '<td colspan="3"></td>' +
            '<td class="text-center">'+rentSum.toFixed(2)+'</td>' +
            '</tr>';

        //获取tab
        var  aa = document.getElementById('equ_mor_charge_import_plan_review');
        //获取tab中ID=myHeader的tr
        if (document.getElementById('myHeader')) {
            //有就去更新tr标签
            var  bb = document.getElementById('myHeader');
            bb.innerHTML =  html;
        }else {
            //无则添加标签进去
            $('#equ_mor_charge_import_plan_review tbody').append(html);
        }
    };

}])
;