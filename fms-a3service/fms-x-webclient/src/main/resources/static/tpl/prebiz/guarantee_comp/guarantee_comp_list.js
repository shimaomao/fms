/**
 * Created by ningyangyang on 2018-03-30.
 */
app.controller('guarantee_comp_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'guarantee_comp/findGuaranteeCompByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'guarantee_comp_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('guarCompId'),
            defaultDetail('applyNo','detailGuaranteeComp','订单编号','20%',$compile,$scope),
            {title:'序号',data:'guarCompNo',width:'20%'},
            {title:'企业名称',data:'name',width:'20%'},
            {title:'担保人关系',data:'relation',width:'20%'},
            {title:'统一社会信用代码',data:'socialCertifNo',width:'20%'},
            {title:'企业电话',data:'landlineNo',width:'20%'},
            {title:'企业性质',data:'compType',width:'20%'},
            {title:'法定代表人',data:'compLegalRep',width:'20%'},
            {title:'法人证件类型',data:'certifType',width:'20%'},
            {title:'法人证件号码',data:'certifNo',width:'20%'},
            {title:'法人手机号码',data:'mobileNo',width:'20%'},
            {title:'企业联系人',data:'compContactPers',width:'20%'},
            {title:'企业联系电话',data:'compTel',width:'20%'},
            {title:'企业所在省份',data:'compProv',width:'20%'},
            {title:'企业所在城市',data:'compCity',width:'20%'},
            {title:'企业所在区县',data:'compCounty',width:'20%'},
            {title:'企业详细地址',data:'compAddr',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.applyNo = $scope.applyNo;
        params.guarCompNo = $scope.guarCompNo;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchGuaranteeComp = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetGuaranteeComp = function(){
        $scope.applyNo = "";
        $scope.guarCompNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveGuaranteeComp = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/guarantee_comp/guarantee_comp_save.html'+getCacheTime(),
            controller: 'guarantee_comp_save_controller',
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

    $scope.modifyGuaranteeComp = function(guarCompId){
        var rowsIds =  $scope.dataTable.getRowsIds('guarCompId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/prebiz/guarantee_comp/guarantee_comp_modify.html'+getCacheTime(),
                controller: 'guarantee_comp_modify_controller',
                resolve:{
                    guarCompId : function (){ return rowsIds[0] }
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


    $scope.detailGuaranteeComp = function(guarCompId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/guarantee_comp/guarantee_comp_detail.html'+getCacheTime(),
            controller: 'guarantee_comp_detail_controller',
            resolve:{
                guaranteeComp : function (){ return $scope.dataTable.getRow(guarCompId,'guarCompId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteGuaranteeComp = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('guarCompId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('guarantee_comp/deleteGuaranteeCompByGuarCompIds',getDeleteData(rowsIds)).success(function (data) {
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