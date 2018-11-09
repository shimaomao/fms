app.controller('basic_change_cont_print_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$interval', function ($scope, $http, $modal, toaster, $compile, $location, $interval) {
    $scope.applyType = $location.search()['serviceType'];
    $scope.taskId = $location.search()['taskId'];
    $scope.applyNo = $location.search()['serviceId'];
    //流程任务key
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];
    $scope.applyDisabled = true;
    $scope.changeLesseeTask = {};
    $scope.applyInput = {};

    if($scope.preview == 'change_task_review'){
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
    //获取附件和变更信息
    $scope.getInputVo = function(){
        $http.get('change_lessee_task/findApplyInputVoByApplyNo?applyNo='+$scope.applyNo).success(function(data){
            if(data.code == Response.successCode){
                $scope.applyInput = data.data;
                console.log('sssss'+$scope.applyInput);
                $scope.fileObj.bizFilesList = $scope.applyInput.bizFilesList;
                $scope.contNo = $scope.applyInput.contNo;
                $scope.applyNoParams =  $scope.applyInput.changeLesseeTask.applyNo;
                $scope.changeLesseeTask.contGenerateFilesList = $scope.applyInput.contGenerateFilesList;
                $scope.changeLesseeTask.contPrintFilesList = $scope.applyInput.contPrintFilesList;
                //向子控制器广播数据
                $scope.$broadcast('applyInputToSonSecond', $scope.applyInput);
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };
    $scope.getInputVo();


    $scope.$on('fileInfoToFather',function (e,data) {
        $scope.fileInfo = data;
    });

    //提交
    $scope.save = function () {
        if(!$scope.form.$invalid){
            $scope.submit = true;
            if($scope.changeLesseeTask.notUpload){
                modalAlert($modal,$scope.changeLesseeTask.notUploadInfo);
                $scope.submit = false;
                return false;
            }
            $scope.changeLesseeTask.taskNo = $scope.applyNo;
            $scope.changeLesseeTask.taskId = $scope.taskId;
            $http.post('change_lessee_task/changeContPrint',$scope.changeLesseeTask).success(function (data) {
                if(data.code == Response.successCode){
                    $location.path("/app/home").search({type:'homeToastInfo', msg:'合同打印成功'});
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

    //退回
    $scope.sendBack = function () {
        $scope.submit = true;
        if(!$scope.changeLesseeTask.memo){
            toaster_info('请输入备注',toaster);
            $scope.submit = false;
            return false;
        }
        $scope.changeLesseeTask.taskNo = $scope.applyNo;
        $scope.changeLesseeTask.taskId = $scope.taskId;
        $http.post('change_lessee_task/sendBack',$scope.changeLesseeTask).success(function (data) {
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

    //返回
    $scope.goBack = function () {
        if(!$scope.taskId){
            $location.path('app/postbiz_basic_change_list');
        }else{
            $location.path('/app/home');
        }
    };

    /**
     * 引用流程日志共通
     */
    // $scope.wfLogType = CommonCodeUtils.bizTypes.apply;
    // $scope.wfLogNo = $scope.applyNo;


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