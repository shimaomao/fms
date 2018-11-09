/**
 * Created by ningyangyang on 2018/3/30.
 */
app.controller('apply_input_detail_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster, $compile, $location) {
    //被其他画面打开新页签时，控制返回等上层按钮是否显示的flag
    $scope.btnFlag = true; //默认为显示
    if($location.search()['isTab']){
        $scope.btnFlag = false;
    }

    $scope.applyNo = $location.search()['applyNo'];
    $scope.applyType = $location.search()['applyType'];
    $scope.contNo = $location.search()['contNo'];
    $scope.type = $location.search()['type'];
    $scope.bizStatus = $location.search()['bizStatus'];
    $scope.overdueCstmId = $location.search()['overdueCstmId'];
    $scope.contractDate = $location.search()['contractDate'];
    $scope.contractRequestDate = $location.search()['contractRequestDate'];
    console.log($scope.contractRequestDate)
    $scope.contractValidDate = $location.search()['contractValidDate'];
    //申请详情顶部蓝色字体信息
    $scope.applyBaseData = null;
    //合同详情顶部蓝色字体信息
    $scope.contBaseData = null;

    $scope.disabled = true;
    $scope.detailFlag = 0;
    // 返回
    $scope.goBack = function () {
        if($scope.type == 'contract')
            $location.path("app/prebiz_contract_list");
        else if($scope.type == 'apply')
            $location.path("app/prebiz_apply_list_search");
        else if($scope.type == 'basicchange')
            $location.path("app/postbiz_basic_change_list");
        else if($scope.type == 'overdue')
            $location.path('/app/postbiz_overdue_cstm_modify').search({
                'overdueCstmId': $scope.overdueCstmId
            });
        else
            $location.path("app/prebiz_apply_list");
    };

    //获取顶部蓝色字体信息
    if(CommonObjectUtils.isExist($scope.contractDate)){
        $http.get('contract/findContBaseInfo?contNo=' + $scope.contNo).success(function(data){
            $scope.contBaseData = data.data;
        });
    } else {
        $http.get('apply/findApplyBaseInfo?applyNo=' + $scope.applyNo).success(function(data){
            $scope.applyBaseData = data.data;
        });
    }


    $http.get('sys_user/findSysUserDetail').success(function (result) {
        $scope.sysUser = result.data;
        var arr = ["Z101","FK101","FK102","FZ101"];
        $scope.roleState = false;
        for(var i=0;i<$scope.sysUser.roles.length;i++){
            if(arr.indexOf($scope.sysUser.roles[i].role) != -1){
                $scope.roleState = true;
                break;
            }
        }

        var arrPay = ["KJ101","CN101","CW101","ZJ101"];
        $scope.rolePay = false;
        for(var i=0;i<$scope.sysUser.roles.length;i++){
            if(arrPay.indexOf($scope.sysUser.roles[i].role) != -1){
                $scope.rolePay = true;
                break;
            }
        }

        if($scope.roleState && $scope.bizStatusAccord){
            //获取risk数据
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
        }
    });

    $scope.deferTask={};
    $scope.changeVo={};
    $scope.depositTaskNo = null;
    $scope.lesseeTaskNo = null;
    //获取展期、增加保证金、承租人变更任务号
    $http.get('basic_change_task/findChangeInfo?contNo=' + $scope.contNo).success(function(data){
        $scope.changeVo = data.data;
        // 获取展示展期详情需要的信息
        if($scope.changeVo && CommonStringUtils.isNotTrimBlank($scope.changeVo.deferTaskNo)) {
            $scope.deferTask={deferTaskNo:$scope.changeVo.deferTaskNo,contNo:$scope.contNo};
            $http.post('defer_task/findDeferTaskVoByContNo',$scope.deferTask).success(function(data){
                $scope.deferTaskVo = data.data;
                $scope.$broadcast('deferTaskToSon', $scope.deferTaskVo);
            });
        }
        // 获取展示增加保证金详情需要的信息
        if($scope.changeVo && CommonStringUtils.isNotTrimBlank($scope.changeVo.depositTaskNo)) {
            $scope.depositTaskNo = $scope.changeVo.depositTaskNo;
        }
        // 获取展示变更承租人详情需要的信息
        if($scope.changeVo && CommonStringUtils.isNotTrimBlank($scope.changeVo.lesseeTaskNo)) {
            $scope.lesseeTaskNo = $scope.changeVo.lesseeTaskNo;
        }
    });

    //风控初审过：订单状态 > 0108
    if($scope.bizStatus*1 >= 108){
        $scope.bizStatusAccord = true;
    }else{
        $scope.bizStatusAccord = false;
    }

    //合同生效
    if($scope.bizStatus == '0206'){
        $scope.payStatus = true;
    }else{
        $scope.payStatus = false;
    }

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.apply;
    $scope.wfLogNo = $scope.applyNo;
    $scope.wfLogSubNo = $scope.contNo;
}]);