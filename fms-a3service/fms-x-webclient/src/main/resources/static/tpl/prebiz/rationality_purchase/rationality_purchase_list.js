/**
 * Created by ningyangyang on 2018-05-29.
 */
app.controller('rationality_purchase_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'rationality_purchase/findRationalityPurchasesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'rationality_purchase_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('buyCarId'),
            defaultDetail('applyNo','detailRationalityPurchase','申请编号','20%',$compile,$scope),
            {title:'客户来源',data:'customerSource',width:'20%'},
            {title:'购车目的',data:'purposePurchase',width:'20%'},
            {title:'选择原因',data:'chooseReason',width:'20%'},
            {title:'原有车辆',data:'originalVehicle',width:'20%'},
            {title:'购买时间',data:'purchaseTime',width:'20%'},
            {title:'购买价格',data:'price',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.applyNo = $scope.applyNo;
        params.customerSource = $scope.customerSource;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchRationalityPurchase = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetRationalityPurchase = function(){
        $scope.applyNo = "";
        $scope.customerSource = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveRationalityPurchase = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/rationality_purchase/rationality_purchase_save.html'+getCacheTime(),
            controller: 'rationality_purchase_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加prebiz信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifyRationalityPurchase = function(buyCarId){
        var rowsIds =  $scope.dataTable.getRowsIds('buyCarId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/prebiz/rationality_purchase/rationality_purchase_modify.html'+getCacheTime(),
                controller: 'rationality_purchase_modify_controller',
                resolve:{
                    buyCarId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑prebiz信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    $scope.detailRationalityPurchase = function(buyCarId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/rationality_purchase/rationality_purchase_detail.html'+getCacheTime(),
            controller: 'rationality_purchase_detail_controller',
            resolve:{
                rationalityPurchase : function (){ return $scope.dataTable.getRow(buyCarId,'buyCarId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteRationalityPurchase = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('buyCarId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('rationality_purchase/deleteRationalityPurchasesByBuyCarIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除prebiz信息成功', toaster);
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