/**
 * Created by lijunjun on 2018-08-31.
 */
app.controller('company_basic_change_save_controller', ['$scope', '$http','$modal','toaster','$location','$compile','$timeout', function ($scope, $http,$modal,toaster,$location,$compile,$timeout) {

    $scope.cstmPersAddr = {};
    $scope.companyBasicChangePostVo = {};
    $scope.oldCompanyBasicChangeVo = {};
    $scope.newCompanyBasicChangeVo = {};
    $scope.cstmContactList = [];
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

    $scope.companyTaskNo = '';
    $scope.applyNo = '';
    $scope.applyType = '';
    if ($location.search()['serviceId']){
        $scope.companyTaskNo = $location.search()['serviceId'];
    }
    if ($location.search()['serviceParameter']) {
        if ($location.search()['serviceParameter'].paramVariables.applyNo) {
            $scope.applyNo = $location.search()['serviceParameter'].paramVariables.applyNo;
        }
        if ($location.search()['serviceParameter'].paramVariables.applyType) {
            $scope.applyType = $location.search()['serviceParameter'].paramVariables.applyType;
        }
    } else {
        $scope.applyNo = $location.search()['applyNo'];
        $scope.applyType = $location.search()['applyType'];
    }

    $http.get('company_basic_change/findApplyCstmPersonByApplyNo?applyNo='+ $scope.applyNo+'&companyTaskNo='+$scope.companyTaskNo).success(function (data) {
        console.log('data', data.data);
        $scope.oldCompanyBasicChangeVo = $.extend(true, {}, data.data.oldCompanyBasicChangeVo);
        $scope.oldCompanyBasicChangeVo.compProvName = AreaUtils.getAreaName($scope.oldCompanyBasicChangeVo.compProv);//经营省份名称
        $scope.oldCompanyBasicChangeVo.compCityName = AreaUtils.getAreaName($scope.oldCompanyBasicChangeVo.compCity);//经营城市名称
        $scope.oldCompanyBasicChangeVo.compCountyName = AreaUtils.getAreaName($scope.oldCompanyBasicChangeVo.compCounty);//经营区县名称
        $scope.oldCompanyBasicChangeVo.invoiceTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.invoiceType,$scope.oldCompanyBasicChangeVo.invoiceType);
        $scope.newCompanyBasicChangeVo = $.extend(true, {}, data.data.newCompanyBasicChangeVo);
        $scope.oldCstmContactList = $scope.oldCompanyBasicChangeVo.cstmContactList;
        $scope.newCompanyBasicChangeVo.applyNo = $scope.applyNo;
        $scope.newCompanyBasicChangeVo.applyType = $scope.applyType;
        console.log($scope.oldCompanyBasicChangeVo);
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
            dataTableData: $scope.oldCstmContactList
        }
        CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
    }

    //新增联系人
    $scope.saveContact = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/apply_input/cstm_contact_append.html'+getCacheTime(),
            controller: 'cstm_contact_append_controller',
            resolve:{
                cstmContactList:function () {
                    return [];
                },
                applyType:function () {
                    return $scope.applyType;
                }
            }
        });
        rtn.result.then(function (data) {
            $scope.cstmContactList.push(data[0]);
            // $scope.cstmContactList=data;
            initSaveTable();
        },function(){
        });
    };
    //联系人列表
    function initSaveTable(){
        /*var tableData = [];
        if($scope.cstmContactList && $scope.cstmContactList.length>0){
            for(var i in $scope.cstmContactList){
                var node =[$scope.cstmContactList[i].name,$scope.cstmContactList[i].relation,$scope.cstmContactList[i].mobileNo,$scope.cstmContactList[i].resideAddr,i];
                tableData.push(node);
            }
        }*/
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
                {title:'联系人地址',data:'resideAddr'},
                {title:'操作',data:'contactNo',
                    render: function (data, type, row, meta) {
                        var html = '<a style="color:#2dc9ff" ng-click="modContact('+'\''+data+'\''+')"></i>编辑</a>'
                            + '&nbsp<a style="color:#2dc9ff" ng-click="delContact('+'\''+data+'\''+')"></i>删除</a>';
                        return html;
                    },
                    fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                        $compile(nTd)($scope);
                    }
                }
            ],
            dataTableData: $scope.cstmContactList
        }

        CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
    }
    // 编辑联系人
    $scope.modContact = function (data) {
        for(var i in $scope.cstmContactList){
            if($scope.cstmContactList[i].contactNo == data){
                var cstmContactList = [];
                cstmContactList[0] = $scope.cstmContactList[i];
                cstmContactList[0].index = i;
                $scope.cstmContactList.splice(i,1);
                //新增联系人
                var rtn = $modal.open({
                    backdrop : 'static',
                    size:'lg',
                    templateUrl: 'tpl/prebiz/apply_input/cstm_contact_append.html'+getCacheTime(),
                    controller: 'cstm_contact_append_controller',
                    resolve:{
                        cstmContactList:function () {
                            return cstmContactList;
                        },
                        applyType:function () {
                            return $scope.applyType;
                        }
                    }
                });
                rtn.result.then(function (data) {
                    $scope.cstmContactList.splice(data[0].index, 0, data[0]);
                    initSaveTable();
                },function(){
                });
            }
        }
    };
    //删除表中联系人
    $scope.delContact = function (data) {
        for(var i in $scope.cstmContactList){
            if($scope.cstmContactList[i].contactNo == data){
                $scope.cstmContactList.splice(i,1);
                initSaveTable();
                break;
            }
        }
    }

    //地址省市县调用
    $scope.changeCountryAddr = function() {
        if ($scope.newCompanyBasicChangeVo.compProv =="") {
            $scope.cityList = {};
            $scope.areaList={};
        } else {
            $scope.cityList=$scope.cityMap;
        }
        $scope.newCompanyBasicChangeVo.compCity="";
        $scope.newCompanyBasicChangeVo.compCounty="";
    }
    $scope.changeCityAddr = function() {

        if ($scope.newCompanyBasicChangeVo.compCity =="") {
            $scope.areaList={};
        } else {
            $scope.areaList=$scope.areaMap;
        }
        $scope.newCompanyBasicChangeVo.compCounty="";

    }

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.newCompanyBasicChangeVo.cstmContactList = $scope.cstmContactList;
            $scope.companyBasicChangePostVo.newCompanyBasicChangeVo = $scope.newCompanyBasicChangeVo;
            $scope.companyBasicChangePostVo.oldCompanyBasicChangeVo = $scope.oldCompanyBasicChangeVo;
            $scope.companyBasicChangePostVo.taskId = $location.search()['taskId']
            if ($location.search()['serviceId']){
                $scope.companyBasicChangePostVo.basicTaskNo = $location.search()['serviceId'];
            }
            $http.post('company_basic_change/saveCompanyBasicChange', $scope.companyBasicChangePostVo).success(function (data) {
                if (data.code == Response.successCode){
                    if ($location.search()['type'] == 'list'){
                        $location.path('app/postbiz_basic_change_list').search({type:'submit', msg:'申请提交成功'});
                    } else {
                        $location.path('app/home');
                    }
                }
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })
        }else{
            $scope.formValidate = true;
            remindMsg($timeout,toaster);
        }
    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        var type = $location.search()['type'];
        if (type == 'list'){
            $location.path('app/postbiz_basic_change_list');
        } else {
            $location.path('app/home');
        }
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.basicChange;
    $scope.wfLogNo = $scope.companyTaskNo;

}]);


