/**
 * Created by ningyangyang on 2018/9/18.
 *  收车委派与登记
 */
app.controller('retrieve_cars_task_register_controller',['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout',function($scope, $http, $modal, toaster,$compile,$location,$timeout){

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.retrieveCarTaskNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    $scope.retrieveCarsTask = {};
    $scope.retrieveResultList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.retrieveResult);
    //获取收车任务详情
    $scope.getData = function () {
        $http.get('retrieve_cars_task/findRetrieveCarsTaskVoByTaskNo?retrieveCarTaskNo='+$scope.retrieveCarTaskNo).success(function (data) {
            if (data.code == Response.successCode){
                $scope.retrieveCarsTask = data.data;
                if(!$scope.retrieveCarsTask.retrieveResult){
                    $scope.retrieveCarsTask.retrieveResult = '';
                }
            } else
                modalAlert($modal,data.message);
        }).error(function(data){
            modalAlert($modal,data);
        })
    }
    $scope.getData();
    
    //提交登记信息
    $scope.save = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            if($scope.retrieveCarsTask.notUpload){
                modalAlert($modal,$scope.retrieveCarsTask.notUploadInfo);
                $scope.submit = false;
                return false;
            }
            $scope.retrieveCarsTask.taskId = $scope.taskId;
            $scope.retrieveCarsTask.retrieveCarTaskNo = $scope.retrieveCarTaskNo;
            $http.post('retrieve_cars_task/retrieveCarsTaskRegister', $scope.retrieveCarsTask).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("/app/home").search({"type":"homeToastInfo",'msg':'委派与登记成功'});
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
        }else{
            $scope.formValidate = true;
            remindMsg($timeout,toaster);
        }
    }

    //暂存登记信息
    $scope.modify = function () {
            $scope.submit = true;
            //$scope.retrieveCarsTask.taskId = $scope.taskId;
            //$scope.retrieveCarsTask.retrieveCarTaskNo = $scope.retrieveCarTaskNo;
            $scope.retrieveCarsTask.flag = CommonCodeUtils.yesNoFlag.yes;
            $http.post('retrieve_cars_task/retrieveCarsTaskRegister', $scope.retrieveCarsTask).success(function (data) {
                if (data.code == Response.successCode){
                    toaster_info("暂存成功！",toaster);
                    $scope.getData();
                }
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
    }

    //返回
    $scope.goBack = function () {
        $location.path('/app/home')
    }

    //合同详情
    $scope.contractDetails = function () {
        var id = $scope.retrieveCarsTask.contNo;
        var url = 'app.prebiz_apply_input_detail?applyNo=' + $scope.retrieveCarsTask.applyNo
            + '&contNo=' +$scope.retrieveCarsTask.contNo
            + '&applyType=' +$scope.retrieveCarsTask.applyType
            + '&type=contract'
            + '&contractDate=' +$scope.contractDate
            + '&bizStatus=' +$scope.bizStatus
            + '&isTab=true';
        var title = '合同详情';
        var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
        if(window.parent.addTab){
            window.parent.addTab(html);
        }
    }
    //借阅车钥匙
    $scope.borrowCarKey = function () {
        if($scope.retrieveCarsTask.carKeyStatus == '3'){
            var id = $scope.retrieveCarsTask.retrieveCarId;
            var url = 'app.original_file_borrow_detail?bizCode='+ $scope.retrieveCarsTask.contNo
                + '&bizCodeType=' + $scope.retrieveCarsTask.bizCodeType
                + '&fileRecordNo=' + $scope.retrieveCarsTask.fileRecordNo
                + '&origFileType=' + $scope.retrieveCarsTask.origFileType
                + '&skipType=' + "true";
            var title = '借阅申请';
            var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
            if(window.parent.addTab){
                window.parent.addTab(html);
            }
        }else{
            modalAlert($modal,'车钥匙未归档');
        }
    }
    //归还车钥匙
    $scope.backCarKey = function () {
        if($scope.retrieveCarsTask.carKeyStatus == '6'){
            var id = $scope.retrieveCarsTask.retrieveCarId;
            var url = 'app.original_file_borrow_back_send_detail?borrowTaskNo='+$scope.retrieveCarsTask.borrowTaskNo
                + '&skipType=' + "true";
            // +'&taskId='+$scope.retrieveCarsTask.borrowBackTaskNo
            var title = '借阅归还申请';
            var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
            if(window.parent.addTab){
                window.parent.addTab(html);
            }
        }else{
            modalAlert($modal,'车钥匙不是借出状态');
        }
    }
    //委托书模板下载
    $scope.downLoadLetter = function () {
        $http.post('retrieve_cars_task/downLoadLetter', {'retrieveCarTaskNo':$scope.retrieveCarTaskNo}).success(function (data) {
            if (data.code == Response.successCode){
                //pdf生成
                console.log(data.data);
                window.parent.open('file/downloadFile?fileCompletePath='+data.data.filePath+'&fileName='+data.data.fileName);
            }else{
                modalAlert($modal,data.message);
            }
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    }

    //查看逾期详情
    $scope.overdueDetail = function () {
        //取得逾期客户id
        $http.get('lawsuit_task/findOverdueCstmIdByOverdueContId?overdueContId='+$scope.retrieveCarsTask.overdueContId).success(function (data) {
            if(data.code == Response.successCode){
                var overdueCstmId = data.data;
                if(CommonStringUtils.isTrimBlank(overdueCstmId)){
                    modalAlert($modal,'该客户未发生过逾期');
                } else {
                    var id = overdueCstmId;
                    var url = 'app.postbiz_overdue_cstm_modify?overdueCstmId=' + overdueCstmId
                        + '&detail=true&isTab=true';
                    var title = '逾期详情';
                    var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
                    if(window.parent.addTab){
                        window.parent.addTab(html);
                    }
                }
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };

    //选择付款银行信息
    $scope.selectBasBankInfo = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_bank_info_select_controller',
            resolve:{
                selectBank:function () {
                    return { organizationType:null}
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.retrieveCarsTask.recAccBranch = data.accBranchBank;
                $scope.retrieveCarsTask.recAccountName = data.accountName;
                $scope.retrieveCarsTask.recAccountNo = data.accountNo;
            }
        },function(){
        });
    }

}])