app.controller('risk_audit_person_save_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster, $compile, $location) {
    $scope.riskData = {};
    $scope.disabled = $scope.$parent.disabled;
    $scope.detailFlag = $scope.$parent.detailFlag;
    $scope.applyNo = $scope.$parent.applyNo;
    $scope.applyType = $scope.$parent.applyType;
    $scope.isRiskTel = 0;

    if($scope.detailFlag == 1){
        $scope.detailFlag = 0;
    }else{
        $scope.detailFlag = 1;
    }
    //附件对象
    $scope.bizFilesList = [];
    $scope.fileInfo = {
        notUpload: false,
        notUploadInfo: '',
        notFileType: '',
        notFileTypeName:''
    };

    $scope.$on('riskDataToSon',function (e,data) {
    $scope.riskData = data;
    if($scope.riskData.bizFilesList){
        $scope.bizFilesList = $scope.riskData.bizFilesList;
    }
});

    $scope.$watch('riskData',function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal){
            $scope.$emit("riskDataToFather",$scope.riskData);
        }
    },true);

    $scope.$watch('fileInfo',function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal){
            $scope.$emit("fileInfoToFather",$scope.fileInfo);
        }
    },true);



    $scope.$watch('bizFilesList',function (newVal,oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal){
            $scope.riskData.bizFilesList = $scope.bizFilesList;
        }
    },true);

    //百度/天眼查
    $scope.telCheck = function (type) {
        if(type == 1){
            window.open("https://www.baidu.com/",'_blank');
        }else{
            window.open("https://www.tianyancha.com/",'_blank');
        }
    };

    //电核备注
    $scope.setRiskTelMenoData = function (memo) {
        if($scope.riskData.riskTelchkVoList){
            var length = $scope.riskData.riskTelchkVoList.length;
            for(var i=0;i<length;i++){
                $scope.riskData.riskTelchkVoList[i].memo = memo;
            }
        }
    };
}]);