/**
 * Created by qiaomengnan on 2018-05-17.
 */

//自定义repeat完成指令
app.directive('repeatFinish',function($timeout){
    return {
        restrict: 'A',
        link: function(scope,elem,attr){
            //当前循环至最后一个
            if (scope.$last === true) {

                $timeout(function () {
                    //向父控制器传递事件消息
                    scope.$emit('repeatFinishCallback');
                },100);

            }
        }
    }
});

app.controller('rule_save_controller', ['$scope', '$http','$modal','toaster','$compile','$location', function ($scope, $http,$modal,toaster,$compile,$location) {

    $scope.rule={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.ruleTypes = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.ruleType);

    /**
     * 新增规则
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            var priorityMap = {};
            var isContinue = true;
            $("input[name='priority']").each(function(i){
                if(CommonStringUtils.isNotTrimBlank(priorityMap[$(this).val()])){
                    modalAlert($modal,"规则条件"+(i+1)+"的结果优先级和规则条件"+(priorityMap[$(this).val()]+1)+"的有重复,请检查");
                    isContinue = false;
                    return;
                }
                if(CommonStringUtils.isTrimBlank($(this).val())){
                    modalAlert($modal,"请输入规则条件"+(i+1)+"的结果优先级");
                    isContinue = false;
                    return;
                }else{
                    priorityMap[$(this).val()] = i;
                    $scope.ruleTableList[$(this).attr("data-priority-index")]['priority'] = $(this).val();

                }
            });

            if(isContinue) {
                var noRuleConditionTableDataNum = 0;

                for (var i in $scope.ruleTableList) {
                    if ($scope.ruleTableList[i]['ruleConsequenceTableData'].length == 0) {
                        modalAlert($modal, "请录入规则条件" + (parseInt(i) + 1) + "的结果信息");
                        isContinue = false;
                        break;
                    }

                    if ($scope.ruleTableList[i]['ruleConditionTableData'].length == 0) {
                        noRuleConditionTableDataNum++;
                        if (noRuleConditionTableDataNum > 1) {
                            modalAlert($modal, "默认规则结果只能有一个,请录入规则条件" + (parseInt(i) + 1) + "的条件信息");
                            isContinue = false;
                            break;
                        }
                    }

                }
            }

            if(isContinue){
                $scope.rule.ruleDetailVos = $scope.ruleTableList;

                $http.post('rule/saveRule', $scope.rule).success(function (data) {
                    if (data.code == Response.successCode) {
                        $location.path("app/baseinfo_rule").search({messageType:'saveRule'});
                    }
                    else
                        modalAlert($modal,data.message);
                    $scope.submit = false;
                }).error(function(data){
                    modalAlert($modal,data);
                    $scope.submit = false;
                })
            }else{
                $scope.submit = false;
            }




        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }


    }



    $scope.addRuleCondition = function(index){

        if(CommonObjectUtils.isNotExist($scope.rule.ruleType)){
            modalAlert($modal,"请选择规则类型");
        }else{
            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/baseinfo/rule/rule_condition_save.html'+getCacheTime(),
                controller: 'rule_condition_save_controller',
                resolve:{
                    ruleType : function(){
                        return $scope.rule.ruleType;
                    }
                }
            });
            rtn.result.then(function (data) {
                if(CommonObjectUtils.isExist(data)) {
                    data.ruleCondId = getTimestamp();
                    $scope.ruleTableList[index]['ruleConditionTableData'].push(data);
                    initRuleConditionDataTable($scope.ruleTableList[index]['ruleConditionTableName'],$scope.ruleTableList[index]['ruleConditionTableData'],index);
                }
            },function(){
            });
        }
    }


    $scope.modifyRuleCondition = function(index,ruleCondId){

        if(CommonObjectUtils.isNotExist($scope.rule.ruleType)){
            modalAlert($modal,"请选择规则类型");
        }else{
            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/baseinfo/rule/rule_condition_modify.html'+getCacheTime(),
                controller: 'rule_condition_modify_controller',
                resolve:{
                    ruleType : function(){
                        return $scope.rule.ruleType;
                    },
                    ruleCondition: function(){
                        for(var i in $scope.ruleTableList[index]['ruleConditionTableData']){
                            if($scope.ruleTableList[index]['ruleConditionTableData'][i]['ruleCondId'] == ruleCondId){
                                return $scope.ruleTableList[index]['ruleConditionTableData'][i];
                            }
                        }
                        return null;
                    }

                }
            });
            rtn.result.then(function (data) {
                if(CommonObjectUtils.isExist(data)) {
                    for(var i in $scope.ruleTableList[index]['ruleConditionTableData']){
                        if($scope.ruleTableList[index]['ruleConditionTableData'][i]['ruleCondId'] == data.ruleCondId){
                            $scope.ruleTableList[index]['ruleConditionTableData'][i] = data;
                            break;
                        }
                    }
                    initRuleConditionDataTable($scope.ruleTableList[index]['ruleConditionTableName'],$scope.ruleTableList[index]['ruleConditionTableData'],index);
                }
            },function(){
            });
        }
    }


    function initRuleConditionDataTable(tableId,tableData,tableIndex){
        //参数配置
        $scope.ruleConditionDataTableProperties= {
            //table的html id
            dataTableId:tableId,
            dataTableData: tableData,
            //table的列
            dataTableColumn: [
                {title:'条件',data:'condItemKeyName',width:'25%'},
                {title:'逻辑',data:'condLogicType',width:'25%', render: function (data, type, row, meta) {  return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.logicType,data);}},
                {title:'条件值1',data:'condLogicValue1',width:'25%'},
                {title:'条件值2',data:'condLogicValue2',width:'25%'},
                {title:'操作',data:'ruleCondId',
                    render: function (data, type, row, meta) {
                        var html = '<a class="a1" ng-click="delRuleConditionTableData('+tableIndex+','+'\''+data+'\''+')"></i>删除</a>';
                        html += '&nbsp;<a class="a1" ng-click="modifyRuleCondition('+tableIndex+','+'\''+data+'\''+')"></i>编辑</a>';
                        return html;
                    },
                    fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                        $compile(nTd)($scope);
                    }
                }
            ]
        }
        CommonDataTableUtils.createDataTableForData($scope.ruleConditionDataTableProperties);
    }


    function initRuleConsequenceDataTable(tableId,tableData,tableIndex){
        //参数配置
        $scope.ruleConsequenceDataTableProperties= {
            //table的html id
            dataTableId:tableId,
            dataTableData: tableData,
            //table的列
            dataTableColumn: [
                {title:'结果',data:'conseqItemKeyName',width:'25%'},
                {title:'逻辑',data:'conseqLogicType',width:'25%', render: function (data, type, row, meta) {  return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.logicType,data);}},
                {title:'结果值1',data:'conseqLogicValue1',width:'25%'},
                {title:'结果值2',data:'conseqLogicValue2',width:'25%'},
                {title:'操作',data:'ruleConseqId',
                    render: function (data, type, row, meta) {
                        var html = '<a class="a1" ng-click="delRuleConsequenceTableData('+tableIndex+','+'\''+data+'\''+')"></i>删除</a>';
                        html += '&nbsp;<a class="a1" ng-click="modifyRuleConsequence('+tableIndex+','+'\''+data+'\''+')"></i>编辑</a>';
                        return html;
                    },
                    fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                        $compile(nTd)($scope);
                    }
                }
            ]
        }

        CommonDataTableUtils.createDataTableForData($scope.ruleConsequenceDataTableProperties);
    }

    $scope.addRuleConsequence = function(index){
        if(CommonObjectUtils.isNotExist($scope.rule.ruleType)){
            modalAlert($modal,"请选择规则类型");
        }else{
            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/baseinfo/rule/rule_consequence_save.html'+getCacheTime(),
                controller: 'rule_consequence_save_controller',
                resolve:{
                    ruleType : function(){
                        return $scope.rule.ruleType;
                    }
                }
            });
            rtn.result.then(function (data) {
                if(CommonObjectUtils.isExist(data)) {
                    data.ruleConseqId = getTimestamp();
                    $scope.ruleTableList[index]['ruleConsequenceTableData'].push(data);
                    initRuleConsequenceDataTable($scope.ruleTableList[index]['ruleConsequenceTableName'],$scope.ruleTableList[index]['ruleConsequenceTableData'],index);
                }
            },function(){
            });
        }
    }

    $scope.modifyRuleConsequence = function(index,ruleConseqId){

        if(CommonObjectUtils.isNotExist($scope.rule.ruleType)){
            modalAlert($modal,"请选择规则类型");
        }else{
            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/baseinfo/rule/rule_consequence_modify.html'+getCacheTime(),
                controller: 'rule_consequence_modify_controller',
                resolve:{
                    ruleType : function(){
                        return $scope.rule.ruleType;
                    },
                    ruleConsequence: function(){
                        for(var i in $scope.ruleTableList[index]['ruleConsequenceTableData']){
                            if($scope.ruleTableList[index]['ruleConsequenceTableData'][i]['ruleConseqId'] == ruleConseqId){
                               return $scope.ruleTableList[index]['ruleConsequenceTableData'][i] ;
                            }
                        }
                        return null;
                    }
                }
            });
            rtn.result.then(function (data) {
                if(CommonObjectUtils.isExist(data)) {
                    for(var i in $scope.ruleTableList[index]['ruleConsequenceTableData']){
                        if($scope.ruleTableList[index]['ruleConsequenceTableData'][i]['ruleConseqId'] == data.ruleConseqId){
                            $scope.ruleTableList[index]['ruleConsequenceTableData'][i] = data;
                            break;
                        }
                    }
                    initRuleConsequenceDataTable($scope.ruleTableList[index]['ruleConsequenceTableName'],$scope.ruleTableList[index]['ruleConsequenceTableData'],index);
                }
            },function(){
            });
        }
    }








    $scope.ruleTableList = [
            {index:0,ruleConditionTableName:'ruleCondition_0',ruleConditionTableData:[],ruleConsequenceTableName:'ruleConsequence_0',ruleConsequenceTableData:[]}
        ];

    $scope.addRuleTab = function(){
        var index = $scope.ruleTableList[$scope.ruleTableList.length - 1]['index'] + 1;
        var tab = {index:index,ruleConditionTableName:'ruleCondition_'+index,ruleConditionTableData:[],ruleConsequenceTableName:'ruleConsequence_'+index,ruleConsequenceTableData:[]};
        $scope.ruleTableList.push(tab);

    }

    $scope.delRuleTab = function(){
        var index = $("a[class='selectTab']").attr('data');
        if(index != 0) {
            var tmpList = [];
            for (var i in $scope.ruleTableList) {
                if ($scope.ruleTableList[i]['index'] != index)
                    tmpList.push($scope.ruleTableList[i]);

            }
            $scope.ruleTableList = tmpList;
            $scope.openRuleInfo(index - 1);
        }
    }

    $scope.delRuleConditionTableData = function(tableIndex,ruleCondId){

        for(var i in $scope.ruleTableList){
            if($scope.ruleTableList[i]['index'] == tableIndex){
                var tmpData = [];
                for(var j in $scope.ruleTableList[i]['ruleConditionTableData']){
                    if($scope.ruleTableList[i]['ruleConditionTableData'][j]['ruleCondId'] != ruleCondId)
                        tmpData.push($scope.ruleTableList[i]['ruleConditionTableData'][j]);
                }
                $scope.ruleTableList[i]['ruleConditionTableData'] = tmpData;
                initRuleConditionDataTable($scope.ruleTableList[i]['ruleConditionTableName'],$scope.ruleTableList[i]['ruleConditionTableData'],$scope.ruleTableList[i]['index']);
                break;
            }
        }

    }

    $scope.delRuleConsequenceTableData = function(tableIndex,ruleConseqId){
        for(var i in $scope.ruleTableList){
            if($scope.ruleTableList[i]['index'] == tableIndex){
                var tmpData = [];
                for(var j in $scope.ruleTableList[i]['ruleConsequenceTableData']){
                    if($scope.ruleTableList[i]['ruleConsequenceTableData'][j]['ruleConseqId'] != ruleConseqId)
                        tmpData.push($scope.ruleTableList[i]['ruleConsequenceTableData'][j]);

                }
                $scope.ruleTableList[i]['ruleConsequenceTableData'] = tmpData;
                initRuleConsequenceDataTable($scope.ruleTableList[i]['ruleConsequenceTableName'],$scope.ruleTableList[i]['ruleConsequenceTableData'],$scope.ruleTableList[i]['index']);
                break;
            }
        }
    }


    $scope.$on('repeatFinishCallback',function(){
        for(var i in $scope.ruleTableList){
            initRuleConditionDataTable($scope.ruleTableList[i]['ruleConditionTableName'],$scope.ruleTableList[i]['ruleConditionTableData'],$scope.ruleTableList[i]['index']);
            initRuleConsequenceDataTable($scope.ruleTableList[i]['ruleConsequenceTableName'],$scope.ruleTableList[i]['ruleConsequenceTableData'],$scope.ruleTableList[i]['index']);
            if(i == ($scope.ruleTableList.length - 1)) {
                $("#div_tab_" + i).attr("class", "tab-content vehicleTabCon");
                $("#a_tab_" + i).attr("class", "selectTab");
                $scope.selectTabIndex = i;
            } else {
                $("#div_tab_"+i).attr("class","tab-content vehicleTabCon ng-hide");
                $("#a_tab_" + i).attr("class", "");
            }
        }
    });


    $scope.selectTabIndex = 0;


    // 点击规则标签
    $scope.openRuleInfo = function (i) {
        initRuleTabHide()
        $("#div_tab_" + i).attr("class", "tab-content vehicleTabCon");
        $("#a_tab_" + i).attr("class", "selectTab");
        $scope.selectTabIndex = i;
    };

    // 规则标签tabClass初始化
    function initRuleTabHide() {
        $("div[id*=div_tab_]").attr("class", "tab-content vehicleTabCon ng-hide");
        $("a[id*=a_tab_]").attr("class", "");
    }

    $scope.isMessage = true;


    $scope.$watch("rule.ruleType",function(newValue,oldValue, scope) {
        if($scope.isMessage) {
            var isData = false;
            for (var i in $scope.ruleTableList) {
                if ($scope.ruleTableList[i]['ruleConditionTableData'].length > 0 || $scope.ruleTableList[i]['ruleConsequenceTableData'].length > 0) {
                    isData = true;
                    break;
                }
            }
            if (isData) {
                modalConfirm($modal, function () {
                    $scope.isMessage = true;
                    $scope.resetRuleTableList();
                }, function () {
                    $scope.isMessage = false;
                    $scope.rule.ruleType = oldValue;
                }, '更改规则类型后,先前录入的规则条件将作废,是否继续更改?')
            }
        }else{
            $scope.isMessage = true;
        }
    }, true);

    $scope.resetRuleTableList = function(){
        for(var i in $scope.ruleTableList){
            $scope.ruleTableList[i]['ruleConditionTableData'] = [];
            $scope.ruleTableList[i]['ruleConsequenceTableData'] = [];
            initRuleConditionDataTable($scope.ruleTableList[i]['ruleConditionTableName'],$scope.ruleTableList[i]['ruleConditionTableData'],$scope.ruleTableList[i]['index']);
            initRuleConsequenceDataTable($scope.ruleTableList[i]['ruleConsequenceTableName'],$scope.ruleTableList[i]['ruleConsequenceTableData'],$scope.ruleTableList[i]['index']);
        }
    }

    $scope.goBack = function(){
        $location.path('app/baseinfo_rule');
    };


}]);


