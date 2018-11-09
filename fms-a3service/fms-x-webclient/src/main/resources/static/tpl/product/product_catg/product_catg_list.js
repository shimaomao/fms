/**
 * Created by niehaibing on 2018-03-21.
 */
app.controller('product_catg_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {

    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加产品大类成功', toaster);
        }
        if ($scope.type == 'modify') {
            toaster_success('修改产品大类成功', toaster);
        }
    }, 100)

    // 启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'product_catg/findProductCatgsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'product_catg_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('productCatgId'),
            defaultDetail('productCatg','detailProductCatg','产品大类代码','20%',$compile,$scope,'productCatgId'),
            {title:'产品大类名称',data:'productCatgName',width:'20%'},
            {title:'产品大类描述',data:'productCatgMemo',width:'20%'},
            {title:'申请类型',data:'applyType',width:'20%',
                render: function (data, type, row, meta) {
                    var applyType="";
                    var dataArray=data.split(",");
                    for(x in dataArray){
                        applyType+=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.applyType,dataArray[x])+",";
                    }
                    if(applyType!=""){
                        return applyType.substring(0,applyType.length-1);
                    }else{
                        return "";
                    }

                }
            },
            {title:'车辆类型',data:'vehicleForm',width:'20%',
                render: function (data, type, row, meta) {
                    var vehicleForm="";
                    var dataArray=data.split(",");
                    for(x in dataArray){
                        vehicleForm+=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleForm,dataArray[x])+",";
                    }
                    if(vehicleForm!=""){
                        return vehicleForm.substring(0,vehicleForm.length-1);
                    }else{
                        return "";
                    }

                }
            },
            {title:'车辆种类',data:'vehicleType',width:'20%',
                render: function (data, type, row, meta) {
                    var vehicleType="";
                    var dataArray=data.split(",");
                    for(x in dataArray){
                        vehicleType+=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleType,dataArray[x])+",";
                    }
                    if(vehicleType!=""){
                        return vehicleType.substring(0,vehicleType.length-1);
                    }else{
                        return "";
                    }

                }
            },
            {title:'启用标志',data:'enableFlag',width:'20%',
                render: function (data, type, row, meta) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,data);
            }},
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.productCatg = $scope.productCatg;
        params.productCatgName = $scope.productCatgName;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchProductCatg = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetProductCatg = function(){
        $scope.productCatg = "";
        $scope.productCatgName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveProductCatg = function(){
        $location.path('app/product_product_catg_save');
    }
    // 修改
    $scope.modifyProductCatg = function(productCatgId){
        var rowsIds =  $scope.dataTable.getRowsIds('productCatgId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/product_product_catg_modify').search({'productCatgId': rowsIds[0]});
        }
    };

// 查看详情
    $scope.detailProductCatg = function(productCatgId){
        $location.path('/app/product_product_catg_detail').search({'productCatgId': productCatgId});
    };

   /* $scope.detailProductCatg = function(productCatgId){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/product_catg/product_catg_detail.html'+getCacheTime(),
            controller: 'product_catg_detail_controller',
            resolve:{
                productCatg : function (){ return $scope.dataTable.getRow(productCatgId,'productCatgId') }
            }
        });
        rtn.result.then(function (status) {

        },function(){
        });
    }
*/
    $scope.deleteProductCatg = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('productCatgId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('product_catg/deleteProductCatgsByProductCatgIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除产品大类成功', toaster);
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
            'product_catg/findProductCatgsByPage',dataTableParams($scope));
    }

}])
;