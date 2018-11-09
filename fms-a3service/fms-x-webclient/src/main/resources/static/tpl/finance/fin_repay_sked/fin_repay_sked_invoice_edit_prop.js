/**
 * Created by ningyangyang on 2018/8/21.
 */
app.controller('fin_repay_sked_invoice_edit_prop_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster,$compile,$location) {

    //是否确认付款
    $scope.yesNoFlagList=CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.yesNoFlag);
    //业务类型
    //$scope.licenseAttrList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.licenseAttr);
    $scope.finRepaySked = {'invoiceProp':''};
    $scope.invoiceProp = '';
    $scope.finRepaySkeds = JSON.parse($location.search()['finRepaySkeds']);
    /*for(var i in $scope.finRepaySkeds){
        $scope.finRepaySkeds[i].licenseAttr = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.licenseAttr,$scope.finRepaySkeds[i].licenseAttr);
    }*/
    //批量修改开票属性
    $scope.save = function () {
        $scope.finRepaySked.contRepaySkedList = $scope.finRepaySkeds;
        $http.post('fin_repay_sked/editInvoiceProp',$scope.finRepaySked).success(function (data) {
            if (data.code == Response.successCode)
                $location.path("app/finance_fin_repay_sked_list").search({'msg':'修改成功'});
            else
                modalAlert($modal,data.message);
        }).error(function(data){
            modalAlert($modal,data);
            $scope.submit = false;
        });
    }

    //批量修改是否先开票
    $scope.changeInvoiceProp = function(){
        if($scope.finRepaySked.invoiceProp == "1" || $scope.finRepaySked.invoiceProp == "0"){
            for(var i = 0;i<$scope.finRepaySkeds.length;i++){
                $scope.finRepaySkeds[i].invoiceProp = $scope.finRepaySked.invoiceProp;
            }
        }
    }

    //单个修改是否先开票
    $scope.changeOneProp = function(a){
        if(a.invoiceProp != $scope.finRepaySked.invoiceProp)
            $scope.finRepaySked.invoiceProp = '';
    }

    //返回
    $scope.goBack = function () {
        $location.path('app/finance_fin_repay_sked_list');
    }

}])
;
