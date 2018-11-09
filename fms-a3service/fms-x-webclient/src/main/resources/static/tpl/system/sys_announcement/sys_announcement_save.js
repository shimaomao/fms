/**
 * Created by lijunjun on 2018-04-27.
 */
app.controller('sys_announcement_save_controller', ['$scope', '$http','$modal','toaster', '$location', function ($scope, $http,$modal,toaster, $location) {

    $scope.sysAnnouncement={};

    $scope.formValidate = false;

    $scope.submit = false;

    // 上传模板
    $scope.fileValue  = {fileVos:[],fileVoUrls:[]};

    // 启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);


    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            if ($scope.fileValue.fileVos.length == 0 ) {
                modalAlert($modal,'请上传公告附件');
                return;
            } else if ($scope.fileValue.fileVos.length > 1) {
                modalAlert($modal,'公告模板文件只能上传一个');
                return;
            }
            $scope.sysAnnouncement.announceFile = $scope.fileValue.fileVoUrls[0];

            $scope.submit = true;
            $http.post('sys_announcement/saveSysAnnouncement', $scope.sysAnnouncement).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("app/system_sys_announcement_list").search({type:"save"});
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


