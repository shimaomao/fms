/**
 * Created by qiaohao on 2018/3/29.
 */
app.directive('fileListDirective',function() {
    return {
        restrict: 'E',
        templateUrl: 'tpl/common/file/file_list_directive.html',
        replace: true,
        transclude: true,
        scope: {
            files: '=files', //用户传递的附件list
            detailFlag: '=detailFlag', //是否是详情模式  0.详情模式 1.非详情模式
            fileTypePath: '=fileTypePath', //附件1级目录
            secondPath: '=secondPath' //附件2级目录
        },
        controller: function ($scope, $http, $modal, toaster, $compile, $location, $timeout) {

            $scope.fileDownloadId = "fileDownload" + $scope.$id;

            //上传附件
            $scope.uploadFiles = function(){
                var rtn = $modal.open({
                    backdrop : 'static',
                    size:'lg',
                    templateUrl: 'tpl/common/file/file_upload.html'+getCacheTime(),
                    controller: 'file_upload_controller',
                    resolve:{
                        fileTypePath: function(){return $scope.fileTypePath} ,
                        secondPath: function(){return $scope.secondPath}
                    }
                });
                rtn.result.then(function (data) {
                    if(CommonArrayUtils.isNotNullAndLengthNotZero(data)) {
                        Array.prototype.push.apply($scope.files,CommonFileUtils.getBizFiles($scope.secondPath,data));
                    }
                },function(){

                });
            }

            /**
             * 全选
             */
            $scope.selectAllFiles = function(){
                //选中状态
                if($scope.selectFiles.length != $scope.files.length) { //不是在全部选中的情况下执行
                    $scope.selectFiles = [];
                    for (var i in $scope.files) {
                        $scope.selectFiles.push($scope.files[i]);
                    }
                }else{
                    $scope.selectFiles = [];
                }
            }

            $scope.checkSelect = function(data){
                return CommonArrayUtils.isContains(data,$scope.selectFiles);
            }

            /**
             * 下载文件
             */
            $scope.downloadFiles = function(){
                if($scope.selectFiles.length > 0){

                    if($scope.selectFiles.length == 1){
                        var selectFile = $scope.selectFiles[0];
                        $("#" +$scope.fileDownloadId).append("<iframe src='file/downloadFile?fileCompletePath="+selectFile.filePath+"&fileName="+selectFile.fileName+"'></iframe>")
                    }else{
                        //获取批量下载压缩包名称
                        var zipFileName = $scope.$parent.zipFileName;
                        if(!CommonObjectUtils.isExist(zipFileName)){
                            //如果没有命名，传空字符串
                            zipFileName = '';
                        }
                        var selectFiles = [];
                        for(var i in $scope.selectFiles){
                            var selectFile = $scope.selectFiles[i];
                            selectFiles.push({fileCompletePath:selectFile.filePath,fileName:selectFile.fileName});
                        }
                        $http.post('file/filesToZip?zipFileName=' + zipFileName, selectFiles).success(function (data) {
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

            //选中的文件
            $scope.selectFiles = [];

            //点击选择文件时
            $scope.selectFileClick = function($event,id){
                var checkbox = $event.target ;
                var checked = checkbox.checked ;
                if(checked){
                    $scope.selectFiles.push(id) ;
                }else{
                    var idx = $scope.selectFiles.indexOf(id) ;
                    $scope.selectFiles.splice(idx,1) ;
                }
            } ;

            //删除文件
            $scope.deleteFiles = function(){
                if($scope.selectFiles.length > 0){
                   for(var i in $scope.selectFiles){
                       var idx = $scope.files.indexOf($scope.selectFiles[i]) ;
                       $scope.files.splice(idx,1) ;
                   }
                    $scope.selectFiles = [];
                }else{
                    modalAlert($modal, "请您选择需要删除的文件");
                }
            }

            /**
             * 打开详情文件
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
                var url = fileVo.filePath;
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
                if($scope.selectFiles.length > 0){
                    for(var i in $scope.selectFiles){
                        var selectFile = $scope.selectFiles[i];
                        arr.push(selectFile.filePath);
                    }
                    var url = '/pic.html?data=' + arr;
                    window.open(url,'_blank');
                }else {
                    modalAlert($modal,'请选择需要预览的文件');
                }
            }
        }


    }
})
