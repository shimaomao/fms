/**
 * Created by yangyiquan on 2018-05-18.
 */
app.controller('mortgage_register_mail_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {
    $scope.contNo = $location.search()['contNo'];
    $scope.mortgageRegisterId = $location.search()['mortgageRegisterId'];
    $scope.formValidate = false;
    $scope.submit = false;
    $scope.mortgageData = {contNo:$scope.contNo};

    //解抵押附件对象
    $scope.detailFlag = 0;
    $scope.treeFileId = "tree_file_mortgage";
    $scope.bizFilesList = {bizFilesInfo:{},fileType:CommonCodeUtils.basFileTypes.mortgageRegisterFile};
    $http.get('mortgage_register/findBizFilesMortgageRegister?bizCode='+ $scope.contNo).success(function (data) {
        if (data.code == Response.successCode){
            $scope.bizFilesList.bizFilesInfo = data.data.bizFilesInfo;
            $scope.bizFilesList.bizFilesListVos = data.data.bizFilesListVos;
        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });


    //$scope.postAddrTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.postAddrType);
    $http.get('contract_vehicle/findContractVehicleFinanceVoByContNo?contNo='+ $scope.contNo).success(function (data) {
        if (data.code == Response.successCode){
            $scope.mortgage = data.data;
        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });
    $http.get('orig_file_detail/findOrigFileDetailByExample?bizCode='+ $scope.contNo+'&bizCodeType=1').success(function (data) {
        if (data.code == Response.successCode){
            //参数配置
            $scope.dataTableProperties= {
                //table的html id
                dataTableId:'mortgage_register_mail',
                //table的列
                dataTableColumn: [
                    defaultCheckBox('bizCode'),
                    //defaultDetail('contNo','detailMortgageRegister','合同编号','20%',$compile,$scope,'mortgageRegisterId'),
                    {title:'业务号',data:'bizCode',width:'20%'},
                    {title:'业务类型',data:'bizCodeType',width:'20%',
                        render:function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.bizCodeType, data);
                        }
                    },
                    {title:'附件类型',data:'fileType',width:'20%'},
                    {title:'文件状态',data:'origFileDetailStatus',width:'20%',
                        render:function (data, type, row, meta) {
                            return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.origFileDetailStatus, data);
                        }
                    }
                ],
                //列是单选还是多选 CheckBox多选 Radio单选
                dataTableSelectType: CheckBox,
                dataTableData: data.data
            };
            $scope.dataTable = CommonDataTableUtils.createDataTableForData($scope.dataTableProperties, $scope);
        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    //保存
    $scope.save = function () {
        var rows = $scope.dataTable.getRows();
        if(!$scope.form.$invalid) {
            $scope.submit = true;
            if(rows.length == 0){
                modalAlert($modal,"请选择一条数据");
            }else{
                $scope.mortgageData.origFileDetailList = rows;
                $http.post('mortgage_register/saveMortgagePost', $scope.mortgageData).success(function (data) {
                    if (data.code == Response.successCode){
                        $location.path("app/asset_mortgage_register_list").search({'type': 'mail'});
                    }else{
                        modalAlert($modal,data.message);
                    }
                    $scope.submit = false;
                }).error(function(data){
                    modalAlert($modal,data);
                    $scope.submit = false;
                })
            }
        }else{
            $scope.formValidate = true;
        }
    };
    //取消
    $scope.close = function () {
        $location.path('/app/asset_mortgage_register_list').search({});
    };
}]);


