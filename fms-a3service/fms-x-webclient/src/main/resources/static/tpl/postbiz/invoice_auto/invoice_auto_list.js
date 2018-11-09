/**
 * Created by yangyiquan on 2018-09-10.
 */
app.controller('invoice_auto_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'invoice_auto/findInvoiceAutosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'invoice_auto_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('invoiceAutoId'),
            defaultDetail('infokind','detailInvoiceAuto','发票种类','20%',$compile,$scope),
            {title:'购方名称',data:'infoclientname',width:'20%'},
            {title:'购方税号（公司必填）',data:'infoclienttaxcode',width:'20%'},
            {title:'购方开户行及账号（专用发票必填）',data:'infoclientbankaccount',width:'20%'},
            {title:'购方地址电话（专用发票必填）',data:'infoclientaddressphone',width:'20%'},
            {title:'税率',data:'infotaxrate',width:'20%'},
            {title:'发票十位代码',data:'infotypecode',width:'20%'},
            {title:'发票号码',data:'infonumber',width:'20%'},
            {title:'销货清单标志',data:'goodslistflag',width:'20%'},
            {title:'开票日期',data:'infoinvdate',width:'20%'},
            {title:'所属月份',data:'infmonth',width:'20%'},
            {title:'合计不含税金额',data:'infoamount',width:'20%'},
            {title:'合计税额',data:'infotaxamount',width:'20%'},
            {title:'接口请求xml',data:'invSendXml',width:'20%'},
            {title:'接口返回xml',data:'invBackXml',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.infokind = $scope.infokind;
        params.infoclientname = $scope.infoclientname;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchInvoiceAuto = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetInvoiceAuto = function(){
        $scope.infokind = "";
        $scope.infoclientname = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveInvoiceAuto = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/invoice_auto/invoice_auto_save.html'+getCacheTime(),
            controller: 'invoice_auto_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加postbiz信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifyInvoiceAuto = function(invoiceAutoId){
        var rowsIds =  $scope.dataTable.getRowsIds('invoiceAutoId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/postbiz/invoice_auto/invoice_auto_modify.html'+getCacheTime(),
                controller: 'invoice_auto_modify_controller',
                resolve:{
                    invoiceAutoId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑postbiz信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    $scope.detailInvoiceAuto = function(invoiceAutoId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/invoice_auto/invoice_auto_detail.html'+getCacheTime(),
            controller: 'invoice_auto_detail_controller',
            resolve:{
                invoiceAuto : function (){ return $scope.dataTable.getRow(invoiceAutoId,'invoiceAutoId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteInvoiceAuto = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('invoiceAutoId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('invoice_auto/deleteInvoiceAutosByInvoiceAutoIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除postbiz信息成功', toaster);
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