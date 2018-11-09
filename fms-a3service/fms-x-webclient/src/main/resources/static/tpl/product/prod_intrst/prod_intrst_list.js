/**
 * Created by niehaibing on 2018-03-27.
 */
app.controller('prod_intrst_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'prod_intrst/findProdIntrstByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'prod_intrst_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('prodIntrstId'),
            defaultDetail('product','detailProdIntrst','产品方案代码','20%',$compile,$scope),
            {title:'利率方案序号',data:'intrstNo',width:'20%'},
            {title:'客户利率',data:'intrstRate',width:'20%'},
            {title:'结算利率',data:'settleIntrstRate',width:'20%'},
            {title:'手续费率',data:'chargeRate',width:'20%'},
            {title:'结算手续费率',data:'settleChargeRate',width:'20%'},
            {title:'一次性手续费',data:'onetimeCharge',width:'20%'},
            {title:'贴息方式',data:'subsidyMode',width:'20%'},
            {title:'贴息利率',data:'subsidyRate',width:'20%'},
            {title:'贴息年限',data:'subsidyYear',width:'20%'},
            {title:'贴息金额',data:'subsidyAmount',width:'20%'},
            {title:'利率方式',data:'intrstRateMode',width:'20%'},
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


    $scope.searchProdIntrst = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetProdIntrst = function(){
        $scope.product = "";
        $scope.intrstNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveProdIntrst = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/product/prod_intrst/prod_intrst_save.html'+getCacheTime(),
            controller: 'prod_intrst_save_controller',
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

    $scope.modifyProdIntrst = function(prodIntrstId){
        var rowsIds =  $scope.dataTable.getRowsIds('prodIntrstId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/product/prod_intrst/prod_intrst_modify.html'+getCacheTime(),
                controller: 'prod_intrst_modify_controller',
                resolve:{
                    prodIntrstId : function (){ return rowsIds[0] }
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


    $scope.detailProdIntrst = function(prodIntrstId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/product/prod_intrst/prod_intrst_detail.html'+getCacheTime(),
            controller: 'prod_intrst_detail_controller',
            resolve:{
                prodIntrst : function (){ return $scope.dataTable.getRow(prodIntrstId,'prodIntrstId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteProdIntrst = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('prodIntrstId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('prod_intrst/deleteProdIntrstByProdIntrstIds',getDeleteData(rowsIds)).success(function (data) {
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