/**
 * Created by qiaomengnan on 2018-05-30.
 */
app.controller('equ_mor_detail_apply_controller', ['$scope', '$http','$modal','toaster','$location','$compile',function ($scope, $http,$modal,toaster,$location,$compile) {

    $scope.equMorDetail={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.equMorDetailIds = $location.search()['Ids'];
    $scope.equMorDetail.differenceCount = 0
    //文件对象
    $scope.fileValue  = {fileVos:[],fileVoUrls:[]};


    //附件对象
    $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.mortgageRelFile};

    $scope.detailFlag = CommonFileUtils.detailFlags.upload;

    $scope.treeFileId = "relief_file_tree";

    $scope.equRelTaskNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];

    init();
    function init(){
        if(isNotUndefinedNull($scope.taskId)){
            $scope.url = 'equ_mor_detail/findEquMorDetailVoList?equRelTaskNo='+$scope.equRelTaskNo
        }else{
            $scope.url = 'equ_mor_detail/find' +
                'EquMorDetailVos?equMorDetailIds='+$scope.equMorDetailIds
        }
        $http.get($scope.url).success(function (data) {
            if(isNotUndefinedNull($scope.taskId)){
                console.log(data.data)
                $scope.equMorDetail = data.data;
                // $scope.bizFilesList.bizFilesInfo = $scope.equMorDetail.commonBizFilesVo.bizFilesInfo;
                // $scope.bizFilesList.bizFilesListVos = $scope.equMorDetail.commonBizFilesVo.bizFilesListVos;
                $scope.equMorDetail.bizFilesVoList = $scope.equMorDetail.bizFilesList
                $scope.list = data.data.equMorDetailVoList;
                $scope.flag = false;
                if($scope.equMorDetail.differenceCount<=0){
                    $scope.flag = false;
                }else{
                    $scope.flag = true;
                }
            }else{
                $scope.list = data.data;
            }


            $scope.equMorDetail.reliefDifference = 0;
            //参数配置
            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'equ_mor_detail_table',
                //table的列
                dataTableColumn: [
                    //defaultDetail('equMorTaskNo','detailEquMorDetail','资方抵押任务号','20%',$compile,$scope),
                    {title:'出租人',data:'lessor',width:'20%'},
                    {title:'承租人',data:'lessee',width:'20%'},
                    {title:'车牌号',data:'vehicleLicenseNo',width:'20%'},
                    {title:'车架号',data:'vinNo',width:'20%'},
                    {title:'合同编号',data:'mainContNo',width:'20%'},
                    {title:'业务类型',data:'serviceType',width:'20%',
                        render:function(data){
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data)
                        }
                    },
                    {title:'融资期限',data:'finPeriodType',width:'20%'},
                    {title:'经销商',data:'salesName',width:'20%'},
                    {title:'应收金额(元)',data:'reliefReceivAmount',width:'20%',
                     render:function(data, type, row, meta){
                         var showData = data;
                         if(!data){
                             showData = 0;
                         }
                         var html = "<input type=\"number\" limit-number class=\"form-control m-b-xs\" ng-change=\"getSum(reliefReceivAmount_"+meta.row+","+meta.row+",'reliefReceivAmount')\" ng-model=\"reliefReceivAmount_"+meta.row+"\" ng-init=\"reliefReceivAmount_"+meta.row+"="+showData+"\" required>";
                         return html;

                    },
                     fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                            $compile(nTd)($scope);
                        }
                    },
                    {title:'违约金(元)',data:'reliefPenalty',width:'20%',
                        render:function(data, type, row, meta){
                            var showData = data;
                            if(!data){
                                showData = 0;
                            }
                            var html = "<input type=\"number\" limit-number class=\"form-control m-b-xs\" ng-change=\"getSum(reliefPenalty_"+meta.row+","+meta.row+",'reliefPenalty')\" ng-model=\"reliefPenalty_"+meta.row+"\" ng-init=\"reliefPenalty_"+meta.row+"="+showData+"\" required>";
                            //var html = '<input type="text" class="form-control m-b-xs" ng-change="getSum()" ng-model="reliefPenalty">'
                            return html;
                        },
                        fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                            $compile(nTd)($scope);
                        }
                    },
                    {title:'剩余本金(元)',data:'reliefRestPrincipal',width:'20%',
                        render:function(data, type, row, meta){
                            var showData = data;
                            if(!data){
                                showData = 0;
                            }
                            var html = "<input type=\"number\" limit-number class=\"form-control m-b-xs\" ng-change=\"getSum(reliefRestPrincipal_"+meta.row+","+meta.row+",'reliefRestPrincipal')\" ng-model=\"reliefRestPrincipal_"+meta.row+"\" ng-init=\"reliefRestPrincipal_"+meta.row+"="+showData+"\" required>";

                            //var html = '<input type="text" class="form-control m-b-xs" ng-change="getSum()" ng-model="reliefRestPrincipal">'
                            return html;
                        },
                        fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                            $compile(nTd)($scope);
                        }
                    },
                    {title:'其他费用(元)',data:'reliefOtherCharge',width:'20%',
                        render:function(data, type, row, meta){
                            var showData = data;
                            if(!data){
                                showData = 0;
                            }
                            var html = "<input type=\"number\" limit-number class=\"form-control m-b-xs\" ng-change=\"getSum(reliefOtherCharge_"+meta.row+","+meta.row+",'reliefOtherCharge')\" ng-model=\"reliefOtherCharge_"+meta.row+"\" ng-init=\"reliefOtherCharge_"+meta.row+"="+showData+"\" required>";
                            //var html = '<input type="text" class="form-control m-b-xs" ng-change="getSum()" ng-model="reliefOtherCharge">'
                            return html;
                        },
                        fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                            $compile(nTd)($scope);
                        }
                    },
                    {title:'差额(元)',data:'reliefDifference',width:'20%',
                        render:function(data, type, row, meta){
                            var showData = data;
                            if(!data){
                                showData = 0;
                            }
                            var html = "<input type=\"text\" class=\"form-control m-b-xs\" ng-model=\"reliefDifference_"+meta.row+"\" ng-init=\"reliefDifference_"+meta.row+"="+showData+"\" disabled required>";
                            // var html = '<input type="text" class="form-control m-b-xs"  ng-model="reliefDifference" disabled>'
                            return html;
                        },
                        fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                            $compile(nTd)($scope);
                        }
                    },
                ],
                dataTableData:$scope.list,
            }

            //创建dataTable
            $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties,$scope);

        })
    }
    //开户行
   // $scope.openingBankList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.openingBank);

    $scope.getSum = function(a,meta,name){
        var nTr = $scope.dataTable.fnGetData();
        var total = 0;
        nTr[meta][name] = a;

        var name1 = 'reliefReceivAmount_' + meta;
        var name2 = 'reliefPenalty_' + meta;
        var name3 = 'reliefRestPrincipal_' + meta;
        var name4 = 'reliefOtherCharge_' + meta;
        var name5 = 'reliefDifference_' + meta;

        $scope[name5] = $scope[name1]*1 - $scope[name2]*1 - $scope[name3]*1 - $scope[name4]*1;
        nTr[meta]['reliefDifference'] = $scope[name5];
        for(var i=0;i<nTr.length;i++){
            if(nTr[i].reliefDifference && nTr[i].reliefDifference!= null){
                total+=nTr[i].reliefDifference*1;
            }
        }

        $scope.equMorDetail.differenceCount=total;

        $scope.flag = false;
        if($scope.equMorDetail.differenceCount<=0){
            $scope.flag = false;
        }else{
            $scope.flag = true;
        }
        // $scope.reliefDifference = $scope.reliefReceivAmount - $scope.reliefPenalty - $scope.reliefRestPrincipal - $scope.reliefOtherCharge;
        // $scope.myVar = $scope.reliefDifference;
    }

    //选择银行信息
    $scope.selectBasBankInfo = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_bank_info_select_controller',
            resolve:{
                selectBank:function () {
                    return { organizationType:CommonCodeUtils.organizationType.mortgages}
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.equMorDetail.openingBank = data.accBankName;
                $scope.equMorDetail.accountName = data.accountName;
                $scope.equMorDetail.accountNo = data.accountNo;
                $scope.equMorDetail.bankCode = data.eleAccountNo;
                $scope.equMorDetail.recAccBranch = data.accBranchBank;
            }
        },function(){
        });
    }

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {
        if(!$scope.form.$invalid){
            if(isNotUndefinedNull($scope.taskId)){
                $scope.urls = 'equ_mor_detail/modifyEquMorDetail'
            }else{
                $scope.urls = 'equ_mor_detail/applyEquMorDetail'
            }
            $scope.submit = true;
            $scope.equMorDetail.equMorDetailVoList = $scope.dataTable.fnGetData();
            //$scope.equMorDetail.commonBizFilesVo = $scope.bizFilesList;
            $scope.equMorDetail.equRelTaskNo = $scope.equRelTaskNo;
            $scope.equMorDetail.taskId = $scope.taskId;
            if($scope.equMorDetail.notUpload){
                modalAlert($modal,"请上传附件");
                $scope.submit = false;
                return false;
            }
            if($scope.equMorDetail.equMorDetailVoList.length == 0){
                modalAlert($modal,"failure");
                $scope.submit = false;
                return false;
            }
                    $http.put($scope.urls,$scope.equMorDetail).success(function(data){
                        if (data.code == Response.successCode){
                            //modalAlert($modal, '解抵押申请成功');
                            if(isNotUndefinedNull($scope.taskId)){
                                $location.path('app/home').search({"type": 'homeToastInfo', "msg":'资方解抵押申请成功'});
                            }
                            else
                                $location.path('/app/asset_equ_mor_detail_list').search({"type": 'homeToastInfo', "msg":'资方解抵押申请成功'});
                        }else{
                            modalAlert($modal, data.message);
                            $scope.submit = false;
                        }
                    })



        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }


    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goback = function(){
        if(isNotUndefinedNull($scope.taskId)){
            $location.path('app/home');
        }
        else
        $location.path('/app/asset_equ_mor_detail_list');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.relief;
    $scope.wfLogNo = $scope.equRelTaskNo;
}]);


