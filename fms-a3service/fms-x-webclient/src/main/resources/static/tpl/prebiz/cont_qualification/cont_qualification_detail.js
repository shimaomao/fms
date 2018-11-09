/**
 * Created by lijunjun on 2018-04-14.
 */
app.controller('cont_qualification_detail_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster, $compile, $location) {


    $scope.contQualificationVo = $scope.$parent.contQualificationVo;
    $scope.treeFileId = "cont_qualification_file_tree";
    $scope.bizFilesList = $scope.$parent.bizFilesList;
    $scope.detailFlag = 0;

    $scope.$watch('contQualificationVo.contQualificationMode', function(){
        if($scope.contQualificationVo.contQualificationMode == '1'){
            $scope.contQualificationVo.backReason = '';
        }
    })

    // 初始化获取附件信息
    if($scope.contQualificationVo.contNo){
        $http.get('cont_print/getContPrintFileList?contNo=' + $scope.contQualificationVo.contNo).success(function (data) {
            $scope.contQualificationVo.bizFilesInfo = data.data.bizFilesInfo;
            $scope.contQualificationVo.bizFilesListVos = data.data.bizFilesListVos;
            $scope.bizFilesList.bizFilesInfo = $scope.contQualificationVo.bizFilesInfo;
            $scope.bizFilesList.bizFilesListVos = $scope.contQualificationVo.bizFilesListVos;
            $scope.bizFilesList.fileType = data.data.fileType;
        });
    }


}]);