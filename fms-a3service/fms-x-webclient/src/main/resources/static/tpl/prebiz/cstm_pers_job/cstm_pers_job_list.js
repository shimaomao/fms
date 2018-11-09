/**
 * Created by ningyangyang on 2018-03-26.
 */
app.controller('cstm_pers_job_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cstm_pers_job/findCstmPersJobByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'cstm_pers_job_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('persJobId'),
            defaultDetail('applyNo','detailCstmPersJob','订单编号','20%',$compile,$scope),
            {title:'单位名称',data:'compName',width:'20%'},
            {title:'单位电话',data:'compTel',width:'20%'},
            {title:'在职年限',data:'workYear',width:'20%'},
            {title:'职业',data:'profession',width:'20%'},
            {title:'职位',data:'position',width:'20%'},
            {title:'单位所属行业类别',data:'industry',width:'20%'},
            {title:'单位所在省份',data:'compProv',width:'20%'},
            {title:'单位所在城市',data:'compCity',width:'20%'},
            {title:'单位所在区县',data:'compCounty',width:'20%'},
            {title:'单位详细地址',data:'compAddr',width:'20%'},
            {title:'税后年薪',data:'salary',width:'20%'},
            {title:'其他税后年薪',data:'elseSalary',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.applyNo = $scope.applyNo;
        params.compName = $scope.compName;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchCstmPersJob = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetCstmPersJob = function(){
        $scope.applyNo = "";
        $scope.compName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveCstmPersJob = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/cstm_pers_job/cstm_pers_job_save.html'+getCacheTime(),
            controller: 'cstm_pers_job_save_controller',
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

    $scope.modifyCstmPersJob = function(persJobId){
        var rowsIds =  $scope.dataTable.getRowsIds('persJobId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/prebiz/cstm_pers_job/cstm_pers_job_modify.html'+getCacheTime(),
                controller: 'cstm_pers_job_modify_controller',
                resolve:{
                    persJobId : function (){ return rowsIds[0] }
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


    $scope.detailCstmPersJob = function(persJobId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/cstm_pers_job/cstm_pers_job_detail.html'+getCacheTime(),
            controller: 'cstm_pers_job_detail_controller',
            resolve:{
                cstmPersJob : function (){ return $scope.dataTable.getRow(persJobId,'persJobId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteCstmPersJob = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('persJobId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('cstm_pers_job/deleteCstmPersJobByPersJobIds',getDeleteData(rowsIds)).success(function (data) {
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