/**
 * Created by ningyangyang on 2018/6/5.
 */
/**
 * Created by ningyangyang on 2018-05-30.
 * 复核
 */
app.controller('equ_mor_detail_receipt_controller', ['$scope', '$http','$modal','toaster','$location','$compile',function ($scope, $http,$modal,toaster,$location,$compile) {

    $scope.equMorDetail={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.equRelTaskNo = $location.search()['serviceId'];
    $scope.taskId = $location.search()['taskId'];
    //$scope.DifferenceCount = 0;

    $scope.equMorDetailVoList = []

    //文件对象
    $scope.fileValue  = {fileVos:[],fileVoUrls:[]};

    //附件对象
    $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.mortgageRelFile};

    $scope.detailFlag = CommonFileUtils.detailFlags.detail;

    $scope.treeFileId = "relief_file_tree";

    init();
    function init(){
        $http.get('equ_mor_detail/findEquMorDetailVoList?equRelTaskNo='+$scope.equRelTaskNo).success(function (data) {
            $scope.equMorDetail = data.data;
            //参数配置
            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'equ_mor_detail_table',
                //table的列
                dataTableColumn: [
                    //defaultDetail('equMorTaskNo','detailEquMorDetail','资方抵押任务号','20%',$compile,$scope),
                    {title:'合同编号',data:'mainContNo',width:'20%'},
                    {title:'出租人',data:'lessor',width:'20%'},
                    {title:'承租人',data:'lessee',width:'20%'},
                    {title:'车牌号',data:'vehicleLicenseNo',width:'20%'},
                    {title:'车架号',data:'vinNo',width:'20%'},
                    {title:'应收金额(元)',data:'reliefReceivAmount',width:'20%'},
                    {title:'违约金(元)',data:'reliefPenalty',width:'20%'},
                    {title:'剩余本金(元)',data:'reliefRestPrincipal',width:'20%'},
                    {title:'其他费用(元)',data:'reliefOtherCharge',width:'20%'},
                    {title:'差额(元)',data:'reliefDifference',width:'20%'},
                ],
                dataTableData:data.data.equMorDetailVoList,
            }

            //创建dataTable
            $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties,$scope);
        })
    }
    //开户行
    //$scope.openingBankList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.openingBank);
    //增加银行信息
    $scope.add = function () {
        var obj = {
            openingBank:'',
            accountName:'',
            accountNo:'',
            bankCode:'',
            receiptAmount:0,
            memo:'',
            receiptDate:getToday()
        };
        $scope.equMorDetailVoList.push(obj);
    };
    //删除银行信息
    $scope.del = function (index) {
        $scope.equMorDetailVoList.splice(index,1);
    };
    //选择银行信息
    $scope.selectBasBankInfo = function(index){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_bank_info/bas_bank_info_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_bank_info_select_controller',
            resolve:{
                selectBank:function () {
                    return { organizationType:CommonCodeUtils.organizationType.userGroup}
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.equMorDetailVoList[index].openingBank = data.accBankName;
                $scope.equMorDetailVoList[index].accountName = data.accountName;
                $scope.equMorDetailVoList[index].accountNo = data.accountNo;
                $scope.equMorDetailVoList[index].bankCode = data.eleAccountNo;
                $scope.equMorDetailVoList[index].recAccBranch = data.accBranchBank;
            }
        },function(){
        });
    }

    /**
     * 审核通过
     */
    $scope.save = function () {
        if(!$scope.form.$invalid){
            $scope.submit = true;
            $scope.equMorDetail.equRelTaskNo = $scope.equRelTaskNo;
            $scope.equMorDetail.taskId = $scope.taskId;
            $scope.equMorDetail.equMorDetailVoList = $scope.equMorDetailVoList
            if($scope.equMorDetailVoList.length==0){
                modalAlert($modal, '请选择收款银行');
                $scope.submit = false;
                return false;
            }

            $http.put('equ_mor_detail/approvalReceipt',$scope.equMorDetail).success(function(data) {
                if (data.code == Response.successCode){
                   // modalAlert($modal,'财务确认收款成功');
                    $location.path("app/home").search({"type": 'homeToastInfo', "msg":'财务确认收款成功'});
                }else
                    modalAlert($modal, data.message);
            })
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    }

    /**
     * 退回上一级
     */
    $scope.sendBack = function () {
            $scope.submit = true;
            $scope.equMorDetail.equRelTaskNo = $scope.equRelTaskNo;
            $scope.equMorDetail.taskId = $scope.taskId;
            if(isUndefinedNull($scope.equMorDetail.remark1)){
                modalAlert($modal,'请输入备注');
                $scope.submit = false;
                return false;
            }
            $http.put('equ_mor_detail/sendBack',$scope.equMorDetail).success(function(data) {
                if (data.code == Response.successCode){
                    //modalAlert($modal, '退回成功')
                    $location.path("app/home").search({"type": 'homeToastInfo', "msg":'退回成功'});
                }else{
                    modalAlert($modal, data.message);
                    $scope.submit = false;
                }

            })
    }




    /**
     * 关闭窗口
     * @param status
     */
    $scope.goback = function(){
        $location.path('app/home');
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.relief;
    $scope.wfLogNo = $scope.equRelTaskNo;
}]);


