app.controller('basic_change_lessee_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$interval', function ($scope, $http, $modal, toaster, $compile, $location, $interval) {
    $scope.applyNo = $scope.$parent.lesseeTaskNo;
    $scope.applyType = null;
    $scope.historyBtn = true;

    $scope.applyDisabled = true;
    $scope.disabled = true;

    //附件对象
    $scope.fileObj = {
        bizFilesList:[],
        notUpload: false,
        notUploadInfo:'',
        notFileType:'',
        notFileTypeName:'',
        fileType:''
    };


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
    $scope.getData();
    $scope.$on('riskDataToFather',function (e,data) {
        $scope.riskData = data;
    });
    //接收子控制器的数据
    $scope.$on('riskDataToFather',function (e,data) {
        $scope.riskData = $.extend(true,$scope.riskData,data);
        //向子控制器广播数据
        $scope.$broadcast('riskDataToSon', $scope.riskData );
    });


    $scope.changeReason = null;
    $scope.name = null;
    $scope.certifNo = null;
    //获取附件和变更信息
    $scope.getInputVo = function(){
        $http.get('change_lessee_task/findApplyInputVoByApplyNo?applyNo='+$scope.applyNo).success(function(data){
            if(data.code == Response.successCode){
                $scope.applyInput = data.data;
                $scope.fileObj.bizFilesList = $scope.applyInput.bizFilesList;
                $scope.contNo = $scope.applyInput.contNo;
                $scope.applyNoParams =  $scope.applyInput.changeLesseeTask.applyNo;
                $scope.applyType = $scope.applyInput.changeLesseeTask.applyType;
                //附件类型
                if($scope.applyType == 1){
                    $scope.fileObj.fileType = $scope.$root.basFileTypes.perApplyFile;
                }else{
                    $scope.fileObj.fileType = $scope.$root.basFileTypes.compApplyFile;
                }
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


    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.apply;
    $scope.wfLogNo = $scope.applyNo;


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