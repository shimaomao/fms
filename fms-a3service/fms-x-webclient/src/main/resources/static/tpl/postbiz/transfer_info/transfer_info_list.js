/**
 * Created by wangxue on 2018-08-30.
 */
app.controller('transfer_info_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {
    //查询参数
    $scope.params = setData.getter();
    // 判断显示message
    $scope.timer = $timeout(function () {
        var message = $location.search()['msg'];
        if (isNotUndefinedNull(message) && isNotEmpty(message)) {
            toaster_success(message, toaster);
        }
    }, 100);

    // 获取过户状态list
    $scope.transferStsList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.transferSts);
    // 抵押状态
    $scope.mortgageStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.mortgageStatus);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'transfer_info/findTransferInfosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'transfer_info_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contNo'),
            // defaultDetail('transferNo','detailTransferInfo','过户任务号','20%',$compile,$scope,'contNo'),
            defaultDetail('contNo','detailTransferInfo','合同号','20%',$compile,$scope,'contNo'),
            {title:'承租人',data:'cstmName',width:'20%'},
            {title:'出租人',data:'belongGroup',width:'20%'},
            {title:'地区',data:'groupDistrict',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            // {title:'合同编号',data:'contNo',width:'20%'},
            {title:'过户状态',data:'transferSts',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.transferSts,data);
                }
            },
            {title:'结清状态',data:'paymentSts',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.paymentSts,data);
                }
            },
            {title:'抵押状态',data:'mortgageStatus',width:'20%',
                render:function(data){
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.mortgageStatus,data)
                }
            },
            {title:'资方',data:'management',width:'20%',
                render:function(data){
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.management,data)
                }
            },
            {title:'登记证文件状态',data:'origFileDetailStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.origFileDetailStatus,data);
                }
            },
            {title:'登记证邮寄日期',data:'postDate',width:'20%'},
            {title:'成交日期',data:'contractValidDate',width:'20%'},
            {title:'融资期限',data:'finPeriodType',width:'20%'},
            {title:'融资额',data:'finTotal',width:'20%'},
            {title:'车牌号',data:'vehicleLicenseNo',width:'20%'},
            {title:'发动机号',data:'engineNo',width:'20%'},
            {title:'过户处理状态',data:'transferHandleSts',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data);
                }
            },
            {title:'当前节点用户',data:'presentUser',width:'20%'},
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


    $scope.searchTransferInfo = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetTransferInfo = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    };

    // 过户申请
    $scope.transferApply = function (){
        var rowIds = $scope.dataTable.getRows();
        if (rowIds.length < 1){
            modalAlert($modal,'请选择需要操作的数据');
        } else {
            var contNo = rowIds[0].contNo;// 合同编号
            $http.get('transfer_info/findTransferInfoByContNo?contNo='+ contNo).success(function (result) {
                if(result.code == Response.successCode) {
                    var data = result.data;
                    if (isNotUndefinedNull(data) && data.transferHandleSts != CommonCodeUtils.codeValues.transferStsSave) {
                        modalAlert($modal,"过户申请已提交，不可重复发起");
                    } else {
                        // 跳转到过户申请页面
                        $location.path('/app/postbiz_transfer_apply').search({'contNo':contNo, 'transferNo': rowIds[0].transferNo});
                    }
                }else{
                        modalAlert($modal,result.message);
                }
            }).error(function (err) {
                modalAlert($modal,err);
            });

        }
    };

    // 违章查询
    $scope.violationInquiry = function () {
        var rowIds = $scope.dataTable.getRows();
        if (rowIds.length < 1){
            modalAlert($modal,'请选择需要操作的数据');
        } else {
            var contNo =  rowIds[0].contNo;// 合同编号
            // $location.path('/app/postbiz_transfer_apply').search({'contNo':contNo});
        }
    };

    // 借阅申请
    $scope.borrowApply = function () {
        var rowIds = $scope.dataTable.getRows();
        if (rowIds.length < 1){
            modalAlert($modal,'请选择需要操作的数据');
        } else {
            for(var i = 0;i<rowIds.length;i++){
                if(rowIds[i].origFileTaskStatus!='0300'){
                    modalAlert($modal,"合同附件归档未完成，无法申请借阅");
                    return;
                }
            }
            var id = rowIds[0].contNo;
            var url = 'app.original_file_borrow_detail?bizCode=' + rowIds[0].contNo
                + '&bizCodeType=' + rowIds[0].bizCodeType
                + '&fileRecordNo=' + rowIds[0].fileRecordNo
                + '&origFileType=' + rowIds[0].origFileType
                + '&skipType=' + "true"
                + '&isTransfer=' + "true"; // "isTransfer"是用来判断是否是由过户相关页面打开借阅申请，非过户相关页面不需要传递此值
            var title = '借阅申请';
            var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
            if(window.parent.addTab){
                window.parent.addTab(html);
            }
        }
    };

    // 查看详情
    $scope.detailTransferInfo = function (contNo) {
        var data = $scope.dataTable.getRow(contNo,'contNo');
        if (data != null) {
            $location.path('/app/postbiz_transfer_detail').search({'contNo':data.contNo, 'transferNo': data.transferNo});
        }
    }

}])