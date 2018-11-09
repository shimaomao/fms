/**
 * Created by yangyiquan on 2018-05-28.
 */
app.controller('monthly_settlement_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'monthly_settlement/findMonthlySettlementsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'monthly_settlement_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('monthlySettlementId'),
            defaultDetail('monthlySettlementNo','detailMonthlySettlement','gps月结任务号','20%',$compile,$scope),
            {title:'月结状态',data:'monthlySts',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.monthlySettlementNo = $scope.monthlySettlementNo;
        params.monthlySts = $scope.monthlySts;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchMonthlySettlement = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetMonthlySettlement = function(){
        $scope.monthlySettlementNo = "";
        $scope.monthlySts = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveMonthlySettlement = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/cost/monthly_settlement/monthly_settlement_save.html'+getCacheTime(),
            controller: 'monthly_settlement_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加cost信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifyMonthlySettlement = function(monthlySettlementId){
        var rowsIds =  $scope.dataTable.getRowsIds('monthlySettlementId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/cost/monthly_settlement/monthly_settlement_modify.html'+getCacheTime(),
                controller: 'monthly_settlement_modify_controller',
                resolve:{
                    monthlySettlementId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑cost信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    $scope.detailMonthlySettlement = function(monthlySettlementId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/cost/monthly_settlement/monthly_settlement_detail.html'+getCacheTime(),
            controller: 'monthly_settlement_detail_controller',
            resolve:{
                monthlySettlement : function (){ return $scope.dataTable.getRow(monthlySettlementId,'monthlySettlementId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteMonthlySettlement = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('monthlySettlementId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('monthly_settlement/deleteMonthlySettlementsByMonthlySettlementIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除cost信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

}])
;