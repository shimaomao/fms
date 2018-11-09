/**
 * Created by yanfengbo on 2018-05-22.
 */
app.controller('car_collect_comp_save_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {
    $scope.$on('filesToFather',function (e,data) {
        $scope.bizFilesList = data;
    });

    $scope.carCollectComp={};

    $scope.formValidate = false;

    $scope.submit = false;

    //附件对象
    $scope.treeFileId = "tree_file_car_collect_comp";
    $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.carCollectCompFile};

    //省份list
    $scope.provinceList=AreaUtils.getAllProvinceList();
    //修改初始化地区
    $scope.cityList ={};
    $scope.areaList={};
    $scope.changeProvince = function() {
        $scope.carCollectComp.addrCity="";
        $scope.carCollectComp.addrCounty="";
        if($scope.carCollectComp.addrProv==undefined||$scope.carCollectComp.addrProv==""){
            $scope.cityList ={};
            $scope.areaList={};
        }else{
            $scope.cityList=AreaUtils.getCityList($scope.carCollectComp.addrProv);
        }
    }
    $scope.changeCity = function() {
        $scope.carCollectComp.addrCounty="";
        if($scope.carCollectComp.addrCity==undefined||$scope.carCollectComp.addrCity==""){
            $scope.areaList={};
        }else{
            $scope.areaList=AreaUtils.getAreaList($scope.carCollectComp.addrCity);
        }

    }

    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    $scope.showCheck=$location.search()['operate']=='check'||false;


    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {
        // 上传附件信息
        $scope.carCollectComp.bizfilesVo = $scope.bizFilesList;

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('car_collect_comp/saveCarCollectComp', $scope.carCollectComp).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("app/postbiz_car_collect_comp_list").search({messageType:'saveCarCollectComp'});
                else
                    modalAlert($modal,data.message);
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }


    }

    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/postbiz_car_collect_comp_list");
    };

}]);


