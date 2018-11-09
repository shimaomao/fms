/**
 * Created by huchenghao on 2018-03-26.
 */
app.controller('cont_request_pay_detail_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.contRequestPay={};

    $scope.formValidate = false;
    $scope.contRequestPay.contNo=$scope.$parent.contNo;
    //请款附件对象
    // $scope.treeFileId = "tree_file_requestPayDetail";
    // $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.requestPayFile};
    // $scope.detailFlag =0;
    $scope.submit = false;
    $http.get('cont_request_pay/findContRequestPayByContNo?contNo='+$scope.contNo).success(function (data) {
        if(data.code == Response.successCode){
            $scope.contRequestPay=data.data;

            $scope.contRequestPay.contNo=$location.search()["contNo"];
            $scope.contRequestPay.applyNo=$location.search()["applyNo"];
            $scope.contRequestPay.applyType=$location.search()["applyType"];
            $scope.contRequestPay.taskId=$location.search()["taskId"];

            // $scope.bizFilesList.bizFilesInfo = $scope.contRequestPay.bizFilesVo.bizFilesInfo;
            // $scope.bizFilesList.bizFilesListVos = $scope.contRequestPay.bizFilesVo.bizFilesListVos;
        }
    });
}]);


