/**
 * Created by qinmuqiao on 2018-09-15.
 */
app.controller('veh_maintain_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$timeout','$location','setData', function ($scope, $http, $modal, toaster,$compile,$timeout,$location,setData) {
    //查询参数
    $scope.params = setData.getter();
    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加维修记录成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑维修记录成功',toaster);
        }
    }, 100);

    $scope.maintainFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.maintainFlag);


    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'veh_maintain/findVehMaintainsVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'veh_maintain_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('vehMaintainId'),
            defaultDetail('vehContNo','detailVehMaintain','合同号','20%',$compile,$scope,'vehMaintainId'),
            {title:'来源',data:'maintainFlag',width:'20%',
                render:function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.maintainFlag, data);
                }},
            {title:'承租人',data:'vehTenant',width:'20%'},
            {title:'出租人',data:'vehLessor',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'发动机号',data:'engineNo',width:'20%'},
            {title:'车牌号',data:'vehicleLicenseNo',width:'20%'},
            {title:'维修日期',data:'maintainDate',width:'20%'},
            {title:'维修地点',data:'maintainAddr',width:'20%'},
            {title:'维修金额',data:'maintainAmount',width:'20%'},
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


    $scope.searchVehMaintain = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetVehMaintain = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveVehMaintain = function(){
        $location.path('/app/postbiz_veh_maintain_save');
    }

    $scope.modifyVehMaintain = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('vehMaintainId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            $location.path('/app/postbiz_veh_maintain_modify').search({'vehMaintainId':rowsIds[0]});

        }
    }

    $scope.downloadVehMaintainTemplate = function (){
        window.parent.open('veh_maintain/exportVehMaintainModalExcel');

    }

    $scope.importVehMaintainExcel = function (){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/common/file/file_upload.html'+getCacheTime(),
            controller: 'file_upload_controller',
            resolve:{
                fileTypePath:function () {
                    return CommonCodeUtils.fileTypePaths.upLoad;
                },
                secondPath:function () {
                    return CommonCodeUtils.secondPath.vehMaintainFiles;
                }
            }
        });
        rtn.result.then(function (data) {
            if(CommonObjectUtils.isExist(data) && data.length > 0 && CommonStringUtils.isNotTrimBlank(data[0].fileCompletePath)){
                $scope.importVehMaintains(data[0].fileCompletePath);
            }
        },function(){

        });
    }

    $scope.importVehMaintains = function(filePath){
        $http.post('veh_maintain/importVehMaintainsByExcel?filePath='+filePath).success(function (data) {
            if (data.code == Response.successCode) {
                toaster_success('维修记录导入成功', toaster);
                $scope.dataTable.fnDraw(true);
            } else {
                modalAlert($modal,data.message);
            }
            $scope.submit = false;
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        })
    }

    $scope.detailVehMaintain = function(vehMaintainId){
        $location.path('/app/postbiz_veh_maintain_detail').search({'vehMaintainId':vehMaintainId});

    }

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.postbiz,CommonServiceType.excelTypes.one,
            'veh_maintain/findVehMaintainsVosByPage',dataTableParams($scope));
    }

}])
;