/**
 * Created by ningyangyang on 2018-03-26.
 */
app.controller('home_visit_save_controller', ['$scope', '$http','$modal','toaster','$location', '$compile','$rootScope',function ($scope, $http,$modal,toaster,$location,$compile,$rootScope) {

    //附件对象
    $scope.treeFileId = "homeVisitList";
    
    $scope.applyNo = $scope.$parent.applyNo;
    $scope.applyVisitVo = $scope.$parent.applyVisitVo;
    $scope.visitFlag = 1;


    $scope.$watch("applyVisitVo",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal)
        $scope.$emit("applyVisitToFather",$scope.applyVisitVo);
    },true);

    $scope.$watch("visitFlag",function (newVal, oldVal) {
        $scope.$emit("visitFlagToFather",$scope.visitFlag);
    },true);


    if($scope.applyNo){
        $http.get('apply_input/findApplyCstmPersonByApplyNo?applyNo='+ $scope.applyNo).success(function (data) {
            if(data.data.applyVisitVo != null){
                $scope.applyInputVo = data.data;
                if($scope.applyInputVo.visitFlag != null){
                    $scope.visitFlag = $scope.applyInputVo.visitFlag;
                    $scope.applyVisitVo = $.extend(true,$scope.applyVisitVo,$scope.applyInputVo.applyVisitVo);
                    $scope.applyVisitVo.reason = $scope.applyInputVo.novisitReason;
                    if($scope.applyInputVo.applyVisitVo.bizFiles){
                        $scope.applyVisitVo.bizFilesList = $scope.applyInputVo.applyVisitVo.bizFiles;
                    }
                }
            }

        });
    }






}]);
