

app.controller('bas_bank_info_handler_controller', ['$scope', '$http','$modal','toaster','$location','$rootScope', function ($scope, $http, $modal, toaster,$location,$rootScope) {
console.log($rootScope);
    //启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);
    //是否默认账号
    $scope.accDefaultList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.accDefault);
    //银行账号状态
    $scope.accountNoStatusList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.accountNoStatus);
    //开户行
    $scope.openingBankList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.openingBank);
    //银行类型
    $scope.organizationTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.organizationType);
    //gps厂商
    $scope.gpsAccTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.gpsAccType);
    //抵押资方
    $scope.mortgageAccTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.mortgageAccType);
    //保险公司
    $scope.insuranceAccTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.insuranceAccType);

    $scope.basBankInfo={};

    $scope.httpData = true;
    $scope.notUpload = false;
    $scope.msgInfo = null;
    $scope.formValidate = false;
    $scope.submit = false;
    //附件对象
    $scope.bizFilesList= [];

    $scope.cityList={};
    $scope.provinceList=AreaUtils.getAllProvinceList();

    $scope.changeCountry = function() {
        if ($scope.basBankInfo.accOpBankProv==""||$scope.basBankInfo.accOpBankProv==undefined) {
            $scope.cityList={};
        } else {
            $scope.cityList=AreaUtils.getCityList($scope.basBankInfo.accOpBankProv);
        }
        $scope.basBankInfo.accOpBankCity="";
    }

    $scope.changeOrganizationType = function (organizationId) {
        if(isNotUndefinedNull(organizationId)){
            $scope.basBankInfo.organizationId=""
        }
    }



    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    $scope.showCheck=$location.search()['operate']=='check'||false;
    $scope.taskId = $location.search()['taskId'];
    $scope.serviceId = $location.search()['serviceId'];
    $scope.serviceIdStatus = isNotUndefinedNull($scope.serviceId)||false;

    if ($scope.showUpdate||isNotUndefinedNull($scope.serviceId)) {
        $http.get('bas_bank_info/findBasBankInfoByBankId?bankId='+ $location.search()['bankId']+'&serviceId='+$scope.serviceId).success(function(data){
            $scope.basBankInfo = data.data;
            console.log(data.data)
            // if($scope.basBankInfo.accOpBankProv==null||$scope.basBankInfo.accOpBankProv==undefined)
            //     $scope.basBankInfo.accOpBankProv=''
            $scope.cityList=AreaUtils.getCityList($scope.basBankInfo.accOpBankProv);
            //附件赋值
            $scope.bizFilesList = $scope.basBankInfo.bizFilesList;
        });
    }

    //选择机构
    $scope.selectOrganizationId = function (organizationType) {
        //用户组
        if(organizationType == 0){
            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/system/sys_group/sys_group_list_select.html?datetime='+getTimestamp(),
                controller: 'sys_group_list_select_controller',
                resolve:{
                    parentGroup:function () {
                        return {parentType:1};
                    }
                }
            })

            rtn.result.then(function (data) {
                if(data != null) {
                    $scope.basBankInfo.organizationId = data.groupName;
                    $scope.basBankInfo.organizationId0 = data.groupCode;
                }
            },function(){

            });
        }else if(organizationType == 1) {
            //实际销售方
            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/baseinfo/bas_sales/bas_sales_list_select.html'+getCacheTime(),
                controller: 'bas_sales_list_select_controller',
                resolve:{
                }
            });
            rtn.result.then(function (data) {
                if(isNotUndefinedNull(data)) {
                    $scope.basBankInfo.organizationId = data.salesName;
                    $scope.basBankInfo.organizationId1 = data.salesCode;

                }
            },function(){
            });
        }else if(organizationType == 2){
            //经销商
            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/baseinfo/bas_partner/bas_partner_list_select.html?datetime='+getTimestamp(),
                controller: 'bas_partner_list_select_controller',
                resolve:{
                    setData: function () {
                        return {
                            "checkboxOrRadio": CheckBox
                        };
                    }
                }
            })
            rtn.result.then(function (data) {
                if(data != null) {
                    $scope.basBankInfo.organizationId = data.partnerName;
                    $scope.basBankInfo.organizationId2 = data.partnerCode;
                }
            },function(){

            });
        }else if(organizationType == 3){
            //收车机构
            var rtn = $modal.open({
                backdrop : 'static',
                size:'lg',
                templateUrl: 'tpl/postbiz/car_collect_comp/car_collect_comp_list_select.html?datetime='+getTimestamp(),
                controller: 'car_collect_comp_list_select_controller',
                resolve:{
                    setData: function () {
                        return {
                            "checkboxOrRadio": CheckBox
                        };
                    }
                }
            })
            rtn.result.then(function (data) {
                if(data != null) {
                    $scope.basBankInfo.organizationId = data.carCollectCompName;
                    $scope.basBankInfo.organizationId3 = data.carCollectCompCode;
                }
            },function(){

            });
        }else {
            modalAlert($modal,'请先选择机构类型！');
        }
    }



    /**
     * 保存银行账号属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid && !$scope.notUpload) {

            $scope.submit = true;
            $scope.basBankInfo.bizFilesList = $scope.bizFilesList;
            if($scope.basBankInfo.organizationType == 0){
                //$scope.basBankInfo.organizationId = $scope.basBankInfo.organizationId0;
                $scope.basBankInfo.organizationIdCode = $scope.basBankInfo.organizationId0;
            }else if($scope.basBankInfo.organizationType == 1){
                //$scope.basBankInfo.organizationId = $scope.basBankInfo.organizationId1;
                $scope.basBankInfo.organizationIdCode = $scope.basBankInfo.organizationId1;
            }else if($scope.basBankInfo.organizationType == 2){
                //$scope.basBankInfo.organizationId = $scope.basBankInfo.organizationId2;
                $scope.basBankInfo.organizationIdCode = $scope.basBankInfo.organizationId2;
            }else if($scope.basBankInfo.organizationType == 3){
                //$scope.basBankInfo.organizationId = $scope.basBankInfo.organizationId3;
                $scope.basBankInfo.organizationIdCode = $scope.basBankInfo.organizationId3;
            }
            $http.post('bas_bank_info/saveBasBankInfo', $scope.basBankInfo).success(function (data) {
                if (data.code == Response.successCode){
                    $location.path("app/baseinfo_bas_bank_info_list").search({type:"save"});
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
            if($scope.form.$invalid){
                toaster_info(promptInfo.submitWarn,toaster);
            }else{
                toaster_info($scope.msgInfo,toaster);
            }
            $scope.formValidate = true;
        }
    };

    /**
     * 修改银行账号属性信息
     */
    $scope.modify = function () {
        if(!$scope.form.$invalid && !$scope.notUpload) {

            $scope.submit = true;
            $scope.basBankInfo.bizFilesList = $scope.bizFilesList;
            if($scope.basBankInfo.organizationType == 0){
                //$scope.basBankInfo.organizationId = $scope.basBankInfo.organizationId0;
                $scope.basBankInfo.organizationIdCode = $scope.basBankInfo.organizationId0;
            }else if($scope.basBankInfo.organizationType == 1){
                //$scope.basBankInfo.organizationId = $scope.basBankInfo.organizationId1;
                $scope.basBankInfo.organizationIdCode = $scope.basBankInfo.organizationId1;
            }else if($scope.basBankInfo.organizationType == 2){
                //$scope.basBankInfo.organizationId = $scope.basBankInfo.organizationId2;
                $scope.basBankInfo.organizationIdCode = $scope.basBankInfo.organizationId2;
            }else if($scope.basBankInfo.organizationType == 3){
                //$scope.basBankInfo.organizationId = $scope.basBankInfo.organizationId3;
                $scope.basBankInfo.organizationIdCode = $scope.basBankInfo.organizationId3;
            }
            $scope.basBankInfo.taskId = $scope.taskId;
            //如果银行账号类型不是用户组，把财务科目代码设为null，防止退回再提交重新选择银行账号类型时科目代码没有更新
            if($scope.basBankInfo.organizationType != 0){
                $scope.basBankInfo.finassSubjectCd = '';
            }
            $http.put('bas_bank_info/modifyBasBankInfo', $scope.basBankInfo).success(function (data) {
                if (data.code == Response.successCode&&isUndefinedNull($scope.serviceId)){
                    toaster_success('编辑成功',toaster);
                    $location.path("app/baseinfo_bas_bank_info_list").search({type:"modify"});
                }else if(data.code == Response.successCode&&!isUndefinedNull($scope.serviceId)) {
                    $location.path('/app/home').search({type:'homeToastInfo', msg:'提交成功'});
                }else {
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            if($scope.form.$invalid){
                toaster_info(promptInfo.submitWarn,toaster);
            }else{
                toaster_info($scope.msgInfo,toaster);
            }
            $scope.formValidate = true;
        }


    };
    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        if (isUndefinedNull($scope.serviceId)){
            $location.path("app/baseinfo_bas_bank_info_list");
        }else{
            $location.path('/app/home')
        }
    };

    /**
     * 引用流程日志共通
     */
    $scope.wfLogType = CommonCodeUtils.bizTypes.basBankInfo;
    $scope.wfLogNo = $scope.serviceId;
}]);

