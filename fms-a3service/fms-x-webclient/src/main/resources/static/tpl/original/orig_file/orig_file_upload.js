app.controller('orig_file_upload_controller', ['$scope', '$http','$modal','$compile','$location', function ($scope, $http,$modal,$compile,$location) {

    $scope.origFileMailVo = {};
    $scope.submit = false;
    $scope.formValidate = false;
    $scope.origFileMailVo.taskId = $location.search()['taskId'];
    $scope.origFileMailVo.borrowTaskNo = $location.search()['serviceId'];
    $scope.origFileMailVo.bizCode = $location.search()['bizCode'];
    $scope.origFileObj = $location.search()['origFileObj'];
    // $scope.origFileMailVo.bizCodeType = $location.search()['bizCodeType'];
    $scope.fileType = $location.search()['origFileType'];
    $scope.detail = $location.search()['detail'];
    //区分上传按钮来源是原件归档还是归档邮寄与上传
    $scope.uploadSourceFlag = $location.search()['uploadSourceFlag'];
    $scope.httpData = false;
    //附件对象
    console.log('origFileType',$location.search()['origFileType']);
    $scope.treeFileId = "orig_file_upload_file_tree";
    $http.get('biz_files/findBizFilesList?bizCode='+$location.search()['bizCode'] +'&bizCodeType='+$location.search()['origFileType']).success(function (data) {
        if (data.code == Response.successCode){
            //附件赋值
            $scope.bizFilesList = data.data;
            $scope.httpData = true;
        }else {
            modalAlert($modal, data.message);
        }
    });

    $scope.notUpload = false;
    $scope.msgInfo = null;
    //提交
    $scope.submit = function () {
        $scope.submit = true;
        $scope.origFileMailVo.bizCodeType = $location.search()['origFileType'];
        $scope.origFileMailVo.bizFilesList = $scope.bizFilesList;
        console.log('bizfilesVo',$scope.origFileMailVo.bizfilesVo);
        //附件上传可以暂存
        // if($scope.notUpload){
        //     modalAlert($modal, $scope.msgInfo);
        // }else{
            $http.post('orig_file/origFileUpload',$scope.origFileMailVo).success(function (data) {
                if(data.code == Response.successCode){
                    if($scope.uploadSourceFlag ==2){
                        $location.path("app/orig_file_archive").search({"type": 'submit', "msg":'资料上传成功'});
                    }else {
                        $location.path("app/orig_file_archive_list").search({"type": 'submit', "msg":'资料上传成功'});
                    }
                }else {
                    modalAlert($modal, data.message);
                }
                $scope.submit = false;
            }).error(function (err) {
                modalAlert($modal,err);
            });
        // }

    };

    //返回
    $scope.backUp= function () {
        if($scope.uploadSourceFlag ==2){
            $location.path("app/orig_file_archive");
        }else {
            $location.path("app/orig_file_archive_list");
        }
    };
}]);


