/**
 * Created by qiaomengnan on 2018-05-17.
 */
app.controller('rule_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile' ,'$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {

    //添加，修改成功提示信息
    $scope.timer = $timeout(function () {
        $scope.messageType=$location.search()['messageType'];
        if($scope.messageType == 'saveRule'){
            toaster_success('添加规则引擎成功',toaster);
        }else if($scope.messageType=='modifyRule'){
            toaster_success('编辑规则引擎成功',toaster);
        }
    }, 5);


    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'rule/findRulesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'rule_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('ruleId'),
            defaultDetail('ruleName','detailRule','规则名称','20%',$compile,$scope,'ruleId'),
            {title:'规则key',data:'ruleKey',width:'20%'},
            {title:'规则类型',data:'ruleType',width:'20%',render: function (data, type, row, meta) {  return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.ruleType,data);}},

        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.ruleType = $scope.ruleType;
        params.ruleKey = $scope.ruleKey;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchRule = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetRule = function(){
        $scope.ruleType = "";
        $scope.ruleKey = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveRule = function(){
        $location.path('/app/baseinfo_rule_save');
    }

    $scope.modifyRule = function(ruleId){
        var rowsIds =  $scope.dataTable.getRowsIds('ruleId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据');
        else{

            $location.path('/app/baseinfo_rule_modify').search({
                ruleId:   rowsIds[0]
            });
        }

    }


    $scope.detailRule = function(ruleId){
        if(CommonObjectUtils.isNotExist(ruleId))
            modalAlert($modal,'请您选择需要查看的数据');
        else{
            $location.path('/app/baseinfo_rule_detail').search({
                ruleId:   ruleId
            });
        }
    }

    $scope.deleteRule = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('ruleId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('rule/deleteRulesByRuleIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除规则引擎成功', toaster);
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