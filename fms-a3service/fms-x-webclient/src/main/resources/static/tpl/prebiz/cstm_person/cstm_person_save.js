/**
 * Created by ningyangyang on 2018-03-26.
 */
app.controller('cstm_person_save_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.cstmPerson={};
    $scope.cstmPersJob = {};
    $scope.cstmPersMate = {};
    $scope.cstmPersAddr = {};
    $scope.cstmCompany = {};
    $scope.cstmContact = {};
    $scope.formValidate = false;

    $scope.submit = false;
    //客户性别
    $scope.genderList = consValueArr(common_constant_code.gender);
    //客户婚姻状况
    $scope.marriageStatusList = consValueArr(common_constant_code.marriage_status);
    //客户户口类型
    $scope.censusTypeList = consValueArr(common_constant_code.census_type);
    //客户学历
    $scope.eduBgTypeList = consValueArr(common_constant_code.edu_bg_type);

    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {
            $scope.submit = true;
            $scope.cstmPerson.cstmPersJob =  $scope.cstmPersJob;
            $scope.cstmPerson.cstmPersMate =  $scope.cstmPersMate;
            $scope.cstmPerson.cstmPersAddr = $scope.cstmPersAddr;
            $scope.cstmPerson.cstmCompany = $scope.cstmCompany;
            $scope.cstmPerson.cstmContact = $scope.cstmContact;
            $http.post('cstm_person/saveCstmPerson', $scope.cstmPerson).success(function (data) {
                if (data.code == Response.successCode)
                   // $scope.close(Response.successMark);
                    modalAlert($modal,data.message);
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
    $scope.goBack = function(status){

        $location.path('app/prebiz_cstm_person_list')
    };

}]);


