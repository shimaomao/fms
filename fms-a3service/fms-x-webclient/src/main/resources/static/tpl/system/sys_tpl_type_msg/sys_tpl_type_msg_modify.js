/**
 * Created by wubaoliang on 2018-03-12.
 */
app.controller('sys_tpl_type_msg_modify_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.sysTplType={};

    $scope.formValidate = false;

    $scope.submit = false;

    // 取得模板类型信息
    $http.get('sys_tpl_type/findSysTplTypeVoByTplTypeId?tplTypeId='+ $location.search()['tplTypeId']).success(function(data){
        $scope.sysTplType = data.data;
        $scope.tplItemList = $scope.sysTplType.tplItemList;
    });

    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $scope.sysTplType.tplItemList = $scope.tplItemList;
            $http.put('sys_tpl_type/modifySysTplType', $scope.sysTplType).success(function (data) {
                if (data.code == Response.successCode) {
                    // toaster_success('编辑短信模板类型信息成功', toaster);
                    $location.path("app/system_sys_tpl_type_msg_list").search({type: 'modify'});
                } else {
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

    // 添加项目
    $scope.addItem = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_tpl_item/sys_tpl_item_add.html'+getCacheTime(),
            controller: 'sys_tpl_item_add_controller',
            resolve:{
            }
        });
        rtn.result.then(function (status) {
            if(status != null) {
                status.tplItemId = new Date().toString();
                $scope.tplItemList.push(status);
            }
        },function(){
        });
    };

    // 删除项目
    $scope.deleteItem = function (tplItemId) {
        if ($scope.tplItemList.length > 0) {
            var arry = [];
            for (var i = 0; i < $scope.tplItemList.length; i++) {
                if (tplItemId != $scope.tplItemList[i].tplItemId) {
                    arry.push($scope.tplItemList[i]);
                }
            }
            $scope.tplItemList = arry;
        }
    };

    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(status){
        $location.path("app/system_sys_tpl_type_msg_list");
    };

}]);


