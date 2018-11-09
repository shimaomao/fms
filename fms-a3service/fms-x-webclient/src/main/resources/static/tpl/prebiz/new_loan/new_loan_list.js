/**
 * Created by yangyiquan on 2018-04-28.
 */
app.controller('new_loan_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$localStorage','setData',function ($scope, $http, $modal, toaster,$compile,$location,$localStorage,setData) {

    $scope.censuDate = {censuDate:'#F{$dp.$D(\'censuMonth\')}',dateFmt:'yyyy-MM'};

    //查询参数
    $scope.params = setData.getter();

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'contract/findNewLoanByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'new_loan_table',
        //table的列
        dataTableColumn: [
            {title:'合同生效日期',data:'contractValidDate',width:'10%'},
            {title:'出租人',data:'groupName',width:'10%'},
            {title:'承租人',data:'name',width:'10%'},
            {title:'车架号',data:'vinNo',width:'10%'},
            {title:'业务类型',data:'licenseAttr',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data);
                }
            },
            {title:'产品名称',data:'productName',width:'10%'},
            {title:'类别',data:'companyType2',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.companyType2,data);
                }
            },
            {title:'车辆品牌',data:'vehBrandCodeName',width:'10%'},
            {title:'业务经理',data:'applyUserName',width:'10%'},
            {title:'融资期限',data:'finPeriodType',width:'10%'},
            {title:'申请金额',data:'investTotal',width:'10%'},
            {title:'首付金额',data:'initAmount',width:'10%'},
            {title:'融资金额',data:'finTotal',width:'10%'},
            {title:'贷款利息',data:'loanInterest',width:'10%'},
            {title:'保证金',data:'deposit',width:'10%'},
            {title:'尾付金额',data:'finalAmount',width:'10%'},
            {title:'购车合同金额',data:'carpriceFee',width:'20%'},
        ],
    }

    //请求的参数
    function dataTableParams($scope){
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchContractList = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetContractList = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }


    //导出数据表
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.prebiz,CommonServiceType.excelTypes.two,
            'contract/findNewLoanExport',dataTableParams($scope));
    }

}])
;