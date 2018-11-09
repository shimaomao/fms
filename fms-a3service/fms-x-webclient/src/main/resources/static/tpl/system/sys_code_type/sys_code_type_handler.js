/**
 * Created by huchenghao on 2018/3/10.
 */
app.controller('sys_code_type_handler_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    $scope.sysCodeType={};
    $scope.formValidate = false;

    $scope.sysCodeType.enableFlag = '0';
    $scope.submit = false;

    $scope.frameTitle = $location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    $scope.showDetail=$location.search()['operate']=='detail'||false;

    if ($scope.showUpdate||$scope.showDetail) {
        // 编辑和详情
        $http.get("sys_code_type/findSysCodeTypeByCodeType?codeType="+$location.search()['codeType']).success(function(data){
            $scope.sysCodeType = data.data;
            $scope.sysCodeType.enableFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,$scope.sysCodeType.enableFlag);
        });
    }
    // 启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {
        if(!$scope.form.$invalid) {
                       $scope.submit = true;
                       $http.post('sys_code_type/saveSysCodeType', $scope.sysCodeType).success(function (data) {
                           if (data.code == Response.successCode){
                               $location.path("app/system_code_type_list").search({type: 'save'});
                           }else{
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
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.put('sys_code_type/modifySysCodeType', $scope.sysCodeType).success(function (data) {
                if (data.code == Response.successCode){
                     $location.path("app/system_code_type_list").search({type: 'modify'});
                }else{
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
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/system_code_type_list");
    };

}]);