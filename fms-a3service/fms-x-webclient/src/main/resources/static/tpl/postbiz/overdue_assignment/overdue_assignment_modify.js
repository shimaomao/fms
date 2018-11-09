/**
 * Created by lijunjun on 2018-05-16.
 */
app.controller('overdue_assignment_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','overdueAssignmentId', function ($scope, $http,$modal, $modalInstance,toaster,overdueAssignmentId) {

    $scope.overdueAssignment={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('overdue_assignment/findOverdueAssignmentByOverdueAssignmentId?overdueAssignmentId='+ overdueAssignmentId).success(function(data){
        $scope.overdueAssignment = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('overdue_assignment/modifyOverdueAssignment', $scope.overdueAssignment).success(function (data) {
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


