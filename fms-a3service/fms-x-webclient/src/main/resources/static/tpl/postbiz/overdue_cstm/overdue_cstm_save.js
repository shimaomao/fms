/**
 * Created by lijunjun on 2018-05-16.
 */
app.controller('overdue_cstm_save_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','registData', function ($scope, $http,$modal, $modalInstance,toaster,registData) {
    $scope.formValidate = false;
    $scope.submit = false;

    //风险账户
    $scope.riskFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.riskFlag);
    //客户可联性
    $scope.certifTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.certifType);
    //配偶
    $scope.mateConnTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.mateConnType);
    //客户可联性
    $scope.connectTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.connectType);
    //工作稳定性
    $scope.jobTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.jobType);
    //收入类型
    $scope.incomeTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.incomeType);
    //居住类型
    $scope.resideTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.resideType);
    //居住真实性
    $scope.addrValidTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.addrValidType);
    //车辆使用情况
    $scope.vehicleCondTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleCondType);
    //担保人/共申人
    $scope.guaranteeConnTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.guaranteeConnType);
    //联系人可联性
    $scope.contactConnTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contactConnType);
    //联系人类型
    $scope.relationTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.relation);
    //是否有效
    $scope.validFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.validFlag);
    //风险等级
    $scope.overdueRiskList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.overdueRisk);
    //地址类型
    $scope.addrTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.addressType);


    $http.get('overdue_cstm/findOverdueRegisterInfo?overdueCstmId='+registData.overdueCstmId+'&overdueCstmTelId='+registData.overdueCstmTelId+'&certifNo='+registData.certifNo).success(function (data) {
        if (data.code == Response.successCode){
            $scope.overdueCstm = data.data;
            // 如果逾期地址信息为空
            if (!$scope.overdueCstm.overdueCstmAddrList){
                $scope.overdueCstm.overdueCstmAddrList = [];
            }
            // 如果逾期电话信息为空
            if (!$scope.overdueCstm.overdueCstmTelList){
                $scope.overdueCstm.overdueCstmTelList = [];
            }
            $scope.overdueCstm.riskFlag = '';
            $scope.overdueCstm.overdueDetail = '';
            $scope.overdueCstm.certifType = '';
            $scope.overdueCstm.mateConnType = '';
            $scope.overdueCstm.connectType = '';
            $scope.overdueCstm.jobType = '';
            $scope.overdueCstm.incomeType = '';
            $scope.overdueCstm.resideType = '';
            $scope.overdueCstm.addrValidType = '';
            $scope.overdueCstm.vehicleCondType = '';
            $scope.overdueCstm.guaranteeConnType = '';
            $scope.overdueCstm.contactConnType = '';
            $scope.overdueCstm.overdueRisk = '';
        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    //历史地址信息
    //增加
    $scope.addAddrList = function (item,index) {
        var cell = {};
        cell.flag = true;
        cell.validFlag = "1";
        $scope.overdueCstm.overdueCstmAddrList.push(cell);
    };
    //删除
    $scope.delAddrList = function (item,index) {
        $scope.overdueCstm.overdueCstmAddrList.splice(index,1);
    };

    //新增电话信息
    //增加
    $scope.addTelList = function (item,index) {
        var cell = {};
        cell.flag = true;
        $scope.overdueCstm.overdueCstmTelList.push(cell);
    };
    //删除
    $scope.delTelList = function (item,index) {
        $scope.overdueCstm.overdueCstmTelList.splice(index,1);
    };
    //增加
    $scope.save = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.post('overdue_cstm/saveOverdueCstmInfo', $scope.overdueCstm).success(function (data) {
                if (data.code == Response.successCode){
                    $modalInstance.close(Response.successMark);
                    toaster_success("添加成功！",toaster);
                }else{
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
        }
    };

    $scope.chooseOverdue = function (num,type) {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/overdue_cstm/overdue_state.html'+getCacheTime(),
            controller: 'overdue_state_controller',
            resolve:{

            }
        });
        rtn.result.then(function (data) {
            if(data){
                //逾期状态详情
                $scope.overdueDetailList = CommonCodeUtils.getCommonCodes(data.overdueDetailType);
                $scope.overdueCstm.overdueCondCd = data.overdueCondCd;
                $scope.overdueCstm.overdueCondName = data.overdueCondName;
                $scope.overdueCstm.overdueRisk = data.overdueRisk;
            }
        },function(){

        });
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close();
    };

}]);


