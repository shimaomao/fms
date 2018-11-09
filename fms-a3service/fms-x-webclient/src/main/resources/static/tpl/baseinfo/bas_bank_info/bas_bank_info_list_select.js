/**
 * Created by yanfengbo on 2018-03-26.
 */
app.controller('bas_bank_info_select_controller', ['$scope', '$http', '$modal','$modalInstance', 'toaster','$compile','$location','selectBank', function ($scope, $http, $modal,$modalInstance, toaster,$compile,$location,selectBank) {
    //开户行
    $scope.openingBankList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.openingBank);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'bas_bank_info/findBasBankInfosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_bank_info_select_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('bankId'),
            {title:'开户行',data:'accBank',width:'20%',
                render: function (data, type, row, meta) {
                    value= CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.openingBank,data);
                    row['accBankName'] = value;
                    return '<a class="a1" ng-click="detailAccBank(\'' + row['bankId'] + '\')">'+value+'</a>';
                },
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    $compile(nTd)($scope);
                }},
            {title:'分行名称',data:'accBranchBank',width:'20%'},
            {title:'开户名',data:'accountName',width:'20%'},
            {title:'银行账号',data:'accountNo',width:'20%'},
            {title:'银行账号类型',data:'organizationType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.organizationType,data);
                }
            },
            {title:'机构信息',data:'organizationId',width:'20%',
                render: function (data, type, row, meta) {
                    var index = row.organizationType;
                    if(index == 4){
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsAccType,data);
                    }else if(index == 5){
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.mortgageAccType,data);
                    }else if(index == 6) {
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.insuranceAccType,data);
                    }else {
                        return data;
                    }
                }
            },
            {title:'银行账号状态',data:'accountNoStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.accountNoStatus,data);
                }
            },
            {title:'开户行省份',data:'accOpBankProv',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'开户行城市',data:'accOpBankCity',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'电子联行号',data:'eleAccountNo',width:'20%'},
            {title:'是否默认账号',data:'accDefault',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.accDefault,data);
                }
            },
            {title:'启用标志',data:'enableFlag',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,data);
                }
            },
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.accBranchBank = $scope.accBranchBank;
        params.accountName = $scope.accountName;
        params.accountNo = $scope.accountNo;
        params.enableFlag='0';//启用状态的银行账户
        params.accountNoStatus='1102';//审批通过银行账户
        if(CommonObjectUtils.isExist(selectBank))
            params.organizationType = selectBank.organizationType;
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
        $scope.accBranchBank = "";
        $scope.accountName = "";
        $scope.accountNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    //点击一条开户行直接获取
    $scope.detailAccBank = function (bankId) {
        var data = $scope.dataTable.getRow(bankId,'bankId');
        $modalInstance.close(data);
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
            var data = $scope.dataTable.getRow();
            if(data == null)
                modalAlert($modal,'请选择银行');
            else
                $modalInstance.close(data);
        }else{
            var data = {id:0,realName:'无上级'};
            $modalInstance.close(data);
        }
    }
}])
;