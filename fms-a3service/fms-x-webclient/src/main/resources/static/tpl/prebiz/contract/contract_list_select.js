
app.controller('contract_select_controller', ['$scope', '$http', '$modal','$modalInstance', 'toaster','$compile','$location','selectData', function ($scope, $http, $modal,$modalInstance, toaster,$compile,$location,selectData) {
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'contract/findContractSelectListByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_bank_info_select_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contractId'),
            {title:'合同号',data:'contNo',width:'20%',
                render: function (data, type, row, meta) {
                    return '<a class="a1" ng-click="detailAccBank(\'' + row['contractId'] + '\')">'+data+'</a>';
                },
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    $compile(nTd)($scope);
                }},
            {title:'出租人',data:'groupName',width:'10%'},
            {title:'承租人',data:'name',width:'10%'},
            {title:'车架号',data:'vinNo',width:'10%'},
            {title:'业务类型',data:'licenseAttr',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data);
                }
            },
            {title:'车辆品牌',data:'vehBrandCodeName',width:'10%'},
            {title:'车型',data:'vehicleCodeName',width:'10%'},
            {title:'车牌号',data:'vehicleLicenseNo',width:'10%'},
            {title:'申请类型',data:'companyType1',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.companyType,data);
                }
            },{title:'产品名称',data:'productName',width:'10%'},
            {title:'融资期限',data:'finPeriodType',width:'10%'},
            {title:'申请金额',data:'investTotal',width:'10%'},
            // {title:'首付比例',data:'initPerc',width:'10%'},
            {title:'首付金额',data:'initAmount',width:'10%'},
            {title:'融资金额',data:'finTotal',width:'10%'},
            {title:'贷款利息',data:'loanInterest',width:'10%'},
            {title:'保证金',data:'deposit',width:'10%'},
            {title:'租金',data:'rent',width:'10%'},
            {title:'尾付金额',data:'finalAmount',width:'10%'},
            {title:'年供金额',data:'annualSupplyAmount',width:'10%'},
            {title:'标签价',data:'guidePrice',width:'10%'},
            {title:'成交价',data:'finAmount',width:'10%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.contNo = $scope.contNo;
        params.vinNo = $scope.vinNo;
        params.name = $scope.name;
        params.groupDistrict = $scope.groupDistrict;
        if(CommonObjectUtils.isExist(selectData)){

        }
        return params;
    }

    $scope.init = function() {
        //创建dataTable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    }

    $scope.searchBasBankInfo = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetBasBankInfo = function(){
        params = {};
        $scope.contNo = '';
        $scope.vinNo = '';
        $scope.name = '';
        $scope.groupDistrict = '';
        $scope.dataTable.fnDraw(true);//刷新
    }

    //点击直接获取
    $scope.detailAccBank = function (contractId) {
        var data = $scope.dataTable.getRow(contractId,'contractId');
        var rows = [data];//放进数组
        $modalInstance.close(rows);
    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close(null);
    };


    $scope.confirm = function(status){
        if(status != 'none') {
            var rows = $scope.dataTable.getRows();
            if(rows == null || rows.length == 0)
                modalAlert($modal,'请选择合同');
            else
                $modalInstance.close(rows);
        }else{
            var data = {id:0,realName:'无上级'};
            $modalInstance.close(data);
        }
    }
}])
;