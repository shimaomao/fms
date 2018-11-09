/**
 * Created by qiaomengnan on 2018-05-25.
 */
app.controller('gps_dispatch_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {
    //gps厂商
    $scope.gpsSellerList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gpsSeller);
    //盗抢险投保渠道
    $scope.theftInsuranceTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.theftInsuranceType);
    //gps安装状态
    $scope.gpsInstallStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gpsInstallStatus);

    //添加，修改成功提示信息
    $scope.timer = $timeout(function () {
        var msg = $location.search()['msg'];
        if(CommonObjectUtils.isExist(msg)){
            toaster_success(msg,toaster);
            $location.search({msg:null});
        }
    }, 500);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'gps_dispatch/findGpsDispatchVosByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'gps_dispatch_table',
        //table的列
        dataTableColumn: [
            {title:'操作',data:'contractId',width:'20%',render: function (data, type, row, meta) {
                var html = '<a class="a1" ng-click="inputGpsDispatch(\''+row.contNo+'\','+ row.settleStatus +')" >派单</a>&nbsp;<a class="a1" ng-click="detailGpsDispatch(\''+row.contNo+'\')"  >详情</a>';
                return html;
            },
            fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                $compile(nTd)($scope);
            }},
            {title:'合同编号',data:'contNo',width:'20%'},
            {title:'申请编号',data:'applyNo',width:'20%'},
            {title:'出租人',data:'groupName',width:'10%'},
            {title:'承租人',data:'lessee',width:'20%'},
            {title:'车架号',data:'vinNo',width:'20%'},

            {title:'合同状态',data:'bizStatus',width:'20%',render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,data);
                }},

            {title:'安装状态',data:'installStatus',width:'20%',render: function (data, type, row, meta) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsInstallStatus,data);
            }},
            {title:'客户类型',data:'applyType',width:'20%',render: function (data, type, row, meta) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.applyType,data);
            }},
            {title:'业务类型',data:'licenseAttr',width:'20%',render: function (data, type, row, meta) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,data);
            }},
            {title:'gps厂商',data:'gpsSeller',width:'20%',render: function (data, type, row, meta) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsSeller,data);
            }},
            {title:'盗抢险投保渠道',data:'theftInsuranceType',width:'20%',render: function (data, type, row, meta) {
                return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.theftInsuranceType,data);
            }},
            {title:'业务经理(录单人)',data:'applyUser',width:'20%'},
            {title:'放款日期',data:'contractValidDate',width:'20%'},
            {title:'品牌',data:'vehBrandCodeName',width:'20%'},
            {title:'车型',data:'vehicleCodeName',width:'20%'},
            {title:'实际销售方',data:'salesName',width:'20%'},
            {title:'融资期限',data:'finPeriodType',width:'20%'},
            {title:'gps融资额',data:'finAmount',width:'20%'},
            {title:'安装师傅',data:'installUser',width:'20%'},
            {title:'安装师傅电话',data:'installUserMobileNo',width:'20%'},

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
        params.installStatus = $scope.installStatus;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);


    $scope.searchGpsDispatch = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetGpsDispatch = function(){
        $scope.contNo = "";
        $scope.applyNo = "";
        $scope.lessee = "";
        $scope.vinNo = "";
        $scope.groupDistrict = "";
        $scope.gpsSeller = "";
        $scope.theftInsuranceType = "";
        $scope.installStatus = "";
        $scope.dataTable.fnDraw(true);//刷新
    }


    $scope.inputGpsDispatch = function(contNo,settleStatus){
        if(CommonCodeUtils.settleStatus.monthlyKnot == settleStatus){
            modalAlert($modal, "该单已经月结,不能再次进行派单操作");
        }else{
            $location.path('/app/cost_gps_dispatch_input').search({contNo:contNo});
        }
    }

    $scope.detailGpsDispatch = function(contNo){
        $location.path('/app/cost_gps_dispatch_detail').search({contNo:contNo});
    }


}])
;