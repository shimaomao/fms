/**
 * Created by ningyangyang on 2018-05-23.
 */
app.controller('overdue_cont_list_select_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$modalInstance', function ($scope, $http, $modal, toaster,$compile,$location,$modalInstance) {

    $scope.overdueFlag = '1';// 当前是否逾期默认为是
    //参数配置
    $scope.dataTableProperties = {
        //ajax url 和类型
        dataTableAjax : {
            url : 'overdue_cont/findOverdueContVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'overdue_cont_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('overdueContId'),
            defaultDetail('contNo','confirmSave','合同编号','20%',$compile,$scope,'overdueContId'),
            {title:'申请编号',data:'applyNo',width:'20%'},
            {title:'承租人',data:'cstmName',width:'20%'},
            {title:'联系方式',data:'mobileNo',width:'20%'},
            {title:'车辆型号',data:'vehicleCodeName',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'车牌号',data:'vehicleLicenseNo',width:'20%'},
            {title:'发动机号',data:'engineNo',width:'20%'},
            {title:'出租人',data:'lessor',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    };
    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.applyNo = $scope.applyNo;
        params.contNo = $scope.contNo;
        params.cstmName = $scope.cstmName;
        params.mobileNo = $scope.mobileNo;
        params.vinNo = $scope.vinNo;
        params.vehicleLicenseNo = $scope.vehicleLicenseNo;
        params.engineNo = $scope.engineNo;
        params.overdueFlag = $scope.overdueFlag;
        return params;
    }

    //重置
    $scope.resetCstmList = function () {
        $scope.applyNo = "";
        $scope.contNo = "";
        $scope.cstmName = "";
        $scope.mobileNo = "";
        $scope.vinNo = "";
        $scope.vehicleLicenseNo = "";
        $scope.engineNo = "";
        $scope.overdueFlag = "";
        $scope.dataTable.fnDraw(true);
    };

    $scope.init = function () {
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };

    //关闭
    $scope.close = function (status) {
        $modalInstance.close(status);
    };

    //确定
    $scope.save = function () {
        var rows = $scope.dataTable.getRows();
        if(rows.length < 1){
            modalAlert($modal, "请选择一条数据");
        } else {
            $scope.close(rows[0]);
        }
    };

    $scope.confirmSave = function (rowId) {
        var row = $scope.dataTable.getRow(rowId,"overdueContId");
        $scope.close(row);
    }

    //查询
    $scope.searchCstmList = function () {
        $scope.dataTable.fnDraw(true);
    };
}]);