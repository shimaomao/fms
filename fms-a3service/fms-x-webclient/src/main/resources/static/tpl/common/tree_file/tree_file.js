/**
 * Created by qiaohao on 2018/4/10.
 */
app.controller('tree_file_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    /**
     * 附件控件需要使用到的信息
     * bizFilesList 整体对象
     * bizFilesInfo { basFileTypeValue:{fileVos:[]} }  保存具体的文件信息
     * basFileTypeValue 附件类型  fileVos 附件类型下的具体文件
     */
    $scope.bizFilesList = $scope.$parent.bizFilesList;
    $scope.treeFileId = $scope.$parent.treeFileId;
    $scope.validate = { uploadFileValidate:0 , uploadFileValidateInfo:'请选择附件类型' };

    $scope.detailFlag = $scope.$parent.detailFlag;

    function FileValue(fileVos,basFileTypeValue){
        this.fileVos = fileVos;
        this.basFileTypeValue = basFileTypeValue;
        this.deleteFileVos=[];
    }

    $scope.fileValue = new FileValue([]);

    //保存一级树形类型,上传附件时，不可选择一级树形和不选树形
    $scope.basFileType = null;

    //附件上传类型
    $scope.fileTypePath = CommonCodeUtils.fileTypePaths.bizFiles;

    //保存真实的附件类型
    $scope.basFileTypeValue = null;

    // 产品方案发生变化时
    $scope.$watch('$parent.product',function(){
        if(CommonObjectUtils.isExist($scope.$parent.product))
            init();
    });
    $scope.$watch('$parent.bizFilesList.fileType',function(){
        init();
    });

    // 初始化
    function init() {
        var url = "bas_file_type/findFileTypeTree?fileType=" + $scope.bizFilesList.fileType;
        // 产品方案
        if (isNotUndefinedNull($scope.$parent.product) && $scope.$parent.product != '') {
            url += '&product=' + $scope.$parent.product;
        }
        console.log("取得附件类型树的URL：" + url);
        if($scope.bizFilesList.fileType){
            $http.get(url).success(function(data){

                //<b class="form-error">*</b>  attributes fileChkFlag
                var nodes = data.data['nodes'];
                // for(var i in nodes){
                //     if(CommonObjectUtils.isExist(nodes[i]['attributes'])) {
                //         var fileChkFlag = nodes[i]['attributes']['fileChkFlag'];
                //         if (fileChkFlag == CommonCodeUtils.yesNoFlag.yes)
                //             nodes[i]['text'] = nodes[i]['text'] + '&nbsp;<b class="form-error">*</b>';
                //     }
                // }

                //一级树形类型
                $scope.basFileType = data.data.id;

                var treeData = [];
                treeData.push(data.data);
                if(CommonArrayUtils.isNotNullAndLengthNotZero(data.data['nodes'])){
                    //data.data['nodes'][0]['state']['selected'] = true;
                    data.data['state']['selected'] = true;
                    $scope.basFileTypeValue = data.data['id'];
                }
                $('#'+$scope.treeFileId).treeview({
                    data: treeData,
                    emptyIcon: 'glyphicon glyphicon-minus',
                    onNodeSelected: function (event, data) {
                        $scope.basFileTypeValue = data.id;
                        $scope.$apply();
                    },
                    onNodeUnselected: function (event, data){
                        $scope.basFileTypeValue = null;
                        $scope.$apply();
                    }
                });
            });
        }

    }

    // 初始化
    init();

    $scope.$watch("basFileTypeValue",function(data){
        if(CommonObjectUtils.isExist(data)){
            if($scope.basFileType ==  $scope.basFileTypeValue){
                //附件属性不能为第一级
                $scope.validate.uploadFileValidate = 1;
                //如果为第一级 则显示所有的子附件
                $scope.fileValue =  $scope.bizFilesList.bizFilesInfo[$scope.basFileType];
            }else if($scope.basFileTypeValue == null){
                //附件属性不能为空
                $scope.validate.uploadFileValidate = 1;
            }else{
                //正常
                $scope.validate.uploadFileValidate = 0;

                if(CommonObjectUtils.isNotExist($scope.bizFilesList.bizFilesInfo[$scope.basFileTypeValue])){
                    $scope.bizFilesList.bizFilesInfo[$scope.basFileTypeValue]  = new FileValue([],$scope.basFileTypeValue);
                }
                $scope.fileValue = $scope.bizFilesList.bizFilesInfo[$scope.basFileTypeValue];
            }
            $scope.uploadFileValidate = $scope.bizFilesList.uploadFileValidate;
        }

    });

    //监听文件
    $scope.$watch("fileValue.fileVos.length",function(){


        if(CommonObjectUtils.isExist($scope.fileValue)){
            //判断是否有被删除的文件,如果有,则需要进行处理
            if(CommonObjectUtils.isExist($scope.fileValue.deleteFileVos)
                && $scope.fileValue.deleteFileVos.length > 0 ){
                for(var key in $scope.bizFilesList.bizFilesInfo){
                    if(CommonObjectUtils.isExist(key) && key != $scope.basFileType) {
                        var result = CommonFileUtils.deleteFileVosByVos($scope.fileValue.deleteFileVos, $scope.bizFilesList.bizFilesInfo[key].fileVos);
                        if(result != null){
                            $scope.bizFilesList.bizFilesInfo[key].fileVos = result;
                        }
                    }
                }
                $scope.fileValue.deleteFileVos = [];
            }

            var bizFilesListVos = [];
            var fileVos = [];
            for(var key in $scope.bizFilesList.bizFilesInfo){
                if(CommonObjectUtils.isExist(key) && key != $scope.basFileType) {
                    bizFilesListVos.push($scope.bizFilesList.bizFilesInfo[key]);
                    Array.prototype.push.apply(fileVos, $scope.bizFilesList.bizFilesInfo[key].fileVos);
                }
            }
            //总父级保存所有文件
            $scope.bizFilesList.bizFilesInfo[$scope.basFileType] =  new FileValue(fileVos,$scope.basFileType);
            //所有文件list
            $scope.bizFilesList.bizFilesListVos = bizFilesListVos;
        }


    });

}]);