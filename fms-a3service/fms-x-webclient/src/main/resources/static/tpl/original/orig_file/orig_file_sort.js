app.controller('orig_file_sort_controller', ['$scope', '$http','$modal','$compile', 'toaster','$location','$state', function ($scope, $http,$modal,$compile,toaster,$location,$state) {

    $scope.origFileSortVo = {};
    $scope.contractVo = {};
    $scope.contInsuranceVo = {};
    $scope.detail = $location.search()['detail'];
    $scope.zipFileName = null;
    $scope.equMorOtherApplyInput = $location.search()['equMorOtherApplyInput'];

    if($scope.detail){
        $scope.dataTableColumn = [
            {title:'合同号',data:'bizCode',width:'20%'},
            {title:'附件类型',data:'fileTypeName',width:'20%'},
            //{title:'文件数量',data:'fileQtyLimit',width:'20%'},
            {title:'文件状态',data:'origFileDetailStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.origFileDetailStatus,data);
                }
            },
            {title:'快递公司',data:'postComp',width:'20%'},
            {title:'快递编号',data:'postNo',width:'20%'},
            {title:'邮寄日期',data:'postDate',width:'20%'},
            {title:'是否需要归档',data:'origFlag',width:'20%',
                render:function (data,type,row,meta) {
                    var html = "";
                    html+="<div class=\"radio\" ng-repeat=\"a in 'origFlag' | getList\">";
                    html+="<label><input type=\"radio\" ng-value=\"a.codeValue\" ng-model=\"$parent.origFlagMode"+meta.row+"\" ng-change=\"changeValue("+meta.row+")\" ng-init=\"$parent.origFlagMode"+meta.row+"="+data+"\" ng-disabled=\"detail\">{{a.codeValueName}}</label>";
                    html+="</div>";
                    return html;
                },
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    $compile(nTd)($scope);
                }
            },
        ];
    }else{
        $scope.dataTableColumn = [
            //defaultCheckBox('bizCode'),
            {title:'<label class="i-checks i-checks-sm m-b-none"><input type="checkbox" name="all_checked"><i></i></label>',
                data:'bizCode',
                width:'3%',
                render: function(data,type,row,meta){
                    var dataName = replaceIdData('bizCode');
                    var dataCheckBoxName = replaceIdData('ids','');
                    return '<label class="i-checks i-checks-sm m-b-none"><input type="checkbox" value="'+data+'" name="'+dataCheckBoxName+'"><i></i></label>'
                }
            },
            {title:'合同号',data:'bizCode',width:'20%'},
            {title:'附件类型',data:'fileTypeName',width:'20%'},
            {title:'文件状态',data:'origFileDetailStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.origFileDetailStatus,data);
                }
            },
            {title:'快递公司',data:'postComp',width:'20%'},
            {title:'快递编号',data:'postNo',width:'20%'},
            {title:'邮寄日期',data:'postDate',width:'20%'},
            {title:'是否需要归档<div class="radio"><label><input name="checkAll" type="radio" value="1"><span>是</span></label></div><div class="radio"><label><input name="checkAll" type="radio" value="0"><span>否</span></label></div>',data:'origFlag',width:'20%',
                render:function (data,type,row,meta) {
                    var html = "";
                    html+="<div class=\"radio\" ng-repeat=\"a in 'origFlag' | getList\">";
                    html+="<label><input type=\"radio\" ng-value=\"a.codeValue\" ng-model=\"$parent.origFlagMode"+meta.row+"\" ng-change=\"changeValue("+meta.row+")\" ng-init=\"$parent.origFlagMode"+meta.row+"="+data+"\" ng-disabled=\"detail\">{{a.codeValueName}}</label>";
                    html+="</div>";
                    return html;
                },
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    $compile(nTd)($scope);
                }
            },
        ];
    }
    //附件对象
    $scope.bizFilesList = [];

    //原件归档流程退回到申请
    if ($location.search()['serviceParameter']){
        $scope.origFileSortVo.bizCode = $location.search()['serviceParameter'].paramVariables.bizCode;
        $scope.origFileSortVo.bizCodeType = $location.search()['serviceParameter'].paramVariables.bizCodeType;
    } else {
        $scope.origFileSortVo.bizCode = $location.search()['bizCode'];
        $scope.origFileSortVo.bizCodeType = $location.search()['bizCodeType'];
    }

    //数据请求
    $scope.httpData = false;

    $scope.getData = function () {
        $http.get("orig_file/findOrigFileSortDetailsByPage?bizCode=" + $scope.origFileSortVo.bizCode+'&bizCodeType='+$scope.origFileSortVo.bizCodeType).success(function (data) {
            $scope.origFileSortVo = data.data;
            console.log($scope.origFileSortVo)
            $scope.contractVo = data.data.contractVo;
            $scope.zipFileName = $scope.contractVo.contNo;
            if($scope.detail && $scope.origFileSortVo.origFileStatus ==  '1'){
                $scope.origFileSortVo.origVinNo = $scope.contractVo.vinNo;
                $scope.origFileSortVo.origEngineeNo = $scope.contractVo.engineNo;
            }
            $scope.contInsuranceVo = data.data.contInsuranceVo;
            // $scope.bizFilesList.bizFilesInfo = data.data.commonBizFilesVo.bizFilesInfo;
            // $scope.bizFilesList.bizFilesListVos = data.data.commonBizFilesVo.bizFilesListVos;
            $scope.bizFilesList =  $scope.origFileSortVo.bizFilesList;
            $scope.fileType = $scope.origFileSortVo.origFileType;
            if ($scope.contInsuranceVo.insuranceType){
                $scope.insuranceSelectInfoList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes[$scope.contInsuranceVo.insuranceType]);
            }
            if(data.code == Response.successCode){
                //参数配置
                $scope.dataTableProperties= {
                    //table的html id
                    dataTableId:'file_sort_list',
                    //table的列
                    dataTableColumn: $scope.dataTableColumn,
                    //列是单选还是多选 CheckBox多选 Radio单选
                    dataTableSelectType: 'onlyClickTd',
                    dataTableData: data.data.origFileDetailVoList
                };
                $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties, $scope);
                $scope.httpData = true;

                $('input[name=checkAll]').click(function () {
                    var value = $("input[name='checkAll']:checked").val();
                    var nTr = $scope.dataTable.fnGetData();
                    for(var i=0;i<nTr.length;i++){
                        nTr[i].origFlag = value;
                        $scope['origFlagMode'+i] = value;
                    }
                    $scope.$apply();
                });
            }else {
                modalAlert($modal, data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };
    $scope.getData();
    //checkbox赋值
    $scope.checkboxValue = function (name,value) {
        $scope.form[name].$dirty = true;
        var item = $scope.contInsuranceVo[name];
        var itemList;
        if(CommonObjectUtils.isNotExist(item) || item == ""){
            itemList = [];
        }else{
            itemList = item.split(',');
        }

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

    //暂存
    $scope.temporarySave = function () {
        var rowsIds = $scope.dataTable.fnGetData();
        $http.post('orig_file/temporarySave',
            {
                "origFileDetailVoList":rowsIds,
                "contractVo":$scope.contractVo,
                "contInsuranceVo":$scope.contInsuranceVo,
                "bizCode":$scope.origFileSortVo.bizCode,
                "bizCodeType":$scope.origFileSortVo.bizCodeType,
                "fileRecordNo":$scope.origFileSortVo.fileRecordNo,
                "remark":$scope.origFileSortVo.origMemo,
                "origVinNo":$scope.origFileSortVo.origVinNo,
                "origEngineeNo":$scope.origFileSortVo.origEngineeNo,
                "origMemo":$scope.origFileSortVo.origMemo,
            }
        ).success(function (data) {
            if(data.code == Response.successCode){
                modalAlert($modal,'暂存成功');
                // window.location.reload();
                $scope.getData();
            }else {
                modalAlert($modal, data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };
    //确认收到
    $scope.ReceivedConfirm = function () {
        var rowsIds = $scope.dataTable.getRows();
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择数据');
        } else {
            for (var x in rowsIds){
                if (rowsIds[x].origFileDetailStatus !== '1'){
                    modalAlert($modal, "文件状态为待签收，才可以进行确认收到");
                    return;
                }
            }
            $http.post('orig_file/ReceivedConfirm',
                {
                    "origFileDetailVoList":rowsIds,
                    "contractVo":$scope.contractVo,
                    "contInsuranceVo":$scope.contInsuranceVo,
                    "bizCode":$scope.origFileSortVo.bizCode,
                    "bizCodeType":$scope.origFileSortVo.bizCodeType,
                    "fileRecordNo":$scope.origFileSortVo.fileRecordNo,
                    "remark":$scope.origFileSortVo.origMemo,
                    "origVinNo":$scope.origFileSortVo.origVinNo,
                    "origEngineeNo":$scope.origFileSortVo.origEngineeNo,
                    "origMemo":$scope.origFileSortVo.origMemo,
                }
            ).success(function (data) {
                if(data.code == Response.successCode){
                    modalAlert($modal,'确认收到成功');
                    // window.location.reload();
                    $scope.getData();
                }else {
                    modalAlert($modal, data.message);
                }
            }).error(function (err) {
                modalAlert($modal,err);
            });
        }
    };
    //归档
    $scope.confirmationFiling = function () {
        console.log('vinNo', $scope.contractVo.vinNo);
        console.log('engineNo', $scope.contractVo.engineNo);

        if(!$scope.form.$invalid && $scope.contInsuranceVo.insuranceSelectInfo && $scope.contInsuranceVo.insuranceSelectInfo != null){
            if ($scope.origFileSortVo.origVinNo !== $scope.contractVo.vinNo){
                modalAlert($modal,"车架号与合同信息中车架号号不一致");
                $scope.submit = false;
                return false;
            }
            if ($scope.origFileSortVo.origEngineeNo !== $scope.contractVo.engineNo){
                modalAlert($modal,"发动机号与合同信息中发动机号不一致");
                $scope.submit = false;
                return false;
            }
            var rowsIds = $scope.dataTable.fnGetData();
            for (var x in rowsIds){
                // 是否需要归档为是
                if (rowsIds[x].origFlag == '1'){
                    //是否需要归档-是
                    //如果不是"待归档"状态，不允许进行归档操作
                    if (rowsIds[x].origFileDetailStatus !== '2' && rowsIds[x].origFileDetailStatus !== '3'){
                        modalAlert($modal, "请检查所有需要归档的文件状态");
                        return false;
                    }
                }
            }
            //附件上传check
            if($scope.notUpload){
                modalAlert($modal, "附件信息归档不完全不能归档："+$scope.notUploadInfo);
                $scope.submit = false;
                return false;
            }
            loadingOpen();
            $http.post('orig_file/origFileSort',
                {
                    "origFileDetailVoList":rowsIds,
                    "contractVo":$scope.contractVo,
                    "contInsuranceVo":$scope.contInsuranceVo,
                    "bizCode":$scope.origFileSortVo.bizCode,
                    "bizCodeType":$scope.origFileSortVo.bizCodeType,
                    "fileRecordNo":$scope.origFileSortVo.fileRecordNo,
                    "remark":$scope.origFileSortVo.origMemo,
                    "taskId":$location.search()['taskId'],
                    "origVinNo":$scope.origFileSortVo.origVinNo,
                    "origEngineeNo":$scope.origFileSortVo.origEngineeNo,
                    "origMemo":$scope.origFileSortVo.origMemo,
                }
            ).success(function (data) {
                loadingClose();
                if(data.code == Response.successCode){
                    var type = $location.search()['backType'];
                    if (type == 'archive'){
                        $location.path('/app/orig_file_archive').search({'msg':'归档成功'});
                    }else {
                        $location.path('/app/home').search({'msg':'归档成功'});
                    }
                }else {
                    modalAlert($modal, data.message);
                }
            }).error(function (err) {
                loadingClose();
                modalAlert($modal,err);
            })
        } else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };
    //返回
    $scope.goBack = function () {
        var type = $location.search()['backType'];
        if (type == 'archive'){
            $location.path('/app/orig_file_archive');
        } else {
            $location.path('/app/home');
        }
    };

    //改变投保生效日自动计算失效日
    $scope.changeStartDay = function(){
        if(isNotUndefinedNull($scope.contInsuranceVo.validStartDay) && !$scope.detail){

            var validDate = new Date($scope.contInsuranceVo.validStartDay);
            var inValidDate = new Date(validDate.setFullYear(validDate.getFullYear()+1));
            inValidDate = new Date(inValidDate.setDate(inValidDate.getDate()-1));
            var month = (inValidDate.getMonth() + 1)<10?"0"+(inValidDate.getMonth() + 1):(inValidDate.getMonth() + 1);
            var day = inValidDate.getDate()<10?"0"+inValidDate.getDate():inValidDate.getDate();
            $scope.contInsuranceVo.validEndDay = inValidDate.getFullYear() + '-' + month + '-' + day;
        }
    }

    //合同详情
    $scope.contractDetails = function () {
        var id = $scope.contractVo.contNo;
        var url = 'app.prebiz_apply_input_detail?applyNo=' + $scope.contractVo.applyNo
            + '&contNo=' +$scope.contractVo.contNo
            + '&applyType=' +$scope.contractVo.applyType
            + '&type=contract'
            + '&contractDate=' +$scope.contractVo.contractDate
            + '&bizStatus=' +$scope.contractVo.bizStatus
            + '&isTab=true';
        var title = '合同详情';
        var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
        if(window.parent.addTab){
            window.parent.addTab(html);
        }
    }

}]);


