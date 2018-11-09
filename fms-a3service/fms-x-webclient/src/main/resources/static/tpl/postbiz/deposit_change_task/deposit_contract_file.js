app.controller('deposit_contract_file_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {
    //文件对象
    $scope.fileValue  = {fileVos:[],fileVoUrls:[]};
    //附件对象
    $scope.depositTaskNo = $scope.$parent.depositTaskNo;
    //业务类型
    $scope.basFileTypes = $scope.$parent.basFileTypes;
    $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.depositChangeSuppleFile};


    if($scope.depositTaskNo){
        var bizCodeType = CommonCodeUtils.basFileTypes.depositChangeSuppleFile;
        $scope.fileFlag = $scope.$parent.fileFlag;
        if($scope.fileFlag){
            bizCodeType = CommonCodeUtils.basFileTypes.depositChangeContractFile;
            $scope.bizFilesList.fileType = bizCodeType;
        }
        $http.get('deposit_change_task/findBizFileByDepositTaskNo?' +
            'depositTaskNo='+$scope.depositTaskNo + '&bizCodeType=' + bizCodeType)
                .success(function (data) {
            $scope.commonBizFilesVo = data.data.body.data;
            $scope.bizFilesList.bizFilesInfo = $scope.commonBizFilesVo.bizFilesInfo;
            $scope.bizFilesList.bizFilesListVos = $scope.commonBizFilesVo.bizFilesListVos;
        })
    }
    $scope.treeFileId = 'deposit_contract_tree';
    $scope.detailFlag = 0;
}]);