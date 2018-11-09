/**
 * Created by qinmuqiao on 2018-09-03.
 */
app.controller('collection_person_save_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.collectionPerson={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);
    $scope.collectionTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.assignmentType);

    //用户选择
    $scope.selectSysUser = function () {
        var rtn = $modal.open({
            backdrop: 'static',
            size: 'lg',
            templateUrl: 'tpl/system/sys_user/sys_user_list_select.html?datetime=' + getTimestamp(),
            controller: 'sys_user_list_select_controller',
            resolve: {
                // sysUserRoleCode: function(){return CommonCodeUtils.roles.riskFirst}
            }
        });
        rtn.result.then(function (data) {
            if (data != null) {
                $scope.collectionPerson.collectionPersonNum = data.user;
                $scope.collectionPerson.collectionPersonName = data.userName;
            }
        }, function () {

        });
    }

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('collection_person/saveCollectionPerson', $scope.collectionPerson).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path('app/postbiz_collection_person_list').search({type:'save'});
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
    $scope.goBack = function(){
        $location.path('app/postbiz_collection_person_list');
    };

}]);


