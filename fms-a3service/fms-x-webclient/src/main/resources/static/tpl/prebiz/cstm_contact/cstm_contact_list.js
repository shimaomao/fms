/**
 * Created by ningyangyang on 2018-03-27.
 */
app.controller('cstm_contact_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cstm_contact/findCstmContactByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'cstm_contact_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contactId'),
            defaultDetail('applyNo','detailCstmContact','订单编号','20%',$compile,$scope),
            {title:'序号',data:'contactNo',width:'20%'},
            {title:'联系人姓名',data:'name',width:'20%'},
            {title:'联系人关系',data:'relation',width:'20%'},
            {title:'联系人手机号码',data:'mobileNo',width:'20%'},
            {title:'联系人所在省份',data:'resideProv',width:'20%'},
            {title:'联系人所在城市',data:'resideCity',width:'20%'},
            {title:'联系人所在区县',data:'resideCounty',width:'20%'},
            {title:'联系人所在详细地址',data:'resideAddr',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.applyNo = $scope.applyNo;
        params.contactNo = $scope.contactNo;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchCstmContact = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetCstmContact = function(){
        $scope.applyNo = "";
        $scope.contactNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveCstmContact = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/cstm_contact/cstm_contact_save.html'+getCacheTime(),
            controller: 'cstm_contact_save_controller',
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

    $scope.modifyCstmContact = function(contactId){
        var rowsIds =  $scope.dataTable.getRowsIds('contactId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/prebiz/cstm_contact/cstm_contact_modify.html'+getCacheTime(),
                controller: 'cstm_contact_modify_controller',
                resolve:{
                    contactId : function (){ return rowsIds[0] }
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


    $scope.detailCstmContact = function(contactId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/cstm_contact/cstm_contact_detail.html'+getCacheTime(),
            controller: 'cstm_contact_detail_controller',
            resolve:{
                cstmContact : function (){ return $scope.dataTable.getRow(contactId,'contactId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteCstmContact = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('contactId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('cstm_contact/deleteCstmContactByContactIds',getDeleteData(rowsIds)).success(function (data) {
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