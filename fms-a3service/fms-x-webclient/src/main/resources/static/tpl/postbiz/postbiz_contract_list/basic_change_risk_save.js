app.controller('postbiz_basic_change_risk_save_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$interval', '$state',function ($scope, $http, $modal, toaster, $compile, $location, $interval,$state) {
    $scope.riskData = {};
    $scope.depositTaskNo = $location.search()['serviceId'];
    $scope.applyType = null;
    $scope.preview = $location.search()['preview'];
    //判断是初审还是复审页面
    if($state.current.name == 'app.postbiz_basic_change_risk_save'){
        $scope.disabled = false;
        $scope.detailFlag = 1;
    }else{
        $scope.disabled = true;
        $scope.detailFlag = 0;
    }
    $scope.$on('riskDataToFather',function (e,data) {
        $scope.riskData = data;
    });
    $scope.formValidate = false;
    $scope.submit = false;

    /*$scope.applyNo = $location.search()['applyNo'];
    $scope.taskId = $location.search()['taskId'];*/


    //获取数据
    $scope.getData = function () {
        $http.get('deposit_risk/findApplyRiskInit?depositTaskNo='+$scope.depositTaskNo).success(function (data) {
            if(data.code == Response.successCode){
                $scope.riskData = data.data;
                $scope.applyType = $scope.riskData.depositChangeApplyVo.applyType;
                $scope.riskData.taskId = $location.search()['taskId'];
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
    $scope.modify = function () {
        console.log($scope.riskData);
        $scope.submit = true;
        $scope.riskData.saveFlag = CommonCodeUtils.yesNoFlag.no;
        $http.post('deposit_risk/saveApplyRisk', $scope.riskData).success(function (data) {
            if (data.code == Response.successCode) {
                toaster_info("暂存成功！", toaster);
                $scope.getData();
            } else {
                modalAlert($modal, data.message);
            }
            $scope.submit = false;
        }).error(function (err) {
            $scope.submit = false;
            modalAlert($modal, err);
        });
    };

    //提交
    $scope.save = function () {
        console.log($scope.riskData);
        if(!$scope.form.$invalid){
            $scope.submit = true;
            $scope.riskData.saveFlag = CommonCodeUtils.yesNoFlag.yes;
            $http.post('deposit_risk/saveApplyRisk',$scope.riskData).success(function (data) {
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

    //退回
    $scope.sendBack = function (type) {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.post('deposit_risk/sendBack', $scope.riskData).success(function (data) {
                $scope.submit = false;
                if (data.code == Response.successCode) {
                    console.log(data);
                    $location.path("/app/home").search({type: 'homeToastInfo', msg: '退回成功'});
                } else {
                    modalAlert($modal, data.message);
                }
            }).error(function (err) {
                $scope.submit = false;
                modalAlert($modal, err);
            });
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    //拒绝
    $scope.refuse = function (type) {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.post('deposit_risk/refuse',$scope.riskData).success(function (data) {
                $scope.submit = false;
                if(data.code == Response.successCode){
                    console.log(data);
                    $location.path("/app/home").search({type:'homeToastInfo', msg:'审批成功'});
                }else{
                    modalAlert($modal,data.message);
                }
            }).error(function (err) {
                $scope.submit = false;
                modalAlert($modal,err);
            });
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    // 返回
    $scope.goBack = function () {
        $location.path('/app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.depositChange;
    $scope.wfLogNo = $scope.depositTaskNo;

    //鹏元征信的查询处理结束后，自动调用暂存
    $scope.$on('creditSuccess',function (e,data) {
        $scope.riskData.saveFlag = CommonCodeUtils.yesNoFlag.no;
        $http.post('deposit_risk/saveApplyRisk',$scope.riskData).success(function (data) {
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