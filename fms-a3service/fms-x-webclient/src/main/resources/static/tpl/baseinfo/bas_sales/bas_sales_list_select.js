/**
 * Created by yanfengbo on 2018-05-03.
 */
app.controller('bas_sales_list_select_controller', ['$scope', '$http', '$modal','$compile','$modalInstance', function ($scope, $http, $modal,$compile,$modalInstance) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'bas_sales/findBasSalessByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_sales_list_select_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('salesId'),
            {
                title: '实际销售方代码',
                data: 'salesCode',
                width: '30%',
                render: function (data, type, row, meta) {
                    return "<a class=\"a1\" ng-click=\"directSelect('"+row.salesId+"')\">"+data+"</a>";
                },
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    $compile(nTd)($scope);
                }
            },
            {title:'实际销售方全称',data:'salesName',width:'20%'},
            {title:'实际销售方状态',data:'salesTaskStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.salesTaskStatus,data);
                }
            },
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
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.salesCode = $scope.salesCode;
        params.salesName = $scope.salesName;
        params.salesTaskStatus = '1202'//审批通过的销售方信息
        return params;
    }

    // 初始化
    $scope.init = function(){
        //创建dataTable 封装了datatable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };


    $scope.searchBasSales = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetBasSales = function(){
        $scope.salesCode = "";
        $scope.salesName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    // 确认
    $scope.confirm = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('salesId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择实际销售方信息！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时选中一条数据！');
        else{
            var data = $scope.dataTable.getRow(rowsIds[0],'salesId');
            $modalInstance.close(data);
        }
    };

    $scope.directSelect = function (salesId) {
        var data = $scope.dataTable.getRow(salesId,'salesId');
        $modalInstance.close(data);
    };
    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close(null);
    };
}])
;
