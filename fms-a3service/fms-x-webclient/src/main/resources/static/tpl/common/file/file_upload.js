/**
 * Created by qiaohao on 2018/3/23.
 */
app.controller('file_upload_controller', ['$scope', '$http', '$modal','$modalInstance', 'fileTypePath','secondPath', function ($scope, $http, $modal,$modalInstance, fileTypePath,secondPath) {

    $scope.filePageId = "filePage" + $scope.$id;

    $scope.fileZhId = "fileZh" + $scope.$id;

    $scope.images = [];

    function getFileZhId() {
        return "#" +  $scope.fileZhId;
    }

    var initialPreviewConfigs = function(){
        var data = [];
        for(var i in $scope.images){
            data.push({caption:$scope.images[i].fileOriginalName, width: "100px", height: "160px", url: '/file/deleteFile', key: i});
        }
        return data;
    }

    var getImageUrls = function(){
        var data = [];
        for(var i in $scope.images){
            data.push($scope.images[i].fileCompletePath);
        }
        return data;
    }

    $scope.initFileInput = function(){
        $(getFileZhId()).fileinput({
            //语言
            language: 'zh',
            //上传url
            uploadUrl: '/file/uploadFiles',
            //可以上传的文件类型
            allowedFileExtensions : ['jpg', 'png','gif','xls','xlsx','doc','docx','pdf'],
            //最大上传数量
            maxFileCount: 10,
            //false是同步上传
            uploadAsync: false,

            showUpload:false, //是否显示上传按钮
            showRemove :false, //显示移除按钮
            //设置预览大小
            previewSettings: {
                image: {width: "100px", height: "100px"},
            },
            //初始化时显示的图片
            overwriteInitial: false,
            initialPreviewAsData: true,
            initialPreview: getImageUrls(),
            initialPreviewConfig:initialPreviewConfigs(),
            uploadExtraData:function(){
                var data={};
                if(CommonObjectUtils.isExist(fileTypePath))
                    data.fileTypePath = fileTypePath;
                if(CommonObjectUtils.isExist(secondPath))
                    data.secondPath = secondPath;
                return data;
            }
            // otherActionButtons:'<input type="checkbox">'

        }).on("filebatchuploadsuccess",function(event, data,previewId, index) {
            if(data.response.code == Response.successCode){
                Array.prototype.push.apply($scope.images,data.response.data);
                uploadFileAuto();
            }
            setTimeout(function(){
                $(getFileZhId()).unbind();
                $(getFileZhId()).fileinput('destroy');
                $scope.initFileInput();
            },10);
        }).on("filebatchuploaderror",function(event, data) {
            //上传失败
            console.log("出错了")
        }).on("filedeleted",function(event,data){
            $scope.images.splice(data,1);
        }).on("filesuccessremove",function(event,data){
            //alert("123");
        }).on("fileuploaded", function(event, data, previewId, index) {
            if(data.response.code == Response.successCode){
                Array.prototype.push.apply($scope.images,data.response.data);
                uploadFileAuto();
            }
            setTimeout(function(){
                $(getFileZhId()).unbind();
                $(getFileZhId()).fileinput('destroy');
                $scope.initFileInput();
            },10);
        });
    };


    function uploadFileAuto() {
        var display = $("#" + $scope.filePageId + ' .fileinput-upload-button').css('display');
        if($scope.images.length != 0 && display == 'inline-block'){
            //已经上传文件,但还有部分未上传
            modalAlert($modal,"您还有文件未上传");
        } else if($scope.images.length == 0 && display == 'inline-block'){
            //选中了文件但没有上传，没有上传文件
            modalAlert($modal,"您还有文件未上传");
        } else if( $scope.images.length == 0 && display != 'inline-block'){
            //没有选择文件
            modalAlert($modal,"请您选择需要上传的文件");
        } else{
            $modalInstance.close($scope.images);
        }
    }

    $scope.save = function(){
        $(getFileZhId()).fileinput("upload");
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };

    setTimeout(function(){
        $scope.initFileInput();
    });


}])
;