/**
 * Created by niehaibing on 2018-03-21.
 */
app.controller('fin_item_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', '$timeout', function ($scope, $http, $modal, toaster,$compile,$location, $timeout) {

    // 判断message信息
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加融资费用信息成功', toaster);
        }
        if ($scope.type == 'modify') {
            toaster_success('修改融资费用信息成功', toaster);
        }
    }, 100)

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
            /*{title:'牌照属性',data:'licenseAttr',width:'20%',
                render: function (data, type, row, meta) {
                    var licenseAttr="";
                    var dataArray=data.split(",");
                    for(x in dataArray){
                        licenseAttr+=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,dataArray[x])+",";
                    }
                    if(licenseAttr!=""){
                        return licenseAttr.substring(0,licenseAttr.length-1);
                    }else{
                        return "";
                    }

                }
            },*/
            {title:'融资方式',data:'finMode',width:'20%',
                render: function (data, type, row, meta) {
                        return  CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.finMode,data);
                }
            },
            {title:'是否可修改',data:'editMode',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.editMode,data);
                }
            },
            {title:'是否和车款一起支付',data:'payMode',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.payMode,data);
                }
            },
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人',data:'updater',width:'20%'},
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
        $location.path('app/product_fin_item_save');

    }
    $scope.detailFinItem = function(finItemId){
        $location.path('/app/product_fin_item_detail').search({'finItemId': finItemId});

    }
    $scope.modifyFinItem = function(finItemId){
        var rowsIds =  $scope.dataTable.getRowsIds('finItemId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/product_fin_item_modify').search({'finItemId': rowsIds[0]});
        }


    }




    $scope.deleteFinItem = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('finItemId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('fin_item/deleteFinItemsByFinItemIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除融资费用信息信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.product,CommonServiceType.excelTypes.one,
            'fin_item/findFinItemsByPage',dataTableParams($scope));
    }
}])
;