/**
 * Created by yangyiquan on 2018-05-18.
 */
app.controller('mortgage_register_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {

    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'mortgage') {
            toaster_success('解抵押成功', toaster);
        } else if ($scope.type == 'mail') {
            toaster_success('邮寄成功',toaster);
        }
    }, 100);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'mortgage_register/findMortgageRegistersByPage',
            type:"GET"
        },
        //table的html id
        dataTableId:'mortgage_register_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('mortgageRegisterId'),
            defaultDetail('contNo','detailMortgageRegister','合同编号','20%',$compile,$scope,'mortgageRegisterId'),
            {title:'申请姓名',data:'name',width:'20%'},
            {title:'订单提出机构',data:'groupName',width:'20%'},
            {title:'车牌号',data:'vehicleLicenseNo',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'发动机号',data:'engineNo',width:'20%'},
            {title:'商业险保单号',data:'insPolicyNo',width:'20%'},
            {title:'保险公司',data:'insCompName',width:'20%'},
            {title:'解抵押状态',data:'mortgateSts',width:'20%',
                render: function (data, type, row, meta) {
                    if(isNullEmpty(data)){
                        data = 0;
                    }
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.mortgateSts,data);
                }
            }
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    };

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.contNo = $scope.contNo;
        params.name = $scope.name;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchMortgageRegister = function(){
        $scope.dataTable.fnDraw(true);
    };

    $scope.resetMortgageRegister = function(){
        $scope.contNo = "";
        $scope.name = "";
        $scope.dataTable.fnDraw(true);//刷新
    };

    //解除抵押
    $scope.mortgages = function(){
        var row = $scope.dataTable.getRow();
        if(row.mortgateSts>=1){
            modalAlert($modal,'您选择的数据已解除抵押！');
            return;
        }
        if(row){
            $location.path('/app/asset_mortgage_register_modify').search({
                'contNo': row.contNo
            });
        }else{
            modalAlert($modal,'请选择一条数据！');
        }
    };

    //邮寄
    $scope.mail = function(){
        var row = $scope.dataTable.getRow();
        if(row.mortgateSts>=1){
            modalAlert($modal,'您选择的数据已邮寄！');
            return;
        }
        if(row){
            $location.path('/app/asset_mortgage_register_mail').search({
                'contNo': row.contNo,
                'mortgageRegisterId': row.mortgageRegisterId
            });
        }else{
            modalAlert($modal,'请选择一条数据！');
        }
    };

    //导出excel
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.asset,CommonServiceType.excelTypes.one,
            'mortgage_register/findMortgageRegistersByPage',dataTableParams($scope));
    }

}])
;