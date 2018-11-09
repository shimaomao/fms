/**
 * Created by lijunjun on 2018-09-12.
 */
app.controller('lawsuit_task_detail_controller', ['$scope', '$http','$modal', 'toaster', '$location',function ($scope, $http,$modal,toaster,$location) {

    $scope.lawsuitTaskVo={};
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.fileType = CommonCodeUtils.basFileTypes.lawsuitRegisterFile;
    $scope.treeFileId = "lawsuit_task_register_file_tree";
    $scope.notUpload = false;
    $scope.lawsuitTaskNo = $location.search()['lawsuitTaskNo'];

    if ($scope.lawsuitTaskNo){
        $http.get('lawsuit_task/findLawsuitRegistersByTaskNo?lawsuitTaskNo='+ $scope.lawsuitTaskNo).success(function (data) {
            if (data.code == Response.successCode){
                console.log(data.data);
                $scope.lawsuitTaskVo = data.data;
                if ($scope.lawsuitTaskVo.bizFilesList){
                    // 附件赋值
                    $scope.bizFilesList = $scope.lawsuitTaskVo.bizFilesList;
                }
            }else{
                modalAlert($modal,data.message);
            }
        });
    }

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

    /**
     * 返回
     * @param status
     */
    $scope.close = function(){
        $location.path('app/postbiz_lawsuit_task_list');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.lawsuit;
    $scope.wfLogNo = $scope.lawsuitTaskNo;

}]);


