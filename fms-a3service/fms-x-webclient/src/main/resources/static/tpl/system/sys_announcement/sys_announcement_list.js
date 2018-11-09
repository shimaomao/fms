/**
 * Created by lijunjun on 2018-04-27.
 */
app.controller('sys_announcement_list_controller', ['$scope', '$http', '$modal', 'toaster','$compile', '$location', '$timeout', function ($scope, $http, $modal, toaster,$compile, $location, $timeout) {
    $scope.status = $location.search()['status'];

    // 判断显示message
    $scope.timer = $timeout(function () {
        $scope.type = $location.search()['type'];
        if ($scope.type == 'save') {
            toaster_success('添加公告信息成功', toaster);
        } else if ($scope.type == 'modify') {
            toaster_success('编辑公告信息成功',toaster);
        }
    }, 100);

    //参数配置
    $scope.dataTableProperties= {
        //ajax url 和类型
        dataTableAjax : {
            url : 'sys_announcement/findSysAnnouncementsByPage',
            type:"GET",
        },
        //table的html id
        dataTableId:'sys_announcement_table',
        //table的列
        dataTableColumn: [
            defaultCheckBox('announceId'),
            defaultDetail('announceTitle','detailSysAnnouncement','公告标题','20%',$compile,$scope, 'announceId'),
            {title:'公告内容',data:'announceCotent',width:'20%'},
            {title:'公告日期',data:'announceDate',width:'20%'},
            {title:'公告附件',data:'announceFile',width:'20%'},
            {title:'启用标志',data:'enableFlag',width:'20%',
                render: function (data, type, row, meta) {
                    return CommonCodeUtils.getCodeValueName(CommonCodeUtils.codeTypes.enableFlag,data);
                }
            },
            {title:'更新时间',data:'updateTime',width:'20%'},
            {title:'更新人员',data:'updater',width:'20%'},
        ],
        //列是单选还是多选 CheckBox多选 Radio单选
        dataTableSelectType: CheckBox
    }

    //请求的参数
    function dataTableParams($scope){
        params = {};
        params.announceTitle = $scope.announceTitle;
        params.announceCotent = $scope.announceCotent;
        params.announceDateSearch = $scope.announceDateSearch;
        return params;
    }

    //创建dataTable
    $scope.dataTable = createTable($scope.dataTableProperties,dataTableParams,$scope);

    $scope.searchSysAnnouncement = function(){
        $scope.dataTable.fnDraw(true);
    }

    $scope.resetSysAnnouncement = function(){
        $scope.announceCotent = "";
        $scope.announceDateSearch = "";
        $scope.announceTitle = "";
        $scope.dataTable.fnDraw(true);//刷新
    }

    $scope.saveSysAnnouncement=function () {
        $location.path('/app/system_sys_announcement_save');
    }


    $scope.modifySysAnnouncement = function(announceId){
        var rowsIds =  $scope.dataTable.getRowsIds('announceId');//主键

        if(rowsIds.length < 1)
            modalAlert($modal,'请您选择需要修改的数据！');
        else if(rowsIds.length > 1)
            modalAlert($modal,'只能同时修改一条数据！');
        else{
            $location.path("app/system_sys_announcement_modify").search({'announceId':rowsIds[0]});
        }

    }


    $scope.detailSysAnnouncement = function(announceId){
        $location.path("/app/system_sys_announcement_detail").search({'announceId': announceId, 'status':"fromHome"});
    }

    $scope.deleteSysAnnouncement = function(){
        var rowsIds =  $scope.dataTable.getRowsIds('announceId');
        if(rowsIds.length < 1){
            modalAlert($modal,'请选择要删除的数据');
        }else{

            modalConfirm($modal,function(){
                $http.delete('sys_announcement/deleteSysAnnouncementsByAnnounceIds',getDeleteData(rowsIds)).success(function (data) {
                    if(data.code == Response.successCode) {
                        toaster_success('删除公告信息成功', toaster);
                        $scope.dataTable.fnDraw(true);
                    }
                    else
                        modalAlert($modal,data.message);
                })
            },null,'您确定需要删除吗？')

        }
    }

    $scope.exportExcel = function(){
        CommonServiceType.exportExcel(CommonServiceType.serviceTypes.system,CommonServiceType.excelTypes.one,
            'sys_announcement/findSysAnnouncementsByPage',dataTableParams($scope));
    }

    // 从主页跳转过来显示的返回按钮
    $scope.backHome = function () {
        $location.path("app/home");
    }

    // $scope.testInterface = function () {
    //     debugger;
    //     $scope.sysMenuClicksVo = {};
    //     $scope.sysMenuClicksVo.menuLink = "app/lsdjkflask";
    //     $http.post('sys_menu_clicks/saveSysMenuClicks', $scope.sysMenuClicksVo).success(function (data) {
    //         if (data.code == Response.successCode){
    //             alert("success!")
    //         }else{
    //             modalAlert($modal,data.message);
    //         }
    //         $scope.submit = false;
    //     }).error(function(data){
    //         modalAlert($modal,data);
    //         $scope.submit = false;
    //     })
    // }
}])
;