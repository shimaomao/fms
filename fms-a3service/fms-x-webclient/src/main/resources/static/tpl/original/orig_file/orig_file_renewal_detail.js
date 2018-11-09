/**
 * Created by ningyangyang on 2018/8/1.
 */
app.controller('orig_file_renewal_sort_controller', ['$scope', '$http','$modal','$compile', 'toaster','$location','$rootScope', function ($scope, $http,$modal,$compile,toaster,$location,$rootScope) {

    $scope.origFileSortVo = {};
    $scope.renewalRegisterVo = {};
    $scope.contInsuranceVo = {};
    $scope.notUpload = false;
    $scope.msgInfo = null;
    //附件对象
    //$scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.origRenewalSortFile};
    $scope.bizFilesList= [];
    //附件上传flag
    $scope.uploadFlag = $location.search()['uploadFlag'];
    $http.get("orig_file/selectOrigFileRenewalSortDetailsByPage?bizCode=" + $location.search()["bizCode"]+'&bizCodeType='+$location.search()["bizCodeType"]).success(function (data) {
        $scope.origFileSortVo = data.data;
        $scope.contInsuranceVo = data.data.contInsuranceVo;
        $scope.renewalRegisterVo = data.data.renewalRegisterVo;
        if ($scope.contInsuranceVo.insuranceType){
            $scope.insuranceSelectInfoList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes[$scope.contInsuranceVo.insuranceType]);
        }

        //附件赋值
        $scope.bizFilesList = $scope.origFileSortVo.bizFilesList;

        if(data.code == Response.successCode){
            //参数配置
            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'file_sort_list',
                //table的列
                dataTableColumn: [
                    //defaultCheckBox('bizCode'),
                    // {title:'<label class="i-checks i-checks-sm m-b-none"><input type="checkbox" name="all_checked"><i></i></label>',
                    //     data:'bizCode',
                    //     width:'3%',
                    //     render: function(data,type,row,meta){
                    //         var dataName = replaceIdData('bizCode');
                    //         var dataCheckBoxName = replaceIdData('ids','');
                    //         return '<label class="i-checks i-checks-sm m-b-none"><input type="checkbox" value="'+data+'" name="'+dataCheckBoxName+'" disabled><i></i></label>'
                    //     }
                    // },
                    {title:'续保任务号',data:'bizCode',width:'20%'},
                    {title:"合同号",data:'contNo',width:'30%'},
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
                    // {title:'是否需要归档',data:'origFlag',width:'20%',
                    //     render:function (data,type,row,meta) {
                    //         var html = "";
                    //         html+="<div class=\"radio\" ng-repeat=\"a in 'origFlag' | getList\">";
                    //         html+="<label><input type=\"radio\" ng-value=\"a.codeValue\" ng-model=\"$parent.origFlagMode"+meta.row+"\" ng-change=\"changeValue("+meta.row+")\" ng-init=\"$parent.origFlagMode"+meta.row+"="+data+"\">{{a.codeValueName}}</label>";
                    //         html+="</div>";
                    //         return html;
                    //     },
                    //     fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    //         $compile(nTd)($scope);
                    //     }
                    // },
                ],
                //列是单选还是多选 CheckBox多选 Radio单选
                dataTableSelectType: CheckBox,
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


    //附件上传
    $scope.uploadFile = function(){
        $scope.origFileSortVo.bizFilesList = $scope.bizFilesList;
        $scope.origFileSortVo.bizCode = $location.search()["bizCode"];
        $scope.origFileSortVo.bizCodeType = $location.search()["bizCodeType"];
        if($scope.notUpload){
            modalAlert($modal,$scope.notUploadInfo);
            $scope.submit = false;
            return false;
        }
        $http.post('orig_file/uploadRenewalFile',$scope.origFileSortVo).success(function(data){
            if(data.code == Response.successCode){
                $location.path('/app/orig_file_renewal_archive_list').search({'type':'submit', 'msg':'附件上传成功'});
            }else {
                modalAlert($modal, data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        })
    }

    //返回
    $scope.goBack = function () {
        $location.path('/app/orig_file_renewal_archive_list');
    };

}]);



