/**
 * Created by wangxue on 2018/3/12.
 */

app.controller('sys_group_list_select_controller', ['$scope', '$http', '$modal','$modalInstance','parentGroup', function ($scope, $http, $modal, $modalInstance,parentGroup) {

    $scope.groupParent = {id:'', text: ''};
    // 组织类型
    if (isNotUndefinedNull(parentGroup.parentType) && parentGroup.parentType != '') {
        $scope.parentType = parentGroup.parentType;
    } else {
        $scope.parentType = '1'; // 行政组织
    }
    $scope.groupCode = parentGroup.groupCode;
    $scope.parentTypeName = CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.parentType, $scope.parentType);

    // 初始化
    $scope.init = function(){
        // 创建用户组树
        $http.get('sys_group/findSysGroupByTree?parentType=' + $scope.parentType + '&groupCode=' + $scope.groupCode).success(function(data){

            var tree = data.data;
            $('#sys_group_select_tree').treeview({
                data: tree,
                emptyIcon: '',
                onNodeSelected: function (event, data) {
                    $scope.groupParent.groupCode = data.id;
                    $scope.groupParent.groupName = data.text;
                    $scope.confirmTree();
                }
            });
        });
    };

    // 无上级用户组
    $scope.confirm = function(status){
        if (status == 'none') {
            var data = {groupCode: '', groupName:"无上级"};
            $modalInstance.close(data);
        }
    };

    // 确认
    $scope.confirmTree = function(){
        if($scope.groupParent == null) {
            modalAlert($modal,'请选择用户组');
        } else {
            $modalInstance.close($scope.groupParent);
        }
    };


    /**
     * 关闭窗口
     * @param status
     */
    $scope.close = function(){
        $modalInstance.close(null);
    };

}]);
