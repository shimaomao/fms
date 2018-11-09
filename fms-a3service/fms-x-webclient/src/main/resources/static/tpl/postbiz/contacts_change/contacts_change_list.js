/**
 * Created by lijunjun on 2018-09-01.
 */
app.controller('contacts_change_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'contacts_change/findContactsChangesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'contacts_change_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contactsChangeId'),
            defaultDetail('solveType','detailContactsChange','操作类型','20%',$compile,$scope),
            {title:'申请编号',data:'applyNo',width:'20%'},
            {title:'变更任务号',data:'contactsTaskNo',width:'20%'},
            {title:'联系人姓名',data:'name',width:'20%'},
            {title:'联系人关系',data:'relation',width:'20%'},
            {title:'联系人手机号码',data:'mobileNo',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.solveType = $scope.solveType;
        params.applyNo = $scope.applyNo;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchContactsChange = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetContactsChange = function(){
        $scope.solveType = "";
        $scope.applyNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveContactsChange = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/contacts_change/contacts_change_save.html'+getCacheTime(),
            controller: 'contacts_change_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加postbiz信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }

    $scope.modifyContactsChange = function(contactsChangeId){
        var rowsIds =  $scope.dataTable.getRowsIds('contactsChangeId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/postbiz/contacts_change/contacts_change_modify.html'+getCacheTime(),
                controller: 'contacts_change_modify_controller',
                resolve:{
                    contactsChangeId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑postbiz信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }

    }


    $scope.detailContactsChange = function(contactsChangeId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/contacts_change/contacts_change_detail.html'+getCacheTime(),
            controller: 'contacts_change_detail_controller',
            resolve:{
                contactsChange : function (){ return $scope.dataTable.getRow(contactsChangeId,'contactsChangeId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteContactsChange = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('contactsChangeId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('contacts_change/deleteContactsChangesByContactsChangeIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除postbiz信息成功', toaster);
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