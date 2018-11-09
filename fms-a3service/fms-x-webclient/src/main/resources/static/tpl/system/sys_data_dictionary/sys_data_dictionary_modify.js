/**
 * Created by qiaohao on 2018/1/10.
 */
app.controller('sys_data_dictionary_modify_controller', ['$scope', '$http','$modal', '$modalInstance','toaster','sysDataDicId', function ($scope, $http,$modal, $modalInstance,toaster,sysDataDicId) {

    $scope.sysDataDic={};

    $scope.formValidate = false;

    $scope.submit = false;


    $http.get('sys_data_dictionary/findSysDataDictionaryVoById?id='+ sysDataDicId).success(function(data){
        $scope.sysDataDic = data.data;
        if($scope.sysDataDic.dataDicParentId == 0){
            $scope.sysDataDic.dataDicParentName = "无上级";
        }
    });


    /**
     * 保存数据字典信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.put('sys_data_dictionary/modifySysDataDictionary', $scope.sysDataDic).success(function (data) {
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


    }

    $scope.selectDataDic = function(){

        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_data_dictionary/sys_data_dictionary_list_select.html?datetime='+getTimestamp(),
            controller: 'sys_data_dictionary_list_select_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.sysDataDic.dataDicParentName = data.dataDicName;
                $scope.sysDataDic.dataDicParentId = data.id;
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


