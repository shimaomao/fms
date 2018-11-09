/**
 * Created by yangyiquan on 2018-05-11.
 */
app.controller('cont_prepay_detail_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cont_prepay_detail/findContPrepayDetailByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'cont_prepay_detail_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contPrepayDetailId'),
            defaultDetail('contNo','detailContPrepayDetail','合同编号','20%',$compile,$scope),
            {title:'提前还款明细类型',data:'prepaymDetailItem',width:'20%'},
            {title:'提前还款明细参考金额',data:'prepayTrialAmount',width:'20%'},
            {title:'提前还款明细实际金额',data:'prepayActualAmount',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.contNo = $scope.contNo;
        params.prepaymDetailItem = $scope.prepaymDetailItem;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchContPrepayDetail = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetContPrepayDetail = function(){
        $scope.contNo = "";
        $scope.prepaymDetailItem = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveContPrepayDetail = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/cost/cont_prepay_detail/cont_prepay_detail_save.html'+getCacheTime(),
            controller: 'cont_prepay_detail_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加cost信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifyContPrepayDetail = function(contPrepayDetailId){
        var rowsIds =  $scope.dataTable.getRowsIds('contPrepayDetailId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/cost/cont_prepay_detail/cont_prepay_detail_modify.html'+getCacheTime(),
                controller: 'cont_prepay_detail_modify_controller',
                resolve:{
                    contPrepayDetailId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑cost信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    $scope.detailContPrepayDetail = function(contPrepayDetailId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/cost/cont_prepay_detail/cont_prepay_detail_detail.html'+getCacheTime(),
            controller: 'cont_prepay_detail_detail_controller',
            resolve:{
                contPrepayDetail : function (){ return $scope.dataTable.getRow(contPrepayDetailId,'contPrepayDetailId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteContPrepayDetail = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('contPrepayDetailId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('cont_prepay_detail/deleteContPrepayDetailByContPrepayDetailIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除cost信息成功', toaster);
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