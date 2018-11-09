/**
 * Created by yanfengbo on 2018-03-26.
 */
app.controller('bas_bank_info_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {
    //开户行
    $scope.openingBankList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.openingBank);
    //银行账号类型
    $scope.organizationTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.organizationType);

    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加银行账号信息成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑银行账号信息成功',toaster);
        }
    }, 100);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'bas_bank_info/findBasBankInfosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_bank_info_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('bankId'),
            defaultDetail('groupCode','detailBasBankInfo','账号所属','20%',$compile,$scope,'bankId'),
            {title:'账号所属名称',data:'groupName',width:'20%'},
            {title:'银行账号类型',data:'organizationType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.organizationType,data);
                }
            },
            {title:'银行账号机构信息',data:'organizationId',width:'20%',
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
            {title:'当前节点用户',data:'presentUser',width:'20%'},
            {title:'开户名',data:'accountName',width:'20%'},
            {title:'开户行',data:'accBank',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.openingBank,data);
                }
            },
            {title:'分行名称',data:'accBranchBank',width:'20%'},
            {title:'银行账号',data:'accountNo',width:'20%'},
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
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    /*$scope.accBank = {};*/
    function dataTableParams($scope){
        params = {};
        angular.forEach($scope.openingBankList,function (data) {
            /*JSON.parse(JSON.stringify(data)).codeValueName*/
            //alert(JSON.stringify($scope.accBank));
            //alert(JSON.stringify(data.codeValueName))
            if($scope.accBank == data.codeValueName){
                $scope.accBank = data.codeValue;

            }
        })
        params.accBank = $scope.accBank;
        params.accountName = $scope.accountName;
        params.accountNo = $scope.accountNo;
        params.groupCode = $scope.groupCode;
        params.organizationType = $scope.organizationType;
        params.accBranchBank = $scope.accBranchBank;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchBasBankInfo = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetBasBankInfo = function(){
        $scope.accBank = "";
        $scope.accountName = "";
        $scope.accountNo = "";
        $scope.groupCode ="";
        $scope.organizationType ="";
        $scope.accBranchBank = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    // 添加
    $scope.saveBasBankInfo = function() {
        $location.path('app/baseinfo_bas_bank_info_handler').search({'frameTitle':'添加银行账户','operate':'save'});
    }

    // 修改
    $scope.modifyBasBankInfo = function(bankId) {


        var rowsIds =  $scope.dataTable.getRowsIds('bankId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var data = $scope.dataTable.getRow(bankId,'bankId')
            //银行账号状态状态为审批通过时才能修改
            if(data.accountNoStatus =='1102'){
                $location.path('/app/baseinfo_bas_bank_info_handler').search({
                    'frameTitle':'修改银行账户',
                    'operate':'update',
                    'bankId': rowsIds[0]
                });
            }else{
                modalAlert($modal,'本条数据不能更新！');
            }
        }
    }



    // 详情
    $scope.detailBasBankInfo = function(bankId) {
        console.log(bankId);
        $location.path('/app/baseinfo_bas_bank_info_detail').search({
            'frameTitle':'银行账户详情',
            'operate':'check',
            'bankId': bankId
        });
    }

    //删除
    $scope.deleteBasBankInfo = function(){
        var rows = $scope.dataTable.getRows();
        if(rows.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{
            modalConfirm($modal,function(){
                var rowsIds = new Array();
                for(var i=0;i<rows.length;i++){
                    if(rows[i].accountNoStatus!="1102"){
                        modalAlert($modal,'所选数据存在未审核通过的明细,无法删除!');
                        return;
                    }else {
                        rowsIds.push(rows[i].bankId);
                    }
                }
                $http.delete('bas_bank_info/deleteBasBankInfosByBankIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除银行账号信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

    //导出excel
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.baseinfo,CommonServiceType.excelTypes.one,
            'bas_bank_info/findBasBankInfosByPage',dataTableParams($scope));
    }

}])
;