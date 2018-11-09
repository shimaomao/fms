/**
 * Created by wangxue on 2018/4/2.
 */


app.controller('sys_group_modify_controller', ['$scope', '$http','$modal','toaster','$location', function ($scope, $http, $modal, toaster, $location) {

    $scope.sysGroup={};

    $scope.formValidate = false;

    $scope.submit = false;

    // 取得用户组信息
    $http.get('sys_group/findSysGroupVoByGroupId?groupId='+ $location.search()['groupId']).success(function(data){
        $scope.sysGroup = data.data;
        $scope.sysGroup.enableFlagName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,$scope.sysGroup.enableFlag);
    });

    // 启用标识
    $scope.enableFlagList = CommonCodeUtils.getCommonCodes(CommonCodeUtils.codeTypes.enableFlag);

    // 选择用户组层级
    $scope.selectGroupLev = function () {
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_group_level/sys_group_level_list_select.html?datetime='+getTimestamp(),
            controller: 'sys_group_level_list_select_controller',
            resolve:{
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                $scope.sysGroup.groupLev = data.groupLev;
                $scope.sysGroup.groupLevName = data.groupLevName;
            }
        },function(){

        });
    };

    // 选择上级用户组
    $scope.selectGroup = function (index) {
        var parentType = index;
        var rtn = $modal.open({
            backdrop : 'static',
            size:'lg',
            templateUrl: 'tpl/system/sys_group/sys_group_list_select.html?datetime='+getTimestamp(),
            controller: 'sys_group_list_select_controller',
            resolve:{
                parentGroup:function () { return {parentType:index, groupCode: $scope.sysGroup.groupCode}; }
            }
        });
        rtn.result.then(function (data) {
            if(data != null) {
                if (parentType == '1') {
                    $scope.sysGroup.adminParentGroup = data.groupCode;
                    $scope.sysGroup.adminParentGroupName = data.groupName;
                } else if (parentType == '2') {
                    $scope.sysGroup.financeParentGroup = data.groupCode;
                    $scope.sysGroup.financeParentGroupName = data.groupName;
                } else if (parentType == '3') {
                    $scope.sysGroup.sellParentGroup = data.groupCode;
                    $scope.sysGroup.sellParentGroupName = data.groupName;
                } else {
                    $scope.sysGroup.operateParentGroup = data.groupCode;
                    $scope.sysGroup.operateParentGroupName = data.groupName;
                }
            }
        },function(){

        });
    };

    /**
     * 修改组织机构属性信息
     */
    $scope.modify = function () {

        if(!$scope.form.$invalid) {

            $scope.submit = true;
            setGroupParentList();
            $http.put('sys_group/modifySysGroup', $scope.sysGroup).success(function (data) {
                if (data.code == Response.successCode){
                    // toaster_success('编辑用户组信息成功', toaster);
                    $location.path("app/system_sys_group_list").search({type: 'modify'});
                } else {
                    modalAlert($modal,data.message);
                }
                $scope.submit = false;
            }).error(function(data){
                modalAlert($modal,data);
                $scope.submit = false;
            })

        }else{
            $scope.formValidate = true;
            toaster_info(promptInfo.submitWarn,toaster);
        }
    };

    // 将上级用户组信息保存转化为list
    function setGroupParentList() {
        var parentGroupList = [];
        var parentGroup;
        // 行政组织
        if ($scope.sysGroup.adminParentGroup != null && $scope.sysGroup.adminParentGroup != '') {
            parentGroup = {};
            parentGroup.parentGroup = $scope.sysGroup.adminParentGroup;
            parentGroup.parentType = '1';
            parentGroupList.push(parentGroup);
        }
        // 财务组织
        if ($scope.sysGroup.financeParentGroup != null && $scope.sysGroup.financeParentGroup != '') {
            parentGroup = {};
            parentGroup.parentGroup = $scope.sysGroup.financeParentGroup;
            parentGroup.parentType = '2';
            parentGroupList.push(parentGroup);
        }
        // 销售组织
        if ($scope.sysGroup.sellParentGroup != null && $scope.sysGroup.sellParentGroup != '') {
            parentGroup = {};
            parentGroup.parentGroup = $scope.sysGroup.sellParentGroup;
            parentGroup.parentType = '3';
            parentGroupList.push(parentGroup);
        }
        // 运营组织
        if ($scope.sysGroup.operateParentGroup != null && $scope.sysGroup.operateParentGroup != '') {
            parentGroup = {};
            parentGroup.parentGroup = $scope.sysGroup.operateParentGroup;
            parentGroup.parentType = '4';
            parentGroupList.push(parentGroup);
        }
        $scope.sysGroup.sysGroupParentVoList = parentGroupList;
    }

    /**
     * 返回
     * @param status
     */
    $scope.goback = function(status){
        $location.path("app/system_sys_group_list");
    };

}]);