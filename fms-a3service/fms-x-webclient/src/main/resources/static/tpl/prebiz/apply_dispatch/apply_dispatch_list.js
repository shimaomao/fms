/**
 * Created by qiaohao on 2018/6/22.
 */
app.controller('apply_dispatch_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {
    //查询参数
    $scope.params = setData.getter();
    //风控主管派单状态
    $scope.applyDispatchStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.applyDispatchStatus);

    //添加，修改成功提示信息
    $scope.timer = $timeout(function () {
        $scope.messageType=$location.search()['messageType'];
        if($scope.messageType == 'gpsDispatchInput'){
            toaster_success('派单成功',toaster);
        }
    }, 5);


    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'apply/findDispatchApplyVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'apply_dispatch_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('applyId'),
            {title:'客户姓名',data:'lessee',width:'20%'},
            {title:'订单编号',data:'applyNo',width:'20%'},
            {title:'派单人',data:'approveUser',width:'20%'},
            {title:'订单提交时间',data:'applyFirsbtDate',width:'20%'},
            {title:'订单状态',data:'bizStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data);
                }
            },
            {title:'订单提出人',data:'applyUser',width:'10%'},
            {title:'提出机构',data:'applyGroup',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }


    //请求的参数
    function dataTableParams($scope){
       /* params = {};
        params.contNo = $scope.contNo;
        params.gpsSeller = $scope.gpsSeller;*/
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchGpsDispatch = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetGpsDispatch = function(){
       /* $scope.lessee = "";
        $scope.applyNo = "";*/
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.applyDispatch = function(contractId){
        var rows =  $scope.dataTable.getRows('contractId');//主键
        if(rows.length < 1)
            modalAlert($modal,'请您选择需要派单的订单信息');
        else {
            if(isNotUndefinedNull(rows[0].bizStatus)){
                if(rows[0].bizStatus == "0108" || rows[0].bizStatus == "0109" || rows[0].bizStatus == "0110"){
                    $location.path('/app/prebiz_apply_dispatch').search({applyDatas:rows});
                }else {
                    modalAlert($modal,'风控初审节点数据才能派单申请!');
                }
            }else {
                modalAlert($modal,'无法判断当前数据!');
            }

        }
    }


}])
;