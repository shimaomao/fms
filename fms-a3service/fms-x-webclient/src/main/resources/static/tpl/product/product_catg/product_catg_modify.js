/**
 * Created by niehaibing on 2018-03-21.
 */
app.controller('product_catg_modify_controller', ['$scope', '$http','$modal', '$location','toaster', function ($scope, $http,$modal, $location,toaster) {

    $scope.productCatg={};

    $scope.formValidate = false;

    $scope.submit = false;
    // 启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);
    //车辆类型
    $scope.vehicleFormList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleForm);
    //车辆种类
    $scope.vehicleTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleType);
    //申请类型
    $scope.applyTypeList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.applyType);

    $http.get('product_catg/findProductCatgByProductCatgId?productCatgId='+ $location.search()['productCatgId']).success(function(data){
        $scope.productCatg = data.data;
    });



    /**
     * 保存组织机构属性信息
     */
    $scope.modify = function () {
        productCatgArray();
        $scope.correct = true;
        if($scope.productCatg.vehicleType==""||
            $scope.productCatg.vehicleForm==""||
            $scope.productCatg.applyType==""){
            $scope.correct = false;
        }
        if(!$scope.form.$invalid&&$scope.correct) {
            $scope.submit = true;
            $http.put('product_catg/modifyProductCatg', $scope.productCatg).success(function (data) {
                if (data.code == Response.successCode) {
                    $location.path("app/product_product_catg_list").search({type:"modify"});
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

        $location.path("app/product_product_catg_list");
    };

    function productCatgArray(){
        //申请类型
        var applyType="";
        $("input[name='applyType']:checked").each(function(){
            applyType+=$(this).attr("ng-true-value")+",";
        })
        $scope.productCatg.applyType=applyType.substring(0,applyType.length-1);

        //车辆类型
        var vehicleForm="";
        $("input[name='vehicleForm']:checked").each(function(){
            vehicleForm+=$(this).attr("ng-true-value")+",";
        })
        $scope.productCatg.vehicleForm=vehicleForm.substring(0,vehicleForm.length-1);

        //车辆种类
        var vehicleType="";
        $("input[name='vehicleType']:checked").each(function(){
            vehicleType+=$(this).attr("ng-true-value")+",";
        })
        $scope.productCatg.vehicleType=vehicleType.substring(0,vehicleType.length-1);
    }
}]);


