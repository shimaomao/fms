/**
 * Created by huchenghao on 2018/3/10.
 */

app.controller('sys_code_handler_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster,$location) {


    $scope.basRepayRule={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    $scope.showDetail=$location.search()['operate']=='detail'||false;

    if ($scope.showUpdate||$scope.showDetail) {
        $http.get('bas_repay_rule/findBasRepayRuleByRuleId?ruleId='+ $location.search()['ruleId']).success(function(data){
            $scope.basRepayRule = data.data;
        });

    }

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {
            if($scope.basRepayRule.beginInterval*1>$scope.basRepayRule.endInterval*1){
                modalAlert($modal,"开始区间不能大于结束区间!");
                return false;
        }
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $http.post('bas_repay_rule/saveBasRepayRule', $scope.basRepayRule).success(function (data) {
                if (data.code == Response.successCode){
                    //toaster_success('添加还款日规则成功',toaster);
                    $location.path("app/baseinfo_bas_repay_rule_list").search({type:'save'});
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
                if($scope.basRepayRule.beginInterval*1>$scope.basRepayRule.endInterval*1){
                    modalAlert($modal,"开始区间不能大于结束区间!");
                    return false;
            }
            $scope.submit = true;

            $http.put('bas_repay_rule/modifyBasRepayRule', $scope.basRepayRule).success(function (data) {
                if (data.code == Response.successCode){
                    //toaster_success('修改数据字典数值成功',toaster);
                    $location.path("app/baseinfo_bas_repay_rule_list").search({type:'modify'});
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
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/baseinfo_bas_repay_rule_list");
    };
}]);