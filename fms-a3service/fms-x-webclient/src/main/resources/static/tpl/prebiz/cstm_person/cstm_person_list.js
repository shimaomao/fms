/**
 * Created by ningyangyang on 2018-03-26.
 */
app.controller('cstm_person_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location' ,function ($scope, $http, $modal, toaster,$compile,$location) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cstm_person/findCstmPersonsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'cstm_person_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('cstmPersonId'),
            defaultDetail('applyNo','detailCstmPerson','applyNo','20%',$compile,$scope),
            {title:'name',data:'name',width:'20%'},
            {title:'certifType',data:'certifType',width:'20%'},
            {title:'certifNo',data:'certifNo',width:'20%'},
            {title:'sex',data:'sex',width:'20%'},
            {title:'marriageStatus',data:'marriageStatus',width:'20%'},
            {title:'censusType',data:'censusType',width:'20%'},
            {title:'birthDate',data:'birthDate',width:'20%'},
            {title:'eduBgType',data:'eduBgType',width:'20%'},
            {title:'age',data:'age',width:'20%'},
            {title:'mobileNo',data:'mobileNo',width:'20%'},
            {title:'telNo',data:'telNo',width:'20%'},
            {title:'qqNo',data:'qqNo',width:'20%'},
            {title:'wechatNo',data:'wechatNo',width:'20%'},
            {title:'mail',data:'mail',width:'20%'},
            {title:'ethnicType',data:'ethnicType',width:'20%'},
            {title:'licenseNo',data:'licenseNo',width:'20%'},
            {title:'driver',data:'driver',width:'20%'},
            {title:'driverMobno',data:'driverMobno',width:'20%'},
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


    $scope.searchCstmPerson = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetCstmPerson = function(){
        $scope.applyNo = "";
        $scope.name = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveCstmPerson = function(){

        $location.path('/app/prebiz_cstm_person_save');
    }

    $scope.modifyCstmPerson = function(cstmPersonId){
        var rowsIds =  $scope.dataTable.getRowsIds('cstmPersonId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/prebiz/cstm_person/cstm_person_modify.html'+getCacheTime(),
                controller: 'cstm_person_modify_controller',
                resolve:{
                    cstmPersonId : function (){ return rowsIds[0] }
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


    $scope.detailCstmPerson = function(cstmPersonId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/cstm_person/cstm_person_detail.html'+getCacheTime(),
            controller: 'cstm_person_detail_controller',
            resolve:{
                cstmPerson : function (){ return $scope.dataTable.getRow(cstmPersonId,'cstmPersonId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteCstmPerson = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('cstmPersonId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('cstm_person/deleteCstmPersonByCstmPersonIds',getDeleteData(rowsIds)).success(function (data) {
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