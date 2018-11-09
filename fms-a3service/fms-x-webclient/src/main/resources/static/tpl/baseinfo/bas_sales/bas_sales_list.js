/**
 * Created by yanfengbo on 2018-05-03.
 */
app.controller('bas_sales_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {
    //查询参数
    $scope.params = setData.getter();
    //添加，修改成功提示信息
    $scope.timer = $timeout(function () {
        $scope.messageType=$location.search()['messageType'];
        if($scope.messageType == 'saveBasSales'){
            toaster_success('添加实际销售方成功',toaster);
        }else if($scope.messageType=='modifyBasSales'){
            toaster_success('编辑实际销售方成功',toaster);
        }

    }, 5);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'bas_sales/findBasSalessByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_sales_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('salesId'),
            defaultDetail('salesCode','detailBasSales','实际销售方代码','20%',$compile,$scope,'salesId'),
            {title:'实际销售方全称',data:'salesName',width:'20%'},
            {title:'实际销售方状态',data:'salesTaskStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.salesTaskStatus,data);
                }
            },
            {title:'当前节点用户',data:'presentUser',width:'20%'},
            {title:'店面属性',data:'salesType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.salesType,data);
                }
            },
            {title:'所属集团',data:'withinGroup',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.withinGroup,data);
                }
            },
            {title:'经营省份',data:'addrProv',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'经营城市',data:'addrCity',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'经营区县',data:'addrCounty',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'经营地址',data:'address',width:'20%'},
            {title:'注册省份',data:'registerProv',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'注册城市',data:'registerCity',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'注册区县',data:'registerCounty',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'注册地址',data:'registerAddress',width:'20%'},
            {title:'担保期限',data:'guaranteePeriod',width:'20%'},
            {title:'车辆类型',data:'vehicleForm',width:'20%',
                render: function (data, type, row, meta) {
                    if (isNotUndefinedNull(data)) {
                        var vehicleForm = "";
                        var dataArray = data.split(",");
                        for (x in dataArray) {
                            vehicleForm += CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleForm, dataArray[x]) + ",";
                        }
                        if (vehicleForm != "") {
                            return vehicleForm.substring(0, vehicleForm.length - 1);
                        } else {
                            return "";
                        }
                    }else {
                        return null;
                    }
                }
            },
            {title:'联系人员',data:'contact',width:'20%'},
            {title:'联系电话',data:'contactTel1',width:'20%'},
            {title:'财务辅助核算代码',data:'finassSalesCode',width:'20%'},
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchBasSales = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetBasSales = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

    //添加
    $scope.saveBasSales = function(){
        $location.path('app/baseinfo_bas_sales_save').search({'frameTitle':'添加实际销售方','operate':'save'});
    }

    //修改
    $scope.modifyBasSales = function(salesId){
        var rowsIds =  $scope.dataTable.getRowsIds('salesId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var data = $scope.dataTable.getRow(salesId,'salesId')
            //销售方状态为审批通过时才能修改
            if(data.salesTaskStatus =='1202'){
                $location.path('/app/baseinfo_bas_sales_modify').search({'frameTitle':'修改实际销售方','operate':'update','salesId': rowsIds[0]});
            }else{
                modalAlert($modal,'本条数据不能更新！');
            }
        }
    }

    //详情
    $scope.detailBasSales = function(salesId){
        $location.path('/app/baseinfo_bas_sales_detail').search({'frameTitle':'实际销售方详情','operate':'check','salesId': salesId});
    }

    //删除
    $scope.deleteBasSales = function(){
        var rows = $scope.dataTable.getRows();
        if(rows.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{
            modalConfirm($modal,function(){
                var rowsIds = new Array();
                for(var i=0;i<rows.length;i++){
                    if(rows[i].salesTaskStatus!="1202"){
                        modalAlert($modal,'所选数据存在未审核通过的明细,无法删除!');
                        return;
                    }else {
                        rowsIds.push(rows[i].salesId);
                    }
                }
                $http.delete('bas_sales/deleteBasSalessBySalesIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除实际销售方信息成功', toaster);
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
            'bas_sales/findBasSalessByPage',dataTableParams($scope));
    }

}])
;