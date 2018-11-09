app.controller('orig_file_borrow_back_send_examine_controller', ['$scope', '$http','$modal','$compile','$location', 'toaster',function ($scope, $http,$modal,$compile,$location,toaster) {

    $scope.submit = false;
    $scope.formValidate = false;
    $scope.borrowTaskVo = {};
    $http.get('borrow_back_task/findBorrowBackTaskByBorrowBackTaskNo?borrowBackTaskNo='+$location.search()['serviceId']).success(function (data) {
        $scope.borrowTaskVo = data.data;
        if (!$scope.borrowTaskVo.depositAmount){
            $scope.borrowTaskVo.depositAmount = 0;
        }
        $scope.borrowTaskVo.borrowBackTaskNo = $location.search()['serviceId'];
        $scope.borrowTaskVo.taskId = $location.search()['taskId'];
        //是否抵扣租金List
        $scope.deductFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.deductFlag);
        $scope.borrowTaskVo.remark = "";
    });

    $http.get('orig_file_detail/findOrigFileBorrowExamineByBorrowBackTaskNo?borrowBackTaskNo='+$location.search()['serviceId']).success(function (data) {
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
                    {title:'合同号',data:'bizCode',width:'20%'},
                    // {title:'业务类型',data:'bizCodeType',width:'20%',
                    //     render: function (data, type, row, meta) {
                    //         return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizCodeType,data);
                    //     }
                    // },
                    {title:'附件类型',data:'fileTypeName',width:'20%'},
                    // {title:'文件数量',data:'fileQtyLimit',width:'20%'},
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

    // 回寄资管审核提交
    $scope.submitOrigFileBorrow = function () {
        if (!$scope.form.$invalid){
            $scope.submit = true;
            $http.post('orig_file_detail/borrowBackTaskExamine',$scope.borrowTaskVo).success(function (data) {
                if(data.code == Response.successCode){
                    //资管审核通过地址跳转地址
                    $location.path("app/home").search({'type':'homeToastInfo', 'msg':'审核提交成功'});
                }else {
                    modalAlert($modal, data.message);
                }
                $scope.submit = false;
            }).error(function (err) {
                $scope.submit = false;
                modalAlert($modal,err);
            });
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    // 回寄资管审核退回上一级
    $scope.backUp = function () {
        $scope.submit = true;
        $http.post('orig_file_detail/borrowBackTaskExamineBack',$scope.borrowTaskVo).success(function (data) {
            if(data.code == Response.successCode){
                //资管审核通过地址跳转地址
                $location.path("app/home").search({'type':'homeToastInfo', 'msg':'退回成功'});
            }else {
                modalAlert($modal, data.message);
            }
            $scope.submit = false;
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };

    //数据字典类型选择
    $scope.selectBasBankInfo = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_bank_info_select_controller',
            resolve:{
                selectBank: function () {
                    return {organizationType: CommonCodeUtils.organizationType.individualAccount}
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.borrowTaskVo.recAccBank = data.accBankName;
                $scope.borrowTaskVo.recAccBranch = data.accBranchBank;
                $scope.borrowTaskVo.recAccountName = data.accountName;
                $scope.borrowTaskVo.recAccountNo = data.accountNo;
                $scope.borrowTaskVo.recEleBankNo = data.eleAccountNo;
            }
        },function(){

        });
    }

    $scope.backHome = function () {
        $location.path('app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.origBorrowBack;
    $scope.wfLogNo = $location.search()['serviceId'];
}]);


