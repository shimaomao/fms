/**
 * Created by qiaohao on 2018/4/10.
 */
app.controller('deposit_supple_upload_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    //操作分类列表
    $scope.contRequestPayActTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.contRequestPayActType);
    //附件对象
    $scope.treeFileId = "deposit_supple_tree";

    $scope.suppleUploadVo = $scope.$parent.suppleUploadVo;


    $scope.$watch("suppleUploadVo",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal)
            $scope.$emit("suppleUploadToFather",$scope.suppleUploadVo);
    },true);

}]);