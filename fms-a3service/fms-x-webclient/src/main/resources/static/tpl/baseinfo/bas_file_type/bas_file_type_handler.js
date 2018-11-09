

app.controller('bas_file_type_handler_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {

    //是否实际文件
    $scope.actualFileList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.actualFile);
    //是否必填
    $scope.requiredStateList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.requiredState);


    $scope.basFileType={};

    $scope.formValidate = false;

    $scope.submit = false;

   /* $scope.frmWidgetId = $location.search()['frmWidgetId'];
    $scope.showSaveButton = $scope.frmWidgetId == common_frame_widget_id.F000801;
    $scope.showModifySaveButton = $scope.frmWidgetId == common_frame_widget_id.F000802;
    // 画面名称
    $scope.frameTitle = consNameById($scope.frmWidgetId);
    if ($scope.frmWidgetId == common_frame_widget_id.F000802 || $scope.frmWidgetId == common_frame_widget_id.F000803) {
        // 编辑和详情
        $http.get('bas_file_type/findBasFileTypeByFileTypeId?fileTypeId='+ $location.search()['fileTypeId']).success(function(data){
            $scope.basFileType = data.data;
        });
    }

    // 取得画面项目权限
    $scope.itemWidgetMap = consItemWidgetMap($scope.frmWidgetId);*/


    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    $scope.showCheck=$location.search()['operate']=='check'||false;


    if ($scope.showUpdate||$scope.showCheck) {
        $http.get('bas_file_type/findBasFileTypeVoByFileTypeId?fileTypeId='+ $location.search()['fileTypeId']).success(function(data){
            $scope.basFileType = data.data;
        });
    }

    //选择上级附件类型代码
    $scope.selectParentFileType = function () {
        var  parentFileType1=$location.search()['parentFileType1']
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/baseinfo/bas_file_type/bas_file_type_list_select.html?datetime='+getTimestamp(),
            controller: 'bas_file_type_list_select_controller',
            resolve:{
                setData: function () {
                    return {
                        parentFileType: parentFileType1,
                        checkboxOrRadio: CheckBox
                    };
                }
            }
        })

        rtn.result.then(function (data) {
            if(data != null) {
                $scope.basFileType.parentFileType = data.fileType;
                $scope.basFileType.parentFileTypeName = data.fileTypeName;
                console.log($scope.basFileType.parentFileType)
               /* $scope.fileTypeName = data.fileTypeName;*/
            }
        },function(){

        });

    }

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('bas_file_type/saveBasFileType', $scope.basFileType).success(function (data) {
                if (data.code == Response.successCode){
                    toaster_success('添加成功',toaster);
                    $location.path("app/baseinfo_bas_file_type_list");
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
     * 修改组织机构属性信息
     */
    $scope.modify = function () {


        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('bas_file_type/modifyBasFileType', $scope.basFileType).success(function (data) {
                if (data.code == Response.successCode){
                    toaster_success('编辑成功',toaster);
                    $location.path("app/baseinfo_bas_file_type_list");
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
        $location.path("app/baseinfo_bas_file_type_list");
    };
}]);
