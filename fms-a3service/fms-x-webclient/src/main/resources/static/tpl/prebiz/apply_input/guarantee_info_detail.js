/**
 * Created by ningyangyang on 2018/4/9.
 */
app.controller('guarantee_info_detail_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location',function ($scope, $http, $modal, toaster,$compile,$location) {
    $scope.applyNo = $scope.$parent.applyNo;
    $scope.applyType = $scope.$parent.applyType;
    $http.get('apply_input/findApplyGuaranteeByApplyNo?applyNo='+ $scope.applyNo).success(function (data) {
        $scope.applyInputVo = data.data;
        //担保人信息
        $scope.guaranteePersList = $scope.applyInputVo.guaranteePersList;
        //担保企业信息
        $scope.guaranteeCompList =  $scope.applyInputVo.guaranteeCompList;
        initTable();
    });

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
}])
;