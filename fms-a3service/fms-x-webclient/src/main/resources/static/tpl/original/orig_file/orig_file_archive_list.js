app.controller('orig_file_archive_list_controller', ['$scope', '$http','$modal','$compile','$location','setData',function ($scope, $http,$modal,$compile,$location,setData) {
    //查询参数
    $scope.params = setData.getter();

    //获取归档状态List
    $scope.origFileStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.origFileStatus);
    //文件状态
    $scope.origFileDetailStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.origFileDetailStatus);
    //是否超期
    $scope.daysRemainingStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.daysRemainingStatus);
    //主页传递的归档状态初始化
    if(CommonObjectUtils.isExist($location.search()['origFileStatus'])){
        $scope.params.origFileStatus = $location.search()['origFileStatus']; //款项状态
    }

    /*$scope.origFileStatus = 0*/
    //参数配置
    $scope.dataTableProperties= {
        dataTableAjax : {
            url : 'orig_file/findPreOrigFilesByOrigFileStatus',
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
            {title:'归档状态',data:'origFileStatus',width:'30%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.origFileStatus,data);
                }
            },
            {title:"归档期限",data:'origDeadline',width:'30%'},
            {title:"剩余归档天数",data:'daysRemaining',width:'30%'},
            {title:"承租人",data:'cstmName',width:'30%'},
            {title:"车架号",data:'vinNo',width:'30%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    };

    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    function dataTableParams($scope){
       /* params = {};
        params.bizCode = $scope.bizCode;
        params.origFileStatus = $scope.origFileStatus;
        params.origFileDetailStatus = $scope.origFileDetailStatus;
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
    $scope.resetOrigFile = function(){
       /* $scope.origFileStatus = "";
        $scope.bizCode = "";
        $scope.origFileDetailStatus = "";
        $scope.cstmName = "";
        $scope.vinNo = "";*/
        $scope.params = {};
        $scope.dataTable.fnDraw(true);
        $scope.callback = function () {
            $scope.showTitle = false;
            $scope.$apply();
        };
    };

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
            /*{title:'业务类型',data:'bizCodeType',width:'30%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizCodeType,data);
                }
            },*/
            {title:'附件类型',data:'fileType',width:'30%'},
            {title:'是否需要归档',data:'origFlag',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.yesNoFlag,data);
                }
            },
            {title:'文件状态',data:'origFileDetailStatus',width:'30%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.origFileDetailStatus,data);
                }
            }
        ]
    };

    function dataTableParams2($scope){
        params2 = {};
        params2.bizCode = $scope.bizCode2;
        params2.bizCodeType = $scope.bizCodeType2;
        params2.origFileDetailStatus = $scope.params.origFileDetailStatus;
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
    //资料邮寄
    $scope.origFileMail = function () {
        var rows = $scope.dataTable.getRows();
        if (rows.length < 1){
            modalAlert($modal, "请选择需要操作的数据");
        } else if(rows[0].origFileStatus == 1){
            modalAlert($modal,'已归档不可操作');
        }else {
            $location.path('/app/orig_file_mail').search({"bizCode": rows[0].bizCode, 'bizCodeType':rows[0].bizCodeType});
        }
    };
    //资料上传
    $scope.origFileUpload = function () {
        var rows = $scope.dataTable.getRows();
        if (rows.length < 1){
            modalAlert($modal, "请选择需要操作的数据");
        } else if(rows[0].origFileStatus == 1){
            modalAlert($modal,'已归档不可操作');
        }else {
            $location.path('/app/orig_file_upload').search({"bizCode": rows[0].bizCode, 'bizCodeType':rows[0].bizCodeType,
                'origFileType' : rows[0].origFileType,'origFileObj':rows[0]});
        }
    };
    
    //查看详情
    $scope.detailOrigFile = function () {
        var rows = $scope.dataTable.getRows();
        if (rows.length < 1){
            modalAlert($modal, "请选择需要操作的数据");
        } else if(rows[0].origFileStatus == 0){
            modalAlert($modal,'只能查看已归档的数据');
        }else {
            $location.path('/app/orig_file_upload').search({"bizCode": rows[0].bizCode, 'bizCodeType':rows[0].bizCodeType,
                'origFileType' : rows[0].origFileType,'origFileObj':rows[0],'detail':'true'});
        }
    }
}]);


