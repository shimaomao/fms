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

    // 创建用户树
    function initSysGroupTree() {
        $scope.roleMenuHead = {id:'0'.common_parent_id,text:'系统用户'};
        $http.post('sys_user/findAllUsers').success(function(data){
            console.log(data);
            var childNodes = data;
            var child = '';
            var myNode = [];
            for( var i  = 0 ;i< childNodes.length;i++){
                child = childNodes[i];
                var jChild = {id:child.userId,text:child.userName}
                myNode.push(jChild);

            }
            var tree = [

                {
                    id: $scope.roleMenuHead.id,
                    text:$scope.roleMenuHead.text,
                    nodes: myNode

                }
            ];
            $('#sys_user_menu_tree').treeview({
                data: tree,
                onNodeSelected: function(event, data) {

                    $scope.userId = data.id;
                    $scope.userName = data.text;
                    $http.post('sys_menu/findSysMenusByUserId?userId='+ $scope.userId).success(function(data){
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

                        })
                        expandNodes();
                    });
                }
            });
        });
    }
    //展开所有节点
    function expandNodes(){
        $('#menuTree').treeview('expandAll', {  silent: true });
    }
    //设置页面跳转

    $scope.setMenu = function(){
        if($scope.userId==0||typeof($scope.userId)=='undefined')
            modalAlert($modal,'请选择正确的用户');
        else
        $location.path('/app/system_sys_user_menu_set').search({'userId':$scope.userId,'userName': $scope.userName});

    }


}])
;