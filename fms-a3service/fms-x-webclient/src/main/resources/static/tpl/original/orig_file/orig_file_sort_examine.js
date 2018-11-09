app.controller('orig_file_sort_examine_controller', ['$scope', '$http','$modal','$compile','$location', 'toaster',function ($scope, $http,$modal,$compile,$location,toaster) {

    $scope.origFileSortVo = {};
    $scope.contractVo = {};
    $scope.contInsuranceVo = {};
    $scope.bizCode = ($location.search()["bizCode"]);
    //数据请求
    $scope.httpData = false;

    $http.get("orig_file/findOrigFileSortDetailsExamineByPage?origFileTaskNo=" + $location.search()['serviceId']).success(function (data) {
        $scope.origFileSortVo = data.data;
        $scope.contractVo = data.data.contractVo;
        $scope.contInsuranceVo = data.data.contInsuranceVo;
        $scope.bizFilesList =  $scope.origFileSortVo.bizFilesList;
        $scope.fileType = $scope.origFileSortVo.origFileType;
        $scope.httpData = true;
        $scope.insuranceSelectInfoList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes[$scope.contInsuranceVo.insuranceType]);
        if(data.code == Response.successCode){
            //参数配置
            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'file_sort_list',
                //table的列
                dataTableColumn: [
                     //defaultCheckBox('bizCode'),
                    {title:'<label class="i-checks i-checks-sm m-b-none"><input type="checkbox" name="all_checked"><i></i></label>',
                        data:'bizCode',
                        width:'3%',
                        render: function(data,type,row,meta){
                            var dataName = replaceIdData('bizCode');
                            var dataCheckBoxName = replaceIdData('ids','');
                            return '<label class="i-checks i-checks-sm m-b-none"><input type="checkbox" value="'+data+'" name="'+dataCheckBoxName+'" disabled><i></i></label>'
                        }
                    },
                    {title:'合同号',data:'bizCode',width:'20%'},
                    // {title:'业务类型',data:'bizCodeType',width:'20%',
                    //     render: function (data, type, row, meta) {
                    //         return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizCodeType,data);
                    //     }
                    // },
                    {title:'附件类型',data:'fileTypeName',width:'20%'},
                    // {title:'文件数量',data:'fileQtyLimit',width:'20%'},
                    {title:'文件状态',data:'origFileDetailStatus',width:'20%',
                        render: function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.origFileDetailStatus,data);
                        }
                    },
                    {title:'是否需要归档',data:'origFlag',width:'20%',
                        render:function (data,type,row,meta) {
                            var html = "";
                            html+="<div class=\"radio\" ng-repeat=\"a in 'origFlag' | getList\">";
                            html+="<label><input type=\"radio\" ng-value=\"a.codeValue\" ng-model=\"$parent.origFlagMode"+meta.row+"\" ng-change=\"changeValue("+meta.row+")\" ng-init=\"$parent.origFlagMode"+meta.row+"="+data+"\" disabled>{{a.codeValueName}}</label>";
                            html+="</div>";
                            return html;
                        },
                        fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                            $compile(nTd)($scope);
                        }
                    },
                ],
                //列是单选还是多选 CheckBox多选 Radio单选
                dataTableSelectType: 'onlyClickTd',
                dataTableData: data.data.origFileDetailVoList
            };
            $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties, $scope);
        }else {
            modalAlert($modal, data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    //checkbox赋值
    $scope.checkboxValue = function (name,value) {
        $scope.form[name].$dirty = true;
        var item = $scope.contInsuranceVo[name];
        var itemList = item.split(',');
        var index = itemList.indexOf(value);
        var result = "";

        if(index==-1){
            itemList.push(value);
        }else{
            itemList.splice(index,1);
        }

        for(var x in itemList){
            result+=itemList[x]+",";
        }
        if(result!=""){
            result = result.substring(0,result.length-1);
        }else{
            result =  "";
        }
        $scope.contInsuranceVo[name] = result;
    };

    $scope.showOrig = function(a,meta,name) {
        var nTr = $scope.dataTable.fnGetData();
        nTr[meta][name] = a;
    };
    $scope.changeValue = function (index) {
        var name = 'origFlagMode'+index;
        var nTr = $scope.dataTable.fnGetData();
        nTr[index]['origFlag'] = $scope[name];
    };
    //提交审核
    $scope.submit = function () {
        if(!$scope.form.$invalid){
            $http.post('orig_file/origFileSortExamine',
                {
                    "contractVo":$scope.contractVo,
                    "contInsuranceVo":$scope.contInsuranceVo,
                    "bizCode":$scope.origFileSortVo.bizCode,
                    "bizCodeType":$scope.origFileSortVo.bizCodeType,
                    "fileRecordNo":$scope.origFileSortVo.fileRecordNo,
                    "remark":$scope.origFileSortVo.remark,
                    "taskId":$location.search()['taskId'],
                }
            ).success(function (data) {
                if(data.code == Response.successCode){
                    $location.path('app/home').search({'type':'homeToastInfo', 'msg':'提交审核成功'})
                }else {
                    modalAlert($modal, data.message);
                }
            }).error(function (err) {
                modalAlert($modal,err);
            });
        } else {
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };
    //退回
    $scope.backUp = function () {
        if(!$scope.form.$invalid){
            $http.post('orig_file/origFileSortExamineBack',
                {
                    "contractVo":$scope.contractVo,
                    "contInsuranceVo":$scope.contInsuranceVo,
                    "bizCode":$scope.origFileSortVo.bizCode,
                    "bizCodeType":$scope.origFileSortVo.bizCodeType,
                    "fileRecordNo":$scope.origFileSortVo.fileRecordNo,
                    "remark":$scope.origFileSortVo.remark,
                    "taskId":$location.search()['taskId'],
                }
            ).success(function (data) {
                if(data.code == Response.successCode){
                    $location.path('app/home').search({'type':'homeToastInfo', 'msg':'退回成功'})
                }else {
                    modalAlert($modal, data.message);
                }
            }).error(function (err) {
                modalAlert($modal,err);
            });
        } else {
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    //返回主页
    $scope.backHome = function () {
        $location.path('app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.origSort;
    $scope.wfLogNo = $location.search()['serviceId'];

}]);


