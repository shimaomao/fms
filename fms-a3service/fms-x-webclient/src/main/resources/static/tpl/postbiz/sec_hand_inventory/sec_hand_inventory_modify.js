/**
 * Created by qinmuqiao on 2018-09-19.
 */
app.controller('sec_hand_inventory_modify_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.secHandInventory={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.statusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.secHandStatus)

    $http.get('sec_hand_inventory/findSecHandInventoryVoBySecHandId?secHandId='+$location.search()['secHandId']).success(function(data){
        $scope.secHandInventory = data.data;
        $scope.secHandInventory.statusVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.secHandStatus,$scope.secHandInventory.status)
        $scope.secHandInventory.carSourceVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.secHandCarSource,$scope.secHandInventory.carSource)

    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('sec_hand_inventory/modifySecHandInventory', $scope.secHandInventory).success(function (data) {
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


    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(){
        $location.path('app/postbiz_sec_hand_inventory_list');
    };

}]);


