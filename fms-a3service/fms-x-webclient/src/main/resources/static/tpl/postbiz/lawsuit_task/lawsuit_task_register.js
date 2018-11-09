/**
 * Created by lijunjun on 2018-09-12.
 */
app.controller('lawsuit_task_register_controller', ['$scope', '$http','$modal', 'toaster', '$location','$timeout',function ($scope, $http,$modal,toaster,$location,$timeout) {

    $scope.lawsuitTaskVo={};
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.fileType = CommonCodeUtils.basFileTypes.lawsuitRegisterFile;
    $scope.treeFileId = "lawsuit_task_register_file_tree";
    $scope.notUpload = false;
    $scope.lawsuitTaskVo.lawsuitRegisterVoList = [];

    $scope.checkFlag1 = false;
    $scope.checkFlag2 = false;
    $scope.checkFlag3 = false;

    $scope.valiFlag = false;

    $scope.caseStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.caseStatus);
    $scope.lawsuitTaskNo = "";
    if ($location.search()['serviceId']){
        $scope.lawsuitTaskNo = $location.search()['serviceId'];
    }

    if ($scope.lawsuitTaskNo){
        $http.get('lawsuit_task/findLawsuitRegistersByTaskNo?lawsuitTaskNo='+ $scope.lawsuitTaskNo).success(function (data) {
            if (data.code == Response.successCode){
                console.log(data.data);
                $scope.lawsuitTaskVo = data.data;
                if ($scope.lawsuitTaskVo.lawsuitRegisterVoList && $scope.lawsuitTaskVo.lawsuitRegisterVoList.length > 0){
                    $scope.lawsuitTaskVo.lawsuitRegisterVoList = $scope.lawsuitTaskVo.lawsuitRegisterVoList;
                }
                if ($scope.lawsuitTaskVo.bizFilesList){
                    // 附件赋值
                    $scope.bizFilesList = $scope.lawsuitTaskVo.bizFilesList;
                }
                $scope.lawsuitTaskVo.remark = "";
            }else{
                modalAlert($modal,data.message);
            }
        });
    }

    /**
     * 诉讼任务登记暂存
     */
    $scope.registerTemporary = function () {
            $scope.submit = true;
            $scope.lawsuitTaskVo.bizFilesList = $scope.bizFilesList;
            $http.post('lawsuit_task/registerTemporary', $scope.lawsuitTaskVo).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path('app/home');
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
    }

    /**
     * 风控任务登记提交
     */
    $scope.registerSave = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;

            // 判断附件是否上传
            if($scope.notUpload){
                modalAlert($modal,$scope.notUploadInfo);
                $scope.submit = false;
                return false;
            }
            if ($location.search()['taskId']){
                $scope.lawsuitTaskVo.taskId = $location.search()['taskId'];
            }
            $scope.lawsuitTaskVo.bizFilesList = $scope.bizFilesList;
            $http.post('lawsuit_task/registerSave', $scope.lawsuitTaskVo).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path('app/home');
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

    //增加诉讼跟进信息
    $scope.addList = function () {
        var cell = {
            court:'',
            caseRecordNo:'',
            caseStatus:'',
            caseDate:'',
            judge:'',
            judgeContactNo:'',
            caseIntroduce:'',
            lawsuitAmount:0,
            judgmentAmount:0,
            executeCaseNo:''
        };
        cell.flag = true;
        $scope.lawsuitTaskVo.lawsuitRegisterVoList.push(cell);
    };

    //删除诉讼跟进信息
    $scope.delList = function (item,index) {
        $scope.lawsuitTaskVo.lawsuitRegisterVoList.splice(index,1);
    };

    //合同详情
    $scope.contractDetails = function () {
        var id = $scope.lawsuitTaskVo.contNo;
        var url = 'app.prebiz_apply_input_detail?applyNo=' + $scope.lawsuitTaskVo.applyNo
            + '&contNo=' +$scope.lawsuitTaskVo.contNo
            + '&applyType=' +$scope.lawsuitTaskVo.applyType
            + '&type=lawsuit'
            + '&contractDate=' +$scope.contractDate
            + '&bizStatus=' +$scope.bizStatus
            + '&isTab=true';
        var title = '合同详情';
        var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
        if(window.parent.addTab){
            window.parent.addTab(html);
        }
    }

    //查看逾期详情
    $scope.overdueDetail = function () {
        //取得逾期客户id
        $http.get('lawsuit_task/findOverdueCstmIdByOverdueContId?overdueContId='+$scope.lawsuitTaskVo.overdueContId).success(function (data) {
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

    // $scope.checkForm1 = function () {
    //     if(isNotUndefinedNull($scope.lawsuitTaskVo.lawsuitEndReason) || isNotEmpty($scope.lawsuitTaskVo.lawsuitEndReason)){
    //         $scope.checkFlag1 = false;
    //     }
    //     if(isEmpty($scope.lawsuitTaskVo.lawsuitEndReason)||isUndefinedNull($scope.lawsuitTaskVo.lawsuitEndReason)){
    //         $scope.checkFlag1 = true;
    //     }
    // }
    //
    // $scope.checkForm2 = function () {
    //     if(isNotUndefinedNull($scope.lawsuitTaskVo.lawsuitEndDate)){
    //         $scope.checkFlag2 = false;
    //     }
    //     if(isUndefinedNull($scope.lawsuitTaskVo.lawsuitEndDate)){
    //         $scope.checkFlag2 = true;
    //     }
    // }
    //
    // $scope.checkForm3 = function () {
    //     if(isNotUndefinedNull($scope.lawsuitTaskVo.lawsuitEndRemark)){
    //         $scope.checkFlag3 = false;
    //     }
    //     if(isUndefinedNull($scope.lawsuitTaskVo.lawsuitEndRemark)){
    //         $scope.checkFlag3 = true;
    //     }
    // }

    /**
     * 返回
     * @param status
     */
    $scope.close = function(){
        $location.path('app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.lawsuit;
    if ($location.search()['serviceId']){
        $scope.wfLogNo = $location.search()['serviceId'];
    }

}]);


