app.controller('risk_credit_person_save_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location', function ($scope, $http, $modal, toaster, $compile, $location) {
    var isCreated = false;
    $scope.applyType = $scope.$parent.applyType;
    $scope.disabled = $scope.$parent.disabled;
    //releation
    //0主贷人 1配偶 2联系人 3个人担保 4企业担保 5共同借款人 6担保人配偶
    var relationList = ['riskPersonVoMain','配偶','联系人','riskPersonVoGuarList','riskCompanyVoGuarList','riskPersonVoBorrList','riskPersonVoGuMateList'];

    //pycreditType
    //1反欺诈分析,2地址核验,3卡核查及交易,4个人银行卡核查,5企业银行卡核查,6驾驶证核查,7企业风险,8企业债务
    var pycreditArr = {
        "1":"pycreditAnti",
        "21":"pycreditAddr",
        "22":"pycreditAddr",
        "3":"",
        "4":"pycreditPersonBkcheck",
        "5":"pycreditCorpBkcheck",
        "6":"pycreditDriver",
        "61":"pycreditDriver",
        "62":"pycreditDriver",
        "63":"pycreditDriver",
        "64":"pycreditDriver",
        "65":"pycreditDriver",
        "7":"pycreditCorpRisk",
        "8":"pycreditCorpDebt"
    };
    var pycreditList = {
        "1":"antiList",
        "21":"addrList",
        "22":"addrList",
        "3":"cardCheckList",
        "4":"personBkchkekList",
        "5":"corpBkcheckList",
        "6":"driverList",
        "61":"driverList",
        "62":"driverList",
        "63":"driverList",
        "64":"driverList",
        "65":"driverList",
        "7":"corpRiskList",
        "8":"corpDebtList"
    };

    $scope.applyNo = $scope.$parent.applyNo;
    $scope.$on('riskDataToSon',function (e,data) {
        $scope.riskData = data;
        $scope.person = data.cstmPerson;
        if(!isCreated){
            $scope.createArr($scope.riskData.pycreditListVoList);
            if($scope.applyType == 2){
                relationList[0] = 'riskCompanyVoMain';
            }
            isCreated = true;
        }
    });

    //数组分组
    $scope.typeName = {
        "61":"驾驶证基本信息核查",
        "62":"驾驶证状态查询",
        "63":"驾驶证准驾车型核查",
        "64":"驾驶证初次领证日期核查",
        "65":"驾驶证档案编号核查",
        "21":"居住地址",
        "22":"单位地址",
    };
    $scope.createArr = function (arr) {
        $scope.antiList = [];
        $scope.addrList = [];
        $scope.cardCheckList = [];
        $scope.personBkchkekList = [];
        $scope.corpBkcheckList = [];
        $scope.driverList = [];
        $scope.corpRiskList = [];
        $scope.corpDebtList = [];
        var length = arr.length;
        for(var i=0;i<length;i++){
            //console.log(arr[i].pycreditType);
            $scope[pycreditList[arr[i].pycreditType]].push(arr[i]);
        }
    };

    //查询/赋值
    $scope.getTableData = function (a) {
        $scope.target = $scope.riskData[relationList[a.relation]];
        var isArr = $scope.target instanceof Array;
        var index,result,length;
        var pycreditName = pycreditArr[a.pycreditType];
        a.actCarUser = $scope.person.actCarUser
        a.driLicenseNo = $scope.person.driLicenseNo
        a.actLicenseNo = $scope.person.actLicenseNo
        $http.post('apply_risk/saveApplyRiskPyCredit',a).success(function (data) {
            if(data.code == Response.successCode){
                console.log(isArr);
                console.log(data);

                result = data.data[pycreditName];

                //当前页面赋值
                a[pycreditName] = result;

                //如果目标是数组，获取下标
                if(isArr){
                    length = $scope.target.length;
                    if(length != 0){
                        for(var i=0;i<length;i++){
                            if(data.data.name == $scope.target[i].name){
                                index = i;
                                break;
                            }
                        }
                    }
                }

                /*征信赋值-START*/
                switch (a.pycreditType*1){
                    //"1","反欺诈分析"
                    case 1:
                        if(isArr){
                            if(length != 0){
                                $scope.target[index].antiResult = result.antiResult;
                                $scope.target[index].phoneAddr = result.areaInfo;
                                $scope.target[index].timeLength = result.timeLength;
                            }
                        }else{
                            $scope.target.antiResult = result.antiResult;
                            $scope.target.phoneAddr = result.areaInfo;
                            $scope.target.timeLength = result.timeLength;
                        }
                        break;
                    //"21","地址核验-居住地址"
                    case 21:
                        if(isArr){
                            if(length != 0){
                                $scope.target[index].resideAddrCheck = result.addrCheck;
                            }
                        }else{
                            $scope.target.resideAddrCheck = result.addrCheck;
                        }
                        break;
                    //"22","地址核验-单位地址"
                    case 22:
                        if(isArr){
                            if(length != 0){
                                $scope.target[index].compAddrCheck = result.addrCheck;
                            }
                        }else{
                            $scope.target.compAddrCheck = result.addrCheck;
                        }
                        break;
                    //"3","卡核查及交易"
                    case 3:
                        if(isArr){
                            if(length != 0){
                                $scope.target[index].resideAddrCheck = result;
                            }
                        }else{
                            $scope.target.resideAddrCheck = result;
                        }
                        break;
                    //"4","个人银行卡核查"
                    case 4:
                        break;
                    //"5","企业银行卡核查"
                    case 5:
                        break;
                    //"6","驾驶证基本信息核查"
                    case 6:
                        if(isArr){
                            if(length != 0){
                                $scope.target[index].driverResult = result.checkResult;
                                //$scope.target[index].driverLicenseStatusDesc = result.driverLicenseStatusDesc;
                            }
                        }else{
                            $scope.target.driverResult = result.checkResult;
                            //$scope.target.driverLicenseStatusDesc = result.driverLicenseStatusDesc;
                        }
                        break;
                    //"7","企业风险"
                    case 7:
                        if(isArr){
                            if(length != 0){
                                $scope.target[index].corpRiskDebt = result.corpRisk;
                            }
                        }else{
                            $scope.target.corpRiskDebt = result.corpRisk;
                        }
                        break;
                    //"8","企业债务"
                    case 8:
                        if(isArr){
                            if(length != 0){
                                $scope.target[index].corpDebt = result.corpDebt;
                            }
                        }else{
                            $scope.target.corpDebt = result.corpDebt;
                        }
                        break;
                }
                /*征信赋值-END*/
                $scope.$emit("creditSuccess",true);
                modalAlert($modal,"查询成功！");
            }else{
                modalAlert($modal,data.message);
            }
        }).error(function (err) {
            modalAlert($modal,err);
        });
    };

    $scope.downloadXml = function (filePath) {
        console.log(filePath)
        if (isNotNullEmpty(filePath))
            CommonFileUtils.downloadFile(filePath);
        else
            modalAlert($modal, "没有报文可以下载");
    };


    //带入到风控报告中的 银行
    $scope.setBankNo = function (a) {
        var dataList = $scope.riskData.accountDetailVoList;
        for(var i=0;i<dataList.length;i++){
            if(dataList[i].name == a.name){
                $scope.riskData.accountDetailVoList[i].accountNo = a.accountNo;
                break;
            }
        }
        $scope.$emit("riskDataToFather",$scope.riskData);
    };
}]);
