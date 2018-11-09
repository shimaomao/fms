/**
 * Created by ningyangyang on 2018-03-26.
 */
app.controller('cstm_pers_mate_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cstm_pers_mate/findCstmPersMateByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'cstm_pers_mate_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('persMateId'),
            defaultDetail('applyNo','detailCstmPersMate','applyNo','20%',$compile,$scope),
            {title:'name',data:'name',width:'20%'},
            {title:'certifType',data:'certifType',width:'20%'},
            {title:'certifNo',data:'certifNo',width:'20%'},
            {title:'mobileNo',data:'mobileNo',width:'20%'},
            {title:'compName',data:'compName',width:'20%'},
            {title:'compTel',data:'compTel',width:'20%'},
            {title:'position',data:'position',width:'20%'},
            {title:'salary',data:'salary',width:'20%'},
            {title:'compProv',data:'compProv',width:'20%'},
            {title:'compCity',data:'compCity',width:'20%'},
            {title:'compCounty',data:'compCounty',width:'20%'},
            {title:'compAddr',data:'compAddr',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.applyNo = $scope.applyNo;
        params.name = $scope.name;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchCstmPersMate = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetCstmPersMate = function(){
        $scope.applyNo = "";
        $scope.name = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveCstmPersMate = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/cstm_pers_mate/cstm_pers_mate_save.html'+getCacheTime(),
            controller: 'cstm_pers_mate_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加prebiz信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifyCstmPersMate = function(persMateId){
        var rowsIds =  $scope.dataTable.getRowsIds('persMateId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/prebiz/cstm_pers_mate/cstm_pers_mate_modify.html'+getCacheTime(),
                controller: 'cstm_pers_mate_modify_controller',
                resolve:{
                    persMateId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑prebiz信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    $scope.detailCstmPersMate = function(persMateId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/cstm_pers_mate/cstm_pers_mate_detail.html'+getCacheTime(),
            controller: 'cstm_pers_mate_detail_controller',
            resolve:{
                cstmPersMate : function (){ return $scope.dataTable.getRow(persMateId,'persMateId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteCstmPersMate = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('persMateId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('cstm_pers_mate/deleteCstmPersMateByPersMateIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除prebiz信息成功', toaster);
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