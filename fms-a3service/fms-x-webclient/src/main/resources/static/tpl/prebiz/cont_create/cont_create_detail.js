/**
 * Created by huchenghao on 2018-03-26.
 */
app.controller('cont_create_detail_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {
    $scope.contCreate={};
    $scope.fileInfo2 = {
        notUpload: false,
        notUploadInfo: '',
        notFileType: '',
        notFileTypeName:''
    };
    $scope.formValidate = false;
    $scope.contCreate.contNo=$scope.$parent.contNo;
    $scope.submit = false;
    // $scope.detailFlag = 0;
    // $scope.treeFileId = "tree_file_contCreate";

    //附件对象
    $scope.bizFilesList = {bizFilesInfo:{}};
    $http.get('cont_create/findContCreateDetailByContNo?contNo='+$scope.contCreate.contNo).success(function (data) {
        if(data.code == Response.successCode){
            $scope.contCreate=data.data;
            $scope.contCreate.accBank=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.openingBank,data.data.accBank);
            //定金是否抵扣车款
            $scope.contCreate.deductibleFeesName=CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.deductibleFees,data.data.deductibleFees);
            // $scope.bizFilesList.bizFilesInfo = data.data.bizFilesVo.bizFilesInfo;
            // $scope.bizFilesList.bizFilesListVos = data.data.bizFilesVo.bizFilesListVos;
            // $scope.bizFilesList.fileType = data.data.bizFilesVo.fileType;
            $scope.fileType = $scope.contCreate.fileType;
        }
});

}]);


