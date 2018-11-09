/**
 * Created by ningyangyang on 2018-07-22.
 */
app.controller('borrow_task_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','setData', function ($scope, $http, $modal, toaster,$compile,$location,setData) {

    //查询参数
    $scope.params = setData.getter();
    //订单状态
    $scope.bizStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.bizStatus);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'borrow_task/findBorrowTasksByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'borrow_task_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('borrowTaskId'),
            defaultDetail('borrowTaskNo','detailBorrowTask','借阅任务号','20%',$compile,$scope,'borrowTaskId'),
            {title:'承租人',data:'cstmName',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            //{title:'归档编号',data:'fileRecordNo',width:'20%'},
            {title:'申请人',data:'borrowUser',width:'20%'},
            {title:'申请人联系方式',data:'borrowUserTel',width:'20%'},
            {title:'借阅任务状态',data:'borrowTaskStatus',width:'20%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data)
                }
            },
            {title:'借阅资料',data:'origFileDetailNames',width:'20%'},
            {title:'借阅用途',data:'borrowPurpose',width:'20%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.borrowPurpose,data);
                }
            },
            {title:'领取方式',data:'borrowGetWay',width:'20%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.borrowGetWay,data);
                }
            },
            {title:'预计归还时间',data:'expectedReturnDate',width:'20%'},
            {title:'邮寄详细地址',data:'postDetailAddress',width:'20%'},
            {title:'是否交押金',data:'depositFlag',width:'20%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.depositFlag,data);
                }
            },
            {title:'押金金额',data:'depositAmount',width:'20%'},
            {title:'当前用户',data:'presentUser',width:'20%'},
            {title:'备注',data:'remark',width:'20%'},
            {title:'快递公司',data:'postComp',width:'20%'},
            {title:'快递编号',data:'postNo',width:'20%'},
            {title:'邮寄日期',data:'postDate',width:'20%'},
            {title:'邮寄人员',data:'postMember',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope){
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchBorrowTask = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetBorrowTask = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }



    $scope.detailBorrowTask = function(borrowTaskId){
        var rowId= $scope.dataTable.getRow(borrowTaskId,'borrowTaskId');
        if (isUndefinedNull(rowId)){
            modalAlert($modal,'请选择需要操作的数据');
        }  else {
            $location.path('/app/original_file_borrow_details').search({"borrowTaskNo": rowId.borrowTaskNo});
        }
    }


}])
;