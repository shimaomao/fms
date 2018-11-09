/**
 * Created by lijunjun on 2018-04-14.
 */
app.controller('cont_print_detail_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster, $compile, $location) {


    $scope.contPrintInfo = $scope.$parent.contPrintInfo;
    /*$scope.treeFileId = "cont_print_file_tree";
    $scope.bizFilesList = $scope.$parent.bizFilesList;
    $scope.detailFlag = 0;*/

    $scope.$watch('contPrintInfo.contPrintMode', function(){
        if($scope.contPrintInfo.contPrintMode == '1'){
            $scope.contPrintInfo.printSendBackReason = '';
        }
    })

    /*// 初始化获取附件信息
    if($scope.contPrintInfo.contNo){
        $http.get('cont_print/getContPrintFileList?contNo=' + $scope.contPrintInfo.contNo).success(function (data) {
            $scope.contPrintInfo.bizFilesInfo = data.data.bizFilesInfo;
            $scope.contPrintInfo.bizFilesListVos = data.data.bizFilesListVos;
            $scope.bizFilesList.bizFilesInfo = $scope.contPrintInfo.bizFilesInfo;
            $scope.bizFilesList.bizFilesListVos = $scope.contPrintInfo.bizFilesListVos;
            $scope.bizFilesList.fileType = data.data.fileType;
        });
    }*/


}]);