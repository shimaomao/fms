app.controller('orig_file_borrow_re_examine_controller', ['$scope', '$http','$modal','$compile','$location','toaster', function ($scope, $http,$modal,$compile,$location,toaster) {

    $scope.submit = false;
    $scope.formValidate = false;
    $scope.borrowTaskVo = {};
    $scope.origFileDetailVo = {};
    $http.get('borrow_task/findBorrowTaskByBorrowTaskNo?borrowTaskNo='+$location.search()['serviceId']).success(function (data) {
        $scope.borrowTaskVo = data.data;
        console.log($scope.borrowTaskVo);
        console.log($scope.borrowTaskVo.borrowPurpose);
        //借阅审批操作类型
        // $scope.borrowTaskVo.depositFlag = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.depositFlag, $scope.borrowTaskVo.depositFlag);
        $scope.borrowTaskVo.borrowTaskStatus = '0';
        $scope.borrowTaskVo.remark = "";
        $scope.borrowTaskVo.taskId = $location.search()['taskId'];
        $scope.borrowTaskVo.borrowTaskNo = $location.search()['serviceId'];
    });

    $http.get('orig_file_detail/findOrigFileBorrowMailByBorrowTaskNo?borrowTaskNo='+$location.search()['serviceId']).success(function (data) {
        $scope.origFileDetailVo.origFileDetailVoList = data.data;
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

    //提交复核
    $scope.submitOrigFileBorrow = function () {
        if (!$scope.form.$invalid){
            $scope.submit = true;
            $scope.borrowTaskVo.origFileDetailVoList = $scope.origFileDetailVo.origFileDetailVoList;
            //复核通过流程
            $http.post('orig_file_detail/borrowTaskReExamine',$scope.borrowTaskVo).success(function (data) {
                if(data.code == Response.successCode){
                    //审核通过跳转地址
                    $location.path("app/home").search({"type": 'homeToastInfo', "msg":'资管复核提交成功'});
                }else {
                    modalAlert($modal, data.message);
                }
                $scope.submit = false;
            }).error(function (err) {
                $scope.submit = false;
                modalAlert($modal,err);
            });
        } else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    //复核没有退回
    $scope.origFileBorrowBack=function () {
        //复核退回流程
        $http.post('orig_file_detail/borrowTaskReExamineBack',$scope.borrowTaskVo).success(function (data) {
            if(data.code == Response.successCode){
                //审核通过跳转地址
                $location.path("app/home").search({"type": 'homeToastInfo', "msg":'资管退回提交成功'});
            }else {
                modalAlert($modal, data.message);
            }
            $scope.submit = false;
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };

    //取消
    $scope.cancelOrigFileBorrow = function () {
        $scope.submit = true;
        $scope.borrowTaskVo.origFileDetailVoList = $scope.origFileDetailVo.origFileDetailVoList;
        $http.post('orig_file_detail/cancelOrigFileBorrow',$scope.borrowTaskVo).success(function (data) {
            if(data.code == Response.successCode){
                $location.path("app/home").search({"type": 'homeToastInfo', "msg":'取消成功'});
            }else {
                $scope.submit = false;
                modalAlert($modal, data.message);
            }
        }).error(function (err) {
            $scope.submit = false;
            modalAlert($modal,err);
        });
    };

    //返回主页
    $scope.backHome = function () {
        $location.path('app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.origBorrow;
    $scope.wfLogNo = $location.search()['serviceId'];
}]);


