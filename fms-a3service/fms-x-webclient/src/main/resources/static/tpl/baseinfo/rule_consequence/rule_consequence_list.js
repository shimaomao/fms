/**
 * Created by qiaomengnan on 2018-05-17.
 */
app.controller('rule_consequence_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'rule_consequence/findRuleConsequenceByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'rule_consequence_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('ruleConseqId'),
            defaultDetail('ruleId','detailRuleConsequence','规则ID','20%',$compile,$scope),
            {title:'规则序号',data:'ruleNo',width:'20%'},
            {title:'结果项目key',data:'conseqItemKey',width:'20%'},
            {title:'结果匹配逻辑',data:'conseqLogicType',width:'20%'},
            {title:'结果项目值1',data:'conseqLogicValue1',width:'20%'},
            {title:'结果项目值2',data:'conseqLogicValue2',width:'20%'},
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


    $scope.searchRuleConsequence = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetRuleConsequence = function(){
        $scope.ruleId = "";
        $scope.ruleNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveRuleConsequence = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/rule_consequence/rule_consequence_save.html'+getCacheTime(),
            controller: 'rule_consequence_save_controller',
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

    $scope.modifyRuleConsequence = function(ruleConseqId){
        var rowsIds =  $scope.dataTable.getRowsIds('ruleConseqId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/baseinfo/rule_consequence/rule_consequence_modify.html'+getCacheTime(),
                controller: 'rule_consequence_modify_controller',
                resolve:{
                    ruleConseqId : function (){ return rowsIds[0] }
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


    $scope.detailRuleConsequence = function(ruleConseqId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/rule_consequence/rule_consequence_detail.html'+getCacheTime(),
            controller: 'rule_consequence_detail_controller',
            resolve:{
                ruleConsequence : function (){ return $scope.dataTable.getRow(ruleConseqId,'ruleConseqId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteRuleConsequence = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('ruleConseqId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('rule_consequence/deleteRuleConsequenceByRuleConseqIds',getDeleteData(rowsIds)).success(function (data) {
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