/**
 * Created by qinmuqiao on 2018-09-03.
 */
app.controller('collection_person_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {

    //查询参数
    $scope.params = setData.getter();

    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加催收组员信息成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑催收组员信息成功',toaster);
        }
    }, 100);

    $scope.collectionTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.assignmentType);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'collection_person/findCollectionPersonVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'collection_person_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('collectionPersonId'),
            defaultDetail('collectionPersonNum','detailCollectionPerson','催收组员账号','20%',$compile,$scope,'collectionPersonId'),
            // {title:'催收人员账号',data:'collectionPersonNum',width:'20%'},
            {title:'催收类型',data:'collectionType',width:'20%',
                render:function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.assignmentType, data);
            }},
            {title:'催收组员名称',data:'collectionPersonName',width:'20%',},
            {title:'启用标识',data:'enableFlag',width:'20%',
                render:function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag, data);
            }},
            {title:'备注',data:'remark',width:'20%'},
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'updater',width:'20%'},
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


    $scope.searchCollectionPerson = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetCollectionPerson = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.saveCollectionPerson = function(){
        $location.path('/app/postbiz_collection_person_save');
    }

    $scope.modifyCollectionPerson = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('collectionPersonId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{

            $location.path('/app/postbiz_collection_person_modify').search({'collectionPersonId':rowsIds[0]});
        }
    }

    $scope.detailCollectionPerson = function(collectionPersonId){
        $location.path('/app/postbiz_collection_person_detail').search({'collectionPersonId':collectionPersonId});
    }

    $scope.deleteCollectionPerson = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('collectionPersonId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('collection_person/deleteCollectionPersonsByCollectionPersonIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除催收组员信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.postbiz,CommonServiceType.excelTypes.one,
            'collection_person/findCollectionPersonVosByPage',dataTableParams($scope));
    }

}])
;