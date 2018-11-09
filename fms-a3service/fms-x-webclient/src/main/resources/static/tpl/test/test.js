/**
 * Created by liujinge on 2018-03-23.
 */
app.controller('test_controller', ['$scope', '$http', '$modal', 'toaster','$compile', function ($scope, $http, $modal, toaster,$compile) {


    $scope.testInfo = {};
    $scope.productName = "";
    $scope.productId = "";
    $scope.applyNo = "";
    $scope.productVo = {};
    $scope.prodFinItemVoList = [];
    $scope.prodIntrstVoList = [];
    $scope.prodVehicleVopList = [];
    $scope.prodGroupVoList = [];
    $scope.prodFileVoList=[];
    $scope.productVo.product = 'TEST001';
    //融资项目
    $scope.prodFinItemVoList.push({finItem:'f01',finItemType:'1'});
    $scope.prodFinItemVoList.push({finItem:'f02',finItemType:'1'});
    $scope.prodFinItemVoList.push({finItem:'f02',finItemType:'2'});
    //利率
    //利率因子
    for (var index = 0; index < 3; index++) {
        $scope.prodIntrstFactorVoList = [];
        $scope.prodIntrstFactorVoList.push({factorCode:'start'+index,factorValueFrom:'1'});
        $scope.prodIntrstFactorVoList.push({factorCode:'end'+index,factorValueFrom:'2'});
        $scope.prodIntrstVo={};
        $scope.prodIntrstVo.intrstRate= Number(0.5) + Number(index);
        $scope.prodIntrstVo.prodIntrstFactorVoList = $scope.prodIntrstFactorVoList;
        $scope.prodIntrstVoList.push($scope.prodIntrstVo);
    }
    //车辆
    $scope.prodVehicleVopList.push({vehicleCode:'V01'});
    $scope.prodVehicleVopList.push({vehicleCode:'V02'});
    //组织
    $scope.prodGroupVoList.push({groupCode:'G01'});
    $scope.prodGroupVoList.push({groupCode:'G02'});
    //附件
    $scope.prodFileVoList.push({fileType:'F01',showType:'0'});
    $scope.prodFileVoList.push({fileType:'F02',showType:'1'});
    $scope.productVo.prodFinItemVoList = $scope.prodFinItemVoList;
    $scope.productVo.prodIntrstVoList = $scope.prodIntrstVoList;
    $scope.productVo.prodVehicleVopList = $scope.prodVehicleVopList;
    $scope.productVo.prodGroupVoList = $scope.prodGroupVoList;
    $scope.productVo.prodFileVoList = $scope.prodFileVoList;

    $scope.applyApproveVo = {};
    $scope.contInspectVo = {applyNo:'A001'};


    /**
     * 后台测试
     */
    $scope.testrun = function () {
            $scope.submit = true;

            // $http.post('testService/testRum', $scope.test).success(function (result) {
            $http.get('product/findProductsByPage?productName=' + $scope.inputparam).success(function (result) {
                if (result.code == Response.successCode) {
                    toaster_success('成功', toaster);
                } else {
                    modalAlert($modal,result.message);
                }
                $scope.submit = false;
            });
    };
    /**
     * 后台测试
     */
    $scope.testrun1 = function () {
        $scope.submit = true;

        // $http.post('testService/testRum', $scope.test).success(function (result) {
        $http.get('product/findProductVoByProductId?productId=' + $scope.inputparam).success(function (result) {
            if (result.code == Response.successCode) {
                toaster_success('成功', toaster);
            } else {
                modalAlert($modal,result.message);
            }
            $scope.submit = false;
        });
    };

    $scope.testrun2 = function () {
        $scope.submit = true;

        // $http.post('testService/testRum', $scope.test).success(function (result) {
        $http.post('product/saveProduct',$scope.productVo).success(function (result) {
            if (result.code == Response.successCode) {
                toaster_success('成功', toaster);
            } else {
                modalAlert($modal,result.message);
            }
            $scope.submit = false;
        });
    };


    $scope.testrun3 = function () {
        $scope.submit = true;
        $scope.applyApproveVo.applyNo = $scope.inputparam;
        $scope.applyApproveVo.taskId = $scope.inputparam1;
        // $http.post('testService/testRum', $scope.test).success(function (result) {
        $http.post('apply_approve/approval',$scope.applyApproveVo).success(function (result) {
            if (result.code == Response.successCode) {
                toaster_success('成功', toaster);
            } else {
                modalAlert($modal,result.message);
            }
            $scope.submit = false;
        });
    };
    $scope.testrun4 = function () {
        $scope.submit = true;
        $scope.contInspectVo.contNo = $scope.inputparam;
        // $http.post('testService/testRum', $scope.test).success(function (result) {
        $http.post('cont_inspect/approval',$scope.contInspectVo).success(function (result) {
            if (result.code == Response.successCode) {
                toaster_success('成功', toaster);
            } else {
                modalAlert($modal,result.message);
            }
            $scope.submit = false;
        });
    };

}])
;