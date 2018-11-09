/**
 * Created by lijunjun on 2018-04-28.
 */
app.controller('postbiz_invoice_company_list_controller', ['$scope', '$http', '$modal', 'toaster', '$compile', '$location', '$localStorage','setData', function ($scope, $http, $modal, toaster, $compile, $location, $localStorage, setData) {

    //查询参数
    $scope.params = setData.getter();
    // 从其他画面跳转到的弹出信息显示
    $scope.type = $location.search()['type'];
    $scope.msg = $location.search()['msg'];
    if ($scope.type == 'submit') {
        toaster_success($scope.msg, toaster);
    }

    //参数配置
    $scope.dataTableProperties = {
        //ajax url 和类型
        dataTableAjax: {
            url: 'invoice_change_task/findCompanyInvoiceListByPage',
            type: "GET",
        },
        //table的html id
        dataTableId: 'contract_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('companyId'),
            {title: '承租人', data: 'name', width: '10%'},
            {title: '统一社会信用代码', data: 'socialCertifNo', width: '10%'},
            {
                title: '开票类型', data: 'invoiceType', width: '10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceType, data);
                }
            },
            {title: '开票名称', data: 'ticketOpening', width: '10%'},
            {title: '开票地址电话', data: 'invoiceAddr', width: '10%'},
            {title: '税号', data: 'dutyParagraph', width: '10%'},
            {title: '账号', data: 'accountNumber', width: '10%'},
            {title: '开户行', data: 'bankName', width: '10%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope) {
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties, dataTableParams, $scope);


    $scope.searchContractList = function () {
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetContractList = function () {
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }

    //导出数据表
    $scope.exportExcel = function () {
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.postbiz, CommonServiceType.excelTypes.one,
            'invoice_change_task/findCompanyInvoiceListByPage', dataTableParams($scope));
    }

    //导出权限控制
    var roles = $localStorage.user.roles;
    for (var i in roles) {
        if (roles[i].role == CommonCodeUtils.role.QY || roles[i].role == CommonCodeUtils.role.YW) {
            $scope.exportFlag = false;
        }
    }

    //开票信息更改
    $scope.invoiceChange = function () {
        var rows = $scope.dataTable.getRows();
        if (rows.length < 1) {
            modalAlert($modal, "请您选择需要修改的合同信息！");
        } else if (rows.length > 1) {
            modalAlert($modal, "只能同时修改一条数据！");
        } else {
            $http.post('invoice_change/checkInvoiceChange', rows[0]).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path('app/postbiz_invoice_change_save').search({socialCertifNo: rows[0].socialCertifNo, type:'list'});
                } else{
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
        }
    };


}])
;