/**
 * Created by qinmuqiao on 2018-09-15.
 */
app.controller('veh_maintain_save_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http,$modal,toaster,$location) {

    $scope.vehMaintain={};
    $scope.vehMaintain.maintainAmount = 0;

    $scope.formValidate = false;

    $scope.submit = false;
    $scope.httpData = true;
    $scope.notUpload = false;

    //附件对象
    $scope.bizFilesList= [];
    /**
     * 保存组织机构属性信息
     */
    $scope.save = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;
            $scope.vehMaintain.maintainFlag = '1';
            $scope.vehMaintain.bizFilesList = $scope.bizFilesList;

            $http.post('veh_maintain/saveVehMaintain', $scope.vehMaintain).success(function (data) {
                if (data.code == Response.successCode)
                    $location.path('app/postbiz_veh_maintain_list').search({type:'save'});
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
     * 选择合同
     * @param status
     */
    $scope.selectCont = function(){
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/prebiz/contract/contract_list_select.html?datetime='+getTimestamp(),
            controller: 'contract_select_controller',
            resolve:{
                selectData: function () {
                    return {}
                }
            }
        });
        rtn.result.then(function (rows) {
            console.log(rows)
            if(rows != null && rows.length>=0) {
                $scope.vehMaintain.vinNo = rows[0].vinNo;
                $scope.vehMaintain.engineNo = rows[0].engineNo;
                $scope.vehMaintain.vehicleLicenseNo = rows[0].vehicleLicenseNo;
            }
        },function(){
        });
    };

    /**
     * 关闭窗口
     * @param status
     */
    $scope.goBack = function(){
        $location.path('/app/postbiz_veh_maintain_list');
    };

}]);


