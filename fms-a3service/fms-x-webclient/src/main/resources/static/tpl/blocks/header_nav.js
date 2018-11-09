/**
 * Created by qiaohao on 2018/1/22.
 */
'use strict';

app.controller('headerNavController', ['$scope', '$localStorage','$filter', '$state', '$window','$location', '$rootScope','$interval','$http', function ($scope, $localStorage, $filter, $state, $window, $location, $rootScope,$interval,$http) {

    if($localStorage.user == undefined || $localStorage.user == null){
        $state.go("access.signin");
    }

    var resources = $localStorage.user.sysMenus;
    var firstMenu = $filter('filter')(resources, function(data){return data.parMenuId == '0'});
    var firstMenu = firstMenu.sort(compare("orderNo"));
    $scope.menus = [];


    for(var i in firstMenu){
        var colLength = 5;
        var parentMenu = getChildren(firstMenu[i]);
        //功能导航菜单
        if(i == 0){
            //所有二级菜单
            var children = $filter('filter')(resources, function(data){return data.menuLevel == '2'});
            for(var i in children){
                children[i] = getChildren(children[i]);
            }
            parentMenu.children = children;
        }
        parentMenu.children = parentMenu.children.sort(compare("orderNo"));
        parentMenu.twoChildren = [];
        var menuCt = [];
        for(var index = 0 ; index <colLength; index++ ){
            menuCt[index] = {};
            menuCt[index].colno = index;
            menuCt[index].sumCount = 0;
        }

        var minLength = 0;
        for(var j in parentMenu.children){
            // 根据余数计算所属列
            var k = j % colLength ;
            if(isUndefinedNull(parentMenu.twoChildren[k])){
                parentMenu.twoChildren[k] = [];
                parentMenu.twoChildren[k].push(parentMenu.children[j]);
                menuCt[k].sumCount += parentMenu.children[j].children.length+1;
            }else{
                menuCt = menuCt.sort(compare("sumCount"));
                k = menuCt[0].colno ;
                parentMenu.twoChildren[k].push(parentMenu.children[j]);
                menuCt[0].sumCount += parentMenu.children[j].children.length+1;
            }

        }

        // var colLength = 5;
        // var groupLengthKey = 'group';
        // //计算二级菜单总数算出5列每列放入的二级菜单
        // var twoMenuLength = parentMenu.children.length;
        // //每列可以放入多少个二级菜单
        // var twoColLength = 0;
        // //余数
        // var surplus = twoMenuLength % colLength;
        // if(surplus == 0)
        //     twoColLength = twoMenuLength / colLength;
        // else{
        //     if(twoMenuLength < colLength)
        //         twoColLength =  parseInt(twoMenuLength / colLength) + 1;
        //     else
        //         twoColLength = parseInt(twoMenuLength / colLength);
        // }
        //
        // //计算每列应该放入多少内容
        // var groupLength = {};
        // if(twoMenuLength > colLength && surplus != 0 ){
        //     var tmpSurplus = surplus;
        //     for(var index = 0 ; index <colLength; index++ ){
        //         if(tmpSurplus > 0){
        //             groupLength[groupLengthKey+index] = twoColLength + 1;
        //             tmpSurplus -- ;
        //         }else{
        //             groupLength[groupLengthKey+index] = twoColLength ;
        //         }
        //     }
        // }
        //
        // // k 代表  以 5个一组 分组的坐标
        // var k = 0;


        // parentMenu.twoChildren = [];
        //
        // for(var j in parentMenu.children){
        //
        //
        //     if(isUndefinedNull(parentMenu.twoChildren[k]))
        //         parentMenu.twoChildren[k] = [];
        //     parentMenu.twoChildren[k].push(parentMenu.children[j]);
        //
        //     if(groupLength[groupLengthKey+k] == parentMenu.twoChildren[k].length ){
        //         //进入下一组
        //         k ++ ;
        //     }
        //
        // }
        $scope.menus.push(parentMenu);
    }
    function getChildren(parent){
        parent.children = [];
        var children = $filter('filter')(resources, function(data){return data.parMenuId === parent.menuId});
        if(children.length != 0){
            for(var i in children){
                parent.children.push(getChildren(children[i]));
            }
        }
        return parent;
    }

    // 指定排序的比较函数
    function compare(property){
        return function(obj1,obj2){
            var value1 = obj1[property];
            var value2 = obj2[property];
            return Number(value1) - Number(value2);     // 升序
        }
    }

    $scope.userInfo = {};


    $rootScope.userInfoRequestTimer = $interval(function () {
        $scope.userInfoRequest();
    }, 10000);
    $scope.userInfoRequest = function(){
        $http.get('sys_user_info/findSysUserInfoVosByPage?readStatus=' + CommonCodeUtils.userInfoReadStatus.unread).success(function (data) {
            if (data.code == Response.successCode) {
                $scope.userInfo = data.data;
                // console.log($scope.userInfo);
            }
        }).error(function(data){
            console.log(data)
        })
    }

    $scope.userInfoRequest();

    $scope.readerUserInfo = function(info,$event){
        $http.put('sys_user_info/readSysUserInfo',{userInfoId:info.userInfoId}).success(function (data) {
            if (data.code == Response.successCode) {
                $scope.userInfoRequest()
                //$location.path(CommonCodeUtils.taskInfoUrl[info.infoCodeType])
                var taskInfo = CommonCodeUtils.taskInfoUrl[info.infoCodeType].split("-");
                var html = "<a data-id=\""+taskInfo[0]+"\" data-url=\""+taskInfo[1]+"\" data-title=\""+taskInfo[2]+"\"></a>";
                addTab(html);
            } else
                console.log(data.message)
        }).error(function(data){
            console.log(data)
        })
        $event.stopPropagation();
    }

    $scope.menuHeight = iframeHeight+50;
    $(window).resize(function () {
        $scope.menuHeight = iframeHeight+50;
    })

    $scope.$on('ngRepeatFinished',function () {
        $('[data-hover="dropdown"]').dropdownHover();
    })
}])
;