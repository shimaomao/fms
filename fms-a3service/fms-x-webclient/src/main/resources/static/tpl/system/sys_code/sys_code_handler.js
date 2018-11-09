/**
 * Created by huchenghao on 2018/3/10.
 */

app.controller('sys_code_handler_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {


    $scope.sysCode={};

    $scope.formValidate = false;

    $scope.submit = false;
    $scope.sysCode.enableFlag = '0';
    $scope.frameTitle = $location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    $scope.showDetail=$location.search()['operate']=='detail'||false;

    var codeType="";
    if ($scope.showUpdate||$scope.showDetail) {
        $http.get('sys_code/findSysCodeByCodeValueId?codeValueId='+ $location.search()['codeValueId']).success(function(data){
            $scope.sysCode = data.data;
            $scope.sysCode.enableFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,$scope.sysCode.enableFlag);
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
            $http.post('sys_code/saveSysCode', $scope.sysCode).success(function (data) {
                if (data.code == Response.successCode){
                    //前端数据字典重新赋值
                    CommonCodeUtils.setCommonCodeValues(data.data);
                    $location.path("app/system_code_list").search({type:'save'});
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

            $http.put('sys_code/modifySysCode', $scope.sysCode).success(function (data) {
                if (data.code == Response.successCode){
                    //前端数据字典重新赋值
                    CommonCodeUtils.setCommonCodeValues(data.data);
                    $location.path("app/system_code_list").search({type: 'modify'});
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
    //数据字典类型选择
    $scope.selectsysCodeType = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_code_type/sys_code_type_list_select.html?datetime='+getTimestamp(),
            controller: 'sys_code_type_list_select_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.sysCode.codeType = data.codeType;
                $scope.sysCode.codeTypeName = data.codeTypeName;
            }
        },function(){

        });
    }
     /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/system_code_list");
    };

}]);