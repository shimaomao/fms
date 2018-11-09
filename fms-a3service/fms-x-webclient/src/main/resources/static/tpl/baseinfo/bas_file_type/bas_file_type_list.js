/**
 * Created by yanfengbo on 2018-03-19.
 */
app.controller('bas_file_type_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {

    //添加，修改成功提示信息
    $scope.timer = $timeout(function () {
        $scope.messageType = $location.search()['messageType'];
        if($scope.messageType == 'saveBasFileType'){
            toaster_success('添加附件类型信息成功',toaster);
        }else if($scope.messageType == 'modifyBasFileType'){
            toaster_success('编辑附件类型信息成功',toaster);
        }

    }, 5);
    //是否实际文件
    $scope.actualFileList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.actualFile);
    //是否必填
    $scope.requiredState = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.requiredState);


    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'bas_file_type/findBasFileTypeByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'bas_file_type_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('fileTypeId'),
            defaultDetail('fileType','detailBasFileType','附件类型代码','20%',$compile,$scope,'fileTypeId'),
            {title:'附件类型名称',data:'fileTypeName',width:'20%'},
            // {title:'上级附件类型代码',data:'parentFileType',width:'20%'},
            /*{title:'是否必填',data:'fileChkFlag',width:'20%'},*/
            {title:'是否必填',data:'fileChkFlag',width:'20%',
                render: function (data, type, row, meta) {
                    /* return consValue(common_constant_code.msgStatus,data);*/
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.requiredState,data);

                }
            },
            {title:'排序',data:'orderNo',width:'20%'},
            {title:'类型限制',data:'fileTypeSuff',width:'20%'},
            {title:'数量限制',data:'fileQtyLimit',width:'20%'},
            /*{title:'是否实际文件',data:'fileFlag',width:'20%'},*/
            {title:'是否实际文件',data:'fileFlag',width:'20%',
                render: function (data, type, row, meta) {
                    /* return consValue(common_constant_code.msgStatus,data);*/
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.actualFile,data);

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
        /*$scope.parentFileType是附件类型代码，这里把值赋给上级类型代码*/
        params.parentFileType = $scope.parentFileType;
        /*这里把值赋给类型代码*/
        params.fileType = $scope.parentFileType;
        params.fileTypeName = $scope.fileTypeName;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    // 创建树
    function initBasFileTypeTree() {
        $scope.orgParent = {id:CommonCodeUtils.codeValues.common_parent_id,text:CommonCodeUtils.codeValues.common_bas_file_type_parent_name};
        $http.get('bas_file_type/findBasFileTypeByTree').success(function(data){
            var childNodes = data.data;
            var tree = [
                {
                    id: $scope.orgParent.id,
                    text:$scope.orgParent.text,
                    nodes: childNodes
                }
            ];
            $('#bas_file_type_tree').treeview({
                data: tree,
                emptyIcon: 'glyphicon glyphicon-minus',
                onNodeSelected: function (event, data) {
                    $scope.parentFileType = data.id;
                    if ($scope.parentFileType == CommonCodeUtils.codeValues.common_parent_id) {
                        $scope.parentFileType = '';
                    }
                    $scope.orgParent.id = data.id;
                    $scope.orgParent.text = data.text;
                    console.log($scope.parentFileType)
                    $scope.searchBasFileType();
                }
            });
        });
    }

    // 树信息初始化
    initBasFileTypeTree();



    $scope.searchBasFileType = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetBasFileType = function(){
        $scope.fileType = "";
        $scope.fileTypeName = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    // 添加
    $scope.saveBasFileType = function() {
        $location.path('app/baseinfo_bas_file_type_save').search({/*'frmWidgetId': common_frame_widget_id.F000801,*/'frameTitle':'添加附件类型', 'operate':'save','parentFileType':$scope.parentFileType});
    }


        // 修改
        $scope.modifyBasFileType = function(fileTypeId) {
            var rowsIds = $scope.dataTable.getRowsIds('fileTypeId');//主键

            if (rowsIds.length < 1)
                modalAlert($modal, '请您选择需要修改的数据！');
            else if (rowsIds.length > 1)
                modalAlert($modal, '只能同时修改一条数据！');
            else {
                $location.path('/app/baseinfo_bas_file_type_modify').search({
                   /* 'frmWidgetId': common_frame_widget_id.F000802,*/
                    'frameTitle':'修改附件类型',
                    'operate':'update',
                    'fileTypeId': rowsIds[0],
                    'parentFileType':$scope.parentFileType
                });

            }
        }


            // 详情
            $scope.detailBasFileType = function(fileTypeId) {
                console.log(fileTypeId);
                $location.path('/app/baseinfo_bas_file_type_detail').search({
                   /* 'frmWidgetId': common_frame_widget_id.F000803,*/
                    'frameTitle':'附件类型详情',
                    'operate':'check',
                    'fileTypeId': fileTypeId
                });
            }


    $scope.deleteBasFileType = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('fileTypeId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('bas_file_type/deleteBasFileTypesByFileTypeIds',getDeleteData(rowsIds)).success(function (data) {
                    console.log(data)
                    if(data.code == Response.successCode) {
                        toaster_success('删除附件类型信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                        initBasFileTypeTree();
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
            'bas_file_type/findBasFileTypeByPage',dataTableParams($scope));
    }
}])
;