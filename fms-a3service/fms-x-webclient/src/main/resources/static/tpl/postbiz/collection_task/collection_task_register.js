/**
 * Created by lijunjun on 2018-09-01.
 */
app.controller('collection_task_register_controller', ['$scope', '$http','$modal','toaster', '$location','$timeout',function ($scope, $http,$modal,toaster,$location,$timeout) {

    $scope.collectionTaskVo={};
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.fileType = CommonCodeUtils.basFileTypes.collectionFile;
    $scope.treeFileId = "collection_task_register_file_tree";
    $scope.notUpload = false;
    $scope.applyType = $location.search()['applyType'];
    $scope.collectionTaskNo = $location.search()['serviceId'];

    $http.get('collection_task/findCollectionTasksByTaskNo?collectionTaskNo='+ $scope.collectionTaskNo).success(function (data) {
        if (data.code == Response.successCode){
            $scope.collectionTaskVo = data.data;
            $scope.collectionTaskVo.remark = "";
            $scope.cstmContactList = $scope.collectionTaskVo.cstmAddrInfoVoList;
            $scope.collectionTaskVo.collectionLevelName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.collectionLevel, $scope.collectionTaskVo.collectionLevel);
            $scope.collectionTaskVo.dispatchTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.dispatchType, $scope.collectionTaskVo.dispatchType);
            if ($scope.collectionTaskVo.bizFilesList){
                $scope.bizFilesList = $scope.collectionTaskVo.bizFilesList;
            }
            initDetailTable();
        }else{
            modalAlert($modal,data.message);
        }
    });

    /*出租人地址信息*/
    function initDetailTable(){
        //参数配置
        $scope.dataTableProperties= {
            //table的html id
            dataTableId:'cstm_contact_table',
            dataTableColumn:[
                {title:'申请编号',data:'applyNo'},
                {title:'联系人姓名',data:'name'},
                {title:'联系人关系',data:'relationType',
                    render:function (data, type, row, meta) {
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.relation, data);
                    }
                },
                {title:'联系人号码',data:'mobileNo'},
                {title:'地址类型',data:'addrType',
                    render:function (data, type, row, meta) {
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.addressType, data);
                    }
                },
                {title:'联系人地址',data:'resideAddr'},
            ],
            dataTableData: $scope.cstmContactList
        }
        CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
    }

    $scope.getDispatchUserName = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_user/sys_user_list_select.html'+getCacheTime(),
            controller: 'sys_user_list_select_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {
            if(data){
                $scope.collectionTaskVo.dispatchUserName = data.userName;
                $scope.collectionTaskVo.dispatchUser = data.user;
            }
        },function(){
        });
    };

    /**
     * 上门催收登记暂存
     */
    $scope.collectionRegisterTemporary = function () {
        $scope.submit = true;
        $scope.collectionTaskVo.bizFilesList = $scope.bizFilesList;
        $http.post('collection_task/collectionRegisterTemporary', $scope.collectionTaskVo).success(function (data) {
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
     * 上门催收登记提交
     */
    $scope.collectionRegisterSave = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;

            // 判断附件是否上传
            if($scope.notUpload){
                modalAlert($modal,$scope.notUploadInfo);
                $scope.submit = false;
                return false;
            }
            $scope.collectionTaskVo.taskId = $location.search()['taskId'];
            $scope.collectionTaskVo.bizFilesList = $scope.bizFilesList;
            console.log($scope.bizFilesList);
            $http.post('collection_task/collectionApprovalAgree', $scope.collectionTaskVo).success(function (data) {
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

    //查看逾期详情
    $scope.overdueDetail = function () {
        //取得逾期客户id
        var overdueCstmId = $scope.collectionTaskVo.overdueCstmId;
        if(CommonStringUtils.isTrimBlank(overdueCstmId)){
            modalAlert($modal,'请选择逾期客户');
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
    };

    // 催收函生成
    $scope.collectionLetterDownload = function () {
        $http.post('collection_task/collectionLetterDownload', {'collectionTaskNo':$scope.collectionTaskNo}).success(function (data) {
            if (data.code == Response.successCode){
                //pdf生成
                window.parent.open('file/downloadFile?fileCompletePath='+data.data.filePath+'&fileName='+data.data.fileName);
            }else{
                modalAlert($modal,data.message);
            }
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    };

    // 委托书生成
    $scope.proxyDownload = function () {
        $http.post('collection_task/proxyDownload', {'collectionTaskNo':$scope.collectionTaskNo}).success(function (data) {
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
    };

    // 律师函生成
    $scope.lawyerLetterDownload = function () {
        $http.post('collection_task/lawyerLetterDownload', {'collectionTaskNo':$scope.collectionTaskNo}).success(function (data) {
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
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $location.path('app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.collectionTask;
    if ($location.search()['serviceId']){
        $scope.wfLogNo = $location.search()['serviceId'];
    }

}]);


