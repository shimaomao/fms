/**
 * Created by yanfengbo on 2018-05-14.
 */
app.controller('cont_insur_claim_list_query_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'cont_insur_claim/findContInsurClaimsByPageSelect',
            type:"GET",
        },
        //table的html id
        dataTableId:'cont_insur_claim_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('contInsurClaimId'),
            defaultDetail('contNo','detailContInsurClaim','合同编号','20%',$compile,$scope,'contInsurClaimId'),
            {title:'客户姓名',data:'name',width:'20%'},
            {title:'车型',data:'vehicleCodeName',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'保险理赔状态',data:'insurClaimStatus',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.insurClaimStatus,data);
                }
            },
            {title:'保险公司名称',data:'insCompName',width:'20%'},
            {title:'商业险保单号',data:'insPolicyNo',width:'20%'},
            {title:'投保生效日',data:'validStartDay',width:'20%'},
            {title:'投保失效日',data:'validEndDay',width:'20%'},
            {title:'出险日期',data:'accidentTime',width:'20%'},
            {title:'报案号',data:'accidentRepno',width:'20%'},
            {title:'理赔金额',data:'claimAmount',width:'20%'},
            {title:'理赔收款开户行',data:'accBank',width:'20%'},
            {title:'理赔收款户名',data:'accountName',width:'20%'},
            {title:'理赔收款账户',data:'accountNo',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.contNo = $scope.contNo;
        params.name = $scope.name;
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
        $scope.dataTable.fnDraw(true);//刷新
    }


    //详情
    $scope.detailContInsurClaim = function(contInsurClaimId){
        $location.path('/app/postbiz_cont_insur_claim_detail').search({'frameTitle':'保险理赔详情','operate':'check','contInsurClaimId': contInsurClaimId});
    }

}])
;