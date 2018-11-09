/**
 * Created by lijunjun on 2018-09-01.
 */
app.controller('contacts_change_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','contactsChangeId', function ($scope, $http,$modal, $modalInstance,toaster,contactsChangeId) {

    $scope.contactsChange={};

    $scope.formValidate = false;

    $scope.submit = false;

    $http.get('contacts_change/findContactsChangeByContactsChangeId?contactsChangeId='+ contactsChangeId).success(function(data){
        $scope.contactsChange = data.data;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('contacts_change/modifyContactsChange', $scope.contactsChange).success(function (data) {
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


