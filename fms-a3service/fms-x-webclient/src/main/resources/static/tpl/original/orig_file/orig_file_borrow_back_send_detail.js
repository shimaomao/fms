app.controller('orig_file_borrow_back_send_detail_controller', ['$scope', '$http','$modal','$compile','$location', function ($scope, $http,$modal,$compile,$location) {

    $scope.submit = false;
    $scope.formValidate = false;
    $scope.borrowTaskVo = {};

    $scope.backShow = $location.search()['skipType'] ? false : true;
    if ($location.search()['serviceParameter']){
        $scope.borrowTaskVo.borrowTaskNo = $location.search()['serviceParameter'].paramVariables.borrowTaskNo;
    }else {
        $scope.borrowTaskVo.borrowTaskNo = $location.search()['borrowTaskNo'];
    }
    $scope.borrowTaskVo.taskId = $location.search()['taskId'];
    $scope.borrowTaskVo.borrowBackTaskNo = $location.search()['serviceId'];

    $http.get("orig_file_detail/findOrigFileBorrowTaskInfo?borrowTaskNo="+$scope.borrowTaskVo.borrowTaskNo
        +'&borrowBackTaskNo='+ $scope.borrowTaskVo.borrowBackTaskNo).success(function (data) {
        if(data.code == Response.successCode){
        $scope.borrowTaskVo = data.data;
        if (!$scope.borrowTaskVo.depositAmount){
            $scope.borrowTaskVo.depositAmount = 0;
        }

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
                dataTableData: data.data.origFileDetailVoList,
            };
            $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties, $scope);
        }else {
            modalAlert($modal, data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    //归还申请提交
    $scope.submitOrigFileBorrow = function () {
        $scope.borrowTaskVo.taskId = $location.search()['taskId'];
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            var rowsIds = $scope.dataTable.fnGetData();
            if(rowsIds.length < 1){
                $scope.submit = false;
                modalAlert($modal,'请选择数据');
            }else {
                if(!$scope.borrowTaskVo.taskId){//如果任务号不存在
                    for (var i in rowsIds){
                        if (rowsIds[i].origFileDetailStatus != '6'){
                            modalAlert($modal, "只能归还已借出的文件，请检查文件状态！");
                            $scope.submit = false;
                            return;
                        }
                    }
                }
                $scope.borrowTaskVo.origFileDetailVoList = rowsIds;
                $http.post('orig_file_detail/borrowTaskMailConfirm',$scope.borrowTaskVo).success(function (data) {
                    if(data.code == Response.successCode){
                        if (!$scope.backShow) {
                            // 从其他也面跳转，不是从列表和主页过来
                            //toaster_success('借阅归还申请提交成功', toaster);
                            window.parent.removeTabById(window.frameElement.id); // 关闭页签
                        } else if($location.search()['serviceParameter']){
                        $location.path("app/home").search({"type": 'homeToastInfo', 'msg':'借阅归还申请成功'});
                        }else{
                            $location.path('app/original_file_borrow_back_send_list').search({'msg':'借阅归还申请成功'});
                        }

                    }else {
                        modalAlert($modal, data.message);
                    }
                    $scope.submit = false;
                }).error(function (err) {
                    $scope.submit = false;
                    modalAlert($modal,err);
                });
            }
        } else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    $scope.backUp=function () {
        if($location.search()['serviceParameter']){
            $location.path('app/home');
        }else{
        $location.path('app/original_file_borrow_back_send_list');
        }

    };

    //数据银行信息
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
    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.origBorrowBack;
    $scope.wfLogNo = $location.search()['serviceId'];

}]);


