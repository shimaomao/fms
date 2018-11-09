/**
 * Created by qinmuqiao on 2018-09-15.
 */
app.controller('veh_maintain_modify_controller', ['$scope', '$http','$modal','$location', function ($scope, $http,$modal,$location) {

    $scope.vehMaintain={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.httpData = true;
    $scope.notUpload = false;

    //附件对象
    $scope.bizFilesList= [];

    $http.get('veh_maintain/findVehMaintainVoByVehMaintainId?vehMaintainId='+$location.search()['vehMaintainId']).success(function(data){
        console.log(data.data);
        $scope.vehMaintain = data.data;
        $scope.vehMaintain.maintainFlagVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.maintainFlag,$scope.vehMaintain.maintainFlag)
        $scope.bizFilesList = $scope.vehMaintain.bizFilesList;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;
            $scope.vehMaintain.bizFilesList = $scope.bizFilesList;

            $http.put('veh_maintain/modifyVehMaintain', $scope.vehMaintain).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path('/app/postbiz_veh_maintain_list').search({type:'modify'});
                }

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
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(status){
        $location.path('/app/postbiz_veh_maintain_list');
    };

}]);


