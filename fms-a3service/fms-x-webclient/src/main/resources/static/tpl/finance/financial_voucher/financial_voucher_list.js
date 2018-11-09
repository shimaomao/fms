/**
 * Created by ningyangyang on 2018-06-20.
 */
app.controller('financial_voucher_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'financial_voucher/findFinancialVouchersByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'financial_voucher_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('voucherId'),
            defaultDetail('voucherType','detailFinancialVoucher','凭证类型','20%',$compile,$scope,'voucherId'),
            {title:'凭证类型名称',data:'voucherName',width:'20%'},
            {title:'凭证类型备注',data:'voucherMemo',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.voucherType = $scope.voucherType;
        params.voucherName = $scope.voucherName;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchFinancialVoucher = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetFinancialVoucher = function(){
        $scope.voucherType = "";
        $scope.voucherName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveFinancialVoucher = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/finance/financial_voucher/financial_voucher_save.html'+getCacheTime(),
            controller: 'financial_voucher_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加finance信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifyFinancialVoucher = function(voucherId){
        var rowsIds =  $scope.dataTable.getRowsIds('voucherId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/finance/financial_voucher/financial_voucher_modify.html'+getCacheTime(),
                controller: 'financial_voucher_modify_controller',
                resolve:{
                    voucherId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑finance信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    $scope.detailFinancialVoucher = function(voucherId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/finance/financial_voucher/financial_voucher_detail.html'+getCacheTime(),
            controller: 'financial_voucher_detail_controller',
            resolve:{
                financialVoucher : function (){ return $scope.dataTable.getRow(voucherId,'voucherId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteFinancialVoucher = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('voucherId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('financial_voucher/deleteFinancialVouchersByVoucherIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除finance信息成功', toaster);
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