/**
 * Created by qiaomengnan on 2018-05-17.
 */
app.controller('rule_condition_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'rule_condition/findRuleConditionByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'rule_condition_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('ruleCondId'),
            defaultDetail('ruleId','detailRuleCondition','规则ID','20%',$compile,$scope),
            {title:'规则序号',data:'ruleNo',width:'20%'},
            {title:'条件项目key',data:'condItemKey',width:'20%'},
            {title:'条件匹配逻辑',data:'condLogicType',width:'20%'},
            {title:'条件项目值1',data:'condLogicValue1',width:'20%'},
            {title:'条件项目值2',data:'condLogicValue2',width:'20%'},
            {title:'排序',data:'orderNo',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.ruleId = $scope.ruleId;
        params.ruleNo = $scope.ruleNo;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchRuleCondition = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetRuleCondition = function(){
        $scope.ruleId = "";
        $scope.ruleNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveRuleCondition = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/rule_condition/rule_condition_save.html'+getCacheTime(),
            controller: 'rule_condition_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加baseinfo信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifyRuleCondition = function(ruleCondId){
        var rowsIds =  $scope.dataTable.getRowsIds('ruleCondId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/baseinfo/rule_condition/rule_condition_modify.html'+getCacheTime(),
                controller: 'rule_condition_modify_controller',
                resolve:{
                    ruleCondId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑baseinfo信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    $scope.detailRuleCondition = function(ruleCondId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/rule_condition/rule_condition_detail.html'+getCacheTime(),
            controller: 'rule_condition_detail_controller',
            resolve:{
                ruleCondition : function (){ return $scope.dataTable.getRow(ruleCondId,'ruleCondId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteRuleCondition = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('ruleCondId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('rule_condition/deleteRuleConditionByRuleCondIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除baseinfo信息成功', toaster);
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