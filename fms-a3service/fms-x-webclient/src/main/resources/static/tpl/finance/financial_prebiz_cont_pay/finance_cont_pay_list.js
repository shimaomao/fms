/**
 * Created by yebangqiang on 2018-07-20.
 */
app.controller('cont_pay_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'prebiz_cont_pay_detail/findContPayInfoByPage',
            type:"GET"
        },
        //table的html id
        dataTableId:'cont_pay_table',
        //table的列
        dataTableColumn: [
            {title:'融资合同编号',data:'contractNo',width:'10%'},
            {title:'出租人',data:'groupName',width:'10%'},
            {title:'承租人',data:'userName',width:'10%'},
            {title:'产品方案名称',data:'productName',width:'10%'},
            {title:'租赁属性',data:'licenseAttr',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data);
                }
            },
            {title:'融资期限',data:'finPeriodType',width:'10%'},
            {title:'融资金额',data:'finTotal',width:'10%'},
            {title:'付款金额',data:'payAmount',width:'10%'},
            {title:'首付金额',data:'initAmount',width:'10%'},
            {title:'尾付金额',data:'finalAmount',width:'10%'},
            {title:'付款方名称',data:'payAccountName',width:'10%'},
            {title:'付款方银行',data:'payAccBank',width:'10%'},
            {title:'付款方支行',data:'payAccBranch',width:'10%'},
            {title:'付款方帐号',data:'payAccountNo',width:'10%'}
        ]
    };

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.contractNo = $scope.contractNo;
        params.userName = $scope.userName;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchContPayDetailList = function(){
        $scope.dataTable.fnDraw(true);
    };

    $scope.resetContPayDetailList = function(){
        $scope.contractNo = "";
        $scope.applyNo = "";
        $scope.userName = "";
        $scope.dataTable.fnDraw(true);//刷新
    };
}])
;