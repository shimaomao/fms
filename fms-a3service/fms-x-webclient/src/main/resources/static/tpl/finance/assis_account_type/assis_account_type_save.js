/**
 * Created by ningyangyang on 2018-06-23.
 */
app.controller('assis_account_type_save_controller', ['$scope', '$http','$modal', 'toaster', '$location', function ($scope, $http, $modal, toaster, $location) {

    $scope.assisAccountType={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.assisAccountType.enableFlag="0";

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {
        $scope.correct = true;
        if($scope.assisAccountType.assisAccountType==""||
            $scope.assisAccountType.assisAccountTypeName==""||
            $scope.assisAccountType.assisAccountValue==""){
            $scope.correct = false;
        }
        if(!$scope.form.$invalid && $scope.correct) {

            $scope.submit = true;

            $http.post('assis_account_type/saveAssisAccountType', $scope.assisAccountType).success(function (data) {
                if (data.code == Response.successCode){
                    toaster_success('添加辅助核算类型成功', toaster);
                    $location.path("app/assis_account_type_list").search({type:"save"});
                } else {
                   modalAlert($modal,data.message);
                }
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
    $scope.close = function(status){
        $location.path("app/assis_account_type_list");
    };

}]);


