/**
 * Created by ningyangyang on 2018-03-30.
 */
app.controller('guarantee_pers_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'guarantee_pers/findGuaranteePersByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'guarantee_pers_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('guarPersId'),
            defaultDetail('applyNo','detailGuaranteePers','订单编号','20%',$compile,$scope),
            {title:'序号',data:'guarPersNo',width:'20%'},
            {title:'担保人姓名',data:'name',width:'20%'},
            {title:'担保人关系',data:'relation',width:'20%'},
            {title:'证件类型',data:'certifType',width:'20%'},
            {title:'证件号码',data:'certifNo',width:'20%'},
            {title:'性别',data:'sex',width:'20%'},
            {title:'生日',data:'birthDate',width:'20%'},
            {title:'手机号码',data:'mobileNo',width:'20%'},
            {title:'电话号码',data:'telNo',width:'20%'},
            {title:'居住省份',data:'resideProv',width:'20%'},
            {title:'居住城市',data:'resideCity',width:'20%'},
            {title:'居住区县',data:'resideCounty',width:'20%'},
            {title:'居住详细地址',data:'resideAddr',width:'20%'},
            {title:'单位名称',data:'compName',width:'20%'},
            {title:'单位电话',data:'compTel',width:'20%'},
            {title:'工作年限',data:'workYear',width:'20%'},
            {title:'职业',data:'profession',width:'20%'},
            {title:'职位',data:'position',width:'20%'},
            {title:'单位所属类型',data:'industry',width:'20%'},
            {title:'单位所在省份',data:'compProv',width:'20%'},
            {title:'单位所在市',data:'compCity',width:'20%'},
            {title:'单位所在区县',data:'compCounty',width:'20%'},
            {title:'单位详细地址',data:'compAddr',width:'20%'},
            {title:'年薪(万元)',data:'salary',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.applyNo = $scope.applyNo;
        params.guarPersNo = $scope.guarPersNo;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchGuaranteePers = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetGuaranteePers = function(){
        $scope.applyNo = "";
        $scope.guarPersNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveGuaranteePers = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/guarantee_pers/guarantee_pers_save.html'+getCacheTime(),
            controller: 'guarantee_pers_save_controller',
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

    $scope.modifyGuaranteePers = function(guarPersId){
        var rowsIds =  $scope.dataTable.getRowsIds('guarPersId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/prebiz/guarantee_pers/guarantee_pers_modify.html'+getCacheTime(),
                controller: 'guarantee_pers_modify_controller',
                resolve:{
                    guarPersId : function (){ return rowsIds[0] }
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


    $scope.detailGuaranteePers = function(guarPersId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/guarantee_pers/guarantee_pers_detail.html'+getCacheTime(),
            controller: 'guarantee_pers_detail_controller',
            resolve:{
                guaranteePers : function (){ return $scope.dataTable.getRow(guarPersId,'guarPersId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteGuaranteePers = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('guarPersId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('guarantee_pers/deleteGuaranteePersByGuarPersIds',getDeleteData(rowsIds)).success(function (data) {
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