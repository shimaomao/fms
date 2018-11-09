/**
 * Created by qinmuqiao on 2018-09-15.
 */
app.controller('mortgage_remind_unlockImpawn_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {
    $scope.mortgageRemindVo= {};

    $scope.formValidate = false;
    $scope.submit = false;
    $scope.httpData = true;
    $scope.notUpload = false;

    //附件对象
    $scope.bizFilesList= [];
    $scope.mortgageRemindList = JSON.parse($location.search()['mortgageRemindList']);
    /**
     * 更新抵押
     */
    $scope.impawn = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            for(var i in $scope.mortgageRemindList){
                $scope.mortgageRemindVo.morRemindId = $scope.mortgageRemindList[i].morRemindId;
            }
            $scope.mortgageRemindVo.bizFilesList = $scope.bizFilesList;
            $scope.mortgageRemindVo.mortgageRemindList = $scope.mortgageRemindList;
            $scope.mortgageRemindVo.mortgageStatus = "0";
            $http.put('mortgage_remind/modifyMortgageRemind', $scope.mortgageRemindVo).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path('app/asset_mortgage_remind_list');
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
    $scope.goBack = function(status){
        $location.path('app/asset_mortgage_remind_list');
    };

}]);


