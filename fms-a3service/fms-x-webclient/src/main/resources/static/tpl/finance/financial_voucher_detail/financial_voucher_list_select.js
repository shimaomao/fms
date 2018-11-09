/**
 * Created by ningyangyang on 2018/6/20.
 */
/**
 * Created by ningyangyang on 2018-05-23.
 */
app.controller('financial_voucher_list_select_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$modalInstance', function ($scope, $http, $modal, toaster,$compile,$location,$modalInstance) {
    //参数配置
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
        dataTableSelectType: Radio
    }
    //请求的参数
    function dataTableParams($scope){
        params = {};
        return params;
    }

    $scope.init = function () {
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };

    //关闭
    $scope.close = function (status) {
        $modalInstance.close(status);
    };

    //确定
    $scope.save = function () {
        var voucherType = $scope.dataTable.getRowId('voucherType');
        if(voucherType){
            $scope.close(voucherType);
        }else{
            modalAlert($modal,"请选择一条数据！");
        }
    };
    $scope.detailFinancialVoucher = function(voucherId){
        var voucherType = $scope.dataTable.getRow(voucherId,'voucherId');
        $scope.close(voucherType.voucherType);
    }
}]);