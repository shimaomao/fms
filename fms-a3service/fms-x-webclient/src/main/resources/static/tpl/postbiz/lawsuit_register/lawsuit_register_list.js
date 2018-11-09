/**
 * Created by lijunjun on 2018-09-12.
 */
app.controller('lawsuit_register_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'lawsuit_register/findLawsuitRegistersByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'lawsuit_register_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('lawsuitRegisterId'),
            defaultDetail('lawsuitTaskNo','detailLawsuitRegister','诉讼任务号','20%',$compile,$scope),
            {title:'受理法院',data:'court',width:'20%'},
            {title:'立案案号',data:'caseRecordNo',width:'20%'},
            {title:'案件状态',data:'caseStatus',width:'20%'},
            {title:'案件时间',data:'caseDate',width:'20%'},
            {title:'承办法官',data:'judge',width:'20%'},
            {title:'承办法官联系方式',data:'judgeContactNo',width:'20%'},
            {title:'案件说明',data:'caseIntroduce',width:'20%'},
            {title:'诉讼金额',data:'lawsuitAmount',width:'20%'},
            {title:'判决金额',data:'judgmentAmount',width:'20%'},
            {title:'执行案号',data:'executeCaseNo',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.lawsuitTaskNo = $scope.lawsuitTaskNo;
        params.court = $scope.court;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchLawsuitRegister = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetLawsuitRegister = function(){
        $scope.lawsuitTaskNo = "";
        $scope.court = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveLawsuitRegister = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/lawsuit_register/lawsuit_register_save.html'+getCacheTime(),
            controller: 'lawsuit_register_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加postbiz信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifyLawsuitRegister = function(lawsuitRegisterId){
        var rowsIds =  $scope.dataTable.getRowsIds('lawsuitRegisterId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/postbiz/lawsuit_register/lawsuit_register_modify.html'+getCacheTime(),
                controller: 'lawsuit_register_modify_controller',
                resolve:{
                    lawsuitRegisterId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑postbiz信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    $scope.detailLawsuitRegister = function(lawsuitRegisterId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/lawsuit_register/lawsuit_register_detail.html'+getCacheTime(),
            controller: 'lawsuit_register_detail_controller',
            resolve:{
                lawsuitRegister : function (){ return $scope.dataTable.getRow(lawsuitRegisterId,'lawsuitRegisterId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteLawsuitRegister = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('lawsuitRegisterId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('lawsuit_register/deleteLawsuitRegistersByLawsuitRegisterIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除postbiz信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

}])
;