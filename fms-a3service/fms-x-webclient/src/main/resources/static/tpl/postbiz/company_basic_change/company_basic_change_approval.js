/**
 * Created by lijunjun on 2018-08-31.
 */
app.controller('company_basic_change_approval_controller', ['$scope', '$http','$modal','toaster','$location','$compile', function ($scope, $http,$modal,toaster,$location,$compile) {

    // $scope.cstmPersAddr = {};
    $scope.companyBasicChangePostVo = {};
    $scope.oldCompanyBasicChangeVo = {};
    $scope.newCompanyBasicChangeVo = {};
    $scope.formValidate = false;
    $scope.submit = false;
    //地区信息
    $scope.cityMap=common_area_value[common_area_code.getCityList];
    //key - arealist
    $scope.areaMap=common_area_value[common_area_code.getAreaList];
    $scope.provinceList=common_area_value[common_area_code.getProvinceList];
    //修改初始化地区
    $scope.cityList =$scope.cityMap;
    $scope.areaList=$scope.areaMap;

    $scope.companyTaskNo = $location.search()['serviceId'];
    $scope.applyNo = $location.search()['applyNo'];
    $scope.applyType = $location.search()['applyType'];
    $scope.taskId = $location.search()['taskId'];

    $http.get('company_basic_change/findCstmCompanyByTaskNo?companyTaskNo='+ $scope.companyTaskNo).success(function (data) {

        $scope.oldCompanyBasicChangeVo = $.extend(true, {}, data.data.oldCompanyBasicChangeVo);
        $scope.newCompanyBasicChangeVo = $.extend(true, {}, data.data.newCompanyBasicChangeVo);
        // 判断每个项目是否变更过
        isChangedSolve($scope.oldCompanyBasicChangeVo, $scope.newCompanyBasicChangeVo);
        $scope.cstmContactList = $scope.oldCompanyBasicChangeVo.cstmContactList;
        $scope.newCstmContactList = $scope.newCompanyBasicChangeVo.cstmContactList;
        $scope.oldCompanyBasicChangeVo.compProvName = AreaUtils.getAreaName($scope.oldCompanyBasicChangeVo.compProv);//经营省份名称
        $scope.oldCompanyBasicChangeVo.compCityName = AreaUtils.getAreaName($scope.oldCompanyBasicChangeVo.compCity);//经营城市名称
        $scope.oldCompanyBasicChangeVo.compCountyName = AreaUtils.getAreaName($scope.oldCompanyBasicChangeVo.compCounty);//经营区县名称
        $scope.oldCompanyBasicChangeVo.invoiceTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceType,$scope.oldCompanyBasicChangeVo.invoiceType);

        $scope.newCompanyBasicChangeVo.compProvName = AreaUtils.getAreaName($scope.newCompanyBasicChangeVo.compProv);//经营省份名称
        $scope.newCompanyBasicChangeVo.compCityName = AreaUtils.getAreaName($scope.newCompanyBasicChangeVo.compCity);//经营城市名称
        $scope.newCompanyBasicChangeVo.compCountyName = AreaUtils.getAreaName($scope.newCompanyBasicChangeVo.compCounty);//经营区县名称
        $scope.newCompanyBasicChangeVo.invoiceTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceType,$scope.newCompanyBasicChangeVo.invoiceType);
        initDetailTable();
        initSaveTable();
    });

    /*历史联系人明细信息*/
    function initDetailTable(){
        //参数配置
        $scope.dataTableProperties= {
            //table的html id
            dataTableId:'contact_table_detail',
            dataTableColumn:[
                {title:'联系人姓名',data:'name'},
                {title:'是否租金联系人',data:'rentFlag',
                    render:function (data) {
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.yesNoFlag,data);
                    }
                },
                {title:'联系人关系',data:'relation',
                    render:function (data) {
                        return CommonCodeUtils.getCodeValueName('relationPerComp',data);
                    }
                },
                {title:'联系人号码',data:'mobileNo'},
                {title:'联系人所在省份',data:'resideProv',
                    render:function (data) {
                        return AreaUtils.getAreaName(data);
                    }
                },
                {title:'联系人所在城市',data:'resideCity',
                    render:function (data) {
                        return AreaUtils.getAreaName(data);
                    }
                },
                {title:'联系人所在区县',data:'resideCounty',
                    render:function (data) {
                        return AreaUtils.getAreaName(data);
                    }
                },
                {title:'联系人地址',data:'resideAddr'},
            ],
            dataTableData: $scope.cstmContactList
        }
        CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
    }

    //联系人列表
    function initSaveTable(){
        //参数配置
        $scope.dataTableProperties= {
            //table的html id
            dataTableId:'contact_table_save',
            dataTableColumn:[
                {title:'联系人姓名',data:'name'},
                {title:'是否租金联系人',data:'rentFlag',
                    render:function (data) {
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.yesNoFlag,data);
                    }
                },
                {title:'联系人关系',data:'relation',
                    render:function (data) {
                        return CommonCodeUtils.getCodeValueName('relationPerComp',data);
                    }
                },
                {title:'联系人号码',data:'mobileNo'},
                {title:'联系人所在省份',data:'resideProv',
                    render:function (data) {
                        return AreaUtils.getAreaName(data);
                    }
                },
                {title:'联系人所在城市',data:'resideCity',
                    render:function (data) {
                        return AreaUtils.getAreaName(data);
                    }
                },
                {title:'联系人所在区县',data:'resideCounty',
                    render:function (data) {
                        return AreaUtils.getAreaName(data);
                    }
                },
                {title:'联系人地址',data:'resideAddr'},
            ],
            dataTableData: $scope.newCstmContactList
        }

        CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
    }

    /**
     * 基本信息变更-企业资管审核通过
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.companyBasicChangePostVo.basicTaskNo = $scope.companyTaskNo;
            $scope.companyBasicChangePostVo.newCompanyBasicChangeVo = $scope.newCompanyBasicChangeVo;
            $scope.companyBasicChangePostVo.oldCompanyBasicChangeVo = $scope.oldCompanyBasicChangeVo;
            $scope.companyBasicChangePostVo.taskId = $scope.taskId;
            $http.post('company_basic_change/companyBasicChangeApproval', $scope.companyBasicChangePostVo).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path('app/home');
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    }

    /**
     * 基本信息变更-企业资管审核退回
     */
    $scope.backUp = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.companyBasicChangePostVo.basicTaskNo = $scope.companyTaskNo;
            $scope.companyBasicChangePostVo.newCompanyBasicChangeVo = $scope.newCompanyBasicChangeVo;
            $scope.companyBasicChangePostVo.oldCompanyBasicChangeVo = $scope.oldCompanyBasicChangeVo;
            $scope.companyBasicChangePostVo.taskId = $scope.taskId;
            $http.post('company_basic_change/companyBasicChangeBack', $scope.companyBasicChangePostVo).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path('app/home');
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    }

    /**
     * 判断变更前后各项目是否变化，并给Flag赋值
     * @param oldEntity
     * @param newEntity
     */
    function isChangedSolve(oldEntity, newEntity) {
        $scope.nameFlag = getChangedFlag(oldEntity.name, newEntity.name);
        $scope.contactNameFlag = getChangedFlag(oldEntity.contactName, newEntity.contactName);
        $scope.contactMobnoFlag = getChangedFlag(oldEntity.contactMobno, newEntity.contactMobno);
        $scope.compProvFlag = getChangedFlag(oldEntity.compProv, newEntity.compProv);
        $scope.compCityFlag = getChangedFlag(oldEntity.compCity, newEntity.compCity);
        $scope.compCountyFlag = getChangedFlag(oldEntity.compCounty, newEntity.compCounty);
        $scope.compAddrFlag = getChangedFlag(oldEntity.compAddr, newEntity.compAddr);
        $scope.invoiceTypeFlag = getChangedFlag(oldEntity.invoiceType, newEntity.invoiceType);
        $scope.ticketOpeningFlag = getChangedFlag(oldEntity.ticketOpening, newEntity.ticketOpening);
        $scope.dutyParagraphFlag = getChangedFlag(oldEntity.dutyParagraph, newEntity.dutyParagraph);
        $scope.invoiceAddrFlag = getChangedFlag(oldEntity.invoiceAddr, newEntity.invoiceAddr);
        $scope.invoiceContactPerFlag = getChangedFlag(oldEntity.invoiceContactPer, newEntity.invoiceContactPer);
        $scope.accountNumberFlag = getChangedFlag(oldEntity.accountNumber, newEntity.accountNumber);
        $scope.bankNameFlag = getChangedFlag(oldEntity.bankName, newEntity.bankName);
        $scope.invoiceContactNoFlag = getChangedFlag(oldEntity.invoiceContactNo, newEntity.invoiceContactNo);
        $scope.invoiceMailAddrFlag = getChangedFlag(oldEntity.invoiceMailAddr, newEntity.invoiceMailAddr);
    };

    /**
     * 判断两个值是否不同，如果不同返回1
     * @param value1
     * @param value2
     * @returns {string}
     */
    function getChangedFlag (value1, value2) {
        if (value1 != value2){
            return '1';
        }
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $location.path('app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.basicChange;
    $scope.wfLogNo = $scope.companyTaskNo;
    // $scope.wfLogSubNo = $scope.companyTaskNo;
}]);


