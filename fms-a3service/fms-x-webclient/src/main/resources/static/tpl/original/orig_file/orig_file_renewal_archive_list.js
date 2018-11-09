app.controller('orig_file_renewal_archive_controller', ['$scope', '$http','$modal','$compile','$location','toaster','setData', function ($scope, $http,$modal,$compile,$location,toaster,setData) {
    //查询参数
    $scope.params = setData.getter();

    // 从其他画面跳转过来的弹出信息显示
    $scope.type = $location.search()['type'];
    $scope.msg = $location.search()['msg'];
    if ($scope.type == 'submit') {
        toaster_success($scope.msg, toaster);
    }
    //获取归档状态List
    $scope.origFileStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.origFileStatus);

    $scope.dataTableProperties= {
        dataTableAjax : {
            url : 'orig_file/findOrigFileInsListByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'file_archive_list',
        //table的列
        dataTableColumn: [
            defaultCheckBox('bizCode'),
            {
                title: '续保任务号',
                data: 'bizCode',
                width: '30%',
                render: function (data, type, row, meta) {
                    return "<a class=\"a1\" ng-click=\"detailArchive('"+data+"','"+row.bizCodeType+"')\">"+data+"</a>";
                },
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    $compile(nTd)($scope);
                }
            },
            {title:"合同号",data:'contNo',width:'30%'},
            // {title:'业务类型',data:'bizCodeType',width:'30%',
            //     render: function (data, type, row, meta) {
            //         return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizCodeType,data);
            //     }
            // },
            {title:'归档状态',data:'origFileStatus',width:'30%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.origFileStatus,data);
                }
            },
            {title:"承租人",data:'cstmName',width:'30%'},
            {title:"车架号",data:'vinNo',width:'30%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio,
    }
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);
    //请求的参数
    function dataTableParams($scope){
       /* params = {};
         params.origFileStatus = $scope.origFileStatus;
         params.contNo = $scope.contNo;*/
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

    $scope.resetOrigFile = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);
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
            {title:"续保任务号",data:'bizCode',width:'30%'},
            {title:"合同号",data:'contNo',width:'30%'},
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

    $scope.origFileMail = function () {
        var rows = $scope.dataTable.getRows();
        if (rows.length < 1){
            modalAlert($modal, "请选择操作数据");
        } else if(rows[0].origFileStatus == '1'){
            modalAlert($modal,'该明细已归档，不可操作');
        } else {
            $location.path('app/orig_file_renewal_sort').search({'bizCode':rows[0].bizCode, 'bizCodeType':rows[0].bizCodeType})
        }
    };
    //续保归档附件明细
    $scope.origFileDetail = function(){
        var rows = $scope.dataTable.getRows();
        if (rows.length < 1){
            modalAlert($modal, "请选择操作数据");
        } else if(rows.length > 1){
            modalAlert($modal,'请选择一条明细查看');
        } else {
            $location.path('app/orig_file_renewal_detail').search({'bizCode':rows[0].bizCode, 'bizCodeType':rows[0].bizCodeType,'uploadFlag':false})
        }
    }
    //续保归档附件上传
    $scope.uploadFile = function(){
        var rows = $scope.dataTable.getRows();
        if (rows.length < 1){
            modalAlert($modal, "请选择操作数据");
        } else if(rows.length > 1){
            modalAlert($modal,'请选择一条数据进行操作');
        } else {
            $location.path('app/orig_file_renewal_detail').search({'bizCode':rows[0].bizCode, 'bizCodeType':rows[0].bizCodeType,'uploadFlag':true})
        }
    }
}]);


