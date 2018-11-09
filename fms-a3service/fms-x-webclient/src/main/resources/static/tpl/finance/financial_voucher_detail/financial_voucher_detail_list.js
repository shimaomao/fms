/**
 * Created by ningyangyang on 2018-06-20.
 */
app.controller('financial_voucher_detail_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location',function ($scope, $http, $modal, toaster,$compile,$location) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'financial_voucher_detail/findFinancialVoucherDetailsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'financial_voucher_detail_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('voucherDetailId'),
            defaultDetail('voucherType','detailFinancialVoucherDetail','凭证类型','20%',$compile,$scope,'voucherDetailId'),
            {title:'凭证类型名称',data:'voucherName',width:'20%'},
            {title:'分录号',data:'voucherDetailNo',width:'20%'},
            {title:'科目代码',data:'subjectCd',width:'20%'},
            {title:'科目名称',data:'subjectName',width:'20%'},
            {title:'科目代码动态值',data:'subjectCdDyn',width:'20%'},
            {title:'辅助核算类型名称',data:'assisAccountTypeName',width:'20%'},
            {title:'核算账簿',data:'voucherAccountNo',width:'20%'},
            {title:'附单据数',data:'attachCount',width:'20%'},
            {title:'摘要格式',data:'summary',width:'20%'},
            {title:'借贷方向',data:'crdrFlag',width:'20%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.crdrFlag,data)
                }
            },
            {title:'借方金额',data:'debitAmountItem',width:'20%'},
            {title:'贷方金额',data:'creditAmountItem',width:'20%'},
            {title:'是否循环',data:'cycleFlag',width:'20%',
                render:function (data) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.yesNoFlag,data)
                }
            },
            {title:'循环对象',data:'cycleList',width:'20%'},
            {title:'备注',data:'voucherDetailMemo',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.voucherType = $scope.voucherType;
        params.voucherDetailNo = $scope.voucherDetailNo;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);

    // 创建树
    function initFinancialVouchersTree() {
        $http.get('financial_voucher/findFinancialVouchersByTree').success(function(data){
            var tree = data.data;
            $('#financial_voucher_tree').treeview({
                data: tree,
                icon:"glyphicon glyphicon-stop",
                emptyIcon: 'glyphicon glyphicon-minus',
                onNodeSelected: function (event, data) {
                    $scope.voucherType = data.id;
                    $scope.voucherTypeName = data.id;
                    $scope.dataTable.fnDraw(true);
                }
            });
        });
    }

    // 初始化
    initFinancialVouchersTree();

   //查询
    $scope.searchFinancialVoucherDetail = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetFinancialVoucherDetail = function(){
        $scope.voucherType = '';
        $scope.voucherDetailNo = '';
        $scope.dataTable.fnDraw(true);//刷新
    }

    //添加凭证类型
    $scope.saveFinancialVoucher = function(){
        $location.path('app/financial_voucher_save');
    }
    //修改凭证类型
    $scope.modifyFinancialVoucher = function(){

        if(($scope.voucherType == '')|| (isUndefinedNull($scope.voucherType)))
            modalAlert($modal,'请您选择需要修改的数据！');
        else{
            $location.path('app/financial_voucher_modify').search({'voucherType':$scope.voucherType})
        }

    }
    //删除凭证类型
    $scope.deleteFinancialVoucher = function(){
        if(($scope.voucherTypeName == '')|| (isUndefinedNull($scope.voucherTypeName)))
            modalAlert($modal,'请您选择需要修改的数据！')
        else{

            modalConfirm($modal,function(){
                $http.delete('financial_voucher/deleteFinancialVouchersByVoucherIds?voucherType='+$scope.voucherTypeName).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除凭证类型成功', toaster);
                        // 初始化
                        initFinancialVouchersTree();
                        $scope.voucherTypeName = ''
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

    //添加凭证明细
    $scope.saveFinancialVoucherDetail = function(){
        $location.path('app/financial_voucher_detail_save')
    }

    //修改凭证明细
    $scope.modifyFinancialVoucherDetail = function(){
        var rowsId =  $scope.dataTable.getRowsIds('voucherDetailId');
        if(rowsId.length < 1){
            modalAlert($modal,'请选择要修改的数据')
        }else if(rowsId.length > 1){
            modalAlert($modal,'只能修改一条数据')
        } else{
            $location.path('app/financial_voucher_detail_modify').search({'voucherDetailId':rowsId})
        }

    }
    //详情
    $scope.detailFinancialVoucherDetail = function(voucherDetailId){
       var voucherDetail =   $scope.dataTable.getRow(voucherDetailId,'voucherDetailId')
        $location.path('app/financial_voucher_detail_detail').search({'voucherDetailId':voucherDetail.voucherDetailId})
    }
    //删除
    $scope.deleteFinancialVoucherDetail = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('voucherDetailId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('financial_voucher_detail/deleteFinancialVoucherDetailsByVoucherDetailIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除凭证类型明细成功', toaster);
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