/**
 * Created by yanfengbo on 2018-05-14.
 */
app.controller('cont_insur_claim_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cont_insur_claim/findContInsurClaimsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'cont_insur_claim_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contInsurClaimId'),
            defaultDetail('contNo','detailContInsurClaim','合同编号','20%',$compile,$scope,'contInsurClaimId'),
            {title:'出租人',data:'groupName',width:'20%'},
            {title:'承租人',data:'name',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'当前节点用户',data:'presentUser',width:'20%'},
            {title:'车型',data:'vehicleCodeName',width:'20%'},
            {title:'车牌号',data:'vehicleLicenseNo',width:'20%'},
            {title:'发动机号',data:'engineNo',width:'20%'},
            {title:'保险公司',data:'insCompName',width:'20%'},
            {title:'商业险保单号',data:'insPolicyNo',width:'20%'},
            {title:'当前保险年限',data:'insuranceYears',width:'20%'},
            {title:'投保生效日',data:'validStartDay',width:'20%'},
            {title:'投保失效日',data:'validEndDay',width:'20%'},
            {title:'保险理赔任务号',data:'contInsurClaimNo',width:'20%'},
            {title:'报案号',data:'accidentRepno',width:'20%'},
            {title:'理赔金额',data:'claimAmount',width:'20%'},
            {title:'申请日期',data:'insurClaimDate',width:'20%'},
            {title:'事故日期',data:'accidentTime',width:'20%'},
            {title:'保险理赔状态',data:'insurClaimStatus',width:'20%',
                render: function (data, type, row, meta) {
                    var insurClaimStatus = row.insurClaimStatus;
                    if(isNotUndefinedNull(insurClaimStatus)){
                        return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.insurClaimStatus,data);
                    }else {
                        return '待申请';
                    }
                }
            },
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: Radio
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.contNo = $scope.contNo;
        params.name = $scope.name;
        params.groupDistrict = $scope.groupDistrict;
        params.vinNo = $scope.vinNo;
        params.vehicleLicenseNo = $scope.vehicleLicenseNo;
        params.engineNo = $scope.engineNo;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchContInsurClaim = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetContInsurClaim = function(){
        $scope.contNo = "";
        $scope.name = "";
        $scope.groupDistrict = "";
        $scope.vinNo = "";
        $scope.vehicleLicenseNo = "";
        $scope.engineNo = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    //申请保险理赔
    $scope.saveContInsurClaim = function(){
        var rowsIds=$scope.dataTable.getRows()
        console.log(rowsIds)
       /* alert(JSON.stringify(rowsIds[0]))
        alert(rowsIds[0].contInsurClaimId)
        alert(rowsIds[0].validStartDay)
        alert(rowsIds[0].validEndDay)*/
        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要申请的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时申请一条数据！');
        else if( rowsIds[0].insurClaimStatus == '0504'||rowsIds[0].insurClaimStatus == '0505'||rowsIds[0].insurClaimStatus == '0507')
            modalAlert($modal,'无法操作的数据');
        else {
            //alert(JSON.stringify(new Date(rowsIds[0].validStartDay)))
            //alert(JSON.stringify(new Date(rowsIds[0].validEndDay)))
            //当前日期
            var myDate = new Date();
            //alert(JSON.stringify(myDate))
            //申请保险理赔条件：投保生效日<当日<投保失效日
            if((new Date(rowsIds[0].validStartDay)<myDate) && (myDate<new Date(rowsIds[0].validEndDay))){
                $location.path('app/insurance_cont_insur_claim_save').search({'frameTitle':'申请保险理赔','operate':'save','contNo':rowsIds[0].contNo,'contVehinsId':rowsIds[0].contVehinsId});
            }else {
                modalAlert($modal,'该条数据已过投保失效日!');
            }
        }
    }

    //详情
    $scope.detailContInsurClaim = function(contInsurClaimId){


       var data = $scope.dataTable.getRow(contInsurClaimId,"contInsurClaimId");
        if(contInsurClaimId == 'null'){
            modalAlert($modal,'本条数据无保险理赔信息！');
        }else{
            $location.path('/app/insurance_cont_insur_claim_detail').search({'frameTitle':'保险理赔详情','operate':'check','contInsurClaimId': contInsurClaimId,'contVehinsId':data.contVehinsId});
        }

    }

    //导出excel
    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.insurance,CommonServiceType.excelTypes.one,
            'cont_insur_claim/findContInsurClaimsByPageSelect2',dataTableParams($scope));
    }
}])
;