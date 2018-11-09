/**
 * Created by liujinge on 2018-03-26.
 */
app.controller('apply_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location' ,function ($scope, $http, $modal, toaster,$compile,$location) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'apply/findApplysByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'apply_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('applyNo'),
            defaultDetail('applyNo','detailApply','申请编号','20%',$compile,$scope,'applyNo'),
            {title:'状态',data:'bizStatus',width:'20%'},
            {title:'订单提出账号',data:'applyUser',width:'20%'},
            // {title:'applyGroup',data:'applyGroup',width:'20%'},
            // {title:'applyCreatDate',data:'applyCreatDate',width:'20%'},
            // {title:'applyFirsbtDate',data:'applyFirsbtDate',width:'20%'},
            // {title:'applySubmitDate',data:'applySubmitDate',width:'20%'},
            // {title:'applyPassDate',data:'applyPassDate',width:'20%'},
            // {title:'presentUser',data:'presentUser',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.applyNo = $scope.applyNo;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchApply = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetApply = function(){
        $scope.applyNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    // $scope.saveApply = function(){
    //     var rtn = $modal.open({
    //         backdrop : 'static',
    //         size:'lg',
    //         templateUrl: 'tpl/prbiz/apply/apply_save.html'+getCacheTime(),
    //         controller: 'apply_save_controller',
    //         resolve:{
    //         }
    //     });
    //     rtn.result.then(function (status) {
    //         if(status == Response.successMark) {
    //             toaster_success('添加prbiz信息成功',toaster);
    //             $scope.dataTable.fnDraw(true);
    //         }
    //     },function(){
    //     });
    // }

    $scope.modifyApply = function(applyNo){
        var apply =  $scope.dataTable.getRow(applyNo,'applyNo')
        if(apply.applyType =='1')
            $location.path('/app/prebiz_apply_input').search({'applyNo':apply.applyNo})
        else if(apply.applyType =='2')
            $location.path('/app/prebiz_apply_input_company').search({'applyNo':apply.applyNo})
        else
            modalAlert($modal,'类型出错!')



        // if(rowsIds.length < 1)
        //     modalAlert($modal,'请您选择需要修改的数据！');
        // else if(rowsIds.length > 1)
        //     modalAlert($modal,'只能同时修改一条数据！');
        // else{
        //
        //     var rtn = $modal.open({
        //         backdrop : 'static',
        //         size:'lg',
        //         templateUrl: 'tpl/prbiz/apply_input/apply_input_modify.html'+getCacheTime(),
        //         controller: 'apply_input_modify_controller',
        //         resolve:{
        //             applyId : function (){ return rowsIds[0] }
        //         }
        //     });
        //     rtn.result.then(function (status) {
        //         if(status == Response.successMark) {
        //             toaster_success('编辑prbiz信息成功', toaster);
        //             $scope.dataTable.fnDraw(true);
        //         }
        //     },function(){
        //     });
        //
        // }

    }
    //订单审批
    $scope.applyApproval = function (applyNo) {
        var apply =  $scope.dataTable.getRow(applyNo,'applyNo')
        $location.path('app/prebiz_apply_approve').search({'applyNo':apply.applyNo,'applyType':apply.applyType})
    }

    $scope.applyAgreeConditional = function (applyNo) {
        var apply =  $scope.dataTable.getRow(applyNo,'applyNo')
        $location.path('app/prebiz_apply_conditional_agree').search({'applyNo':apply.applyNo,'applyType':apply.applyType})
    }

    $scope.applyAgree = function (applyNo) {
        var apply =  $scope.dataTable.getRow(applyNo,'applyNo')
        $location.path('app/prebiz_apply_agree').search({'applyNo':apply.applyNo,'applyType':apply.applyType})
    }

    $scope.detailApply = function(applyNo){
                    //下面为财务付款测试

                    // var contNo = '0000000068';
                    // $scope.contNo = contNo;
                    // //applyNo = 'A001';
                var apply =  $scope.dataTable.getRow(applyNo,'applyNo')
                $location.path("app/prebiz_apply_input_detail").search({'applyNo':apply.applyNo,'contNo':$scope.contNo,'applyType':apply.applyType});

                    //下面是合同文件核查测试
                    // $location.path("app/prebiz_cont_inspect");

    }

    // 合同生成前确认
    $scope.contConfirmBef = function (applyNo) {
        var apply =  $scope.dataTable.getRow(applyNo,'applyNo');
        $location.path("app/prebiz_cont_confirm_bef").search({'applyNo':apply.applyNo, 'taskId':apply.taskId, "applyType":apply.applyType, "contNo":apply.contNo});
    }

}])
;