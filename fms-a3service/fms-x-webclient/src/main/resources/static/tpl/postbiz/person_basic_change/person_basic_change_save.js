/**
 * Created by lijunjun on 2018-08-31.
 */
app.controller('person_basic_change_save_controller', ['$scope', '$http','$modal','toaster','$location','$compile','$timeout', function ($scope, $http,$modal,toaster,$location,$compile,$timeout) {

    $scope.cstmPersAddr = {};
    $scope.personBasicChangePostVo = {};
    $scope.oldPersonBasicChangeVo = {};
    $scope.newPersonBasicChangeVo = {};
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

    $scope.personTaskNo = '';
    $scope.applyNo = '';
    $scope.applyType = '';
    if ($location.search()['serviceId']){
        $scope.personTaskNo = $location.search()['serviceId'];
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

    $http.get('person_basic_change/findApplyCstmPersonByApplyNo?applyNo='+ $scope.applyNo+'&personTaskNo='+$scope.personTaskNo).success(function (data) {
        console.log('data', data.data);
        $scope.oldPersonBasicChangeVo = $.extend(true, {}, data.data.oldPersonBasicChangeVo);
        $scope.oldPersonBasicChangeVo.resideProvName = AreaUtils.getAreaName($scope.oldPersonBasicChangeVo.resideProv);
        $scope.oldPersonBasicChangeVo.resideCityName = AreaUtils.getAreaName($scope.oldPersonBasicChangeVo.resideCity);
        $scope.oldPersonBasicChangeVo.resideCountyName = AreaUtils.getAreaName($scope.oldPersonBasicChangeVo.resideCounty);
        $scope.newPersonBasicChangeVo = $.extend(true, {}, data.data.newPersonBasicChangeVo);
        $scope.oldCstmContactList = $scope.oldPersonBasicChangeVo.cstmContactList;
        if ($scope.newPersonBasicChangeVo && $scope.newPersonBasicChangeVo.cstmContactList){
            $scope.cstmContactList = $scope.newPersonBasicChangeVo.cstmContactList;
        }
        $scope.newPersonBasicChangeVo.applyNo = $scope.applyNo;
        $scope.newPersonBasicChangeVo.applyType = $scope.applyType;
        console.log($scope.oldPersonBasicChangeVo);
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
                        if($scope.applyType==1){
                            return CommonCodeUtils.getCodeValueName('relationPer2',data);
                        }else{
                            return CommonCodeUtils.getCodeValueName('relationPerComp',data);
                        }
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
            /*if(i == data){
                $scope.cstmContactList.splice(i,1);
                initSaveTable();
                break;
            }*/
        }
    }

    //地址省市县调用
    $scope.changeCountryAddr = function() {
        if ($scope.newPersonBasicChangeVo.resideProv =="") {
            $scope.cityList = {};
            $scope.areaList={};
        } else {
            $scope.cityList=$scope.cityMap;
        }
        $scope.newPersonBasicChangeVo.resideCity="";
        $scope.newPersonBasicChangeVo.resideCounty="";
    }
    $scope.changeCityAddr = function() {

        if ($scope.newPersonBasicChangeVo.resideCity =="") {
            $scope.areaList={};
        } else {
            $scope.areaList=$scope.areaMap;
        }
        $scope.newPersonBasicChangeVo.resideCounty="";
    }

    /**
     * 个人基本信息变更提交
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.newPersonBasicChangeVo.cstmContactList = $scope.cstmContactList;
            $scope.personBasicChangePostVo.newPersonBasicChangeVo = $scope.newPersonBasicChangeVo;
            $scope.personBasicChangePostVo.oldPersonBasicChangeVo = $scope.oldPersonBasicChangeVo;
            $scope.personBasicChangePostVo.personTaskNo = $scope.personTaskNo;
            $scope.personBasicChangePostVo.taskId = $location.search()['taskId']?$location.search()['taskId']:'';
            $http.post('person_basic_change/savePersonBasicChange', $scope.personBasicChangePostVo).success(function (data) {
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
    $scope.wfLogNo = $scope.personTaskNo;

}]);


