/**
 * Created by qiaomengnan on 2018-03-14.
 */
app.controller('act_user_leave_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','leaveId', function ($scope, $http,$modal, $modalInstance,toaster,leaveId) {

    $scope.actUserLeave={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('act_user_leave/findActUserLeaveByLeaveId?leaveId='+ leaveId).success(function(data){
        $scope.actUserLeave = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('act_user_leave/modifyActUserLeave', $scope.actUserLeave).success(function (data) {
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


