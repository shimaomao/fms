/**
 * Created by yanfengbo on 2018-10-25.
 */
app.controller('transfer_info_retreats_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout','setData', function ($scope, $http, $modal, toaster,$compile,$location,$timeout,setData) {
    //查询参数
    $scope.params = setData.getter();

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'transfer_info/findTransferInfoRetreatsVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'transfer_info_retreats_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contNo'),
            defaultDetail('contNo','detailTransferInfo','合同号','20%',$compile,$scope,'contNo'),
            {title:'承租人',data:'cstmName',width:'20%'},
            {title:'出租人',data:'belongGroup',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'过户状态',data:'transferSts',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.transferSts,data);
                }
            },
            {title:'结清状态',data:'paymentSts',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.paymentSts,data);
                }
            },
            {title:'合同生效日期',data:'contractValidDate',width:'20%'},
            {title:'车牌号',data:'vehicleLicenseNo',width:'20%'},
            {title:'发动机号',data:'engineNo',width:'20%'},
            {title:'保险处置方式',data:'insurancDealType',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.insurancDealType,data);
                }
            },
            {title:'保险公司名称',data:'insCompName',width:'20%'},
            {title:'商业险保单号',data:'insPolicyNo',width:'20%'},
            {title:'投保生效日',data:'validStartDay',width:'20%'},
            {title:'投保失效日',data:'validEndDay',width:'20%'},
            {title:'保单实际金额',data:'insFee',width:'20%'},
            {title:'过户退保处理状态',data:'retreatsHandleSts',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data);
                }
            },
            {title:'当前节点用户',data:'retreatsPresentUser',width:'20%'},

        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope){
        var params = $scope.params;
        setData.setter(params);
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchTransferInfo = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetTransferInfo = function(){
        $scope.params = {};
        $scope.dataTable.fnDraw(true);//刷新
    };

    // 过户退保申请
    $scope.accountRefundApply = function (){
        var rowIds = $scope.dataTable.getRows();
        if (rowIds.length < 1){
            modalAlert($modal,'请选择需要操作的数据');
        } else {
            var contNo = rowIds[0].contNo;// 合同编号
            $http.get('transfer_info/findTransferInfoByContNo?contNo='+ contNo).success(function (result) {
                if(result.code == Response.successCode) {
                    var data = result.data;
                    if (data.retreatsHandleSts != null) {
                        modalAlert($modal,"过户退保申请已提交，不可重复发起");
                    } else {
                        // 跳转到过户申请页面
                        $location.path('/app/postbiz_surrender_charge_apply').search({'contNo':contNo, 'transferNo': rowIds[0].transferNo});
                    }
                }else{
                    modalAlert($modal,result.message);
                }
            }).error(function (err) {
                modalAlert($modal,err);
            });

        }
    };

    // 查看详情
    $scope.detailTransferInfo = function (contNo) {
        var data = $scope.dataTable.getRow(contNo,'contNo');
        if (data != null) {
            if(isNotUndefinedNull(data.retreatsNo))
                $location.path('/app/postbiz_surrender_charge_detail').search({'contNo':data.contNo, 'retreatsNo': data.retreatsNo});
            else
                modalAlert($modal,"本条合同还未发起过户退保申请");
        }
    }

}])
