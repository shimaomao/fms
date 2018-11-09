/**
 * Created by wangxue on 2018/3/9.
 */

app.controller('sys_widget_attribute_handler_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','sysWidgetAttribute', function ($scope, $http, $modal, $modalInstance, toaster, sysWidgetAttribute) {

    $scope.frmWidgetId = sysWidgetAttribute.frameWidgetId;
    $scope.sysWidgetAttribute={};

    $scope.frameTitle = consNameById($scope.frmWidgetId);

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.showSaveButton = $scope.frmWidgetId == common_frame_widget_id.F000001;
    $scope.showModifySaveButton = $scope.frmWidgetId == common_frame_widget_id.F000002;

    // 项目显示权限
    $scope.modList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.sys_widget_mod);

   if ($scope.frmWidgetId == common_frame_widget_id.F000002) {
       // 编辑的场合
        $scope.sysWidgetAttribute = sysWidgetAttribute;
       $scope.eleWidgetName = $scope.sysWidgetAttribute.eleWidgetName;
        $http.get('sys_widget_attribute/findSysWidgetAttributeById?id='+ $scope.sysWidgetAttribute.widgetConId).success(function(data){
            $scope.sysWidgetAttribute = data.data;
            $scope.sysWidgetAttribute.eleWidgetName = $scope.eleWidgetName;
        });
    } else if ($scope.frmWidgetId == common_frame_widget_id.F000003) {
       // 详情
       $scope.sysWidgetAttribute = sysWidgetAttribute;
       // 项目显示权限
       $scope.sysWidgetAttribute.showModName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.sys_widget_mod, $scope.sysWidgetAttribute.showMod);
       // 项目编辑权限
       $scope.sysWidgetAttribute.writeModName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.sys_widget_mod, $scope.sysWidgetAttribute.writeMod);
       // 项目是否必须
       $scope.sysWidgetAttribute.checkModName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.sys_widget_mod, $scope.sysWidgetAttribute.checkMod);
    }
    // 画面ID和名称
    $scope.sysWidgetAttribute.frmWidgetId = sysWidgetAttribute.frmWidgetId;
    $scope.sysWidgetAttribute.frmWidgetName = sysWidgetAttribute.frmWidgetName;

    // 取得画面项目权限
    $scope.itemWidgetMap = consItemWidgetMap($scope.frmWidgetId);

    /**
     * 保存项目权限信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('sys_widget_attribute/saveSysWidgetAttribute', $scope.sysWidgetAttribute).success(function (data) {
                if (data.code == Response.successCode)
                    $scope.close(Response.successMark);
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
     * 保存组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('sys_widget_attribute/modifySysWidgetAttribute', $scope.sysWidgetAttribute).success(function (data) {
                if (data.code == Response.successCode)
                    $scope.close(Response.successMark);
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

    $scope.selectItem = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_widget/sys_widget_list_select.html?datetime='+getTimestamp(),
            controller: 'sys_widget_list_select_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.sysWidgetAttribute.eleWidgetName = data.widgetName;
                $scope.sysWidgetAttribute.eleWidgetId = data.widgetId;
            }
        },function(){

        });
    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(status){
        $modalInstance.close(status);
    };
}]);