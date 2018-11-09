/**
 * Created by yanfengbo on 2018-05-14.
 */
app.controller('bas_sales_approve_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http,$modal,toaster,$location) {

    $scope.basSales={};
    $scope.httpData = true;
    //附件对象
    $scope.bizFilesList= [];
    $scope.areaName=AreaUtils.getAllAreaName();
    $scope.basSales={vehicleForm:''};
    //车辆类型list
    $scope.vehicleFormList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleForm);

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.insurClaimApproveTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.insurClaimApproveType)
    $scope.taskId = $location.search()['taskId'];
    $scope.serviceId = $location.search()['serviceId']
    init();
    function init(){
        if(isUndefinedNull($scope.serviceId)){
            modalAlert($modal,'serviceId有误');
        }else {
            $http.get('bas_sales/findBasSalesBySalesId?salesId='+$scope.salesId+'&serviceId='+$scope.serviceId).success(function(data){
                $scope.basSales = data.data;
                console.log(data.data)
                $scope.basSales.actType='0';
                $scope.basSales.salesTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.salesType,$scope.basSales.salesType);
                $scope.basSales.withinGroupName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.withinGroup,$scope.basSales.withinGroup);
                $scope.basSales.salesTaskStatusName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.salesTaskStatus,$scope.basSales.salesTaskStatus);
                //附件赋值
                $scope.bizFilesList = $scope.basSales.bizFilesList;
            })
        }
    }

    /**
     * 保存组织机构属性信息
     */

    $scope.modify = function () {
        if($scope.basSales.actType == '0'){
            $scope.url = 'bas_sales/approval';
        }else if($scope.basSales.actType == '1'){
            $scope.url = 'bas_sales/sendBack';
        }
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.basSales.taskId = $scope.taskId = $location.search()['taskId'];
            $http.put($scope.url, $scope.basSales).success(function (data) {
                if (data.code == Response.successCode){
                    if($scope.basSales.actType=="0"){
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                    }else{
                        $location.path('/app/home').search({type:'homeToastInfo', msg:'退回成功'});
                    }
                }
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
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
        $location.path('/app/home')
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.basSales;
    $scope.wfLogNo = $scope.serviceId;

}]);



