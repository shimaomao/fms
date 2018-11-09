/**
 * Created by ningyangyang on 2018-07-27.
 */
app.controller('mortgage_remind_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','morRemindId', function ($scope, $http,$modal, $modalInstance,toaster,morRemindId) {

    $scope.mortgageRemind={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('mortgage_remind/findMortgageRemindByMorRemindId?morRemindId='+ morRemindId).success(function(data){
        $scope.mortgageRemind = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('mortgage_remind/modifyMortgageRemind', $scope.mortgageRemind).success(function (data) {
                if (data.code == Response.successCode)
                    $scope.close(Response.successMark);
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
    $scope.close = function(status){
        $modalInstance.close(status);
    };

}]);


