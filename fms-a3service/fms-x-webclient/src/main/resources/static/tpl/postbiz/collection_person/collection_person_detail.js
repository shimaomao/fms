/**
 * Created by qinmuqiao on 2018-09-03.
 */
app.controller('collection_person_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {

    $scope.collectionPerson ={};

    $scope.formValidate = false;

    $scope.submit = false;

    // 编辑用户组层级
    $http.get('collection_person/findCollectionPersonVoByCollectionPersonId?collectionPersonId='+$location.search()['collectionPersonId']).success(function(data){
        $scope.collectionPerson = data.data;
        $scope.collectionPerson.collectionTypeVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.assignmentType,$scope.collectionPerson.collectionType)
        $scope.collectionPerson.enableFlagVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.common_status,$scope.collectionPerson.enableFlag)

    });

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(status){
        $location.path('app/postbiz_collection_person_list');
    };

}]);


