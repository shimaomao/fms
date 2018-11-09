/**
 * Created by yangyiquan on 2018-05-31.
 */
app.controller('pilfer_insurance_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {
    //gps厂商
    $scope.gpsSellerList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gpsSeller);
    //盗抢险投保渠道
    $scope.theftInsuranceTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.theftInsuranceType);

    //添加，修改成功提示信息
    $scope.timer = $timeout(function () {
        $scope.messageType=$location.search()['messageType'];
        if($scope.messageType == 'pilferInsuranceInput'){
            toaster_success('录入成功',toaster);
        }
    }, 5);


    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'pilfer_insurance/findPilferInsurancesByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'pilfer_insurance_table',
        //table的列
        dataTableColumn: [
            {title:'操作',data:'contNo',width:'20%',render: function (data, type, row, meta) {
                var html = '<a class="a1" ng-click="inputPilferInsurance(\''+data+'\')" >录入</a>&nbsp;<a class="a1" ng-click="detailPilferInsurance(\''+data+'\')"  >详情</a>';
                return html;
            },
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    $compile(nTd)($scope);
                }},
            {title:'合同编号',data:'contNo',width:'20%'},
            {title:'申请编号',data:'applyNo',width:'20%'},
            {title:'出租人',data:'rentPerson',width:'10%'},
            {title:'承租人',data:'lessee',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},
            {title:'客户类型',data:'applyType',width:'20%',render: function (data, type, row, meta) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.applyType,data);
            }},
            {title:'业务类型',data:'licenseAttr',width:'20%',render: function (data, type, row, meta) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data);
            }},
            {title:'业务经理(录单人)',data:'applyUser',width:'20%'},
            {title:'放款日期',data:'contractValidDate',width:'20%'},
            {title:'品牌',data:'vehBrandCode',width:'20%'},
            {title:'车型',data:'vehicleCode',width:'20%'},
            {title:'实际销售方',data:'salesName',width:'20%'},
            {title:'融资期限',data:'finPeriodType',width:'20%'},
            {title:'盗抢险投保渠道',data:'theftInsuranceType',width:'20%',render: function (data, type, row, meta) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.theftInsuranceType,data);
            }},
            {title:'gps厂商',data:'gpsSeller',width:'20%',render: function (data, type, row, meta) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsSeller,data);
            }},
            {title:'第一受益人',data:'firstBeneficiary',width:'20%'},
            {title:'有线设备号',data:'wiredDeviceNo',width:'20%'},
            {title:'无线设备号',data:'wirelessDeviceNo',width:'20%'},
            {title:'新车购置价',data:'purchasePrice',width:'20%'},
            {title:'最高赔偿限额',data:'maximumCompensation',width:'20%'},
            {title:'盗抢险费用',data:'pilferInsuranceCost',width:'20%'},
            {title:'年限',data:'timeLimit',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }


    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.contNo = $scope.contNo;
        params.applyNo = $scope.applyNo;
        params.lessee = $scope.lessee;
        params.vinNo = $scope.vinNo;
        params.groupDistrict = $scope.groupDistrict;
        params.gpsSeller = $scope.gpsSeller;
        params.theftInsuranceType = $scope.theftInsuranceType;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchPilferInsurance = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetPilferInsurance = function(){
        $scope.contNo = "";
        $scope.applyNo = "";
        $scope.lessee = "";
        $scope.vinNo = "";
        $scope.groupDistrict = "";
        $scope.gpsSeller = "";
        $scope.theftInsuranceType = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.inputPilferInsurance = function(contNo){
        $location.path('/app/cost_pilfer_insurance_input').search({contNo:contNo});
    }


    $scope.detailPilferInsurance = function(contNo){

        $http.get('pilfer_insurance/findPilferInsuranceVoByContNo?contNo=' + contNo).success(function(data){
            $scope.pilferInsurance = data.data;
            if(isNotUndefinedNull($scope.pilferInsurance.pilferInsuranceId)){
                $location.path('/app/cost_pilfer_insurance_detail').search({contNo:contNo});
            }else {
                modalAlert($modal,'暂无相关信息,请先录入!');
            }
        });

    }


}])
;
