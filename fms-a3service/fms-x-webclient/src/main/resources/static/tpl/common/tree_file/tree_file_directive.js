/**
 * Created by qiaohao on 2018/6/21.
 */
app.directive('treeFileDirective',function(){
    return {
        restrict: 'E',
        templateUrl: 'tpl/common/tree_file/tree_file_directive.html',
        replace : true,
        transclude : true,
        scope:{
            files : '=files', //用户传递的附件list
            fileType : '=fileType', //用户传递的附件类型
            detailFlag : '=detailFlag', //是否是详情模式  0.详情模式 1.非详情模式
            msgInfo: '=msgInfo', //未选择附件类型提示语
            notUpload: '=notUpload', //是否存在某个必须上传的附件类型未上传 true 存在 false 不存在
            notUploadInfo: '=notUploadInfo', //未上传提示语，
            notFileType: '=notFileType', //未上传附件类型
            notFileTypeName: '=notFileTypeName', //未上传附件类型名称
            zipFileName: '=zipFileName' //批量下载时自定义的压缩包文件名
        },
        controller: function($scope, $http, $modal, toaster,$compile,$location,$timeout,$filter){
            if(CommonObjectUtils.isNotExist($scope.files)){
                $scope.files = [];
            }
            if(CommonObjectUtils.isNotExist($scope.notUpload))
                $scope.notUpload = false;
            if(CommonObjectUtils.isNotExist($scope.notUploadInfo))
                $scope.notUploadInfo = null;
            if(CommonObjectUtils.isNotExist($scope.notFileType))
                $scope.notFileType = null;
            if(CommonObjectUtils.isNotExist($scope.notFileTypeName))
                $scope.notFileTypeName = null;

            //附件树id
            $scope.treeFileId = 'treeFileId' + $scope.$id;
            //未选择附件默认提示语
            if(CommonStringUtils.isNotTrimBlank($scope.msgInfo))
                $scope.msgInfo= "请选择附件类型";
            //展示的文件
            $scope.showFiles = [];
            $scope.showFilesFlag = true;
            $scope.showFileType = null;
            //所有最后一级节点
            $scope.lastNodes = [];
            //最根级节点
            $scope.rootId = null;
            // 初始化
            $scope.init =function() {
                if(CommonStringUtils.isNotTrimBlank($scope.fileType)){
                    $http.get("bas_file_type/findFileTypeTree?fileType=" + $scope.fileType).success(function(data){
                        if(CommonObjectUtils.isExist(data.data)){
                            //所有最后一个节点
                            $scope.lastNodes = data.data['lastNodes'];
                            //为每个last node附件内容赋值
                            $scope.initLastNodes();
                            //选中第一个根节点
                            data.data['state']['selected'] = true;
                            $scope.rootId = data.data.id;
                            $scope.showFiles = getFiles(data.data.id);
                            $scope.checkFile();
                            //实例树形
                            $('#'+$scope.treeFileId).treeview({
                                data:  [data.data],
                                emptyIcon: 'glyphicon glyphicon-minus',
                                onNodeSelected: function (event, data) {
                                    if(data.lastNode){
                                        $scope.showFilesFlag = false;
                                        $scope.showFileType = data.id;
                                    }else{
                                        $scope.showFilesFlag = true;
                                        $scope.showFileType = null;
                                        $scope.showFiles = getFiles(data.id);
                                    }
                                    $scope.$apply();
                                },
                                onNodeUnselected: function (event, data){

                                }
                            });

                        }
                    });
                }
            }

            //根据文件类型获取文件列表
            function getFiles(fileType){
                var files = [];
                for (var i in $scope.lastNodes) {
                    var lastNode = $scope.lastNodes[i];
                    if(CommonObjectUtils.isExist(lastNode.parentNodes[fileType])){
                        Array.prototype.push.apply(files,lastNode.files);
                    }
                }
                return files;
            }

            function watchFiles(i){
                $scope.$watch("lastNodes["+i+"]",function(data){
                    var bizFiles = [];
                    for (var i in $scope.lastNodes) {
                        var lastNode = $scope.lastNodes[i];
                        Array.prototype.push.apply(bizFiles,lastNode.files);
                    }
                    $scope.files = bizFiles;
                },true)
            }

            //为每个last node附件内容赋值
            $scope.initLastNodes = function () {
                //为每个last node附件内容赋值
                if(CommonArrayUtils.isNotNullAndLengthNotZero($scope.lastNodes)) {
                    for (var i in $scope.lastNodes) {
                        var lastNode = $scope.lastNodes[i];
                        if(CommonArrayUtils.isNotNullAndLengthNotZero($scope.files)){
                            lastNode.files = $filter('filter')($scope.files, function (data) {
                                return data.fileType == lastNode.id;
                            });
                        }
                        if(CommonObjectUtils.isNotExist(lastNode.files))
                            lastNode.files = [];
                        watchFiles(i);
                    }
                    //$scope.$apply();
                }
            }

            $scope.$watch("files",function (n,o) {
                //如果原本的值没有内容，新值有内容，则初始化每个节点的内容
                if(CommonArrayUtils.isNullOrLengthZero(o) && CommonArrayUtils.isNotNullAndLengthNotZero(n)){
                    //为每个last node附件内容赋值
                    $scope.initLastNodes();
                    //赋值后，展示所有文件
                    $scope.showFiles = getFiles($scope.rootId);
                }
                $scope.checkFile();
            },true);

            // 初始化
            $scope.init();

            $scope.$watch("fileType",function (n,o) {
                //原本没值，现在有值了，进行初始化
                if(CommonStringUtils.isTrimBlank(o) && CommonStringUtils.isNotTrimBlank(n)){
                    // 初始化
                    $scope.init();
                } else if(n != o && CommonStringUtils.isNotTrimBlank(n)){  //新值不等于旧值，并且新值存在
                    // 初始化
                    $scope.init();
                }
            })

            $scope.checkFile = function(){
                if(CommonArrayUtils.isNotNullAndLengthNotZero($scope.lastNodes)) {
                    for (var i in $scope.lastNodes) {
                        var data = $scope.lastNodes[i];
                        if (CommonArrayUtils.isNullOrLengthZero(data.files) && data.attributes.fileChkFlag == CommonCodeUtils.yesNoFlag.yes) {
                            $scope.notUpload = true;
                            $scope.notUploadInfo = "请上传" + data.text.replace("&nbsp;<b class='form-error'>*</b>", "") + "类型的文件";
                            $scope.notFileType = data.id;
                            $scope.notFileTypeName = data.text.replace("&nbsp;<b class='form-error'>*</b>", "");
                            break;
                        } else {
                            $scope.notUpload = false;
                            $scope.notUploadInfo = null;
                            $scope.notFileType = null;
                            $scope.notFileTypeName = null;
                        }
                    }
                }else{
                    $scope.notUpload = false;
                    $scope.notUploadInfo = null;
                    $scope.notFileType = null;
                    $scope.notFileTypeName = null;
                }

            }

        }
    }
});