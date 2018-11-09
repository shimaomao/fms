/**
 * Created by yangyiquan on 2018-05-18.
 */
app.controller('mortgage_register_modify_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.mortgageRegister={};
    $scope.contVehicleFinance={};
    $scope.contNo = $location.search()['contNo'];

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('contract_vehicle/findContractVehicleFinanceVoByContNo?contNo='+ $scope.contNo).success(function(data){
        $scope.contVehicleFinance = data.data;
        $scope.bizStatus = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizStatus,$scope.contVehicleFinance.bizStatus);
        $scope.licenseAttr = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,$scope.contVehicleFinance.licenseAttr);
        $scope.vehicleForm = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.vehicleForm,$scope.contVehicleFinance.vehicleForm);

        $scope.mortgageRegister.insCompName = $scope.contVehicleFinance.insCompName;
        $scope.mortgageRegister.insPolicyNo = $scope.contVehicleFinance.insPolicyNo;
        $scope.mortgageRegister.contNo = $scope.contVehicleFinance.contNo;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('mortgage_register/saveMortgageRegister', $scope.mortgageRegister).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path("app/asset_mortgage_register_list").search({'type': 'mortgage'});
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
     * 返回
     * @param status
     */
    $scope.goBack = function(){
        $location.path("app/asset_mortgage_register_list").search({});
    };



}]);


