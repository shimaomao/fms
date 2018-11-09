/**
 * Created by qiaohao on 2018/6/22.
 */
app.controller('apply_dispatch_controller', ['$scope', '$http', '$modal', 'toaster', '$compile', '$location', '$timeout', function ($scope, $http, $modal, toaster, $compile, $location, $timeout) {


    $scope.apply = {};

    $scope.applyDatas = $location.search()['applyDatas'];


    $scope.save = function () {

        if (!$scope.form.$invalid) {

            var applyNos = [];
            for (var i in $scope.applyDatas) {
                applyNos.push($scope.applyDatas[i]['applyNo']);
            }
            if (applyNos.length == 0) {
                modalAlert($modal, "请选择需要派单的订单");
            } else {
                $scope.apply.applyNos = applyNos;
                $http.post('apply/dispatchApply', $scope.apply).success(function (data) {
                    if (data.code == Response.successCode) {
                        $location.path("app/prebiz_apply_dispatch_list").search({messageType:'gpsDispatchInput'});
                    } else {
                        modalAlert($modal, data.message);
                        $scope.submit = false;
                    }
                }).error(function (data) {
                    modalAlert($modal, data);
                    $scope.submit = false;
                })
            }
        } else {
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn, toaster);
        }


    }


    //用户选择
    $scope.selectSysUser = function () {
        var rtn = $modal.open({
            backdrop: 'static',
            size: 'lg',
            templateUrl: 'tpl/system/sys_user/sys_user_list_select.html?datetime=' + getTimestamp(),
            controller: 'sys_user_list_select_controller',
            resolve: {
                sysUserRoleCode: function(){return CommonCodeUtils.roles.riskFirst}
            }
        });
        rtn.result.then(function (data) {
            if (data != null) {
                $scope.apply.approveUser = data.user;
                $scope.apply.approveUserName = data.userName;
            }
        }, function () {

        });
    }

    //返回到主页
    $scope.goBack = function () {
        $location.path("app/prebiz_apply_dispatch_list");
    }

}])
;