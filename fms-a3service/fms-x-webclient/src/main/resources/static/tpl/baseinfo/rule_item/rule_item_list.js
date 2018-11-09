/**
 * Created by qiaomengnan on 2018-05-17.
 */
app.controller('rule_item_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {

    //添加，修改成功提示信息
    $scope.timer = $timeout(function () {
        $scope.messageType=$location.search()['messageType'];
        if($scope.messageType == 'saveRuleItem'){
            toaster_success('添加规则引擎项目成功',toaster);
        }else if($scope.messageType=='modifyRuleItem'){
            toaster_success('编辑规则引擎项目成功',toaster);
        }
    }, 5);



    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'rule_item/findRuleItemsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'rule_item_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('ruleItemId'),
            defaultDetail('ruleItemName','detailRuleItem','规则项目名称','20%',$compile,$scope,'ruleItemId'),
            {title:'规则项目key',data:'ruleItemKey',width:'20%'},
            {title:'规则类型',data:'ruleType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.ruleType,data);
                }},
            {title:'项目属性',data:'itemType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.ruleItemType,data);
                }},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.ruleType = $scope.ruleType;
        params.ruleItemKey = $scope.ruleItemKey;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchRuleItem = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetRuleItem = function(){
        $scope.ruleType = "";
        $scope.ruleItemKey = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveRuleItem = function(){
        $location.path('/app/baseinfo_rule_item_save');
    }

    $scope.modifyRuleItem = function(ruleItemId){
        var rowsIds =  $scope.dataTable.getRowsIds('ruleItemId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据');
        else{
            $location.path('/app/baseinfo_rule_item_modify').search({
                ruleItemId:   rowsIds[0]
            });
        }
    }

    $scope.detailRuleItem = function(ruleItemId){
        var rows =  $scope.dataTable.getRows();
        if(rows.length < 1)
            modalAlert($modal,'请您选择需要查看的数据');
        else if(rows.length > 1)
            modalAlert($modal,'只能同时查看一条数据');
        else{
            $location.path('/app/baseinfo_rule_item_detail').search({
                ruleItem: rows[0]
            });
        }
    }

    $scope.deleteRuleItem = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('ruleItemId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('rule_item/deleteRuleItemsByRuleItemIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除规则项目信息成功', toaster);
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