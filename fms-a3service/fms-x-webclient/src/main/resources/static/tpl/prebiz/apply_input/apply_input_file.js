/**
 * Created by qiaohao on 2018/4/10.
 */
app.controller('apply_input_file_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    $scope.$watch("bizFilesList",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal != oldVal)
            $scope.$emit("filesToFather",$scope.bizFilesList);
    },true);
   // $scope.fileValue  = {fileVos:[],fileVoUrls:[]};

    $scope.bizFilesList = $scope.$parent.bizFilesList;
    $scope.treeFileId = 'apply_input_tree';
    //订单编号
    $scope.applyNo = $scope.$parent.applyNo;

   //alert($scope.applyNo)
    if($scope.applyNo){
        $http.get('apply_input/findBizFileByApplyNo?applyNo='+$scope.applyNo).success(function (data) {
            console.log(data.data);
            $scope.applyInputVo = data.data;
            $scope.bizFilesList.bizFilesInfo = $scope.applyInputVo.bizfilesVo.bizFilesInfo;
            $scope.bizFilesList.bizFilesListVos = $scope.applyInputVo.bizfilesVo.bizFilesListVos;
            $scope.bizFilesList.product = $scope.applyInputVo.applyFinanceVo.product;
            $scope.product = $scope.applyInputVo.applyFinanceVo.product;
        })
    }

    // 刷新附件按钮
    // $scope.refresh = function () {
    //     // 产品方案
    //     $scope.product = $scope.$parent.financeInfo.applyFinanceVo.product;
    //     if (isUndefinedNull($scope.product)) {
    //         $scope.product = '';
    //     }
    //     $scope.bizFilesList.product = $scope.product;
    //     console.log("刷新附件上传产品方案附件：" + $scope.product);
    // };
    //
    // 监听融资信息中的产品方案是否发生变化
    $scope.$watch("$parent.financeInfo.applyFinanceVo.product",function (newVal, oldVal) {
        if (CommonObjectUtils.isExist(newVal) && newVal != oldVal) {
            refreshFileType();
        }
    });

    // 刷新附件类型
    function refreshFileType() {
        // 产品方案
        $scope.product = $scope.$parent.financeInfo.applyFinanceVo.product;
        if (isUndefinedNull($scope.product)) {
            $scope.product = '';
        }
        $scope.bizFilesList.product = $scope.product;
        console.log("刷新附件上传产品方案附件：" + $scope.product);
    }

}]);