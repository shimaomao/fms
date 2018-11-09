/**
 * Created by ningyangyang on 2018-05-03.
 */
app.controller('orig_file_list_controller', ['$scope', '$http','$modal','$compile','$location', function ($scope, $http,$modal,$compile,$location) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'orig_file/findOrigFilesByPage',
            type:"GET"
        },
        //table的html id
        dataTableId:'file_archive_list',
        //table的列
        dataTableColumn: [
            defaultCheckBox('bizCode'),
            defaultDetail('bizCode','detailArchive','业务号','30%',$compile,$scope,'bizCode'),
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
            {
                title:'归档期限',data:'origDeadline',width:'30%',
            },
            {
                title:'实际归档日期',data:'actualFilingDate',width:'30%',
            },
            {
                title:'剩余天数',data:'daysRemaining',width:'30%',
            }
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox,
    };

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.bizCode = $scope.bizCode;
        params.bizCodeType = $scope.bizCodeType;
        return params;
    }

    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);

    $scope.searchOrigFile = function(){
        $scope.dataTable.fnDraw(true);
        $scope.callback = function () {
            $scope.showTitle = false;
            $scope.$apply();
        };
    }

    $scope.resetOrigFile = function(){
        $scope.bizCode = "";
        $scope.bizCodeType = "";
        $scope.dataTable.fnDraw(true);//刷新
        $scope.callback = function () {
            $scope.showTitle = false;
            $scope.$apply();
        };
    }


    //查看详情
    $scope.showTitle = false;
    $scope.detailArchive = function (bizCode) {
        $http.get('orig_file_detail/findOrigFileDetailByPage?bizCode='+bizCode).success(function (data) {
            //参数配置
            $scope.dataTableProperties= {
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
                dataTableData: data.data.data
            }

            CommonDataTableUtils.createDataTableForData($scope.dataTableProperties);
            $scope.showTitle = true;
        });
    };
    // //文件操作
    // $scope.fileOperation = function () {
    //     var origFileDetailBizCodes =  $scope.dataTable.getRowsIds('bizCode');
    //     if(origFileDetailBizCodes.length < 1){
    //         modalAlert($modal,'请选择需要操作的数据');
    //     }else {
    //         $location.path('/app/orig_file_sort').search({"origFileDetailBizCodes": origFileDetailBizCodes});
    //     }
    // };

    //操作文件
    $scope.fileOperation = function () {
        var bizCodes =  $scope.dataTable.getRows();
        if(bizCodes.length<1){
            modalAlert($modal,'请选择需要操作的数据');
        }else{
            var bizCodesList = [];
            for(var i in bizCodes){
                bizCodesList.push(bizCodes[i].bizCode);
            }
            $location.path('/app/original_orig_file_detail_list').search({'bizCodesList':bizCodesList})
        }

    }
    // //归档完成确认btn
    // $scope.archivalCompletion = function () {
    //     var rowsIds = $scope.dataTable.getRows();
    //     if(rowsIds.length < 1){
    //         modalAlert($modal,'请选择数据');
    //     }else {
    //         $http.post('orig_file/fileFinishedConfirm',{"origFileVoList":rowsIds}).success(function (data) {
    //             if(data.code == Response.successCode){
    //                 $scope.dataTable.fnDraw(true);
    //                 modalAlert($modal, "归档确认成功");
    //             }else {
    //                 modalAlert($modal, data.message);
    //             }
    //         }).error(function (err) {
    //             modalAlert($modal,err);
    //         });
    //     }
    // };
}]);