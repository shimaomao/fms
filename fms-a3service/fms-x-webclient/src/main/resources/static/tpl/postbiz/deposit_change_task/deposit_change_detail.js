/**
 * Created by lijunjun on 2018-05-16.
 */
app.controller('deposit_change_detail_controller', ['$scope', '$http','$modal','toaster','$location','$compile', function ($scope, $http,$modal,toaster,$location,$compile) {

    $scope.baseData={};
    $scope.httpData = true;
    $scope.msgInfo = null;
    $scope.cont_no = $location.search()['cont_no'];
        $scope.apply_type = $location.search()['apply_type'];
    $scope.depositTaskNo = $location.search()['serviceId'];
    if(CommonStringUtils.isTrimBlank($scope.depositTaskNo)){
        $scope.depositTaskNo = $scope.$parent.depositTaskNo;
    }
    $scope.flag = $location.search()['flag'];
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

    // 返回
    $scope.goBack = function () {
        $location.path('/app/postbiz_basic_change_task_list');
    };

    // $scope.guaranteeList = [];
    // $scope.guaranteeList.push($scope.guaranteeCompList);
    // $scope.guaranteeList.push($scope.guaranteePersList);
    function initTable(){
        var tableData = [];
        //担保人信息
        for(var i in $scope.guaranteePersList){
            var node = [$scope.guaranteePersList[i].applyNo,'个人',$scope.guaranteePersList[i].name,$scope.guaranteePersList[i].relation,$scope.guaranteePersList[i].certifNo,$scope.guaranteePersList[i].certifType,$scope.guaranteePersList[i].guarPersNo];
            tableData.push(node);
        }

        //担保企业
        for(var i in $scope.guaranteeCompList){
            var node = [$scope.guaranteeCompList[i].applyNo,'企业',$scope.guaranteeCompList[i].name,$scope.guaranteeCompList[i].relation,$scope.guaranteeCompList[i].socialCertifNo,"",$scope.guaranteeCompList[i].guarCompNo];
            tableData.push(node);
        }
        $scope.dataTableProperties= {
            //table的html id
            dataTableId:'guarantee_info_table',
            dataTableColumn:[
                {title:'申请编号',class:'center'},
                {title:'担保类型',class:'center'},
                {title:'担保人(企业)名称',class:'center'},
                {title:'担保关系',class:'center',
                    render: function (data, type, row, meta) {
                        if(row[1]=='个人'){
                            if($scope.applyType==1){
                                return CommonCodeUtils.getCodeValueName('relationPer2',data);
                            }else{
                                return CommonCodeUtils.getCodeValueName('relationPerComp',data);
                            }
                        }else{
                            if($scope.applyType==1){
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
                },
                {title:'操作',
                    render: function (data, type, row, meta) {
                        var html = '<a style="color:#2dc9ff" ng-click="detailGuaranTee('+'\''+data+'\''+')">详情</a>';
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
    $scope.detailGuaranTee = function (data) {
        for(var i in $scope.guaranteePersList){
            if($scope.guaranteePersList[i].guarPersNo ==data){
                var rtn = $modal.open({
                    backdrop : 'static',
                    size:'lg',
                    templateUrl: 'tpl/prebiz/apply_input/guarantee_pers_detail.html'+getCacheTime(),
                    controller: 'guarantee_pers_detail_controller',
                    resolve:{
                        guaranteePers: function () {
                            return $scope.guaranteePersList[i] ;
                        },
                        applyType: function () {
                            return $scope.applyType;
                        }
                    }
                });
                rtn.result.then(function () {
                },function(){
                });
            }
        }
        for(var i in $scope.guaranteeCompList){
            if($scope.guaranteeCompList[i].guarCompNo ==data){
                var rtn = $modal.open({
                    backdrop : 'static',
                    size:'lg',
                    templateUrl: 'tpl/prebiz/apply_input/guarantee_comp_detail.html'+getCacheTime(),
                    controller: 'guarantee_comp_detail_controller',
                    resolve:{
                        guaranteeComp:function () {
                            return $scope.guaranteeCompList[i];
                        },
                        applyType: function () {
                            return $scope.applyType;
                        }
                    }
                });
                rtn.result.then(function () {
                },function(){
                });
            }
        }
    }

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
}]);

