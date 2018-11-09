/**
 * Created by yangyiquan on 2018-05-10.
 */
app.controller('cont_prepayment_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {

    //还款状态
    $scope.paymentStsList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.paymentSts);
    if($location.search()['type'] == 'save'){
        toaster_info("保存成功！",toaster);
    }else if($location.search()['type'] == 'cancel') {
        toaster_info("取消成功！",toaster);
    }
    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cont_prepayment/findContPrepaymentListByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'cont_prepayment_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contPrepaymentNo'),
            {title:'合同编号',data:'contNo',width:'10%'},
            defaultDetail('contPrepaymentNo','detailContPrepayment','提前还款任务号','20%',$compile,$scope,'contPrepaymentNo'),
            {title:'出租人',data:'rentPerson',width:'10%'},
            {title:'承租人',data:'name',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'产品方案',data:'productName',width:'20%'},
            {title:'每期租金',data:'rent',width:'20%'},
            {title:'车型',data:'vehicleCodeName',width:'20%'},
            {title:'合同生效日期',data:'contractValidDate',width:'20%'},
            {title:'还款状态',data:'paymentStsForSer',width:'10%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.paymentSts,data);
                }
            },
            {title:'提前还款状态',data:'prepaymentSts',width:'20%',
                render: function (data, type, row, meta) {
                    if(!data){
                        return "";
                    }
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data);
                }
            },
            {title:'当前节点用户',data:'presentUser',width:'20%'},
            {title:'提前还款日期',data:'prepaymentDate',width:'20%',
                render: function (data, type, row, meta) {
                    if(!row.prepaymentSts){
                        return "";
                    }
                    return data;
                }},

        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    };

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.contNo = $scope.contNo;
        params.name = $scope.name;
        params.groupDistrict = $scope.groupDistrict;
        params.vinNo = $scope.vinNo;
        params.paymentStsForSer = $scope.paymentSts;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchContPrepayment = function(){
        $scope.dataTable.fnDraw(true);
    };

    $scope.resetContPrepayment = function(){
        $scope.contNo = "";
        $scope.name = "";
        $scope.groupDistrict = "";
        $scope.vinNo = "";
        $scope.paymentSts = "";
        $scope.dataTable.fnDraw(true);//刷新
    };


    $scope.saveContPrepayment = function(){
        var rows = $scope.dataTable.getRows();
        if(rows && rows.length == 1) {
            var contPrepayment =  rows[0];
            if(contPrepayment.contPrepaymentNo && contPrepayment.prepaymentSts != CommonCodeUtils.codeValues.contPrepaymentInvalid){
                modalAlert($modal,'已申请过提前还款！');
                return;
            }
            var repayDay = contPrepayment.repayDay*1;
            var nowDay = new Date().getDate();
            if(nowDay && nowDay*1 == repayDay){
                modalAlert($modal,'还款日当天不能申请提前还款！');
                return;
            }

            $location.path('/app/cost_cont_prepayment_modify').search({
                'operate':'save',
                'contNo': contPrepayment.contNo,
                'detail':true
            });
        }else{
            modalAlert($modal,'请您选择需要修改的数据！');
        }
    };
    //查看提前还款明细
    $scope.detailContPrepayment = function(contPrepaymentNo){
        if(!contPrepaymentNo){
            modalAlert($modal,'未申请提前还款，无法查看！');
            return;
        }
        $location.path('/app/cost_cont_prepayment_modify').search({
            'operate':'show',
            'contPrepaymentNo':contPrepaymentNo
        });
    };

    $scope.cancel = function(){
        var rows = $scope.dataTable.getRows();
        if(rows && rows.length == 1) {
            var contPrepayment =  rows[0];
            if(!contPrepayment.contPrepaymentNo){
                modalAlert($modal,'未申请提前还款！');
                return;
            }
            if(contPrepayment.prepaymentSts == CommonCodeUtils.codeValues.contPrepaymentInvalid){
                modalAlert($modal,'提前还款已失效！');
                return;
            }
            if(contPrepayment.prepaymentSts == CommonCodeUtils.codeValues.contPrepaymentValid){
                modalAlert($modal,'提前还款已生效！');
                return;
            }

            $location.path('/app/cost_cont_prepayment_cancel').search({
                'contPrepaymentNo':contPrepayment.contPrepaymentNo
            });
        }else{
            modalAlert($modal,'请选择一条提前还款！');
        }
    };

    //试算
    $scope.preCount = function(){
        var rows = $scope.dataTable.getRows();
        if(rows && rows.length == 1) {
            var contPrepayment =  rows[0];
            var repayDay = contPrepayment.repayDay*1;
            var nowDay = new Date().getDate();
            if(nowDay && nowDay*1 == repayDay){
                modalAlert($modal,'还款日当天不能申请提前还款！');
                return;
            }

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/cost/cont_prepayment/cont_prepayment_try_count.html?datetime='+getTimestamp(),
                controller: 'cont_prepayment_try_count_controller',
                resolve:{
                    contData: function () {
                        return contPrepayment.contNo;
                    }
                }
            });
            rtn.result.then(function (data) {

            },function(){
            });

            /*$location.path('/app/cost_cont_prepayment_modify').search({
                'operate':'save',
                'contNo': contPrepayment.contNo,
                'detail':true
            });*/
        }else{
            modalAlert($modal,'请您选择需要试算的数据！');
        }
    };

    /**
     * 打印结清证明
     */
    $scope.printJQZM = function () {
        var rows = $scope.dataTable.getRows();
        if(rows && rows.length == 1) {
            var contPrepayment =  rows[0];
            if(contPrepayment.prepaymentSts != CommonCodeUtils.codeValues.prepaymentStsEnd){
                modalAlert($modal,'请选择提前还款已生效的数据！');
                return;
            }
            CommonFileUtils.downloadFileGet('cont_prepayment/printPrepaymentJQZM',{contPrepaymentNo : contPrepayment.contPrepaymentNo}
                ,$http,$modal,$scope);
        }else{
            modalAlert($modal,'请您选择需要打印的数据！');
        }
    };

}])
;