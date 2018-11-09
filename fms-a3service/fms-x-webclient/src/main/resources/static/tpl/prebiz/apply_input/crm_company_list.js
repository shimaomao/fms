/**
 * Created by ningyangyang on 2018-05-23.
 */
app.controller('crm_company_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$modalInstance', function ($scope, $http, $modal, toaster,$compile,$location,$modalInstance) {
    //参数配置
    $scope.dataTableProperties = {
        dataTableAjax : {
            url : 'crm_company/findCrmCompanysByPage',
            type:"GET"
        },
        dataTableId:'crm_company_table',
        dataTableColumn: [
            defaultCheckBox('socialCertifNo'),
            defaultDetail('name','detailCrmCompany','企业名称','20%',$compile,$scope,'socialCertifNo'),
            {title:'统一社会信用代码',data:'socialCertifNo',width:'20%'},
            {title:'法定代表人',data:'compLegalRep',width:'20%'},
            {title:'法人证件类型',data:'certifType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType,data);
                }
            },
            {title:'法人证件号码',data:'certifNo',width:'20%'},
            {title:'法人手机号码',data:'mobileNo',width:'20%'},
            {title:'经营省份',data:'compProv',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'经营城市',data:'compCity',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'经营区县',data:'compCounty',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'经营详细地址',data:'compAddr',width:'20%'},
            {title:'注册资金',data:'regCapital',width:'20%'},
            {title:'企业联系电话',data:'compTel',width:'20%'},
            {title:'企业性质',data:'compType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.compType,data);
                }
            },
            {title:'成立年限',data:'establYear',width:'20%'}
        ],
        dataTableSelectType: Radio
    };
    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.name = $scope.name;
        params.socialCertifNo = $scope.socialCertifNo;
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
        var row = $scope.dataTable.getRow();
        if(row){
            $scope.close(row);
        }else{
            modalAlert($modal,"请选择一条数据！");
        }

    };
    
    $scope.detailCrmCompany = function (socialCertifNo) {
        var row = $scope.dataTable.getRow(socialCertifNo,"socialCertifNo");
        $scope.close(row);
    };

    //查询
    $scope.searchSysGroup = function () {
        $scope.dataTable.fnDraw(true);
    };

    //重置
    $scope.resetSysGroup = function () {
        $scope.name = "";
        $scope.socialCertifNo = "";
        $scope.dataTable.fnDraw(true);
    };
}]);