/**
 * Created by qinmuqiao on 2018-09-08.
 */
app.controller('annual_inspection_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {

    //查询参数
    $scope.params = setData.getter();
    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('年检更新成功', toaster);
        } else if ($scope.type == 'modify') {
        }
    }, 100);

    $scope.annualInspectStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.annualInspectStatus);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'annual_inspection/findAnnualInspectionVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'annual_inspection_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('annualInspectionId'),
            defaultDetail('contNo','detailAnnualInspection','合同号','20%',$compile,$scope,'annualInspectionId'),
            {title:'承租人',data:'annualInspecUser',width:'20%'},
            {title:'车架号',data:'annualInspecVinNo',width:'20%'},
            {title:'是否年检',data:'annualInspectStatus',width:'20%',
                render:function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.annualInspectStatus, data);
                }},
            {title:'车辆行驶证书注册日期',data:'annualInspecDrivingLicenseRegisterDate',width:'20%'},
            {title:'年检期限',data:'annualInspectDeadline',width:'20%'},
            {title:'年检日期',data:'annualInspectDate',width:'20%'},
            {title:'年检任务号',data:'annualInspectNo',width:'20%'},

        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope){
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchAnnualInspection = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetAnnualInspection = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.updateAnnualInspection = function(){

        var rows = $scope.dataTable.getRows();
        var rowsIds =  $scope.dataTable.getRowsIds('annualInspectionId');//主键
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要更新的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能更新修改一条数据！');
        else{
            if (rows[0].annualInspectStatus == "1"){
                modalAlert($modal,'年检已完成！');
                return;
            }
            $location.path('/app/postbiz_annual_inspection_update').search({'annualInspectionId':rowsIds[0]});
        }

    }

    $scope.detailAnnualInspection = function(annualInspectionId){
        $location.path('/app/postbiz_annual_inspection_detail').search({'annualInspectionId':annualInspectionId});
    }

    /*查询违章*/
    $scope.selectCarBreak = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('annualInspectionId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要查询的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能更新查询一条数据！');
        else{

        }
    };

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.postbiz,CommonServiceType.excelTypes.one,
            'annual_inspection/findAnnualInspectionVosByPage',dataTableParams($scope));
    }

}])
;