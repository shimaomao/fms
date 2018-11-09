/**
 * Created by yanfengbo on 2018-05-29.
 */
app.controller('overdue_cont_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'overdue_cont/findOverdueContsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'overdue_cont_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('overdueContId'),
            defaultDetail('cstmName','detailOverdueCont','承租人','20%',$compile,$scope,'overdueContId'),
            {title:'申请编号',data:'applyNo',width:'20%'},
            {title:'合同编号',data:'contNo',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.overdueCstmId = $scope.overdueCstmId;
        params.applyNo = $scope.applyNo;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchOverdueCont = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetOverdueCont = function(){
        $scope.overdueCstmId = "";
        $scope.applyNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.modifyOverdueCont = function(){

        var rowsIds=$scope.dataTable.getRows()
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要上传的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时上传一条数据！');
        else{
            $location.path('/app/cost_overdue_cont_modify').search({'frameTitle':'罚息免除','operate':'update','contNo': rowsIds[0].contNo});
        }

        // var rowsIds =  $scope.dataTable.getRowsIds('overdueContId');//主键
        //
        // if(rowsIds.length < 1)
        //     modalAlert($modal,'请您选择需要修改的数据！');
        // else if(rowsIds.length > 1)
        //     modalAlert($modal,'只能同时修改一条数据！');
        // else{
        //     $location.path('/app/cost_overdue_cont_modify').search({'frameTitle':'罚息免除','operate':'update','overdueContId': rowsIds[0]});
        // }

    }

   /* $scope.detailOverdueCont = function(overdueContId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/cost/overdue_cont/overdue_cont_detail.html'+getCacheTime(),
            controller: 'overdue_cont_detail_controller',
            resolve:{
                overdueCont : function (){ return $scope.dataTable.getRow(overdueContId,'overdueContId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }*/

    /*$scope.deleteOverdueCont = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('overdueContId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('overdue_cont/deleteOverdueContsByOverdueContIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除cost信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }*/

}])
;