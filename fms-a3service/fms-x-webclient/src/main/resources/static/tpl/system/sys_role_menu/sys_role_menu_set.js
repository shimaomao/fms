/**
 * Created by ningyangyang on 2018/3/16.
 */
app.controller('sys_role_menu_set_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location',function ($scope, $http, $modal, toaster,$compile,$location) {


    $scope.roleId = $location.search()['roleId'];
    $scope.roleName = $location.search()['roleName'];
    var checkNodes;
    initSysGroupTree();
    var nodeList = [];
    function initSysGroupTree(){
        $http.get('sys_menu/findAllMenusByRoleId?roleId='+$scope.roleId).success(function(data){
            $('#menuTree').treeview({
                data:data,
                showCheckbox:true,
                expandIcon:'glyphicon glyphicon-plus',
                selectable:true,
                checkedIcon:'glyphicon glyphicon-ok',
                emptyIcon:'glyphicon',
                multiSelect:true,
                showIcon:true,
                uncheckedIcon:'glyphicon glyphicon-unchecked',
                onNodeChecked: function (event,data) {
                    var selectNodes = getChildNodeIdArr(data); //获取所有子节点
                    if (selectNodes) { //子节点不为空，则选中所有子节点
                         $('#menuTree').treeview('checkNode', [selectNodes, { silent: true }]);
                    }
                    var parentNode = $("#menuTree").treeview("getNode", data.parentId);
                    setParentNodeCheck(data);
                    nodeList = $('#menuTree').treeview('getChecked');
                },
                onNodeUnchecked: function(event, data){
                    var selectNodes = getChildNodeIdArr(data); //获取所有子节点
                    if (selectNodes) { //子节点不为空，则取消选中所有子节点
                        $('#menuTree').treeview('uncheckNode', [selectNodes, { silent: true }]);
                    }
                    nodeList = $('#menuTree').treeview('getChecked');
                },
            })
            expandNodes();
            nodeList =   $('#menuTree').treeview('getChecked');
        });
    }
    //展开所有节点
    function expandNodes(){
        $('#menuTree').treeview('expandAll', {  silent: true });
    }
    function getChildNodeIdArr(node) {
        var ts = [];
        if (node.nodes) {
            for (var x in node.nodes) {
                ts.push(node.nodes[x].nodeId);
                if (node.nodes[x].nodes) {
                    var getNodeDieDai = getChildNodeIdArr(node.nodes[x]);
                    for (var j in getNodeDieDai) {
                        ts.push(getNodeDieDai[j]);
                    }
                }
            }
        } else {
            ts.push(node.nodeId);
        }
        return ts;
    }

    function setParentNodeCheck(node) {
        var parentNode = $("#menuTree").treeview("getNode", node.parentId);
        if (parentNode.nodes) {
            var checkedCount = 0;
            for (var x in parentNode.nodes) {
                if (parentNode.nodes[x].state.checked) {
                    checkedCount ++;
                } else {
                    break;
                }
            }
            if (checkedCount === parentNode.nodes.length) {
                $("#menuTree").treeview("checkNode", parentNode.nodeId);
                setParentNodeCheck(parentNode);
            }
        }
    }
    //保存
    $scope.saveSysMenu = function(){
         $scope.submit = true;
       $scope.sysRoleMenus = [];
        if(nodeList.length!=0){
        for( var i in nodeList){
            var sysRoleMenu={

                roleId :'',
                menuId:''
            }
            sysRoleMenu.roleId = $scope.roleId;
            sysRoleMenu.menuId = nodeList[i].id;
            $scope.sysRoleMenus.push(sysRoleMenu)

        }

        $http.post("sys_role_menu/updateSysRoleMenuByRoleId",$scope.sysRoleMenus)
            .success(function (data, header, config, status) {
               // modalAlert($modal,'保存菜单成功');
                $location.path('app/system_sys_role_menu_list').search({type:'save'});
            })
            .error(function (data, header, config, status) {
                //console.log(data);
                modalAlert($modal,data);
            });
        }else{
            modalAlert($modal,'您还没有给角色赋菜单');
        }

    }
    /**
     * 页面返回
     */
  $scope.goBack = function () {

      $location.path('app/system_sys_role_menu_list');
  }

}])
;