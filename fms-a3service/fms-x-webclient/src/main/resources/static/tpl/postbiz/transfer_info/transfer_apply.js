/**
 * Created by wangxue on 2018/8/30.
 */

app.controller('transfer_apply_controller', ['$scope', '$http','$modal', 'toaster','$location', '$filter',function ($scope, $http, $modal, toaster,$location,$filter) {

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.contNo = $location.search()['contNo'];
    $scope.findNo = $scope.contNo;
    $scope.findUrl = 'transfer_info/findTransferDetailByContNo?contNo=';
    $scope.transferNo = $location.search()['transferNo'];
    $scope.taskId = $location.search()['taskId'];
    $scope.processLogShow = false;
    // 暂存之后再次进入申请页面
    if (isNotUndefinedNull($scope.transferNo) && isNotEmpty($scope.transferNo)) {
        $scope.findUrl = 'transfer_info/findTransferDetailByTransferNo?transferNo=';
        $scope.findNo = $scope.transferNo;
    }
    $scope.fromHome = false;
    // 保险处置
    $scope.insurancDealTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.insurancDealType);

    $scope.transferInfoVo = {};

    //从我的任务中进来
    if (isNotUndefinedNull($location.search()['serviceId']) && isNotEmpty($location.search()['serviceId'])) {
        $scope.fromHome = $scope.processLogShow = true;
        $scope.transferNo = $location.search()['serviceId'];
        $scope.findNo = $scope.transferNo;
        $scope.findUrl = 'transfer_info/findTransferDetailByTransferNo?transferNo=';
    }

    // 获取页面显示信息
    $http.get($scope.findUrl + $scope.findNo).success(function (result) {
        if(result.code == Response.successCode){
            console.log(result);
            $scope.transferInfoVo = result.data;
            // 提前还款状态
            $scope.transferInfoVo.prepaymentStsVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus, $scope.transferInfoVo.prepaymentSts);
            setCodeValue();
        }else{
            modalAlert($modal, result.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    function setCodeValue() {
        // 过户申请日期
        if (!$scope.transferInfoVo.transferApplyDate) {
            $scope.transferInfoVo.transferApplyDate = $filter('date')(new Date(), 'yyyy-MM-dd');
        } else {
            $scope.transferInfoVo.transferApplyDate = $filter('date')($scope.transferInfoVo.transferApplyDate, 'yyyy-MM-dd');
        }
        // 行驶证登记日期
        $scope.transferInfoVo.vehicleDrivingLicenseRegisterDate = $filter('date')($scope.transferInfoVo.vehicleDrivingLicenseRegisterDate, 'yyyy-MM-dd');
        // 保险失效日
        $scope.transferInfoVo.validEndDay = $filter('date')($scope.transferInfoVo.validEndDay, 'yyyy-MM-dd');
        // 合同生效日期
        $scope.transferInfoVo.contractValidDate = $filter('date')($scope.transferInfoVo.contractValidDate, 'yyyy-MM-dd');
        // 结清状态
        $scope.transferInfoVo.paymentStsVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.paymentSts, $scope.transferInfoVo.paymentSts);
        // 抵押状态
        $scope.transferInfoVo.mortgageStatusVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.mortgageStatus, $scope.transferInfoVo.mortgageStatus);
        // 资方
        $scope.transferInfoVo.managementVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.management, $scope.transferInfoVo.management);
        // 登记证文件状态
        $scope.transferInfoVo.origFileDetailStatusVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.origFileDetailStatus,$scope.transferInfoVo.origFileDetailStatus);

        // 保险处置方式
        if (isUndefinedNull($scope.transferInfoVo.insurancDealType) || isEmpty($scope.transferInfoVo.insurancDealType)) {
            $scope.transferInfoVo.insurancDealType = "";
            if ($scope.transferInfoVo.insuranceStatus == '2') {
                // 保险失效的场合
                $scope.transferInfoVo.insurancDealType = "0";
            }
        }
        // 过户流程处理任务ID
        $scope.transferInfoVo.taskId = $scope.taskId;
    }

    // 返回
    $scope.backUp = function () {
        if($scope.fromHome){
            $location.path('/app/home');
        } else {
            $location.path("app/postbiz_transfer_info_list");
        }
    };

    // 提交
    $scope.submitInfo = function () {
        if(!$scope.form.$invalid) {
            // 判断附件是否上传
            if ($scope.transferInfoVo.notUpload) {
                 modalAlert($modal, "请上传" + $scope.transferInfoVo.notFileTypeName + "类型文件");
                 return;
             }
            $scope.submit = true;
            $http.post('transfer_info/submitTransferApply', $scope.transferInfoVo).success(function (result) {
                if (result.code == Response.successCode){
                    if($scope.fromHome){
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'过户申请提交成功'});
                    }else{
                        $location.path("app/postbiz_transfer_info_list").search({msg:"过户申请提交成功"});
                    }
                }
                else{
                    modalAlert($modal,result.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            });
        } else{
            toaster_info(promptInfo.submitWarn,toaster);
            $scope.formValidate = true;
        }
    };

    // 暂存
    $scope.saveInfo = function () {
        $scope.submit = true;
        $http.post("transfer_info/saveTransferApply", $scope.transferInfoVo).success(function (result) {
            if (result.code == Response.successCode){
                // resetTransferInfo(result.data.transferNo);
                $scope.transferInfoVo.transferNo = result.data.transferNo;
                toaster_info("暂存成功",toaster);
                $scope.submit = false;
            } else {
                modalAlert($modal, result.message);
            }
            $scope.submit = false;
        }).error(function(result){
            modalAlert($modal, result);
            $scope.submit = false;
        });
    };

    //查看还款计划表
    $scope.overdueSales = function () {
        var contNo = $scope.transferInfoVo.contNo;
        console.log(contNo);
        if(contNo){
            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/postbiz/overdue_cstm/overdue_sales.html'+getCacheTime(),
                controller: 'overdue_sales_controller',
                resolve:{
                    paramsData: function () {
                        return {
                            "contNo": contNo
                        }
                    }
                }
            });
            rtn.result.then(function (data) {

            },function(){

            });
        } else{
            modalAlert($modal,'合同号不存在！');
        }
    };

    // 违章查询
    $scope.violationInquiry = function () {

    };

    // 借阅申请
    $scope.borrowApply = function () {
        if($scope.transferInfoVo.origFileTaskStatus != '0300'){
            modalAlert($modal,"合同附件归档未完成，无法申请借阅");
            return;
        }
        // 查询合同的文件呢状态
        var url = 'transfer_info/findOrigFileDetailStatusByContNo?contNo=' + $scope.transferInfoVo.contNo
            + '&bizCodeType=' + $scope.transferInfoVo.bizCodeType;
        $http.get(url).success(function (result) {
            if(result.code == Response.successCode){
                var origFileStatus = result.data;
                if (origFileStatus != '3') {
                    // 登记证文件类型是已归档以外的场合
                    modalAlert($modal,"登记证已发起借阅，无法再次申请借阅");
                } else {
                    // 跳转到借阅申请页面
                    var id = $scope.transferInfoVo.contNo;
                    var url = 'app.original_file_borrow_detail?bizCode=' + $scope.transferInfoVo.contNo
                        + '&bizCodeType=' + $scope.transferInfoVo.bizCodeType
                        + '&fileRecordNo=' + $scope.transferInfoVo.fileRecordNo
                        + '&origFileType=' + $scope.transferInfoVo.origFileType
                        + '&skipType=' + "true"
                        + '&isTransfer=' + "true"; // "isTransfer"是用来判断是否是由过户相关页面打开借阅申请，非过户相关页面不需要传递此值
                    var title = '借阅申请';
                    var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
                    if(window.parent.addTab){
                        window.parent.addTab(html);
                    }
                }
            } else {
                modalAlert($modal,result.message);
            }
        }).error(function (result) {
            modalAlert($modal, result);
        });
    };

    // 暂存之后重置页面显示信息
    function resetTransferInfo(findNo) {
        $http.get('transfer_info/findTransferDetailByTransferNo?transferNo=' + findNo).success(function (result) {
            if(result.code == Response.successCode){
                $scope.transferInfoVo = result.data;
                setCodeValue();
            }else{
                modalAlert($modal, result.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    }

    //确认书模板下载（先暂存再下载）
    $scope.downLoadLetter = function () {
            //暂存
            $scope.submit = true;
                $http.post("transfer_info/saveTransferApply", $scope.transferInfoVo).success(function (result) {
                    if (result.code == Response.successCode) {
                        $scope.transferInfoVo.transferNo = result.data.transferNo;
                        //下载
                        $http.post('transfer_info/downLoadLetter', {'contNo': $scope.contNo}).success(function (data) {
                            if (data.code == Response.successCode) {
                                //pdf生成
                                console.log(data.data);
                                window.parent.open('file/downloadFile?fileCompletePath=' + data.data.filePath + '&fileName=' + data.data.fileName);
                            } else {
                                modalAlert($modal, data.message);
                            }
                            $scope.submit = false;
                        }).error(function (data) {
                            modalAlert($modal, data);
                            $scope.submit = false;
                        })
                        $scope.submit = false;
                    } else {
                        modalAlert($modal, result.message);
                    }
                    $scope.submit = false;
                }).error(function (result) {
                    modalAlert($modal, result);
                    $scope.submit = false;
                });
    }

}]);