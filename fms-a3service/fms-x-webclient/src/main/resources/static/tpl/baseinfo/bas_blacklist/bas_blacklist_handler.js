/**
 * Created by yangyiquan on 2018-05-04.
 */
app.controller('bas_blacklist_handler_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    // 黑名单级别
    $scope.blackLevalList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.blackLevel);
    //来源
    $scope.sourceList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.source);

    $scope.basBlacklist={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    $scope.showCheck=$location.search()['operate']=='check'||false;


    if($scope.showUpdate){
        $http.get('bas_blacklist/findBasBlacklistByBlacklistId?blacklistId='+ $location.search()['blacklistId']).success(function(data){
            $scope.basBlacklist = data.data;
        });
    }

    /**
     * 保存黑名单信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('bas_blacklist/saveBasBlacklist', $scope.basBlacklist).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path("app/baseinfo_bas_blacklist_list").search({type:"save"});
                }

                else{
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    /**
     * 修改黑名单信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('bas_blacklist/modifyBasBlacklist', $scope.basBlacklist).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("app/baseinfo_bas_blacklist_list").search({type:"modify"});
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
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/baseinfo_bas_blacklist_list");
    };

}]);


