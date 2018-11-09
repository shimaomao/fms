/**
 * Created by wangxue on 2018/3/22.
 */

app.controller('apply_input_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','$interval', function ($scope, $http, $modal, toaster, $compile, $location,$timeout,$interval) {
    $scope.applyType = 1;
    $scope.$on('personToFather',function (e,data) {
        $scope.cstmPerson = data;
    });
    $scope.$on('persJobToFather',function (e,data) {
        $scope.cstmPersJob = data;
    });
    $scope.$on('persMateToFather',function (e,data) {
        $scope.cstmPersMate = data;
        $scope.$broadcast('persMateToSon', $scope.cstmPersMate);
    });
    $scope.$on('persAddrToFather',function (e,data) {
        $scope.cstmPersAddr = data;
    });
    $scope.$on('contactToFather',function (e,data) {
        $scope.cstmContactList = data;
    });
    $scope.$on('guaranteePersToFather',function (e,data) {
        $scope.guaranteePersList = data;
    });
    $scope.$on('guaranteeCompToFather',function (e,data) {
        $scope.guaranteeCompList = data;
    });
    $scope.$on('filesToFather',function (e,data) {
        $scope.bizFilesList = data;
    });
    $scope.$on('borrowerToFather',function (e,data) {
        $scope.borrowerList = data;
    });
    $scope.$on('rationalityPurchaseToFather',function (e,data) {
        $scope.rationalityPurchase = data;
    });
    $scope.$on('applyVisitToFather',function (e,data) {
        $scope.applyVisitVo = data;
    });
    $scope.$on('visitFlagToFather',function (e,data) {
        $scope.visitFlag = data;
    });
    $scope.$on('remarkToFather',function (e,data) {
        $scope.remark = data;
    });
    $scope.formValidate = false;
    $scope.submit = false;
    //担保人信息
    $scope.guaranteePersList = [];
    //担保企业信息
    $scope.guaranteeCompList = [];
    // 融资方案信息 车辆类型:新车 申请类型:个人，车辆和融资明细信息
    $scope.financeInfo = {applyFinanceVo: {/*vehicleForm: '2',*/applyType: '1'},vehicleFinList: []};
   //用户基本信息
    $scope.cstmPerson={};
    $scope.cstmPersJob = {};
    $scope.cstmPersMate = {};
    $scope.cstmPersAddr = {};
    $scope.applyVisitVo = {};
    $scope.cstmContactList=[];
    $scope.rationalityPurchase={};

    //附件对象
    $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.perApplyFile, product:''};
    //订单编号
    $scope.applyNo = $location.search()['applyNo'];
    $scope.wfLogNo = $location.search()['applyNo'];
    $scope.serviceParameter = $location.search()['serviceParameter'];
    $scope.wfLogType = '01';

    //任务id
    $scope.taskId = $location.search()['taskId'];
    //contNo
    $scope.contNo = $location.search()['contNo'];

    // 提交
    $scope.submitInfo = function () {
        // 设置提交和保存的返回信息
        setApplyInputData();
        if(!$scope.form.$invalid && checkContactAndGuarantee() && checkApplyFinance($scope.applyInputVo.applyFinanceVo, $scope.applyInputVo.applyVehicleVoList)
            && checkInputFile()) {
            $scope.submit = true;
            $http.post("apply_input/submitApplyInputVo", $scope.applyInputVo).success(function (result) {
                if (result.code == Response.successCode){
                    closeTabFormHome();
                    $location.path("/app/home").search({type:'homeToastInfo', msg:'提交成功'});

                } else {
                    modalAlert($modal,result.message);
                }
                $scope.submit = false;
            });
        } else {
            $scope.formValidate = true;
            $scope.remindMsg();

        }
    };

    $scope.remindMsg = function () {
        $timeout(function () {
            if($(".form-info:not(.ng-hide)").length > 0){
                $(".form-info:not(.ng-hide)").each(function (i,v) {
                    var title;
                    var text = $(v).text();
                    if($(v).parents("#customer").length>0){
                        var subtext = $(v).parents('.sub-main').find('.pull-left').text();
                        title = "客户基本信息-"+subtext;
                    }else if($(v).parents("#vehicleFin").length>0){
                        title = "车辆融资信息";
                    }else if($(v).parents("#applyVisit").length>0){
                        title = "家访";
                    }
                    toaster_info(title+'-'+text,toaster);
                    return false;
                });
            }else{
                toaster_info(promptInfo.submitWarn,toaster);
            }
        });
    };

    // 暂存
    $scope.save = function () {
        // 设置提交和保存的返回信息
        setApplyInputData();
        $scope.submit = true;
        $http.post("apply_input/saveApplyInputVo", $scope.applyInputVo).success(function (data) {
            if (data.code == Response.successCode){
                $scope.applyNo = data.data.applyNo;
                $scope.taskId = data.data.taskId;
                toaster_info("暂存成功",toaster);
                //closeTabFormHome();
                $location.path("/app/prebiz_apply_input").search({applyNo:$scope.applyNo,taskId:$scope.taskId});
                $scope.submit = false;
            } else {
                modalAlert($modal,data.message);
            }
            $scope.submit = false;
        });
    };

    // 暂存修改
    $scope.modify = function () {
        // 设置提交和保存的返回信息
        setApplyInputData();
        $scope.submit = true;
        $http.put("apply_input/modifyApplyInputVoByApplyNo", $scope.applyInputVo).success(function (result) {
            if (result.code == Response.successCode){
                toaster_info("暂存成功",toaster);
                $scope.submit = false;
            } else {
                modalAlert($modal,result.message);
            }
            $scope.submit = false;
        });
    };

    // 提交修改
    $scope.subModify = function () {
        // 设置提交和保存的返回信息
        setApplyInputData();
        if(!$scope.form.$invalid && checkContactAndGuarantee() && checkApplyFinance($scope.applyInputVo.applyFinanceVo, $scope.applyInputVo.applyVehicleVoList)
            && checkInputFile()) {
            $scope.submit = true;
            $http.put("apply_input/subModifyApplyInputVoByApplyNo", $scope.applyInputVo).success(function (result) {
                if (result.code == Response.successCode){
                    closeTabFormHome();
                    $location.path("/app/home").search({type:'homeToastInfo', msg:'提交成功'});
                } else {
                    modalAlert($modal,result.message);
                }
                $scope.submit = false;
            });
        } else {
            $scope.formValidate = true;
            $scope.remindMsg();
        }
    };
    // 返回
    $scope.goBack = function () {
        $location.path("/app/home");
    };

    // 设置提交和保存的返回信息
    function setApplyInputData() {
        $scope.applyInputVo = {};
        // 申请类型
        $scope.applyInputVo.applyType = $scope.financeInfo.applyFinanceVo.applyType;
        // 订单编号
        $scope.applyInputVo.applyNo = $scope.applyNo;
        //taskId
        $scope.applyInputVo.taskId  = $scope.taskId;
        //contNo
        $scope.applyInputVo.contNo  =  $scope.contNo;
        // 融资信息
        $scope.applyInputVo.applyFinanceVo = $scope.financeInfo.applyFinanceVo;
        // 车辆和融资明细信息
        $scope.applyInputVo.applyVehicleVoList = $scope.financeInfo.vehicleFinList;
        //用户信息
        $scope.applyInputVo.cstmPersJob =  $scope.cstmPersJob;
        $scope.applyInputVo.cstmPersMate =  $scope.cstmPersMate;
        $scope.applyInputVo.cstmPersAddr = $scope.cstmPersAddr;
        $scope.applyInputVo.cstmContactList = $scope.cstmContactList;
        //客户基本信息
        $scope.applyInputVo.cstmPerson =  $scope.cstmPerson;
        //担保人基本信息
        $scope.applyInputVo.guaranteePersList = $scope.guaranteePersList;
        //担保企业信息
        $scope.applyInputVo.guaranteeCompList  =$scope.guaranteeCompList;
        // 上传附件信息
        $scope.applyInputVo.bizfilesVo = $scope.bizFilesList;
        //共同担保人
        $scope.applyInputVo.commonBorrowerList = $scope.borrowerList;
        //购车合理性
        $scope.applyInputVo.rationalityPurchase = $scope.rationalityPurchase;
        //家访
        $scope.applyInputVo.visitFlag = $scope.visitFlag;
        $scope.applyInputVo.applyVisitVo = $scope.applyVisitVo;
        $scope.applyInputVo.novisitReason = $scope.applyVisitVo.reason;
        //备注
        $scope.applyInputVo.remark = $scope.remark;
    };

    // check输入融资信息是否符合条件
    function checkApplyFinance(applyFinanceVo, applyVehicleList) {
        // 首付比例
        if (isNotUndefinedNull(applyFinanceVo.initPerc)) {
            if (!CommonDecimalUtils.isValueSection(Number(applyFinanceVo.initPerc), Number(applyFinanceVo.initPercFrom), Number(applyFinanceVo.initPercTo))) {
                // modalAlert($modal, "首付比例不符合产品方案的首付比例区间，请重新输入");
                modalAlert($modal, "首付比例必须在" + Number(applyFinanceVo.initPercFrom) + " - " + Number(applyFinanceVo.initPercTo) + "区间内，请重新输入");
                return false;
            }
        } else {
            modalAlert($modal, "首付比例不能为空");
            return false;
        }
        // 首付金额
        if (isNotUndefinedNull(applyFinanceVo.initAmount)) {
            if (!CommonDecimalUtils.isValueSection(Number(applyFinanceVo.initAmount), Number(applyFinanceVo.initAmountFrom), Number(applyFinanceVo.initAmountTo))) {
                // modalAlert($modal, "首付金额不符合产品方案的首付金额区间，请重新输入");
                modalAlert($modal, "首付金额必须在" + Number(applyFinanceVo.initAmountFrom) + " - " + Number(applyFinanceVo.initAmountTo) + "区间内，请重新输入");
                return false;
            }
        } else {
            modalAlert($modal, "首付金额不能为空");
            return false;
        }
        // 尾付比例
        if (isNotUndefinedNull(applyFinanceVo.finalPerc)) {
            if (!CommonDecimalUtils.isValueSection(Number(applyFinanceVo.finalPerc), Number(applyFinanceVo.finalPercFrom), Number(applyFinanceVo.finalPercTo))) {
                // modalAlert($modal, "尾付比例不符合产品方案的尾付比例区间，请重新输入");
                modalAlert($modal, "尾付比例必须在" + Number(applyFinanceVo.finalPercFrom) + " - " + Number(applyFinanceVo.finalPercTo) + "区间内，请重新输入");
                return false;
            }
        } else {
            modalAlert($modal, "尾付比例不能为空");
            return false;
        }
        // 尾付金额
        if (isNotUndefinedNull(applyFinanceVo.finalAmount)) {
            if (!CommonDecimalUtils.isValueSection(Number(applyFinanceVo.finalAmount), Number(applyFinanceVo.finalAmountFrom), Number(applyFinanceVo.finalAmountTo))) {
                // modalAlert($modal, "尾付金额不符合产品方案的尾付金额区间，请重新输入");
                modalAlert($modal, "尾付金额必须在" + Number(applyFinanceVo.finalAmountFrom) + " - " + Number(applyFinanceVo.finalAmountTo) + "区间内，请重新输入");
                return false;
            }
        } else {
            modalAlert($modal, "尾付金额不能为空");
            return false;
        }
        // 保证金率
        if (isNotUndefinedNull(applyFinanceVo.depositPerc)) {
            if (!CommonDecimalUtils.isValueSection(Number(applyFinanceVo.depositPerc), Number(applyFinanceVo.depositPercFrom), Number(applyFinanceVo.depositPercTo))) {
                // modalAlert($modal, "保证金率不符合产品方案的保证金率区间，请重新输入");
                modalAlert($modal, "保证金率必须在" + Number(applyFinanceVo.depositPercFrom) + " - " + Number(applyFinanceVo.depositPercTo) + "区间内，请重新输入");
                return false;
            }
        } else {
            modalAlert($modal, "保证金率不能为空");
            return false;
        }
        // 保证金
        if (isNotUndefinedNull(applyFinanceVo.deposit)) {
            if (!CommonDecimalUtils.isValueSection(Number(applyFinanceVo.deposit), Number(applyFinanceVo.depositFrom), Number(applyFinanceVo.depositTo))) {
                // modalAlert($modal, "保证金不符合产品方案的保证金区间，请重新输入");
                modalAlert($modal, "保证金必须在" + Number(applyFinanceVo.depositFrom) + " - " + Number(applyFinanceVo.depositTo) + "区间内，请重新输入");
                return false;
            }
        } else {
            modalAlert($modal, "保证金不能为空");
            return false;
        }
        // 利率方案
        if (isUndefinedNull(applyFinanceVo.intrstNo) || applyFinanceVo.intrstNo == '') {
            modalAlert($modal, "找不到对应的利率方案请重新设置");
            return false;
        }
        // 车辆数量
        for (var index = 0; index < applyVehicleList.length; index++) {
            if (isUndefinedNull(applyVehicleList[index].vehicleCount) || applyVehicleList[index].vehicleCount == 0) {
                modalAlert($modal, "车辆数量必须大于等于1");
                return false;
            }
        }
        return true;
    }
    //check联系人和担保人信息
    function checkContactAndGuarantee(){
        if($scope.cstmContactList != null && $scope.cstmContactList){
            if($scope.cstmContactList.length==0){
                modalAlert($modal,'请输入联系人信息');
                return false;
            }
        }
        /*if(!($scope.guaranteeCompList.length!=0 || $scope.guaranteePersList.length!=0)){
            modalAlert($modal,'请输入担保信息');
            return false;
        }*/
        return true;
    }

    // check附件上传是否符合条件
    function checkInputFile() {
        if ($scope.bizFilesList.product != $scope.applyInputVo.applyFinanceVo.product) {
            modalAlert($modal,'请确认附件类型！');
            return false;
        }
        if($scope.visitFlag == '1'){
            if($scope.applyVisitVo.notUpload){
                modalAlert($modal,$scope.applyVisitVo.notUploadInfo);
                $scope.submit = false;
                return false;
            }
        }
        return true;
    }

    //身份验证
    function checkIdCard(){
        if(cardIdValidation($scope.cstmPerson.certifType,$scope.cstmPerson.certifNo,$modal) && cardIdValidations($scope.cstmPersMate.certifType,$scope.cstmPersMate.certifNo,$modal)){
            return true;
        }
        return false;
    }

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