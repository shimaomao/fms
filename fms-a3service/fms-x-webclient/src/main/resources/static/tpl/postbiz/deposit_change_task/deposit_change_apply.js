/**
 * Created by lijunjun on 2018-05-16.
 */
app.controller('deposit_change_apply_controller', ['$scope', '$http','$modal','toaster','$location','$compile', function ($scope, $http,$modal,toaster,$location,$compile) {

    $scope.baseData={};
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.httpData = true;
    $scope.notUpload = false;
    $scope.msgInfo = null;
    $scope.cont_no = $location.search()['cont_no'];
    // 审批页面鹏元征信是否显示
    $scope.zxFlag = false;
    $scope.apply_type = $location.search()['apply_type'];
    $scope.backUrl = '/app/home';
    $scope.depositTaskNo = $location.search()['serviceId'];
    if(isNotNullEmpty($scope.depositTaskNo)){
        $scope.backUrl = '/app/home';
    } else {
        var type = $location.search()['type'];
        if(isNotUndefinedNull(type) && type == 'baisc_change'){
            $scope.backUrl = '/app/postbiz_basic_change_list';
        } else if(isNotUndefinedNull(type) && type == 'vehicle_disposal'){
            $scope.backUrl = '/app/postbiz_vehicle_disposal_list';
        }
    }
    $scope.taskId = $location.search()['taskId'];
    //附件对象
    $scope.bizFilesList= [];
    //担保人信息
    $scope.guaranteePersList = new Array();
    //担保企业信息
    $scope.guaranteeCompList = new Array();

    $scope.getData = function () {
        var url = 'deposit_change_task/findApplyInfoByContNo?';
        if(isNotUndefinedNull($scope.depositTaskNo)){
            url = url + '&depositTaskNo=' + $scope.depositTaskNo;
        } else if (isNotUndefinedNull($scope.cont_no)){
            url = url + 'contNo=' + $scope.cont_no;
        }
        $http.get(url).success(function (data) {
            if(data.code == Response.successCode){
                $scope.baseData = data.data;
                //附件对象
                $scope.bizFilesList=  $scope.baseData.bizFilesList;
                $scope.guaranteePersList = $scope.baseData.guaranteePersList;
                $scope.guaranteeCompList = $scope.baseData.guaranteeCompList;
                $scope.apply_type = $scope.baseData.applyType;
                $scope.applyType = $scope.baseData.applyType;
                initTable();
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };
    $scope.getData();


    /**
     * 担保人部分js
     */
    $scope.$watch('guaranteePersList',function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal)
            $scope.$emit("guaranteePersToFather",$scope.guaranteePersList);
    },true);
    $scope.$watch('guaranteeCompList',function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal)
            $scope.$emit("guaranteeCompToFather",$scope.guaranteeCompList);
    },true);
    $scope.$on('companyToSon',function (e,data) {
        $scope.cstmCompany = data;
    });

    // $scope.guaranteeList = [];
    // $scope.guaranteeList.push($scope.guaranteeCompList);
    // $scope.guaranteeList.push($scope.guaranteePersList);
    function initTable(){
        var tableData = [];
        var node;
        //担保人信息
        if( $scope.guaranteePersList && $scope.guaranteePersList.length!=0) {
            for (var i in $scope.guaranteePersList) {
                if($scope.guaranteePersList[i].applyNo){
                    node = ['个人', $scope.guaranteePersList[i].name, $scope.guaranteePersList[i].relation, $scope.guaranteePersList[i].certifNo, $scope.guaranteePersList[i].certifType,$scope.guaranteePersList[i].guarPersNo];
                }else {
                    node = ['个人', $scope.guaranteePersList[i].name, $scope.guaranteePersList[i].relation, $scope.guaranteePersList[i].certifNo, $scope.guaranteePersList[i].certifType,$scope.guaranteePersList[i].guarPersNo];
                }
                tableData.push(node);
            }
        }
        //担保企业
        if($scope.guaranteeCompList &&  $scope.guaranteeCompList.length!=0){
            for(var i in $scope.guaranteeCompList){
                if($scope.guaranteeCompList[i].applyNo){
                    node = ['企业',$scope.guaranteeCompList[i].name,$scope.guaranteeCompList[i].relation,$scope.guaranteeCompList[i].socialCertifNo,"",$scope.guaranteeCompList[i].guarCompNo];
                }else{
                    node = ['企业',$scope.guaranteeCompList[i].name,$scope.guaranteeCompList[i].relation,$scope.guaranteeCompList[i].socialCertifNo,"",$scope.guaranteeCompList[i].guarCompNo];
                }
                tableData.push(node);
            }
        }
        $scope.dataTableProperties= {
            //table的html id
            dataTableId:'guarantee_info_table',
            dataTableColumn:[
                //{title:'申请编号',class:'center'},
                {title:'担保类型',class:'center'},
                {title:'担保人(企业)名称',class:'center'},
                {title:'担保关系',class:'center',
                    render: function (data, type, row, meta) {
                        if(row[0]=='个人'){
                            if($scope.applyType== 1){
                                return CommonCodeUtils.getCodeValueName('relationPer2',data);
                            }else{
                                return CommonCodeUtils.getCodeValueName('relationPerComp',data);
                            }
                        }else{
                            if($scope.applyType== 1){
                                return CommonCodeUtils.getCodeValueName('relationPerComp',data);
                            }else{
                                return CommonCodeUtils.getCodeValueName('relationComp2',data);
                            }
                        }
                    },
                },
                {title:'证件号码',class:'center'},
                {title:'证件类型',class:'center',
                    render: function (data, type, row, meta) {
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.certifType,data);
                    },
                },{title:'操作',class:'center',
                    render: function (data, type, row, meta) {
                        var html = '';
                        if(data != 1){
                            html = '<a style="color:#2dc9ff" ng-click="delGuaranTee('+'\''+data+'\''+')">删除</a>|<a style="color:#2dc9ff" ng-click="modifyGuaranTee('+'\''+data+'\''+')">编辑</a>';
                        }

                        return html;
                    },
                    fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                        $compile(nTd)($scope);
                    }
                }
            ],
            dataTableData: tableData
        }

        CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);

    }
    //担保人信息修改
    $scope.modifyGuaranTee = function (data) {
        for(var i in $scope.guaranteePersList){
            if($scope.guaranteePersList[i].guarPersNo ==data){
                var rtn = $modal.open({
                    backdrop : 'static',
                    size:'lg',
                    templateUrl: 'tpl/prebiz/apply_input/guarantee_pers_modify.html'+getCacheTime(),
                    controller: 'guarantee_pers_modify_controller',
                    resolve:{
                        guaranteePersList:function () {
                            return $scope.guaranteePersList;
                        },
                        applyType: function () {
                            return $scope.applyType;
                        },
                        guaranteePers: function () {
                            return $scope.guaranteePersList[i] ;
                        }
                    }
                });
                rtn.result.then(function (data) {
                    $scope.guaranteePersList = data;
                    initTable();
                },function(){
                });
            }
        }
        for(var i in $scope.guaranteeCompList){
            if($scope.guaranteeCompList[i].guarCompNo ==data){
                var rtn = $modal.open({
                    backdrop : 'static',
                    size:'lg',
                    templateUrl: 'tpl/prebiz/apply_input/guarantee_comp_modify.html'+getCacheTime(),
                    controller: 'guarantee_comp_modify_controller',
                    resolve:{
                        guaranteeCompList:function () {
                            return $scope.guaranteeCompList;
                        },
                        applyType: function () {
                            return $scope.applyType;
                        },
                        guaranteeComp:function () {
                            return $scope.guaranteeCompList[i];
                        }
                    }
                });
                rtn.result.then(function (data) {
                    $scope.guaranteeCompList = data;
                    initTable();
                },function(){
                });
            }
        }
    }
    //删除联系人
    $scope.delGuaranTee = function (data) {
        for(var i in $scope.guaranteePersList){
            if($scope.guaranteePersList[i].guarPersNo ==data){
                var mateCertifNo = $scope.guaranteePersList[i].mateCertifNo;
                $scope.guaranteePersList.splice(i,1);

                for(var i in $scope.guaranteePersList){
                    if($scope.guaranteePersList[i].certifNo == mateCertifNo){
                        $scope.guaranteePersList.splice(i,1);
                        break;
                    }
                }
                initTable();
                return;
            }
        }

        for(var i in $scope.guaranteeCompList){
            if($scope.guaranteeCompList[i].guarCompNo ==data){
                $scope.guaranteeCompList.splice(i,1)
                initTable();
                return;
            }
        }
    };

    //担保人个人信息
    $scope.saveGuaranteePers = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/apply_input/guarantee_pers_save.html'+getCacheTime(),
            controller: 'guarantee_pers_save_controller',
            resolve:{
                guaranteePersList:function () {
                    return $scope.guaranteePersList;
                },
                applyType: function () {
                    return $scope.applyType;
                },
                cstmCompany: function () {
                    return $scope.cstmCompany;
                }
            }
        });
        rtn.result.then(function (data) {
            $scope.guaranteePersList = data;
            initTable();
        },function(){
        });

    }
    //担保企业信息
    $scope.saveGuaranteeComp = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/apply_input/guarantee_comp_save.html'+getCacheTime(),
            controller: 'guarantee_comp_save_controller',
            resolve:{
                guaranteeCompList:function () {
                    return $scope.guaranteeCompList;
                },
                applyType: function () {
                    return $scope.applyType;
                }
            }
        });
        rtn.result.then(function (data) {
            $scope.guaranteeCompList = data;
            initTable();
        },function(){
        });
    }

    //保存
    $scope.save = function () {
        if(!$scope.form.$invalid) {
            if(CommonArrayUtils.isNullOrLengthZero($scope.guaranteePersList)
                && CommonArrayUtils.isNullOrLengthZero($scope.guaranteeCompList)
                && $scope.baseData.supplementDeposit <= 0){
                modalAlert($modal,"增加保证金和增加担保信息必须要填写一个！");
                return;
            }
            $scope.submit = true;
            $scope.baseData.depositTaskNo = $scope.depositTaskNo;
            $scope.baseData.taskId = $scope.taskId;
            $scope.baseData.bizFilesList = $scope.bizFilesList;
            $scope.baseData.guaranteePersList = $scope.guaranteePersList;
            $scope.baseData.guaranteeCompList =  $scope.guaranteeCompList
            $http.post('deposit_change_task/saveDepositChange', $scope.baseData).success(function (data) {
                if (data.code == Response.successCode){
                    if(isNotNullEmpty($scope.depositTaskNo))
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'申请成功'});
                    else
                        $location.path("/app/postbiz_basic_change_list").search({type:'homeToastInfo', msg:'申请成功'});
                }
                else{
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            if($scope.form.$invalid){
                toaster_info(promptInfo.submitWarn,toaster);
            }else{
                toaster_info($scope.msgInfo,toaster);
            }
            $scope.formValidate = true;
        }
    };

    //查看逾期详情
    $scope.overdue = function () {
        //取得逾期客户id
        $http.get('deposit_change_task/findOverdueCstmId?certifNo='+$scope.baseData.certifNo).success(function (data) {
            if(data.code == Response.successCode){
                var overdueCstmId = data.data;
                if(CommonStringUtils.isTrimBlank(overdueCstmId)){
                    modalAlert($modal,'该客户未发生过逾期');
                } else {
                    var id = overdueCstmId;
                    var url = 'app.postbiz_overdue_cstm_modify?overdueCstmId=' + overdueCstmId
                        + '&detail=true&isTab=true';
                    var title = '逾期详情';
                    var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
                    if(window.parent.addTab){
                        window.parent.addTab(html);
                    }
                }
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };

    //取消
    $scope.goBack = function () {
        $location.path($scope.backUrl);
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.depositChange;
    $scope.wfLogNo = $scope.depositTaskNo;
}]);

