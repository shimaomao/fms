/**
 * Created by qinmuqiao on 2018-09-19.
 */
app.controller('sec_hand_inventory_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','setData','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,setData,$timeout) {

    //查询参数
    $scope.params = setData.getter();

    $scope.maxDate = {maxDate:'#F{$dp.$D(\'validEndDate\')}'};
    $scope.minDate = {minDate:'#F{$dp.$D(\'validStartDate\')}'};

    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加车辆信息成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑车辆信息成功',toaster);
        }
    }, 100);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sec_hand_inventory/findSecHandInventoryVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sec_hand_inventory_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('secHandId'),
            defaultDetail('vinNo','detailSecHandInventory','车架号','20%',$compile,$scope,'secHandId'),
            {title:'发动机号',data:'engineNo',width:'20%'},
            {title:'行驶公里数',data:'miles',width:'20%'},
            {title:'登记日期',data:'registDate',width:'20%'},
            {title:'车龄',data:'vehAgeMonths',width:'20%'},
            {title:'出厂日期',data:'produceDate',width:'20%'},
            {title:'车辆评估价',data:'evaluationPrice',width:'20%'},
            {title:'颜色',data:'color',width:'20%'},
            {title:'车型',data:'vehicleName',width:'20%'},
            {title:'收车任务号',data:'recoveryTaskNo',width:'20%'},
            {title:'状态',data:'status',width:'20%',
                render:function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.secHandStatus, data);
            }},
            {title:'来源',data:'carSource',width:'20%',
                render:function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.secHandCarSource, data);
                }},
            {title:'收车入库时间',data:'storageDate',width:'20%'},
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


    $scope.searchSecHandInventory = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetSecHandInventory = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveSecHandInventory = function(){
        $location.path('/app/postbiz_sec_hand_inventory_save');
    }

    $scope.modifySecHandInventory = function(secHandId){
        var rowsIds =  $scope.dataTable.getRowsIds('secHandId');//主键
        var rows = $scope.dataTable.getRows();
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            if (rows[0].carSourceVal == "1"){
                modalAlert($modal,'车辆处置从数据不可更改！');
                return;
            }

            $location.path('/app/postbiz_sec_hand_inventory_modify').search({'secHandId':rowsIds[0]});

        }

    }

    $scope.detailSecHandInventory = function(secHandId){
        $location.path('/app/postbiz_sec_hand_inventory_detail').search({'secHandId':secHandId});

    }


    $scope.secExportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.postbiz,CommonServiceType.excelTypes.one,
            'sec_hand_inventory/findSecHandInventoryVosByPage',dataTableParams($scope));
    }

}])
;