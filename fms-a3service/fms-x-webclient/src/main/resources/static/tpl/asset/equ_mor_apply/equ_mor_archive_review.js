/**
 * Created by qiaohao on 2018/6/5.
 */

//自定义repeat完成指令
app.directive('repeatFinish',function($timeout){
    return {
        restrict: 'A',
        link: function(scope,elem,attr){
            //当前循环至最后一个
            if (scope.$last === true) {

                $timeout(function () {
                    //向父控制器传递事件消息
                    scope.$emit('repeatFinishCallback');
                },100);

            }
        }
    }
});

app.controller('equ_mor_info_review_controller', ['$scope', '$http', '$modal', 'toaster','$location', function ($scope, $http, $modal, toaster,$location) {


    $scope.detailFlag = 0;
    $scope.equMorDetailsInfoReviewVo = {taskId : $location.search()['taskId'],equMorTaskNo:$location.search()['serviceId'],taskDefinitionKey:$location.search()['taskDefinitionKey']};
    $scope.equMorTaskNo = $location.search()['serviceId'];
    $scope.equMorDetails = [];
    $scope.equMorCharges = [];

    $http.get('equ_mor_apply/findEquMorDetailVosAndFileByEquMorTaskNo?equMorTaskNo=' + $scope.equMorTaskNo).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.equMorDetails = data.data;
        }
        else
            modalAlert($modal,data.message);
    }).error(function(data){
        modalAlert($modal,data);
    })

    $http.get('equ_mor_apply/findEquMorChargeImportVo?equMorTaskNo=' + $scope.equMorTaskNo).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.equMorCharges = data.data.equMorCharges;
            $scope.basBankInfoVo = data.data.basBankInfoVo;
            $scope.equMorRepayVos = data.data.equMorRepays;
            $scope.callback(data.data.equMorRepays);
        } else {
            modalAlert($modal, data.message);
        }
    }).error(function(data){
        modalAlert($modal,data);
    })


    $scope.$on('repeatFinishCallback',function(){
        if($scope.equMorDetails.length > 0 ){
            var equMorDetailId = $scope.equMorDetails[0].equMorDetailId;
            $("#a_tab_" + equMorDetailId).attr('class','selectTab');
            $("#div_tab_" + equMorDetailId).attr('class','tab-content tab-con clearfix');
            for (var i in $scope.equMorDetails) {
                var equMorDetail = $scope.equMorDetails[i];
                $("#div_tab_" + equMorDetail.equMorDetailId).find("textarea").html(JSON.stringify(equMorDetail.fileVos));
            }
            $scope.$broadcast('$initFileData', '发送' );
        }
    });

    function hideTab(){
        $("div[id*=div_tab_]").attr("class", "tab-content tab-con clearfix ng-hide");
        $("a[id*=a_tab_]").attr("class", "");
    }

    $scope.switchTab  = function(equMorDetailId){
        hideTab();
        $("#a_tab_" + equMorDetailId).attr('class','selectTab clearfix');
        $("#div_tab_" + equMorDetailId).attr('class','tab-content tab-con clearfix');
    }

    $scope.save = function(){
        if(!$scope.form.$invalid) {
            $scope.submit = true;

            $http.post('equ_mor_apply/equMorArchiveReview', $scope.equMorDetailsInfoReviewVo).success(function (data) {
                if (data.code == Response.successCode) {
                    $location.path("/app/home").search({type: 'homeToastInfo', msg: '复核成功'});
                }
                else
                    modalAlert($modal, data.message);
                $scope.submit = false;
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
        if(CommonStringUtils.isNotTrimBlank($scope.equMorDetailsInfoReviewVo.memo)) {
            $scope.submit = true;
            $http.post('equ_mor_apply/equMorApplyReturn', $scope.equMorDetailsInfoReviewVo).success(function (data) {
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
            modalAlert($modal,"请填写备注");
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
        var  aa = document.getElementById('equ_mor_archive_plan_review');
        //获取tab中ID=myHeader的tr
        if (document.getElementById('myHeader')) {
            //有就去更新tr标签
            var  bb = document.getElementById('myHeader');
            bb.innerHTML =  html;
        }else {
            //无则添加标签进去
            $('#equ_mor_archive_plan_review tbody').append(html);
        }
    };

}])
;