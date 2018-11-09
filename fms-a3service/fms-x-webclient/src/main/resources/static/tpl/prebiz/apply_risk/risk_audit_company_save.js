app.controller('risk_audit_company_save_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster, $compile, $location) {
    //附件对象
    $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.applyRiskApproveFile, product:''};
    $scope.treeFileId = "riskAudit";
    $scope.$on('riskDataToSon',function (e,data) {
        $scope.riskData = data;
        if($scope.riskData.bizFilesVo){
            $scope.bizFilesList.bizFilesInfo = $scope.riskData.bizFilesVo.bizFilesInfo;
            $scope.bizFilesList.bizFilesListVos = $scope.riskData.bizFilesVo.bizFilesListVos;
        }
    });

    $scope.$watch('riskData',function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal){
            $scope.$emit("riskDataToFather",$scope.riskData);
        }
    },true);



    $scope.$watch('bizFilesList',function (newVal,oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal){
            $scope.riskData.bizFilesVo = $scope.bizFilesList;
        }
    },true);
}]);