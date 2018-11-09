/**
 * Created by niehaibing on 2018-03-27.
 */
app.controller('prod_intrst_factor_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'prod_intrst_factor/findProdIntrstFactorByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'prod_intrst_factor_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('prodIntrstFactorId'),
            defaultDetail('product','detailProdIntrstFactor','产品方案代码','20%',$compile,$scope),
            {title:'利率方案序号',data:'intrstNo',width:'20%'},
            {title:'因子代码',data:'factorCode',width:'20%'},
            {title:'因子值开始',data:'factorValueFrom',width:'20%'},
            {title:'因子值结束',data:'factorValueTo',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.product = $scope.product;
        params.intrstNo = $scope.intrstNo;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchProdIntrstFactor = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetProdIntrstFactor = function(){
        $scope.product = "";
        $scope.intrstNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveProdIntrstFactor = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/product/prod_intrst_factor/prod_intrst_factor_save.html'+getCacheTime(),
            controller: 'prod_intrst_factor_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加product信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifyProdIntrstFactor = function(prodIntrstFactorId){
        var rowsIds =  $scope.dataTable.getRowsIds('prodIntrstFactorId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/product/prod_intrst_factor/prod_intrst_factor_modify.html'+getCacheTime(),
                controller: 'prod_intrst_factor_modify_controller',
                resolve:{
                    prodIntrstFactorId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑product信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    $scope.detailProdIntrstFactor = function(prodIntrstFactorId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/product/prod_intrst_factor/prod_intrst_factor_detail.html'+getCacheTime(),
            controller: 'prod_intrst_factor_detail_controller',
            resolve:{
                prodIntrstFactor : function (){ return $scope.dataTable.getRow(prodIntrstFactorId,'prodIntrstFactorId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteProdIntrstFactor = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('prodIntrstFactorId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('prod_intrst_factor/deleteProdIntrstFactorByProdIntrstFactorIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除product信息成功', toaster);
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