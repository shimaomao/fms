app.controller('basic_change_approval_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$interval', function ($scope, $http, $modal, toaster, $compile, $location, $interval) {
    $scope.applyType = $location.search()['serviceType'];
    $scope.taskId = $location.search()['taskId'];
    $scope.applyNo = $location.search()['serviceId'];
    //流程任务key
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];
    $scope.applyDisabled = true;

    if($scope.taskDefinitionKey == 'change_task_review'){
        $scope.disabled = true;
    }else{
        $scope.disabled = false;
    }
    $scope.$on('riskDataToFather',function (e,data) {
        $scope.riskData = data;
    });
    $scope.formValidate = false;
    $scope.submit = false;

    //附件对象
    $scope.fileObj = {
        bizFilesList:[],
        notUpload: false,
        notUploadInfo:'',
        notFileType:'',
        notFileTypeName:'',
        fileType:''
    };

    //附件类型
    if($scope.applyType == 1){
        $scope.fileObj.fileType = $scope.$root.basFileTypes.perApplyFile;
    }else{
        $scope.fileObj.fileType = $scope.$root.basFileTypes.compApplyFile;
    }

    //获取数据
    $scope.getData = function () {
        $http.get('apply_risk/findApplyRiskInit?applyNo='+$scope.applyNo+'&flag=change').success(function (data) {
            if(data.code == Response.successCode){
                $scope.riskData = data.data;
                $scope.riskData.taskId = $location.search()['taskId'];
                $scope.riskData.taskNo =  $location.search()['serviceId'];
                //向子控制器广播数据
                $scope.$broadcast('riskDataToSon', $scope.riskData );
                console.log($scope.riskData);

            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };
    //获取附件和变更信息
    $scope.getInputVo = function(){
        $http.get('change_lessee_task/findApplyInputVoByApplyNo?applyNo='+$scope.applyNo).success(function(data){
            if(data.code == Response.successCode){
                $scope.applyInput = data.data;
                $scope.fileObj.bizFilesList = $scope.applyInput.bizFilesList;
                $scope.contNo = $scope.applyInput.contNo;
                $scope.applyNoParams =  $scope.applyInput.changeLesseeTask.applyNo;
                //向子控制器广播数据
                $scope.$broadcast('applyInputToSonSecond', $scope.applyInput);
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };
    $scope.getData();
    $scope.getInputVo();
    //接收子控制器的数据
    $scope.$on('riskDataToFather',function (e,data) {
        $scope.riskData = $.extend(true,$scope.riskData,data);
        //向子控制器广播数据
        $scope.$broadcast('riskDataToSon', $scope.riskData );
    });

    $scope.$on('fileInfoToFather',function (e,data) {
        $scope.fileInfo = data;
    });

    //提交
    $scope.save = function () {
        $scope.url = null;
        if($scope.taskDefinitionKey == 'change_task_approve'){
            $scope.url = 'apply_risk/saveApplyRisk';
        }else if($scope.taskDefinitionKey == 'change_task_review'){
            $scope.url = 'change_lessee_task/submitRiskApprove';
        }
        if(!$scope.form.$invalid){
            $scope.submit = true;
            $scope.riskData.saveFlag = CommonCodeUtils.yesNoFlag.yes;
            $scope.riskData.isChangeLessee = CommonCodeUtils.yesNoFlag.yes;
            $http.post($scope.url,$scope.riskData).success(function (data) {
                if(data.code == Response.successCode){
                    console.log(data);
                    $location.path("/app/home").search({type:'homeToastInfo', msg:'审批成功'});
                }else{
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function (err) {
                modalAlert($modal,err);
            });
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    //暂存
    $scope.modify = function () {
        $scope.submit = true;
        $scope.riskData.saveFlag = CommonCodeUtils.yesNoFlag.no;
        $http.post('apply_risk/saveApplyRisk',$scope.riskData).success(function (data) {
            if(data.code == Response.successCode){
                toaster_info("暂存成功！",toaster);
                $scope.getData();
            }else{
                modalAlert($modal,data.message);
            }
            $scope.submit = false;
        }).error(function (err) {
            $scope.submit = false;
            modalAlert($modal,err);
        });
    };

    //退回
    $scope.sendBack = function () {
        $scope.submit = true;
        if(!$scope.riskData.memo){
            toaster_info('请输入备注',toaster);
            $scope.submit = false;
            return false;
        }
        $http.post('change_lessee_task/sendBack',$scope.riskData).success(function (data) {
            $scope.submit = false;
            if(data.code == Response.successCode){
                console.log(data);
                $location.path("/app/home").search({type:'homeToastInfo', msg:'退回成功'});
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            $scope.submit = false;
            modalAlert($modal,err);
        });
    };

    //百度/天眼查
    $scope.telCheck = function (type) {
        if(type == 1){
            window.open("https://www.baidu.com/",'_blank');
        }else{
            window.open("https://www.tianyancha.com/",'_blank');
        }
    };

    //返回
    $scope.goBack = function () {
        if(!$scope.taskId){
            $location.path('app/postbiz_basic_change_list');
        }else{
            $location.path('/app/home');
        }
    };

    /**
     * 变更承租人任务拒绝
     */
    $scope.goRefuse = function () {
        $scope.submit = true;
        if(!$scope.riskData.memo){
            toaster_info('请输入备注',toaster);
            $scope.submit = false;
            return false;
        }
        $scope.riskData.taskId = $location.search()['taskId'];
        $scope.riskData.taskNo =  $location.search()['serviceId'];
        $http.post('change_lessee_task/goRefuse',$scope.riskData).success(function (data) {
            $scope.submit = false;
            if(data.code == Response.successCode){
                console.log(data);
                $location.path("/app/home").search({type:'homeToastInfo', msg:'拒绝成功'});
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            $scope.submit = false;
            modalAlert($modal,err);
        });
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.apply;
    $scope.wfLogNo = $scope.applyNo;

    //鹏元征信的查询处理结束后，自动调用暂存
    $scope.$on('creditSuccess',function (e,data) {
        $scope.riskData.saveFlag = CommonCodeUtils.yesNoFlag.no;
        $http.post('apply_risk/saveApplyRisk',$scope.riskData).success(function (data) {
            console.log('暂存成功');
            $scope.getData();
        }).error(function (err) {

        });
    });


    // 防止画面长时间无操作session失效，定时更新session
    keepSessionAlive();
    var keepLive = $interval(function () {
        keepSessionAlive();
    }, 50 * 60 * 1000); //50分钟刷新一次

    // 画面销毁监听- 定时任务销毁
    $scope.$on("$destroy", function () {
        $interval.cancel(keepLive);
    })

    // 访问后台，刷新session
    function keepSessionAlive() {
        $http.post("keep_session/alive").success(function (data) {
        });
    }
}]);