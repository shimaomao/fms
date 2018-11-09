/**
 * Created by ningyangyang on 2018-07-27.
 */
app.controller('mortgage_remind_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {

    $scope.mortgageRemind = {};
    $scope.mortgageStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.mortgageRemindStatus);
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'mortgage_remind/findMortgageRemindsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'mortgage_remind_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('morRemindId'),
            defaultDetail('lessee','detailMortgageRemind','承租人','20%',$compile,$scope,'morRemindId'),
            {title:'出租人',data:'lessor',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'合同号',data:'contNo',width:'20%'},
            {title:'融资额',data:'finTotal',width:'20%'},
            {title:'融资期限',data:'leasePeriod',width:'20%'},
            {title:'抵押日期',data:'mortgageDate',width:'20%'},
            {title:'合同生效日期',data:'contractValidDate',width:'20%'},
            {title:'抵押状态',data:'mortgageStatus',width:'20%',
            render:function (data) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.mortgageRemindStatus,data)
            }
            },
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.lessee = $scope.lessee;
        params.vinNo = $scope.vinNo;
        params.mortgageStatus = $scope.mortgageStatus;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchMortgageRemind = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetMortgageRemind = function(){
        $scope.lessee = "";
        $scope.vinNo = "";
        $scope.mortgageStatus = "";
        $scope.dataTable.fnDraw(true);//刷新
    }
    //抵押
    $scope.modifyMortgageRemind = function(){
        var rowsIds =  $scope.dataTable.getRows();//主键
        if(rowsIds.length < 1){
            modalAlert($modal,'请您选择需要修改的数据！');
        } else{
            if(rowsIds[0].mortgageStatus != 2){
                modalAlert($modal,'请您选择尚未抵押的数据！');
                $scope.submit = false;
            }else {
                $location.path('app/asset_mortgage_remind_Impawn').search({'mortgageRemindList':JSON.stringify(rowsIds)});
            }
        }

    }
    //解抵押
    $scope.relMortgageRemind = function(){
        var rowsIds =  $scope.dataTable.getRows();//主键
        if(rowsIds.length < 1){
            modalAlert($modal,'请您选择需要解押的数据！');
        } else {
            if(rowsIds[0].mortgageStatus != 0 ){
                modalAlert($modal,'请您选择已经抵押的数据！');
                $scope.submit = false;
            }else {
                $location.path('app/asset_mortgage_remind_unlockImpawn').search({'mortgageRemindList':JSON.stringify(rowsIds)});
            }
        }

    }


    $scope.detailMortgageRemind = function(morRemindId){
        var data = $scope.dataTable.getRow(morRemindId, 'morRemindId');
        if (data.mortgageStatus == 2){
            modalAlert($modal,'未抵押数据暂无详情！');
            return;
        }
        $location.path('app/asset_mortgage_remind_detail').search({'morRemindId':morRemindId});
    }


    $scope.deleteMortgageRemind = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('morRemindId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('mortgage_remind/deleteMortgageRemindsByMorRemindIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除asset信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

    //导出数据表
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.asset,CommonServiceType.excelTypes.one,
            'mortgage_remind/findMortgageRemindsByPage',dataTableParams($scope));
    }

}])
;