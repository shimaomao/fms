/**
 * Created by wubaoliang on 2018-03-12.
 */
app.controller('sys_tpl_item_add_controller', ['$scope', '$http','$modal', '$modalInstance','toaster', function ($scope, $http,$modal, $modalInstance,toaster) {

    $scope.sysTplItem={};

    $scope.formValidate = false;

    $scope.submit = false;


    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.close($scope.sysTplItem);
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


