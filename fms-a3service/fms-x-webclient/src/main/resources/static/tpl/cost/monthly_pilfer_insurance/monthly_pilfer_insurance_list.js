/**
 * Created by yangyiquan on 2018-05-31.
 */
app.controller('monthly_pilfer_insurance_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'monthly_pilfer_insurance/findMonthlyPilferInsurancesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'monthly_pilfer_insurance_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('monthlyPilferInsuranceId'),
            defaultDetail('monthlyPilferInsuranceNo','detailMonthlyPilferInsurance','盗抢险月结任务号','20%',$compile,$scope),
            {title:'月结状态',data:'monthlyPilferInsuranceSts',width:'20%'},
            {title:'合计金额',data:'totalCost',width:'20%'},
            {title:'当前节点用户',data:'presentUser',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.monthlyPilferInsuranceNo = $scope.monthlyPilferInsuranceNo;
        params.monthlyPilferInsuranceSts = $scope.monthlyPilferInsuranceSts;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchMonthlyPilferInsurance = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetMonthlyPilferInsurance = function(){
        $scope.monthlyPilferInsuranceNo = "";
        $scope.monthlyPilferInsuranceSts = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveMonthlyPilferInsurance = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/cost/monthly_pilfer_insurance/monthly_pilfer_insurance_save.html'+getCacheTime(),
            controller: 'monthly_pilfer_insurance_save_controller',
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

    $scope.modifyMonthlyPilferInsurance = function(monthlyPilferInsuranceId){
        var rowsIds =  $scope.dataTable.getRowsIds('monthlyPilferInsuranceId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/cost/monthly_pilfer_insurance/monthly_pilfer_insurance_modify.html'+getCacheTime(),
                controller: 'monthly_pilfer_insurance_modify_controller',
                resolve:{
                    monthlyPilferInsuranceId : function (){ return rowsIds[0] }
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


    $scope.detailMonthlyPilferInsurance = function(monthlyPilferInsuranceId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/cost/monthly_pilfer_insurance/monthly_pilfer_insurance_detail.html'+getCacheTime(),
            controller: 'monthly_pilfer_insurance_detail_controller',
            resolve:{
                monthlyPilferInsurance : function (){ return $scope.dataTable.getRow(monthlyPilferInsuranceId,'monthlyPilferInsuranceId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteMonthlyPilferInsurance = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('monthlyPilferInsuranceId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('monthly_pilfer_insurance/deleteMonthlyPilferInsurancesByMonthlyPilferInsuranceIds',getDeleteData(rowsIds)).success(function (data) {
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