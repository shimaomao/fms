

app.controller('bas_msg_handler_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {
    $scope.basMsg={};
    $scope.formValidate = false;
    $scope.submit = false;

    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    $scope.showCheck=$location.search()['operate']=='check'||false;


    if ($scope.showCheck) {
        $http.get('bas_msg/findBasMsgVoFromSysTplTypeVoByMsgId?msgId='+ $location.search()['msgId']).success(function(data){
            $scope.basMsg = data.data;
            $scope.basMsg.msgStatusName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.msgStatus,$scope.basMsg.msgStatus);
        });
    }

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('bas_msg/saveBasMsg', $scope.basMsg).success(function (data) {
                if (data.code == Response.successCode){
                    toaster_success('添加成功',toaster);
                    $location.path("app/baseinfo_bas_msg_list");
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


        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('bas_msg/modifyBasMsg', $scope.basMsg).success(function (data) {
                if (data.code == Response.successCode){
                    toaster_success('编辑成功',toaster);
                    $location.path("app/baseinfo_bas_msg_list");
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


    };
    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/baseinfo_bas_msg_list");
    };
}]);
