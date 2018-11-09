/**
 * Created by huchenghao on 2018/3/10.
 */

app.controller('bas_partner_detail_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    $scope.basPartner={partnerType:'',vehicleForm:'',remitType:'',rentType:''};

    $scope.formValidate = false;

    $scope.submit = false;
    //經銷商合作类型list
    $scope.partnerTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.parentType);
    //车辆类型list
    $scope.vehicleFormList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleForm);
    //放款模式list
    $scope.remitTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.remitType);
    //经营牌照类型list
    $scope.rentTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr);
    
    $scope.areaName=AreaUtils.getAllAreaName();

    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.detailFlag = 0;
    //请款附件对象
    // $scope.treeFileId = "tree_file_partner";
    // $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.partnerFile};

     $http.get('bas_partner/findBasPartnerByPartnerId?partnerId='+ $location.search()['partnerId']).success(function(data){
            $scope.basPartner = data.data;
            // $scope.bizFilesList.bizFilesInfo = $scope.basPartner.bizfilesVo.bizFilesInfo;
            // $scope.bizFilesList.bizFilesListVos = $scope.basPartner.bizfilesVo.bizFilesListVos;
        });

     /**
     * 返回
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("app/baseinfo_bas_partner_list");
    };

}]);