app.controller('orig_file_borrow_controller', ['$scope', '$http','$modal','$compile','$location', '$timeout', 'toaster','setData', function ($scope, $http,$modal,$compile,$location, $timeout,toaster,setData) {
    //查询参数
    $scope.params = setData.getter();

    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'submit') {
            toaster_success('借阅提交成功', toaster);
        }
    }, 100);
    //获取归档状态List
    $scope.origFileStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.origFileStatus);


    $scope.dataTableProperties= {
        dataTableAjax : {
            url : 'orig_file/findBorrowOrigFilesByOrigFileStatus',
            type:"GET",
        },
        //table的html id
        dataTableId:'file_archive_list',
        //table的列
        dataTableColumn: [
            defaultCheckBox('bizCode'),
            {
                title: '合同号',
                data: 'bizCode',
                width: '30%',
                render: function (data, type, row, meta) {
                    return "<a class=\"a1\" ng-click=\"detailArchive('"+data+"','"+row.bizCodeType+"')\">"+data+"</a>";
                },
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    $compile(nTd)($scope);
                }
            },
            // {title:'业务类型',data:'bizCodeType',width:'30%',
            //     render: function (data, type, row, meta) {
            //         return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizCodeType,data);
            //     }
            // },
            {title:'归档编号',data:'fileRecordNo',width:'30%',
                render: function (data, type, row, meta) {
                    return data;
                }
            },
            {title:'归档状态',data:'origFileStatus',width:'30%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.origFileStatus,data);
                }
            },
            {title:'归档审核状态',data:'origFileTaskStatus',width:'30%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data);
                }
            },
            {title:"客户姓名",data:'cstmName',width:'30%'},
            {title:"车架号",data:'vinNo',width:'30%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio,
    }
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    //请求的参数
    function dataTableParams($scope){
       /* params = {};
        // params.origFileStatus = $scope.origFileStatus;
        params.bizCode = $scope.bizCode;
        params.cstmName = $scope.cstmName;
        params.vinNo = $scope.vinNo;*/
        var params = $scope.params;
        setData.setter(params);
        return params;
    }
    //查询
    $scope.searchOrigFile = function () {
        $scope.dataTable.fnDraw(true);
        $scope.callback = function () {
            $scope.showTitle = false;
            $scope.$apply();
        };
    };
    //重置
    $scope.resetOrigFile = function(){
       /* $scope.bizCode = "";
        $scope.cstmName = "";
        $scope.vinNo = "";*/
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
        $scope.callback = function () {
            $scope.showTitle = false;
            $scope.$apply();
        };
    };

    //参数配置
    $scope.dataTableProperties2= {
        dataTableAjax : {
            url : 'orig_file_detail/findOrigFileDetailByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'file_archive_detail',
        //table的列
        dataTableColumn: [
            {title:"合同号",data:'bizCode',width:'30%'},
            // {title:'业务类型',data:'bizCodeType',width:'30%',
            //     render: function (data, type, row, meta) {
            //         return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizCodeType,data);
            //     }
            // },
            {title:'附件类型',data:'fileType',width:'30%'},
            {title:'文件状态',data:'origFileDetailStatus',width:'30%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.origFileDetailStatus,data);
                }
            }
        ],
    }

    function dataTableParams2($scope){
        params2 = {};
        params2.bizCode = $scope.bizCode2;
        params2.bizCodeType = $scope.bizCodeType2;
        return params2;
    }

    //查看详情
    $scope.showTitle = false;
    $scope.detailArchive = function (bizCode,bizCodeType) {
        $scope.bizCode2 = bizCode;
        $scope.bizCodeType2 = bizCodeType;
        $scope.callback = function () {
            $scope.showTitle = true;
            $scope.$apply();
        };
        if($scope.dataTable2){
            $scope.dataTable2.fnDraw(true);
        }else {
            $scope.dataTable2 = createTable($scope.dataTableProperties2,dataTableParams2,$scope);
        }
    };

    //借阅
    $scope.fileOperation = function () {
        var rowIds = $scope.dataTable.getRows();
        if (rowIds.length < 1){
            modalAlert($modal,'请选择需要操作的数据');
        } else {
            for(var i = 0;i<rowIds.length;i++){
                if(rowIds[i].origFileTaskStatus!='0300'){
                    modalAlert($modal,"请选择归档审核通过的数据");
                    return;
                }
            }
            $location.path('/app/original_file_borrow_detail').search({"bizCode": rowIds[0].bizCode, 'bizCodeType': rowIds[0].bizCodeType,
                "fileRecordNo": rowIds[0].fileRecordNo,'origFileType' : rowIds[0].origFileType});
        }
    };

}]);


