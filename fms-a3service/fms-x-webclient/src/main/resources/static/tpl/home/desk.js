/**
 * Created by qiaohao on 2018/2/1.
 */
app.controller('desk_controller', ['$scope', '$http', '$modal', 'toaster','$compile','$location','setData', function ($scope, $http, $modal, toaster,$compile,$location,setData) {
    $scope.approveInfo = null;
    $scope.types = [
        {code : "1", name : "30天"},
        {code : "2", name : "本月"},
        {code : "3", name : "当日"}
    ];
    $scope.searchType = $scope.types[0].code;
    var oldSearchType = $scope.types[0].code;
    //主页获取审批模块
    $http.get('sys_role/findApproveInfo?searchType=' + $scope.searchType).success(function (data) {
        if(data.code == Response.successCode){
            $scope.approveInfo = data.data;
            $scope.$emit("approveInfoToFather",$scope.approveInfo);
            console.log($scope.approveInfo);
        }else{
            modalAlert($modal,data.message);
        }
    }).error(function (err) {
        modalAlert($modal,err);
    });



    $scope.refreshData = function (url) {
        if($scope.searchType.code == oldSearchType){
            return;
        } else {
            oldSearchType = $scope.searchType;
            $http.get('sys_role/findApproveInfo?searchType=' + $scope.searchType).success(function (data) {
                if(data.code == Response.successCode){
                    $scope.approveInfo = data.data;
                    $scope.$emit("approveInfoToFather",$scope.approveInfo);
                    console.log($scope.approveInfo);
                }else{
                    modalAlert($modal,data.message);
                }
            }).error(function (err) {
                modalAlert($modal,err);
            });
        }
    }

    //超链接点击跳转 1：累计融资金额、2：申请数、3：累计放款数
    $scope.goDetail = function (type) {
        var url = '';
        var id = '';
        var title = '';
        var now = new Date();
        if($scope.searchType == '1'){
            now.setTime(now.getTime() - 1000 * 60 * 60 * 24 * 30);
            now = getYMD(now);//30天之前
        } else if($scope.searchType == '2'){
            now = getYMD(new Date(new Date().getFullYear(), new Date().getMonth(), 1));//本月1号
        } else if($scope.searchType == '3'){
            now = getYMD(now);//当天
        }
        if(type == '1' || type == '3'){
            id = 4;
            title = '合同一览';
            url = 'app.prebiz_contract_list' + '?validStartTime=' + now;
        } else if(type == '2'){
            id = 1;
            title = '申请一览';
            url = 'app.prebiz_apply_list_search' + '?searchType=' + $scope.searchType
                + '&submitStartTime=' + now;
        }else {
            modalAlert($modal,'跳转失败，请联系管理员');
        }
        var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
        if(window.parent.addTab){
            window.parent.addTab(html);
        }
    }

    //新开Tab
    $scope.openNewTab = function (obj) {
        var url = obj.routerUrl;
        var id = '';
        var title = '';
        var now = new Date();
        if($scope.searchType == '1'){
            now.setTime(now.getTime() - 1000 * 60 * 60 * 24 * 30);
            now = getYMD(now);//30天之前
        } else if($scope.searchType == '2'){
            now = getYMD(new Date(new Date().getFullYear(), new Date().getMonth(), 1));//本月1号
        } else if($scope.searchType == '3'){
            now = getYMD(now);//当天
        }
        if('app.prebiz_apply_list_search' == url){
            id = 1;
            title = '申请一览';
            url = url + '?applyStatus=' + obj.code + '&searchType=' + $scope.searchType
                + '&submitStartTime=' + now;
        } else if('app.orig_file_archive' == url){
            id = 2;
            title = '原件归档';
            url = url + '?origFileStatus=0';
        } else if('app.orig_file_archive_list' == url){
            id = 3;
            title = '归档邮寄与上传';
            url = url + '?origFileStatus=0';
        } else if('app.prebiz_contract_list' == url){
            id = 4;
            title = '合同一览';
            url = url + '?fundStatus=' + obj.code;
        } else {
            modalAlert($modal,'跳转失败，请联系管理员');
        }
        var html = "<a data-id=\""+id+"\" data-url=\""+url+"\" data-title=\""+title+"\"></a>";
        if(window.parent.addTab){
            window.parent.addTab(html);
        }
    };
}])
;