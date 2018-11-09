/**
 * Created by yanfengbo on 2018-05-22.
 */
app.controller('car_collect_comp_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {
    //添加，修改成功提示信息
    $scope.timer = $timeout(function () {
        $scope.messageType=$location.search()['messageType'];
        if($scope.messageType == 'saveCarCollectComp'){
            toaster_success('添加收车机构信息成功',toaster);
        }else if($scope.messageType=='modifyCarCollectComp'){
            toaster_success('编辑收车机构信息成功',toaster);
        }

    }, 5);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'car_collect_comp/findCarCollectCompsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'car_collect_comp_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('carCollectCompId'),
            defaultDetail('carCollectCompCode','detailCarCollectComp','收车机构代码','20%',$compile,$scope,'carCollectCompId'),
            {title:'收车机构名称',data:'carCollectCompName',width:'20%'},
            {title:'联系电话',data:'contactTel',width:'20%'},
            {title:'联系地址',data:'address',width:'20%'},
            {title:'邮箱',data:'mailAddress',width:'20%'},
            {title:'所在省份',data:'addrProv',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'所在城市',data:'addrCity',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
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
        params.carCollectCompCode = $scope.carCollectCompCode;
        params.carCollectCompName = $scope.carCollectCompName;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchCarCollectComp = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetCarCollectComp = function(){
        $scope.carCollectCompCode = "";
        $scope.carCollectCompName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    //添加
    $scope.saveCarCollectComp = function(){
        $location.path('app/postbiz_car_collect_comp_save').search({'frameTitle':'添加收车机构信息','operate':'save'});
    }

    //修改
    $scope.modifyCarCollectComp = function(carCollectCompId){

        var rowsIds =  $scope.dataTable.getRowsIds('carCollectCompId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/postbiz_car_collect_comp_modify').search({'frameTitle':'修改收车机构信息','operate':'update','carCollectCompId': rowsIds[0]});

        }
    }


    //详情
    $scope.detailCarCollectComp = function(carCollectCompId){
        $location.path('/app/postbiz_car_collect_comp_detail').search({'frameTitle':'收车机构信息详情','operate':'check','carCollectCompId': carCollectCompId});
    }

    //删除
    $scope.deleteCarCollectComp = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('carCollectCompId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('car_collect_comp/deleteCarCollectCompsByCarCollectCompIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除收车机构信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

    //导出excel
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.postbiz,CommonServiceType.excelTypes.one,
            'car_collect_comp/findCarCollectCompsByPage',dataTableParams($scope));
    }

}])
;