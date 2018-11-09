/**
 * Created by yangyiquan on 2018-05-9.
 */
app.controller('contRepayAccount_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {

    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
         if ($scope.type == 'modify') {
            toaster_success('修改客户还款信息成功',toaster);
        }
    }, 100);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'contRepayAccount/findContRepayAccountListByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'contRepayAccount_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contNo'),
            // defaultDetail('contNo','detailContRepayAccount','合同编号','10%',$compile,$scope,'contNo'),
            {title:'申请编号',data:'applyNo',width:'10%'},
            {title:'合同编号',data:'contNo',width:'10%'},
            {title:'客户姓名',data:'name',width:'10%'},
            {title:'证件号码',data:'cstmCertifNo',width:'10%'},
            {title:'还款卡银行',data:'accBank',width:'10%',
                render: function (data, type, row, meta) {
                    if(data == null){
                        return "";
                    }
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.openingBank,data);
                }
            },
            {title:'还款卡户名',data:'accountName',width:'10%',},
            {title:'还款卡账号',data:'accountNo',width:'10%'},
            {title:'还款卡绑定证件号',data:'certifNo',width:'10%'},
            {title:'还款卡绑定手机号',data:'accMobileNo',width:'10%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.contNo = $scope.contNo;
        params.applyNo = $scope.applyNo;
        params.name = $scope.name;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchContRepayAccountList = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetContRepayAccountList = function(){
        $scope.contNo = "";
        $scope.applyNo = "";
        $scope.name = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    //修改客户还款信息
    $scope.modifyContRepayAccount = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('contNo');

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            $location.path('/app/prebiz_cont_repay_account_modify').search({
                'contNo': rowsIds[0]

            });

        }

    }

    //客户还款详情查看
    $scope.detailContRepayAccount = function(contNo){
        var contract =  $scope.dataTable.getRow(contNo,'contNo')
        $location.path("app/prebiz_apply_input_detail").search({'applyNo':contract.applyNo,'contNo':contract.contNo,'applyType':contract.applyType,'type':'contract'});

    }


}])
;