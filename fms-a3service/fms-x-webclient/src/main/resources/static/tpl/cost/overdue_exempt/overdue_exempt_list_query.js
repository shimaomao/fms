/**
 * Created by yanfengbo on 2018-05-30.
 */
app.controller('overdue_exempt_list_query_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'overdue_exempt/findOverdueExemptsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'overdue_exempt_query_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('overdueExemptId'),
            defaultDetail('contNo','overdueExemptQueryDetail','合同编号','20%',$compile,$scope,'overdueExemptId'),
            /*{title:'合同编号',data:'contNo',width:'20%'},*/
            {title:'出租人',data:'groupName',width:'10%'},
            {title:'承租人',data:'cstmName',width:'20%'},
            {title:'车架号',data:'vinNo',width:'10%'},
            {title:'罚息免除任务号',data:'overdueExemptNo',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'罚息免除任务状态',data:'overdueExemptStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data);
                }
            },
            {title:'当前节点用户',data:'presentUser',width:'20%'},
            {title:'申请免除金额',data:'applyExemptAmount',width:'20%'},
            {title:'申请时间',data:'overdueDate',width:'20%'},
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.cstmName = $scope.cstmName;
        params.contNo = $scope.contNo;
        params.groupDistrict = $scope.groupDistrict;
        params.vinNo = $scope.vinNo;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchOverdueExempt = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetOverdueExempt = function(){
        $scope.cstmName ="";
        $scope.contNo ="";
        $scope.groupDistrict = "";
        $scope.vinNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    $scope.overdueExemptQueryDetail = function(overdueExemptId){
        var rowData = $scope.dataTable.getRow(overdueExemptId,"overdueExemptId")
        $location.path('/app/cost_overdue_exempt_detail_query').search({'overdueExemptNo': rowData.overdueExemptNo});

    }
}])
;
