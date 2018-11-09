/**
 * Created by qiaohao on 2018/3/12.
 */
app.controller('act_re_model_save_controller', ['$scope', '$http','$modal', '$modalInstance','toaster', function ($scope, $http,$modal, $modalInstance,toaster) {


    $scope.actReModel = {};

    $scope.formValidate = false;

    $scope.submit = false;

    /**
     * 保存模型信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('act_re_model/saveActReModel', $scope.actReModel).success(function (data) {
                if (data.code == Response.successCode) {
                   // window.open("modeler.html?modelId="+data.data.id);
                    $scope.close(data.data.id);

                }else
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
    $scope.close = function(modelId){
        $modalInstance.close(modelId);
    };

}]);
