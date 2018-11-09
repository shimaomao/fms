/**
 * Created by niehaibing on 2018-03-21.
 */
app.controller('fin_item_save_controller', ['$scope', '$http','$modal', '$location','toaster', function ($scope, $http,$modal, $location,toaster) {

    $scope.finItem={finMode:'1',payMode:'1',editMode:'1'};

    $scope.formValidate = false;

    $scope.submit = false;
    //牌照类型list
    $scope.licenseAttrList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr);
    //融资方式list
    $scope.finModeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.finMode);
    //是否可修改
    $scope.editModeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.editMode);
    //是否和车款一起支付
    $scope.payModeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.payMode);
    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {
        //$scope.finItemArray();
        if(!$scope.form.$invalid) {
            $scope.submit = true;

            $http.post('fin_item/saveFinItem', $scope.finItem).success(function (data) {
                if (data.code == Response.successCode) {
                    toaster_success('添加融资费用信息成功', toaster);
                    $location.path("app/product_fin_item_list").search({type:'save'});
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

    }

    /**
     * 返回
     * @param status
     */
    $scope.goBack = function(status){

        $location.path("app/product_fin_item_list");
    };

    /*$scope.finItemArray=function(){
        //牌照属性
        var licenseAttr="";
        $("input[name='licenseAttr']:checked").each(function(){
            licenseAttr+=$(this).attr("ng-true-value")+",";
        })
        $scope.finItem.licenseAttr=licenseAttr.substring(0,licenseAttr.length-1);

        //融资方式
        var finMode="";
        $("input[name='finMode']:checked").each(function(){
            finMode+=$(this).attr("ng-true-value")+",";
        })
        $scope.finItem.finMode=finMode.substring(0,finMode.length-1);
    }*/
}]);


