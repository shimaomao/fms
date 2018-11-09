/**
 * Created by ningyangyang on 2018-05-23.
 */
app.controller('crm_person_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$modalInstance', function ($scope, $http, $modal, toaster,$compile,$location,$modalInstance) {
    //参数配置
    $scope.dataTableProperties = {
        dataTableAjax : {
            url : 'crm_person/findCrmPersonsByPage',
            type:"GET"
        },
        dataTableId:'crm_person_table',
        dataTableColumn: [
            defaultCheckBox('certifNo'),
            defaultDetail('name','detailCrmPerson','客户姓名','20%',$compile,$scope,'certifNo'),
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
    };
    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.name = $scope.name;
        params.certifNo = $scope.certifNo;
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
        var certifNo = $scope.dataTable.getRowId('certifNo');
        if(certifNo){
            $scope.close(certifNo);
        }else{
            modalAlert($modal,"请选择一条数据！");
        }

    };

    $scope.detailCrmPerson = function (certifNo) {
        $scope.close(certifNo);
    };

    //查询
    $scope.searchSysGroup = function () {
        $scope.dataTable.fnDraw(true);
    };

    //重置
    $scope.resetSysGroup = function () {
        $scope.name = "";
        $scope.certifNo = "";
        $scope.dataTable.fnDraw(true);
    };
}]);