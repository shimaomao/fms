/**
 * Created by ningyangyang on 2018-03-15.
 */
app.controller('sys_role_menu_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location','$timeout',function ($scope, $http, $modal, toaster,$compile,$location,$timeout) {

    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('分配菜单成功', toaster);
        }
    }, 100);
    // 用户组树信息初始化
    initSysGroupTree();
    // 创建用角色树
    function initSysGroupTree() {
        $scope.roleMenuHead = {id:'0',text:'系统角色'};
        $http.post('sys_role/findAllRoles').success(function(data){
            var childNodes = data;
            var child = '';
                var myNode = [];
                for( var i  = 0 ;i< childNodes.length;i++){
                    child = childNodes[i];
                    var jChild = {id:child.roleId,text:child.roleName}
                    myNode.push(jChild);

                }
            var tree = [

                {
                    id: $scope.roleMenuHead.id,
                    text:$scope.roleMenuHead.text,
                    nodes: myNode

                }
            ];
            $('#sys_role_menu_tree').treeview({
                data: tree,
                onNodeSelected: function(event, data) {
                     $scope.roleId = data.id;
                     $scope.roleName = data.text;

                     $http.post('sys_menu/findSysMenusByRoleId?roleId='+ $scope.roleId).success(function(data){
                         $('#menuTree').treeview({
                             data:data,
                             showCheckbox:false,
                             expandIcon:'glyphicon glyphicon-plus',
                             selectable:true,
                             checkedIcon:'glyphicon glyphicon-ok',
                             emptyIcon:'glyphicon',
                             multiSelect:true,
                             showIcon:true,
                             uncheckedIcon:'glyphicon glyphicon-unchecked',
                             // onNodeExpanded:function () {
                             //     $('#menuTree').treeview('expandAll', {  silent: true });
                             // }

                         })
                         expandNodes();
                     });

                }
            });

        });
    }
    function expandNodes(){
        $('#menuTree').treeview('expandAll', {  silent: true });
    }

    //设置页面跳转

    $scope.setMenu = function(){
        if($scope.roleId==0||typeof($scope.roleId)=='undefined')
            modalAlert($modal,'请选择正确的角色');
        else
            $location.path('/app/system_sys_role_menu_set').search({'roleId':$scope.roleId,'roleName': $scope.roleName});

    }
}])
;