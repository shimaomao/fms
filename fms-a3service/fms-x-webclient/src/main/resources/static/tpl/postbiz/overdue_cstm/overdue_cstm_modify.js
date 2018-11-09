/**
 * Created by lijunjun on 2018-05-16.
 */
app.controller('overdue_cstm_modify_controller', ['$scope', '$http','$modal','toaster','$location','$timeout',function ($scope, $http,$modal,toaster,$location,$timeout) {

    // 从其他画面跳转到的弹出信息显示
    $scope.type = $location.search()['type'];
    $scope.msg = $location.search()['msg'];
    if ($scope.type == 'submit') {
        toaster_success($scope.msg, toaster);
    }
    //被其他画面打开新页签时，控制返回等上层按钮是否显示的flag
    $scope.btnFlag = true; //默认为显示
    if($location.search()['isTab']){
        $scope.btnFlag = false;
    }
    $timeout(function () {
        var msg = $location.search()['msg'];
        if(CommonObjectUtils.isExist(msg)) {
            toaster_success(msg, toaster);
            $location.search({msg:null});
        }
    })

    $scope.overdueCstmId = $location.search()['overdueCstmId'];
    $scope.overdueContId = $location.search()['overdueContId'];
    $scope.certifNo = $location.search()['certifNo'];
    $scope.contNo = $location.search()['contNo'];
    $scope.overdueContNoList = [];// 逾期合同List
    $scope.overdueContNoFlag = '0';// 控制显示当前是否有合同逾期
    console.log('contNo',$scope.contNo);
    $scope.detail = $location.search()['detail'];

    $scope.getData = function () {
        $http.get('overdue_cstm/findOverdueCstmByOverdueCstmId?overdueCstmId='+$scope.overdueCstmId).success(function (data) {
            if(data.code == Response.successCode){
                $scope.cstmData = data.data;
                $scope.cstmData.overdueTelRegisterVoList = $scope.cstmData.overdueTelRegisterVoList==null?[]:$scope.cstmData.overdueTelRegisterVoList;
                $scope.cstmData.collectionTaskVoList = $scope.cstmData.collectionTaskVoList==null?[]:$scope.cstmData.collectionTaskVoList;
                $scope.cstmData.retrieveCarsTaskVoList = $scope.cstmData.retrieveCarsTaskVoList==null?[]:$scope.cstmData.retrieveCarsTaskVoList;
                $scope.cstmData.lawsuitTaskVoList = $scope.cstmData.lawsuitTaskVoList==null?[]:$scope.cstmData.lawsuitTaskVoList;

                if ($scope.cstmData && $scope.cstmData.overdueContVoList){
                    for (var i in $scope.cstmData.overdueContVoList){
                        if ($scope.cstmData.overdueContVoList[i].overdueFlag == '1'){
                            // 如果合同逾期状态为1：逾期，push到list中
                            $scope.overdueContNoList.push($scope.cstmData.overdueContVoList[i]);
                        }
                    }
                }
                if ($scope.overdueContNoList && $scope.overdueContNoList.length > 0){
                    $scope.overdueContNoFlag = '1';// 如果当前有合同逾期，则设定flag为1
                }
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };
    $scope.getData();
    //电话登记
    $scope.telRegist = function (item) {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/overdue_cstm/overdue_cstm_save.html'+getCacheTime(),
            controller: 'overdue_cstm_save_controller',
            resolve:{
                registData: function () {
                    return {
                        "overdueCstmId": $scope.overdueCstmId,
                        "certifNo": item.certifNo,
                        "overdueCstmTelId": item.overdueCstmTelId
                    }
                }
            }
        });
        rtn.result.then(function (data) {
            if(data){
                $scope.getData();
            }
        },function(){

        });
    };
    //查看当前逾期总额
    $scope.overdueSum = function (num,type) {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/overdue_cstm/overdue_sum.html'+getCacheTime(),
            controller: 'overdue_sum_controller',
            resolve:{
                paramsData: function () {
                    if(type == 1){
                        return {
                            "overdueCstmId": num
                        }
                    }else{
                        return {
                            "contNo": num
                        }
                    }
                }
            }
        });
        rtn.result.then(function (data) {

        },function(){

        });
    };
    //当前销售未还本金
    $scope.overdueSales = function (num,type) {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/overdue_cstm/overdue_sales.html'+getCacheTime(),
            controller: 'overdue_sales_controller',
            resolve:{
                paramsData: function () {
                    if(type == 1){
                        return {
                            "overdueCstmId": num
                        }
                    }else{
                        return {
                            "contNo": num
                        }
                    }
                }
            }
        });
        rtn.result.then(function (data) {

        },function(){

        });
    };
    //当前财务未还本金
    $scope.overdueFinance = function (num,type) {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/overdue_cstm/overdue_finance.html'+getCacheTime(),
            controller: 'overdue_finance_controller',
            resolve:{
                paramsData: function () {
                    if(type == 1){
                        return {
                            "overdueCstmId": num,
                            'contNo':$scope.contNo
                        }
                    }else{
                        return {
                            "contNo": num,
                        }
                    }
                }
            }
        });
        rtn.result.then(function (data) {

        },function(){

        });
    };

    //合同详情
    $scope.detailContract = function (contNo,applyNo,applyType) {
        $location.path('/app/prebiz_apply_input_detail').search({
            'contNo': contNo,
            'applyNo': applyNo,
            'applyType': applyType,
            'overdueCstmId':$scope.overdueCstmId,
            'type': 'overdue'
        });
    };

    $scope.changeUser = function(type){
        console.log(type);
    };

    //返回
    $scope.goBack = function () {
        $location.path('/app/postbiz_overdue_cstm_list')
    };

    // 加入黑名单
    $scope.addBlacklist = function () {
        var registerType = "2"; //登记类型：逾期客户
        // 获取客户中的全部申请编号集合
        var overdueContVoList = $scope.cstmData.overdueContVoList;
        var applyNoList = [];
        for (var i = 0; i < overdueContVoList.length; i++) {
            applyNoList.push(overdueContVoList[i].applyNo);
        }
        var basBlacklistVo = {"registerType": registerType, "applyNoList": applyNoList};
        $http.post('bas_blacklist/saveBasBlacklistByApplyNo',basBlacklistVo).success(function (result) {
            if (result.code == Response.successCode){
                toaster_success("加入黑名单成功！",toaster);
            }else{
                modalAlert($modal,result.message);
            }
        }).error(function (result) {
            modalAlert($modal,result);
        })
    }

    //收车
    $scope.retrieveCar = function (data) {
        $scope.retrieveCarsTask = {}
        $scope.retrieveCarsTask.contNo = data.contNo;
        $http.post('retrieve_cars_task/checkRetrieveCarsTask',$scope.retrieveCarsTask).success(function (result) {
            $scope.retrieveCarsTask1 = result.data;
            if(isNotUndefinedNull($scope.retrieveCarsTask1))
                modalAlert($modal,"该任务正在进行收车任务，请等待收车结束后再申请");
            else
                $location.path('app/postbiz_retrieve_cars_task_launch').search({contNo:data.contNo,flag:CommonCodeUtils.yesNoFlag.yes,overdueCstmId:$scope.overdueCstmId,overdueContId:data.overdueContId,certifNo:$scope.certifNo});        })

    }

    // 上门催收
    $scope.collectionTask = function () {
        $scope.collectionTaskVo = {overdueCstmId:$scope.overdueCstmId};
        $http.post('collection_task/isCollectionTaskExit', $scope.collectionTaskVo).success(function (data) {
            if (data.code == Response.successCode){
                var collectionTaskNo;
                if (data.data){
                    collectionTaskNo = data.data;
                }
                $location.path('app/postbiz_collection_task_save').search({overdueCstmId:$scope.overdueCstmId, overdueContId:$scope.overdueContId, type:'overdueCstm', collectionTaskNo:collectionTaskNo});
            } else {
                modalAlert($modal,data.message);
            }
        });
    };

    // 诉讼
    $scope.lawsuitTask = function (data) {
        $location.path('app/postbiz_lawsuit_task_save').search({overdueCstmId:$scope.overdueCstmId, overdueContId:data.overdueContId,type:'overdueCstm'});
    };

}]);
app.directive('buttonClick', ['$parse',function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attr) {
            var $this;
            $(element).click(function (e) {
                $this = $(this).next();
                if($this.css('display') == 'none'){
                    $this.css({'display':'block'});
                }else{
                    $this.css({'display':'none'});
                }
                $(this).parent().siblings().find('.dropdown-menu').css({'display':'none'});
                e.stopPropagation();
                $(document).click(function () {
                    $this.css({'display':'none'});
                });
            });
        }
    };
}]);
