
/**
 * Created by niehaibing on 2018-03-23.
 */

app.controller('product_user_controller', ['$scope', '$http','$modal','$modalInstance', 'toaster','$compile','setData', function ($scope, $http,$modal,$modalInstance,toaster,$compile,setData) {
    //参数配置
    if(!setData.checkboxOrRadio){
        setData.checkboxOrRadio = CheckBox;
    }
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_group/findSysGroupVoListByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_group_list_select_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('groupId'),
            {
                title: '机构代码',
                data: 'groupCode',
                width: '30%',
                render: function (data, type, row, meta) {
                    return "<a class=\"a1\" ng-click=\"directSelect('"+row.groupId+"')\">"+data+"</a>";
                },
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    $compile(nTd)($scope);
                }
            },
            /*{title:'机构代码',data:'groupCode',width:'20%'},*/
            {title:'机构名称',data:'groupName',width:'20%'},
            {title:'机构层级代码',data:'groupLev',width:'20%'},
            {title:'机构层级名称',data:'groupLevName',width:'20%'}
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: setData.checkboxOrRadio
    };

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.groupCode = $scope.groupCode;
        params.groupName = $scope.groupName;
        return params;
    }

    // 初始化
    $scope.init = function(){
        //创建dataTable 封装了datatable
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };

    $scope.searchSysGroup = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetSysGroup = function(){
        $scope.groupCode = "";
        $scope.groupName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    // 确认
    $scope.confirm = function(){
        if(status != 'none') {
            var data;
            if(!setData.checkboxOrRadio){
                data = $scope.dataTable.getRows();
            }else{
                data = $scope.dataTable.getRow();
            }
            if(data == null)
                modalAlert($modal,'请选择一个用户');
            else
                $modalInstance.close(data);
        }else{
            var data = {id:0,realName:'无上级'};
            $modalInstance.close(data);
        }
    };
    $scope.close = function(status){
        $modalInstance.close(status);
    };

    $scope.directSelect = function (groupId) {
        var data = $scope.dataTable.getRow(groupId,'groupId');
        $modalInstance.close(data);
    };

    // 导出excel
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.system,CommonServiceType.excelTypes.two,
            'sys_group/findSysGroupVoListByPage',dataTableParams($scope));
    };
}]);



