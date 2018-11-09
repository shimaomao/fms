app.controller('orig_file_borrow_back_send_list_controller', ['$scope', '$http','$modal','$compile','$location','$timeout','toaster','setData',function ($scope, $http,$modal,$compile,$location,$timeout,toaster,setData) {
    //查询参数
    $scope.params = setData.getter();

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'orig_file_detail/findOrigFileBorrowBackSendByPage',
            type:"GET"
        },
        //table的html id
        dataTableId:'orig_file_borrow_back_send_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('origFileId'),
            {title:'合同号',data:'bizCode',width:'20%'},
            {title:'归档编号',data:'fileRecordNo',width:'20%'},
            {title:"承租人",data:'cstmName',width:'20%'},
            {title:"车架号",data:'vinNo',width:'20%'},
            {title:'当前节点用户',data:'presentUser',width:'20%'},
            {title:'借阅人',data:'borrowUser',width:'20%'},
            {title:'借阅任务号',data:'borrowTaskNo',width:'20%'},
            {title:'借阅资料',data:'origFileDetailNames',width:'20%'},
            {title:'是否交押金',data:'depositFlag',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.depositFlag,data);
                }
            },
            {title:'押金',data:'depositAmount',width:'20%'},
            // {title:'借阅状态',data:'borrowTaskStatus',width:'20%',
            //     render: function (data, type, row, meta) {
            //         return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data);
            //     }},
            {title:'借出邮寄时间',data:'borrowDate',width:'20%'},
            {title:'预计归还时间',data:'expectedReturnDate',width:'20%'},
            {title:'归还状态',data:'borrowBackTaskStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data);
                }},
            {title:'归还邮寄时间',data:'returnDate',width:'20%'},

        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    };

    //请求的参数
    function dataTableParams($scope){
       /* params = {};
        params.bizCode = $scope.bizCode;
        params.fileRecordNo = $scope.fileRecordNo;
        params.borrowUser = $scope.borrowUser;
        params.cstmName = $scope.cstmName;
        params.vinNo = $scope.vinNo;*/
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchOrigFile = function(){
        $scope.dataTable.fnDraw(true);
    };

    $scope.resetOrigFile = function(){
       /* $scope.bizCode = "";
        $scope.fileRecordNo = "";
        $scope.borrowUser = "";
        $scope.cstmName = "";
        $scope.vinNo = "";*/
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    };
    
    $scope.backSend = function () {
        var rowsIds = $scope.dataTable.getRows();
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择数据');
        } else if(rowsIds[0].borrowBackTaskStatus){
            modalAlert($modal,'已开启归还流程，不可操作');
        } else {
            var borrowTaskNo = rowsIds[0].borrowTaskNo;
            $location.path("app/original_file_borrow_back_send_detail").search({"borrowTaskNo": borrowTaskNo, "taskId":$location.search()['taskId']});
        }
    }
}]);


