/**
 * Created by niehaibing on 2018-03-21.
 */
app.controller('fin_item_modify_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal, toaster,$location) {

    $scope.finItem={};

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

    $http.get('fin_item/findFinItemByFinItemId?finItemId='+ $location.search()['finItemId']).success(function(data){
        $scope.finItem = data.data;
    });
    $scope.modify = function () {
        //$scope.finItem();
        if(!$scope.form.$invalid) {

            $scope.submit = true;


            $http.put('fin_item/modifyFinItem', $scope.finItem).success(function (data) {
                if (data.code == Response.successCode) {
                    toaster_success('修改融资项目成功', toaster);
                    $location.path("app/product_fin_item_list").search({type:'modify'});
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
    $scope.goBack = function(status){

        $location.path("app/product_fin_item_list");
    };

   /* $scope.finItem=function(){
        //牌照属性
        var licenseAttr="";
        $("input[name='licenseAttr']:checked").each(function(){
            licenseAttr+=$(this).attr("ng-true-value")+",";
        })
        $scope.finItem.licenseAttr=licenseAttr.substring(0,licenseAttr.length-1);
    }*/


}]);


