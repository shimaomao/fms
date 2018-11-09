app.controller('orig_file_borrow_details_controller', ['$scope', '$http','$modal','$compile','$location','toaster', function ($scope, $http,$modal,$compile,$location,toaster) {

    $scope.submit = false;
    $scope.formValidate = false;
    $scope.borrowTaskVo = {};
    $scope.origFileDetailVo = {};
    $http.get('borrow_task/findBorrowTaskByBorrowTaskNo?borrowTaskNo='+$location.search()['borrowTaskNo']).success(function (data) {
        $scope.borrowTaskVo = data.data;
        console.log($scope.borrowTaskVo)
        //借阅审批操作类型
        $scope.borrowTaskVo.depositFlag = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.depositFlag, $scope.borrowTaskVo.depositFlag);
        if($scope.borrowTaskVo.depositFlag == '否'){
            $scope.borrowTaskVo.depositAmount = 0
        }
        $scope.borrowTaskVo.borrowTaskStatus = '0';
        $scope.borrowTaskVo.remark = "";
        $scope.borrowTaskVo.taskId = $location.search()['taskId'];
        $scope.borrowTaskVo.borrowTaskNo = $location.search()['borrowTaskNo'];
    });

    $http.get('orig_file_detail/findOrigFileBorrowMailByBorrowTaskNo?borrowTaskNo='+$location.search()['borrowTaskNo']).success(function (data) {
        $scope.origFileDetailVo.origFileDetailVoList = data.data;
        console.log(data.data)
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





    //返回主页
    $scope.backHome = function () {
        $location.path('app/original_borrow_task_list');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.origBorrow;
    $scope.wfLogNo = $location.search()['borrowTaskNo'];
}]);



