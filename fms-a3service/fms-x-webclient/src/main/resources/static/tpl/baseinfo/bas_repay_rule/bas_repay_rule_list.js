/**
 * Created by huchenghao on 2018-03-16.
 */
app.controller('bas_repay_rule_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {
    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加还款日规则信息成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑还款日规则信息成功',toaster);
        }
    }, 100);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'bas_repay_rule/findBasRepayRulesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_repay_rule_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('ruleId'),
            defaultDetail('repayDay','detailBasRepayRule','还款日','20%',$compile,$scope,'ruleId'),
            {title:'开始区间',data:'beginInterval',width:'20%'},
            {title:'结束区间',data:'endInterval',width:'20%'},
            {title:'系统更新时间',data:'updateTime',width:'20%',
                render: function (data, type, row, meta) {
                    return new Date(data).Format('yyyy-MM-dd HH:mm:ss');
                }
            },
            {title:'系统更新人员',data:'updater',width:'20%'},
            {title:'系统创建时间',data:'createTime',width:'20%',
                render: function (data, type, row, meta) {
                    return new Date(data).Format('yyyy-MM-dd HH:mm:ss');
                }
            },
            {title:'系统创建人',data:'creator',width:'20%'},

        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.repayDay = $scope.repayDay;
        params.beginInterval = $scope.beginInterval;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchBasRepayRule = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetBasRepayRule = function(){
        $scope.repayDay = "";
        $scope.beginInterval = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveBasRepayRule = function(){
        $location.path('/app/baseinfo_bas_repay_rule_handler').search({'frameTitle':'添加还款日规则','operate':'save'});
    }

    $scope.modifyBasRepayRule = function(ruleId){
        var rowsIds =  $scope.dataTable.getRowsIds('ruleId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/baseinfo_bas_repay_rule_handler').search({'frameTitle':'修改还款日规则','operate':'update','ruleId':rowsIds[0]});
        }

    }


    $scope.detailBasRepayRule = function(ruleId){
        $location.path('/app/baseinfo_bas_repay_rule_handler').search({'frameTitle':'查看还款日规则','operate':'detail','ruleId':ruleId});
    }

    $scope.deleteBasRepayRule = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('ruleId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{
            modalConfirm($modal,function(){
                $http.delete('bas_repay_rule/deleteBasRepayRulesByRuleIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除还款日规则成功', toaster);
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