/**
 * Created by ningyangyang on 2018-05-28.
 */
app.controller('stock_assets_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'stock_assets/findStockAssetssByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'stock_assets_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('stockAssetsId'),
            defaultDetail('shareholderName','detailStockAssets','股东名称','20%',$compile,$scope),
            {title:'股份比例',data:'shareRatio',width:'20%'},
            {title:'出资额',data:'contribution',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.shareholderName = $scope.shareholderName;
        params.shareRatio = $scope.shareRatio;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchStockAssets = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetStockAssets = function(){
        $scope.shareholderName = "";
        $scope.shareRatio = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveStockAssets = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/stock_assets/stock_assets_save.html'+getCacheTime(),
            controller: 'stock_assets_save_controller',
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

    $scope.modifyStockAssets = function(stockAssetsId){
        var rowsIds =  $scope.dataTable.getRowsIds('stockAssetsId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/prebiz/stock_assets/stock_assets_modify.html'+getCacheTime(),
                controller: 'stock_assets_modify_controller',
                resolve:{
                    stockAssetsId : function (){ return rowsIds[0] }
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


    $scope.detailStockAssets = function(stockAssetsId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/stock_assets/stock_assets_detail.html'+getCacheTime(),
            controller: 'stock_assets_detail_controller',
            resolve:{
                stockAssets : function (){ return $scope.dataTable.getRow(stockAssetsId,'stockAssetsId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteStockAssets = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('stockAssetsId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('stock_assets/deleteStockAssetssByStockAssetsIds',getDeleteData(rowsIds)).success(function (data) {
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