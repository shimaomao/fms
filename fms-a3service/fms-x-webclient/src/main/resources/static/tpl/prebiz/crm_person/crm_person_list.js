/**
 * Created by ningyangyang on 2018-05-23.
 */
app.controller('crm_person_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {
    //客户类型
    $scope.customerType = 1;
    $scope.$watch('customerType',function () {
        $scope.name = '';
        $scope.certifNo = '';
        $scope.socialCertifNo = '';
        if($scope.customerType == 1){
            $('#crm_person_table_wrapper').removeClass('hidden');
            $('#crm_company_table_wrapper').addClass('hidden');
            if($scope.dataTable1){
                $scope.dataTable1.fnDraw(true);
            }else{
                $scope.dataTable1 = createTable($scope.dataTableProperties(),dataTableParams,$scope);
            }
        }else{
            $('#crm_person_table_wrapper').addClass('hidden');
            $('#crm_company_table_wrapper').removeClass('hidden');
            if($scope.dataTable2){
                $scope.dataTable2.fnDraw(true);
            }else{
                $scope.dataTable2 = createTable($scope.dataTableProperties(),dataTableParams,$scope);
            }
        }

    });
    //参数配置
    $scope.dataTableProperties = function () {
        if($scope.customerType == 1){
            return {
                dataTableAjax : {
                    url : 'crm_person/findCrmPersonsByPage',
                    type:"GET"
                },
                dataTableId:'crm_person_table',
                dataTableColumn: [
                    defaultCheckBox('personId'),
                    defaultDetail('name','detailCrmPerson','客户姓名','20%',$compile,$scope,'personId'),
                    {title:'证件类型',data:'certifType',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType,data);
                        }
                    },
                    {title:'证件号码',data:'certifNo',width:'20%'},
                    {title:'客户性别',data:'sex',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gender,data);
                        }
                    },
                    {title:'婚姻状况',data:'marriageStatus',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.marriageStatus,data);
                        }
                    },
                    {title:'户口类别',data:'censusType',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.censusType,data);
                        }
                    },
                    {title:'出生日期',data:'birthDate',width:'20%'},
                    {title:'客户学历',data:'eduBgType',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.eduBgType,data);
                        }
                    },
                    {title:'手机号码',data:'mobileNo',width:'20%'},
                    {title:'住宅电话',data:'telNo',width:'20%'},
                    {title:'QQ号码',data:'qqNo',width:'20%'},
                    {title:'微信号',data:'wechatNo',width:'20%'},
                    {title:'电子邮件',data:'mail',width:'20%'},
                    {title:'客户民族',data:'ethnicType',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.ethnicType,data);
                        }
                    },
                    {title:'驾驶证号',data:'licenseNo',width:'20%'},
                    {title:'单位名称',data:'compName',width:'20%'},
                    {title:'单位电话',data:'compTel',width:'20%'},
                    {title:'在职年限',data:'workYear',width:'20%'},
                    {title:'职业',data:'profession',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.professionType,data);
                        }
                    },
                    {title:'职位',data:'position',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.positionType,data);
                        }
                    },
                    {title:'单位所属行业类别',data:'industry',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.industryType,data);
                        }
                    },
                    {title:'单位所在省',data:'compProv',width:'20%',
                        render: function (data, type, row, meta) {
                            return AreaUtils.getAreaName(data);
                        }
                    },
                    {title:'单位所在市',data:'compCity',width:'20%',
                        render: function (data, type, row, meta) {
                            return AreaUtils.getAreaName(data);
                        }
                    },
                    {title:'单位所在区县',data:'compCounty',width:'20%',
                        render: function (data, type, row, meta) {
                            return AreaUtils.getAreaName(data);
                        }
                    },
                    {title:'单位所在详细地址',data:'compAddr',width:'20%'},
                    {title:'税后年薪(万元)',data:'salary',width:'20%'},
                    {title:'其他税后年薪(万元)',data:'elseSalary',width:'20%'},
                    {title:'居住状况',data:'resideCond',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.resideCond,data);
                        }
                    },
                    {title:'居住年限',data:'resideYear',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.resideYear,data);
                        }
                    },
                    {title:'居住省份',data:'resideProv',width:'20%',
                        render: function (data, type, row, meta) {
                            return AreaUtils.getAreaName(data);
                        }
                    },
                    {title:'居住城市',data:'resideCity',width:'20%',
                        render: function (data, type, row, meta) {
                            return AreaUtils.getAreaName(data);
                        }
                    },
                    {title:'居住区县',data:'resideCounty',width:'20%',
                        render: function (data, type, row, meta) {
                            return AreaUtils.getAreaName(data);
                        }
                    },
                    {title:'居住详细地址',data:'resideAddr',width:'20%'},
                    {title:'户籍省份',data:'censusProv',width:'20%',
                        render: function (data, type, row, meta) {
                            return AreaUtils.getAreaName(data);
                        }
                    },
                    {title:'户籍城市',data:'censusCity',width:'20%',
                        render: function (data, type, row, meta) {
                            return AreaUtils.getAreaName(data);
                        }
                    },
                    {title:'户籍区县',data:'censusCounty',width:'20%',
                        render: function (data, type, row, meta) {
                            return AreaUtils.getAreaName(data);
                        }
                    },
                    {title:'户籍详细地址',data:'censusAddr',width:'20%'},
                    {title:'房产类型',data:'propertyType',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.propertyType,data);
                        }
                    },
                    {title:'房产省份',data:'propertyProv',width:'20%',
                        render: function (data, type, row, meta) {
                            return AreaUtils.getAreaName(data);
                        }
                    },
                    {title:'房产城市',data:'propertyCity',width:'20%',
                        render: function (data, type, row, meta) {
                            return AreaUtils.getAreaName(data);
                        }
                    },
                    {title:'房产区县',data:'propertyCounty',width:'20%',
                        render: function (data, type, row, meta) {
                            return AreaUtils.getAreaName(data);
                        }
                    },
                    {title:'房产详细地址',data:'propertyAddr',width:'20%'},
                ],
                dataTableSelectType: Radio
            }
        }else {
            return {
                dataTableAjax : {
                    url : 'crm_company/findCrmCompanysByPage',
                    type:"GET"
                },
                dataTableId:'crm_company_table',
                dataTableColumn: [
                    defaultCheckBox('companyId'),
                    defaultDetail('name','detailCrmCompany','企业名称','20%',$compile,$scope,'companyId'),
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
                            return AreaUtils.getAreaName(data);
                        }
                    },
                    {title:'经营城市',data:'compCity',width:'20%',
                        render: function (data, type, row, meta) {
                            return AreaUtils.getAreaName(data);
                        }
                    },
                    {title:'经营区县',data:'compCounty',width:'20%',
                        render: function (data, type, row, meta) {
                            return AreaUtils.getAreaName(data);
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
            }
        }
    };
    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.name = $scope.name;
        params.certifNo = $scope.certifNo;
        params.socialCertifNo = $scope.socialCertifNo;
        return params;
    }
    //录入个人客户
    $scope.inputPersonal = function () {
        $location.path('/app/crm_person_modify');
    };
    //查看个人详情
    $scope.detailCrmPerson = function (personId) {
        $location.path('/app/crm_person_detail').search({
            "personId": personId
        });
    };
    //录入企业客户
    $scope.inputEnterprise = function () {
        $location.path('/app/crm_company_modify');
    };
    //查看企业详情
    $scope.detailCrmCompany = function (companyId) {
        $location.path('/app/crm_company_detail').search({
            "companyId": companyId
        });
    };
    //修改
    $scope.modify = function () {
        if($scope.customerType == 1){
            var personId = $scope.dataTable1.getRowId('personId');
            if(personId != null){
                $location.path('/app/crm_person_modify').search({
                    "personId": personId
                });
            }else{
                modalAlert($modal,"请选择数据!");
            }
        }else{
            var companyId = $scope.dataTable2.getRowId('companyId');
            if(companyId != null){
                $location.path('/app/crm_company_modify').search({
                    "companyId": companyId
                });
            }else{
                modalAlert($modal,"请选择数据!");
            }
        }
    }
    //查询信息
    $scope.searchCstmCompany = function(){
            if ($scope.customerType == 1) {
                $scope.dataTable1.fnDraw(true);
            }else if($scope.customerType == 2){
                $scope.dataTable2.fnDraw(true);
            }
    }
    //重置信息
    $scope.resetCstmCompany = function(){
        $scope.name = "";
        $scope.certifNo = "";
        $scope.socialCertifNo = "";
            if ($scope.customerType == 1) {
                $scope.dataTable1.fnDraw(true);
            }else if($scope.customerType == 2){
                $scope.dataTable2.fnDraw(true);
            }

    }

}]);