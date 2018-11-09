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

app.controller('equ_mor_archive_tab_controller', ['$scope', '$http', '$modal', 'toaster','$location', function ($scope, $http, $modal, toaster,$location) {


    $scope.equMorArchiveVo = {taskId : $location.search()['taskId'],taskDefinitionKey:$location.search()['taskDefinitionKey'],equMorTaskNo:$location.search()['serviceId']};

    $scope.equMorTaskNo = $location.search()['serviceId'];

    $scope.equMorDetails = [];

    $scope.processInstanceType = $location.search()['processInstanceType'];
    $scope.returnButton = $scope.processInstanceType == CommonCodeUtils.actRuTaskApprovalUrl.equ_mortgage.name;

    $http.get('equ_mor_apply/findEquMorDetailVosAndFileByEquMorTaskNo?equMorTaskNo=' + $scope.equMorTaskNo).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.equMorDetails = data.data;
            $scope.management = "";
            for(var i in $scope.equMorDetails){
                var equMorDetail = $scope.equMorDetails[i];
                if(CommonObjectUtils.isNotExist(equMorDetail.mortgageAddr)){
                    equMorDetail.mortgageAddr = equMorDetail.groupDistrict;
                }
                if(CommonObjectUtils.isNotExist(equMorDetail.mortgagee)){
                    equMorDetail.mortgagee = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.management,equMorDetail.management);
                }
                if (!$scope.management){
                    $scope.management = $scope.equMorDetails[i].management;
                }
            }
        } else
            modalAlert($modal,data.message);
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
        $("#a_tab_" + equMorDetailId).attr('class','selectTab');
        $("#div_tab_" + equMorDetailId).attr('class','tab-content tab-con clearfix');
    }

    $scope.save = function(){

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            var check = true;

            for (var i in $scope.equMorDetails) {
                var equMorDetail = $scope.equMorDetails[i];
                if (CommonObjectUtils.isNotExist(equMorDetail.mortgageAddr)) {
                    modalAlert($modal, "请填写" + equMorDetail.mainContNo + "的抵押地(注册地)");
                    check = false;
                    break;
                }
                if (CommonObjectUtils.isNotExist(equMorDetail.mortgageDate)) {
                    modalAlert($modal, "请选择" + equMorDetail.mainContNo + "的抵押日期");
                    check = false;
                    break;
                }
                if (CommonObjectUtils.isNotExist(equMorDetail.mortgagee)) {
                    modalAlert($modal, "请填写" + equMorDetail.mainContNo + "的抵押权人(出租人)");
                    check = false;
                    break;
                }

                if(equMorDetail.notUpload){
                    modalAlert($modal, "请上传" + equMorDetail.mainContNo + "合同号的" + equMorDetail.notFileTypeName + "类型文件");
                    check = false;
                    break;
                }

                equMorDetail.memo = $scope.memo;

            }

            if(check) {
                $scope.equMorArchiveVo.equMorDetailArchiveVos = $scope.equMorDetails;
                $http.post('equ_mor_apply/equMorArchive', $scope.equMorArchiveVo).success(function (data) {
                    if (data.code == Response.successCode) {
                        $location.path("/app/home").search({type:'homeToastInfo', msg:'上传资料成功'});
                    }
                    else
                        modalAlert($modal, data.message);
                    $scope.submit = false;
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
        if(CommonStringUtils.isNotTrimBlank($scope.equMorArchiveVo.memo)){
            $scope.submit = true;
            $http.post('equ_mor_apply/equMorApplyReturn', $scope.equMorArchiveVo).success(function (data) {
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