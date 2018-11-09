app.controller('orig_file_borrow_task_finance_controller', ['$scope', '$http','$modal','$compile','$location', 'toaster',function ($scope, $http,$modal,$compile,$location,toaster) {

    //初始化定义银行信息
    $scope.contReceiptVoList = [];
    $scope.borrowTaskVo = {};
    $http.get('borrow_task/findBorrowTaskByBorrowTaskNo?borrowTaskNo='+$location.search()['serviceId']).success(function (data) {

        $scope.borrowTaskVo = data.data;
        $scope.borrowTaskVo.borrowTaskNo = $location.search()['serviceId'];
        $scope.borrowTaskVo.taskId = $location.search()['taskId'];
        //是否抵扣租金List
        $scope.deductFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.deductFlag);
        $scope.borrowTaskVo.remark = "";
    });

    $http.get('orig_file_detail/findOrigFileBorrowMailByBorrowTaskNo?borrowTaskNo='+$location.search()['serviceId']).success(function (data) {
        if(data.code == Response.successCode){
            //参数配置
            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'orig_file_borrow_mail_table',
                //table的列
                dataTableColumn: [
                    {title:'<label class="i-checks i-checks-sm m-b-none"><input type="checkbox" name="all_checked"><i></i></label>',
                        data:'bizCode',
                        width:'3%',
                        render: function(data,type,row,meta){
                            var dataName = replaceIdData('bizCode');
                            var dataCheckBoxName = replaceIdData('ids','');
                            return '<label class="i-checks i-checks-sm m-b-none"><input type="checkbox" value="'+data+'" name="'+dataCheckBoxName+'" disabled><i></i></label>'
                        }
                    },
                    {title:'业务号',data:'bizCode',width:'20%'},
                    {title:'业务类型',data:'bizCodeType',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizCodeType,data);
                        }
                    },
                    {title:'附件类型',data:'fileTypeName',width:'20%'},
                    {title:'文件数量',data:'fileQtyLimit',width:'20%'},
                    {title:'归档编号',data:'fileRecordNo',width:'20%'},
                    {title:'文件状态',data:'origFileDetailStatus',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.origFileDetailStatus,data);
                        }
                    },
                ],
                //列是单选还是多选 CheckBox多选 Radio单选
                dataTableSelectType: 'onlyClickTd',
                dataTableData: data.data
            };
            $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties, $scope);
        }else {
            modalAlert($modal, data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    //增加银行信息
    $scope.add = function () {
        var obj = {
            /*recAccBank:'',
             recAccountName:'',
             recAccountNo:'',
             eleAccountNo:'',
             recAccountAmount:0,
             remark1:'',*/
            receiptDate: getToday()
        };
        $scope.contReceiptVoList.push(obj);
    };
    //删除银行信息
    $scope.del = function (index) {
        $scope.contReceiptVoList.splice(index,1);
    };

    // 回寄资管审核提交
    $scope.receiptConfirm = function () {
        if (!$scope.form.$invalid){
            $scope.submit = true;
            if(isNullEmpty($scope.contReceiptVoList) || $scope.contReceiptVoList.length==0){
                modalAlert($modal,"请选择收款银行后再提交！");
                $scope.submit = false;
                return;
            }
            $http.post('orig_file_detail/receiptConfirm',
                {
                    'contReceiptVoList':$scope.contReceiptVoList,
                    'borrowTaskNo':$scope.borrowTaskVo.borrowTaskNo,
                    'taskId':$scope.borrowTaskVo.taskId,
                    'remark':$scope.borrowTaskVo.remark,
                }
            ).success(function (data) {
                if(data.code == Response.successCode){
                    //财务确认成功地址跳转地址
                    $location.path("app/home").search({'type':'homeToastInfo', 'msg':'财务确认提交成功'});
                }else {
                    modalAlert($modal, data.message);
                    $scope.submit = false;
                }
            }).error(function (err) {
                modalAlert($modal,err);
                $scope.submit = false;
            });
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    //退回
    $scope.backUp = function () {
        if (!$scope.form.$invalid){
            $scope.submit = true;
            $http.post('orig_file_detail/receiptConfirmBack',
                {
                    'contReceiptVoList':$scope.contReceiptVoList,
                    'borrowTaskNo':$scope.borrowTaskVo.borrowTaskNo,
                    'taskId':$scope.borrowTaskVo.taskId
                }
            ).success(function (data) {
                if(data.code == Response.successCode){
                    //财务确认成功地址跳转地址
                    $location.path("app/home").search({'type':'homeToastInfo', 'msg':'财务确认退回交成功'});
                }else {
                    $scope.submit = false;
                    modalAlert($modal, data.message);
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

    //数据字典类型选择
    $scope.selectBasBankInfo = function(index){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_bank_info_select_controller',
            resolve:{
                selectBank: function () {
                    return {'organizationType':CommonCodeUtils.organizationType.userGroup};
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.contReceiptVoList[index].recAccBank = data.accBankName;
                $scope.contReceiptVoList[index].recAccountName = data.accountName;
                $scope.contReceiptVoList[index].recAccountNo = data.accountNo;
                $scope.contReceiptVoList[index].eleAccountNo = data.eleAccountNo;
                $scope.contReceiptVoList[index].recAccBranch = data.accBranchBank;
            }
        },function(){
        });
    }

    //返回到主页
    $scope.backHome = function () {
        $location.path('app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.origBorrow;
    $scope.wfLogNo = $location.search()['serviceId'];
}]);


