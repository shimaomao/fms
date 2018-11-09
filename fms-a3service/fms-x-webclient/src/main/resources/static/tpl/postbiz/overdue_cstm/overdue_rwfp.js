/**
 * Created by lijunjun on 2018-05-16.
 */
app.controller('overdue_rwfp_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {
    $scope.overdueCstmId = $location.search()['overdueCstmId'];
    $scope.certifNo = $location.search()['certifNo'];
    $scope.detail = $location.search()['detail'];
    $scope.collectionPerson={};

    $scope.formValidate = false;

    $scope.submit = false;

    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);

    $scope.getData = function () {
        $http.get('overdue_cstm/findOverdueCstmVoByOverdueCstmId?overdueCstmId='+$scope.overdueCstmId).success(function (data) {
            if(data.code == Response.successCode){
                $scope.cstmData = data.data;
                $scope.collectionPerson.collectionPersonNum = $scope.cstmData.assignUser;//把值给页面显示
                //$scope.collectionPerson.collectionType = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.assignmentType, $scope.cstmData.assignmentType);
                $scope.collectionPerson.collectionType = $scope.cstmData.assignmentType;
                    console.log($scope.cstmData);
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {

            modalAlert($modal,err);
        });
    };
    $scope.getData();


    //选择催收人员
    $scope.selectCollectionPerson = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/postbiz/collection_person/sys_collection_person_list_select.html?datetime='+getTimestamp(),
            controller: 'sys_collection_person_list_select_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {   //由sys_collection_person_list_select.js中返回的data
            if (data != null) {
                $scope.collectionPerson.collectionPersonNum = data.collectionPersonNum;//把值给页面显示
                //$scope.collectionPerson.collectionType = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.assignmentType, data.collectionType);
                $scope.collectionPerson.collectionType = data.collectionType;
            }
        }, function () {

        });
    }

    /**
     * 保存催收任务信息
     */
    $scope.save = function () {
        $scope.overdueAssignment = {};
        $scope.overdueAssignment.overdueCstmId = $scope.overdueCstmId;
        $scope.overdueAssignment.assignmentType = $scope.collectionPerson.collectionType;
        $scope.overdueAssignment.assignUser = $scope.collectionPerson.collectionPersonNum;

        if(!$scope.form.$invalid) {

            $scope.submit = true;

            $http.post('overdue_assignment/saveAssignment', $scope.overdueAssignment).success(function (data) {
                if (data.code == Response.successCode){
                    modalAlert($modal,'分配成功！');
                    $location.path('app/postbiz_overdue_cstm_list');
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


    }

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(){
        $location.path('app/postbiz_overdue_cstm_list');
    };
}]);
