'use strict';

app.controller('navController', ['$scope', '$localStorage','$filter', '$state', '$window','$location', '$rootScope', function ($scope, $localStorage, $filter, $state, $window, $location, $rootScope) {
    if($localStorage.user == undefined || $localStorage.user == null){
        $state.go("access.signin");
    }


    var resources = $localStorage.user.sysMenus;
    var firstMenu = $filter('filter')(resources, function(data){return data.menuLevel == '2'});
    $scope.menus = [];
    var permissionList = [];
    for(var i in firstMenu){
        $scope.menus.push(getChildren(firstMenu[i]));
    }
    function getChildren(parent){
        parent.children = [];
        var children = $filter('filter')(resources, function(data){return data.parMenuId === parent.menuId});
        if(children.length != 0){
            for(var i in children){
                parent.children.push(getChildren(children[i]));
                permissionList.push(children[i].menuLink);
            }
        }
        return parent;
    }
    $localStorage.permissionList = permissionList;


}])
;