/**
 * Created by yanfengbo on 2018-03-09.
 */
app.controller('bas_msg_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {
    //短信发送状态
    $scope.msgStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.msgStatus);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'bas_msg/findBasMsgByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_msg_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('msgId'),
            defaultDetail('telNo','detailBasMsg','手机号码','20%',$compile,$scope,'msgId'),
            {title:'短信内容',data:'msgText',width:'20%'},
            {title:'备注',data:'memo',width:'20%'},
            {title:'短信发送状态',data:'msgStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.msgStatus,data);

                }
            },
            {title:'短信分类',data:'tplTypeName',width:'20%'},
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'updater',width:'20%'},
        ],

        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.telNo = $scope.telNo;
        params.msgStatus = $scope.msgStatus;
        params.tplTypeName = $scope.tplTypeName;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchBasMsg = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetBasMsg = function(){
        $scope.telNo = "";
        $scope.msgStatus = "";
        $scope.tplTypeName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

   /* // 添加
    $scope.saveBasMsg = function(){
        $location.path('app/baseinfo_bas_msg_handler').search({'frmWidgetId':common_frame_widget_id.F000801});
        var basMsg = {};
        basMsg.frmWidgetId = common_frame_widget_id.F000801;
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_msg/bas_msg_handler.html'+getCacheTime(),
            controller: 'bas_msg_handler_controller',
            resolve:{
                basMsg:function () {
                    return basMsg;
                }
            }
        });
        rtn.result.then(function (status) {
            if(status == Response.successMark) {
                toaster_success('添加baseinfo信息成功',toaster);
                $scope.dataTable.fnDraw(true);
            }
        },function(){
        });
    }*/

    /*// 修改
    $scope.modifyBasMsg = function(msgId){
        var rowsIds =  $scope.dataTable.getRowsIds('msgId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path('/app/baseinfo_bas_msg_handler').search({'frmWidgetId':common_frame_widget_id.F000802, 'msgId': rowsIds[0]});

        }
        var rowsIds =  $scope.dataTable.getRowsIds('msgId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            var basMsg = $scope.dataTable.getRow(rowsIds[0],'msgId');
            basMsg.frmWidgetId = common_frame_widget_id.F000802;

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/baseinfo/bas_msg/bas_msg_handler.html'+getCacheTime(),
                controller: 'bas_msg_handler_controller',
                resolve:{
                    basMsg : function (){ return basMsg }
                }
            });
            rtn.result.then(function (status) {
                if(status == Response.successMark) {
                    toaster_success('编辑baseinfo信息成功', toaster);
                    $scope.dataTable.fnDraw(true);
                }
            },function(){
            });

        }
    }*/

    // 详情
    $scope.detailBasMsg = function(msgId){
        console.log(msgId);
        $location.path('/app/baseinfo_bas_msg_handler').search({'frameTitle':'短信发送详情','operate':'check','msgId': msgId});
    }



    //删除
    $scope.deleteBasMsg = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('msgId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('bas_msg/deleteBasMsgBymsgIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除baseinfo信息成功', toaster);
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
            'bas_msg/findBasMsgByPage',dataTableParams($scope));
    }

}])
;