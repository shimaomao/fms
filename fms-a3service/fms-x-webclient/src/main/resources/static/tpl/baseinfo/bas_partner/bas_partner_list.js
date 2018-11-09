/**
 * Created by huchenghao on 2018-03-17.
 */
app.controller('bas_partner_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {
    //查询参数
    $scope.params = setData.getter();
    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加经销商信息成功', toaster);
        }else if ($scope.type == 'saveGroup') {
            toaster_success('添加经销商信息成功,已覆盖用户组信息',toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑经销商信息成功',toaster);
        } else if ($scope.type == 'modifyGroup') {
            toaster_success('编辑经销商信息成功,已覆盖用户组信息',toaster);
        }
    }, 100);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'bas_partner/findBasPartnersByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_partner_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('partnerId'),
            defaultDetail('partnerCode','detailBasPartner','经销商代码','20%',$compile,$scope,'partnerId'),
            {title:'经销商全称',data:'partnerName',width:'20%'},
            {title:'经销商简称',data:'partnerNameShort',width:'20%'},
            {title:'经营品牌',data:'brand',width:'20%'},
            {title:'经营省份',data:'partnerProv',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'经营城市',data:'partnerCity',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
            {title:'经营区县',data:'partnerCounty',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data)
                        return "";
                    return common_area_value[common_area_code.getName][data];
                }
            },
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
        params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchBasPartner = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetBasPartner = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveBasPartner = function(){
        $location.path('/app/baseinfo_bas_partner_handler').search({'frameTitle':'添加经销商信息','operate':'save'});
    }

    $scope.modifyBasPartner = function(partnerId){
        var rowsIds =  $scope.dataTable.getRowsIds('partnerId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/baseinfo_bas_partner_handler').search({'frameTitle':'修改经销商信息','operate':'update','partnerId':rowsIds[0]});

        }
    }


    $scope.detailBasPartner = function(partnerId){
        $location.path('/app/baseinfo_bas_partner_detail').search({'frameTitle':'经销商信息详情','operate':'detail','partnerId':partnerId});
    }

    $scope.deleteBasPartner = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('partnerId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{
            modalConfirm($modal,function(){
                $http.delete('bas_partner/deleteBasPartnersByPartnerIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除经销商信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.baseinfo,CommonServiceType.excelTypes.two,
            'bas_partner/findBasPartnersByPage',dataTableParams($scope));
    }

}])
;