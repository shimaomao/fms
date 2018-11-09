/**
 * Created by niehaibing on 2018-03-27.
 */
app.controller('intrst_factor_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {
    //添加，修改成功提示信息
    $scope.timer = $timeout(function () {
        $scope.messageType=$location.search()['messageType'];
        if($scope.messageType == 'saveIntrstFactor'){
            toaster_success('添加利率因子成功',toaster);
        }else if($scope.messageType=='modifyIntrstFactor'){
            toaster_success('编辑利率因子成功',toaster);
        }

    }, 5);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'intrst_factor/findIntrstFactorsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'intrst_factor_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('intrstFactorId'),
            defaultDetail('factorCode','detailIntrstFactor','因子代码','20%',$compile,$scope,'intrstFactorId'),
            {title:'因子名称',data:'factorName',width:'20%'},
            {title:'匹配类型',data:'factorType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.factorType,data);
                }
            },
            {title:'启用标志',data:'enableFlag',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,data);
                }
            },
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.factorCode = $scope.factorCode;
        params.factorName = $scope.factorName;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchIntrstFactor = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetIntrstFactor = function(){
        $scope.factorCode = "";
        $scope.factorName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    //添加
    $scope.saveIntrstFactor = function(){
        $location.path('app/product_intrst_factor_save').search({'frameTitle':'添加利率因子信息','operate':'save'});
    }

    //修改
    $scope.modifyIntrstFactor = function(intrstFactorId){
        var rowsIds =  $scope.dataTable.getRowsIds('intrstFactorId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/product_intrst_factor_modify').search({'frameTitle':'修改利率因子信息','operate':'update','intrstFactorId': rowsIds[0]});
        }

    }

    //详情
    $scope.detailIntrstFactor = function(intrstFactorId){
        $location.path('/app/product_intrst_factor_detail').search({'frameTitle':'利率因子详情','operate':'check','intrstFactorId': intrstFactorId});
    }

    $scope.deleteIntrstFactor = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('intrstFactorId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('intrst_factor/deleteIntrstFactorsByIntrstFactorIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除利率因子信息成功', toaster);
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