/**
 * Created by ningyangyang on 2018/3/16.
 */
app.controller('sys_user_menu_set_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location',function ($scope, $http, $modal, toaster,$compile,$location) {


    $scope.userId = $location.search()['userId'];
    $scope.userName = $location.search()['userName'];
    initSysGroupTree();
    var nodeList = [];
    function initSysGroupTree(){
        $http.get('sys_menu/findAllMenusByUserId?userId='+$scope.userId).success(function(data){
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
        var sysUserMenus = [];
        if(nodeList.length!=0){
        for( var i in nodeList){
            var sysUserMenu={

                userId :'',
                menuId:''
            }
            sysUserMenu.userId = $scope.userId;
            sysUserMenu.menuId = nodeList[i].id;
            sysUserMenus.push(sysUserMenu)

        }

        $http.post("sys_user_menu/updateSysUserMenuByUserId",sysUserMenus)
            .success(function (data, header, config, status) {
                //console.log(data);
              $location.path('app/system_sys_user_menu_list').search({type:'save'});
            })
            .error(function (data, header, config, status) {
                //console.log(data);
                modalAlert($modal,data);
            });
        }else{
            modalAlert($modal,'您还没没有给用户赋菜单');
        }
    }
    /**
     * 页面返回
     */
    $scope.goBack = function () {

        $location.path('app/system_sys_user_menu_list');
    }


}])
;