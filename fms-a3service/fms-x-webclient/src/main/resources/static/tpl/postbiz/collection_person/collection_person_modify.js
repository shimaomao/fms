/**
 * Created by qinmuqiao on 2018-09-03.
 */
app.controller('collection_person_modify_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.collectionPerson ={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag)
    $scope.collectionList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.assignmentType)

    // 编辑用户组层级
    $http.get('collection_person/findCollectionPersonVoByCollectionPersonId?collectionPersonId='+$location.search()['collectionPersonId']).success(function(data){
        $scope.collectionPerson = data.data;
    });

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
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('collection_person/modifyCollectionPerson', $scope.collectionPerson).success(function (data) {
                if (data.code == Response.successCode){
                    // $scope.close(Response.successMark);
                    $location.path('app/postbiz_collection_person_list').search({type:'modify'});
                    // $scope.goBack();
                }

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


