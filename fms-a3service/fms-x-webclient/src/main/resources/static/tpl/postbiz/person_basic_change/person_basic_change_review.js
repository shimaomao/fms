/**
 * Created by lijunjun on 2018-08-31.
 */
app.controller('person_basic_change_review_controller', ['$scope', '$http','$modal','toaster','$location','$compile', function ($scope, $http,$modal,toaster,$location,$compile) {

    $scope.personBasicChangePostVo = {};
    $scope.oldPersonBasicChangeVo = {};
    $scope.newPersonBasicChangeVo = {};
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

    $scope.personTaskNo = $location.search()['serviceId'];
    $scope.applyNo = $location.search()['applyNo'];
    $scope.applyType = $location.search()['applyType'];
    $scope.taskId = $location.search()['taskId'];

    $http.get('person_basic_change/findCstmPersonByTaskNo?personTaskNo='+ $scope.personTaskNo).success(function (data) {
        console.log('data', data.data);
        $scope.oldPersonBasicChangeVo = $.extend(true, {}, data.data.oldPersonBasicChangeVo);
        $scope.newPersonBasicChangeVo = $.extend(true, {}, data.data.newPersonBasicChangeVo);
        // 判断每个项目是否变更过
        isChangedSolve($scope.oldPersonBasicChangeVo, $scope.newPersonBasicChangeVo);
        $scope.cstmContactList = $scope.oldPersonBasicChangeVo.cstmContactList;
        $scope.newCstmContactList = $scope.newPersonBasicChangeVo.cstmContactList;
        $scope.oldPersonBasicChangeVo.resideProvName = AreaUtils.getAreaName($scope.oldPersonBasicChangeVo.resideProv);
        $scope.oldPersonBasicChangeVo.resideCityName = AreaUtils.getAreaName($scope.oldPersonBasicChangeVo.resideCity);
        $scope.oldPersonBasicChangeVo.resideCountyName = AreaUtils.getAreaName($scope.oldPersonBasicChangeVo.resideCounty);

        $scope.newPersonBasicChangeVo.resideProvName = AreaUtils.getAreaName($scope.newPersonBasicChangeVo.resideProv);
        $scope.newPersonBasicChangeVo.resideCityName = AreaUtils.getAreaName($scope.newPersonBasicChangeVo.resideCity);
        $scope.newPersonBasicChangeVo.resideCountyName = AreaUtils.getAreaName($scope.newPersonBasicChangeVo.resideCounty);
        initDetailTable();
        initSaveTable();
    });

    /**
     * 判断变更前后各项目是否变化，并给Flag赋值
     * @param oldEntity
     * @param newEntity
     */
    function isChangedSolve(oldEntity, newEntity) {
        $scope.nameFlag = getChangedFlag(oldEntity.name, newEntity.name);
        $scope.mobileNoFlag = getChangedFlag(oldEntity.mobileNo, newEntity.mobileNo);
        $scope.resideProvFlag = getChangedFlag(oldEntity.resideProv, newEntity.resideProv);
        $scope.resideCityFlag = getChangedFlag(oldEntity.resideCity, newEntity.resideCity);
        $scope.resideCountyFlag = getChangedFlag(oldEntity.resideCounty, newEntity.resideCounty);
        $scope.resideAddrFlag = getChangedFlag(oldEntity.resideAddr, newEntity.resideAddr);
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
                        return CommonCodeUtils.getCodeValueName('relationPer2',data);
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
                        return CommonCodeUtils.getCodeValueName('relationPer2',data);
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
     * 资管审核通过
     */
    $scope.save = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.personBasicChangePostVo.newPersonBasicChangeVo = $scope.newPersonBasicChangeVo;
            $scope.personBasicChangePostVo.oldPersonBasicChangeVo = $scope.oldPersonBasicChangeVo;
            $scope.personBasicChangePostVo.taskId = $scope.taskId;
            $scope.personBasicChangePostVo.personTaskNo = $scope.personTaskNo;
            $http.post('person_basic_change/personBasicChangeReview', $scope.personBasicChangePostVo).success(function (data) {
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
     * 资管审核退回
     */
    $scope.backUp = function () {
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.newPersonBasicChangeVo.cstmContactList = $scope.cstmContactList;
            $scope.personBasicChangePostVo.newPersonBasicChangeVo = $scope.newPersonBasicChangeVo;
            $scope.personBasicChangePostVo.oldPersonBasicChangeVo = $scope.oldPersonBasicChangeVo;
            $scope.personBasicChangePostVo.taskId = $scope.taskId;
            $scope.personBasicChangePostVo.personTaskNo = $scope.personTaskNo;
            $http.post('person_basic_change/personBasicChangeReviewBack', $scope.personBasicChangePostVo).success(function (data) {
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
    $scope.wfLogNo = $scope.personTaskNo;

}]);


