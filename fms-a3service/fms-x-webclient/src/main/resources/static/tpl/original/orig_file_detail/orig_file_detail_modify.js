/**
 * Created by ningyangyang on 2018-05-03.
 */
app.controller('orig_file_detail_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','origFileDetailId', function ($scope, $http,$modal, $modalInstance,toaster,origFileDetailId) {

    $scope.origFileDetail={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('orig_file_detail/findOrigFileDetailByOrigFileDetailId?origFileDetailId='+ origFileDetailId).success(function(data){
        $scope.origFileDetail = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('orig_file_detail/modifyOrigFileDetail', $scope.origFileDetail).success(function (data) {
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


