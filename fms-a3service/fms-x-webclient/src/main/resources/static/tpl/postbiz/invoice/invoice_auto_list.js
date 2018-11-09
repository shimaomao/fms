/**
 * Created by ningyangyang on 2018/10/23.
 */
app.controller('invoice_auto_list_controller', ['$scope', '$http', '$modal','$location', '$timeout','toaster','$state',function ($scope, $http, $modal,$location,$timeout,toaster,$state) {


    $timeout(function () {
        var msg = $location.search()['msg'];
        if(CommonObjectUtils.isExist(msg)) {
            toaster_success(msg, toaster);
            $location.search({msg:null});
        }
    })

    $scope.invoiceNumbers = $location.search()['invoiceNos'];

    $scope.flag = false;

    initTable();
    function initTable(){
        if(!Array.isArray($scope.invoiceNumbers)){
            $scope.invoiceNumbers = $scope.invoiceNumbers.split(',');
        }
        $http.post('invoice/findInvoiceAutos', $scope.invoiceNumbers).success(function (data) {
            if (data.code == Response.successCode){
                $scope.invoceAuto = data.data;
                //参数配置
                $scope.dataTableProperties= {
                    //table的html id
                    dataTableId:'invoice_auto',
                    dataTableColumn:[
                        defaultCheckBox('invoiceAutoId'),
                        //defaultDetail('infokind','detailInvoiceAuto','发票种类','20%',$compile,$scope),
                        {title:'发票种类',data:'infokind',width:'20%',
                            render:function (data) {
                                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.infoKind,data);
                            }
                        },
                        {title:'打印状态',data:'printStatus',width:'20%',
                            render:function (data) {
                                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.printStatus,data);
                            }
                        },
                        {title:'购方名称',data:'infoclientname',width:'20%'},
                        {title:'发票十位代码',data:'infotypecode',width:'20%'},
                        {title:'发票号码',data:'infonumber',width:'20%'},
                        {title:'销货清单标志',data:'goodslistflag',width:'20%',
                            render:function (data) {
                                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.goodsListFlag,data)
                            }
                        },
                        {title:'备注',data:'infonotes',width:'20%'},
                        {title:'开票日期',data:'infoinvdate',width:'20%'},
                        {title:'所属月份',data:'infmonth',width:'20%'},
                        {title:'合计不含税金额',data:'infoamount',width:'20%'},
                        {title:'合计税额',data:'infotaxamount',width:'20%'},
                    ],
                    dataTableSelectType: CheckBox,
                    dataTableData: $scope.invoceAuto
                }
                $scope.dataTable =  CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
            }else
                modalAlert($modal,data.message);
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })




    }

    /**
     * 发票打印
     */
    $scope.manualPrintinv = function () {
        var invoiceAutos  = $scope.dataTable.getRows('invoiceAutoId');//主键
        for(var i in invoiceAutos){
            var invoiceAuto = invoiceAutos[i];
            if(invoiceAuto['printStatus'] == CommonCodeUtils.printStatus.print){
                modalAlert($modal,'发票已经打印，请选择未打印的发票');
                return;
            }
        }
        var rtn = $modal.open({
            backdrop : 'static',
            size: 'sm',
            templateUrl: 'tpl/alert/confirm.html'+getCacheTime(),
            controller: 'modal_confirm_controller',
            resolve:{
                // header:'提示信息',
                // info:'确认打印吗?',
                header : function(){return '提示信息'},
                info : function(){return '确认打印吗?'}
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                $scope.flag = true;
                confirmPrint(invoiceAutos);
            }
        },function(reason){
        });
    }

     function confirmPrint(invoiceAutos) {
        if($scope.flag){
            $http.put('invoice/printinv',invoiceAutos).success(function (data) {
                $scope.submit = false;
                if (data.code == Response.successCode){
                    var rtn1 = $modal.open({
                        keyboard: false,
                        backdrop : 'static',
                        size:'lg',
                        templateUrl: 'tpl/postbiz/invoice/invoice_printinv_result.html?datetime='+getTimestamp(),
                        controller: 'invoice_printinv_result_controller',
                        resolve:{
                            invoiceResult:function () {
                                return data.data;
                            }
                        }
                    });
                    rtn1.result.then(function () {
                        refresh();
                    },function(){

                    });
                } else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
        }
    }
    /**
     *  刷新页面
     */
    function refresh() {
        // alert('11111');
        //  $location.path('app/postbiz_invoice_auto_list').search({invoiceNos:$scope.invoiceNos})//刷新
         window.location.reload();
        // initTable();
        //$state.reload('app.postbiz_invoice_auto_list')
    }

    /**
     *  返回开票一览页面
     */
    $scope.goBack = function () {
        $location.path('app/postbiz_invoice_list');
    }

}])