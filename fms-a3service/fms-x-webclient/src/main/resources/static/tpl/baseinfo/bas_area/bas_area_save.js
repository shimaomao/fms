/**
 * Created by niehaibing on 2018-03-15.
 */
app.controller('bas_area_save_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal, toaster,$location) {

    $scope.basArea={};

    $scope.formValidate = false;

    $scope.submit = false;

    //
    $scope.areaLevelList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.areaLevel);
    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {
        if(!$scope.form.$invalid) {
            $http.get('bas_area/findBasAreaByAreaCode?areaCode='+$scope.basArea.areaCode).success(function (data) {
                if(data.data!=null){
                    modalAlert($modal,"该省市县代码已存在！");
                }else{
                    $scope.submit = true;
                    $http.post('bas_area/saveBasArea', $scope.basArea).success(function (data) {
                        if (data.code == Response.successCode){
                            $location.path("app/baseinfo_bas_area_list").search({type:'save'});
                        }else{
                            modalAlert($modal,data.message);
                        }
                        $scope.submit = false;
                    }).error(function(data){
                        modalAlert($modal,data);
                        $scope.submit = false;
                    })
                }
            });
        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    /*    if(!$scope.form.$invalid) {

            $scope.submit = true;
            //   $scope.sysTplType.tplItemList = $scope.tplItemList;
            $http.post('bas_area/saveBasArea', $scope.basArea).success(function (data) {
                if (data.code == Response.successCode) {
                    toaster_success('添加省市县成功', toaster);
                    $location.path("app/system_bas_area_list");
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
        }*/

    };
    $scope.selectParAreaCode = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_area/bas_area_select_list.html'+getCacheTime(),
            controller: 'bas_area_select_list_controller',
            resolve:{
                basArea: function () {
                    return '1';
                }
            }
        });
       rtn.result.then(function (data) {
            if(data != null) {
                $scope.basArea.parentAreaCode = data.areaCode;
                $scope.basArea.parentAreaName = data.areaName;
            }
        },function(){
        });
    };
    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(status){

        $location.path("app/baseinfo_bas_area_list");
    };

}]);


