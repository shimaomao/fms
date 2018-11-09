/**
 * Created by Administrator on 2018/4/26.
 */
app.controller('home_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location',function ($scope, $http, $modal, toaster,$compile,$location) {

    // 从其他画面跳转到主页的弹出信息显示
    $scope.type = $location.search()['type'];
    $scope.msg = $location.search()['msg'];
    if ($scope.type == 'homeToastInfo') {
        toaster_success($scope.msg, toaster);
        $location.search({msg:null,type:null});
    }
    //接受子页面的值
    $scope.$on('approveInfoToFather',function (e,data) {
        $scope.approveInfo = data;
        if(CommonObjectUtils.isExist($scope.approveInfo)){
            $scope.homePageStyle= {
                "width": "49%",
                "float": "right",
                "margin-top": "20px",
                "display": "inline"
            }
        }else{
            $scope.homePageStyle= {
                "width": "100%",
                "float": "left",
                "margin-top": "20px",
                "display": "inline"
            }
        }
    });
    //主页获取常用菜单url
    $http.get('sys_menu_clicks/findSysMenuClicksByUser').success(function (data) {
        if(data.code == Response.successCode){
            $scope.menuUrl = data.data;
        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });

    //新开Tab
    $scope.openNewTab = function (id,url,title) {
        var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
        if(window.parent.addTab){
            window.parent.addTab(html);
        }
    };
}])
;