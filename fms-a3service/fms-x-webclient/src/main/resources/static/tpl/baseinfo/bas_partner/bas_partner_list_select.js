/**
 * Created by wangxue on 2018/3/22.
 */

app.controller('bas_partner_list_select_controller', ['$scope', '$http', '$modal','$modalInstance', function ($scope, $http, $modal, $modalInstance) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'bas_partner/findBasPartnersByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_partner_list_select_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('partnerId'),
            {title:'合作商代码',data:'partnerCode',width:'20%'},
            {title:'合作商全称',data:'partnerName',width:'20%'},
            {title:'合作商简称',data:'partnerNameShort',width:'20%'},
            {title:'经营省份',data:'partnerProv',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'经营城市',data:'partnerCity',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'经营区县',data:'partnerCounty',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'系统跟新时间',data:'updateTime',width:'20%',
                render: function (data, type, row, meta) {
                    return new Date(data).Format('yyyy-MM-dd HH:mm:ss');
                }
            }
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.partnerCode = $scope.partnerCode;
        params.partnerName = $scope.partnerName;
        return params;
    }

    // 初始化
    $scope.init = function(){
        //创建dataTable 封装了datatable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };

    // 查询
    $scope.searchBasPartner = function(){
        $scope.dataTable.fnDraw(true);
    };

    // 重置
    $scope.resetBasPartner = function(){
        $scope.partnerCode = "";
        $scope.partnerName = "";
        $scope.dataTable.fnDraw(true);//刷新
    };

    // 确认
    $scope.confirm = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('partnerId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择合作商信息！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时选中一条数据！');
        else{
            var data = $scope.dataTable.getRow(rowsIds[0],'partnerId');
            $modalInstance.close(data);
        }
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close(null);
    };

}]);