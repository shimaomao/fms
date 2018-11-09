/**
 * Created by huchenghao on 2018/3/10.
 */

app.controller('bas_partner_handler_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {
    $scope.$on('filesToFather',function (e,data) {
        $scope.bizFilesList = data;
    });
    $scope.basPartner={partnerType:'',vehicleForm:'',remitType:'',rentType:''};

    $scope.formValidate = false;

    $scope.submit = false;
    //經銷商合作类型list
    $scope.partnerTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.partnerType);
    //车辆类型list
    $scope.vehicleFormList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleForm);
    //放款模式list
    $scope.remitTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.remitType);
    //经营牌照类型list
    $scope.rentTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr);

    //附件对象
    $scope.notUpload = false;
    $scope.notFileTypeName = "";

    // $scope.treeFileId = "tree_file_partner";
    // $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.partnerFile};
    //省份list
    $scope.provinceList=AreaUtils.getAllProvinceList();
    //修改初始化地区
    $scope.cityList ={};
    $scope.areaList={};
    $scope.changeProvince = function() {
        $scope.basPartner.partnerCity="";
        $scope.basPartner.partnerCounty="";
        if($scope.basPartner.partnerProv==undefined||$scope.basPartner.partnerProv==""){
            $scope.cityList ={};
            $scope.areaList={};
        }else{
            $scope.cityList=AreaUtils.getCityList($scope.basPartner.partnerProv);
        }
    }
    $scope.changeCity = function() {
        $scope.basPartner.partnerCounty="";
        if($scope.basPartner.partnerCity==undefined||$scope.basPartner.partnerCity==""){
            $scope.areaList={};
        }else{
            $scope.areaList=AreaUtils.getAreaList($scope.basPartner.partnerCity);
        }

    }

    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    if ($scope.showUpdate) {
        $http.get('bas_partner/findBasPartnerByPartnerId?partnerId='+ $location.search()['partnerId']).success(function(data){
            $scope.basPartner = data.data;
            $scope.cityList=AreaUtils.getCityList($scope.basPartner.partnerProv);
            $scope.areaList=AreaUtils.getAreaList($scope.basPartner.partnerCity);
            // $scope.bizFilesList.bizFilesInfo = $scope.basPartner.bizfilesVo.bizFilesInfo;
            // $scope.bizFilesList.bizFilesListVos = $scope.basPartner.bizfilesVo.bizFilesListVos;
        });

    }

    /**
     * 保存经销商信息
     */
    $scope.save = function () {
        // 上传附件信息
        // $scope.basPartner.bizfilesVo = $scope.bizFilesList;
        $scope.correct = true;
        // if($scope.basPartner.partnerType==""||
        //     $scope.basPartner.vehicleForm==""||
        //     $scope.basPartner.remitType==""||
        //     $scope.basPartner.rentType==""){
        //     $scope.correct = false;
        // }

        if($scope.notUpload){
            modalAlert($modal, "请上传" + $scope.notFileTypeName + "类型文件");
            $scope.correct = false;
        }
        if(!$scope.form.$invalid && $scope.correct) {
                         $scope.submit = true;
                         $http.post('bas_partner/saveBasPartner', $scope.basPartner).success(function (data) {
                             if (data.code == Response.successCode){
                                 console.log(data);
                                 if(data.data==1){
                                     $location.path("app/baseinfo_bas_partner_list").search({type:'saveGroup'});
                                 }else if(data.data==2){
                                     $location.path("app/baseinfo_bas_partner_list").search({type:'save'});
                                 }
                             }
                             else{
                                 modalAlert($modal,data.message);
                             }
                             $scope.submit = false;
                         }).error(function(data){
                             modalAlert($modal,data);
                             $scope.submit = false;
                         })
              }else{
                  $scope.formValidate = true;
                  toaster_info(promptInfo.submitWarn,toaster);
              }

    };

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {
        // 上传附件信息
        $scope.basPartner.bizfilesVo = $scope.bizFilesList;
            $scope.correct = true;
        if($scope.notUpload){
            modalAlert($modal, "请上传" + $scope.notFileTypeName + "类型文件");
            $scope.correct = false;
        }
              if(!$scope.form.$invalid&& $scope.correct) {
                            $scope.submit = true;
                            $http.put('bas_partner/modifyBasPartner', $scope.basPartner).success(function (data) {
                                if (data.code == Response.successCode){
                                    if(data.data==1){
                                        $location.path("app/baseinfo_bas_partner_list").search({type:'modifyGroup'});
                                    }else if(data.data==2){
                                        $location.path("app/baseinfo_bas_partner_list").search({type:'modify'});
                                    }
                                }
                                else{
                                    modalAlert($modal,data.message);
                                }

                                $scope.submit = false;
                            }).error(function(data){
                                modalAlert($modal,data);
                                $scope.submit = false;
                            })
                }else{
                  $scope.formValidate = true;
                  toaster_info(promptInfo.submitWarn,toaster);
                }

    };

    //用户选择
    $scope.selectsysUser = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_user/sys_user_list_select.html?datetime='+getTimestamp(),
            controller: 'sys_user_list_select_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.basPartner.areaManager = data.user;
                $scope.basPartner.areaManagerName = data.userName;
                $scope.basPartner.areaManagerMobno = data.userMobileNo;
            }
        },function(){

        });
    }

    //层级选择
    $scope.selectlevel = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_group_level/sys_group_level_list_select.html?datetime='+getTimestamp(),
            controller: 'sys_group_level_list_select_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.basPartner.groupLevName = data.groupLevName;
                $scope.basPartner.groupLev = data.groupLev;
            }
        },function(){

        });
    }

    //组织选择
    $scope.selectOrg = function(){
        if($scope.basPartner.partnerCode==undefined||$scope.basPartner.partnerCode==""){
            modalAlert($modal,"请输入经销商代码！");
            return;
        }
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_group/sys_group_list_select.html?datetime='+getTimestamp(),
            controller: 'sys_group_list_select_controller',
            resolve:{
                parentGroup:function () {
                    return {parentType:1, groupCode: $scope.basPartner.partnerCode};
                }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.basPartner.parentGroupName = data.groupName;
                $scope.basPartner.parentGroupCode = data.groupCode;
            }
        },function(){

        });
    }
     /**
     * 返回
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("app/baseinfo_bas_partner_list");
    };

    $scope.checkboxValue = function(name){
        $scope.form[name] = true;
        var partnerType="";
        $("input[name='"+name+"']:checked").each(function(){
            partnerType+=$(this).attr("ng-true-value")+",";
        })
        $scope.basPartner[name] = partnerType.substring(0, partnerType.length - 1);
        console.log($scope.basPartner[name])
    }

}]);