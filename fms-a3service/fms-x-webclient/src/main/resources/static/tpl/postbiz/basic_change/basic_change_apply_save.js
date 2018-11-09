/**
 * Created by lijunjun on 2018-08-31.
 */
app.controller('basic_change_apply_save_controller', ['$scope', '$http','$modal','toaster','$location','$compile', function ($scope, $http,$modal,toaster,$location,$compile) {
    $scope.applyNoParams = $scope.$parent.applyNoParams;
    $scope.contNo = $scope.$parent.contNo;
    $scope.applyNo = $scope.$parent.applyNo;
    $scope.type = $scope.$parent.type;
    $scope.contractDate = $scope.$parent.contractDate;
    $scope.bizStatus = $scope.$parent.bizStatus;

    $scope.applyDisabled = $scope.$parent.applyDisabled;

    $scope.name = $scope.$parent.name;
    $scope.certifNo = $scope.$parent.certifNo;

    $scope.taskId = $scope.$parent.taskId;

    //流程任务key
    $scope.taskDefinitionKey = $scope.$parent.taskDefinitionKey;

    $scope.detailContract = function () {

        var id = $scope.contNo;
        var url = 'app.prebiz_apply_input_detail?applyNo='+$scope.applyNoParams
            + '&contNo=' +$scope.contNo
            + '&applyType=' +$scope.applyTypeOld
            + '&type=contract'
            + '&contractDate=' +$scope.contractDate
            + '&bizStatus=' +$scope.bizStatus
            + '&isTab=true';
        var title = '合同详情';
        var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
        if(window.parent.addTab){
            window.parent.addTab(html);
        }
    };
    //传值父页面
    $scope.$watch("changeReason",function (newVal, oldVal) {
        if (isNotUndefinedNull(newVal)&& newVal !==oldVal)
            $scope.$emit("changeReasonToFather",$scope.changeReason);
    },true);

    $scope.$on('applyInputToSonSecond',function (e,data) {
        $scope.changeReason = data.changeLesseeTask.changeReason;
        $scope.contNo = data.changeLesseeTask.contNo;
        $scope.applyNoParams = data.apply.applyNo;
        $scope.applyTypeOld = data.apply.applyType;
        if($scope.applyTypeOld == 1){
            $scope.name = data.cstmPerson.name;
            $scope.certifType = data.cstmPerson.certifType;
            $scope.certifNo = data.cstmPerson.certifNo;
        }else{
            $scope.name = data.cstmCompany.name;
            $scope.socialCertifNo = data.cstmCompany.socialCertifNo;
        }
        $scope.groupName =  data.groupName;
        $scope.vinNo =  data.vinNo;
        $scope.contNo =  data.contNo;
    });

    $scope.$on('applyInputToSonFirst',function (e,data) {
        console.log(data);
        $scope.applyTypeOld = data.apply.applyType;
        if($scope.applyTypeOld == 1){
            $scope.name = data.cstmPerson.name;
            $scope.certifType = data.cstmPerson.certifType;
            $scope.certifNo = data.cstmPerson.certifNo;
        }else{
            $scope.name = data.cstmCompany.name;
            $scope.socialCertifNo = data.cstmCompany.socialCertifNo;
        }
        $scope.groupName =  data.applyFinanceVo.belongGroupName;
        $scope.vinNo =  data.vinNo;
    });
}]);


