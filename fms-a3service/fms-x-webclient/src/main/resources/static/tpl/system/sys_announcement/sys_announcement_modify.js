/**
 * Created by lijunjun on 2018-04-27.
 */
app.controller('sys_announcement_modify_controller', ['$scope', '$http','$modal', 'toaster', '$location', function ($scope, $http,$modal, toaster, $location) {

    $scope.sysAnnouncement={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.formFileVos  = [];

    // 启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);
    $http.get('sys_announcement/findSysAnnouncementByAnnounceId?announceId='+ $location.search()['announceId']).success(function(data){
        $scope.sysAnnouncement = data.data;

        // 公告附件
        var list = CommonStringUtils.split('/', $scope.sysAnnouncement.announceFile);
        var fileVos = [{fileName:list[list.length - 1],fileCompletePath:$scope.sysAnnouncement.announceFile}];
        $scope.fileValue  = {fileVos:fileVos,fileVoUrls:[$scope.sysAnnouncement.announceFile]};
    });

    /**
     * 保存公告信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;

            $http.put('sys_announcement/modifySysAnnouncement', $scope.sysAnnouncement).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("app/system_sys_announcement_list").search({type:"modify"});
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
    $scope.close = function(){
        $location.path("app/system_sys_announcement_list");
    };

}]);


