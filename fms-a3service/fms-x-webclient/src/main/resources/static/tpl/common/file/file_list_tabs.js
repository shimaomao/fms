/**
 * Created by qiaohao on 2018/3/29.
 */
app.controller('file_list_tabs_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','$timeout', function ($scope, $http, $modal, toaster,$compile,$location, $timeout) {


    $scope.fileVos = [];

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
        $("."+$scope.fileDownloadTextClass).html(JSON.stringify($scope.fileVos));
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
                    fileTypePath:CommonCodeUtils.fileTypePaths.bizFiles,
                    secondPath:''
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
        $("input[name=fileCheckbox]").prop('checked',!$("input[type=checkbox]").prop('checked'));
    }


    $scope.fileDownloadDivClass = "fileDownloadDiv" + Math.random().toString(8).substr(2);
    $scope.fileDownloadTextClass = "fileDownloadText" + Math.random().toString(8).substr(2);

    /**
     * 下载文件
     */
    $scope.downloadFiles = function(){
        var selectedFiles = getSelectedFiles();
        if(selectedFiles.length>0){
            for(var i in selectedFiles){
                $("."+$scope.fileDownloadDivClass).append("<iframe src='file/downloadFile?fileCompletePath="+selectedFiles[i]+"'></iframe>")
                //window.open("file/downloadFile?fileCompletePath="+selectedFiles[i]);
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
        var selectedFileObjs = $("input[type=checkbox]:checked");
        selectedFileObjs.each(function(){
            selectedFiles.push($(this).val());
        });
        return selectedFiles;
    }

    /**
     * 打开详情图片
     */
    $scope.detailFile = function(fileCompletePath){
        window.open(fileCompletePath);
    }

    /**
     * 批量预览
     */
    $scope.detailAllFile = function () {
        var arr = [];
        if($scope.fileVos != 0){
            $("input[name=fileCheckbox]").each(function (i,v) {
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

    $scope.$on('$initFileData',function(e,data){
        var cont = $("."+$scope.fileDownloadTextClass).html();
        if(CommonObjectUtils.isExist(cont))
            $scope.fileVos  = JSON.parse(cont);
    })


}])
;