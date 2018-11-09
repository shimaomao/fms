/**
 * Created by niehaibing on 2018-03-23.
 */
app.controller('product_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location, $timeout) {

    // 判断message信息
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加产品方案成功', toaster);
        }
        if ($scope.type == 'modify') {
            toaster_success('修改产品方案成功', toaster);
        }
    }, 100)

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'product/findProductsByPage',
            type:"GET",

        },
        //table的html id
        dataTableId:'product_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('productId'),
            defaultDetail('product','detailProduct','产品方案代码','20%',$compile,$scope,'productId'),
            {title:'产品大类代码',data:'productCatg',width:'20%'},
            {title:'产品方案名称',data:'productName',width:'20%'},
            {title:'产品方案描述',data:'productMemo',width:'20%'},
            {title:'开始日期',data:'startDate',width:'20%'},
            {title:'结束日期',data:'endDate',width:'20%'},
            {title:'车辆类型',data:'vehicleForm',width:'20%',
                render: function (data, type, row, meta) {
                    var vehicleForm="";
                    if(data != null){
                        var dataArray=data.split(",");
                    }
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

            {title:'申请类型',data:'applyType',width:'20%',
                render: function (data, type, row, meta) {
                    var applyType="";
                    if(data != null){
                        var dataArray=data.split(",");
                    }
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

            {title:'车辆种类',data:'vehicleType',width:'20%',
                render: function (data, type, row, meta) {
                    var vehicleType="";
                    if(data != null){
                        var dataArray=data.split(",");
                    }
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

            {title:'牌照属性',data:'licenseAttr',width:'20%',
                render: function (data, type, row, meta) {
                    var licenseAttr="";
                    if(data != null){
                        var dataArray=data.split(",");
                    }
                    for(x in dataArray){
                        licenseAttr+=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,dataArray[x])+",";
                    }
                    if(licenseAttr!=""){
                        return licenseAttr.substring(0,licenseAttr.length-1);
                    }else{
                        return "";
                    }

                }
            },

            {title:'租金支付模式',data:'rentPayMode',width:'20%',
                render: function (data, type, row, meta) {
                    var rentPayMode="";
                    if(data != null){
                        var dataArray=data.split(",");
                    }
                    for(x in dataArray){
                        rentPayMode+=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.rentPayMode,dataArray[x])+",";
                    }
                    if(rentPayMode!=""){
                        return rentPayMode.substring(0,rentPayMode.length-1);
                    }else{
                        return "";
                    }

                }
            },

            {title:'GPS安装情况',data:'gpsInstMode',width:'20%',
                render: function (data, type, row, meta) {
                    var gpsInstMode="";
                    if(data != null){
                        var dataArray=data.split(",");
                    }
                    for(x in dataArray){
                        gpsInstMode+=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsInstMode,dataArray[x])+",";
                    }
                    if(gpsInstMode!=""){
                        return gpsInstMode.substring(0,gpsInstMode.length-1);
                    }else{
                        return "";
                    }

                }
            },

            {title:'还款方式',data:'repayMode',width:'20%',
                render: function (data, type, row, meta) {
                    var repayMode="";
                    if(data != null){
                        var dataArray=data.split(",");
                    }
                    for(x in dataArray){
                        repayMode+=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.repayMode,dataArray[x])+",";
                    }
                    if(repayMode!=""){
                        return repayMode.substring(0,repayMode.length-1);
                    }else{
                        return "";
                    }

                }
            },

            {title:'还款频率',data:'repayRate',width:'20%',
                render: function (data, type, row, meta) {
                    var repayRate="";
                    if(data != null){
                        var dataArray=data.split(",");
                    }
                    for(x in dataArray){
                        repayRate+=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.repayRate,dataArray[x])+",";
                    }
                    if(repayRate!=""){
                        return repayRate.substring(0,repayRate.length-1);
                    }else{
                        return "";
                    }

                }
            },

            {title:'保证金返还方式',data:'depositRtnMode',width:'20%',
                render: function (data, type, row, meta) {
                    var depositRtnMode="";
                    if(data != null){
                        var dataArray=data.split(",");
                    }
                    for(x in dataArray){
                        depositRtnMode+=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.depositRtnMode,dataArray[x])+",";
                    }
                    if(depositRtnMode!=""){
                        return depositRtnMode.substring(0,depositRtnMode.length-1);
                    }else{
                        return "";
                    }

                }
            },

            {title:'融资期限',data:'finPeriodType',width:'20%',
                render: function (data, type, row, meta) {
                    var finPeriodType="";
                    if(data != null){
                        var dataArray=data.split(",");
                    }
                    for(x in dataArray){
                        finPeriodType+=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.finPeriodType,dataArray[x])+",";
                    }
                    if(finPeriodType!=""){
                        return finPeriodType.substring(0,finPeriodType.length-1);
                    }else{
                        return "";
                    }

                }
            },

            {title:'手续费收取方式',data:'chargePayMode',width:'20%',
                render: function (data, type, row, meta) {
                    var chargePayMode="";
                    if(data != null){
                        var dataArray=data.split(",");
                    }
                    for(x in dataArray){
                        chargePayMode+=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.chargePayMode,dataArray[x])+",";
                    }
                    if(chargePayMode!=""){
                        return chargePayMode.substring(0,chargePayMode.length-1);
                    }else{
                        return "";
                    }

                }
            },
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人',data:'updater',width:'20%'},
            /*{title:'首付比例开始',data:'initPercFrom',width:'20%'},
            {title:'首付比例结束',data:'initPercTo',width:'20%'},
            {title:'首付金额开始',data:'initAmountFrom',width:'20%'},
            {title:'首付金额结束',data:'initAmountTo',width:'20%'},
            {title:'尾付比例开始',data:'finalPercFrom',width:'20%'},
            {title:'尾付比例结束',data:'finalPercTo',width:'20%'},
            {title:'尾付金额开始',data:'finalAmountFrom',width:'20%'},
            {title:'尾付金额结束',data:'finalAmountTo',width:'20%'},
            {title:'保证金开始',data:'depositFrom',width:'20%'},
            {title:'保证金结束',data:'depositTo',width:'20%'},
            {title:'保证金率开始',data:'depositPercFrom',width:'20%'},
            {title:'保证金率结束',data:'depositPercTo',width:'20%'},
            {title:'融资总额开始',data:'finTotalFrom',width:'20%'},
            {title:'融资总额结束',data:'finTotalTo',width:'20%'},
            {title:'风险融资额开始',data:'finRiskFrom',width:'20%'},
            {title:'风险融资额结束',data:'finRiskTo',width:'20%'},
            {title:'贴息是否差额付款',data:'subsidyPayMode',width:'20%'},
            {title:'扩展属性1',data:'prodAttr1',width:'20%'},
            {title:'扩展属性2',data:'prodAttr2',width:'20%'},
            {title:'扩展属性3',data:'prodAttr3',width:'20%'},*/
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    };

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.product = $scope.product;
        params.productCatg = $scope.productCatg;
        return params;
    };

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchProduct = function(){
        $scope.dataTable.fnDraw(true);
    };

    $scope.resetProduct = function(){
        $scope.product = "";
        $scope.productCatg = "";
        $scope.dataTable.fnDraw(true);//刷新
    };


    $scope.saveProduct = function(){
        $location.path('/app/product_product_center');
    };

    $scope.modifyProduct = function(){
        var productId =  $scope.dataTable.getRowsIds('productId');//主键

        if(productId.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(productId.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/product_product_center').search({
                "productId": productId[0]
            });
        }

    };


    $scope.detailProduct = function(productId){
        $location.path('/app/product_product_detail').search({
            "productId": productId
        });
    };

    $scope.deleteProduct = function(){
        var rowsIds = $scope.dataTable.getRows();
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{
            var result = {
                products: [],
                productIds: []
            };
            for(var i=0;i<rowsIds.length;i++){
                result.productIds.push(rowsIds[i].productId);
                if(rowsIds[i].product){
                    result.products.push(rowsIds[i].product);
                }

            }
            modalConfirm($modal,function(){
                $http.delete('product/deleteProductsByProductIds',getDeleteData(result)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除产品方案成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }else{
                        modalAlert($modal,data.message);
                    }
                })
            },null,'您确定需要删除吗？')

        }
    }

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.product,CommonServiceType.excelTypes.one,
            'product/findProductsByPage',dataTableParams($scope));
    }

}])
;