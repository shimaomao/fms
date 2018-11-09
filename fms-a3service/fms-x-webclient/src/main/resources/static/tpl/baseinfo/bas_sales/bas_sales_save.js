/**
 * Created by yanfengbo on 2018-05-03.
 */
app.controller('bas_sales_save_controller', ['$scope', '$http','$modal','toaster','$location','$rootScope', function ($scope, $http,$modal,toaster,$location,$rootScope) {
    $scope.basSales={vehicleForm:''};
    // 店面属性
    $scope.salesTypeList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.salesType);
    // 所属集团
    $scope.withinGroupList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.withinGroup);
    //车辆类型
    $scope.vehicleFormList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.vehicleForm);

    $scope.basSales={};

    $scope.httpData = true;
    $scope.notUpload = false;
    $scope.msgInfo = null;
    $scope.formValidate = false;
    $scope.submit = false;

    //附件对象
    $scope.bizFilesList= [];

    //省份list
    $scope.provinceList=AreaUtils.getAllProvinceList();
    //修改初始化地区
    $scope.cityList ={};
    $scope.areaList={};

    $scope.registerCityList ={};
    $scope.registerAreaList={};
    //经营
    $scope.changeProvince = function() {
        $scope.basSales.addrCity="";
        $scope.basSales.addrCounty="";
        if($scope.basSales.addrProv==undefined||$scope.basSales.addrProv==""){
            $scope.cityList ={};
            $scope.areaList={};
        }else{
            $scope.cityList=AreaUtils.getCityList($scope.basSales.addrProv);
        }
    }
    $scope.changeCity = function() {
        $scope.basSales.addrCounty="";
        if($scope.basSales.addrCity==undefined||$scope.basSales.addrCity==""){
            $scope.areaList={};
        }else{
            $scope.areaList=AreaUtils.getAreaList($scope.basSales.addrCity);
        }

    }

    //注册
    $scope.changeRegisterProv = function() {
        $scope.basSales.registerCity="";
        $scope.basSales.registerCounty="";
        if($scope.basSales.registerProv==undefined||$scope.basSales.registerProv==""){
            $scope.registerCityList ={};
            $scope.registerAreaList={};
        }else{
            $scope.registerCityList=AreaUtils.getCityList($scope.basSales.registerProv);
        }
    }
    $scope.changeRegisterCity = function() {
        $scope.basSales.registerCounty="";
        if($scope.basSales.registerCity==undefined||$scope.basSales.registerCity==""){
            $scope.registerAreaList={};
        }else{
            $scope.registerAreaList=AreaUtils.getAreaList($scope.basSales.registerCity);
        }

    }

    $scope.frameTitle=$location.search()['frameTitle'];
    $scope.showSave=$location.search()['operate']=='save'||false;
    $scope.showUpdate=$location.search()['operate']=='update'||false;
    $scope.showCheck=$location.search()['operate']=='check'||false;


    //选择所属经销商
    $scope.selectPartner = function () {
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
                $scope.basSales.parGroupCode = data.partnerCode;
                $scope.basSales.partnerName = data.partnerName;
            }
        },function(){

        });

    }
    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {
        // 上传附件信息
        $scope.basSales.bizFilesList = $scope.bizFilesList;
        $scope.bas_salestype();
        $scope.correct = true;
        if($scope.basSales.vehicleForm==""){
            $scope.correct = false;

        }
        if(!$scope.form.$invalid&& $scope.correct && !$scope.notUpload) {

            $scope.submit = true;

            $http.post('bas_sales/saveBasSales', $scope.basSales).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path("app/baseinfo_bas_sales_list").search({messageType:'saveBasSales'});
                else
                    modalAlert($modal,data.message);
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
    }

    $scope.bas_salestype=function(){
        //车辆类型
        var carType="";
        $("input[name='vehicleForm']:checked").each(function(){
            carType+=$(this).attr("ng-true-value")+",";
        })
        $scope.basSales.vehicleForm=carType.substring(0,carType.length-1);
    }

    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/baseinfo_bas_sales_list");
    };

}]);


