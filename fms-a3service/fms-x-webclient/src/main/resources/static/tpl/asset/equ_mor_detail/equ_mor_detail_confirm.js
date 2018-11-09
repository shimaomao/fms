/**
 * Created by ningyangyang on 2018-05-30.
 * 解抵押确认
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

app.controller('equ_mor_detail_confirm_controller', ['$scope', '$http','$modal','toaster','$location','$compile',function ($scope, $http,$modal,toaster,$location,$compile) {

    $scope.equMorDetail={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.equRelTaskNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];

    init();
    function init(){
        $http.get('equ_mor_detail/findEquMorDetailVoList?equRelTaskNo='+$scope.equRelTaskNo).success(function (data) {
            $scope.equMorDetail = data.data;
            $scope.equMorDetailList = data.data.equMorDetailVoList
            console.log($scope.equMorDetailList);
            //参数配置
            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'equ_mor_detail_table',
                //table的列
                dataTableColumn: [
                    //defaultDetail('equMorTaskNo','detailEquMorDetail','资方抵押任务号','20%',$compile,$scope),
                    {title:'合同编号',data:'mainContNo',width:'20%'},
                    {title:'出租人',data:'lessor',width:'20%'},
                    {title:'承租人',data:'lessee',width:'20%'},
                    {title:'车牌号',data:'vehicleLicenseNo',width:'20%'},
                    {title:'车架号',data:'vinNo',width:'20%'},
                    {title:'差额(元)',data:'reliefDifference',width:'20%'},
                ],
                dataTableData:data.data.equMorDetailVoList,
            }

            //创建dataTable
            $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties,$scope);
        })
    }

    $scope.$on('repeatFinishCallback',function(){
        // if($scope.equMorDetailList.length > 0 ){
        //     var equMorDetailId = $scope.equMorDetailList[0].equMorDetailId;
        //     $("#a_tab_" + equMorDetailId).attr('class','selectTab');
        //     $("#div_tab_" + equMorDetailId).attr('class','tab-content tab-con');
        // }
        if($scope.equMorDetailList.length > 0 ){
            var equMorDetailId = $scope.equMorDetailList[0].equMorDetailId;
            $("#a_tab_" + equMorDetailId).attr('class','selectTab');
            $("#div_tab_" + equMorDetailId).attr('class','tab-content tab-con clearfix');
            for (var i in $scope.equMorDetailList) {
                var equMorDetail = $scope.equMorDetailList[i];
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



    /**
     * 审核通过
     */
    $scope.save = function () {
        if(!$scope.form.$invalid){
            $scope.submit = true;
            $scope.equMorDetail.equRelTaskNo = $scope.equRelTaskNo;
            $scope.equMorDetail.taskId = $scope.taskId;
            for(var i in $scope.equMorDetailList){
                var equMorDetailVo = $scope.equMorDetailList[i];
                console.log(equMorDetailVo)

                // if(CommonObjectUtils.isNotExist(equMorDetail.commonBizFilesVo)||Object.keys(equMorDetail.commonBizFilesVo.bizFilesInfo).length <= 0 ){
                //     modalAlert($modal,"请上传" + equMorDetail.mainContNo +"合同的附件信息");
                //     $scope.submit = false;
                //     return false;
                // }
                if(equMorDetailVo.notUpload){
                    modalAlert($modal, "请上传" + equMorDetailVo.mainContNo + "合同号的" + equMorDetailVo.notFileTypeName + "类型文件");
                    $scope.submit = false;
                    return false;
                }
               // equMorDetail.fileVos = JSON.parse(fileVos);
            }
            $scope.equMorDetail.equMorDetailVoList = $scope.equMorDetailList
            $http.put('equ_mor_detail/approvalConfirm',$scope.equMorDetail).success(function(data) {
                if (data.code == Response.successCode){
                    //modalAlert($modal, '资方解抵押成功');
                    $location.path("app/home").search({"type": 'homeToastInfo', "msg":'资方解抵押成功'});
                }else{
                    modalAlert($modal, data.message);
                    $scope.submit = false;
                }
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
        $location.path('app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.relief;
    $scope.wfLogNo = $scope.equRelTaskNo;

}]);



