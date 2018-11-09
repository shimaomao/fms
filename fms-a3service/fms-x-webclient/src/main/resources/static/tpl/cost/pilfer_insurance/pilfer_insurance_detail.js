/**
 * Created by yangyiquan on 2018-05-31.
 */
app.controller('pilfer_insurance_detail_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {
    
    $scope.pilferInsurance={};
    $scope.httpData = true;
    $scope.frameTitle=$location.search()['frameTitle'];

    // $scope.detailFlag = 0;
    //附件对象
    // $scope.treeFileId = "pilfer_insurance_table";
    // $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.pilferInsuranceFile};
    //附件对象
    $scope.bizFilesList= [];

    $http.get('pilfer_insurance/findPilferInsuranceVoByContNo?contNo=' + $location.search()['contNo']).success(function(data){
        $scope.pilferInsurance = data.data;
        $scope.pilferInsurance.gpsSellerName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.gpsSeller,$scope.pilferInsurance.gpsSeller);
        // $scope.bizFilesList.bizFilesInfo = $scope.pilferInsurance.bizfilesVo.bizFilesInfo;
        // $scope.bizFilesList.bizFilesListVos = $scope.pilferInsurance.bizfilesVo.bizFilesListVos;
        //附件赋值
        $scope.bizFilesList = $scope.pilferInsurance.bizFilesList;
    });


    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path('app/cost_pilfer_insurance_list');
    };

}]);


