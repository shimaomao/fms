/**
 * Created by qinmuqiao on 2018-09-08.
 */
app.controller('annual_inspection_update_controller', ['$scope', '$http','$modal','toaster','$location', '$filter', function ($scope, $http,$modal,toaster,$location, $filter) {

    $scope.annualInspection={};
    $scope.formValidate = false;
    $scope.submit = false;

    $http.get('annual_inspection/findAnnualInspectionVoByAnnualInspectionId?annualInspectionId='+ $location.search()['annualInspectionId']).success(function(data){
        $scope.annualInspection = data.data;
        $scope.annualInspection.annualInspectDeadline = $filter('date')($scope.annualInspection.annualInspectDeadline, 'yyyy-MM-dd');
        if (!$scope.annualInspection.annualInspectDate){
            $scope.annualInspection.annualInspectDate = new Date();
        }

        $scope.annualInspection.annualInspectDate = $filter('date')($scope.annualInspection.annualInspectDate, 'yyyy-MM-dd');
        $scope.annualInspection.annualInspectStatusVal = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.annualInspectStatus,$scope.annualInspection.annualInspectStatus)

    });

    /**
     * 保存组织机构属性信息
     */
    $scope.updateAnnualInspection = function () {
    console
        if(!$scope.form.$invalid) {

            $scope.submit = true;

            if ($scope.annualInspection.annualInspectStatus == '1') {
                modalAlert($modal,'年检已完成');
                return;
            }
            $http.put('annual_inspection/modifyAnnualInspection', $scope.annualInspection).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path('app/postbiz_annual_inspection_list').search({type:'save'});
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

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(){
        $location.path('app/postbiz_annual_inspection_list');
    };

}]);


