/**
 * Created by ningyangyang on 2018-09-10.
 */
app.controller('change_lessee_task_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','taskId', function ($scope, $http,$modal, $modalInstance,toaster,taskId) {

    $scope.changeLesseeTask={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('change_lessee_task/findChangeLesseeTaskByTaskId?taskId='+ taskId).success(function(data){
        $scope.changeLesseeTask = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('change_lessee_task/modifyChangeLesseeTask', $scope.changeLesseeTask).success(function (data) {
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


