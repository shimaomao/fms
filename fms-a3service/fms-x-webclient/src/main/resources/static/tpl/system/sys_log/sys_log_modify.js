/**
 * Created by yanfengbo on 2018-04-10.
 */
app.controller('sys_log_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','logId', function ($scope, $http,$modal, $modalInstance,toaster,logId) {

    $scope.sysLog={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('sys_log/findSysLogByLogId?logId='+ logId).success(function(data){
        $scope.sysLog = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('sys_log/modifySysLog', $scope.sysLog).success(function (data) {
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


