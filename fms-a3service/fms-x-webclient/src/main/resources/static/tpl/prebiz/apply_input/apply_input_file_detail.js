app.controller('apply_input_file_detail_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {
    //文件对象
    $scope.fileValue  = {fileVos:[],fileVoUrls:[]};
    //附件对象
    $scope.applyType = $scope.$parent.applyType;
    if($scope.applyType ==1){
        $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.perApplyFile};
    }else if($scope.applyType ==2){
        $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.compApplyFile};
    }


    $scope.applyNo = $scope.$parent.applyNo
    if($scope.applyNo){
        $http.get('apply_input/findBizFileByApplyNo?applyNo='+$scope.applyNo).success(function (data) {
            $scope.applyInputVo = data.data;
            $scope.bizFilesList.bizFilesInfo = $scope.applyInputVo.bizfilesVo.bizFilesInfo;
            $scope.bizFilesList.bizFilesListVos = $scope.applyInputVo.bizfilesVo.bizFilesListVos;
            $scope.bizFilesList.product = $scope.applyInputVo.applyFinanceVo.product;
            $scope.product = $scope.applyInputVo.applyFinanceVo.product;
        })
    }
    $scope.treeFileId = 'apply_input_tree';
    $scope.detailFlag = 0;
}]);