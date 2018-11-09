 /**
 * Created by lijunjun on 2018-04-28.
 */
app.controller('postbiz_comp_basic_hi_change_controller', ['$scope', '$http', '$modal', 'toaster', '$compile', '$location', '$localStorage', 'applyNo', '$modalInstance', function ($scope, $http, $modal, toaster, $compile, $location, $localStorage, applyNo, $modalInstance) {

    $scope.applyNo = applyNo;
    //参数配置
    $scope.dataTableProperties = {
        //ajax url 和类型
        dataTableAjax: {
            url: 'basic_change_task/findBasicCompChangeHistory',
            type: "GET",
        },
        //table的html id
        dataTableId: 'basic_change_comp_table',
        //table的列
        dataTableColumn: [
            {title: '任务号', data: 'taskNo', width: '10%'},
            {title: '任务状态', data: 'basicTaskStatus', width: '10%',
                render:function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus, data);
                }},
            {title: '变更发起人', data: 'submitUser', width: '10%'},
            {title: '变更发起时间', data: 'submitDate', width: '10%'},
            {title: '备注', data: 'remark', width: '10%'},
            {title: '变更后承租人', data: 'name', width: '10%'},
            {title: '变更后联系人姓名', data: 'contactName', width: '10%'},
            {title: '变更后联系人手机号码', data: 'contactMobno', width: '10%'},
            {title: '变更后经营地址-省份', data: 'compProv', width: '10%',
                render: function (data, type, row, meta) {
                    return AreaUtils.getAreaName(data);
                }
            },
            {title: '变更后经营地址-城市', data: 'compCity', width: '10%',
                render: function (data, type, row, meta) {
                    return AreaUtils.getAreaName(data);
                }
            },
            {title: '变更后经营地址-区县', data: 'compCounty', width: '10%',
                render: function (data, type, row, meta) {
                    return AreaUtils.getAreaName(data);
                }
            },
            {title: '变更后经营地址-详细地址', data: 'compAddr', width: '10%'},
            {
                title: '变更后开票类型', data: 'invoiceType', width: '10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceType, data);
                }
            },
            {title: '变更后开票名', data: 'ticketOpening', width: '10%'},
            {title: '变更后税号', data: 'dutyParagraph', width: '10%'},
            {title: '变更后地址', data: 'invoiceAddr', width: '10%'},
            {title: '变更后账号', data: 'accountNumber', width: '10%'},
            {title: '变更后发票邮寄地址', data: 'invoiceMailAddr', width: '10%'},
            {title: '变更后邮寄联系人', data: 'invoiceContactPer', width: '10%'},
            {title: '变更后联系人电话', data: 'invoiceContactNo', width: '10%'},
            {title: '变更后开户行', data: 'bankName', width: '10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.openingBank,data);
                }
            },
            {title: '变更前承租人', data: 'nameOld', width: '10%'},
            {title: '变更前联系人姓名', data: 'contactNameOld', width: '10%'},
            {title: '变更前联系人手机号码', data: 'contactMobnoOld', width: '10%'},
        ]
    }


    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.applyNo = $scope.applyNo;
        return params;
    }

    $scope.init = function () {
        //创建dataTable
        $scope.dataTable = createTable($scope.dataTableProperties, dataTableParams, $scope);
    }

    $scope.close = function(){
        $modalInstance.close();
    };

}])
;