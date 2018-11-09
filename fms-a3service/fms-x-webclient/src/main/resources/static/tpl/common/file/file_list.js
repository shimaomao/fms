/**
 * Created by qiaohao on 2018/3/29.
 */
app.controller('file_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location, $timeout) {

    $scope.fileVos = [];

    $scope.pageId = 'fileList' + $scope.$id;

    $scope.fileDownloadId = 'fileDownload' + $scope.$id;

    if(CommonObjectUtils.isExist( $scope.$parent.fileValue)) {
        $scope.fileVos = $scope.$parent.fileValue.fileVos;
    }
    var flag = false;
    // $timeout(function () {
    //      $scope.fileVos = $scope.$parent.fileValue.fileVos;
    // },500);
    $scope.$watch('$parent.fileValue',function(){
        if(CommonObjectUtils.isExist( $scope.$parent.fileValue)){
            flag = true;
            $scope.fileVos = $scope.$parent.fileValue.fileVos;
        }
    });

    $scope.$watch('fileVos.length',function(){
        if(CommonObjectUtils.isExist( $scope.$parent.fileValue)) {
            if(flag){
                $scope.$parent.fileValue.fileVos = $scope.fileVos;
                $scope.$parent.fileValue.fileVoUrls = CommonFileUtils.getFileVoUrls($scope.fileVos);
            }
        }
    });

    function getFileVoUrls(){
        var fileVoUrls = [];
        for(var i in $scope.fileVos){
            fileVoUrls.push($scope.fileVos[i]['fileCompletePath']);
        }
        return fileVoUrls;
    }

    $scope.uploadFiles = function(){
        if(CommonObjectUtils.isExist($scope.$parent.validate) && $scope.$parent.validate.uploadFileValidate == 1){
            modalAlert($modal,$scope.$parent.validate.uploadFileValidateInfo);
        }else{

            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/common/file/file_upload.html'+getCacheTime(),
                controller: 'file_upload_controller',
                resolve:{
                    fileTypePath: function(){return $scope.$parent.fileTypePath} ,
                    secondPath: function(){return $scope.$parent.basFileTypeValue}
                }
            });
            rtn.result.then(function (data) {
                if(CommonObjectUtils.isExist(data)) {
                    Array.prototype.push.apply($scope.fileVos,data);
                }
            },function(){

            });
        }
    }

    /**
     * 选择文件
     */
    $scope.selectFiles = function(){
        $("#" + $scope.pageId + " input[name=fileCheckbox]").prop('checked',!$("#" + $scope.pageId + " input[type=checkbox]").prop('checked'));
    }

    /**
     * 下载文件
     */
    $scope.downloadFiles = function(){
        var selectedFiles = getSelectedFileObjList();
        if(selectedFiles.length>0){
            if(selectedFiles.length == 1){
                var selectFile = selectedFiles[0];
                $("#" +$scope.fileDownloadId).append("<iframe src='file/downloadFile?fileCompletePath="+selectFile.fileCompletePath+"&fileName="+selectFile.fileName+"'></iframe>")
            }else{
                $http.post('file/filesToZip', selectedFiles).success(function (data) {
                    if (data.code == Response.successCode) {
                        $("#" +$scope.fileDownloadId).append("<iframe src='file/downloadFile?fileCompletePath="+data.data+"'></iframe>")
                    } else
                        modalAlert($modal, data.message);
                }).error(function (data) {
                    modalAlert($modal, data);
                })
            }
        }else{
            modalAlert($modal,'请选择需要下载的文件');
        }
    }

    /**
     * 删除文件
     */
    $scope.deleteFiles = function(){
        var selectedFiles = getSelectedFiles();
        var deleteFileVos = [];
        if(selectedFiles.length>0){
            var existFileObjs = [];
            for(var j in $scope.fileVos){
                var result = true;
                for(var i in selectedFiles){
                    if( selectedFiles[i] == $scope.fileVos[j]['fileCompletePath'] ){
                        deleteFileVos.push($scope.fileVos[j]);
                        result = false;
                    }
                }
                if(result){
                    existFileObjs.push($scope.fileVos[j]);
                }
            }
            $scope.fileVos = existFileObjs;

            //将本次删除的文件,赋值给fileValue，用作删除通知
            if(CommonObjectUtils.isExist( $scope.$parent.fileValue)) {
                $scope.$parent.fileValue.deleteFileVos = deleteFileVos;
            }


        }else{
            modalAlert($modal,'请选择需要删除的文件');
        }
    }

    /**
     * 获得选中文件
     */
    function getSelectedFiles(){
        var selectedFiles = [];
        var selectedFileObjs = $("#" + $scope.pageId + " input[type=checkbox]:checked");
        selectedFileObjs.each(function(){
            selectedFiles.push($(this).val());
        });
        return selectedFiles;
    }

    /**
     * 获得选中文件
     */
    function getSelectedFileObjList(){
        var selectedFiles = [];
        var selectedFileObjs = $("#" + $scope.pageId + " input[type=checkbox]:checked");
        selectedFileObjs.each(function(){
            selectedFiles.push({fileCompletePath:$(this).val(),fileName:$(this).attr("data")});
        });
        return selectedFiles;
    }


    /**
     * 打开详情图片
     */
    $scope.detailFile = function(fileCompletePath){
        if(/\.(gif|jpg|jpeg|png|GIF|JPG|PNG|pdf|PDF)$/.test(fileCompletePath)){
            window.open(fileCompletePath);
        }else{
            modalAlert($modal,"该文件不可预览");
        }
    }

    //双击查看图片
    $scope.dbDetailFile = function (fileVo) {
        var url = fileVo.fileCompletePath;
        if(/\.(gif|jpg|jpeg|png|GIF|JPG|PNG|pdf|PDF)$/.test(url)){
            window.open(url);
        }else{
            modalAlert($modal,"该文件不可预览");
        }
    }

    /**
     * 批量预览
     */
    $scope.detailAllFile = function () {
        var arr = [];
        if($scope.fileVos != 0){
            $("#" + $scope.pageId + " input[name=fileCheckbox]").each(function (i,v) {
                var isChecked = $(v).is(':checked');
                if(isChecked){
                    arr.push($scope.fileVos[i].fileCompletePath);
                }
            });
            if(arr.length != 0){
                var url = '/pic.html?data=' + arr;
                window.open(url,'_blank');
            }else{
                modalAlert($modal,'请选择文件');
            }
        }else {
            modalAlert($modal,'没有文件，请上传');
        }

    }
}])
;