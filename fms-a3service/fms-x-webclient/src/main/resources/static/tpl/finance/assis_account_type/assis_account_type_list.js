/**
 * Created by ningyangyang on 2018-06-23.
 */
app.controller('assis_account_type_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location', function ($scope, $http, $modal, toaster, $compile, $location) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'assis_account_type/findAssisAccountTypesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'assis_account_type_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('assisAccountTypeId'),
            defaultDetail('assisAccountType','detailAssisAccountType','辅助核算类型','20%',$compile,$scope,'assisAccountTypeId'),
            {title:'辅助核算类型名称',data:'assisAccountTypeName',width:'20%'},
            {title:'核算项目值设值',data:'assisAccountValue',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.assisAccountType = $scope.assisAccountType;
        params.assisAccountTypeName = $scope.assisAccountTypeName;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchAssisAccountType = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetAssisAccountType = function(){
        $scope.assisAccountType = "";
        $scope.assisAccountTypeName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    $scope.saveAssisAccountType = function(){
        $location.path('app/assis_account_type_save');
    }

    $scope.modifyAssisAccountType = function(assisAccountTypeId){
        var rowsIds =  $scope.dataTable.getRowsIds('assisAccountTypeId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/assis_account_type_modify').search({'assisAccountTypeId': rowsIds[0]});
        }

    }


    $scope.detailAssisAccountType = function(assisAccountTypeId){
        $location.path('/app/assis_account_type_detail').search({'assisAccountTypeId': assisAccountTypeId});
    }



    $scope.deleteAssisAccountType = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('assisAccountTypeId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('assis_account_type/deleteAssisAccountTypesByAssisAccountTypeIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除辅助核算类型信息成功', toaster);
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