/**
 * Created by qiaohao on 2018/5/31.
 */
app.controller('equ_mor_sea_wing_apply_input_controller', ['$scope', '$http', '$modal', 'toaster', '$location', function ($scope, $http, $modal, toaster, $location) {


    $scope.equMorTask = {};

    $scope.equMorDetail = {};

    $scope.equMorApplyVo = {};

    //判断是否从工作流传入(可能是从我的任务点进去提交，也可能是从一览申请页面暂存后再点提交)
    $scope.taskId = $location.search()['taskId'];
    $scope.equMorTaskNo = $location.search()['serviceId'];
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];


    if (CommonObjectUtils.isNotExist($scope.taskId)) {
        $http.get('equ_mor_apply/findEquMorApplyVoByContNo?contNo=' + $location.search()['contNo']).success(function (data) {
            if (data.code == Response.successCode) {
                $scope.equMorApplyVo = data.data;
                console.log($scope.equMorApplyVo)
                $scope.contFinDetailVosList = $scope.equMorApplyVo.contFinDetailVos;
                $scope.equMorApplyVo.rentPayModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.rentPayMode, $scope.equMorApplyVo.rentPayMode);
                $scope.equMorApplyVo.licenseAttrName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr, $scope.equMorApplyVo.licenseAttr);
                //合同保证金比例设为固定值30%
                $scope.equMorDetail.contractMarginRatio = 30;
                //业务类别不为尾款业务时,尾款比例设为固定值0%
                if($scope.equMorDetail.serviceCategory!=1){
                    $scope.equMorDetail.balanceRatio = 0;
                }

            }
            else
                modalAlert($modal, data.message);
        }).error(function (data) {
            modalAlert($modal, data);
        })
    } else {
        $http.get('equ_mor_apply/findEquMorApplyVoByEquMorTaskNo?equMorTaskNo=' + $scope.equMorTaskNo).success(function (data) {
            if (data.code == Response.successCode) {
                $scope.equMorApplyVo = data.data;
                console.log($scope.equMorApplyVo)
                $scope.contFinDetailVosList = $scope.equMorApplyVo.contFinDetailVos;
                $scope.equMorApplyVo.rentPayModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.rentPayMode, $scope.equMorApplyVo.rentPayMode);
                $scope.equMorApplyVo.licenseAttrName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr, $scope.equMorApplyVo.licenseAttr);
                $scope.equMorTask = data.data.equMorTaskVo;
                $scope.equMorDetail = data.data.equMorDetailVo;
                //合同保证金比例设为固定值30%
                $scope.equMorDetail.contractMarginRatio = 30;
                //业务类别不为尾款业务时,尾款比例设为固定值0%
                if($scope.equMorDetail.serviceCategory!=1){
                    $scope.equMorDetail.balanceRatio = 0;
                }
            }
            else
                modalAlert($modal, data.message);
        }).error(function (data) {
            modalAlert($modal, data);
        })
    }

    $scope.changeLeasePeriod1 = function () {
        if ($scope.equMorApplyVo.rentPayMode == "1") {
            if ($scope.equMorDetail.leasePeriod == 1) {
                $scope.equMorDetail.balanceAnnualRate = 6.66;
            } else if ($scope.equMorDetail.leasePeriod == 2) {
                $scope.equMorDetail.balanceAnnualRate = 7.24;
            } else if ($scope.equMorDetail.leasePeriod == 3) {
                $scope.equMorDetail.balanceAnnualRate = 7.15;
            } else {
                $scope.equMorDetail.balanceAnnualRate = 0;
            }


        } else if ($scope.equMorApplyVo.rentPayMode == "0") {
            if ($scope.equMorDetail.leasePeriod == 1) {
                $scope.equMorDetail.balanceAnnualRate = 6.80;
            } else if ($scope.equMorDetail.leasePeriod == 2) {
                $scope.equMorDetail.balanceAnnualRate = 7.32;
            } else if ($scope.equMorDetail.leasePeriod == 3) {
                $scope.equMorDetail.balanceAnnualRate = 7.26;
            } else {
                $scope.equMorDetail.balanceAnnualRate = 0;
            }
        }
    };

    $scope.changeLeasePeriod2 = function () {
        if ($scope.equMorApplyVo.rentPayMode == "1") {
            if ($scope.equMorDetail.leasePeriod == 4) {
                $scope.equMorDetail.balanceAnnualRate = 7.05;
            } else if ($scope.equMorDetail.leasePeriod == 5) {
                $scope.equMorDetail.balanceAnnualRate = 8.05;
            } else {
                $scope.equMorDetail.balanceAnnualRate = 0;
            }

        } else if ($scope.equMorApplyVo.rentPayMode == "0") {
            if ($scope.equMorDetail.leasePeriod == 4) {
                $scope.equMorDetail.balanceAnnualRate = 7.50;
            } else if ($scope.equMorDetail.leasePeriod == 5) {
                $scope.equMorDetail.balanceAnnualRate = 8.20;
            } else {
                $scope.equMorDetail.balanceAnnualRate = 0;
            }
        }
    };

    $scope.save = function () {
        if (!$scope.form.$invalid) {

            if ($scope.equMorDetail.planRepaymentPeriod <= 0) {
                modalAlert($modal, "计划还款期次不能小于等于0");
                return;
            }

            if ($scope.equMorDetail.rent > $scope.equMorApplyVo.rent) {
                modalAlert($modal, "终端客户应付万量租赁的月租金应覆盖万量租赁应付海翼租赁的月租金");
                return;
            }

            if ($scope.equMorDetail.serviceCategory == "0") {
                $scope.equProportion = 0.8;
                if ($scope.equMorDetail.contAmount > CommonDecimalUtils.getAmountByPercAndCeil($scope.equMorApplyVo.finTotal, $scope.equProportion * 100, 2)) {
                    modalAlert($modal, "未满足海翼租赁与万量租赁单笔业务的合同金额≤万量租赁与终端客户的合同金额*80%");
                     return;
                }
            }
            if ($scope.equMorDetail.serviceCategory == "1") {
                $scope.equProportion = 0.9;
                if ($scope.equMorDetail.contAmount > CommonDecimalUtils.getAmountByPercAndCeil($scope.equMorApplyVo.finTotal, $scope.equProportion * 100, 2)) {
                    modalAlert($modal, "未满足海翼租赁与万量租赁单笔业务的合同金额≤万量租赁与终端客户的合同金额*90%");
                    return;
                }
            }

            //取车款
            $scope.getCarFinAmount();
            if ($scope.equMorDetail.contAmount > $scope.carFinAmount) {
                modalAlert($modal, "未满足海翼租赁与万量租赁单笔业务的合同金额≤车辆售价");
                return;
            }

            if ($scope.equMorDetail.serviceCategory == "1") {
                if ($scope.equMorDetail.balanceAmount > CommonDecimalUtils.getAmountByPercAndCeil($scope.equMorApplyVo.finTotal, 55, 2)) {
                    modalAlert($modal, "尾款比例应不超过我司合同金额的55%");
                    return;
                }
            }

            $scope.submit = true;
            $scope.equMorApplyVo.equMorDetailVo = $scope.equMorDetail;
            $scope.equMorApplyVo.equMorTaskVo = $scope.equMorTask;
            //租赁期限开始日赋给计划首期租金支付日
            $scope.equMorDetail.planFirstPayDate = $scope.equMorApplyVo.leaseTermStartDate;

            //出租人赋给业务推荐单位
            $scope.equMorDetail.servRecommComp = $scope.equMorApplyVo.belongGroupName;

            var url = 'equ_mor_apply/saveEquMorSeaWingApply';
            if (CommonObjectUtils.isExist($scope.taskId)) {
                $scope.equMorApplyVo.taskId = $location.search()['taskId'];
                $scope.equMorApplyVo.taskDefinitionKey = $location.search()['taskDefinitionKey']
                url = 'equ_mor_apply/modifyEquMorSeaWingApply';
            }

            $http.post(url, $scope.equMorApplyVo).success(function (data) {
                if (data.code == Response.successCode) {
                    if (CommonObjectUtils.isNotExist($scope.equMorTaskNo)) {
                        $location.path('app/asset_equ_mor_sea_wing_apply_list').search({msg: '申请成功'});
                    } else {
                        $location.path("/app/home").search({type: 'homeToastInfo', msg: '申请成功'});
                    }
                } else {
                    modalAlert($modal, data.message);
                    $scope.submit = false;
                }
            }).error(function (data) {
                modalAlert($modal, data);
                $scope.submit = false;
            })

        } else {
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn, toaster);
        }
    }

    //暂存
    $scope.storage = function (printFlag) {
        if (CommonStringUtils.isTrimBlank($scope.equMorTask.mortgageProcess)) {
            modalAlert($modal, "请选择抵押流程");
            return;
        }
        $scope.submit = true;
        $scope.equMorApplyVo.equMorDetailVo = $scope.equMorDetail;

        //业务类别
        if (isUndefinedNull($scope.equMorApplyVo.equMorDetailVo.serviceCategory)) {
            $scope.equMorApplyVo.equMorDetailVo.serviceCategory = "";
        }
        //租赁期限
        if (isUndefinedNull($scope.equMorApplyVo.equMorDetailVo.leasePeriod)) {
            $scope.equMorApplyVo.equMorDetailVo.leasePeriod = "";
        }

        //租赁期限开始日赋给计划首期租金支付日
        $scope.equMorDetail.planFirstPayDate = $scope.equMorApplyVo.leaseTermStartDate;

        //出租人赋给业务推荐单位
        $scope.equMorDetail.servRecommComp = $scope.equMorApplyVo.belongGroupName;

        $scope.equMorApplyVo.equMorTaskVo = $scope.equMorTask;
        $http.post('equ_mor_apply/storageEquMorSeaWingApply', $scope.equMorApplyVo).success(function (data) {
            if (data.code == Response.successCode) {
                if (1 == printFlag) {
                    $scope.equMorApplyVo = data.data;
                    $scope.equMorApplyVo.rentPayModeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.rentPayMode, $scope.equMorApplyVo.rentPayMode);
                    $scope.equMorApplyVo.licenseAttrName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr, $scope.equMorApplyVo.licenseAttr);
                    $scope.equMorTask = data.data.equMorTaskVo;
                    $scope.equMorDetail = data.data.equMorDetailVo;

                    //取暂存的taskId和流程key
                    if (isNotUndefinedNull(data.data.taskId)) {
                        $scope.taskId = data.data.taskId;
                        $scope.taskDefinitionKey = data.data.taskDefinitionKey;
                    }
                    $location.path("/app/asset_equ_mor_sea_wing_apply_input").search({
                        taskDefinitionKey: $scope.taskDefinitionKey,
                        taskId: $scope.taskId
                    });
                    $scope.submit = false;

                    $scope.print2();
                } else {
                    /*if (CommonObjectUtils.isExist($scope.taskId)) {
                     $location.path("/app/home").search({type: 'homeToastInfo', msg: '保存成功'});
                     } else {
                     $location.path('app/asset_equ_mor_sea_wing_apply_list').search({msg: '保存成功'});
                     }*/
                    //取暂存的taskId和流程key
                    if (isNotUndefinedNull(data.data.taskId)) {
                        $scope.taskId = data.data.taskId;
                        $scope.taskDefinitionKey = data.data.taskDefinitionKey;
                    }

                    toaster_info("暂存成功", toaster);
                    $location.path("/app/asset_equ_mor_sea_wing_apply_input").search({
                        taskDefinitionKey: $scope.taskDefinitionKey,
                        taskId: $scope.taskId
                    });
                    $scope.submit = false;
                }
            } else {
                modalAlert($modal, data.message);
                $scope.submit = false;
            }
        }).error(function (data) {
            modalAlert($modal, data);
            $scope.submit = false;
        })
    }

    $scope.managementList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.management);
    $scope.mortgageProcessList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.mortgageProcess);
    $scope.finPeriodTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.finPeriodType);
    //业务类别
    $scope.serviceCategoryList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.serviceCategory);
    //租赁期限
    $scope.leasePeriodList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.leasePeriod);
    //业务类别为常规业务时的租赁期限
    $scope.leasePeriodCgList = [];
    //业务类别为尾款业务时的租赁期限
    $scope.leasePeriodWkList = [];
    //比例(用于合同金额的计算)
    $scope.equProportion = 0;

    for (var j = 0; j < $scope.serviceCategoryList.length; j++) {
        //业务类别为常规业务
        if ($scope.serviceCategoryList[j].codeValue == "0") {
            //得到业务类别为常规业务下的租赁期限list
            for (var i = 0; i < $scope.leasePeriodList.length; i++) {

                if ($scope.leasePeriodList[i].codeValue == "1" || $scope.leasePeriodList[i].codeValue == "2" || $scope.leasePeriodList[i].codeValue == "3") {
                    $scope.leasePeriodCgList.push($scope.leasePeriodList[i])
                }
            }
        }

        //业务类别为尾款业务
        if ($scope.serviceCategoryList[j].codeValue == "1") {
            //得到业务类别为尾款业务下的租赁期限list
            for (var i = 0; i < $scope.leasePeriodList.length; i++) {
                if ($scope.leasePeriodList[i].codeValue == "4" || $scope.leasePeriodList[i].codeValue == "5") {
                    $scope.leasePeriodWkList.push($scope.leasePeriodList[i])
                }
            }
        }
    }

    //取车款
    $scope.getCarFinAmount = function () {
        if (isNotUndefinedNull($scope.contFinDetailVosList) && $scope.contFinDetailVosList.length > 0) {
            for (var i = 0; i < $scope.contFinDetailVosList.length; i++) {
                if ($scope.contFinDetailVosList[i].finItem == "carprice") {
                    $scope.carFinAmount = $scope.contFinDetailVosList[i].finAmount;
                }
            }
        }
    }


    //业务类别onChange
    $scope.changeServiceCategory = function (a) {
        //业务类别,租赁期限,年利率联动
        $scope.equMorDetail.leasePeriod = "";
        $scope.equMorDetail.balanceAnnualRate = 0;

        //业务类别切换不为尾款业务时,尾款比例和尾款金额设为0
        if (a != "1"){
            $scope.equMorDetail.balanceRatio = 0;
            $scope.equMorDetail.balanceAmount = 0
        }

        //取车款
        $scope.getCarFinAmount();

        if (isUndefinedNull($scope.carFinAmount)) {
            modalAlert($modal, '车款取值不正确!');
        }
        //取比例
        if (a == "0") {
            $scope.equProportion = 0.8;
        } else if (a == "1") {
            $scope.equProportion = 0.9;
        }
        //调用合同金额计算
        $scope.checkContAmount($scope.equProportion, $scope.carFinAmount)
    };

   /* //监听计划还款期次
    $scope.$watch("equMorDetail.planRepaymentPeriod", function () {
        //取车款
        $scope.getCarFinAmount();
        //取比例
        if ($scope.equMorDetail.serviceCategory == "0") {
            $scope.equProportion = 0.8;
        }
        if ($scope.equMorDetail.serviceCategory == "1") {
            $scope.equProportion = 0.9;
        }
        //调用合同金额计算
        $scope.checkContAmount($scope.equProportion, $scope.carFinAmount)
    })*/

    //计划还款期次onChange
    $scope.changePlanRepaymentPeriod = function () {
        //取车款
        $scope.getCarFinAmount();
        //取比例
        if ($scope.equMorDetail.serviceCategory == "0") {
            $scope.equProportion = 0.8;
        }
        if ($scope.equMorDetail.serviceCategory == "1") {
            $scope.equProportion = 0.9;
        }
        //调用合同金额计算
        $scope.checkContAmount($scope.equProportion, $scope.carFinAmount)
    }

    //合同金额根据业务类别与计划还款期次联动
    $scope.checkContAmount = function (b, c) {
        if ($scope.equMorApplyVo.finPeriodType > 0 &&
            $scope.equMorDetail.planRepaymentPeriod > 0 && isNotUndefinedNull($scope.equMorDetail.serviceCategory)) {
            if ($scope.equMorApplyVo.finPeriodType > $scope.equMorDetail.planRepaymentPeriod) {

                if (c > CommonDecimalUtils.getAmountByPercAndCeil($scope.equMorApplyVo.finTotal, b * 100, 2)) {
                    $scope.equMorDetail.contAmount = CommonDecimalUtils.getTowZero(CommonDecimalUtils.getAmountByPercAndCeil($scope.equMorApplyVo.finTotal - (($scope.equMorApplyVo.finPeriodType - $scope.equMorDetail.planRepaymentPeriod) * $scope.equMorApplyVo.rent), $scope.equProportion * 100, 2))
                } else {
                    $scope.equMorDetail.contAmount = CommonDecimalUtils.getTowZero(c - (($scope.equMorApplyVo.finPeriodType - $scope.equMorDetail.planRepaymentPeriod) * $scope.equMorApplyVo.rent))
                }
            } else {
                if (c > CommonDecimalUtils.getAmountByPercAndCeil($scope.equMorApplyVo.finTotal, b * 100, 2)) {
                    $scope.equMorDetail.contAmount = CommonDecimalUtils.getTowZero(CommonDecimalUtils.getAmountByPercAndCeil($scope.equMorApplyVo.finTotal, b * 100, 2))
                } else {
                    $scope.equMorDetail.contAmount = CommonDecimalUtils.getTowZero(c)
                }
            }
        } else {
            $scope.equMorDetail.contAmount = null;
        }
    }


    $scope.goBack = function () {
        if (CommonObjectUtils.isExist($scope.equMorTaskNo)) {
            $location.path('app/home');
        } else {
            $location.path('app/asset_equ_mor_sea_wing_apply_list');
        }
    }

    //计算所有金额
    $scope.checkAllAmount = function () {
        $scope.checkContMargin();
        $scope.checkTotalContInterest();
        $scope.checkBalanceAmount();
        // $scope.checkRent();
    }
    //合同金额变化,重新计算所有金额
    $scope.$watch("equMorDetail.contAmount", function () {
        $scope.checkAllAmount();
    });

    //计算合同保证金(元)  合同保证金(元) = 合同金额 * 合同保证金比例(%)
    $scope.checkContMargin = function () {
        if (CommonObjectUtils.isExist($scope.equMorDetail.contAmount) &&
            CommonObjectUtils.isExist($scope.equMorDetail.contractMarginRatio)) {
            $scope.equMorDetail.contMargin = CommonDecimalUtils.getAmountByPercAndCeil($scope.equMorDetail.contAmount, $scope.equMorDetail.contractMarginRatio, 2);
        }
    }
    //监听合同保证金(元)计算参数
    $scope.$watch("equMorDetail.contractMarginRatio", function () {
        $scope.checkContMargin();
    })

    //计算合同利息总额(元) 合同利息总额(元) = 合同金额 * 常规方案费率(%)
    $scope.checkTotalContInterest = function () {
        if (CommonObjectUtils.isExist($scope.equMorDetail.contAmount) &&
            CommonObjectUtils.isExist($scope.equMorDetail.regularProgramRate)) {
            $scope.equMorDetail.totalContInterest = CommonDecimalUtils.getAmountByPercAndCeil($scope.equMorDetail.contAmount, $scope.equMorDetail.regularProgramRate, 2);
        }
    }
    //监听计算合同利息总额(元)计算参数
    $scope.$watch("equMorDetail.regularProgramRate", function () {
        $scope.checkTotalContInterest();
    })
    //计算尾款金额(元) 尾款金额(元)  =  合同金额 * 尾款比例(%)
    $scope.checkBalanceAmount = function () {
        if (CommonObjectUtils.isExist($scope.equMorDetail.contAmount) &&
            CommonObjectUtils.isExist($scope.equMorDetail.balanceRatio)) {
            $scope.equMorDetail.balanceAmount = CommonDecimalUtils.getAmountByPercAndCeil($scope.equMorDetail.contAmount, $scope.equMorDetail.balanceRatio, 2);
        }
    }
    //监听计算尾款金额(元)计算参数
    $scope.$watch("equMorDetail.balanceRatio", function () {
        $scope.checkBalanceAmount();
    })
    //计算每期租金
    $scope.checkRent = function () {
        var params = {
            rentPayMode: $scope.equMorApplyVo.rentPayMode,
            repayDay: $scope.equMorApplyVo.repayDay,
            contAmount: $scope.equMorDetail.contAmount,
            balanceAmount: $scope.equMorDetail.balanceAmount,
            planRepaymentPeriod: $scope.equMorDetail.planRepaymentPeriod,
            balanceAnnualRate: $scope.equMorDetail.balanceAnnualRate
        };

        console.log(params)

        if (CommonObjectUtils.isExistDatas(params)) {
            $http.get('equ_mor_apply/findRent?' + CommonHttpUtils.getParamsUrl(params)).success(function (data) {
                if (data.code == Response.successCode) {
                    $scope.equMorDetail.rent = data.data;
                } else
                    modalAlert($modal, data.message);
            }).error(function (data) {
                modalAlert($modal, data);
            })
        }
    }
    /* //监听每期租金的参数变化
     $scope.$watch("equMorApplyVo.rentPayMode + equMorApplyVo.repayDay + equMorDetail.balanceAmount + equMorDetail.planRepaymentPeriod + equMorDetail.balanceAnnualRate", function () {
     $scope.checkRent();
     });*/


    $scope.print = function () {
        /*if (CommonObjectUtils.isExist($scope.equMorTask.equMorTaskNo)) {
            CommonFileUtils.downloadFileGet('equ_mor_apply/printEquMorChargeSeaWingApply', {equMorTaskNo: $scope.equMorTask.equMorTaskNo}
                , $http, $modal, $scope);
        } else {
            modalConfirm($modal, function () {
                $scope.storage(1);
            }, null, '合同打印需要进行暂存,您要继续打印吗？')
        }*/

        modalConfirm($modal, function () {
            $scope.storage(1);
        }, null, '合同打印需要进行暂存,您要继续打印吗？')
    }
    $scope.print2 = function () {
        if (CommonObjectUtils.isExist($scope.equMorTask.equMorTaskNo)) {
            CommonFileUtils.downloadFileGet('equ_mor_apply/printEquMorChargeSeaWingApply', {equMorTaskNo: $scope.equMorTask.equMorTaskNo}
                , $http, $modal, $scope);
        }else{
            modalAlert($modal, '无法获取任务号!');
        }
    }

    //取消
    $scope.cancel = function () {

        $scope.equMorApplyVo.taskId = $location.search()['taskId'];
        $scope.equMorApplyVo.taskDefinitionKey = $location.search()['taskDefinitionKey'];
        $scope.equMorApplyVo.serviceId = $location.search()['serviceId'];

        $scope.submit = true;
        $http.post('equ_mor_apply/equMorApplyCancel', $scope.equMorApplyVo).success(function (data) {
            if (data.code == Response.successCode) {
                $location.path("/app/home").search({type: 'homeToastInfo', msg: '取消成功'});
            }
            else {
                modalAlert($modal, data.message);
                $scope.submit = false;
            }
        }).error(function (data) {
            modalAlert($modal, data);
            $scope.submit = false;
        })
    }

}])

;