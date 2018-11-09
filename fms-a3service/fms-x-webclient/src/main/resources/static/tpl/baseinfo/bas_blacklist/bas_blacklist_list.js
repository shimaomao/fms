/**
 * Created by yangyiquan on 2018-05-04.
 */
app.controller('bas_blacklist_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$timeout','$location', function ($scope, $http, $modal, toaster,$compile,$timeout,$location) {

    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加黑名单成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('修改黑名单成功',toaster);
        }
    }, 100);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'bas_blacklist/findBasBlacklistsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_blacklist_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('blacklistId'),
            defaultDetail('name','detailBasBlacklist','客户名称','20%',$compile,$scope,'blacklistId'),
            {title:'证件号码',data:'certifNo',width:'20%'},
            {title:'手机号码',data:'mobileNo',width:'20%'},
            {title:'黑名单级别',data:'blackLevel',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.blackLevel,data);
                }
            },
            {title:'来源',data:'source',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.source,data);
                }
            },
            {title:'备注',data:'memo',width:'30%'},
            {title:'更新时间',data:'updateTime',width:'20%',
                render: function (data, type, row, meta) {
                    return new Date(data).Format('yyyy-MM-dd HH:mm:ss');
                }
            },
            {title:'更新人员',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.name = $scope.name;
        params.certifNo = $scope.certifNo;
        return params;
    }

    //创建dataTable，（$scope.dataTableProperties方法具体内容在本页上方）
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchBasBlacklist = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetBasBlacklist = function(){
        $scope.name = "";
        $scope.certifNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    //新增黑名单
    $scope.saveBasBlacklist = function(){
        $location.path('app/baseinfo_bas_blacklist_handler').search({'frameTitle':'添加黑名单','operate':'save'});
    }

    //修改黑名单
    $scope.modifyBasBlacklist = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('blacklistId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            $location.path('/app/baseinfo_bas_blacklist_handler').search({
                'frameTitle':'修改黑名单',
                'operate':'update',
                'blacklistId': rowsIds[0]

            });

        }

    }

    //查看详细信息
    $scope.detailBasBlacklist = function(blacklistId){
        $location.path('/app/baseinfo_bas_blacklist_detail').search({
            'frameTitle':'黑名单详情',
            'operate':'check',
            'blacklistId': blacklistId
        });
    }

    //删除黑名单
    $scope.deleteBasBlacklist = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('blacklistId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('bas_blacklist/deleteBasBlacklistsByBlacklistIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除黑名单成功', toaster);
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
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.baseinfo,CommonServiceType.excelTypes.one,
            'bas_blacklist/findBasBlacklistsByPage',dataTableParams($scope));
    }

}])
;