app.controller('cont_backfill_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location, $timeout,setData) {

    //查询参数
    $scope.params = setData.getter();
    //回填状态
    $scope.filBackfillStsList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.filBackfillSts);
    $timeout(function () {
        var msg = $location.search()['msg'];
        if(CommonObjectUtils.isExist(msg)) {
            toaster_success(msg, toaster);
        }
    })

    //业务类型
    $scope.licenseAttrList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr)

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'fin_backfill/findFinBackfillsByPage',
            type:"GET",

        },
        //table的html id
        dataTableId:'backfill_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('filBackfillId'),
            defaultDetail('contNo','detailBackFill','合同编号','20%',$compile,$scope,'filBackfillId'),
            //{title:'合同编号',data:'contNo',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'申请姓名',data:'name',width:'20%'},
            {title:'回填状态',data:'filBackfillSts',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.filBackfillSts,data);
                }
            },
            {title:'产品方案',data:'productName',width:'20%'},
            {title:'融资额',data:'finTotal',width:'20%'},
            {title:'首付比例',data:'initPerc',width:'20%'},
            {title:'首付金额',data:'initAmount',width:'20%'},
            {title:'业务类型',data:'licenseAttr',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data);
                }
            },
            {title:'放款日期',data:'contractValidDate',width:'20%'},
            {title:'融资期限',data:'finPeriodType',width:'20%'},
            {title:'租赁期限开始日',data:'leaseTermStartDate',width:'20%'},
            {title:'租赁期限结束日',data:'leaseTermEndDate',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    };

    $scope.callback = function (data) {
        //var data = $scope.dataTable;
        var tableData = data.data;
        var /*chargeSum=0,*/initAmountSum=0,finTotalSum=0;
        for(var i=0;i<tableData.length;i++){
            // chargeSum = tableData[i].charge*1 + chargeSum;
            initAmountSum = tableData[i].initAmount*1 + initAmountSum;
            finTotalSum = tableData[i].finTotal*1 + finTotalSum;
        }
        var html = '<tr>' +
            '<th>合计</th>' +
            '<td colspan="5"></td>' +
            '<td>'+finTotalSum.toFixed(2)+'</td>' +
            '<td colspan="1"></td>' +
            '<td>'+initAmountSum.toFixed(2)+'</td>' +
            '<td colspan="2"></td>' +
            '</tr>';
        $('#backfill_table tbody').append(html);
    };



    //请求的参数
    function dataTableParams($scope){
       /* params = {};
        params.name = $scope.name;
        params.contNo = $scope.contNo;
        params.filBackfillSts = $scope.filBackfillSts;*/
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchProduct = function(){
        $scope.dataTable.fnDraw(true);
    };

    $scope.resetProduct = function(){
        /*$scope.name = "";
        $scope.contNo = "";
        $scope.filBackfillSts = "";*/
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    };
    //回填
    $scope.exportExcel = function () {
        var filBackfill =  $scope.dataTable.getRows();
        if(filBackfill.length < 1){
            modalAlert($modal,'请选择需要操作的数据');
        }else if(filBackfill[0].filBackfillSts == '1'){
            modalAlert($modal,'已回填，不可操作');
        }else {
            $location.path('/app/prebiz_cont_backinput').search({"filBackfillId": filBackfill[0].filBackfillId});
        }
    };
    //续保回填
    $scope.renewalFinBackfill = function () {
        var filBackfill =  $scope.dataTable.getRows();
        if(filBackfill.length < 1){
            modalAlert($modal,'请选择需要操作的数据');
        }else if(filBackfill[0].filBackfillSts != '1'){
            modalAlert($modal,'已回填的数据才可以进行续保回填，请先进行回填操作');
        }else {
            $location.path('/app/prebiz_cont_backinput').search({"filBackfillId": filBackfill[0].filBackfillId, type:'renewal'});
        }
    };

    //详情
    $scope.detailBackFill = function (id) {
        $location.path('/app/prebiz_cont_backinput').search({"filBackfillId": id,"isDetail":"true"});
    };

    //导出excel
    $scope.exportExcelData = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.finance,CommonServiceType.excelTypes.one,
            'fin_backfill/findFinBackfillsForExportExcel',dataTableParams($scope));
    }
}])
;
