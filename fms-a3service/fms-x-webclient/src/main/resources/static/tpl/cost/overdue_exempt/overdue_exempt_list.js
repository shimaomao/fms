/**
 * Created by yanfengbo on 2018-05-29.
 */
app.controller('overdue_exempt_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {
    //查询参数
    $scope.params = setData.getter();

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'overdue_exempt/findContOverdueVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'overdue_exempt_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contNo'),
            {title:'合同编号',data:'contNo',width:'20%'},
            {title:'申请编号',data:'applyNo',width:'20%'},
            {title:'出租人',data:'groupName',width:'10%'},
            {title:'承租人',data:'cstmName',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'最大逾期天数',data:'overdueDaysMax',width:'20%'},
            {title:'罚息总额',data:'overdueAmountSum',width:'20%'},
            {title:'剩余未还期数',data:'surplusPeriod',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope){
       /* params = {};
        params.cstmName = $scope.cstmName;
        params.contNo = $scope.contNo;
        params.groupDistrict = $scope.groupDistrict;
        params.vinNo = $scope.vinNo;*/
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchOverdueCont = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetOverdueCont = function(){
        /*$scope.cstmName ="";
        $scope.contNo ="";
        $scope.groupDistrict = "";
        $scope.vinNo = "";*/
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.modifyOverdueCont = function(){

        var rowsIds=$scope.dataTable.getRows()
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要免除的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时免除一条数据！');
        else{
            $location.path('/app/cost_overdue_exempt_modify').search({'frameTitle':'罚息免除','operate':'update','contNo': rowsIds[0].contNo});
        }
    }
}])
;