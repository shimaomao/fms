/**
 * Created by ningyangyang on 2018/3/30.
 */
app.controller('guarantee_info_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location',function ($scope, $http, $modal, toaster,$compile,$location) {


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
    //担保人信息
    $scope.guaranteePersList =$scope.$parent.guaranteePersList;
    //担保企业信息
    $scope.guaranteeCompList = $scope.$parent.guaranteeCompList;
    $scope.applyNo = $scope.$parent.applyNo;
    $scope.applyType = $scope.$parent.applyType;
    if($scope.applyNo){
        $http.get('apply_input/findApplyGuaranteeByApplyNo?applyNo='+ $scope.applyNo).success(function (data) {
            $scope.applyInputVo = data.data;
            $scope.guaranteePersList = $scope.applyInputVo.guaranteePersList;
            $scope.guaranteeCompList = $scope.applyInputVo.guaranteeCompList;
            initTable();
        });
    }


    // $scope.guaranteeList = [];
    // $scope.guaranteeList.push($scope.guaranteeCompList);
    // $scope.guaranteeList.push($scope.guaranteePersList);
    initTable();
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
                        html = '<a style="color:#2dc9ff" ng-click="delGuaranTee('+'\''+data+'\''+')">删除</a>|<a style="color:#2dc9ff" ng-click="modifyGuaranTee('+'\''+data+'\''+')">编辑</a>';

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
               $scope.guaranteePersList.splice(i,1);
               /*var mateCertifNo = $scope.guaranteePersList[i].mateCertifNo;
               $scope.guaranteePersList.splice(i,1);

               for(var i in $scope.guaranteePersList){
                   if($scope.guaranteePersList[i].certifNo == mateCertifNo){
                       $scope.guaranteePersList.splice(i,1);
                       break;
                   }
               }*/
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
}])
;