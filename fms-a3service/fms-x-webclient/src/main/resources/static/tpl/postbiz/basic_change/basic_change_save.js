/**
 * Created by lijunjun on 2018-08-31.
 */
app.controller('basic_change_save_controller', ['$scope', '$http','$modal','toaster','$location','$compile','$timeout', function ($scope, $http,$modal,toaster,$location,$compile,$timeout) {
    $scope.formValidate = false;
    $scope.submit = false;

    //获取url参数
    if($location.search()['serviceId']){
        $scope.applyNo = $location.search()['serviceId'];
    }else{
        //$scope.applyNo = $location.search()['applyNoParams'];
        $scope.applyNoParams = $location.search()['applyNoParams'];
    }
    $scope.contNo = $location.search()['contNo'];
    $scope.applyType = $location.search()['serviceType'];
    $scope.type = $location.search()['type'];
    $scope.contractDate = $location.search()['contractDate'];
    $scope.bizStatus = $location.search()['bizStatus'];
    $scope.taskId = $location.search()['taskId'];
    //console.log($scope.applyNo);
    //console.log($scope.taskId);
    $scope.name = $location.search()['name'];
    $scope.certifNo = $location.search()['certifNo'];
//流程任务key
    $scope.taskDefinitionKey = $location.search()['taskDefinitionKey'];
    //联系人
    $scope.cstmContactList=[];
    //购车合理性
    $scope.rationalityPurchase={};
    //担保人信息
    $scope.guaranteePersList = [];
    //担保企业信息
    $scope.guaranteeCompList = [];
    //附件对象
    $scope.fileObj = {
        bizFilesList:[],
        notUpload: false,
        notUploadInfo:'',
        notFileType:'',
        notFileTypeName:'',
        fileType:''
    };

    //附件类型
    if($scope.applyType == 1){
        $scope.fileObj.fileType = $scope.$root.basFileTypes.perApplyFile;
    }else{
        $scope.fileObj.fileType = $scope.$root.basFileTypes.compApplyFile;
    }

    if($scope.applyType == 1){
        //用户基本信息
        $scope.cstmPerson= {};
        $scope.cstmPersJob = {};
        $scope.cstmPersMate = {};
        $scope.cstmPersAddr = {};

        $scope.$on('personToFather',function (e,data) {
            $scope.cstmPerson = data;
        });
        $scope.$on('persJobToFather',function (e,data) {
            $scope.cstmPersJob = data;
        });
        $scope.$on('persMateToFather',function (e,data) {
            $scope.cstmPersMate = data;
            $scope.$broadcast('persMateToSon', $scope.cstmPersMate);
        });
        $scope.$on('persAddrToFather',function (e,data) {
            $scope.cstmPersAddr = data;
        });
        //共同借款人
        $scope.$on('borrowerToFather',function (e,data) {
            $scope.borrowerList = data;
        });
    }else{
        $scope.cstmCompany={};
        $scope.companyType = {
            companyType1:"",
            companyType2:""
        };
        $scope.$on('companyToFather',function (e,data) {
            $scope.cstmCompany = data;
            $scope.$broadcast('companyToSon', $scope.cstmCompany);
        });
        $scope.$on('companyTypeToFather',function (e,data) {
            $scope.companyType = data;
        });
        $scope.$on('stockAssetsListToFather',function (e,data) {
            $scope.stockAssetsList = data;
        });
    }
    //变更原因
    $scope.$on('changeReasonToFather',function (e,data) {
        $scope.changeReason = data;
    });




    $scope.$on('contactsToFather',function (e,data) {
        $scope.cstmContactList = data;
    });
    $scope.$on('contactToFather',function (e,data) {
        $scope.cstmContactList = data;
    });
    $scope.$on('guaranteePersToFather',function (e,data) {
        $scope.guaranteePersList = data;
    });
    $scope.$on('guaranteeCompToFather',function (e,data) {
        $scope.guaranteeCompList = data;
    });
    $scope.$on('rationalityPurchaseToFather',function (e,data) {
        $scope.rationalityPurchase = data;
    });
    $scope.$on('remarkToFather',function (e,data) {
        $scope.remark = data;
    });

    //获取附件和变更信息
    $scope.getInputVo = function(){
        if($scope.taskId){
            $http.get('change_lessee_task/findApplyInputVoByApplyNo?applyNo='+$scope.applyNo).success(function(data){
                if(data.code == Response.successCode){
                    $scope.applyInput = data.data;
                    $scope.fileObj.bizFilesList = $scope.applyInput.bizFilesList;
                    $scope.contNo = $scope.applyInput.contNo;
                    $scope.applyNoParams =  $scope.applyInput.changeLesseeTask.applyNo;
                    //向子控制器广播数据
                    $scope.$broadcast('applyInputToSonSecond', $scope.applyInput);
                }else{
                    modalAlert($modal,data.message);
                }
            }).error(function (err) {
                modalAlert($modal,err);
            });
        }
        if(!$location.search()['serviceId']){
            $http.get('apply_input/findApplyInputVoByApplyNo?applyNo='+ $scope.applyNoParams).success(function (data) {
                if(data.code == Response.successCode){
                    //向子控制器广播数据
                    $scope.$broadcast('applyInputToSonFirst', data.data);
                }else{
                    modalAlert($modal,data.message);
                }
            });
        }
    };
    $scope.getInputVo();

    // 设置提交和保存的返回信息
    function setApplyInputData() {
        $scope.applyInputVo = {};
        // 申请类型
        $scope.applyInputVo.applyType = $scope.applyType;
        // 订单编号
        //$scope.applyInputVo.applyNo = $scope.applyNo;
        if($location.search()['serviceId']){
            $scope.applyInputVo.applyNo = $location.search()['serviceId'];
        }else{
            //$scope.applyNo = $location.search()['applyNoParams'];
            $scope.applyInputVo.oldApplyNo = $location.search()['applyNoParams'];
        }
        //taskId
        $scope.applyInputVo.taskId  = $scope.taskId;
        //contNo
        $scope.applyInputVo.contNo  =  $scope.contNo;
        //变更原因说明
        $scope.applyInputVo.changeReason = $scope.changeReason;

        if($scope.applyType == 1){
            //个人信息
            $scope.applyInputVo.cstmPerson =  $scope.cstmPerson;
            $scope.applyInputVo.cstmPersJob =  $scope.cstmPersJob;
            $scope.applyInputVo.cstmPersMate =  $scope.cstmPersMate;
            $scope.applyInputVo.cstmPersAddr = $scope.cstmPersAddr;
            //共同借款人
            $scope.applyInputVo.commonBorrowerList = $scope.borrowerList;
        }else{
            //企业信息
            $scope.applyInputVo.cstmCompany =  $scope.cstmCompany;
            $scope.applyInputVo.stockAssetsList =  $scope.stockAssetsList;
            $scope.applyInputVo.companyType1 = $scope.companyType.companyType1;
            $scope.applyInputVo.companyType2 = $scope.companyType.companyType2;
        }
        //联系人
        $scope.applyInputVo.cstmContactList = $scope.cstmContactList;
        //担保人基本信息
        $scope.applyInputVo.guaranteePersList = $scope.guaranteePersList;
        //担保企业信息
        $scope.applyInputVo.guaranteeCompList  =$scope.guaranteeCompList;
        //上传附件信息
        $scope.applyInputVo.bizFilesList = $scope.fileObj.bizFilesList;
        //购车合理性
        $scope.applyInputVo.rationalityPurchase = $scope.rationalityPurchase;
        //备注
        $scope.applyInputVo.remark = $scope.remark;

        console.log($scope.applyInputVo);
    }

    //提交
    $scope.save = function () {
        $scope.submit = true;
        setApplyInputData();
        if(checkForm() && checkContactAndGuarantee() && checkInputFile()){
            $http.post('change_lessee_task/submitApplyInputVo', $scope.applyInputVo).success(function (data) {
                if (data.code == Response.successCode) {
                    if(!$scope.taskId){
                        $location.path('app/postbiz_basic_change_list').search({"type": 'submit',"msg":'变更承租人申请提交成功'});
                    }else{
                        $location.path('/app/home').search({"type": 'homeToastInfo',"msg":'变更承租人申请提交成功'});
                    }
                    //$location.path('/app/home').search({"type": 'homeToastInfo',"msg":'合同展期申请提交成功'});
                } else {
                    modalAlert($modal, data.message);
                }
            }).error(function (data) {

            });
            $scope.submit = false;
        }else{
            $scope.formValidate = true;
            $scope.submit = false;
        }
    };

    //暂存
    $scope.modify = function(){
        $scope.submit = true;
        setApplyInputData();
        $http.post('change_lessee_task/saveApplyInputVo',$scope.applyInputVo).success(function (data) {
            if (data.code == Response.successCode){
                console.log(data)
                $location.search('serviceId',data.data.applyNo);
                $location.search('taskId',data.data.taskId);
                $scope.taskId = data.data.taskId;
                $scope.applyNo = data.data.applyNo;
                toaster_info('暂存成功!',toaster);
            } else {
                modalAlert($modal,data.message);
            }
            $scope.submit = false;
        }).error(function (data) {
            $scope.submit = false;
        });
    };

    //form表单验证
    function checkForm() {
        if($scope.form.$invalid){
            $scope.remindMsg();
            return false;
        }
        return true;
    }

    //check联系人和担保人信息
    function checkContactAndGuarantee(){
        if($scope.cstmContactList != null && $scope.cstmContactList){
            if($scope.cstmContactList.length==0){
                toaster_info('请输入联系人信息',toaster);
                return false;
            }
        }
        /*if(!($scope.guaranteeCompList.length!=0 || $scope.guaranteePersList.length!=0)){
            modalAlert($modal,'请输入担保信息');
            return false;
        }*/
        return true;
    }

    // check附件上传是否符合条件
    function checkInputFile() {
        if($scope.fileObj.notUpload) {
            toaster_info('附件变更-'+$scope.fileObj.notUploadInfo,toaster);
            return false;
        }
        return true;
    }

    $scope.remindMsg = function () {
        $timeout(function () {
            if($(".form-info:not(.ng-hide)").length > 0){
                $(".form-info:not(.ng-hide)").each(function (i,v) {
                    var title;
                    var text = $(v).text();
                    if($(v).parents("#customer").length>0){
                        var subtext = $(v).parents('.sub-main').find('.pull-left').text();
                        title = "承租人变更-"+subtext;
                    }else if($(v).parents("#change").length>0){
                        title = "变更申请";
                    }else if($(v).parents("#applyVisit").length>0){
                        title = "家访";
                    }
                    toaster_info(title+'-'+text,toaster);
                    return false;
                });
            }else{
                toaster_info(promptInfo.submitWarn,toaster);
            }
        });
    };

    //返回
    $scope.goBack = function () {
        if(!$scope.taskId){
            $location.path('app/postbiz_basic_change_list');
        }else{
            $location.path('/app/home');
        }
    };
}]);


