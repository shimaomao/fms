/**
 * Created by ningyangyang on 2018-05-25.
 */
app.controller('common_borrower_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'common_borrower/findCommonBorrowersByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'common_borrower_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('comBorrowerId'),
            defaultDetail('applyNo','detailCommonBorrower','订单编号','20%',$compile,$scope),
            {title:'借款人姓名',data:'name',width:'20%'},
            {title:'证件类型',data:'certifType',width:'20%'},
            {title:'证件号码',data:'certifNo',width:'20%'},
            {title:'手机号码',data:'mobileNo',width:'20%'},
            {title:'单位名称',data:'compName',width:'20%'},
            {title:'单位电话',data:'compTel',width:'20%'},
            {title:'职位',data:'position',width:'20%'},
            {title:'年薪(万元)',data:'salary',width:'20%'},
            {title:'单位所在省份',data:'compProv',width:'20%'},
            {title:'单位所在城市',data:'compCity',width:'20%'},
            {title:'单位所在区县',data:'compCounty',width:'20%'},
            {title:'单位所在详细地址',data:'compAddr',width:'20%'},
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


    $scope.searchCommonBorrower = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetCommonBorrower = function(){
        $scope.applyNo = "";
        $scope.name = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveCommonBorrower = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/common_borrower/common_borrower_save.html'+getCacheTime(),
            controller: 'common_borrower_save_controller',
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

    $scope.modifyCommonBorrower = function(comBorrowerId){
        var rowsIds =  $scope.dataTable.getRowsIds('comBorrowerId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/prebiz/common_borrower/common_borrower_modify.html'+getCacheTime(),
                controller: 'common_borrower_modify_controller',
                resolve:{
                    comBorrowerId : function (){ return rowsIds[0] }
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


    $scope.detailCommonBorrower = function(comBorrowerId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/common_borrower/common_borrower_detail.html'+getCacheTime(),
            controller: 'common_borrower_detail_controller',
            resolve:{
                commonBorrower : function (){ return $scope.dataTable.getRow(comBorrowerId,'comBorrowerId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }

    $scope.deleteCommonBorrower = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('comBorrowerId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('common_borrower/deleteCommonBorrowersByComBorrowerIds',getDeleteData(rowsIds)).success(function (data) {
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