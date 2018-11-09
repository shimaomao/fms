/**
 * Created by ningyangyang on 2018-03-26.
 */
app.controller('cstm_pers_addr_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cstm_pers_addr/findCstmPersAddrByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'cstm_pers_addr_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('persAddrId'),
            defaultDetail('applyNo','detailCstmPersAddr','订单编号','20%',$compile,$scope),
            {title:'居住状况',data:'resideCond',width:'20%'},
            {title:'居住年份',data:'resideYear',width:'20%'},
            {title:'居住省份',data:'resideProv',width:'20%'},
            {title:'居住城市',data:'resideCity',width:'20%'},
            {title:'居住区县',data:'resideCounty',width:'20%'},
            {title:'居住详细地址',data:'resideAddr',width:'20%'},
            {title:'户籍省份',data:'censusProv',width:'20%'},
            {title:'户籍城市',data:'censusCity',width:'20%'},
            {title:'户籍区县',data:'censusCounty',width:'20%'},
            {title:'户籍详细地址',data:'censusAddr',width:'20%'},
            {title:'房产类型',data:'propertyType',width:'20%'},
            {title:'房产省份',data:'propertyProv',width:'20%'},
            {title:'房产城市',data:'propertyCity',width:'20%'},
            {title:'房产区县',data:'propertyCounty',width:'20%'},
            {title:'房产详细地址',data:'propertyAddr',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.applyNo = $scope.applyNo;
        params.resideCond = $scope.resideCond;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchCstmPersAddr = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetCstmPersAddr = function(){
        $scope.applyNo = "";
        $scope.resideCond = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveCstmPersAddr = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/cstm_pers_addr/cstm_pers_addr_save.html'+getCacheTime(),
            controller: 'cstm_pers_addr_save_controller',
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

    $scope.modifyCstmPersAddr = function(persAddrId){
        var rowsIds =  $scope.dataTable.getRowsIds('persAddrId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/prebiz/cstm_pers_addr/cstm_pers_addr_modify.html'+getCacheTime(),
                controller: 'cstm_pers_addr_modify_controller',
                resolve:{
                    persAddrId : function (){ return rowsIds[0] }
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


    $scope.detailCstmPersAddr = function(persAddrId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/cstm_pers_addr/cstm_pers_addr_detail.html'+getCacheTime(),
            controller: 'cstm_pers_addr_detail_controller',
            resolve:{
                cstmPersAddr : function (){ return $scope.dataTable.getRow(persAddrId,'persAddrId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteCstmPersAddr = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('persAddrId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('cstm_pers_addr/deleteCstmPersAddrByPersAddrIds',getDeleteData(rowsIds)).success(function (data) {
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