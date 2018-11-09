/**
 * Created by ningyangyang on 2018-07-27.
 */
app.controller('mortgage_remind_detail_controller', ['$scope', '$http','$modal', '$location', function ($scope, $http,$modal, $location) {

    $scope.mortgageRemind = {};
    $scope.formValidate = false;

    $scope.submit = false;

    $scope.httpData = true;
    $scope.notUpload = false;

    //附件对象
    $scope.bizFilesList= [];

    $scope.bizUnlockFilesList= [];

    $http.get('mortgage_remind/selectMortgageRemindVosBymorRemindId?morRemindId='+$location.search()['morRemindId']).success(function(data){
        $scope.mortgageRemind = data.data;
        $scope.mortgageRemind.mortgageStatusVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.mortgageStatus,$scope.mortgageRemind.mortgageStatus)
        $scope.bizFilesList = $scope.mortgageRemind.bizFilesList;
        $scope.bizUnlockFilesList = $scope.mortgageRemind.bizUnlockFilesList;
    });

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(status){
        $location.path('app/asset_mortgage_remind_list');
    };

}]);


