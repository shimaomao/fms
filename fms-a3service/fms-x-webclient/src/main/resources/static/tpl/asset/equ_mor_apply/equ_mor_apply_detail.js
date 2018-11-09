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

app.controller('equ_mor_apply_detail_controller', ['$scope', '$http', '$modal', 'toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    $scope.detailFlag = 0;
    $scope.equMorDetailsInfoReviewVo = {
        taskId : $location.search()['taskId']?$location.search()['taskId']:$scope.$parent.taskId,
        equMorTaskNo:$location.search()['serviceId']?$location.search()['serviceId']:$scope.$parent.serviceId,
        taskDefinitionKey:$location.search()['taskDefinitionKey']?$location.search()['taskDefinitionKey']:$scope.$parent.taskDefinitionKey
    };
    $scope.equMorTaskNo = $location.search()['equMorTaskNo']?$location.search()['equMorTaskNo']:$scope.$parent.equMorTaskNo;
    $scope.type = $location.search()['type'];
    $scope.equMorDetails = [];
    $scope.equMorCharges = [];
    $scope.equMorRepays = [];
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.httpData = true;
    $scope.notUpload = false;
    $scope.equMorChargeFileList= [];
    $http.get('equ_mor_apply/findEquMorDetailVosAndFileByEquMorTaskNo?equMorTaskNo=' + $scope.equMorTaskNo).success(function (data) {
        if (data.code == Response.successCode) {
            $scope.equMorDetails = data.data;
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

    $http.get('equ_mor_apply/findEquMorChargeImportVo?equMorTaskNo=' + $scope.equMorTaskNo).success(function (data) {
        if (data.code == Response.successCode) {
            if(data.data.equMorCharges.length > 0) {
                $scope.equMorCharges = data.data.equMorCharges;
            }
            if(data.data.equMorRepays.length > 0) {
                $scope.equMorRepays = data.data.equMorRepays;
            }
            if(data.data.basBankInfoVo != null) {
                $scope.basBankInfoVo = data.data.basBankInfoVo;
                $scope.basBankInfoVo.accBankName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.openingBank,data.data.basBankInfoVo.accBank);
            }
            $scope.equMorChargeFileList = data.data.equMorChargeFileList;

            $scope.callback($scope.equMorRepays);
        } else {
            modalAlert($modal, data.message);
        }
    }).error(function(data){
        modalAlert($modal,data);
    })

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
        //获取ta
        var  aa = document.getElementById('equ_mor_charge_import_plan');
        //获取tab中ID=myHeader的tr
        if (document.getElementById('myHeader')) {
            //有就去更新tr标签
            var  bb = document.getElementById('myHeader');
            bb.innerHTML =  html;
        }else {
            //无则添加标签进去
            $('#equ_mor_charge_import_plan tbody').append(html);
        }
    };

    $scope.initEquMorApplyTable = function(tableData){
        $scope.equMorApplytDataTableProperties = {
            //table的html id
            dataTableId:'equ_mor_apply_table',
            dataTableData: tableData,
            //table的列
            dataTableColumn: [
                {title:'客户姓名',data:'managementName',width:'20%'},
                {title:'合同编号',data:'clientContNo',width:'20%'},
                {title:'车架号',data:'margin',width:'20%'},
                {title:'车牌号',data:'factorge',width:'20%'},
                {title:'融资额',data:'managementCharge',width:'20%'},
                {title:'归档编号',data:'serviceCharge',width:'20%'},
                {title:'抵押地(注册地)',data:'oneTimeInterest',width:'20%'},
                {title:'抵押日期',data:'retentionPrice',width:'20%'},
                {title:'抵押权人(出租人)',data:'totalShouldPay',width:'20%'},
            ]

        }
        CommonDataTableUtils.createDataTableForData($scope.equMorApplytDataTableProperties);
    }


    $scope.initEquMorApplyTable([]);


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

    //返回到主页
    $scope.goBack = function () {
        $location.path("app/asset_equ_mor_apply_list");
    }



}])
;