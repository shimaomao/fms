app.controller('orig_file_borrow_detail_controller', ['$scope', '$http','$modal','$compile','$location','toaster', function ($scope, $http,$modal,$compile,$location,toaster) {

    $scope.submit = false;
    $scope.formValidate = false;
    $scope.firstFlag = false;
    var ars = new Array();
    $scope.backShow = $location.search()['skipType'] ? false : true;
    $scope.OrigFileBorrowPostVo = {borrowTaskNo:$location.search()['serviceId'] || '', taskId:$location.search()['taskId'] || ''};
    $scope.borrowTaskNo = $location.search()['serviceId'] || '';
    if(isNotUndefinedNull($scope.borrowTaskNo) && isNotEmpty($scope.borrowTaskNo)){
        $scope.secondSubmit = true;
    }else{
        $scope.secondSubmit = false;
    }

    if ($location.search()['serviceParameter']){
        $scope.OrigFileBorrowPostVo.bizCode = $location.search()['serviceParameter'].paramVariables.bizCode;
        $scope.OrigFileBorrowPostVo.bizCodeType = $location.search()['serviceParameter'].paramVariables.bizCodeType;
        $scope.OrigFileBorrowPostVo.fileRecordNo = $location.search()['serviceParameter'].paramVariables.fileRecordNo;
        $scope.fileType = $location.search()['serviceParameter'].paramVariables.origFileType;
    } else {
        $scope.OrigFileBorrowPostVo.fileRecordNo = $location.search()['fileRecordNo'];
        $scope.OrigFileBorrowPostVo.bizCode = $location.search()['bizCode'];
        $scope.OrigFileBorrowPostVo.bizCodeType = $location.search()['bizCodeType'];
        $scope.fileType = $location.search()['origFileType'];
    }
    $scope.OrigFileBorrowPostVo.depositFlag = '0';//是否有押金-否
    $scope.OrigFileBorrowPostVo.depositAmountFlag = "";//金额不可编辑
    $scope.OrigFileBorrowPostVo.flag = '2';
    $scope.detailFlag = 0;
    //是否需要交押金
    $scope.depositFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.depositFlag)
    //附件对象
    $scope.bizFilesList= [];
    $scope.httpData = false;
    $scope.notUpload = false;
    $scope.msgInfo = null;

    // $scope.treeFileId = "orig_file_borrow_file_tree";

    $http.get('orig_file_detail/findOrigFileBorrowDetails?bizCode='+$scope.OrigFileBorrowPostVo.bizCode+'&bizCodeType='+$scope.OrigFileBorrowPostVo.bizCodeType+'&fileType='+$scope.fileType
        +'&borrowTaskNo='+$scope.OrigFileBorrowPostVo.borrowTaskNo).success(function (data) {
        $scope.OrigFileBorrowPostVo = data.data;
        console.log($scope.OrigFileBorrowPostVo);

        //如果是过户相关页面过来，初始化借阅用途为‘02:过户’
        var isTransfer = $location.search()['isTransfer'];
        if(isTransfer){
            $scope.OrigFileBorrowPostVo.borrowPurpose = CommonCodeUtils.borrowPurpose.transfer;
        }

        //附件赋值
        $scope.bizFilesList = $scope.OrigFileBorrowPostVo.bizFilesList;
        $scope.bizFileType = $scope.OrigFileBorrowPostVo.origFileType;
        $scope.httpData = true;
        // $scope.OrigFileBorrowPostVo.bizFilesInfo = data.data.commonBizFilesVo.bizFilesInfo;
        // $scope.OrigFileBorrowPostVo.bizFilesListVos = data.data.commonBizFilesVo.bizFilesListVos;
        // $scope.bizFilesList.bizFilesInfo = $scope.OrigFileBorrowPostVo.bizFilesInfo;
        // $scope.bizFilesList.bizFilesListVos = $scope.OrigFileBorrowPostVo.bizFilesListVos;

        if(data.code == Response.successCode){

            checkKey(data.data.origFileDetailVoList);

            //参数配置
            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'orig_file_borrow_table',
                //table的列
                dataTableColumn: [
                    {title:'<label class="i-checks i-checks-sm m-b-none"><input type="checkbox" name="all_checked"><i></i></label>',
                        data:'bizCode',
                        width:'3%',
                        render: function(data,type,row,meta){
                            var dataName = replaceIdData('bizCode');
                            var dataCheckBoxName = replaceIdData('ids','');
                            if($scope.secondSubmit)
                                return '<label class="i-checks i-checks-sm m-b-none"><input type="checkbox" value="'+row.fileType+'" name="'+dataCheckBoxName+'" checked disabled><i></i></label>';
                            return '<label class="i-checks i-checks-sm m-b-none"><input type="checkbox" value="'+row.fileType+'" name="'+dataCheckBoxName+'"><i></i></label>';
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
                    {title:'文件状态',data:'origFileDetailStatus',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.origFileDetailStatus,data);
                        }
                    },
                    {title:'当前借出人',data:'borrowUser',width:'20%'},
                    {title:'归档编号',data:'fileRecordNo',width:'20%'},
                ],
                //列是单选还是多选 CheckBox多选 Radio单选
                dataTableSelectType: 'onlyClickTd',
                dataTableData: data.data.origFileDetailVoList
            };
            $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties, $scope,function (val,type,$scope) {
                if($scope.secondSubmit)//如果是二次提交
                    return;
                if (type){
                    ars.push(val);
                } else {
                    remove(val, ars);
                }
                if(isInArray(ars, CommonCodeUtils.carkey.carkey)){
                    $scope.OrigFileBorrowPostVo.flag = '1';
                    if (!$scope.firstFlag){
                        $scope.OrigFileBorrowPostVo.depositFlag = '';//是否有押金-恢复默认
                        $scope.firstFlag = true;
                    }
                } else {
                    $scope.OrigFileBorrowPostVo.flag = '2';
                    $scope.OrigFileBorrowPostVo.depositFlag = '0';//是否有押金-否
                    $scope.OrigFileBorrowPostVo.depositAmount = '';//清空押金
                    $scope.firstFlag = false;
                }
                $scope.$apply();

            });
        }else {
            modalAlert($modal, data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    //是否交押金监视
    $scope.$watch('OrigFileBorrowPostVo.depositFlag', function(){
        if($scope.OrigFileBorrowPostVo.depositFlag == '0'){
            //是否交押金为"否"的场合
            $scope.OrigFileBorrowPostVo.depositAmountFlag = '';//金额不可编辑
            $scope.OrigFileBorrowPostVo.depositAmount = '0';
        }else{
            //是否交押金为"是"的场合
            $scope.OrigFileBorrowPostVo.depositAmountFlag = '1';//金额可编辑
        }
    })
    
    //提交
    $scope.submitOrigFileBorrow = function () {
        if(!$scope.form.$invalid) {
            var rowsIds = [];
            if($scope.secondSubmit){//二次申请
                rowsIds =  $scope.dataTable.fnGetData();
            }else{
                rowsIds = $scope.dataTable.getRows();
                for (var i in rowsIds){
                    // if (rowsIds[i].origFileDetailStatus != '3' && rowsIds[i].origFileDetailStatus != '5'){
                    if (rowsIds[i].origFileDetailStatus != '3'){
                        // modalAlert($modal,'只能借阅已归档或借阅中的文件！');
                        modalAlert($modal,'只能借阅已归档的文件！');
                        return;
                    }
                }
            }

            if(rowsIds.length < 1){
                modalAlert($modal,'请选择数据');
                $scope.submit = false;
            }else {
                $scope.submit = true;
                $http.post('orig_file_detail/borrowTask',
                    {
                        "origFileDetailVoList":rowsIds,
                        "fileRecordNo":$scope.OrigFileBorrowPostVo.fileRecordNo,
                        "borrowTaskNo":$scope.borrowTaskNo,
                        "borrowUser":$scope.OrigFileBorrowPostVo.borrowUser,
                        "borrowUserTel":$scope.OrigFileBorrowPostVo.borrowUserTel,
                        "postDetailAddress":$scope.OrigFileBorrowPostVo.postDetailAddress,
                        "depositFlag":$scope.OrigFileBorrowPostVo.depositFlag,
                        "borrowGetWay":$scope.OrigFileBorrowPostVo.borrowGetWay,
                        "depositAmount":$scope.OrigFileBorrowPostVo.depositAmount,
                        "remark":$scope.OrigFileBorrowPostVo.remark,
                        "bizCode":$scope.OrigFileBorrowPostVo.bizCode,
                        "bizCodeType":$scope.OrigFileBorrowPostVo.bizCodeType,
                        "taskId":$location.search()['taskId'],
                        "origFileType":$scope.fileType,
                        "expectedReturnDate":$scope.OrigFileBorrowPostVo.expectedReturnDate,
                        "borrowPurpose":$scope.OrigFileBorrowPostVo.borrowPurpose,
                    }
                ).success(function (data) {
                    if(data.code == Response.successCode){
                        if (!$scope.backShow) {
                            // 从其他也面跳转，不是从列表和主页过来
                            toaster_success('借阅申请提交成功', toaster);
                            window.parent.removeTabById(window.frameElement.id); // 关闭页签
                        } else if($location.search()['serviceParameter']){
                            $location.path("app/home").search({"type": 'homeToastInfo', "msg":'借阅申请提交成功'});
                        } else{
                            $location.path('app/original_file_borrow').search({'msg':'借阅申请提交成功'});
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

    //二次提交检查是否有车钥匙
    function checkKey(arr){
        if($scope.secondSubmit && arr && arr.length>0){
            for(var i = 0; i < arr.length; i++){
                if((arr[i].fileType+"").substring(0,6) == CommonCodeUtils.carkey.carkey){
                    $scope.OrigFileBorrowPostVo.flag = '1';
                }
            }
        }
    }

    /**
     * 使用循环的方式判断一个元素是否存在于一个数组中
     * @param {Object} arr 数组
     * @param {Object} value 元素值
     */
    function isInArray(arr,value){
        for(var i = 0; i < arr.length; i++){
            if((arr[i]+"").substring(0,6) == value){
                return true;
            }
        }
        return false;
    }

    function remove(val, arr) {
        var index = arr.indexOf(val);
        if (index > -1) {
            arr.splice(index, 1);
        }
    };

    $scope.backUp=function () {
        if($location.search()['serviceParameter']){
            $location.path("app/home");
        } else{
            $location.path('app/original_file_borrow');
        }
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.origBorrow;
    $scope.wfLogNo = $location.search()['serviceId'];
}]);


