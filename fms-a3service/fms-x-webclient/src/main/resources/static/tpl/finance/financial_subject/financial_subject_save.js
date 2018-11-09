/**
 * Created by yanfengbo on 2018-06-20.
 */
app.controller('financial_subject_save_controller', ['$scope', '$http','$modal','toaster','$location',function ($scope, $http, $modal, toaster,$location) {

    $scope.financialSubject={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    $scope.showCheck=$location.search()['operate']=='check'||false;

    $scope.assisAccountTypeList = [];
    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            if($scope.assisAccountTypeList.length == 0){
                modalAlert($modal,'辅助核算类型不能为空');
                $scope.submit = false;
                return false;
            }
            $scope.financialSubject.assisAccountTypeVos = $scope.assisAccountTypeList;
                $http.post('financial_subject/saveFinancialSubject', $scope.financialSubject).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("app/finance_financial_subject_list").search({messageType:'saveFinancialSubject'});
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

    //选择辅助核算类型管理
    $scope.selectAssisAccountType = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/finance/assis_account_type/assis_account_type_select.html?datetime='+getTimestamp(),
            controller: 'assis_account_type_select_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                //$scope.assisAccountTypeList = data;
                for( var i in data ){
                    if($scope.assisAccountTypeList.length>0){
                        for(var j in $scope.assisAccountTypeList){
                            if($scope.assisAccountTypeList[j].assisAccountTypeId==data[i].assisAccountTypeId)
                                break;
                            else if(j == $scope.assisAccountTypeList.length-1){
                                $scope.assisAccountTypeList.push(data[i]);
                            }
                        }
                    }else{
                        $scope.assisAccountTypeList.push(data[i]);
                    }
                }
            }
        },function(){

        });
    }

    //删除辅助核算类型
    $scope.del = function (index) {
        $scope.assisAccountTypeList.splice(index,1);
    };

    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/finance_financial_subject_list");
    };
}]);


