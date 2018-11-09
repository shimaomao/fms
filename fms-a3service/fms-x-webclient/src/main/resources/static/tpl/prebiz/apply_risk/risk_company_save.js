/**
 * Created by wangxue on 2018/3/22.
 */

app.controller('risk_company_save_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$interval', function ($scope, $http, $modal, toaster, $compile, $location, $interval) {
    $scope.applyType = 2;
    $scope.preview = $location.search()['preview'];
    if($scope.preview){
        $scope.disabled = true;
        $scope.detailFlag = 0;
    }else{
        $scope.disabled = false;
        $scope.detailFlag = 1;
    }

    $scope.$on('riskDataToFather',function (e,data) {
        $scope.riskData = data;
    });
    $scope.$on('fileInfoToFather',function (e,data) {
        $scope.fileInfo = data;
    });

    $scope.formValidate = false;
    $scope.submit = false;
    $scope.applyNo = $location.search()['applyNo'];

    //获取数据
    $scope.getData = function () {
        $http.get('apply_risk/findApplyRiskInit?applyNo='+$scope.applyNo).success(function (data) {
            if(data.code == Response.successCode){
                $scope.riskData = data.data;
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

    //提交
    $scope.save = function () {
        console.log($scope.riskData);
        if(!$scope.form.$invalid && !$scope.fileInfo.notUpload){
            $scope.submit = true;
            $scope.riskData.saveFlag = CommonCodeUtils.yesNoFlag.yes;
            $http.post('apply_risk/saveApplyRisk',$scope.riskData).success(function (data) {
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
            if(!$scope.form.$invalid && $scope.fileInfo.notUpload){
                toaster_info($scope.fileInfo.notUploadInfo,toaster);
            }else{
                toaster_info(promptInfo.submitWarn,toaster);
            }
        }
    };

    //暂存
    $scope.modify = function () {
        $scope.submit = true;
        $scope.riskData.saveFlag = CommonCodeUtils.yesNoFlag.no;
        $http.post('apply_risk/saveApplyRisk',$scope.riskData).success(function (data) {
            if(data.code == Response.successCode){
                console.log(data);
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
    $scope.goBack = function (type) {
        $scope.submit = true;
        var url = '';
        if(type == 1){
            url = 'apply_risk/backApplyRisk';
        }else{
            url = 'apply_risk/backToApply';
        }
        $http.post(url,$scope.riskData).success(function (data) {
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


    // 返回
    $scope.back = function () {
        $location.path('/app/home');
    };

    //百度/天眼查
    $scope.telCheck = function (type) {
        if(type == 1){
            window.open("https://www.baidu.com/",'_blank');
        }else{
            window.open("https://www.tianyancha.com/",'_blank');
        }
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

    // 初始化根据订单编号查询黑名单信息
    $scope.basBlacklists = [];
    function initBasBlacklistInfo() {
        $http.get('bas_blacklist/findBasBlacklistVosByApplyNo?applyNo=' + $scope.applyNo).success(function (result) {
            if (result.code == Response.successCode) {
                $scope.basBlacklists = result.data;
            }
        })
    }
    initBasBlacklistInfo();
}]);