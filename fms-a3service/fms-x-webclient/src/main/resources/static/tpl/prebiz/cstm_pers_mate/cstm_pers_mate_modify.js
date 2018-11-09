/**
 * Created by ningyangyang on 2018-03-26.
 */
app.controller('cstm_pers_mate_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','persMateId', function ($scope, $http,$modal, $modalInstance,toaster,persMateId) {

    $scope.cstmPersMate={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('cstm_pers_mate/findCstmPersMateByPersMateId?persMateId='+ persMateId).success(function(data){
        $scope.cstmPersMate = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('cstm_pers_mate/modifyCstmPersMate', $scope.cstmPersMate).success(function (data) {
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


