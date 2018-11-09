/**
 * Created by qinmuqiao on 2018-09-19.
 */
app.controller('sec_hand_inventory_save_controller', ['$scope', '$http','$modal','$location','toaster', function ($scope, $http,$modal, $location,toaster) {

    $scope.secHandInventory={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.statusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.secHandStatus)

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('sec_hand_inventory/saveSecHandInventory', $scope.secHandInventory).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path('app/postbiz_sec_hand_inventory_list').search({type:'save'});
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

    // 选择车型
    $scope.selectBasVehicle = function () {
        var basVehicle = {};
        basVehicle.vehicleLevel = '4';// 级别  4-车型
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_vehicle/bas_vehicle_list_select.html'+getCacheTime(),
            controller: 'bas_vehicle_list_select_controller',
            resolve:{
                basVehicle: function () { return basVehicle;}
            }
        });
        rtn.result.then(function (status) {
            if(isNotUndefinedNull(status)) {
                $scope.secHandInventory.vehicleCode = status.vehicleCode;
                $scope.secHandInventory.vehicleName = status.vehicleName;
            }
        },function(){
        });
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(){
        $location.path('app/postbiz_sec_hand_inventory_list');
    };

}]);


