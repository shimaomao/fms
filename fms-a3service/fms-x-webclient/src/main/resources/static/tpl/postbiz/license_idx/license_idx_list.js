/**
 * Created by license_idx on 2018-09-11.
 */
app.controller('license_idx_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', '$timeout', 'setData',function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {

    //查询参数
    $scope.params = setData.getter();
    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加指标信息成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑指标信息成功',toaster);
        }
    }, 100);
    //获取指标状态List
    $scope.licenseIdxStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseIdxStatus);
    //获取合同状态List
    $scope.bizStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.bizStatus);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'license_idx/findLicenseIdxsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'license_idx_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('licenseIdxId'),
            defaultDetail('licenseIdxNo','detailLicenseIdx','指标编号','20%',$compile,$scope,'licenseIdxId'),
            {title:'指标状态',data:'licenseIdxStatus',width:'20%',render:function(data){
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseIdxStatus,data);
            }},
            {title:'指标失效日',data:'idxInvalidDate',width:'20%'},
            {title:'指标有效天数',data:'idxValidDay',width:'20%'},
            {title:'指标所属分公司',data:'groupName',width:'20%'},
            {title:'指标所属区域',data:'groupDistrict',width:'20%'},
            {title:'指标使用人',data:'useCustomer',width:'20%'},
            {title:'使用人证件号',data:'useCertifNo',width:'20%'},
            {title:'使用人电话',data:'usePhoneNo',width:'20%'},
            {title:'指标预约日期',data:'useAppointDate',width:'20%'},
            {title:'指标合同编号',data:'useContNo',width:'20%'},
            {title:'合同状态',data:'bizStatus',width:'20%',render:function(data){
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data);
            }},
            {title:'还款状态',data:'paymentSts',width:'20%',render:function(data){
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.paymentSts,data);
            }},
            {title:'车牌号',data:'useLicenseNo',width:'20%'},
            {title:'历史车牌号',data:'licenseNoUsed',width:'20%'},
            {title:'指标续约开始日',data:'leaseStartDate',width:'20%'},
            {title:'指标续约结束日',data:'leaseEndDate',width:'20%'},
            {title:'合同开始日',data:'leaseTermStartDate',width:'20%'},
            {title:'合同结束日',data:'leaseTermEndDate',width:'20%'},
            {title:'备注',data:'idxMemo',width:'20%'},
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


    $scope.searchLicenseIdx = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetLicenseIdx = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

    //新增用户
    $scope.saveLicenseIdx = function(){
        $location.path('/app/postbiz_license_idx_save');
    }

    $scope.modifyLicenseIdx = function(licenseIdxId){
        var rowsIds =  $scope.dataTable.getRowsIds('licenseIdxId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要变更的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时变更一条数据！');
        else{
            $location.path('/app/postbiz_license_idx_modify').search({'licenseIdxId':rowsIds[0],'licenseIdxzt':'1'})
        }

    }


    $scope.detailLicenseIdx = function(licenseIdxId){
        var LicenseIdx = $scope.dataTable.getRow(licenseIdxId,'licenseIdxId');
        var licenseIdxId = LicenseIdx.licenseIdxId;
        $location.path('/app/postbiz_license_idx_detail').search({'licenseIdxId': licenseIdxId});
    }

    $scope.renewLicenseIdx = function(licenseIdxId){
        var rowsIds =  $scope.dataTable.getRowsIds('licenseIdxId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要续约的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时续约一条数据！');
        else{
            $location.path('/app/postbiz_license_idx_modify').search({'licenseIdxId':rowsIds[0],'licenseIdxzt':'2'})
        }

    }

    $scope.retireLicenseIdx = function(licenseIdxId){
        var rowsIds =  $scope.dataTable.getRowsIds('licenseIdxId');//主键
        var licenseIdxStatus =  $scope.dataTable.getRowsIds('licenseIdxStatus');//指标状态
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要退牌的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时退牌一条数据！');
        else{
            if(licenseIdxStatus=='2'){
                modalConfirm($modal,function(){
                    $http.put('license_idx/modifyLicenseIdxVoBylicenseIdx?licenseIdxId='+ rowsIds[0]+'&licenseIdxzt='+licenseIdxStatus).success(function(data){
                        if(data.code == Response.successCode) {
                            toaster_success('指标退牌成功', toaster);
                            $scope.dataTable.fnDraw(true);
                        }
                        else
                            modalAlert($modal,data.message);
                    });
                },null,'您确定需要指标退牌吗？');
            }else{
                modalAlert($modal,'指标退牌只能选择已使用状态！');
            }
        }
    }

    $scope.cancelLicenseIdx = function(licenseIdxId){
        var rowsIds =  $scope.dataTable.getRowsIds('licenseIdxId');//主键
        var licenseIdxStatus =  $scope.dataTable.getRowsIds('licenseIdxStatus');//指标状态
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要预约取消的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时预约取消一条数据！');
        else{
            if(licenseIdxStatus=='1'){
                modalConfirm($modal,function(){
                    $http.put('license_idx/modifyLicenseIdxVoBylicenseIdx?licenseIdxId='+ rowsIds[0]+'&licenseIdxzt='+licenseIdxStatus).success(function(data){
                        if(data.code == Response.successCode) {
                            toaster_success('预约取消成功', toaster);
                            $scope.dataTable.fnDraw(true);
                        }
                        else
                            modalAlert($modal,data.message);
                    });
                },null,'您确定需要预约取消吗？');
            }else{
                modalAlert($modal,'预约取消只能选择预约中状态！');
            }
        }
    }
}])
;