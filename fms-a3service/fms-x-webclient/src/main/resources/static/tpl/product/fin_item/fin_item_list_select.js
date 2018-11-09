/**
 * Created by niehaibing on 2018-03-21.
 */
app.controller('fin_item_select_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'fin_item/findFinItemsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'fin_item_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('finItemId'),
            defaultDetail('finItem','detailFinItem','融资项目代码','20%',$compile,$scope,'finItemId'),
            {title:'融资项目名称',data:'finItemName',width:'20%'},
           /* {title:'牌照属性',data:'licenseAttr',width:'20%'},*/
            {title:'融资方式',data:'finMode',width:'20%',
                render: function (data, type, row, meta) {
                    return  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.finMode,data);
                }
            },
            {title:'是否可修改',data:'editMode',width:'20%'},
            {title:'是否和车款一起支付',data:'payMode',width:'20%'},
            {title:'排序',data:'orderNo',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
      //  params.finItem = $scope.finItem;
        params.finItemName = $scope.finItemName;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchFinItem = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetFinItem = function(){
        $scope.finItem = "";
        $scope.finItemName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveFinItem = function(){
        $location.path('app/system_fin_item_save');
       /* var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/fin_item/fin_item_save.html'+getCacheTime(),
            controller: 'fin_item_save_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加system信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });*/
    }
    $scope.detailFinItem = function(finItemId){
        $location.path('/app/system_fin_item_detail').search({'finItemId': finItemId});

    }
    $scope.modifyFinItem = function(finItemId){
        var rowsIds =  $scope.dataTable.getRowsIds('finItemId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/system_fin_item_modify').search({'finItemId': rowsIds[0]});
        }
      /*  var rowsIds =  $scope.dataTable.getRowsIds('finItemId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/system/fin_item/fin_item_modify.html'+getCacheTime(),
                controller: 'fin_item_modify_controller',
                resolve:{
                    finItemId : function (){ return rowsIds[0] }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑system信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }*/

    }


  /*  $scope.detailFinItem = function(finItemId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/fin_item/fin_item_detail.html'+getCacheTime(),
            controller: 'fin_item_detail_controller',
            resolve:{
                finItem : function (){ return $scope.dataTable.getRow(finItemId,'finItemId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }*/

    $scope.deleteFinItem = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('finItemId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('fin_item/deleteFinItemsByFinItemIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除system信息成功', toaster);
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