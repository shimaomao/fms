/**
 * Created by ningyangyang on 2018-03-26.
 */
app.controller('home_visit_detail_controller', ['$scope', '$http','$modal','toaster','$location', '$compile','$rootScope',function ($scope, $http,$modal,toaster,$location,$compile,$rootScope) {
    $scope.detailFlag = CommonFileUtils.detailFlags.detail;

    //附件对象
    $scope.treeFileId = "homeVisitList";

    $scope.applyNo = $scope.$parent.applyNo;
    $scope.applyVisitVo = {};
    $scope.visitFlag = 1;

    if($scope.applyNo){
        $http.get('apply_input/findApplyCstmPersonByApplyNo?applyNo='+ $scope.applyNo).success(function (data) {
            $scope.applyInputVo = data.data;
            if($scope.applyInputVo.visitFlag != null){
                $scope.visitFlag = $scope.applyInputVo.visitFlag;
                $scope.applyVisitVo = $scope.applyInputVo.applyVisitVo;
                $scope.applyVisitVo.reason = $scope.applyInputVo.novisitReason;
                if($scope.applyInputVo.applyVisitVo.bizFiles){
                    // $scope.bizFilesList.bizFilesInfo = $scope.applyInputVo.applyVisitVo.bizfilesVo.bizFilesInfo;
                    // $scope.bizFilesList.bizFilesListVos = $scope.applyInputVo.applyVisitVo.bizfilesVo.bizFilesListVos;
                    $scope.applyVisitVo.bizFilesList = $scope.applyInputVo.applyVisitVo.bizFiles;
                }
            }
        });
    }






}]);
