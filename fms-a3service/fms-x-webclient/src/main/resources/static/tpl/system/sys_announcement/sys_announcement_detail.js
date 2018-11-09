/**
 * Created by lijunjun on 2018-04-27.
 */
app.controller('sys_announcement_detail_controller', ['$scope', '$http','$modal', '$location', function ($scope, $http,$modal, $location) {

    $scope.sysAnnouncement={};
    $scope.detailFlag = 0;
    $scope.status = $location.search()['status'];

    $http.get('sys_announcement/findSysAnnouncementByAnnounceId?announceId='+ $location.search()['announceId']).success(function(data){
        $scope.sysAnnouncement = data.data;
        $scope.sysAnnouncement.enableFlag = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,$scope.sysAnnouncement.enableFlag);

        // 公告附件
        var list = CommonStringUtils.split('/', $scope.sysAnnouncement.announceFile);
        var fileVos = [{fileName:list[list.length - 1],fileCompletePath:$scope.sysAnnouncement.announceFile}];
        $scope.fileValue  = {fileVos:fileVos,fileVoUrls:[$scope.sysAnnouncement.announceFile]};
    });

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        if($scope.status == "home"){
            $location.path("app/home");
        } else {
            $location.path("app/system_sys_announcement_list").search({'status':$scope.status});
        }
    };

}]);


