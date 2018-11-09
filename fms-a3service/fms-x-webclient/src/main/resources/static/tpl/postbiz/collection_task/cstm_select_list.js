/**
 * Created by ningyangyang on 2018-05-23.
 */
app.controller('cstm_select_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$modalInstance', function ($scope, $http, $modal, toaster,$compile,$location,$modalInstance) {

    $scope.overdueFlag = '1';
    //参数配置
    $scope.dataTableProperties = {
        dataTableAjax : {
            url : 'collection_task/findCstmInfosByPage',
            type:"GET"
        },
        dataTableId:'cstm_select_table',
        dataTableColumn: [
            defaultCheckBox('certifNo'),
            defaultDetail('cstmName','detailCrmPerson','承租人','20%',$compile,$scope,'certifNo'),
            // {title:'证件类型',data:'certifType',width:'20%',
            //     render: function (data, type, row, meta) {
            //         return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType,data);
            //     }
            // },
            {title:'证件号码',data:'certifNo',width:'20%'},
            {title:'客户性别',data:'sex',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gender,data);
                }
            },
            {title:'当前逾期天数',data:'overdueDays',width:'20%'},
            {title:'当前逾期期数',data:'overduePeriods',width:'20%'},
            {title:'当前逾期总额',data:'overdueSum',width:'20%'},
            {title:'当前逾期状态',data:'overdueCondCd',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.overdueCondCd,data);
                }
            },
            {title:'当前风险等级',data:'overdueRisk',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.overdueRisk,data);
                }
            },
        ],
        dataTableSelectType: Radio
    };
    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.cstmName = $scope.cstmName;
        params.certifNo = $scope.certifNo;
        params.overdueRisk = $scope.overdueRisk;
        params.overdueFlag = $scope.overdueFlag;
        return params;
    }

    //重置
    $scope.resetCstmList = function () {
        $scope.cstmName = "";
        $scope.certifNo = "";
        $scope.overdueRisk = "";
        $scope.overdueFlag = "";
        $scope.dataTable.fnDraw(true);
    };

    $scope.init = function () {
        $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    };

    //关闭
    $scope.close = function (status) {
        $modalInstance.close(status);
    };

    //确定
    $scope.save = function () {
        var rows = $scope.dataTable.getRows();
        if (rows.length > 1){
            modalAlert($modal, "至多只能选择一条数据");
        } else if(rows.length < 1){
            modalAlert($modal, "请选择一条数据");
        } else {
            $scope.close(rows[0]);
        }
        /*var certifNo = $scope.dataTable.getRowId('certifNo');
        if(certifNo){
            $scope.close(certifNo);
        }else{
            modalAlert($modal,"请选择一条数据！");
        }*/

    };

    $scope.detailCrmPerson = function (certifNo) {
        var row = $scope.dataTable.getRow(certifNo,'certifNo');
        console.log(row);
        $scope.close(row);
        // $scope.close(certifNo);
    };

    //查询
    $scope.searchCstmList = function () {
        $scope.dataTable.fnDraw(true);
    };
}]);